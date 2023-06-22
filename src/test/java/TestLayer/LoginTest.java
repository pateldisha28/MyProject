package TestLayer;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import basePackage.BaseHRMClass;
import testdata.ExcelSheet;
import POM.PomLogin;
public class LoginTest extends BaseHRMClass {
	PomLogin log;
	
	public LoginTest()
	{
		super();//constructor of my parent class so im using super keyword.
		
	}
	
	@BeforeMethod
	public void initsetup() throws InterruptedException
	{
		initiate();
		Thread.sleep(3000);
		
		System.out.println("screenshot done");
		log=new PomLogin();//initiating the object of pomlogin class
	
	}

	@Test (priority=1)
	public void title()
	{
		String actual=log.varify();
		System.out.println("OrangeHRM");
		AssertJUnit.assertEquals(actual,"OrangeHRM");
	}
	
	@DataProvider
	public Object[][] details()
	{
		Object result[][]=ExcelSheet.readdata("Sheet1");
		return result;
		}
	
	@Test(priority=2, dataProvider="details")
	public void Login(String name,String password) throws InterruptedException
	{
		Thread.sleep(6000);
		log.typeusername(name);
		log.typepassword(password);
		screenshots("Login");
		log.clickbtn();
	}
	

//	 @AfterMethod
//	 public void close()
//	 {
//		 driver.close();
//	 }
	
	
}
