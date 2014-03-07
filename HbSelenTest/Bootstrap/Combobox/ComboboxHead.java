package Combobox;

import org.openqa.selenium.WebElement;

import BootstrapCore.AbstractElement;

public class ComboboxHead extends AbstractElement {

	public ComboboxHead(WebElement element)  {
		super(element);
	}
	public void open(){
		element.click();
	}
	public String getText(){
		return element.getText();
	}

}
