package BootstrapCore;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;



public class MyFieldDecorator extends DefaultFieldDecorator {
	private IElementFactory elementFactory = new ElementFactory();
    private IContainerFactory containerFactory = new ContainerFactory();
    private final static int delay=10;
    
	public MyFieldDecorator(SearchContext searchContext) {
		super(new AjaxElementLocatorFactory(searchContext,delay));
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
		List<IContainer> containers = new ArrayList<IContainer>();
		List<IElement> elements = new ArrayList<IElement>();
		List<WebElement> listElements = proxyForListLocator(loader, createLocator(field));
		if(IContainer.class.isAssignableFrom(clazz)){
			for(WebElement e:listElements){
				containers.add(decorateContainer(loader,e,clazz));
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
		return listElements;

	}
	@SuppressWarnings("unchecked")
	private Object decorateElement(final ClassLoader loader, final Field field) {
        final WebElement wrappedElement = proxyForLocator(loader, createLocator(field));
        return elementFactory.create((Class<? extends IElement>) field.getType(), wrappedElement);
    }

    @SuppressWarnings("unchecked")
	private IContainer decorateContainer(final ClassLoader loader, final WebElement wrappedElement,final Class<?>  clazz ) {
        final IContainer container = containerFactory.create((Class<IContainer>) clazz, wrappedElement);

        PageFactory.initElements(new MyFieldDecorator(wrappedElement), container);
        return container;
    }
    @SuppressWarnings("unchecked")
	private IContainer decorateContainer(final ClassLoader loader, final Field field) {
        final WebElement wrappedElement = proxyForLocator(loader, createLocator(field));
        return decorateContainer(loader,wrappedElement,(Class<? extends IContainer>) field.getType());
    }
    private ElementLocator createLocator(final Field field) {
    	return factory.createLocator(field);
    }
}
