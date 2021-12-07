package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;
import lombok.Value;
import lombok.val;
import org.openqa.selenium.Keys;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {
    private SelenideElement heading = $("[data-test-id=dashboard]");
    private SelenideElement firstCard = $("[data-test-id=\"92df3f1c-a033-48e6-8390-206f6b1f56c0\"]");
    private SelenideElement secondCard = $("[data-test-id=\"0f3f5c2a-249e-4c3d-8287-09f7a039391d\"]");

    public DashboardPage() {
        heading.shouldHave(text("Личный кабинет"));
        firstCard.shouldBe(visible).shouldHave(text("**** **** **** 0001, баланс:"));
        secondCard.shouldBe(visible).shouldHave(text("**** **** **** 0002, баланс:"));
    }

    private static final String balanceStart = "баланс: ";
    private static final String balanceFinish = " р.";

    public static int getCardBalance(String id) {
        String text = $(id).getText();
        return extractBalance(text);
    }

    private static int extractBalance(String text) {
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }
    public static MoneyTtransferPage clickSecondCard() {
        $("[data-test-id=\"0f3f5c2a-249e-4c3d-8287-09f7a039391d\"] button").click();
        return new MoneyTtransferPage();
    }
    public static MoneyTtransferPage clickFirstCard() {
        $(".list__item [data-test-id=action-deposit]").click();
        return new MoneyTtransferPage();
    }
}
