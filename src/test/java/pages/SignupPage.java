package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignupPage {

    WebDriver driver;
    WebDriverWait wait;

    // === Locators ===
    private By firstName = By.id("firstname");
    private By lastName = By.id("lastname");
    private By email = By.id("email_address");
    private By password = By.id("password");
    private By confirmPassword = By.id("password-confirmation");
    private By createAccountButton = By.cssSelector("button[title='Create an Account']");

    // === Constructor ===
    public SignupPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Wait up to 10 seconds
    }

    // === Actions with Waits ===
    public void enterFirstName(String fname) {
        WebElement first = wait.until(ExpectedConditions.visibilityOfElementLocated(firstName));
        first.sendKeys(fname);
    }

    public void enterLastName(String lname) {
        WebElement last = wait.until(ExpectedConditions.visibilityOfElementLocated(lastName));
        last.sendKeys(lname);
    }

    public void enterEmail(String emailId) {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(email));
        emailField.sendKeys(emailId);
    }

    public void enterPassword(String pwd) {
        WebElement pwdField = wait.until(ExpectedConditions.visibilityOfElementLocated(password));
        WebElement confirmPwd = wait.until(ExpectedConditions.visibilityOfElementLocated(confirmPassword));
        pwdField.sendKeys(pwd);
        confirmPwd.sendKeys(pwd);
    }

    public void clickCreateAccount() {
        WebElement createAccountBtn = driver.findElement(By.cssSelector("button[title='Create an Account']"));

        // Scroll into view and click using JS
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", createAccountBtn);
        js.executeScript("arguments[0].click();", createAccountBtn);
    }
}
