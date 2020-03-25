package com.cts.saucedemopages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuPage {

	private By clickOnAboutLoc = By.linkText("About");

	private WebDriver driver;

	public MenuPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnAbout() {
		driver.findElement(clickOnAboutLoc).click();
	}

	public String getTitle() {
		String actualTitle = driver.findElement(By.xpath("//div[@class='product_label']")).getText();
		return actualTitle;
	}

}
