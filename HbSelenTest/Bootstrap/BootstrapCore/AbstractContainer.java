package BootstrapCore;

import org.openqa.selenium.WebElement;


public  class AbstractContainer implements IContainer {
	private WebElement element;
	
	public AbstractContainer(){
		
	}
	public AbstractContainer(WebElement element){
		init(element);
	}
	@Override
	public boolean isDisplayed() {
		 return element.isDisplayed();
	}
	@Override
	public void init(WebElement element) {
		this.element=element;
	}
	@Override
	public String getText() {
		return element.getText();
	}
	
}
