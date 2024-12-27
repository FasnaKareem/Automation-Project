package basepackage;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class BaseClassThom {
	
	public static WebDriver driver;
	@BeforeTest
	public void setUp()
	{
		
			 driver=new ChromeDriver();
			 driver.get("https://www.thomascook.in/");	
			 driver.manage().window().maximize();
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			 
		 
	}

}
