package BootstrapCore;

import org.openqa.selenium.WebElement;


public class ElementFactory implements IElementFactory{

	@Override
	public <E extends IElement> E create(Class<E> ElementClass,
			WebElement element) {
		try{
			return ElementClass.getConstructor(WebElement.class).newInstance(element);
			//return findImplementationFor(ElementClass).getDeclaredConstructor(WebElement.class).newInstance(element);
		}
		catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	/*
	 * why I need this?
	 */
	@SuppressWarnings("unchecked")
	private <E extends IElement> Class<? extends E> findImplementationFor(final Class<E> elementClass) {
        try {
            return (Class<? extends E>) Class.forName(elementClass.getName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
