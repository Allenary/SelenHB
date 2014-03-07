package BootstrapCore;

import org.openqa.selenium.WebElement;

public interface IContainer extends IElement{
	void init(WebElement element);
	String getText();
}
