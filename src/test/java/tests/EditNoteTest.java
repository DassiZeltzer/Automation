package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.TasksPage;

public class EditNoteTest extends BaseTest{
	
	@Test (description="Edit note of task")
	public void tc01_editNote() {
		TasksPage tp = new TasksPage(driver);
		tp.addTask("Task dassi");
		tp.editNoteToTask("Task dassi", "Note 1");
	 	//Validation
	 	Assert.assertTrue(tp.isNoteExist("note 1"));
	}
}
