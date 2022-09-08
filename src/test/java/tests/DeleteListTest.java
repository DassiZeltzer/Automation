package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.TasksPage;

public class DeleteListTest extends BaseTest{
	
	@Severity(SeverityLevel.NORMAL)
	@Test(description="Delete an existing list")
	public void tc01_deleteNewList() {
		TasksPage tp = new TasksPage(driver);
		tp.addList("Example list");
		tp.clickOnList("Example list");
		tp.deleteList("Example list");
		//Validation
		Assert.assertFalse(tp.isListExist("Example list"));
 	}
}
