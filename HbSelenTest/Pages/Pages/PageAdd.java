package Pages;

import java.util.List;

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
	@FindBy(className="chzn-container-single")
	List<Combobox> combos;
	
	public void init(WebDriver driver){
		PageFactory.initElements(new MyFieldDecorator(driver), this);
	}
	public void comboOpen(){
		Log.info("text in combo before click: "+combo.getText());
		combo.selectOption(1);
		Log.info("text in combo after click: "+combo.getText());
		Log.info("count items in combo: "+combo.countItems());
	}
	public void countCombos(){
		Log.info("combos count="+combos.size());
	}
	public void selectFirstOptionInAllCombos(){
		Combobox c=combos.get(1);
		Log.info("Combos(1)="+c.getText());
//		for (Combobox c: combos){
//			c.selectOption(1);
//		}
	}
}
