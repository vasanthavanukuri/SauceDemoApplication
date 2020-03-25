package com.cts.saucedemopages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutInfoPage {
	private By firstnameLoc = By.id("first-name");
	private By lastnameLoc = By.id("last-name");
	private By zipCodeLoc = By.id("postal-code");
	private By continueLoc = By.xpath("//input[@type='submit']");
	private By cancelLoc = By.linkText("CANCEL");

	private WebDriver driver;

	public CheckOutInfoPage(WebDriver driver) {
		this.driver = driver;
	}

	public void enteringFirstName(String firstName) {
		driver.findElement(firstnameLoc).sendKeys(firstName);
	}

	public void enteringLastName(String lastname) {
		driver.findElement(lastnameLoc).sendKeys(lastname);
	}

	public void enteringZipCode(String zipCode) {
		driver.findElement(zipCodeLoc).sendKeys(zipCode);
	}

	public void clickOnContinue() {
		driver.findElement(continueLoc).click();
	}

	public void clickOnCancel() {
		driver.findElement(cancelLoc).click();
	}

	public String checkingInfoPage() {
		String infoText = driver.findElement(By.xpath("//div[text()='Checkout: Your Information']")).getText();
		return infoText;
	}
}
