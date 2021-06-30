package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.NewPaste;
import page.MainPagePasteBin;

import static page.NewPaste.PageTitle;
import static page.NewPaste.PasteDescription;

public class ICanWin {

        public WebDriver driver;

        @BeforeMethod(alwaysRun = true)
        public void browserSetup() {
            driver = new ChromeDriver();
        }

        @Test(description = "I can win")
        public void creatingNewPaste () {
            MainPagePasteBin mainPage = new MainPagePasteBin(driver);
            NewPaste createPastePage = new NewPaste(driver);

            mainPage.openPage();
            mainPage.enterPasteDescription("Hello from WebDriver");
            mainPage.choose10MinutesExpiration();
            mainPage.enterPasteName("helloweb");
            mainPage.createPaste();
            createPastePage.pasteTitle();
            createPastePage.pasteDescription();

            Assert.assertEquals(PageTitle, "helloweb - Pastebin.com", "Title does not match" );
            Assert.assertEquals(PasteDescription, "Hello from WebDriver", "Text does not match!");
        }

        @AfterMethod(alwaysRun = true)
        public void browserTearDown() {
            driver.quit();
            driver = null;
        }
    }
