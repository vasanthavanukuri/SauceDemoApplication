package com.cts.stepdefinitions;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cts.saucedemopages.CheckOutInfoPage;
import com.cts.saucedemopages.CheckOutOverView;
import com.cts.saucedemopages.FinishPage;
import com.cts.saucedemopages.LoginPage;
import com.cts.saucedemopages.MenuPage;
import com.cts.saucedemopages.ProductsPage;
import com.cts.saucedemopages.YourCart;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {
	public WebDriver driver;

	@Given("I have a browser with sauceDemoPage")
	public void i_have_a_browser_with_sauceDemoPage() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.saucedemo.com/");
	}

	@When("I enter userName as {string} and I enter password as  {string}")
	public void i_enter_userName_as_and_I_enter_password_as11(String userName, String password) {
		
		LoginPage login=new LoginPage(driver);
		login.enterUserName(userName);
		login.enterPassword(password);
		login.clickOnLogin();
	}

	@Then("I should access to the portal")
	public void i_should_access_to_the_portal() {
		
		MenuPage  menu=new MenuPage(driver);
		String actualTitle = menu.getTitle();
		Assert.assertEquals("Products", actualTitle);
		driver.quit();
	}

	@When("I click on add to cart button by entering userName as {string} and password as  {string}")
	public void i_click_on_add_to_cart_button_by_entering_userName_as_and_password_as(String userName, String password) throws InterruptedException {
		
		LoginPage login=new LoginPage(driver);
		login.enterUserName(userName);
		login.enterPassword(password);
		login.clickOnLogin();
		Thread.sleep(5000);
		ProductsPage  products=new ProductsPage(driver);
		products.clickOnAddToCart();
	}

	@Then("products should be added to the cart")
	public void products_should_be_added_to_the_cart() {
		
		ProductsPage  products=new ProductsPage(driver);
		String cartNum = products.productsInCart();
		Assert.assertEquals("true", cartNum);
		driver.quit();
	}

	@When("I click on cart symbol by entering userName as {string} and password as  {string}")
	public void i_click_on_cart_symbol_by_entering_userName_as_and_password_as(String userName, String password) throws InterruptedException {
		
		LoginPage login=new LoginPage(driver);
		login.enterUserName(userName);
		login.enterPassword( password);
		login.clickOnLogin();
		Thread.sleep(5000);
		ProductsPage  products=new ProductsPage(driver);
		products.clickOnAddToCart();
		products.clickOnCartSymbol();
	}

	@Then("ordered products should be displayed with product details")
	public void ordered_products_should_be_displayed_with_product_details()
	{
		YourCart yourcartpage=new YourCart(driver);
		String numberProducts = yourcartpage.productsInCart();
		Assert.assertEquals("true", numberProducts);
		driver.quit();
	}

	@When("I click on continue shopping  button by entering userName as {string} and password as  {string}")
	public void i_click_on_continue_shopping_button_by_entering_userName_as_and_password_as(String userName,
			String password) throws InterruptedException {
		
		LoginPage login=new LoginPage(driver);
		login.enterUserName(userName);
		login.enterPassword(password);
		login.clickOnLogin();
		Thread.sleep(5000);
		ProductsPage  products=new ProductsPage(driver);
		products.clickOnAddToCart();
		products.clickOnCartSymbol();
		
		YourCart yourcartpage=new YourCart(driver);
		yourcartpage.continueShopping();
	}

	@Then("products page should be displayed")
	public void products_page_should_be_displayed() {

		ProductsPage  products=new ProductsPage(driver);
		String pageText = products.gettingTitleOfPage();
		Assert.assertEquals("Products", pageText);
		driver.quit();

	}

	@When("I click on CheckOut button by entering userName as {string} and password as  {string}")
	public void i_click_on_CheckOut_button_by_entering_userName_as_and_password_as(String userName, String password) throws InterruptedException {

		LoginPage login=new LoginPage(driver);
		login.enterUserName(userName);
		login.enterPassword(password);
		login.clickOnLogin();
		
		Thread.sleep(5000);
		ProductsPage  products=new ProductsPage(driver);
		products.clickOnAddToCart();
		products.clickOnCartSymbol();
		
		YourCart yourcartpage=new YourCart(driver);
		yourcartpage.checkOut();

	}

	@Then("information  page should be displayed")
	public void information_page_should_be_displayed() {

		CheckOutInfoPage infopage=new CheckOutInfoPage(driver);
		String infoPageText = infopage.checkingInfoPage();
		Assert.assertEquals("Checkout: Your Information", infoPageText);
		driver.quit();
	}

	@When("I enter userName as {string} and password as  {string}  and firstName as {string} and lastname as {string} and zipCode as {string}")
	public void i_enter_userName_as_and_password_as_and_firstName_as_and_lastname_as_and_zipCode_as(String userName,String password, String firstName, String lastname, String zipCode) throws InterruptedException {
		
		LoginPage login=new LoginPage(driver);
		login.enterUserName(userName);
		login.enterPassword(password);
		login.clickOnLogin();
		
		Thread.sleep(5000);
		ProductsPage  products=new ProductsPage(driver);
		products.clickOnAddToCart();
		products.clickOnCartSymbol();
		
		YourCart yourcartpage=new YourCart(driver);
		yourcartpage.checkOut();
		
		CheckOutInfoPage infopage=new CheckOutInfoPage(driver);
		infopage.enteringFirstName(firstName);
		infopage.enteringLastName(lastname);
		infopage.enteringZipCode(zipCode);
		infopage.clickOnContinue();

	}

	@Then("overView  page should be displayed")
	public void overview_page_should_be_displayed() {

		CheckOutOverView checkout=new CheckOutOverView(driver);
		String overText =checkout.checkingOverViewpage();
		Assert.assertEquals("Checkout: Overview", overText);
		driver.quit();
		
	}

	@When("I enter userName as {string} and password as  {string} and firstName as {string} and lastname as {string} and zipCode as {string}  and click on continue and then finish")
	public void i_enter_userName_as_and_password_as_and_firstName_as_and_lastname_as_and_zipCode_as_and_click_on_continue_and_then_finish(
			String userName, String password, String firstName, String lastname, String zipCode) throws InterruptedException {
		
		LoginPage login=new LoginPage(driver);
		login.enterUserName(userName);
		login.enterPassword(password);
		login.clickOnLogin();
		Thread.sleep(5000);
		
		ProductsPage  products=new ProductsPage(driver);
		products.clickOnAddToCart();
		products.clickOnCartSymbol();
		
		YourCart yourcartpage=new YourCart(driver);
		yourcartpage.checkOut();
		
		CheckOutInfoPage infopage=new CheckOutInfoPage(driver);
		infopage.enteringFirstName(firstName);
		infopage.enteringLastName(lastname);
		infopage.enteringZipCode(zipCode);
		infopage.clickOnContinue();
		
		CheckOutOverView checkout=new CheckOutOverView(driver);
		checkout.clickingOnFinish();
		
	}

	@Then("finish page should be opened")
	public void finish_page_should_be_opened() {

		FinishPage finished=new FinishPage(driver);
		String finish = finished.checkingFinishText();
		Assert.assertEquals("Finish", finish);
		driver.quit();
	}

	@Then("thank you for order message should be displayed")
	public void thank_you_for_order_message_should_be_displayed() {
		
		FinishPage finished=new FinishPage(driver);
		finished.successfulOrderMsg();
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File file=ts.getScreenshotAs(OutputType.FILE);
		file.renameTo(new File("src/test/resources/screenshot/Thanks.png"));
		driver.quit();
		
	}
}
