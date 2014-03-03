package Paginator;

import org.openqa.selenium.support.FindBy;
import org.seleniumhq.jetty7.util.log.Log;

import BootstrapElements.AbstractContainer;
import BootstrapElements.BLabel;

/*
 * 2014/03/03
 * TODO
 * issue: values doesn't updated after navigation to the another page of table
 * by clicking "next", "last" and so on
 */
public class RowsInfo extends AbstractContainer{
	@FindBy(id="page-starts-from")
	private BLabel startsFrom;
	@FindBy(id="page-ends-to")
	private BLabel endsTo;
	@FindBy(id="total_items")
	private BLabel totalCount;
	public int firstRowOnPage(){
		return Integer.parseInt(startsFrom.getText());
	}
	public int lastRowOnPage(){
		return Integer.parseInt(endsTo.getText());
	}
	public int totalRowsCount(){
		return Integer.parseInt(totalCount.getText());
	}
}
