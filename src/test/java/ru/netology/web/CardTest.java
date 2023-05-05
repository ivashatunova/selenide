package ru.netology.web;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class CardTest {


    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    LocalDateTime now = LocalDateTime.now();
    LocalDateTime next = now.plusDays(5);
    String data = dtf.format(next);


    @Test
    void shouldSendForm() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
        $("[data-test-id='city'] .input__control").setValue("Казань");
        $("[data-test-id='date'] .input__control").click();
        for (int i = 0; i < 10; i++) {
            $("[data-test-id='date'] .input__control").sendKeys(Keys.BACK_SPACE);
        }
        $("[data-test-id='date'] .input__control").setValue(data);
        $("[data-test-id='name'] .input__control").setValue("Шатунова Иванна");
        $("[data-test-id='phone'] .input__control").setValue("+79168580321");
        $("[data-test-id='agreement'] .checkbox__box").click();
        $("button .button__text").click();
        $x("//div[contains(text(), 'Успешно')]").shouldBe(Condition.visible, Duration.ofSeconds(15));

    }

    @Test
    void shouldSendWhenСhooseСity() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
        $("[data-test-id='city'] .input__control").setValue("Ка");
        $x("//span[contains(text(), 'Казань')]").click();
        $("[data-test-id='date'] .input__control").click();
        for (int i = 0; i < 10; i++) {
            $("[data-test-id='date'] .input__control").sendKeys(Keys.BACK_SPACE);
        }
        $("[data-test-id='date'] .input__control").setValue(data);
        $("[data-test-id='name'] .input__control").setValue("Шатунова Иванна");
        $("[data-test-id='phone'] .input__control").setValue("+79168580321");
        $("[data-test-id='agreement'] .checkbox__box").click();
        $("button .button__text").click();
        $x("//div[contains(text(), 'Успешно')]").shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    @Test
    void shouldSendWhenСhooseDate() {
        Configuration.holdBrowserOpen = true;
        int day = now.plusDays(7).getDayOfMonth();
        open("http://localhost:9999");
        $("[data-test-id='city'] .input__control").setValue("Казань");
        $("[data-test-id='date'] .icon_name_calendar").click();
        $("[data-test-id='date'] .icon_name_calendar").click();
        if (!now.plusDays(7).getMonth().equals(now.getMonth())) {
            $("[data-step='1']").click();
        }
        $x("//td[contains(text(), '" + day + "')]").click();
        $("[data-test-id='name'] .input__control").setValue("Шатунова Иванна");
        $("[data-test-id='phone'] .input__control").setValue("+79168580321");
        $("[data-test-id='agreement'] .checkbox__box").click();
        $("button .button__text").click();
        $x("//div[contains(text(), 'Успешно')]").shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

}
