package by.htp.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {
	public static final String URL = "https://mail.ru/";

	@FindBy(xpath = "//button[text()='Войти' and contains (@class,'ph-login')]")
	private WebElement enterButton;

	@FindBy(xpath = "//input[@name='username']")
	private WebElement accountNameField;

	@FindBy (xpath = "//span[text()='Enter password']")
	private WebElement enterPasswordButton;

	@FindBy (xpath = "//input[@name='password']")
	private WebElement passwordField;

	@FindBy (xpath = "//span[text()='Sign in']")
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





//	@FindBy(id = "mailbox__login")
//	private WebElement loginField;
//
//	@FindBy(id = "mailbox__password")
//	private WebElement passField;
//
//	@FindBy(id = "mailbox__auth__button")

//	private WebElement submit;

//	public MailBoxPage login(String login, String pass) {
//		loginField.sendKeys(login);
//		passField.sendKeys(pass);
//		submit.click();
//		return new MailBoxPage(driver);
//	}

	@Override
	public void waitForLoaded() {
	}
}