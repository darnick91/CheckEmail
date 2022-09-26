package pages;

import lombok.Getter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

    @Getter
    public class UkrNetMail extends BasePage {

        @FindBy(xpath = "//input[@type='text']")
        private WebElement mailInputField;

        @FindBy(xpath = "//input[@name='password']")
        private WebElement passwordInputField;

        @FindBy(xpath = "//button[@class='button primary compose']")
        private WebElement mailButton;

        @FindBy(name = "toFieldInput")
        private WebElement addressToFieldInput;

        @FindBy(xpath = "//input[@name='subject']")
        private WebElement mailTopic;

        @FindBy(css = "#mceu_33")
        private WebElement textMailFieldInput;

        @FindBy(xpath = "//*[@id=\"screens\"]/div/div[2]/div/button[1]")
        private WebElement sendMailButton;

        @FindBy(xpath = "//a[@class='link3']")
        private WebElement linkOfMassage;

        @FindBy(xpath = "//em[contains(text(), 'testmailepam2@ukr.net')]")
        private WebElement validateMassage;

        @FindBy(id = "msg16642178580553055160")
        private WebElement receivedMail;

        public UkrNetMail(WebDriver driver) {
            super(driver);
        }

        public UkrNetMail inputMailAddress(String address) {
            mailInputField.sendKeys(address, Keys.TAB);
            waitForVisibilityOfElement(WAIT_TIME, passwordInputField);
            return this;
        }

        public UkrNetMail inputPassword(String address) {
            passwordInputField.sendKeys(address, Keys.ENTER);
            waitForVisibilityOfElement(WAIT_TIME, mailButton);
            return this;
        }

        public UkrNetMail writeMailButtonClick() {
            mailButton.click();
            waitForVisibilityOfElement(WAIT_TIME, addressToFieldInput);
            return this;
        }

        public void writeMail(String addressTo, String text) {
            addressToFieldInput.sendKeys(addressTo);
            mailTopic.sendKeys("1");
            textMailFieldInput.sendKeys(text);
            sendMailButton.click();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        public boolean checkMassageReceived() {
            linkOfMassage.click();
            return validateMassage.isDisplayed();
        }

}
