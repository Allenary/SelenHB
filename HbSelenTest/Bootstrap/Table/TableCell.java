package Table;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import BootstrapCore.AbstractContainer;

public class TableCell extends AbstractContainer {
	@FindBy(tagName = "div")
	WebElement div;

	// private boolean isAction;

	@Override
	public String getText() {
		if (isAction())
			return "";
		else
			return div.getText();
	}

	public boolean isAction() {
		return div.getAttribute("class").toLowerCase()
				.contains("result-selected");
	}

	public void selectEdit() {
		if (isAction()) {
			div.findElement(By.className("dropdown-toggle")).click();

		}
	}
}
