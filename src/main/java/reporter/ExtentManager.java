package reporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	static ExtentHtmlReporter htmlReporter;
	private static ExtentReports extent;

	private ExtentManager() {
	}

	public synchronized static ExtentReports getReporter(String filePath) {
		if (extent == null) {

			htmlReporter = new ExtentHtmlReporter(filePath);
			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);
			// TODO :To add system or environment info runtime.
			extent.setSystemInfo("Operating System", System.getProperty("os.name"));

			htmlReporter.config().setChartVisibilityOnOpen(true);
			htmlReporter.config().setDocumentTitle("Test Automation Report");
			htmlReporter.config().setReportName("AutomationTestReport");
			htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
			htmlReporter.config().setTheme(Theme.DARK);
			htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

		}
		return extent;
	}

	public static synchronized ExtentTest startTest(String testName) {
		return extent.createTest(testName);
	}
}
