package BootstrapElements;

import org.openqa.selenium.WebElement;

import BootstrapCore.AbstractElement;

public class BTextbox extends AbstractElement{

	public BTextbox(WebElement element) {
		super(element);
	}
	public void setText(String text){
		element.sendKeys(text);
	}
	public String getText(){
		return element.getText();
	}

}
