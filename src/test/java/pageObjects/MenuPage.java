package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MenuPage extends BasePage{
	@FindBy(css="#loading")
	private WebElement loading;

	public MenuPage(WebDriver driver) {
		super(driver);
	}
	
	public void waitingForLoading() {
		wait.until(ExpectedConditions.visibilityOf(loading));
		wait.until(ExpectedConditions.invisibilityOf(loading));
	}
}
