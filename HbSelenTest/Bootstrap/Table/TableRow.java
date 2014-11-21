package Table;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.support.FindBy;

import BootstrapCore.AbstractContainer;

public class TableRow extends AbstractContainer {

	@FindBy(tagName = "td")
	private List<TableCell> cells;

	public List<String> getValues() {
		System.out.println("count cells in row: " + cells.size());
		List<String> values = new ArrayList<String>();
		for (TableCell cell : cells) {
			String text = cell.getText();
			values.add(text);
			System.out.println(text);
		}
		return values;
	}
}
