package fb_scraper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GlPageScraper {

    private static final String GL_FB_PAGE = "https://www.facebook.com/LoodIsGood";
    private static final String DRIVER_PATH = "C:\\Program Files\\chromedriver.exe";


    public GlPageScraper() {
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
    }

    public void scrapFlavours() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            driver.get(GL_FB_PAGE);

            //wait until agree button appears and click it
            WebDriverWait driverWait = new WebDriverWait(driver, 10);
            WebElement agreeButton = driverWait.until(ExpectedConditions
                    .elementToBeClickable(By.id("u_0_22")));
            agreeButton.click();

            driver.findElement(By.id("jsc_c_1i")); //errors
        } finally {
            driver.close();
        }
    }

}
