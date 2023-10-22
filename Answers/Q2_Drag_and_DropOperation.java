package com.Task18.Answers;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Q2_Drag_and_DropOperation {
	static WebDriver driver=null;
	public static void main(String[] args) {
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();

		//Navigate to https://jqueryui.com/droppable
		driver.navigate().to("https://jqueryui.com/droppable/");

		//Switch to iFrame
		WebElement f=driver.findElement(By.xpath("//*[@id=\"content\"]/iframe"));
		driver.switchTo().frame(f);

		//Locate the source and target Element
		WebElement sourceElemnt = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement targetElemnt= driver.findElement(By.xpath("//div[@id='droppable']"));

		//Move to Element and perform Drag an d Drop Operation
		Actions act =new Actions(driver);
		act.moveToElement(sourceElemnt).dragAndDrop(sourceElemnt, targetElemnt).build().perform();

		//Verifies the color Properties of the target element's CSS
		String targetColor=targetElemnt.getCssValue("color");

		//Perform color property Validation
		if(targetColor.equals("rgba(119, 118, 32, 1)")) {
			System.out.println("color changed");
		}
		else
			System.out.println("Color is Not Changed");


		//Verifies the text changed to dropped
		String text=targetElemnt.getText();
		if(text.equalsIgnoreCase("dropped!")) {
			System.out.println("The Element is Dropped");
		}
		else 
			System.out.println("The element is Not Dragged");
		

		driver.quit();
	}

}
