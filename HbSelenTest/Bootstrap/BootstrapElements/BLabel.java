package BootstrapElements;

import org.openqa.selenium.WebElement;

public class BLabel extends AbstractElement {

	public BLabel(WebElement element) {
		super(element);
	}
	public String getText(){
		return element.getText();
	}
	

}
