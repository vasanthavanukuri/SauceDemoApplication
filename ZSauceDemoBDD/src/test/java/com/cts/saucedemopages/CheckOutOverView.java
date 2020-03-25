package com.cts.saucedemopages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class CheckOutOverView {
	
	
	private  By clickOnFinishLoc =By.linkText("FINISH");

	private WebDriver driver;
	
	public CheckOutOverView(WebDriver driver)
	{
		this.driver=driver;
	}

	public  String checkingOverViewpage()
	{
	String overViewText= driver.findElement(By.xpath("//div[text()='Checkout: Overview']")).getText();
	return overViewText;
	}
	public  void clickingOnFinish()
	{
		driver.findElement(clickOnFinishLoc).click();
	}

}
