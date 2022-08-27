package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SettingsPage extends BasePage{
	@FindBy(css="[name='lang']")
	private WebElement LanguagesList;
	@FindBy(css="#settings_form [type='submit']")
	private WebElement SubmitChangesButton;

	public SettingsPage(WebDriver driver) {
		super(driver);
	}
	
	public void chooseLanguage(String Language) {
		Select s = new Select(LanguagesList);
		s.selectByValue(Language);
		click(SubmitChangesButton);
		sleep(3000);
	}
	



}
