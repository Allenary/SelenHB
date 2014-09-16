package Combobox;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import BootstrapCore.AbstractContainer;

public class Combobox extends AbstractContainer{
	@FindBy(className="chzn-single")
	private ComboboxHead head;
	@FindBy(className="active-result")
	private List<ComboboxItem> comboItems;
	@FindBy(className="search-choice-close")
	private List<WebElement> unselect;
//	private List<WebElement> unselect;
	
	public boolean isSelected(){
//		try{
//			return unselect.isDisplayed();
//		}catch(Exception e){
//			return false;
//		}
//		return (unselect.size()==0);
		for(ComboboxItem ci:comboItems){
			if(ci.isSelected()) return true;
		}
		return false;
	}
	
	public String getSelectedValue(){
		String result="";
		for (ComboboxItem ci: comboItems){
			if (ci.isSelected()){
				result=ci.getValue();
			}
		}
		return result;
	}
	public void selectOption(int number){
		head.open();
		comboItems.get(number).select();
	}
	public void selectOption(String name) throws IOException{
		head.open();
		for(ComboboxItem ci: comboItems){
			if(ci.getValue().equals(name)){
				ci.select();
				return;
			}
		}
		throw new IOException("No such option found: "+name);
	}
	
	public int countItems(){
		return comboItems.size();
	}
	@Override
	public String getText(){
		return head.getText();
	}
	
	public void unselect(){
		unselect.get(0).click();
	}
	/*
	 * this function can be unused in future
	 */
	public String getOptionsText(){
		String tmp="";
		for(ComboboxItem i:comboItems){
			tmp+=i.getValue()+" ";
		}
		return tmp;
	}
}
