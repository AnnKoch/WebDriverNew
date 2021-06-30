package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static page.MailPage.emailValue;

public class PricingCalculatorPage {

    private final By computeEngineButton = By.xpath("//div[@title='Compute Engine' and @class='tab-holder compute']");
    private final By numberOfInstances = By.id("input_65");
    private final By OSDropDown = By.id("select_value_label_58");
    private final By freeOSChoice = By.id("select_option_67");
    private final By machineClassDropDown = By.id("select_value_label_59");
    private final By regularMachineChoice = By.id("select_option_79");
    private final By seriesDropDown = By.xpath("//*[@id='select_value_label_61']");
    private final By seriesChoice = By.xpath("//*[@id='select_option_194']");
    private final By machineTypeDropDown = By.id("select_value_label_62");
    private final By machineTypeChoice = By.id("select_option_381");
    private final By addGPUCheckBox = By.xpath("//*[contains(text(),'Add GPUs.')]");
    private final By numberOfGPUDropDown = By.id("select_value_label_413");
    private final By GPUChoice = By.id("select_option_420");
    private final By GPUTypeDropDown = By.id("select_value_label_414");
    private final By GPUTypeChoice = By.xpath("//div[contains(text(), 'NVIDIA Tesla V100')]");
    private final By SSDDropDown = By.id("select_value_label_375");
    private final By SSDChoice = By.id("select_option_402");
    private final By dataCenterLocationDropDown = By.id("select_value_label_63");
    private final By dataCenterLocationChoice = By.id("select_option_211");
    private final By committedUsageDropDown = By.id("select_value_label_64");
    private final By committedUsageChoice = By.id("select_option_98");
    private final By addToEstimateButton = By.xpath("//*[@class='md-raised md-primary cpc-button md-button md-ink-ripple']");
    private final By emailEstimateButton = By.id("email_quote");
    private final By emailField = By.id("input_498");
    private final By sendEmailButton = By.xpath("//button[contains(text(), 'Send Email')]");

    private final static int WAIT_TIMEOUT_SECONDS = 20;
    WebDriver driver;
    public PricingCalculatorPage(WebDriver driver) {
        this.driver = driver;
    }

    private JavascriptExecutor getExecutor() {
        return (JavascriptExecutor)this.driver;
    }

    private void scrollToId(String id) {
        String script = String.format("document.getElementById('%s').scrollIntoView();", id);
        getExecutor().executeScript(script);
    }

    public void chooseComputeEngine() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(computeEngineButton));
        driver.findElement(computeEngineButton).click();
    }

    public void enterNumberOfInstances (String instancesNumber){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(numberOfInstances));
        driver.findElement(numberOfInstances).sendKeys(instancesNumber);
    }

    public void chooseOS () {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(OSDropDown));
        driver.findElement(OSDropDown).click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(freeOSChoice));
        driver.findElement(freeOSChoice).click();
    }

    public void chooseMachineClass(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(machineClassDropDown));
        driver.findElement(machineClassDropDown).click();
        new WebDriverWait (driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(regularMachineChoice));
        driver.findElement(regularMachineChoice).click();
    }

    public void chooseSeries(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(seriesDropDown));
        driver.findElement(seriesDropDown).click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(seriesChoice));
        driver.findElement(seriesChoice).click();
    }

    public void chooseMachineType(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(machineTypeDropDown));
//        scrollToId("select_value_label_194");
        driver.findElement(machineTypeDropDown).click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(machineTypeChoice));
        driver.findElement(machineTypeChoice).click();
    }

    public void chooseGPU() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(addGPUCheckBox));
        driver.findElement(addGPUCheckBox).click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(numberOfGPUDropDown));
        driver.findElement(numberOfGPUDropDown).click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(GPUChoice));
        driver.findElement(GPUChoice).click();
        driver.findElement(GPUTypeDropDown).click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(GPUTypeChoice));
        driver.findElement(GPUTypeChoice).click();
    }
    public void chooseSSD(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(SSDDropDown));
        driver.findElement(SSDDropDown).click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(SSDChoice));
        driver.findElement(SSDChoice).click();
    }
    public void chooseDataCenterLocation(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(dataCenterLocationDropDown));
        driver.findElement(dataCenterLocationDropDown).click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(dataCenterLocationChoice));
        driver.findElement(dataCenterLocationChoice).click();
    }
    public void chooseCommittedUsage(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(committedUsageDropDown));
        driver.findElement(committedUsageDropDown).click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(committedUsageChoice));
        driver.findElement(committedUsageChoice).click();
    }

    public void scrollDown(){
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.ARROW_DOWN);

    }

    public void addToEstimate(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(addToEstimateButton));
                driver.findElements(addToEstimateButton)
                        .get(0).click();
    }
    public void addEmailEstimation(){
        new WebDriverWait (driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(emailEstimateButton));
        driver.findElement(emailEstimateButton).click();
    }
    public void enterEmailValue(){
        driver.findElement(emailField).sendKeys(emailValue);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(sendEmailButton));
        driver.findElement(sendEmailButton).click();
    }
}
