package TestCases;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Combobox.Combobox;
import Pages.PageAdd;


public class JuAddOutTransactionPage {
	static WebDriver w;
	static PageAdd page;
	

	@BeforeClass
	public static void init(){
		w = new FirefoxDriver();
		page = new PageAdd();
		page.init(w);
	}
	@Ignore
	@Test
	public void test() {
		Map<String, String> testData = new HashMap<String,String>();
		testData.put("name", "pizza");
		page.setData(testData);
		page.save();
		assertTrue(page.getModalMessage().contains("Your data has been successfully stored into the database"));
	}
	@Test
	public void selectOptionTest() throws IOException{
		Combobox cmbCathegory = page.combos.get(0);
		cmbCathegory.selectOption("Автомобиль");
	}

}
