package BootstrapElements;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.seleniumhq.jetty7.util.log.Log;

import Combobox.Combobox;


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

		Class<?> clazz = (Class<?>) ((ParameterizedType) field.getGenericType()).
                getActualTypeArguments()[0];
		Log.info("getActualTypeArguments"+clazz);
//		InvocationHandler handler = new LocatingCustomElementListHandler(locator, field);
		List<IContainer> containers = new ArrayList<IContainer>();
		List<IElement> elements = new ArrayList<IElement>();
		List<WebElement> listElements = proxyForListLocator(loader, createLocator(field));
		if(IContainer.class.isAssignableFrom(clazz)){
			for(WebElement e:listElements){
				Log.info("WebElement: "+e.getText());
				IContainer cont=containerFactory.create((Class<? extends IContainer>)((ParameterizedType) field.getGenericType()).
		                getActualTypeArguments()[0], e);
				Log.info("container: "+((Combobox)cont).getText());
				containers.add(cont);
				PageFactory.initElements(new MyFieldDecorator(e), cont);
			}
			return containers;
		}
		if(IElement.class.isAssignableFrom(clazz)){
			for(WebElement e:listElements){
				elements.add(elementFactory.create((Class<? extends IElement>)((ParameterizedType) field.getGenericType()).
                getActualTypeArguments()[0], e));
			}
			return elements;
		}
		return null;

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
