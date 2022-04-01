package by.htp.mailru_outbox;

import static org.testng.Assert.assertTrue;

import java.util.Date;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import by.htp.pageobject.MailBoxPage;
import by.htp.pageobject.MainPage;

public class LoginTest extends BaseTest {

    private static final Logger LOG = Logger.getLogger(LoginTest.class);
    @Test
    public void doLogin() {

        LOG.warn("start: navigate");
        MainPage mainPage = navigate(MainPage.URL);
        LOG.warn("start: login");
        LOG.info("enter: daniel_defo@internet.ru  iiYiYyoPM31;");
        MailBoxPage mailBox = mainPage.login("daniel_defo@internet.ru", "iiYiYyoPM31;");

        // дальше не работает

//        driver.switchTo().defaultContent();

        LOG.info("send Email;");
        mailBox.sendEmail("daniel_defo@internet.ru", "Interesting topic", "EMAIL_TEXT");

//		LOG.info("check Email;");
//
//		String titleEmail = mailBoxCheck.waitForMyEmail(EMAIL_TEXT);
//		assertTrue(titleEmail.contains(EMAIL_TEXT));
//		LOG.info("check OK;");
        closeBrowser();
    }
}