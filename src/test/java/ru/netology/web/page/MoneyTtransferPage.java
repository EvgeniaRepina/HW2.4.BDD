package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;
import lombok.val;
import org.openqa.selenium.Keys;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MoneyTtransferPage {
    private SelenideElement heading = $("[data-test-id=dashboard]");
    private SelenideElement firstCard = $("[data-test-id=\"92df3f1c-a033-48e6-8390-206f6b1f56c0\"]");
    private SelenideElement secondCard = $("[data-test-id=\"0f3f5c2a-249e-4c3d-8287-09f7a039391d\"]");


    public MoneyTtransferPage() {
        heading.shouldHave(text("Личный кабинет"));
        firstCard.shouldBe(visible).shouldHave(text("**** **** **** 0001, баланс:"));
        secondCard.shouldBe(visible).shouldHave(text("**** **** **** 0002, баланс:"));
    }


    public static MoneyTtransferPage depositFirstCard(DataHelper.CardInfo info, String amount) {
        $(".list__item [data-test-id=action-deposit]").click();
        $("[data-test-id=amount] input").sendKeys(Keys.CONTROL, "A");
        $("[data-test-id=amount] input").sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=amount] input").setValue(amount);
        $("[data-test-id=from] input").click();
        $("[data-test-id=from] input").sendKeys(Keys.CONTROL, "A");
        $("[data-test-id=from] input").sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=from] input").setValue(info.getCardNumber());
        $("[data-test-id=action-transfer]").click();
        return new MoneyTtransferPage();
    }

    public static MoneyTtransferPage depositFirstCardByBalance(DataHelper.CardInfo info) {

        String balance = String.valueOf(DashboardPage.getCardBalance(DataHelper.getSecondCardId()));

        $(".list__item [data-test-id=action-deposit]").click();
        $("[data-test-id=amount] input").sendKeys(Keys.CONTROL, "A");
        $("[data-test-id=amount] input").sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=amount] input").setValue(balance);
        $("[data-test-id=from] input").click();
        $("[data-test-id=from] input").sendKeys(Keys.CONTROL, "A");
        $("[data-test-id=from] input").sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=from] input").setValue(info.getCardNumber());
        $("[data-test-id=action-transfer]").click();
        return new MoneyTtransferPage();
    }

    public static MoneyTtransferPage depositSecondCard(DataHelper.CardInfo info, String amount) {
        $("[data-test-id=\"0f3f5c2a-249e-4c3d-8287-09f7a039391d\"] button").click();
        $("[data-test-id=amount] input").sendKeys(Keys.CONTROL, "A");
        $("[data-test-id=amount] input").sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=amount] input").setValue(amount);
        $("[data-test-id=from] input").click();
        $("[data-test-id=from] input").sendKeys(Keys.CONTROL, "A");
        $("[data-test-id=from] input").sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=from] input").setValue(info.getCardNumber());
        $("[data-test-id=action-transfer]").click();
        return new MoneyTtransferPage();
    }

    public static MoneyTtransferPage depositSecondCardByBalance(DataHelper.CardInfo info) {

        String balance = String.valueOf(DashboardPage.getCardBalance(DataHelper.getFirstCardId()));

        $("[data-test-id=\"0f3f5c2a-249e-4c3d-8287-09f7a039391d\"] button").click();
        $("[data-test-id=amount] input").sendKeys(Keys.CONTROL, "A");
        $("[data-test-id=amount] input").sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=amount] input").setValue(balance);
        $("[data-test-id=from] input").click();
        $("[data-test-id=from] input").sendKeys(Keys.CONTROL, "A");
        $("[data-test-id=from] input").sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=from] input").setValue(info.getCardNumber());
        $("[data-test-id=action-transfer]").click();
        return new MoneyTtransferPage();
    }

}
