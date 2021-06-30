package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.CloudPage;
import page.PricingCalculatorPage;
import page.SearchResultsPage;

public class HurtMePlenty {

    public WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "Hurt Me Plenty")
    public void calculateCloud ()  {
        CloudPage mainPage = new CloudPage(driver);
        SearchResultsPage resultsPage = new SearchResultsPage(driver);
        PricingCalculatorPage calculatorPage = new PricingCalculatorPage(driver);

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
        calculatorPage.scrollDown();
        calculatorPage.chooseSSD();
        calculatorPage.scrollDown();
        calculatorPage.chooseDataCenterLocation();
        calculatorPage.chooseCommittedUsage();
        calculatorPage.addToEstimate();

        WebElement vmClassActual = driver.findElement(By.xpath("//*[contains(text(),'VM class:')]"));
        WebElement instanceTypeActual = driver.findElement(By.xpath("//*[contains(text(),'Instance type:')]"));
        WebElement regionActual = driver.findElement(By.xpath("//*[contains(text(),'Region:')]"));
        WebElement localSSDActual = driver.findElement(By.xpath("//*[contains(text(),'Total available local SSD space')]"));
        WebElement commitmentTermActual = driver.findElement(By.xpath("//*[contains(text(),'Commitment term:')]"));
        WebElement estimatedCostActual = driver.findElement(By.xpath("//*[contains(text(),'Total Estimated Cost:')]"));


        Assert.assertEquals(vmClassActual.getText(), "VM class: regular", "VM class doesn't match");
        Assert.assertEquals(instanceTypeActual.getText(), "Instance type: n1-standard-8", "Instance type doesn't match");
        Assert.assertEquals(regionActual.getText(), "Region: Frankfurt", "Region doesn't match");
        Assert.assertEquals(localSSDActual.getText(), "Total available local SSD space 2x375 GiB", "SSD type doesn't match");
        Assert.assertEquals(commitmentTermActual.getText(), "Commitment term: 1 Year", "Commitment term doesn't match");
        Assert.assertEquals(estimatedCostActual.getText(), "Total Estimated Cost: USD 1,082.77 per 1 month", "Total cost doesn't match");
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
