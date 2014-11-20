package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import Table.TableHeader;

public class PagePockets extends AbstractPage {
	// @FindBy(tagName = "thead")
	// private TableHeader header;
	@CacheLookup
	@FindBy(tagName = "thead")
	private TableHeader tableHeader;

	public List<String> getColumnTitles() {
		List<String> titles = tableHeader.getColumnTitles();

		return titles;
	}

	public PagePockets(WebDriver driver) {
		super(driver);
	}

	@Override
	public String getExpectedPageTitle() {
		// TODO:
		return null;
	}

	@Override
	public String getURL() {
		return "http://fortest.resscode.org.ua/hb/pockets";
	}

}
