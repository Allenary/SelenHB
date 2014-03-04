package BootstrapElements;

import java.util.List;

import org.openqa.selenium.WebElement;

public interface IElementsFactory {
	<E extends IElement> List<E> create(Class<E> ElementClass, WebElement element);
}
