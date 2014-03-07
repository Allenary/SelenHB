package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BootstrapCore.MyFieldDecorator;
import BootstrapElements.AddOptionsButtons;
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
	ModalMessage message;
	//needed for finding element after element load..
	private WebDriver driver;
	
	public void init(WebDriver driver){
		//adding driver looks like hack
		this.driver=driver;
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
	public void save(){
		control.save();
	}
	//all crap in this class happens because of this:
	public String getModalMessage(){
		WebElement elem = (new WebDriverWait(driver,60))
				.until(ExpectedConditions.presenceOfElementLocated(By.className("modal-message")));
		message.init(elem);
		return message.getMessageText();
	}
}
