package Combobox;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import BootstrapElements.AbstractContainer;

public class Combobox extends AbstractContainer{
	@FindBy(className="chzn-single")
	private ComboboxHead head;
	@FindBy(className="active-result")
	private List<WebElement> items;
	
	public void click(){
		head.open();
		
	}
	public int countItems(){
		return items.size();
	}

}
