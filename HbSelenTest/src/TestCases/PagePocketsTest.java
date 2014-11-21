package TestCases;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Pages.PagePockets;

public class PagePocketsTest {
	static WebDriver w;
	static PagePockets page;

	@BeforeClass
	public static void init() {
		w = new FirefoxDriver();
		page = new PagePockets(w);
	}

	@Test
	public void test() {
		System.out.println("start test");
		List<String> titles = page.getColumnTitles();
		System.out.println(titles);
		List<String> values1 = page.getValuesFromRow(1);
		System.out.println(values1);
	}
}
