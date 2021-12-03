package ru.netology.web.test;

import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.data.DataHelper.PreBalanceInfo;
import ru.netology.web.page.DashboardPage;
import ru.netology.web.page.LoginPageV1;
import ru.netology.web.page.VerificationPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MoneyTransferPositiveTest {

    @Test
    void ShouldTopupFirstCard_PreBoundValue_NotEmptyBalanceOfEachCard() {

        open("http://localhost:9999");
        LoginPageV1 loginPage = new LoginPageV1(); // создали страницу
        DataHelper.AuthInfo authInfo = DataHelper.getAuthInfo(); // взяли инфу
        VerificationPage verificationPage = loginPage.validLogin(authInfo); // заполнили поля для логина, нажали отправить
        DataHelper.VerificationCode verificationCode = DataHelper.getVerificationCodeFor(authInfo); //взяли код
        verificationPage.validVerify(verificationCode);// ввели код, нажали отправить
        DashboardPage dashboardPage = new DashboardPage(); // создали страницу

        PreBalanceInfo preBalanceInfo = new PreBalanceInfo();

        int expectedFirstCard = preBalanceInfo.getBalanceFirstCard() + 1;
        int expectedSecondCard = preBalanceInfo.getBalanceSecondCard() - 1;

        dashboardPage.setValue("-1");
        dashboardPage.depositFirstCard(DataHelper.getSecondCardInfo()); // заполнили поля, нажали отправить

        DashboardPage dashboardPage2 = new DashboardPage();
        int actualFirstCard = dashboardPage2.getCardBalance("[data-test-id=\"92df3f1c-a033-48e6-8390-206f6b1f56c0\"]");
        int actualSecondCard = dashboardPage2.getCardBalance("[data-test-id=\"0f3f5c2a-249e-4c3d-8287-09f7a039391d\"]");

        assertEquals(expectedFirstCard, actualFirstCard);
        assertEquals(expectedSecondCard, actualSecondCard);
    }

    @Test
    void ShouldTopupFirstCard_ZeroValue_NotEmptyBalanceOfEachCard() {

        open("http://localhost:9999");
        LoginPageV1 loginPage = new LoginPageV1(); // создали страницу
        DataHelper.AuthInfo authInfo = DataHelper.getAuthInfo(); // взяли инфу
        VerificationPage verificationPage = loginPage.validLogin(authInfo); // заполнили поля для логина, нажали отправить
        DataHelper.VerificationCode verificationCode = DataHelper.getVerificationCodeFor(authInfo); //взяли код
        verificationPage.validVerify(verificationCode);// ввели код, нажали отправить
        DashboardPage dashboardPage = new DashboardPage(); // создали страницу

        PreBalanceInfo preBalanceInfo = new PreBalanceInfo();

        int expectedFirstCard = preBalanceInfo.getBalanceFirstCard();
        int expectedSecondCard = preBalanceInfo.getBalanceSecondCard();

        dashboardPage.setValue("0");
        dashboardPage.depositFirstCard(DataHelper.getSecondCardInfo()); // заполнили поля, нажали отправить

        DashboardPage dashboardPage2 = new DashboardPage();
        int actualFirstCard = dashboardPage2.getCardBalance("[data-test-id=\"92df3f1c-a033-48e6-8390-206f6b1f56c0\"]");
        int actualSecondCard = dashboardPage2.getCardBalance("[data-test-id=\"0f3f5c2a-249e-4c3d-8287-09f7a039391d\"]");

        assertEquals(expectedFirstCard, actualFirstCard);
        assertEquals(expectedSecondCard, actualSecondCard);
    }
    @Test
    void ShouldTopupFirstCard_PostBoundValue_NotEmptyBalanceOfEachCard() {

        open("http://localhost:9999");
        LoginPageV1 loginPage = new LoginPageV1(); // создали страницу
        DataHelper.AuthInfo authInfo = DataHelper.getAuthInfo(); // взяли инфу
        VerificationPage verificationPage = loginPage.validLogin(authInfo); // заполнили поля для логина, нажали отправить
        DataHelper.VerificationCode verificationCode = DataHelper.getVerificationCodeFor(authInfo); //взяли код
        verificationPage.validVerify(verificationCode);// ввели код, нажали отправить
        DashboardPage dashboardPage = new DashboardPage(); // создали страницу

        PreBalanceInfo preBalanceInfo = new PreBalanceInfo();

        int expectedFirstCard = preBalanceInfo.getBalanceFirstCard() + 1;
        int expectedSecondCard = preBalanceInfo.getBalanceSecondCard() - 1;

        dashboardPage.setValue("1");
        dashboardPage.depositFirstCard(DataHelper.getSecondCardInfo()); // заполнили поля, нажали отправить

        DashboardPage dashboardPage2 = new DashboardPage();
        int actualFirstCard = dashboardPage2.getCardBalance("[data-test-id=\"92df3f1c-a033-48e6-8390-206f6b1f56c0\"]");
        int actualSecondCard = dashboardPage2.getCardBalance("[data-test-id=\"0f3f5c2a-249e-4c3d-8287-09f7a039391d\"]");

        assertEquals(expectedFirstCard, actualFirstCard);
        assertEquals(expectedSecondCard, actualSecondCard);
    }
    @Test
    void ShouldTopupFirstCard_PositiveValue_NotEmptyBalanceOfEachCard() {

        open("http://localhost:9999");
        LoginPageV1 loginPage = new LoginPageV1(); // создали страницу
        DataHelper.AuthInfo authInfo = DataHelper.getAuthInfo(); // взяли инфу
        VerificationPage verificationPage = loginPage.validLogin(authInfo); // заполнили поля для логина, нажали отправить
        DataHelper.VerificationCode verificationCode = DataHelper.getVerificationCodeFor(authInfo); //взяли код
        verificationPage.validVerify(verificationCode);// ввели код, нажали отправить
        DashboardPage dashboardPage = new DashboardPage(); // создали страницу

        PreBalanceInfo preBalanceInfo = new PreBalanceInfo();

        int expectedFirstCard = preBalanceInfo.getBalanceFirstCard() + 100;
        int expectedSecondCard = preBalanceInfo.getBalanceSecondCard() - 100;

        dashboardPage.setValue("100");
        dashboardPage.depositFirstCard(DataHelper.getSecondCardInfo()); // заполнили поля, нажали отправить

        DashboardPage dashboardPage2 = new DashboardPage();
        int actualFirstCard = dashboardPage2.getCardBalance("[data-test-id=\"92df3f1c-a033-48e6-8390-206f6b1f56c0\"]");
        int actualSecondCard = dashboardPage2.getCardBalance("[data-test-id=\"0f3f5c2a-249e-4c3d-8287-09f7a039391d\"]");

        assertEquals(expectedFirstCard, actualFirstCard);
        assertEquals(expectedSecondCard, actualSecondCard);
    }
    @Test
    void ShouldTopupFirstCard_OverValue_NotEmptyBalanceOfEachCard() {

        open("http://localhost:9999");
        LoginPageV1 loginPage = new LoginPageV1(); // создали страницу
        DataHelper.AuthInfo authInfo = DataHelper.getAuthInfo(); // взяли инфу
        VerificationPage verificationPage = loginPage.validLogin(authInfo); // заполнили поля для логина, нажали отправить
        DataHelper.VerificationCode verificationCode = DataHelper.getVerificationCodeFor(authInfo); //взяли код
        verificationPage.validVerify(verificationCode);// ввели код, нажали отправить
        DashboardPage dashboardPage = new DashboardPage(); // создали страницу

        PreBalanceInfo preBalanceInfo = new PreBalanceInfo();

        int expectedFirstCard = preBalanceInfo.getBalanceFirstCard();
        int expectedSecondCard = preBalanceInfo.getBalanceSecondCard();

        dashboardPage.setValue("9999999");
        dashboardPage.depositFirstCard(DataHelper.getSecondCardInfo()); // заполнили поля, нажали отправить

        DashboardPage dashboardPage2 = new DashboardPage();
        int actualFirstCard = dashboardPage2.getCardBalance("[data-test-id=\"92df3f1c-a033-48e6-8390-206f6b1f56c0\"]");
        int actualSecondCard = dashboardPage2.getCardBalance("[data-test-id=\"0f3f5c2a-249e-4c3d-8287-09f7a039391d\"]");

        assertEquals(expectedFirstCard, actualFirstCard);
        assertEquals(expectedSecondCard, actualSecondCard);
    }

}

