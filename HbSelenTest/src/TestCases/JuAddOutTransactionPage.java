package TestCases;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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
	@Test
	public void test() {
		
		page.setName("aa");
		page.selectFirstOptionInAllCombos();
		page.save();
		assertTrue(page.getModalMessage().contains("Your data has been successfully stored into the database"));
		
	}

}
