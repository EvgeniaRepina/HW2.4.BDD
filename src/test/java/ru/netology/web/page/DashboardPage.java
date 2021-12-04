package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;
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
    String value;

    public DashboardPage() {
        heading.shouldHave(text("Личный кабинет"));
        firstCard.shouldBe(visible).shouldHave(text("**** **** **** 0001, баланс:"));
        secondCard.shouldBe(visible).shouldHave(text("**** **** **** 0002, баланс:"));
    }

    public void setValue(String value) {
        this.value = value;
    }

    public CheckBalancePage depositFirstCard(DataHelper.CardInfo info) {
        $(".list__item [data-test-id=action-deposit]").click();
        $("[data-test-id=amount] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=amount] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=amount] input").setValue(value);
        $("[data-test-id=from] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=from] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=from] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=from] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=from] input").setValue(info.getCardNumber());
        $("[data-test-id=action-transfer]").click();
        return new CheckBalancePage();
    }

    public CheckBalancePage depositFirstCardByBalance(DataHelper.CardInfo info) {

        String balance = String.valueOf(getCardBalance("[data-test-id=\"0f3f5c2a-249e-4c3d-8287-09f7a039391d\"]"));

        $(".list__item [data-test-id=action-deposit]").click();
        $("[data-test-id=amount] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=amount] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=amount] input").setValue(balance);
        $("[data-test-id=from] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=from] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=from] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=from] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=from] input").setValue(info.getCardNumber());
        $("[data-test-id=action-transfer]").click();
        return new CheckBalancePage();
    }

    public CheckBalancePage depositSecondCard(DataHelper.CardInfo info) {
        $("[data-test-id=\"0f3f5c2a-249e-4c3d-8287-09f7a039391d\"] button").click();
        $("[data-test-id=amount] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=amount] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=amount] input").setValue(value);
        $("[data-test-id=from] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=from] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=from] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=from] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=from] input").setValue(info.getCardNumber());
        $("[data-test-id=action-transfer]").click();
        return new CheckBalancePage();
    }

    public CheckBalancePage depositSecondCardByBalance(DataHelper.CardInfo info) {

        String balance = String.valueOf(getCardBalance("[data-test-id=\"92df3f1c-a033-48e6-8390-206f6b1f56c0\"]"));

        $("[data-test-id=\"0f3f5c2a-249e-4c3d-8287-09f7a039391d\"] button").click();
        $("[data-test-id=amount] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=amount] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=amount] input").setValue(balance);
        $("[data-test-id=from] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=from] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=from] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=from] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=from] input").setValue(info.getCardNumber());
        $("[data-test-id=action-transfer]").click();
        return new CheckBalancePage();
    }

    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";

    public int getCardBalance(String id) {
        String text = $(id).getText();
        return extractBalance(text);
    }

    private int extractBalance(String text) {
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }
}
