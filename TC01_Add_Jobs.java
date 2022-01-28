package A21_Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC01_Add_Jobs {
	
	static WebDriver driver;
	
	//Step 1
	//String TestURL="https://opensource-demo.orangehrmlive.com/";
	//String UserName="Admin",password="admin123";
	//String jobTitle="Sales5",JobDescr="Seles5 descr",
		//	JobNote="Sales5 Note";
	
	//step1
	 @DataProvider(name = "Orange124")
	  public static Object[][] Test1() throws Exception {
	 
	        return new Object[][] { 
	        	{ "https://opensource-demo.orangehrmlive.com/","Admin", "admin123","Sales12","Sales12 descr","Sales12 Note" },
	        	{"https://opensource-demo.orangehrmlive.com/","Admin", "admin123","Sales13","Sales13 descr","Sales13 Note" },
	        	{"https://opensource-demo.orangehrmlive.com/","Admin", "admin123","Sales14","Sales14 descr","Sales14 Note" }
	        	};
	  }
	 
	 
	 
	 @DataProvider(name="Orange125")
		
	 public Object[] myDataProvider() {
	      
	     Object data[][]=  new Object[3][6];
	     
	     // First student details
	     data[0][0]= "https://opensource-demo.orangehrmlive.com/"; 
	     data[0][1]= "Admin";
	     data[0][2]= "admin123";
	     data[0][3]= "Sales15";
	     data[0][4]= "Sales15 descr";
	     data[0][5]= "Sales15 Note";
	      
	     // Second student details
	     data[1][0]= "https://opensource-demo.orangehrmlive.com/"; 
	     data[1][1]= "Admin";
	     data[1][2]= "admin123";
	     data[1][3]= "Sales16";
	     data[1][4]= "Sales16 descr";
	     data[1][5]= "Sales16 Note";
	     
	     // Second student details
	     data[2][0]= "https://opensource-demo.orangehrmlive.com/"; 
	     data[2][1]= "Admin";
	     data[2][2]= "admin123";
	     data[2][3]= "Sales17";
	     data[2][4]= "Sales17 descr";
	     data[2][5]= "Sales17 Note";
	     
	     return data;
	      
	      
	 }
	 
	
  @Test(dataProvider="Orange125")//Step2
  public void Add_Jobs_Test(String TestURL,String UserName,String password,
		  String jobTitle,String JobDescr,String JobNote
		  
		  )  throws Exception{  //STep3
	  
	  TC01_Add_Jobs T1=new TC01_Add_Jobs();
	  
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
