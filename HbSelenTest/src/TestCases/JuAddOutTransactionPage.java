package TestCases;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Pages.PageAdd;

@RunWith(Parameterized.class)
public class JuAddOutTransactionPage {
	static WebDriver w;
	static PageAdd page;
	private String testData;
	
	public JuAddOutTransactionPage(String testData){
		this.testData=testData;
	}
	@Parameters
	public static Collection<Object[]> data() {
        return  Arrays.asList(new Object[][]{
        		{"qtd1"},
        		{"qtd2"},
        		{"qtd3"},
        		{"qtd4"}
        });
    }
	@BeforeClass
	public static void init(){
		w = new FirefoxDriver();
		w.get("http://fortest.resscode.org.ua/hb/outtransactions/add");
		page = new PageAdd();
		page.init(w);
	}
	@Test
	public void test() {
		page.setName(testData);
		page.selectFirstOptionInAllCombos();
		page.save();
		assertTrue(page.getModalMessage().contains("Your data has been successfully stored into the database"));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
