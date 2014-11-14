package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import Table.HeaderCell;

public class PagePockets extends AbstractPage {
	// @FindBy(tagName = "thead")
	// private TableHeader header;
	@CacheLookup
	@FindBy(tagName = "th")
	private List<HeaderCell> cells;

	public List<String> getColumnTitles() {
		List<String> titles = new ArrayList<String>();
		for (HeaderCell cell : cells) {
			String title = cell.getValue();
			titles.add(title);
			System.out.println(title);
		}
		// titles.add(cells.get(3).getValue());
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
