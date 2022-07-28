package pagesobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LinkedSignInPage extends BasePage {

	WebDriver driver;

	public LinkedSignInPage(WebDriver driver) {
		this.driver = driver;
	}

	// WebElement
	By emailTextField = By.id("username");

	By passwordTextField = By.id("password");

	/**
	 * This method used to enter email address.
	 * 
	 * @param email
	 *            email
	 */
	public void enterEmail(String email) {
		waitForElementToVisible(emailTextField, driver);
		setText(driver.findElement(emailTextField), email);
	}

	/**
	 * This method used to enter password.
	 * 
	 * @param password
	 *            password
	 */
	public void enterPassword(String password) {
		waitForElementToVisible(passwordTextField, driver);
		setText(driver.findElement(passwordTextField), password);
	}

	/**
	 * This method used to verify login page is displayed or not.
	 * 
	 * @return true if displayed else false
	 */
	public boolean isLoginPageDisplayed() {
		return isElementDisplayed(driver.findElement(emailTextField))
				&& isElementDisplayed(driver.findElement(passwordTextField));
	}
}
