package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.AdvancedTaskPage;
import pageObjects.TasksPage;

public class AddAdvancedTaskTest extends BaseTest{

	@Severity(SeverityLevel.NORMAL)
	@Test(description="Add new advanced task")
	public void tc01_addNewAdvTask() {
		TasksPage tp = new TasksPage(driver);
		int before = tp.getNumOfTasks();
		tp.openAdvancedTask();
		AdvancedTaskPage atp = new AdvancedTaskPage(driver);
		atp.addAdvancedTask("2", "22/7/2022", "adv task 0", "note 0", "dassi");
		int after = tp.getNumOfTasks();
		/* Validation - option 1
		Checking that the number of tasks has increased by 1 */
		Assert.assertEquals(after, before+1);
		/* validation - option 2
		Checking if the task does exist */
		Assert.assertTrue(tp.isTaskExist("adv task 0"));
	}
	
	@Severity(SeverityLevel.NORMAL)
	@Test(dataProvider="getData", description="Add 4 new advanced tasks")
	public void tc02_addNewAdvTasks(String priority, String due, String task, String note, String tags) {
		TasksPage tp = new TasksPage(driver);
		int before = tp.getNumOfTasks();
		tp.openAdvancedTask();
		AdvancedTaskPage atp = new AdvancedTaskPage(driver);
		atp.addAdvancedTask(priority, due, task, note, tags);
		int after = tp.getNumOfTasks();
    		/* Validation - option 1
    		Checking that the number of tasks has increased by 1 */
		Assert.assertEquals(after, before+1);
		/* validation - option 2 
		Checking if the task does exist */
		Assert.assertTrue(tp.isTaskExist(task));
	}
	
	@DataProvider
	public Object[][] getData(){
		Object[][] myData = {
				{"0", "1/1/2011", "adv task 1", "note 1", "dassi"},
				{"1", "1/2/2012", "adv task 2", "note 2","dan"},
				{"2", "1/3/2013", "adv task 3", "note 3","yonit"},
				{"-1", "1/4/2014", "adv task 4", "note 4","gal"},
		};
		return myData;
	}
}
