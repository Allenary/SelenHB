package BootstrapElements;

import org.openqa.selenium.WebElement;

import BootstrapCore.AbstractElement;

/*
 * 2014/03/03
 * can be simply "BootstrapButton", not "AbstractButton"
 */
public class BButton extends AbstractElement{

	public BButton(WebElement element) {
		super(element);
	}
	public void click(){
		element.click();
	}
	/* 
	 * 2014/03/03
	 * I'm not sure that all kinds of  buttons 
	 * has the same identifier of enabled/disabled state
	 * But for now it's ok.
	 */
	public boolean isEnabled(){
		boolean isDisabled = element.getAttribute("class").toLowerCase().contains("disabled");
		return !isDisabled;
		
	}
	public boolean smartClick(){
		boolean isClicked=isEnabled();
		if(isClicked){
			click();
		}
		return isClicked;
	}
}
