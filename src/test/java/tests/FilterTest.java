package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AdvancedTaskPage;
import pageObjects.TasksPage;

public class FilterTest extends BaseTest{
	
	 @Test (description="Filter tasks by tag")
	 public void tc01_filterByTag() {
	 	TasksPage tp = new TasksPage(driver);
	 	tp.openAdvancedTask();
	 	AdvancedTaskPage atp = new AdvancedTaskPage(driver);
	 	atp.addAdvancedTask("0", "3/3/2014", "advanced task", "note", "dassi");
	 	tp.filterByTag("dassi");
	 	//Validation
	 	Assert.assertTrue(tp.isFilterResultsContainTag("dassi"));
	 }
}
