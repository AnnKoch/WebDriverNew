package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage {

    By searchResult = By.xpath("//*[@class='gs-title' and b='Google Cloud Platform Pricing Calculator']");
    public String pageName;

    private final static int WAIT_TIMEOUT_SECONDS = 15;
    WebDriver driver;
    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openCalculator() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(searchResult));
        pageName = driver.findElement(searchResult).getText();
        driver.findElement(searchResult).click();
    }

}
