package Pages;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BootstrapCore.MyFieldDecorator;
import BootstrapElements.BLabel;
import BootstrapElements.BTextbox;
import BootstrapElements.ModalMessage;
import BootstrapElements.SaveOptionsButtons;
import BootstrapElements.TextEditor;
import Combobox.Combobox;

public class PageAdd implements IPage {
	@FindBy(id = "category_id_field_box")
	private Combobox cathegory;
	@FindBy(id = "pocket_id_input_box")
	private Combobox pocket;
	@FindBy(id = "description_field_box")
	public TextEditor description;

	@FindBy(id = "field-name")
	private BTextbox name;
	@FindBy(id = "crudForm")
	private SaveOptionsButtons control;
	@FindBy(className = "modal-message")
	private ModalMessage message;
	private final String expectedPageTitle = "Out transactions";
	@FindBy(css = "h1")
	private BLabel actualTitle;

	private String url = "http://fortest.resscode.org.ua/hb/outtransactions/add";

	public void init(WebDriver driver) {
		driver.get(url);
		PageFactory.initElements(new MyFieldDecorator(driver), this);
	}

	public void setName(String str) {
		name.setText(str);
	}

	public String getTitle() {
		return actualTitle.getText();
	}

	public String getName() {
		return name.getText();
	}

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

	public String getExpectedPageTitle() {
		return expectedPageTitle;
	}

	public void setData(Map<String, String> testData) throws IOException {
		setName(testData.get("name"));
		cathegory.selectOption(testData.get("cathegory"));
		pocket.selectOption(testData.get("pocket"));

	}
}
