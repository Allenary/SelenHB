package Pages;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import BootstrapElements.BTextbox;
import BootstrapElements.TextEditor;
import Combobox.Combobox;

public class PageAddOutTransaction extends PageAdd {

	@FindBy(id = "category_id_field_box")
	private Combobox cathegory;
	@FindBy(id = "pocket_id_input_box")
	private Combobox pocket;
	@FindBy(id = "description_field_box")
	public TextEditor description;

	@FindBy(id = "field-name")
	private BTextbox name;

	public PageAddOutTransaction(WebDriver driver) {
		super(driver);
	}

	public void setName(String str) {
		name.setText(str);
	}

	public String getName() {
		return name.getText();
	}

	@Override
	public String getExpectedPageTitle() {
		return "Out transactions";
	}

	@Override
	public String getURL() {
		return "http://fortest.resscode.org.ua/hb/outtransactions/add";
	}

	@Override
	public void setData(Map<String, String> testData) {
		setName(testData.get("name"));
		try {
			cathegory.selectOption(testData.get("cathegory"));
			pocket.selectOption(testData.get("pocket"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
