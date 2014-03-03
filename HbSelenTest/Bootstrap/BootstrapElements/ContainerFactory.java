package BootstrapElements;

import org.openqa.selenium.WebElement;

public class ContainerFactory implements IContainerFactory{

	public ContainerFactory() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public <C extends IContainer> C create(Class<C> containerClass,
			WebElement element) {
		C container =  createInstanceOf(containerClass);
		container.init(element);
		return container;
	}
	 private <C extends IContainer> C createInstanceOf(final Class<C> containerClass) {
	        try {
	            return containerClass.newInstance();
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        } 
	    }
}
