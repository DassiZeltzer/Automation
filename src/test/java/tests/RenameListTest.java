package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.TasksPage;

public class RenameListTest extends BaseTest{
	
	@Severity(SeverityLevel.NORMAL)
	@Test (description="Rename list")
	public void tc01_renameList() {
	 	TasksPage tp = new TasksPage(driver);
	 	tp.addList("List2");
	 	tp.clickOnList("List2");
	 	tp.renameList("List2", "List renamed1");
	 	tp.renameList("List renamed2");
	 	//Validation
	 	Assert.assertTrue(tp.isListExist("List renamed2"));
	}
}
