package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.SignupPage;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.junit.Assert.assertTrue;

public class SignupSteps {

    WebDriver driver;
    SignupPage signupPage;

    @Given("I am on the Magento homepage")
    public void i_am_on_the_magento_homepage() {
        WebDriverManager.chromedriver().setup();       // Sets up ChromeDriver
        driver = new ChromeDriver();                   // Launch browser
        driver.get("https://magento.softwaretestingboard.com/");
        driver.manage().window().maximize();
    }

    @When("I click on the {string} link")
    public void i_click_on_the_link(String linkText) {
        driver.findElement(org.openqa.selenium.By.linkText(linkText)).click(); // Click "Create an Account"
    }

    @When("I enter valid details and submit the form")
    public void i_enter_valid_details_and_submit_the_form() {
        signupPage = new SignupPage(driver); // Create page object

        String uniqueEmail = "vishal" + System.currentTimeMillis() + "@gmail.com";

        signupPage.enterFirstName("Vishal");
        signupPage.enterLastName("Chauhan");
        signupPage.enterEmail(uniqueEmail);        // Use unique email each time
        signupPage.enterPassword("Test@12345");
        signupPage.clickCreateAccount();
    }

    @Then("I should see the welcome message")
    public void i_should_see_the_welcome_message() {
        boolean isSuccess =
                driver.getPageSource().contains("Thank you for registering") ||
                        driver.getPageSource().contains("My Account");

        assertTrue("Signup failed!", isSuccess);
        driver.quit(); // Close browser
    }
}
