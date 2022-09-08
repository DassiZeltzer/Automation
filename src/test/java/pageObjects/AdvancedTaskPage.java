package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AdvancedTaskPage extends BasePage{
	@FindBy(css="[name='prio']")
	private WebElement priorityList;
	@FindBy(css="#duedate")
	private WebElement dueField;
	@FindBy(css="[name='task'].in500")
	private WebElement taskField;
	@FindBy(css="[name='note'].in500")
	private WebElement noteField;
	@FindBy(css="#edittags")
	private WebElement tagsField;
	@FindBy(css="[value='Save']")
	private WebElement saveButton;
	
	public AdvancedTaskPage(WebDriver driver) {
		super(driver);
	}
	
	public void addAdvancedTask(String Priority, String Due, String Task, String Note, String Tags) {
		Select s = new Select(priorityList);
		s.selectByValue(Priority);
		fillText(dueField, Due);
		fillText(taskField, Task);
		fillText(noteField, Note);
		fillText(tagsField, Tags);
		click(saveButton);
		sleep(1000);
	}
}
