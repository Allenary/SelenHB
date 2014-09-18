package BootstrapElements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import BootstrapCore.AbstractContainer;

public class MyFrame extends AbstractContainer {
	@FindBy(tagName = "p")
	private WebElement text;

	public void writeText(String text) {
		System.out.println("frame initialized");
		System.out.println(this.text.getTagName());
		this.text.sendKeys(text);
	}

}
