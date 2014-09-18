package TestCases;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import Pages.PageAdd;

public class JuAddOutTransactionPage {
	static WebDriver w;
	static PageAdd page;

	@BeforeClass
	public static void init() {
		w = new FirefoxDriver();
		page = new PageAdd();
		page.init(w);
	}

	@Ignore
	@Test
	public void test() throws IOException {
		Map<String, String> testData = new HashMap<String, String>();
		testData.put("name", "pizza");
		testData.put("cathegory", "Продукты");
		testData.put("pocket", "Еда");

		page.setData(testData);
		page.save();
		assertTrue(page.getModalMessage().contains(
				"Your data has been successfully stored into the database"));
	}

	@Test
	public void addDescriptionTest() {
		w.switchTo().defaultContent();
		w.findElement(By.id("description_field_box"));
		w.findElement(By.id("cke_39")).click();

		w.switchTo().frame(0);
		WebElement el = w.findElement(By.xpath("//body/p"));
		el.sendKeys("aa");
		w.switchTo().defaultContent();
	}
}
