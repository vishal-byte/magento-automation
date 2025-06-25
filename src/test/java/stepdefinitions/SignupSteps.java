package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.SignupPage;
import utils.SharedTestData;

import java.util.UUID;

public class SignupSteps {
    WebDriver driver;
    SignupPage signupPage;

    @Given("I am on the Magento homepage")
    public void i_am_on_the_magento_homepage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");
    }

    @When("I click on the Create an Account link")
    public void i_click_on_the_create_account_link() {
        driver.findElement(By.linkText("Create an Account")).click();
    }

    @And("I enter valid signup details")
    public void i_enter_valid_signup_details() {
        signupPage = new SignupPage(driver);

        String email = "test" + UUID.randomUUID().toString().substring(0, 5) + "@mail.com";
        String password = "Password123";

        SharedTestData.email = email;
        SharedTestData.password = password;

        signupPage.enterFirstName("John");
        signupPage.enterLastName("Doe");
        signupPage.enterEmail(email);
        signupPage.enterPassword(password);
        signupPage.enterConfirmPassword(password);
    }

    @And("I submit the signup form")
    public void i_submit_signup_form() {
        signupPage.clickCreateAccount();
    }

    @Then("I should see the welcome message")
    public void i_should_see_welcome_message() {
        // Optionally validate welcome message
    }

    @And("I close the browser")
    public void i_close_the_browser() {
        driver.quit();
    }
}
