import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Pages.PageAdd;



public class TestRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver w;
		w = new FirefoxDriver();
		w.get("http://fortest.resscode.org.ua/hb/outtransactions/add");
		PageAdd page = new PageAdd();
		page.init(w);
		
		page.countCombos();
		page.setName("test");
		page.selectFirstOptionInAllCombos();
		page.uselectAllCombos();
		//page.save();
		//Assert.assertTrue(page.getModalMessage().contains("Your data has been successfully stored into the database"));
//		Log.info("message="+page.getModalMessage());
//		page.goToEdit();
//		page.saveAndGoBack();
	}

}
