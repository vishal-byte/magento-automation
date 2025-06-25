package pages;

import org.openqa.selenium.By;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignupPage {
    WebDriver driver;
    WebDriverWait wait;

    public SignupPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public void enterFirstName(String firstName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstname"))).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(By.id("lastname")).sendKeys(lastName);
    }

    public void enterEmail(String email) {
        driver.findElement(By.id("email_address")).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        driver.findElement(By.id("password-confirmation")).sendKeys(confirmPassword);
    }

    public void clickCreateAccount() {
        WebElement createAccountBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[title='Create an Account']")));

        // Scroll into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", createAccountBtn);

        // Add a small wait to allow UI to settle
        try {
            Thread.sleep(500); // Not ideal in production, but helps in unstable UI
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Click via JavaScript
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", createAccountBtn);
    }

}
