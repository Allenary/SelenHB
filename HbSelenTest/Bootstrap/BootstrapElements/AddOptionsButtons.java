package BootstrapElements;

import org.openqa.selenium.support.FindBy;

public class AddOptionsButtons extends AbstractContainer{
	@FindBy(className="submit-form")
	private BButton save;
	@FindBy(id="save-and-go-back-button")
	private BButton saveAndGoBack;
	@FindBy(className="return-to-list")
	private BButton cancel;
	
	public void saveAndGoBackToList(){
		saveAndGoBack.click();
	}

}
