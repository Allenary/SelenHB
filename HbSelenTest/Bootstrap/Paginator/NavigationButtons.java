package Paginator;

import org.openqa.selenium.support.FindBy;

import BootstrapElements.AbstractButton;
import BootstrapElements.AbstractContainer;

public class NavigationButtons extends AbstractContainer{
	@FindBy(className="first-button")
	private AbstractButton first;
	@FindBy(className="last-button")
	private AbstractButton last;
	@FindBy(className="next-button")
	private AbstractButton next;
	@FindBy(className="prev-button")
	private AbstractButton previous;
	
	public boolean last(){
		return last.smartClick();
	}
	public boolean first(){
		return first.smartClick();
	}
	public boolean next(){
		return next.smartClick();
	}
	public boolean previous(){
		return previous.smartClick();
	}
}
