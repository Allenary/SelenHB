package TableOptions;

import org.openqa.selenium.support.FindBy;

import BootstrapElements.AbstractContainer;
import BootstrapElements.BButton;

public class TableOptionsButtons extends AbstractContainer{
	@FindBy(className="add-anchor")
	private BButton add;

	public void clickAdd(){
		add.click();
	}

}
