package by.htp.mailru_outbox;

import Lesson14.pages.MainPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.uncommons.reportng.HTMLReporter;

import java.util.concurrent.TimeUnit;

@Listeners({HTMLReporter.class})
public class BaseTest {

    private static final Logger LOG = Logger.getLogger(BaseTest.class);
    protected WebDriver driver;

    @BeforeClass
    public WebDriver startBrowser() {
        LOG.warn("start, 'startBrowser'");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        LOG.warn("finish, 'startBrowser'");
        return driver;
    }

    protected MainPage navigate(String url) {
        LOG.info("start, 'navigate;");
        driver.get(url);
        LOG.info("finish, 'navigate;");
        return new MainPage(driver);
    }
}
