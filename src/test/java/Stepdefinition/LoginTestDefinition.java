package Stepdefinition;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class LoginTestDefinition {

    static WebDriver driver;
    static int val = 0;
    static int count=0;
    static int count1=0;

    @Given("open chrome and launch the application")
    public void open_chrome_and_launch_the_application() {
        String s = System.setProperty("webdriver.chrome.driver", "C://Users//Shalini.Verma//OneDrive - Gemini Solutions//Desktop//chrome//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        System.out.println(">> This step open the browser and launch the application");
    }

    @Given("User navigates to Login page")
    public void user_navigates_to_Login_page() {
        System.out.println(">> User got navigated to login page");
    }

    @When("User enters valid email address {string}")
    public void user_enters_valid_email_address(String emailAddressText) {
        driver.findElement(By.id("user-name")).sendKeys(emailAddressText);
        //System.out.println(">> User enters valid email address: "+emailAddressText);
    }

    @And("Enters valid password {string}")
    public void enters_valid_password(String passwordText) {
        driver.findElement(By.id("password")).sendKeys(passwordText);
        //System.out.println(">> User enters valid password: "+passwordText);
    }

    @And("Click on Login button")
    public void click_on_Login_button() {
        driver.findElement(By.id("login-button")).click();
        //System.out.println(">> User clicks on Login Button");
    }

    @Then("User should login successfully")
    public void usr_should_login_successfully() {
        System.out.println(">> User should Logged in Successfully");
    }

    @Then("Swag labs Title is visible on the product screen")
    public void swag_labs_title_is_visible_on_the_product_screen() {
        if (driver.findElement(By.xpath("//div[text()='Swag Labs']")).getText().equals("Swag Labs")) {

            System.out.println("Swag Labs Title is present");

        } else {

            System.out.println("Element is Absent");

        }
    }

    @When("User click on Add to Cart button")
    public void user_click_on_add_to_cart_button() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
        val++;
        driver.findElement(By.xpath("//button[@id=\"add-to-cart-sauce-labs-bike-light\"]")).click();
        val++;
    }

    @Then("Product is added in cart successfully")
    public void product_is_added_in_cart_successfully() {

    }

    @Then("the cart icon displays the correct number of items added to the cart")
    public void the_cart_icon_displays_the_correct_number_of_items_added_to_the_cart() {
        String text = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).getText();
        System.out.println("Items in cart read by program: " + val);
        System.out.println("Item read from xpath: " + text);
        if (text.equals(String.valueOf(val))) {

            System.out.println("Cart Verified");
        } else {

            System.out.println("Cart Verification failed");
        }
    }

    @When("User click on Checkout Button")
    public void user_click_on_checkout_button() {
        driver.findElement(By.xpath("//a[@class=\"shopping_cart_link\"]")).click();
        driver.findElement(By.xpath("//button[@id=\"checkout\"]")).click();
        System.out.println(">> Success");
    }

    @Then("User will be redirected to Checkout Page")
    public void user_will_be_redirected_to_checkout_page() {
        System.out.println(">> User will be redirected to checkout page");
    }

    //
    @When("User click on Logout Button")
    public void user_click_on_logout_button() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[text()=\"Open Menu\"]")).click();
        driver.findElement(By.xpath("//a[text()=\"Logout\"]")).click();
    }

    @Then("User will be logged out successfully")
    public void user_will_be_logged_out_successfully() {
        System.out.println(">> User will be logged out successfully");
    }

    @When("User enters invalid email address {string}")
    public void user_enters_invalid_email_address(String invalidEmailAddress) {
        driver.findElement(By.id("user-name")).sendKeys(invalidEmailAddress);
    }

    @When("Enters invalid password {string}")
    public void enters_invalid_password(String invalidPassword) {

        driver.findElement(By.id("password")).sendKeys(invalidPassword);
    }

    @Then("User should get a proper warning message")
    public void usr_should_get_a_proper_warning_message() {
        String actualErrorMessage = driver.findElement(By.xpath("//h3[@data-test=\"error\"]")).getText();
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        //System.out.println(">> User got a proper warning message");
        assertEquals(expectedErrorMessage, actualErrorMessage);

    }

    @Given("Verify Name, Price and Description of the product")
    public void product_details() {
        String[] productNames = {"Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket", "Sauce Labs Onesie", "Test.allTheThings() T-Shirt (Red)"};

        String[] productDescription = {"carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.",
                "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.",
                "Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.",
                "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.",
                "Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.",
                "This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton."};

        String[] productPrices = {"$29.99", "$9.99", "$15.99", "$49.99", "$7.99", "$15.99"};


        List<WebElement> pn = driver.findElements(By.xpath("//div[@class=\"inventory_item_name\"]"));
        boolean nameFlag = true;
        for (WebElement pns : pn) {

            String productNameElement = pns.getText();
            List<String> list = Arrays.asList(productNames);
            if (list.contains(productNameElement)) {
                nameFlag = true;
            } else {
                nameFlag = false;
        }
        }
        if(nameFlag)
        {
            System.out.println("All Product Name matched");
        }else {
            System.out.println("Product Name Mismatched");
        }
        boolean descFlag = true;
        List<WebElement> pd = driver.findElements(By.xpath("//div[@class=\"inventory_item_desc\"]"));
        for (WebElement pds : pd) {

            String productDescElement = pds.getText();
            List<String> list = Arrays.asList(productDescription);
            if (list.contains(productDescElement)) {
                descFlag = true;
            } else {
                descFlag = false;
            }
        }
        if(descFlag)
        {
            System.out.println("All Product Description matched");
        }else {
            System.out.println("Product Description Mismatched");
        }

        boolean priceFlag = true;
        List<WebElement> pp = driver.findElements(By.xpath("//div[@class=\"inventory_item_price\"]"));
        for (WebElement pps : pp) {
            String productPriceElement = pps.getText();
            List<String> list = Arrays.asList(productPrices);
            if (list.contains(productPriceElement)) {
                priceFlag = true;
            } else {
                priceFlag = false;
            }
        }
        if(priceFlag)
        {
            System.out.println("All Product price matched");
        }else {
            System.out.println("Product price Mismatched");
        }


    }

    @Given("the user is on the product page")
    public void theUserIsOnTheProductPage() {
    }

    @When("the user adds product with quantity to the cart")
    public void theUserAddsProductWithQuantityToTheCart() {
    }

    @Then("the cart should contain {string} of {string}")
    public void theCartShouldContainOf(String productName, String quantity)
    {
       String quan= driver.findElement(By.xpath("//div[@class=\"cart_quantity\"]")).getText();
       String pname= driver.findElement(By.xpath("//div[@class=\"inventory_item_name\"]")).getText();
       System.out.println(quan);
        System.out.println(pname);
    }
String product1, product2;

    @Given("User has added products to the cart")
    public void userHasAddedProductsToTheCart() throws InterruptedException {
        Thread.sleep(2000);
      product1= driver.findElement(By.xpath("//div[text()=\"Sauce Labs Fleece Jacket\"]")).getText();
    driver.findElement(By.xpath("//button[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]")).click();
      count++;
      product2= driver.findElement(By.xpath("//div[text()=\"Sauce Labs Onesie\"]")).getText();
      driver.findElement(By.xpath("//button[@id=\"add-to-cart-sauce-labs-onesie\"]")).click();
      count1++;
        System.out.println("Items added in cart");
    }

    @When("User clicks on the cart")
    public void userClicksOnTheCart() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@class=\"shopping_cart_link\"]")).click();
        System.out.println(">> User click on the cart");
    }
String product1_xpath, product2_xpath, quantity1_xpath,quantity2_xpath;
    @Then("Cart should display the correct products and quantities")
    public void cartShouldDisplayTheCorrectProductsAndQuantities() {
        product1_xpath= driver.findElement(By.xpath("//div[text()='Sauce Labs Fleece Jacket']")).getText();
        quantity1_xpath = driver.findElement(By.xpath("(//div[@class='cart_quantity'])[1]")).getText();

        product2_xpath= driver.findElement(By.xpath("//div[text()='Sauce Labs Onesie']")).getText();
        quantity2_xpath=driver.findElement(By.xpath("(//div[@class='cart_quantity'])[2]")).getText();
        assertEquals(product1,product1_xpath);
        System.out.println("Product 1 actual name" +product1_xpath +" and expected name Matched : " +product1);
        assertEquals(String.valueOf(count),quantity1_xpath);
        System.out.println("actual quantity of product 1: "+quantity1_xpath+"Expected quantity of product 1 " +count);
        assertEquals(product2,product2_xpath);
        System.out.println("Product 1 actual name and expected name Matched :" +product2_xpath +" " +product2);
        assertEquals(String.valueOf(count1),quantity2_xpath);
        System.out.println("actual and expected quantity of product 1 matched: "+quantity2_xpath+" " +count1);
    }


//
//
//
//    @When("User dont enter any credentials")
//    public void user_dont_enter_any_credentials() {
//        System.out.println(">> User has not entered any credentials");
//    }


//
}