package Pages;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import BootstrapElements.ModalMessage;
import BootstrapElements.SaveOptionsButtons;

public abstract class PageAdd extends AbstractPage {
	public PageAdd(WebDriver driver) {
		super(driver);
	}

	@FindBy(className = "modal-message")
	private ModalMessage message;
	@FindBy(id = "crudForm")
	private SaveOptionsButtons control;

	public void saveAndGoBack() {
		control.saveAndGoBackToList();
	}

	public void save() {
		control.save();
	}

	public String getModalMessage() {
		return message.getMessageText();
	}

	public void goToEdit() {
		message.goToEdit();
	}

	public void goToList() {
		message.goToList();
	}

	public abstract void setData(Map<String, String> testData);

}
