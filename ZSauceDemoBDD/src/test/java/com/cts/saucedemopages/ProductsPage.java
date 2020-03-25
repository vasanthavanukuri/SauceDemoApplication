package com.cts.saucedemopages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ProductsPage {

	private By sortLoc = By.xpath("//select[@class='product_sort_container']");
	private By addToCartLoc = By.xpath("(//button[@class='btn_primary btn_inventory'])[1]");
	private By clickOnOpenMenuLoc = By.xpath("//button[text()='Open Menu']");
	private By proOneLoc = By.xpath("(//div[@class='inventory_item_price'])[1]");
	private By proTwoLoc = By.xpath("(//div[@class='inventory_item_price'])[2]");
	private By cartLoc = By.xpath("//span[@class='fa-layers-counter shopping_cart_badge']");
	private By menuLoc = By.xpath("//button[text()='Open Menu']");
	private By productTextLoc = By.xpath("//div[text()='Products']");
	private By logOutLoc = By.linkText("Logout");

	private WebDriver driver;

	public ProductsPage(WebDriver driver) {
		this.driver = driver;
	}

	public void sortingProducts(String text) {
		Select selectName = new Select(driver.findElement(sortLoc));

		selectName.selectByVisibleText(text);
	}

	public void clickOnAddToCart() {
		driver.findElement(addToCartLoc).click();
	}

	public void clickOnOpenMenu() {
		driver.findElement(clickOnOpenMenuLoc).click();
	}

	public String productLToH() {

		String pro1 = driver.findElement(proOneLoc).getText();
		String pro2 = driver.findElement(proTwoLoc).getText();
		String StrPro1 = pro1.substring(1);
		String StrPro2 = pro2.substring(1);
		double onePro = Double.parseDouble(StrPro1);
		double twoPro = Double.parseDouble(StrPro2);
		if (onePro < twoPro) {
			String LToH = "true";
			return LToH;
		} else {
			String LToH = "false";
			return LToH;
		}
	}

	public String productHToL() {

		String pro1 = driver.findElement(proOneLoc).getText();
		String pro2 = driver.findElement(proTwoLoc).getText();
		String StrPro1 = pro1.substring(1);
		String StrPro2 = pro2.substring(1);
		double onePro = Double.parseDouble(StrPro1);
		double twoPro = Double.parseDouble(StrPro2);
		if (onePro > twoPro) {
			String LToH = "true";
			return LToH;
		} else {
			String LToH = "false";
			return LToH;
		}
	}

	public String productsInCart() {
		String number = driver.findElement(cartLoc).getText();
		if (number.equalsIgnoreCase("1")) {
			String cartT = "true";
			return cartT;
		} else {
			String cartF = "false";
			return cartF;
		}
	}

	public void clickOnCartSymbol() {
		driver.findElement(cartLoc).click();

	}

	public String gettingTitleOfPage() {
		String headerText = driver.findElement(productTextLoc).getText();
		return headerText;

	}

	public void clickOnMenuButton() {
		driver.findElement(menuLoc).click();

	}

	public void clickOnLogOut() {
		driver.findElement(logOutLoc).click();
	}

}
