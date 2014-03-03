package BootstrapElements;

import org.openqa.selenium.WebElement;

public interface IContainerFactory {
	<C extends IContainer> C create(Class<C> containerClass, WebElement element);
}
