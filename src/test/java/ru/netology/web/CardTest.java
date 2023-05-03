package ru.netology.web;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class CardTest {
    @Test
    void shouldSendForm() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
        $("[data-test-id='city'] .input__control").setValue("Казань");
        $("[data-test-id='date'] .input__control").setValue("05.07.2023");
        $("[data-test-id='name'] .input__control").setValue("Шатунова Иванна");
        $("[data-test-id='phone'] .input__control").setValue("+79168580321");
        $("[data-test-id='agreement'] .checkbox__box").click();
        $("button .button__text").click();
        $x("//div[contains(text(), 'Успешно')]").shouldBe(Condition.visible, Duration.ofSeconds(15));








    }
}
