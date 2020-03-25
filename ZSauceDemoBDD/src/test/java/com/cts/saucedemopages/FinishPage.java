package com.cts.saucedemopages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FinishPage {
	
	private WebDriver driver;

	public FinishPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String checkingFinishText()
	{
		String finishText =driver.findElement(By.xpath("//div[text()='Finish']")).getText();
		return finishText;
	}
	public  String successfulOrderMsg()
	{
		String successText =driver.findElement(By.xpath("//h2[text()='THANK YOU FOR YOUR ORDER']")).getText();
		return successText;
	}

}
