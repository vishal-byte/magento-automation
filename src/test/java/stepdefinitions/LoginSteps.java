package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import utils.SharedTestData;

public class LoginSteps {
    WebDriver driver;
    LoginPage loginPage;

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/customer/account/login/");
    }

    @When("I login using the credentials from signup")
    public void i_login_with_signup_credentials() {
        loginPage = new LoginPage(driver);
        loginPage.enterEmail(SharedTestData.email);
        loginPage.enterPassword(SharedTestData.password);
        loginPage.clickLogin();
    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        // You can verify login success via page content or logout link
    }

    @And("I close the browser after login")
    public void i_close_the_browser_after_login() {
        driver.quit();
    }
}
