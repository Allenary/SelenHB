package BootstrapElements;

import org.openqa.selenium.WebElement;

public class WrapperFactory {
	/**
     * —оздает экземпл€р класса,
     * реализующий IElement интерфейс,
     * вызыва€ конструктор с аргументом WebElement
     */
    public static IElement createInstance(Class<IElement> clazz, 
                                        WebElement element) {
        try {
            return clazz.getConstructor(WebElement.class).
                                    newInstance(element);
        } catch (Exception e) {
            throw new AssertionError(
                        "WebElement can't be represented as " + clazz
                        );
        } 
    }
}
