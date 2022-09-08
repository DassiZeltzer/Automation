package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.TasksPage;

public class AddListTest extends BaseTest{
	
	@Test (description="Add new list")
	public void tc01_addNewList() {
		TasksPage tp = new TasksPage(driver);
		tp.addList("New list 5");
		//Validation
		Assert.assertTrue(tp.isListExist("New list 5"));
	}
		
	@Test (description="Add new simple task")
	public void tc02_addNewTasks() {
		TasksPage tp = new TasksPage(driver);
		tp.clickOnList("New list 5");
		tp.addTask("Task 1");
		tp.addTask("Task 2");
		//Validation
		int actual = tp.getNumOfTasks();
		int expected = 2;
		Assert.assertEquals(actual, expected);
	
		tp.deleteList("New list 5");
	}
}
