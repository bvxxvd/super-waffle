package by.htp.mailru_outbox;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import Lesson14.pages.MailBoxPage;
import Lesson14.pages.MainPage;

public class LoginTest extends BaseTest {

    private static final Logger LOG = Logger.getLogger(LoginTest.class);

    @Test
    public void doLogin() {

        LOG.warn("start: navigate");
        MainPage mainPage = navigate(MainPage.URL);

        LOG.warn("start: login");
        LOG.info("enter: daniel_defo@internet.ru  iiYiYyoPM31;");
        MailBoxPage mailBox = mainPage.login("daniel_defo@internet.ru", "iiYiYyoPM31;");

        LOG.info("send Email;");
        mailBox.sendEmail("daniel_defo@internet.ru", "Interesting topic", "EMAIL_TEXT");

        LOG.info("check Email;");
        String titleEmail = mailBox.waitForEmail("Interesting topic");
        assertTrue(titleEmail.contains("Interesting topic"));

        LOG.info("check OK;");
    }
}