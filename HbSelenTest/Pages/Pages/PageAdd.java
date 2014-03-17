package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BootstrapCore.MyFieldDecorator;
import BootstrapElements.AddOptionsButtons;
import BootstrapElements.BLabel;
import BootstrapElements.BTextbox;
import BootstrapElements.ModalMessage;
import Combobox.Combobox;

public class PageAdd implements IPage {
	@FindBy(className="chzn-container-single")
	List<Combobox> combos;
	@FindBy(id="field-name")
	BTextbox name;
	@FindBy(id="crudForm")
	AddOptionsButtons control;	
	@FindBy(className="modal-message")
	ModalMessage message;
	private final String expectedPageTitle="Out transactions";
	@FindBy(css="h1")
	BLabel actualTitle;
	
	public void init(WebDriver driver){
		PageFactory.initElements(new MyFieldDecorator(driver), this);
	}
	public void setName(String str){
		name.setText(str);
	}
	public String getTitle(){
		return actualTitle.getText();
	}
	public String getName(){
		return name.getText();
	}
	
	public int countCombos(){
		return combos.size();
	}
	public void selectFirstOptionInAllCombos(){
		for (Combobox c: combos){
			c.selectOption(1);
		}
	}
	/*
	 * can causes issue if checkbox already unselected
	 */
	public void uselectAllCombos(){
		for (Combobox c: combos){		
			c.unselect();
		}
	}
	public void saveAndGoBack(){
		control.saveAndGoBackToList();
	}
	public void save(){
		control.save();
	}

	public String getModalMessage(){
		return message.getMessageText();
	}
	public void goToEdit(){
		message.goToEdit();
	}
	public void goToList(){
		message.goToList();
	}
	public String getExpectedPageTitle() {
		return expectedPageTitle;
	}
}
