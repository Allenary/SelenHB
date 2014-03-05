package BootstrapElements;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.util.List;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.seleniumhq.jetty7.util.log.Log;


public class MyFieldDecorator extends DefaultFieldDecorator {
	private IElementFactory elementFactory = new ElementFactory();
    private IContainerFactory containerFactory = new ContainerFactory();
    
	public MyFieldDecorator(SearchContext searchContext) {
		super(new DefaultElementLocatorFactory(searchContext));
	}

	@Override
    public Object decorate(final ClassLoader loader, final Field field) {
		
		if (IContainer.class.isAssignableFrom(field.getType())) {
            return decorateContainer(loader, field);
        }
        if (IElement.class.isAssignableFrom(field.getType())) {
            return decorateElement(loader, field);
        }
        if (List.class.isAssignableFrom(field.getType())){
        	return decorateList(loader, field);
        }
        return super.decorate(loader, field);
    }
	@SuppressWarnings("unchecked")
	private List<?> decorateList(ClassLoader loader, Field field) {

		ElementLocator locator = factory.createLocator(field);
		Class<?> clazz = (Class<?>) ((ParameterizedType) field.getGenericType()).
                getActualTypeArguments()[0];
		Log.info("getActualTypeArguments"+((ParameterizedType) field.getGenericType()).getActualTypeArguments()[0]);
		InvocationHandler handler = new LocatingCustomElementListHandler(locator, field);
		List<?> elements =(List<?>) Proxy.newProxyInstance(
						loader, new Class[] {List.class}, handler);
		return elements;

	}

	@SuppressWarnings("unchecked")
	private Object decorateElement(final ClassLoader loader, final Field field) {
        final WebElement wrappedElement = proxyForLocator(loader, createLocator(field));
        return elementFactory.create((Class<? extends IElement>) field.getType(), wrappedElement);
    }

    @SuppressWarnings("unchecked")
	private Object decorateContainer(final ClassLoader loader, final Field field) {
        final WebElement wrappedElement = proxyForLocator(loader, createLocator(field));
        final IContainer container = containerFactory.create((Class<? extends IContainer>) field.getType(), wrappedElement);

        PageFactory.initElements(new MyFieldDecorator(wrappedElement), container);
        return container;
    }
    private ElementLocator createLocator(final Field field) {
        return factory.createLocator(field);
    }
}
