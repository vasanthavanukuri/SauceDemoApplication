package com.cts.saucedemopages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private By userNameLoc = By.id("user-name");
	private By passwordLoc = By.id("password");
	private By clickOnLoginLoc = By.xpath("//input[@value='LOGIN']");
	private By errorLoc = By.xpath("//h3[@data-test='error']");

	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void enterUserName(String userName) {
		driver.findElement(userNameLoc).sendKeys(userName);
	}

	public void enterPassword(String password) {
		driver.findElement(passwordLoc).sendKeys(password);
	}

	public void clickOnLogin() {
		driver.findElement(clickOnLoginLoc).click();
	}

	public String errorMessage() {
		String errorMSg = driver.findElement(errorLoc).getText();
		return errorMSg;
	}

}
