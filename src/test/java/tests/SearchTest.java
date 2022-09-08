package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.TasksPage;

public class SearchTest extends BaseTest{

	@Severity(SeverityLevel.NORMAL)
	@Test (description="Search exising task")
	public void tc01_searchExisingTask() {	
		TasksPage tp = new TasksPage(driver);
		tp.Search("First task");
		//Validation
		Assert.assertTrue(tp.isSearchResultsContain("First task"));
	}
	
	@Severity(SeverityLevel.NORMAL)
	@Test (description="Search missing task")
	public void tc02_searchMissingTask() {
		TasksPage tp = new TasksPage(driver);
		tp.Search("not exist");
		//Validation
		int actual = tp.getNumOfTasks();
		int expected = 0;
		Assert.assertEquals(actual, expected);
	}
}
