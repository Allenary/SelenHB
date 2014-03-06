package Combobox;

import org.openqa.selenium.WebElement;

import BootstrapElements.AbstractElement;

public class ComboboxItem extends AbstractElement {

	public ComboboxItem(final WebElement element) {
		super(element);
	}

	/*
	 * value will returned only in case element is displayed on page
	 */
	public String getValue(){
		return element.getText();
	}
	
	public void select(){
		element.click();
	}
	public boolean isSelected(){
		return element.getAttribute("class").toLowerCase().contains("result-selected");
	}
}
