package com.cts.saucedemopages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YourCart {

	private  By yourCartLoc =By.xpath("//div[@class='cart_quantity']");
	private  By continueLoc=By.xpath("//a[text()='Continue Shopping']");
	private  By checkOutLoc=By.linkText("CHECKOUT");
	
	private WebDriver driver;

	public YourCart(WebDriver driver) {
		this.driver = driver;
	}
	
	public  String productsInCart() {
		String prosNumber = driver.findElement(yourCartLoc).getText();
		int productsNumber = Integer.parseInt(prosNumber);
		if(productsNumber > 0) {
			return "true";
		}
		else {
			return "false";
		}
	}
	public void continueShopping()
	{
		driver.findElement(continueLoc).click();
	}
	public void checkOut()
	{
		driver.findElement(checkOutLoc).click();
	}
}