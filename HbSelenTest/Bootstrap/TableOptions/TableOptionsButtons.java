package TableOptions;

import org.openqa.selenium.support.FindBy;

import BootstrapElements.AbstractContainer;

public class TableOptionsButtons extends AbstractContainer{
	@FindBy(className="add-anchor")
	private ButtonAdd add;

	public void clickAdd(){
		add.click();
	}

}
