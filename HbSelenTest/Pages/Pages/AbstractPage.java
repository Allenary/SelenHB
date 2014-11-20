package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import BootstrapCore.MyFieldDecorator;
import BootstrapElements.BLabel;

public abstract class AbstractPage implements ISitePage {
	@FindBy(css = "h1")
	private BLabel actualTitle;

	public AbstractPage(WebDriver driver) {
		init(driver);
	}

	public String getTitle() {
		return actualTitle.getText();
	}

	public void init(WebDriver driver) {
		driver.get(getURL());
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				String result = (((JavascriptExecutor) driver)
						.executeScript("return jQuery.active==0")).toString();
				return result.equals("true");
			}
		};
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(pageLoadCondition);
		PageFactory.initElements(new MyFieldDecorator(driver), this);
	}
}
