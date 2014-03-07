package BootstrapElements;

import org.openqa.selenium.WebElement;

import BootstrapCore.AbstractElement;

public class BLink extends AbstractElement {

	public BLink(WebElement element) {
		super(element);
	}
	public void click(){
		element.click();
	}

}
