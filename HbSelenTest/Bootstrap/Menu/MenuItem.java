package Menu;

import org.openqa.selenium.WebElement;

import BootstrapElements.AbstractElement;

public class MenuItem extends AbstractElement{

	public MenuItem(WebElement element) {
		super(element);
	}
	public void select(){
		element.click();
	}

}
