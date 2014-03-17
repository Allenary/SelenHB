package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BootstrapCore.MyFieldDecorator;
import Paginator.NavigationButtons;
import Paginator.RowsInfo;
import TableOptions.TableOptionsButtons;

public class PageTable implements IPage {
	@FindBy(id="options-content")
	TableOptionsButtons options;
	@FindBy(className="pager")
	NavigationButtons nav;
	@FindBy(className="pPageStat")
	RowsInfo rowsInfo;
	
	@Override
	public void init(WebDriver driver) {
		PageFactory.initElements(new MyFieldDecorator(driver), this);
	}
	public void addNewRow(){
		options.clickAdd();
	}
	public void lastPageTable(){
		nav.last();
	}
	public String getAllRowsStat(){
		return "First row index: "+rowsInfo.firstRowOnPage()+
			" Last row index: "+rowsInfo.lastRowOnPage()+
			" Total count: "+rowsInfo.totalRowsCount();
	}

}
