package Paginator;

import org.openqa.selenium.support.FindBy;

import BootstrapElements.BButton;
import BootstrapElements.AbstractContainer;

public class NavigationButtons extends AbstractContainer{
	@FindBy(className="first-button")
	private BButton first;
	@FindBy(className="last-button")
	private BButton last;
	@FindBy(className="next-button")
	private BButton next;
	@FindBy(className="prev-button")
	private BButton previous;
	
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
