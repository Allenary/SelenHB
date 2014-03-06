package BootstrapElements;

import java.util.logging.Logger;

import org.openqa.selenium.WebElement;
import org.seleniumhq.jetty7.util.log.Log;

public  class AbstractContainer implements IContainer {
	private WebElement element;
	
	
	@Override
	public boolean isDisplayed() {
		 return element.isDisplayed();
	}
	@Override
	public void init(WebElement element) {
		this.element=element;
//		Log.info(this.getClass().getName()+": "+element.getText());
	}
	@Override
	public String getText() {
		return element.getText();
	}
	
}
