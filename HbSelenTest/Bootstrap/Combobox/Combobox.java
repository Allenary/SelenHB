package Combobox;

import java.util.List;

import org.openqa.selenium.support.FindBy;

import BootstrapCore.AbstractContainer;

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
	}
	@Override
	public String getText(){
		return head.getText();
	}
	/*
	 * this function can be unused in future
	 */
	protected String getOptionsText(){
		String tmp="";
		for(ComboboxItem i:comboItems){
			tmp+=i.getValue()+" ";
		}
		return tmp;
	}
}
