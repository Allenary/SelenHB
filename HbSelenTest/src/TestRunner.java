import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.seleniumhq.jetty7.util.log.Log;

import Pages.PageAdd;
import Pages.PageTable;


public class TestRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver w;
		w = new FirefoxDriver();
		w.get("http://fortest.resscode.org.ua/hb/outtransactions/add");
		PageAdd page = new PageAdd();
		page.init(w);
		
		page.comboOpen();
		page.countCombos();
		page.selectFirstOptionInAllCombos();
	}

}
