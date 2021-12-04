package ru.netology.web.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.data.DataHelper.PreBalanceInfo;
import ru.netology.web.page.DashboardPage;
import ru.netology.web.page.LoginPageV1;
import ru.netology.web.page.VerificationPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MoneyTransferSecondCardTest {

    @BeforeEach
    void setup() {
        open("http://localhost:9999");
        LoginPageV1 loginPage = new LoginPageV1();
        DataHelper.AuthInfo authInfo = DataHelper.getAuthInfo();
        VerificationPage verificationPage = loginPage.validLogin(authInfo);
        DataHelper.VerificationCode verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
        DashboardPage dashboardPage = new DashboardPage();

        dashboardPage.depositSecondCardByBalance(DataHelper.getFirstCardInfo());
        dashboardPage.setValue("10000");
        dashboardPage.depositFirstCard(DataHelper.getSecondCardInfo());
    }

    @Test
    void ShouldTopupSecondCard_PreBoundValue_NotEmptyBalanceOfEachCard() {

        DashboardPage dashboardPage = new DashboardPage();
        PreBalanceInfo preBalanceInfo = new PreBalanceInfo();

        int expectedFirstCard = preBalanceInfo.getBalanceFirstCard() - 1;
        int expectedSecondCard = preBalanceInfo.getBalanceSecondCard() + 1;

        dashboardPage.setValue("-1");
        dashboardPage.depositSecondCard(DataHelper.getFirstCardInfo());

        DashboardPage dashboardPage2 = new DashboardPage();
        int actualFirstCard = dashboardPage2.getCardBalance("[data-test-id=\"92df3f1c-a033-48e6-8390-206f6b1f56c0\"]");
        int actualSecondCard = dashboardPage2.getCardBalance("[data-test-id=\"0f3f5c2a-249e-4c3d-8287-09f7a039391d\"]");

        assertEquals(expectedFirstCard, actualFirstCard);
        assertEquals(expectedSecondCard, actualSecondCard);
    }

    @Test
    void ShouldTopupSecondCard_ZeroValue_NotEmptyBalanceOfEachCard() {

        DashboardPage dashboardPage = new DashboardPage();
        PreBalanceInfo preBalanceInfo = new PreBalanceInfo();

        int expectedFirstCard = preBalanceInfo.getBalanceFirstCard();
        int expectedSecondCard = preBalanceInfo.getBalanceSecondCard();

        dashboardPage.setValue("0");
        dashboardPage.depositSecondCard(DataHelper.getFirstCardInfo());

        DashboardPage dashboardPage2 = new DashboardPage();
        int actualFirstCard = dashboardPage2.getCardBalance("[data-test-id=\"92df3f1c-a033-48e6-8390-206f6b1f56c0\"]");
        int actualSecondCard = dashboardPage2.getCardBalance("[data-test-id=\"0f3f5c2a-249e-4c3d-8287-09f7a039391d\"]");

        assertEquals(expectedFirstCard, actualFirstCard);
        assertEquals(expectedSecondCard, actualSecondCard);
    }

    @Test
    void ShouldTopupSecondCard_PostBoundValue_NotEmptyBalanceOfEachCard() {

        DashboardPage dashboardPage = new DashboardPage();
        PreBalanceInfo preBalanceInfo = new PreBalanceInfo();

        int expectedFirstCard = preBalanceInfo.getBalanceFirstCard() - 1;
        int expectedSecondCard = preBalanceInfo.getBalanceSecondCard() + 1;

        dashboardPage.setValue("1");
        dashboardPage.depositSecondCard(DataHelper.getFirstCardInfo());

        DashboardPage dashboardPage2 = new DashboardPage();
        int actualFirstCard = dashboardPage2.getCardBalance("[data-test-id=\"92df3f1c-a033-48e6-8390-206f6b1f56c0\"]");
        int actualSecondCard = dashboardPage2.getCardBalance("[data-test-id=\"0f3f5c2a-249e-4c3d-8287-09f7a039391d\"]");

        assertEquals(expectedFirstCard, actualFirstCard);
        assertEquals(expectedSecondCard, actualSecondCard);
    }

    @Test
    void ShouldTopupSecondCard_PositiveValue_NotEmptyBalanceOfEachCard() {

        DashboardPage dashboardPage = new DashboardPage();
        PreBalanceInfo preBalanceInfo = new PreBalanceInfo();

        int expectedFirstCard = preBalanceInfo.getBalanceFirstCard() - 100;
        int expectedSecondCard = preBalanceInfo.getBalanceSecondCard() + 100;

        dashboardPage.setValue("100");
        dashboardPage.depositSecondCard(DataHelper.getFirstCardInfo());

        DashboardPage dashboardPage2 = new DashboardPage();
        int actualFirstCard = dashboardPage2.getCardBalance("[data-test-id=\"92df3f1c-a033-48e6-8390-206f6b1f56c0\"]");
        int actualSecondCard = dashboardPage2.getCardBalance("[data-test-id=\"0f3f5c2a-249e-4c3d-8287-09f7a039391d\"]");

        assertEquals(expectedFirstCard, actualFirstCard);
        assertEquals(expectedSecondCard, actualSecondCard);
    }

    @Test
    void ShouldTopupSecondCard_OverValue_NotEmptyBalanceOfEachCard() {

        DashboardPage dashboardPage = new DashboardPage();
        PreBalanceInfo preBalanceInfo = new PreBalanceInfo();

        int expectedFirstCard = preBalanceInfo.getBalanceFirstCard();
        int expectedSecondCard = preBalanceInfo.getBalanceSecondCard();

        dashboardPage.setValue("138706");
        dashboardPage.depositSecondCard(DataHelper.getFirstCardInfo());

        DashboardPage dashboardPage2 = new DashboardPage();
        int actualFirstCard = dashboardPage2.getCardBalance("[data-test-id=\"92df3f1c-a033-48e6-8390-206f6b1f56c0\"]");
        int actualSecondCard = dashboardPage2.getCardBalance("[data-test-id=\"0f3f5c2a-249e-4c3d-8287-09f7a039391d\"]");

        assertEquals(expectedFirstCard, actualFirstCard);
        assertEquals(expectedSecondCard, actualSecondCard);
    }
    @Test
    void ShouldTopupSecondCard_EnormousValue_NotEmptyBalanceOfEachCard() {

        DashboardPage dashboardPage = new DashboardPage();
        PreBalanceInfo preBalanceInfo = new PreBalanceInfo();

        int expectedFirstCard = preBalanceInfo.getBalanceFirstCard();
        int expectedSecondCard = preBalanceInfo.getBalanceSecondCard();

        dashboardPage.setValue("8888888");
        dashboardPage.depositSecondCard(DataHelper.getFirstCardInfo());

        DashboardPage dashboardPage2 = new DashboardPage();
        int actualFirstCard = dashboardPage2.getCardBalance("[data-test-id=\"92df3f1c-a033-48e6-8390-206f6b1f56c0\"]");
        int actualSecondCard = dashboardPage2.getCardBalance("[data-test-id=\"0f3f5c2a-249e-4c3d-8287-09f7a039391d\"]");

        assertEquals(expectedFirstCard, actualFirstCard);
        assertEquals(expectedSecondCard, actualSecondCard);
    }
}

