package login;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pagesobjects.LinkedSignInPage;
import reporter.BaseTest;

public class LoginTest extends BaseTest {

	@Test
	public void testLoginpage() {
		WebDriver driver = initializeDriver();
		driver.get("https://www.linkedin.com/login");
		
		LinkedSignInPage linkedSignInPage = new LinkedSignInPage(driver);
		assertTrue(linkedSignInPage.isLoginPageDisplayed());
		//assertTrue(false);
	}
	
	@Test
	public void testValidLogin() {
		
		WebDriver driver = initializeDriver();
		driver.get("https://www.linkedin.com/login");
		
		LinkedSignInPage linkedSignInPage = new LinkedSignInPage(driver);
		linkedSignInPage.enterEmail("vishal.sudrik555@gmail.com");
		
		linkedSignInPage.enterPassword("Test@12345");
	}
}
