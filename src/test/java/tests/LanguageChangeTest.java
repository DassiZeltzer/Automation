package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.SettingsPage;
import pageObjects.TasksPage;

public class LanguageChangeTest extends BaseTest{
	
	@Test (description="Change the website language to French")
	public void tc01_FrenchLanguageChange() {
	 	TasksPage tp = new TasksPage(driver);
		tp.goToSettings();
		SettingsPage sp = new SettingsPage(driver);
		sp.chooseLanguage("fr");
	 	//Validation option 1
		Assert.assertTrue(tp.isLanguageChanged("Configuration"));
		//Validation option 2
		String actual = tp.getSettingsText();
		String expected = "Configuration";
		Assert.assertEquals(actual, expected);
	 }
	   
	@Test (description="Change the website language to danish")
	public void tc02_danishLanguageChange() {
		TasksPage tp = new TasksPage(driver);
		tp.goToSettings();
		SettingsPage sp = new SettingsPage(driver);
		sp.chooseLanguage("da");	
		//Validation option 1
		Assert.assertTrue(tp.isLanguageChanged("Indstillinger"));
		//Validation option 2
		String actual = tp.getSettingsText();
		String expected = "Indstillinger";
		Assert.assertEquals(actual, expected);
	}
}
