package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.TasksPage;

public class SelectListTest extends BaseTest{
	
	@Test (dataProvider="getData")
	public void tc01_addNewLists(String list) {
		TasksPage tp = new TasksPage(driver);
		tp.addList(list);
		//Validation
		Assert.assertTrue(tp.isListExist(list));
	}
	
	
	 @Test (dataProvider="getData")
	 public void tc02_selectLists(String list) {
		TasksPage tp = new TasksPage(driver);
		tp.selectList(list);
		//Validation
		String actual = tp.getListText();
		String expected = list;
		Assert.assertEquals(actual, expected);		 	
	 }

	 
	@DataProvider
	public Object[][] getData(){
		Object[][] myData = {
				{"New list 1"},
				{"New list 2"},
				{"New list 3"},
		};
		return myData;
	}
}
