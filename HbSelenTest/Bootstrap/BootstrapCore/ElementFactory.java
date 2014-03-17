package BootstrapCore;

import org.openqa.selenium.WebElement;


public class ElementFactory implements IElementFactory{

	@Override
	public <E extends IElement> E create(Class<E> ElementClass,
			WebElement element) {
		try{
			return ElementClass.getConstructor(WebElement.class).newInstance(element);
		}
		catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
}
