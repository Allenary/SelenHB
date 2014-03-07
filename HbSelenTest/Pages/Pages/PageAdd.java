package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BootstrapElements.AddOptionsButtons;
import BootstrapElements.BTextbox;
import BootstrapElements.MyFieldDecorator;
import Combobox.Combobox;

public class PageAdd implements IPage {
	@FindBy(className="chzn-container-single")
	List<Combobox> combos;
	@FindBy(id="field-name")
	BTextbox name;
	@FindBy(id="crudForm")
	AddOptionsButtons control;
	
	public void init(WebDriver driver){
		PageFactory.initElements(new MyFieldDecorator(driver), this);
	}
	public void setName(String str){
		name.setText(str);
	}
	
	public int countCombos(){
		return combos.size();
	}
	public void selectFirstOptionInAllCombos(){
		for (Combobox c: combos){
			c.selectOption(1);
		}
	}
	public void saveAndGoBack(){
		control.saveAndGoBackToList();
	}
}
