package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.TasksPage;

public class AddSimpleTaskTest extends BaseTest{
	
	@Severity(SeverityLevel.NORMAL)
 	@Test (description="Add new simple task")
	public void tc01_addNewSimpleTask() {
		TasksPage tp = new TasksPage(driver);
		tp.addTask("First task added");
		/* validation
		Checking if the task does exist */
		Assert.assertTrue(tp.isTaskExist("First task added"));
	}
	
	@Severity(SeverityLevel.NORMAL)
 	@Test (dataProvider="getData", description="Add 3 new simple task")
	public void tc02_addNewSimpleTasks(String taskName) {
		TasksPage tp = new TasksPage(driver);
		tp.addTask(taskName);
		/* validation
		Checking if the task does exist */
		Assert.assertTrue(tp.isTaskExist(taskName));
	}
    
	@DataProvider
	public Object[][] getData(){
		Object[][] myData = {
				{"task 1 added"},
				{"task 2 added"},
				{"task 3 added"},
		};
		return myData;
	}
}
