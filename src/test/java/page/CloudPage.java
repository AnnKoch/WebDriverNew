package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CloudPage {

    By searchButton = By.xpath("//*[@name='q']");
    By submitButton = By.xpath("//button[@type='submit']");
    private static final String HOMEPAGE_URL = "https://cloud.google.com/";
    private final int WAIT_TIMEOUT_SECONDS = 15;


    WebDriver driver;

    public CloudPage(WebDriver driver) {
        this.driver = driver;
    }
    public void openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
    }

    public void searchForCalculator(String searchInput) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        driver.findElement(searchButton).sendKeys(searchInput);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(submitButton));
        driver.findElement(submitButton).click();
    }
}