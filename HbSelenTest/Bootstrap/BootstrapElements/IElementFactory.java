package BootstrapElements;

import org.openqa.selenium.WebElement;

public interface IElementFactory {
	<E extends IElement> E create(Class<E> ElementClass, WebElement element);

}
