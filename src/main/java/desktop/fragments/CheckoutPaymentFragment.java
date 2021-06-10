package desktop.fragments;

import abstractClasses.fragment.AbstractFragment;
import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static utils.WaitUtils.fWaitUntil;

@Data
public class CheckoutPaymentFragment  extends AbstractFragment {

    @FindBy(xpath = "put your locator expression here")
    private WebElement fragmentRootElement;

    @FindBy(xpath = "//div[@class=\"disabled-container\"]")
    private WebElement paymentDisabledContainer;

    @FindBy(xpath = "//button[@id=\"hasSubmittedSameAddresses\"]")
    private WebElement continueToPaymentButton;

    @FindBy(xpath = "//select[@id=\"brandSelected\"]")
    private WebElement cardTypeSelect;

    @FindBy(xpath = "//input[@id=\"visacardName\"]")
    private WebElement nameOnCardInput;

    @FindBy(xpath = "//input[@id=\"visacardNumber\"]")
    private WebElement cardNumberInput;

    @FindBy(xpath = "//select[@id=\"visacardValidToYear\"]")
    private WebElement expiryYearSelect;

    @FindBy(xpath = "//select[@id=\"visacardValidToMonth\"]")
    private WebElement expiryMonthSelect;

    @FindBy(xpath = "//input[@id=\"visacardCvv\"]")
    private WebElement cvvInput;

    @FindBy(xpath = "//iframe[@id=\"chase\"]")
    private WebElement paymentIframe;

    public CheckoutPaymentFragment() {
        setRootElement(fragmentRootElement);
    }

    public void switchToPaymentIframe() {
        switchToFrame(paymentIframe);
    }

    public void clickOnContinueToPayment() {
        moveToElementAndClick(continueToPaymentButton);
    }

    public void selectCardType(String cardType) {
        selectByText(cardTypeSelect, cardType);
    }

    public void inputNameOnCard(String nameOnCard) {
        elementHighlighter(nameOnCardInput);
        fWaitUntil(ExpectedConditions.visibilityOf(nameOnCardInput)).sendKeys(nameOnCard);
    }

    public void inputCardNumber(String cardNumber) {
        elementHighlighter(cardNumberInput);
        cardNumberInput.sendKeys(cardNumber);
    }

    public void selectExpiryYear(String expiryYear) {
        selectByText(expiryYearSelect, expiryYear);
    }

    public void selectExpiryMonth(String expiryMonth) {
        selectByText(expiryMonthSelect, expiryMonth);
    }

    public void inputCvv(String cvv) {
        elementHighlighter(cvvInput);
        cvvInput.sendKeys(cvv);
    }
}
