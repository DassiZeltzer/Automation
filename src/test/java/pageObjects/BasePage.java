package pageObjects;


import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {  
		WebDriver driver;
		Actions action;
		WebDriverWait wait;
		JavascriptExecutor js; 

		public BasePage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			action = new Actions (driver);
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			js=(JavascriptExecutor)driver; 
		}

		public void fillText(WebElement el, String text) {
			//highlight
			highlightElement(el, "black", "pink");
			//js.executeScript("arguments[0].setAttribute('style', 'background-color:pink;' , 'border: 1px solid black;');", el);
			el.clear();
			sleep(500);
			el.sendKeys(text);
		}

		public void click(WebElement el) {
			highlightElement(el, "yellow", "blue");
			//js.executeScript("arguments[0].setAttribute('style', 'background-color:blue; border: 1px solid black;');", el);
			sleep(400);
			el.click();
		}

		public String getText(WebElement el) {
			highlightElement(el, "yellow", "yellow");
			//js.executeScript("arguments[0].setAttribute('style', 'background-color:yellow;');", el);
			sleep(500);
			return el.getText();
		}

		public void sleep(long mills) {
			try {
				Thread.sleep(mills);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//Alart
		public void alertOK(String text) {
			driver.switchTo().alert().sendKeys(text);
			sleep(1000);
			driver.switchTo().alert().accept();
		}
		
		public void alertOK() {
			driver.switchTo().alert().accept();
		}
		
		//Mouse options
		public void moveTo(WebElement el) {
			action.moveToElement(el).build().perform();
		}
		
		
		private void highlightElement(WebElement element, String color, String background) {
			//keep the old style to change it back
			String originalStyle = element.getAttribute("style");
			String newStyle = "background-color:" + background + "; border: 1px solid " + color + ";" + originalStyle;
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			// Change the style 
			js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '" + newStyle + "');},0);",
					element);

			// Change the style back after few miliseconds
			js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
					+ originalStyle + "');},1000);", element);

		}
}


