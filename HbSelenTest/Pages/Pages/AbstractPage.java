package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BootstrapCore.MyFieldDecorator;
import BootstrapElements.BLabel;

public abstract class AbstractPage implements ISitePage {
	@FindBy(css = "h1")
	private BLabel actualTitle;

	public String getTitle() {
		return actualTitle.getText();
	}

	public void init(WebDriver driver) {
		driver.get(getURL());
		PageFactory.initElements(new MyFieldDecorator(driver), this);
	}
}
