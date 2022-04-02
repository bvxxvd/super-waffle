package Lesson14.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {
    public static final String URL = "https://mail.ru/";

    @FindBy(xpath = "//button[text()='Войти' and contains (@class,'ph-login')]")
    private WebElement enterButton;

    @FindBy(xpath = "//input[@name='username']")
    private WebElement accountNameField;

    @FindBy(xpath = "//span[text()='Enter password']")
    private WebElement enterPasswordButton;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//span[text()='Sign in']")
    private WebElement signInButton;

    public MailBoxPage login(String login, String password) {
        enterButton.click();

        driver.switchTo().frame(15);
        accountNameField.sendKeys(login);
        enterPasswordButton.click();
        passwordField.sendKeys(password);
        signInButton.click();
        driver.switchTo().defaultContent();
        return new MailBoxPage(driver);
    }

    public MainPage(WebDriver driver) {
        super(driver);
    }
}
