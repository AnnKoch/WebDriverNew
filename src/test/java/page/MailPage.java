package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailPage {

    private final static int WAIT_TIMEOUT_SECONDS = 15;
    private static final String TEN_MINUTES_MAIL_URL = "https://10mail.org/";
    public static String emailValue;
    public static String monthlyCost;
    private final By email = By.xpath("//*[@class='address']");
    private final By HTMLTypeButton = By.xpath("//*[@class='bi-image']");
    private final By actualTotalMonthlyCostValue = By.xpath("//h3[contains(text(),'USD')]");

    WebDriver driver;

    public MailPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get(TEN_MINUTES_MAIL_URL);
    }
    public void saveEmail(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(email));
        emailValue = driver.findElement(email).getText();
    }
    public void verifyEmail() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(HTMLTypeButton));
        driver.findElement(HTMLTypeButton).click();
        WebElement HTMLFrame = driver.findElement(By.xpath("//iframe[@class='mail-clean-html']"));
        driver.switchTo().frame(HTMLFrame);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(actualTotalMonthlyCostValue));
        monthlyCost = driver.findElement(actualTotalMonthlyCostValue).getText();
    }
}