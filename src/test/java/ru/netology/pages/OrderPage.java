package ru.netology.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Поля формы
    private By nameField = By.cssSelector("[data-test-id='name'] input");
    private By phoneField = By.cssSelector("[data-test-id='phone'] input");
    private By agreementCheckbox = By.cssSelector("[data-test-id='agreement'] .checkbox__box");
    private By continueButton = By.cssSelector("button.button");

    // Сообщение об успешной отправке (по тексту, а не по классу!)
    private By successMessage = By.xpath("//*[contains(text(),'Ваша заявка успешно отправлена')]");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void fillName(String name) {
        WebElement nameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(nameField));
        nameInput.clear();
        nameInput.sendKeys(name);
    }

    public void fillPhone(String phone) {
        WebElement phoneInput = wait.until(ExpectedConditions.visibilityOfElementLocated(phoneField));
        phoneInput.clear();
        phoneInput.sendKeys(phone);
    }

    public void checkAgreement() {
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(agreementCheckbox));
        checkbox.click();
    }

    public void clickContinue() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        button.click();
    }

    public String getSuccessMessage() {
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        return message.getText().trim();
    }
}
