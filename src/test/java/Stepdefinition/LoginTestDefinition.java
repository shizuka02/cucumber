package Stepdefinition;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginTestDefinition {

    static WebDriver driver;
    static int val=0;

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
        if(driver.findElement(By.xpath("//div[text()='Swag Labs']")).getText().equals("Swag Labs")){

            System.out.println("Swag Labs Title is present");

        }else{

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
    public void the_cart_icon_displays_the_correct_number_of_items_added_to_the_cart()
    {
        String text = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).getText();
        System.out.println("Items in cart read by program: "+val);
        System.out.println("Item read from xpath: "+text);
        if(text.equals(String.valueOf(val)))
       {

           System.out.println("Cart Verified");
       }
       else {

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
//    @When("User enters invalid email address {string}")
//    public void user_enters_invalid_email_address(String invalidEmailAddress) {
//        System.out.println(">> User has entered invalid email address: " + invalidEmailAddress);
//    }
//
//    @When("Enters invalid password {string}")
//    public void enters_invalid_password(String invalidPassword) {
//        System.out.println(">> User has entered invalid password address: " + invalidPassword);
//    }
//
//    @Then("User should get a proper warning message")
//    public void usr_should_get_a_proper_warning_message() {
//        System.out.println(">> User got a proper warning message");
//
//    }
//
//
//
//    @When("User dont enter any credentials")
//    public void user_dont_enter_any_credentials() {
//        System.out.println(">> User has not entered any credentials");
//    }


//
}