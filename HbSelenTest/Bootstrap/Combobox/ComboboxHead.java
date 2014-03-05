package Combobox;

import org.openqa.selenium.WebElement;
import org.seleniumhq.jetty7.util.log.Log;

import BootstrapElements.AbstractElement;

public class ComboboxHead extends AbstractElement {

	public ComboboxHead(WebElement element)  {
		super(element);
		Log.info("combohead"+element.getText());
	}
	public void open(){
		element.click();
	}
	public String getText(){
		return element.getText();
	}

}
