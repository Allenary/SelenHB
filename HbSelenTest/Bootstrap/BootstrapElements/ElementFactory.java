package BootstrapElements;

import org.openqa.selenium.WebElement;

public class ElementFactory implements IElementFactory{

	public ElementFactory() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public <E extends IElement> E create(Class<E> ElementClass,
			WebElement element) {
		try{
			return findImplementationFor(ElementClass).getDeclaredConstructor(WebElement.class).newInstance(element);
		}
		catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	private <E extends IElement> Class<? extends E> findImplementationFor(final Class<E> elementClass) {
        try {
            return (Class<? extends E>) Class.forName(elementClass.getName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
