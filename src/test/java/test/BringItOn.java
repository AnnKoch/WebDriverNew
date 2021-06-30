package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.MainPagePasteBin;
import page.NewPaste;
import static page.NewPaste.*;

public class BringItOn {

        public WebDriver driver;

        @BeforeMethod(alwaysRun = true)
        public void browserSetup() {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }

        @Test(description = "Bring It On")
        public void creatingNewPaste () {
            MainPagePasteBin mainPage = new MainPagePasteBin(driver);
            NewPaste createPastePage = new NewPaste(driver);

            mainPage.openPage();
            mainPage.enterPasteDescription("git config --global user.name  \"New Sheriff in Town\"\n" +
                    "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                    "git push origin master --force");
            mainPage.choose10MinutesExpiration();
            mainPage.enterPasteName("how to gain dominance among developers");
            mainPage.chooseBash();
            mainPage.createPaste();

            createPastePage.pasteTitle();
            createPastePage.pasteDescription();
            createPastePage.checkBash();

            Assert.assertEquals(PageTitle, "how to gain dominance among developers - Pastebin.com", "Title does not match");
            Assert.assertEquals(PasteDescription,
                    "git config --global user.name  \"New Sheriff in Town\"\n" +
                    "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                    "git push origin master --force", "Code does not match");
            Assert.assertEquals(bashLabel.getText(), "Bash", "Does not contain Bash");
        }

        @AfterMethod(alwaysRun = true)
        public void browserTearDown() {
            driver.quit();
            driver = null;
        }
    }
