import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGNormalClass {
	
	@Test
	public void F() {
		System.out.println("In Test Method");
	
	}
	@BeforeMethod
	public void Beforemethod() {
		System.out.println("In Before Method");
		
	}
	@AfterMethod
	public void Aftermethod() {
		System.out.println("In After Method");
	}
	@BeforeClass
	public void Beforeclass() {
		System.out.println("In BeforeClass Method ");
	}
	@AfterClass
	public void Afterclass() {
		System.out.println("In AfterClass Method");
	}
	@BeforeTest
	public void Beforetest() {
		System.out.println("In Before Test Method");
	}
	@AfterTest
	public void Aftertest() {
		System.out.println("In After Test Method");
	}
	@BeforeSuite
	public void Beforesuit() {
		System.out.println("In Before Suit Mehtod");
	}
	@AfterSuite
	public void Aftersuit() {
		System.out.println("In After Suit Method");
	}
	
	
	

}
