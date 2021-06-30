package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;

public class NewPaste {

    public static String PageTitle;
    public static String PasteDescription;
    public static WebElement bashLabel;
    private static final int WAIT_TIMEOUT_SECONDS = 15;
    private static final By pasteTitle = By.xpath("//h1");

    WebDriver driver;

    public NewPaste(WebDriver driver) {
        this.driver=driver;
    }
    public final void pasteTitle() {
        System.out.println("Verifying paste properties...");
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(pasteTitle));
        PageTitle = driver.getTitle();
    }
    public final void pasteDescription() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        PasteDescription = driver.findElement(By.xpath("//textarea")).getText();
    }
    public final void checkBash(){
        new WebDriverWait (driver, WAIT_TIMEOUT_SECONDS);
        bashLabel = driver.findElement(By.xpath("//a[contains(text(), 'Bash')]"));
        bashLabel.getText();
        System.out.println("Bash label found!");
    }
}