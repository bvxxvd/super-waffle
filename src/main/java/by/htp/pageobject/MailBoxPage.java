package by.htp.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailBoxPage extends BasePage {

    @FindBy(xpath = "//span[text()='Написать письмо']")
    private WebElement composeLetter;

    @FindBy(xpath = "//div[contains(@class, 'head_container')]//input")
    private WebElement toWhomField;

    @FindBy(xpath = "//div[contains(@class, 'subject__container')]//input")
    private WebElement subjectField;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div[1]/div[2]/div[3]/div[5]/div/div/div[2]/div[1]/div[1]")
    private WebElement textField;

    @FindBy(xpath = "//span[text()='Отправить']")
    private WebElement sendButton;

    public void sendEmail(String toStr, String topicStr, String textStr) {
        composeLetter.click();
        toWhomField.sendKeys(toStr);
        subjectField.sendKeys(topicStr);
        textField.sendKeys(textStr);
        sendButton.click();
    }



    public MailBoxPage(WebDriver driver) {
        super(driver);
    }

    public String waitForMyEmail(String emailText) {
        WebDriverWait wait = new WebDriverWait(driver, 1000);
        String xpathExpression = "//div[@id='b-letters']//span[contains(text(),'" + emailText + "')]";
        wait.until(ExpectedConditions.textToBe(By.xpath(xpathExpression), emailText));
        WebElement mail = getDriver().findElement(By.xpath(xpathExpression));
        return mail.getText();
    }
}