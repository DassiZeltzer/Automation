package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.TasksPage;

public class CompleteTaskTest extends BaseTest{
	
	@Test (description="Complete a task")
	public void tc01_CompleteTask(){
		TasksPage tp = new TasksPage(driver);
		tp.addList("Dassi");
		tp.clickOnList("Dassi");
		tp.addTask("task 1 - dassi");
		tp.addTask("task 2 - dassi");
		int before = tp.getNumOfTasks();
		tp.completeTask("task 1 - dassi");
		tp.clearCompletedTasksInList("Dassi");
		int after = tp.getNumOfTasks();
		/* Validation - option 1
		Checking that the number of tasks has increased by 1 */
		Assert.assertEquals(before-1, after);
		/* validation - option 2
		Checking if the task does exist */
		Assert.assertFalse(tp.isTaskExist("task 1 - dassi"));		
	}	
}
