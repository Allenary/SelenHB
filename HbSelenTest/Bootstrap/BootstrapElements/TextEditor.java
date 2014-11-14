package BootstrapElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TextEditor {
	@FindBy(id = "cke_39")
	private BButton bold;
	// @FindBy(tagName = "iframe")
	// private MyFrame frame;
	private WebDriver driver;

	public TextEditor(WebDriver webDriver) {
		init(webDriver);
	}

	public void init(WebDriver driver) {
		this.driver = driver;
	}

	public void write(String text) {
		makeItBold();
		driver.switchTo().frame(0);
		WebElement el = driver.findElement(By.xpath("//body/p"));
		el.sendKeys(text);
		driver.switchTo().defaultContent();
	}

	public void makeItBold() {
		bold.click();
	}

}
