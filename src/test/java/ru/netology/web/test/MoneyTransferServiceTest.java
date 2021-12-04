package ru.netology.web.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.DashboardPage;
import ru.netology.web.page.LoginPageV1;
import ru.netology.web.page.VerificationPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MoneyTransferServiceTest {

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
    void ShouldTopupFirstCard_AllValue_NotEmptyBalanceOfEachCard() {
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.depositFirstCardByBalance(DataHelper.getSecondCardInfo());

        int expectedFirstCard = 20000;
        int expectedSecondCard = 0;

        DashboardPage dashboardPage2 = new DashboardPage();
        int actualFirstCard = dashboardPage2.getCardBalance("[data-test-id=\"92df3f1c-a033-48e6-8390-206f6b1f56c0\"]");
        int actualSecondCard = dashboardPage2.getCardBalance("[data-test-id=\"0f3f5c2a-249e-4c3d-8287-09f7a039391d\"]");

        assertEquals(expectedFirstCard, actualFirstCard);
        assertEquals(expectedSecondCard, actualSecondCard);
    }

    @Test
    void ShouldTopupSecondCard_AllValue_NotEmptyBalanceOfEachCard() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.depositSecondCardByBalance(DataHelper.getFirstCardInfo());

        int expectedFirstCard = 0;
        int expectedSecondCard = 20000;

        DashboardPage dashboardPage2 = new DashboardPage();
        int actualFirstCard = dashboardPage2.getCardBalance("[data-test-id=\"92df3f1c-a033-48e6-8390-206f6b1f56c0\"]");
        int actualSecondCard = dashboardPage2.getCardBalance("[data-test-id=\"0f3f5c2a-249e-4c3d-8287-09f7a039391d\"]");

        assertEquals(expectedFirstCard, actualFirstCard);
        assertEquals(expectedSecondCard, actualSecondCard);
    }


    @Test
    void ShouldЕqualizeCards() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.depositSecondCardByBalance(DataHelper.getFirstCardInfo());

        int expectedFirstCard = 10000;
        int expectedSecondCard = 10000;

        dashboardPage.setValue("10000");
        dashboardPage.depositFirstCard(DataHelper.getSecondCardInfo());

        DashboardPage dashboardPage2 = new DashboardPage();
        int actualFirstCard = dashboardPage2.getCardBalance("[data-test-id=\"92df3f1c-a033-48e6-8390-206f6b1f56c0\"]");
        int actualSecondCard = dashboardPage2.getCardBalance("[data-test-id=\"0f3f5c2a-249e-4c3d-8287-09f7a039391d\"]");

        assertEquals(expectedFirstCard, actualFirstCard);
        assertEquals(expectedSecondCard, actualSecondCard);
    }
}

