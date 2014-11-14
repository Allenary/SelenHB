package Pages;

import org.openqa.selenium.support.FindBy;

import Paginator.NavigationButtons;
import Paginator.RowsInfo;
import TableOptions.TableOptionsButtons;

public abstract class PageTable extends AbstractPage {
	@FindBy(id = "options-content")
	TableOptionsButtons options;
	@FindBy(className = "pager")
	NavigationButtons nav;
	@FindBy(className = "pPageStat")
	RowsInfo rowsInfo;

	public void addNewRow() {
		options.clickAdd();
	}

	public void lastPageTable() {
		nav.last();
	}

	public String getAllRowsStat() {
		return "First row index: " + rowsInfo.firstRowOnPage()
				+ " Last row index: " + rowsInfo.lastRowOnPage()
				+ " Total count: " + rowsInfo.totalRowsCount();
	}

}
