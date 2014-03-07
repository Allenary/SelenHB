package BootstrapCore;

import org.openqa.selenium.WebElement;


public abstract class AbstractElement implements IElement{
	protected final WebElement element;
	public AbstractElement(WebElement element) {
		this.element = element;
	}
	@Override
	public boolean isDisplayed(){
		return element.isDisplayed();
	}
}
