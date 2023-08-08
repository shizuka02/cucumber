package Testdefinition;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginTestDefinition {

    static WebDriver driver;
    @Given("open chrome and launch the application")
    public void open_chrome_and_launch_the_application()
    {
        String s = System.setProperty("webdriver.chrome.driver", "C://Users//Shalini.Verma//OneDrive - Gemini Solutions//Desktop//chrome//chromedriver.exe");
        driver=new ChromeDriver();
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

    @Then("Usr should login successfully")
    public void usr_should_login_successfully() {
        System.out.println(">> User should Logged in Successfully");
    }

    @When("User enters invalid email address {string}")
    public void user_enters_invalid_email_address(String invalidEmailAddress) {
        System.out.println(">> User has entered invalid email address: "+invalidEmailAddress);
    }

    @When("Enters invalid password {string}")
    public void enters_invalid_password(String invalidPassword) {
        System.out.println(">> User has entered invalid password address: "+invalidPassword);
    }

    @Then("User should get a proper warning message")
    public void usr_should_get_a_proper_warning_message() {
        System.out.println(">> User got a proper warning message");

    }
    @Then("User should login successfully")
    public void user_should_login_successfully() {
        System.out.println(">> User should be logged in successfully");
    }

    @When("User dont enter any credentials")
    public void user_dont_enter_any_credentials() {
        System.out.println(">> User has not entered any credentials");
    }

}
