package TestCases;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Pages.PageAdd;

public class TestAddOutTransactionPage {
	 PageAdd page;
	
	@Before
	public void initPage(){
		WebDriver w;
		w = new FirefoxDriver();
		w.get("http://fortest.resscode.org.ua/hb/outtransactions/add");
		page = new PageAdd();
		page.init(w);
	}
	@Test
	public void verifyTitle() {
		assertEquals("Wrong Title", page.getTitle(), page.getExpectedPageTitle());
	}

}
