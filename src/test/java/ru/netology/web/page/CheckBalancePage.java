package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CheckBalancePage {
    private SelenideElement heading = $("[data-test-id=dashboard]");
    private SelenideElement firstCard = $("[data-test-id=\"92df3f1c-a033-48e6-8390-206f6b1f56c0\"]");
    private SelenideElement secondCard = $("[data-test-id=\"0f3f5c2a-249e-4c3d-8287-09f7a039391d\"]");

    public CheckBalancePage() {
        heading.shouldHave(text("Личный кабинет"));
        firstCard.shouldBe(visible).shouldHave(text("**** **** **** 0001, баланс:"));
        secondCard.shouldBe(visible).shouldHave(text("**** **** **** 0002, баланс:"));
    }

}
