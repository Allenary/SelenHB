package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import BootstrapCore.MyFieldDecorator;

public class DescriptionIFrame implements IFrame {

	@Override
	public void init(WebDriver driver) {
		driver.switchTo().frame(0);
		PageFactory.initElements(new MyFieldDecorator(driver), this);

	}

}
