package TestCases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.PageAdd;

public class TestAddOutTransactionPage {
    static PageAdd page;
    static WebDriver w;
    
	@BeforeClass
	public static void initPage(){
		
		w = new FirefoxDriver();
		w.get("http://fortest.resscode.org.ua/hb/outtransactions/add");
		page = new PageAdd();
		page.init(w);
	}
	
	@Test(enabled = true)
	public void verifyTitle() {
		assertEquals("Wrong Title", page.getTitle(), page.getExpectedPageTitle());
	}
	@DataProvider
	private Object[][] getTestData() {
        return new Object[][]{
        		{"qtd1"},
        		{"qtd2"},
        		{"qtd3"},
        		{"qtd4"}
        };
    }
	
	@Test(dataProvider = "getTestData")
	public void saveTransactionWithData(String testValue){
		page.setName(testValue);
		page.selectFirstOptionInAllCombos();
		page.save();
		assertTrue(page.getModalMessage().contains("Your data has been successfully stored into the database"));
		//bad fix, need to think more
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * hmm.. doesn't close browser... something wrong
	 */
	@AfterClass
	public static void postSteps(){
		w.quit();
	}
	
}
