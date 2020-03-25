package com.cts.saucedemopages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ProductsPage {

	private static By sortLoc = By.xpath("//select[@class='product_sort_container']");
	private static By addToCartLoc =By.xpath("(//button[@class='btn_primary btn_inventory'])[1]");
	private static By clickOnOpenMenuLoc =	By.xpath("//button[text()='Open Menu']");
	private static By proOneLoc =	By.xpath("(//div[@class='inventory_item_price'])[1]");
	private static By proTwoLoc =	By.xpath("(//div[@class='inventory_item_price'])[2]");
	private static By cartLoc =	By.xpath("//span[@class='fa-layers-counter shopping_cart_badge']");
	private static By menuLoc = By.xpath("//button[text()='Open Menu']");
	private static By productTextLoc=By.xpath("//div[text()='Products']");
	private static By logOutLoc = By.linkText("Logout");
	
	public static void sortingProducts(WebDriver driver, String text) 
	{
		Select selectName = new Select(driver.findElement(sortLoc));

		selectName.selectByVisibleText(text);
	}
    public static void clickOnAddToCart(WebDriver driver)
    {
    	driver.findElement(addToCartLoc).click();
    }
    public static void clickOnOpenMenu(WebDriver driver)
    {
    	driver.findElement(clickOnOpenMenuLoc).click();
    }
   
	public static String productLToH(WebDriver driver) {

    	String pro1 = driver.findElement(proOneLoc).getText();
    	String pro2 = driver.findElement(proTwoLoc).getText();
    	String StrPro1 = pro1.substring(1);
    	String StrPro2 = pro2.substring(1);
    	double onePro = Double.parseDouble(StrPro1);
    	double twoPro = Double.parseDouble(StrPro2);
    	if(onePro < twoPro) {
    	 String LToH = "true";
    	 return LToH;
    	}
    	else {
    	 String LToH = "false";
    	 return LToH;	 
    	}
	}
	public static String productHToL(WebDriver driver) {

    	String pro1 = driver.findElement(proOneLoc).getText();
    	String pro2 = driver.findElement(proTwoLoc).getText();
    	String StrPro1 = pro1.substring(1);
    	String StrPro2 = pro2.substring(1);
    	double onePro = Double.parseDouble(StrPro1);
    	double twoPro = Double.parseDouble(StrPro2);
    	if(onePro > twoPro) {
    	 String LToH = "true";
    	 return LToH;
    	}
    	else {
    	 String LToH = "false";
    	 return LToH;	 
    	}
	}
	public static String productsInCart(WebDriver driver) {
		String number = driver.findElement(cartLoc).getText();
		if(number.equalsIgnoreCase("1")) {
			String cartT = "true";
	    	 return cartT; 
		}
		else {
			 String cartF = "false";
	    	 return cartF;
		}
	}
	public static void clickOnCartSymbol(WebDriver driver)
    {
    	driver.findElement(cartLoc).click();
    	
    }
	public static String gettingTitleOfPage(WebDriver driver)
	{
		String headerText =driver.findElement(productTextLoc).getText();
		return headerText;
		
		
	}
	public static void clickOnMenuButton(WebDriver driver)
	{
		driver.findElement(menuLoc).click();
		
	}
	public static void clickOnLogOut(WebDriver driver)
	{
		driver.findElement(logOutLoc).click();
	}
	
}
