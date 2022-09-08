package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.TasksPage;

public class DeleteTaskTest extends BaseTest{
	
	@Test (description="Delete an existing task")
	public void tc01_deleteTask() {
		TasksPage tp = new TasksPage(driver);
		tp.addTask("Null 1");
		tp.deleteTask("Null 1");
		//Validation
	 	Assert.assertFalse(tp.isTaskExist("Null 1"));
	}
}
