package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.seleniumhq.jetty7.util.log.Log;

import BootstrapElements.MyFieldDecorator;
import Combobox.Combobox;
import Combobox.ComboboxHead;
import Menu.MenuItem;

public class PageAdd implements IPage {
	@FindBy(id="category_id_field_box")
	Combobox combo;
	
	public void init(WebDriver driver){
		PageFactory.initElements(new MyFieldDecorator(driver), this);
	}
	public void comboOpen(){
		combo.click();
		Log.info("count items in combo: "+combo.countItems());
	}
	

}
