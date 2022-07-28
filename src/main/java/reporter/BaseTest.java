package reporter;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.google.common.io.Files;

public class BaseTest {

	File fileReport = new File(System.getProperty("user.dir") + File.separator + "reports", "AutomationReport.html");
	ExtentTest test;
	public WebDriver driver;

	public WebDriver initializeDriver() {
		Properties properties = new Properties();
		String filePath = "default.properties";
		try (InputStream inputStream = BaseTest.class.getClassLoader().getResourceAsStream(filePath)) {
			properties.load(inputStream);
		} catch (Exception ex) {
		}

		String browser;
		if (StringUtils.isBlank(System.getProperty("browser"))) {
			browser = properties.getProperty("browser");
		} else {
			browser = System.getProperty("browser");
		}

		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\NewgenAutomationBatch15Workspace\\TestAutomationFramework\\driver\\chromedriver.exe");

			driver = new ChromeDriver();

			// To maximize window
			driver.manage().window().maximize();
		} else {
			// execute on other browser
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		return driver;
	}

	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(Method method) {
		System.out.println("In Before method..");
		test = ExtentManager.startTest(method.getName());
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			String screenshotName = result.getMethod().getMethodName();
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAILED ", ExtentColor.RED));
			takeScreenShot(screenshotName);
			test.fail(result.getThrowable());
			test.addScreenCaptureFromPath("./FailedTcScreenshot" + File.separator + screenshotName + ".png");
		} else {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " PASSED ", ExtentColor.GREEN));

		}
		test = null;
		driver.quit();
	}

	@BeforeSuite(alwaysRun = true)
	public void beforeSuite() {
		ExtentManager.getReporter(fileReport.getAbsolutePath());

	}

	@AfterSuite(alwaysRun = true)
	protected void afterSuite(final ITestContext iTestContext) {
		ExtentManager.getReporter(fileReport.getAbsolutePath()).flush();
	}

	/**
	 * This method is used to capture screenshots on failure of test script
	 * 
	 * @param screenshotName
	 *            - Method name
	 */
	public void takeScreenShot(String screenshotName) {
		try {
			String path = System.getProperty("user.dir") + File.separator + "reports" + File.separator
					+ "FailedTcScreenshot";
			File file = new File(path);
			if (!file.exists()) {
				file.mkdir();
			}
			File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String destination = path + File.separator + screenshotName + ".png";
			File finalDestination = new File(destination);
			Files.copy(source, finalDestination);
		} catch (Exception e) {
		}
	}

}
