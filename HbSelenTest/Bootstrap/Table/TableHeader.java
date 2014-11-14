package Table;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import BootstrapCore.AbstractContainer;

public class TableHeader extends AbstractContainer {
	@CacheLookup
	@FindBy(tagName = "th")
	private List<HeaderCell> cells;

	public List<String> getColumnTitles() {
		List<String> titles = new ArrayList<String>();
		for (HeaderCell cell : cells) {
			titles.add(cell.getValue());
		}
		return titles;
	}
}
