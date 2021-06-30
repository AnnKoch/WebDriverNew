package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;

public class MainPagePasteBin {

    private final By pasteArea = By.id("postform-text");
    private final By pasteExpDropDwn = By.id("select2-postform-expiration-container");
    private final By tenMinutes = By.xpath("//li[text()='10 Minutes']");
    private final By pasteName = By.id("postform-name");
    private final By syntaxHighlightingDropDwn = By.id("select2-postform-format-container");
    private final By createPasteBtn = By.xpath("//button[@class='btn -big']");
    private final By bashChoice = By.xpath("//li[text()='Bash']");
    private final int WAIT_TIMEOUT_SECONDS = 15;
    private static final String HOMEPAGE_URL = "https://pastebin.com";

    WebDriver driver;
    public MainPagePasteBin(WebDriver driver) {
        this.driver=driver;
    }

    public void openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
    }
    public void enterPasteDescription(String Description) {
        driver.findElement(pasteArea).sendKeys(Description);
    }
    public void enterPasteName(String NameOfThePaste){
        driver.findElement(pasteName).sendKeys(NameOfThePaste);
    }
    public void choose10MinutesExpiration() {
        driver.findElement(pasteExpDropDwn).click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(tenMinutes));
        driver.findElement(tenMinutes).click();
    }
    public void chooseBash() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(syntaxHighlightingDropDwn));
        driver.findElement(syntaxHighlightingDropDwn).click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(bashChoice));
        driver.findElement(bashChoice).click();
    }
    public void createPaste() {
        driver.findElement(createPasteBtn).click();
    }
}