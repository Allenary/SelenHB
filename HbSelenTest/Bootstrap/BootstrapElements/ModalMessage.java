package BootstrapElements;

import org.openqa.selenium.support.FindBy;

import BootstrapCore.AbstractContainer;

public class ModalMessage extends AbstractContainer{
	@FindBy(tagName="p")
	private BLabel message;
	@FindBy(className="go-to-edit-form")
	private BLink edit;
	@FindBy(partialLinkText="Go back to list")
	private BLink goToList;
	
	public String getMessageText(){
		return message.getText();
	}
	public void goToEdit(){
		edit.click();
	}
	public void goToList(){
		goToList.click();
	}
}
