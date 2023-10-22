package com.Task18.Answers;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Q1_Facebook_Acount_SignUp {
	static WebDriver driver=null;
	public static void main(String[] args) {
		driver=new ChromeDriver();//Opens the Chrome Browser
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();//Maximize the Browser window
		driver.get("https://www.facebook.com/");//Navigate to the FaceBook homePage Url
		String currenturl=driver.getCurrentUrl();//Gets the Url of the Current page

		//verifies whether a Url is redirected to FaceBook HomePage
		if(currenturl.equals("https://www.facebook.com/"))				
		{
			System.out.println("FaceBook Homepage redirected Successfully...");
			driver.findElement(By.partialLinkText("Create new account")).click();//clicks the create new account Button
			driver.findElement(By.name("firstname")).sendKeys("Test");//Types the FirstName as test in the firstName field
			driver.findElement(By.name("lastname")).sendKeys("User");//Types the surName as test in the surname  field
			driver.findElement(By.name("reg_email__")).sendKeys("testuser@test.com");//Types the New Email Id 
			driver.findElement(By.name("reg_email_confirmation__")).sendKeys("testuser@test.com");//types the Re-Confirmation Mail Id 
			driver.findElement(By.id("password_step_input")).sendKeys("Seshanth2346Rakesh####");//Types the Password
			driver.findElement(By.name("birthday_day")).click();						
			Select sel =new Select(driver.findElement(By.name("birthday_day")));
			sel.selectByValue("11");//Selects the birth_day 
			Select sel1= new Select(driver.findElement(By.name("birthday_month")));
			sel1.selectByIndex(4);//selects the birth_month
			Select sel2= new Select(driver.findElement(By.id("year")));
			sel2.selectByValue("1985");//selects the Birth_year
			driver.findElement(By.xpath("//input[@value='2']")).click();//choose the Gender
			driver.findElement(By.name("websubmit")).click();//clicks the SignUp Button
		}


		else {
			System.out.println("Redirection Of FaceBook Homapage is Failed");
			driver.quit();//Quit from the browser window
		}


	}
}
