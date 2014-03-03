package Combobox;

import org.openqa.selenium.WebElement;

import BootstrapElements.AbstractElement;

public class ComboboxItem extends AbstractElement {

	public ComboboxItem(final WebElement element) {
		super(element);
	}

	public String getValue(){
		return element.getText();
	}
	
	public void select(){
		element.click();
	}
	
}
