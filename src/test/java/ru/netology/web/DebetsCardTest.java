
package ru.netology.web;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DebetsCardTest {
    SelenideElement form = $("form");
    SelenideElement name = form.$("[data-test-id=name] input");
    SelenideElement phone = form.$("[data-test-id=phone] input");
    SelenideElement agreement = form.$("[data-test-id=agreement]");
    SelenideElement button = form.$("button");

    @BeforeEach
    void openHost() {
        open("http://localhost:9999");
    }


    @Test
    void PositiveTestFillingOutAnApplicationFormOnDebitCard() {
        name.setValue("Иванов Василий");
        phone.setValue("+79250000000");
        agreement.click();
        button.click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! " +
                "Наш менеджер свяжется с вами в ближайшее время."));
    }
}