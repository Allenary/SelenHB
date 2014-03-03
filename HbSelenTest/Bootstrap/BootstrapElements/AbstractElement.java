package BootstrapElements;

import org.openqa.selenium.WebElement;
import org.seleniumhq.jetty7.util.log.Log;

public abstract class AbstractElement implements IElement{
	protected final WebElement element;
	public AbstractElement(WebElement element) {
		this.element = element;
		Log.info(this.getClass().getName()+": "+element.getText());
	}
	@Override
	public boolean isDisplayed(){
		return element.isDisplayed();
	}
}
