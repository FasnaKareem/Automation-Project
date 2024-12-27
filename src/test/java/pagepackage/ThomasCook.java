package pagepackage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

  public class ThomasCook {
	
    WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"search-button\"]")
	WebElement search;
	
	@FindBy(xpath="//*[@id=\"forexDiv\"]/div/div/div/div[4]/div[2]/a/span/span[2]")
	WebElement rateCard;
	
	@FindBy(xpath="//*[@id=\"navbarDropdown\"]")
	WebElement holiday;
	
	@FindBy(xpath="//*[@id=\"navbarSupportedContent\"]/ul/li[1]/div/div/div/div[3]/ul/li[3]/a")
	WebElement dubai;
	
	@FindBy(xpath="//*[@id=\"LoginLogoutToggel\"]")
	WebElement login;
	
	@FindBy(xpath="//*[@id=\"newUserId\"]/p/a")
	WebElement register;
	
	@FindBy(xpath="//*[@id=\"registerFName\"]")
	WebElement firstName;
	
	@FindBy(xpath="//*[@id=\"registerLName\"]")
	WebElement lastName;
	
	@FindBy(xpath="//*[@id=\"registerLogin\"]/div[2]/div[2]/div/a")
	WebElement regLogin;
	
	@FindBy(xpath="//*[@id=\"registerLogin\"]/div[2]/div[1]/div/a")
	WebElement regLink;
	
	@FindBy(xpath="//*[@id=\"regTitle\"]")
	WebElement title;
	
	@FindBy(xpath="//*[@id=\"registerFName\"]")
	WebElement fnName;
	
	@FindBy(xpath="//*[@id=\"registerLName\"]")
	WebElement ltName;
	
	@FindBy(xpath="//*[@id=\"registerEmailId\"]")
	WebElement mailId;
	
	@FindBy(xpath="//*[@id=\"registerPwd\"]")
	WebElement passWord;
	
	@FindBy(xpath="//*[@id=\"registerConfirmPwd\"]")
	WebElement confirmPass;
	
	@FindBy(xpath="//*[@id=\"registerMobileNo\"]")
	WebElement mobNumber;
	
	@FindBy(xpath="//*[@id=\"registerButton\"]")
	WebElement regBtn;
	
	
	public  ThomasCook(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements( driver,this);
		
	}
	
	
	public void titleVerification()
	{
		String actualTitle=driver.getTitle();
		System.out.println("Title="+actualTitle);
		
		String exp="Thomas Cook Tours and Travels: Flights, Hotels, Forex & Holidays Packages";
		if(exp.equals(actualTitle))
		{
			System.out.println("Titles are same");
			
		}
		else
		{
			System.out.println("Titles are not same");
		}
	}
	
	
	public void pageSource()
	{
		String src=driver.getPageSource();
		if(src.contains("Best offers exclusively for you!"))
		{
			System.out.println("Content present");
		}
		else
		{
			System.out.println("Content not present");
		}
				
	}
	
	
	public void linkCountTC()
	{
		List<WebElement> linkDetails=driver.findElements(By.tagName("a"));
		System.out.println("Total No. of Links : "+linkDetails.size());
		
		for(WebElement element:linkDetails)
		{
			String link=element.getAttribute("href");
			String linkText=element.getText();
			System.out.println("Link = "+link);
			System.out.println("LinkText = "+linkText);
		}
	}
	
	
	
	public void screenShot() throws IOException
	{
			File c=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(c, new File("C:\\Users\\Inspiron\\Pictures\\Screenshots\\Image.png"));
			
			
			File buttonImg=search.getScreenshotAs(OutputType.FILE);
			FileHandler.copy(buttonImg,new File("./screenshot/button.png"));
			
			
	}
	

    
    public void windowHandle()
	{
		String parentWindow=driver.getWindowHandle();
		rateCard.click();
		
		Set <String> allWindows=driver.getWindowHandles();
		for(String handle:allWindows)
		{
			if(!handle.equalsIgnoreCase(parentWindow))
			{
				driver.switchTo().window(handle);
				driver.close();
			}
			
			driver.switchTo().window(parentWindow);
			
		}
	}
    
    
    public void moveToElement()
	{ 
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		Actions act=new Actions(driver);
		
		act.moveToElement(holiday).perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[1]/div/div/div/div[3]/ul/li[3]/a")));
		dubai.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

	    // Optionally, scroll down by a specific amount (e.g., 500 pixels)
	    // js.executeScript("window.scrollBy(0, 500);");
	    
	    
	}
    
    
    public void copyPaste()
	{ 
       login.click();
       register.click();
	   Actions act=new Actions(driver);
	   firstName.sendKeys("Anu");
	   act.keyDown(firstName, Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL);
	   act.keyDown(firstName, Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL);
	   act.keyDown(lastName, Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL);
	   act.perform();
	   regLogin.click();
   	   regLink.click();
   	
	}
    
    
    public void setValues(String FN, String LN, String MI, String PW, String CP, String MN)
	{
    	
		title.click();
		Select option=new Select(title);
    	option.selectByValue("Miss");
		fnName.sendKeys(FN);
		ltName.sendKeys(LN);
	    mailId.sendKeys(MI);
		passWord.sendKeys(PW);
		confirmPass.sendKeys(CP);
		mobNumber.sendKeys(MN);
		regBtn.click();
		
	}
    
   

}
