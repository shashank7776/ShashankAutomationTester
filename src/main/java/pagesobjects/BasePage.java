package pagesobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	/**
	 * This method used to click on web element.
	 * @param element element
	 */
	public void clickOnElement(WebElement element) {
		element.click();
	}
	
	/**
	 * This method to enter text in given element.
	 * @param element input
	 */
	public void setText(WebElement element, String input) {
		element.sendKeys(input);
	}
	
	/**
	 * This method used to verify element is displayed or not.
	 * @param element element
	 * @return true if displayed else false
	 */
	public boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();
	}
	
	/**
	 * This method used to wait for given element to be visible.
	 * @param by by
	 * @param driver driver
	 */
	public void waitForElementToVisible(By by, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	/**
	 * This method used to move to given element.
	 * @param element element
	 * @param driver driver
	 */
	public void moveToElement(WebElement element, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}
	
	/**
	 * This method used to move to given element and click.
	 * @param element element
	 * @param driver driver
	 */
	public void moveToElementAndClick(WebElement element, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();
	}
}
