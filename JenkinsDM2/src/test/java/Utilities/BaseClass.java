package Utilities;





import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;

public class BaseClass {

	WebDriver driver;

  @Parameters({"browser","websiteURL"})
  @BeforeMethod
  public void beforeClass(String browsername, String url) throws InterruptedException {
	  Ibrowsers(browsername,url);
	}
  

  @AfterMethod
  public void afterMethod() {
	  
	  driver.close();
  }
  
  
  public  void Ibrowsers(String browsername,String url) throws InterruptedException {
		
		if(browsername.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get(url);
		Thread.sleep(3000);
	}
		else if(browsername.equalsIgnoreCase("Edge")) {
			
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			driver.get(url);
			driver.manage().window().maximize();
			Thread.sleep(3000);
		}

}
}