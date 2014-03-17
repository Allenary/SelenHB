package TestCases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
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
	@Test
	public void saveTransactionWithData(){
		page.setName("test");
		page.selectFirstOptionInAllCombos();
		page.save();
		assertTrue(page.getModalMessage().contains("Your data has been successfully stored into the database"));
	}

}
