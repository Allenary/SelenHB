package Table;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import BootstrapCore.AbstractElement;

public class HeaderCell extends AbstractElement {

	public HeaderCell(final WebElement element) {
		super(element);
	}

	public boolean isSortable() {
		return !element.getAttribute("class").toLowerCase()
				.contains("no-sorter");
	}

	public String getValue() {
		if (isSortable()) {
			WebElement el = element.findElement(By.tagName("div"));

			System.out.println(el);
			return el.getText();
		}
		return element.getText();
	}
}
