package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.TasksPage;

public class SearchTest extends BaseTest{

	@Test (description="Search exising product")
	public void tc01_searchExisingProduct() {	
		TasksPage tp = new TasksPage(driver);
		tp.Search("First task");
		//Validation
		Assert.assertTrue(tp.isSearchResultsContain("First task"));
	}
	
	@Test (description="Search missing product")
	public void tc02_searchMissingProduct() {
		TasksPage tp = new TasksPage(driver);
		tp.Search("not exist");
		//Validation
		int actual = tp.getNumOfTasks();
		int expected = 0;
		Assert.assertEquals(actual, expected);
	}
}
