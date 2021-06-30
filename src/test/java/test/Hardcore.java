package test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.CloudPage;
import page.PricingCalculatorPage;
import page.SearchResultsPage;
import page.MailPage;
import java.util.ArrayList;

import static page.MailPage.monthlyCost;

public class Hardcore {
    public WebDriver driver;
    private JavascriptExecutor getExecutor() {
        return (JavascriptExecutor)this.driver;
    }


    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();

    }

    @Test(description = "Hardcore")
    public void calculateCloud (){
        CloudPage mainPage = new CloudPage(driver);
        SearchResultsPage resultsPage = new SearchResultsPage(driver);
        PricingCalculatorPage calculatorPage = new PricingCalculatorPage(driver);
        MailPage tenMinutesMailPage = new MailPage(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        mainPage.openPage();
        mainPage.searchForCalculator("Google Cloud Platform Pricing Calculator");
        resultsPage.openCalculator();
        new WebDriverWait(driver, 20);
        driver.switchTo().frame(0);
        driver.switchTo().frame("myFrame");
        calculatorPage.chooseComputeEngine();
        calculatorPage.chooseOS();
        calculatorPage.enterNumberOfInstances("4");
        calculatorPage.chooseMachineClass();
        calculatorPage.scrollDown();
        calculatorPage.chooseSeries();
        calculatorPage.chooseMachineType();
        calculatorPage.scrollDown();
        calculatorPage.chooseGPU();
        calculatorPage.chooseSSD();
        calculatorPage.scrollDown();
        calculatorPage.scrollDown();
        calculatorPage.chooseDataCenterLocation();
        calculatorPage.chooseCommittedUsage();
        calculatorPage.addToEstimate();
        calculatorPage.addEmailEstimation();

        js.executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        new WebDriverWait(driver, 3);
        driver.switchTo().window(tabs.get(1));
        tenMinutesMailPage.openPage();
        tenMinutesMailPage.saveEmail();
        driver.switchTo().window(tabs.get(0));
        calculatorPage.scrollDown();
        calculatorPage.scrollDown();
        calculatorPage.scrollDown();
        calculatorPage.scrollDown();
        calculatorPage.scrollDown();
        calculatorPage.scrollDown();
        calculatorPage.scrollDown();

        driver.switchTo().frame(0);
        driver.switchTo().frame("myFrame");
        calculatorPage.enterEmailValue();
        driver.switchTo().window(tabs.get(1));
        tenMinutesMailPage.verifyEmail();

        Assert.assertEquals(monthlyCost, "USD 1,082.77", "Total Cost doesn't match");
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}

