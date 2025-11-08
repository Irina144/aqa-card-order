package ru.netology.tests;

import org.junit.jupiter.api.Test;
import ru.netology.base.TestBase;
import ru.netology.pages.OrderPage;

import static org.assertj.core.api.Assertions.assertThat;

public class CardOrderTest extends TestBase {

    @Test
    void shouldTestSuccess() {
        OrderPage orderPage = new OrderPage(driver);

        String name = "Иван Иванов";
        String phone = "+79270000000";

        orderPage.fillName(name);
        orderPage.fillPhone(phone);
        orderPage.checkAgreement();
        orderPage.clickContinue();

        String successText = orderPage.getSuccessMessage();
        assertThat(successText).contains("Ваша заявка успешно отправлена!");
    }
}
