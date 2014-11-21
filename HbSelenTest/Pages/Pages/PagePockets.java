package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import Table.TableHeader;
import Table.TableRow;

public class PagePockets extends AbstractPage {
	@CacheLookup
	@FindBy(tagName = "thead")
	private TableHeader tableHeader;

	@FindBy(tagName = "tr")
	private List<TableRow> rows;

	// private List<TableRow> rows;

	public PagePockets(WebDriver driver) {
		super(driver);
	}

	public List<String> getColumnTitles() {
		List<String> titles = tableHeader.getColumnTitles();
		return titles;
	}

	public List<String> getValuesFromRow(int rowNumber) {
		// return row.getValues();
		System.out.println("rows count" + rows.size());
		return rows.get(rowNumber).getValues();
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
