package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class TasksPage extends MenuPage{
	@FindBy(css="#task")
	private WebElement taskField;
	@FindBy(css="#newtask_submit")
	private WebElement addButton;
	@FindBy(css="#newtask_adv>span")
	private WebElement advancedButton;	
	@FindBy(css="#search")
	private WebElement searcField;
	@FindBy(css=".tab-height-wrapper>span")
	private WebElement newListButton;
	@FindBy(css="#total")
	private WebElement total;
	@FindBy(css="#lists li span")
	private List<WebElement> lists;
	@FindBy(css=".task-title")
	private List<WebElement> tasks;
	@FindBy(css=".taskactionbtn")
	private List<WebElement> taskMenu;
	@FindBy(css="#cmenu_delete")
	private WebElement menuDelete;
	@FindBy(css="#btnRenameList")
	private WebElement renameList;
	@FindBy(css="#btnDeleteList")
	private WebElement deleteList;
	@FindBy(css=".list-action")
	private List<WebElement> listMenu;
	@FindBy(css="#tagcloudbtn")
	private WebElement tagsButton;
	@FindBy(css="#tasklist [class='tag']")
	private List<WebElement> tags;
	@FindBy(css="#tabs_buttons")
	private WebElement selectListButton;
	@FindBy(css="#slmenucontainer a")
	private List<WebElement> hamburgerMenu;
	@FindBy(css=".mtt-tab.mtt-tabs-selected span")
	private WebElement selectedList;
	@FindBy(css="#settings")
	private WebElement settingsButton;
	@FindBy(css="#cmenu_note")
	private WebElement editNote;
	@FindBy(css="[style=\"display: block;\"] .mtt-action-note-save")
	private WebElement save;
	@FindBy(css=".task-note-area textarea")
	private List<WebElement> taskstextarea;
	@FindBy(css=".task-note span")
	private List<WebElement> tasksNotes;
	@FindBy(css="[type='checkbox']")
	private List<WebElement> checkbox;
	@FindBy(css="#btnClearCompleted")
	private WebElement clearCompletedTasks;
	
	public TasksPage(WebDriver driver) {
		super(driver);
	}
	
	public void addTask(String taskName){
		fillText(taskField, taskName);
		click(addButton);
		waitingForLoading();
		
	}
	
	public void deleteTask(String taskName){
		for (int i = 0; i < tasks.size(); i++) {
			if (getText(tasks.get(i)).equalsIgnoreCase(taskName)) {
				moveTo(tasks.get(i));
				click(taskMenu.get(i));
				click(menuDelete);
				alertOK();
				sleep(1000);
			}
		}
	}
	
	public void completeTask(String taskName){
		for (int i = 0; i < tasks.size(); i++) {
			if (getText(tasks.get(i)).equalsIgnoreCase(taskName)) {
				click(checkbox.get(i));
				break;

			}
		}
	}
	
	public void editNoteToTask(String taskName, String note){
		for (int i = 0; i < tasks.size(); i++) {
			if (getText(tasks.get(i)).equalsIgnoreCase(taskName)) {
				moveTo(tasks.get(i));
				click(taskMenu.get(i));
				click(editNote);
				for (WebElement el : taskstextarea) {
					if (el.isDisplayed()) {
						sleep(1000);
						fillText(el, note);
						sleep(1000);
						click(save);
							}
						
						}
					}
				}		
	}

	public void openAdvancedTask() {
		click(advancedButton);
	}
	
	public void Search(String text) {
		fillText(searcField, text);
		sleep(1000);
	}
	
	public void goToSettings() {
		click(settingsButton);
		sleep(1000);
	}
	
	public void addList(String listName) {
		click(newListButton);
		alertOK(listName);
		sleep(1000);	
	}
	
	public void deleteList(String listName) {
		WebElement listMenu = driver.findElement(By.cssSelector("[title='" + listName +"']>.list-action"));
		click(listMenu);
		click(deleteList);
		alertOK();
		sleep(1000);	
	}
	
	public void clearCompletedTasksInList(String listName) {
		WebElement listMenu = driver.findElement(By.cssSelector("[title='" + listName +"']>.list-action"));
		click(listMenu);
		click(clearCompletedTasks);
		alertOK();
		sleep(1000);	
	}
	
	public void clickOnList(String listName) {
		WebElement list = driver.findElement(By.cssSelector("[title='" + listName +"']>span"));
		click(list);
		sleep(500);
	}
	
	public void selectList(String listName) {
		click(selectListButton);
		for (int i = 0; i < hamburgerMenu.size(); i++) {
			if (getText(hamburgerMenu.get(i)).equalsIgnoreCase(listName)) {
				click(hamburgerMenu.get(i));
				sleep(500);
			}
		}
	}
	
	public void renameList(String listName, String newListName) {
		WebElement listMenu = driver.findElement(By.cssSelector("[title='" + listName +"']>.list-action"));
		click(listMenu);
		click(renameList);
		alertOK(newListName);
		sleep(1000);
	}
	
	public void renameList(String newListName) {
		for (WebElement el : listMenu) {
			if (el.isDisplayed()) {
				click(el);
				sleep(500);
				break;
			}
		}
		click(renameList);
		alertOK(newListName);
		sleep(1000);
	}
	
	public void filterByTag(String tagName) {
		click(tagsButton);
		waitingForLoading();
		WebElement tag = driver.findElement(By.cssSelector("#tagcloudcontent [tag='" + tagName +"']"));
		click(tag);
		sleep(1000);
	}
	
	//Validation
	public int getNumOfTasks() {
		String sTotal = getText(total);
		int iTotal = Integer.parseInt(sTotal);
		return iTotal;	
	}
	
	public String getListText() {
		String ListText = getText(selectedList);
		return ListText;	
	}
	
	public String getSettingsText() {
		String SettingsText = getText(settingsButton);
		return SettingsText;	
	}
	
	public boolean isListExist(String listName) {
		for (WebElement el : lists) {
			if (el.getText().equalsIgnoreCase(listName)) {
				return true;
			}
		}
		return false;
	}	
	
	public boolean isTaskExist(String taskName) {
		for (WebElement el : tasks) {
			if (getText(el).equalsIgnoreCase(taskName)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isNoteExist(String noteName) {
		for (WebElement el : tasksNotes) {
			if (getText(el).equalsIgnoreCase(noteName)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isSearchResultsContain(String taskName) {
		for (WebElement el : tasks) {
			if (!getText(el).contains(taskName)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isFilterResultsContainTag(String tagName) {
		for (WebElement el : tags) {
			if (!getText(el).contains(tagName)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isLanguageChanged(String Language) {
		getText(settingsButton);
			if (settingsButton.getText().equalsIgnoreCase(Language)) {
				return true;
			}
		return false;
	}
}
