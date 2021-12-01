package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {
  private SelenideElement heading = $("[data-test-id=dashboard]");
  private SelenideElement firstCard = $("[data-test-id=\"92df3f1c-a033-48e6-8390-206f6b1f56c0\"]");
  private SelenideElement secondCard= $("[data-test-id=\"0f3f5c2a-249e-4c3d-8287-09f7a039391d\"]");

  public DashboardPage() {
    heading.shouldHave(text("Личный кабинет"));
    firstCard.shouldBe(visible).shouldHave(text("**** **** **** 0001"));
    secondCard.shouldBe(visible).shouldHave(text("**** **** **** 0002"));
    }

  public CheckBalancePage depositFirstCardNumber(DataHelper.CardInfo info) {
    $(".list__item [data-test-id=action-deposit]").click();
    $("[data-test-id=amount] input").setValue("100");
    $("[data-test-id=from] input").setValue(info.getCardNumber());
    $("[data-test-id=action-transfer]").click();
    return new CheckBalancePage();
  }

}
