package A21_Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ExcelUtil.ExcelApiTest4;

public class TC01_Add_Jobs2 {
	
	static WebDriver driver;
	
	
	@DataProvider(name = "TC01_Add_Jobs")
	public static Object[][] Authentication1() throws Exception {
		
		ExcelApiTest4 eat = new ExcelApiTest4();
		Object[][] testObjArray = eat.getTableArray("C://HTML Report//OrangeHRM6//TC01_Jobs123.xlsX", "Sheet1");
		System.out.println(testObjArray.length);
		return (testObjArray);
	}
	
	
	 
	
  @Test(dataProvider="TC01_Add_Jobs")//Step2
  public void Add_Jobs_Test(String TestURL,String UserName,String password,
		  String jobTitle,String JobDescr,String JobNote
		  
		  )  throws Exception{  //STep3
	  
	  TC01_Add_Jobs2 T1=new TC01_Add_Jobs2();
	  
	  T1.Openchrome();
	  T1.OpenOrangeHRM(TestURL); //STep2
	  T1.Login(UserName,password);//Step2
	  T1.Add_jobs(jobTitle,JobDescr,JobNote);//Step2
	  T1.CloseBrowser();
		
		
  }
  
  
  public void Openchrome()throws Exception
  {
	  System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;	
  }
  
  public void OpenOrangeHRM(String TestURL1)throws Exception
  {

		driver.get(TestURL1);   
		
  }
  
  public void Login(String Uname,String Pwd)throws Exception
  {
	 findElement(By.id("txtUsername")).sendKeys(Uname);
	findElement(By.id("txtPassword")).sendKeys(Pwd);
		findElement(By.id("btnLogin")).click();
		
  }
  
  public void Add_jobs(String JobTitle1,String JobDescr1,String JobNote1)throws Exception
  {
	  findElement(By.id("menu_admin_viewAdminModule")).click();
		findElement(By.id("menu_admin_Job")).click();
		findElement(By.id("menu_admin_viewJobTitleList")).click();
		findElement(By.id("btnAdd")).click();
		findElement(By.id("jobTitle_jobTitle")).sendKeys(JobTitle1);
		findElement(By.id("jobTitle_jobDescription")).sendKeys(JobDescr1);
		findElement(By.id("jobTitle_note")).sendKeys(JobNote1);
		findElement(By.id("btnSave")).click();
  }
  
  public void CloseBrowser()throws Exception
  {

		driver.quit();
  }
  
  
  public  WebElement findElement(By by) throws Exception 
	{

		WebElement elem = driver.findElement(by);  
		
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	 
		}
		return elem;
	}

  
  
}
