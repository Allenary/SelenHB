package BootstrapElements;

import org.openqa.selenium.support.FindBy;

import BootstrapCore.AbstractContainer;

public class TextEditor extends AbstractContainer {
	@FindBy(id = "cke_39")
	private BButton bold;
	@FindBy(tagName = "iframe")
	private MyFrame frame;

	public void write(String text) {
		System.out.println("texteditor initialized");
		frame.writeText(text);
	}

	public void makeItBold() {
		bold.click();
	}

}
