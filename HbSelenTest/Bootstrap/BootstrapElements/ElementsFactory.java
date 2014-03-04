package BootstrapElements;

import java.util.List;

import org.openqa.selenium.WebElement;

public class ElementsFactory implements IElementsFactory{

	@Override
	public <E extends IElement> List<E> create(Class<E> elementClass,
			WebElement element) {
//		Class.forName(elementClass)
		
		return null;
	}

}
