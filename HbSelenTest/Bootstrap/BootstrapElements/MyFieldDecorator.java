package BootstrapElements;

import java.lang.reflect.Field;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;

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
        return super.decorate(loader, field);
    }
	private Object decorateElement(final ClassLoader loader, final Field field) {
        final WebElement wrappedElement = proxyForLocator(loader, createLocator(field));
        return elementFactory.create((Class<? extends IElement>) field.getType(), wrappedElement);
    }

    private ElementLocator createLocator(final Field field) {
        return factory.createLocator(field);
    }

    private Object decorateContainer(final ClassLoader loader, final Field field) {
        final WebElement wrappedElement = proxyForLocator(loader, createLocator(field));
        final IContainer container = containerFactory.create((Class<? extends IContainer>) field.getType(), wrappedElement);

        PageFactory.initElements(new MyFieldDecorator(wrappedElement), container);
        return container;
    }
}
