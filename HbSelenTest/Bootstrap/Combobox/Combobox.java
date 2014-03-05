package Combobox;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import BootstrapElements.AbstractContainer;
import BootstrapElements.AbstractElement;

public class Combobox extends AbstractContainer{
	@FindBy(className="chzn-single")
	private ComboboxHead head;
	@FindBy(className="active-result")
	private List<ComboboxItem> comboItems;
	
	public void selectOption(int number){
		head.open();
		comboItems.get(number).select();
	}
	public int countItems(){
		return comboItems.size();
//		return 0;
	}

}
