package ru.netology.web.test;

import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.DashboardPage;
import ru.netology.web.page.LoginPageV1;
import ru.netology.web.page.VerificationPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MoneyTransferTest {

    @Test
    void shouldGetBalance() {

        open("http://localhost:9999");
        LoginPageV1 loginPage = new LoginPageV1(); // создали страницу
        DataHelper.AuthInfo authInfo = DataHelper.getAuthInfo(); // взяли инфу
        VerificationPage verificationPage = loginPage.validLogin(authInfo); // заполнили поля для логина, нажали отправить
        DataHelper.VerificationCode verificationCode = DataHelper.getVerificationCodeFor(authInfo); //взяли код
        verificationPage.validVerify(verificationCode);// ввели код, нажали отправить
        DashboardPage dashboardPage = new DashboardPage(); // создали страницу

        int expectedFirstCard = DataHelper.PreBalanceInfo.getBalanceFirstCard() + 100;
        int expectedSecondCard = DataHelper.PreBalanceInfo.getBalanceSecondCard() - 100;

        dashboardPage.depositFirstCard(DataHelper.getSecondCardInfo()); // заполнили поля, нажали отправить

        int actualFirstCard = DataHelper.PostBalanceInfo.getBalanceFirstCard();
        int actualSecondCard = DataHelper.PostBalanceInfo.getBalanceSecondCard();

        assertEquals(expectedFirstCard, actualFirstCard);
        assertEquals(expectedSecondCard, actualSecondCard);
    }

    @Test
    void shouldFillBalance() {

        open("http://localhost:9999");
        LoginPageV1 loginPage = new LoginPageV1(); // создали страницу
        DataHelper.AuthInfo authInfo = DataHelper.getAuthInfo(); // взяли инфу
        VerificationPage verificationPage = loginPage.validLogin(authInfo); // заполнили поля для логина, нажали отправить
        DataHelper.VerificationCode verificationCode = DataHelper.getVerificationCodeFor(authInfo); //взяли код
        verificationPage.validVerify(verificationCode);// ввели код, нажали отправить
        DashboardPage dashboardPage = new DashboardPage(); // создали страницу

        dashboardPage.depositFirstCardByBalance(DataHelper.getSecondCardInfo()); // заполнили поля, нажали отправить

        int expectedFirstCard = 20000;
        int expectedSecondCard = 0;
        int actualFirstCard = DataHelper.PostBalanceInfo.getBalanceFirstCard();
        int actualSecondCard = DataHelper.PostBalanceInfo.getBalanceSecondCard();

        assertEquals(expectedFirstCard, actualFirstCard);
        assertEquals(expectedSecondCard, actualSecondCard);
    }
//    @Test
//    void shouldEqualBalance() {
//
//        open("http://localhost:9999");
//        LoginPageV1 loginPage = new LoginPageV1(); // создали страницу
//        DataHelper.AuthInfo authInfo = DataHelper.getAuthInfo(); // взяли инфу
//        VerificationPage verificationPage = loginPage.validLogin(authInfo); // заполнили поля для логина, нажали отправить
//        DataHelper.VerificationCode verificationCode = DataHelper.getVerificationCodeFor(authInfo); //взяли код
//        verificationPage.validVerify(verificationCode);// ввели код, нажали отправить
//        DashboardPage dashboardPage = new DashboardPage(); // создали страницу
//
//        dashboardPage.depositFirstCardByBalance(DataHelper.getSecondCardInfo()); // заполнили поля, нажали отправить
//
//        int expectedFirstCard = 10000;
//        int expectedSecondCard = 10000;
//        int actualFirstCard = DataHelper.PostBalanceInfo.getBalanceFirstCard();
//        int actualSecondCard = DataHelper.PostBalanceInfo.getBalanceSecondCard();
//
//        assertEquals(expectedFirstCard, actualFirstCard);
//        assertEquals(expectedSecondCard, actualSecondCard);
//    }
//    @Test
//    void shouldFillTheWebsite() {
//
//        open("http://localhost:9999");
//        LoginPageV1 loginPage = new LoginPageV1(); // создали страницу
//        DataHelper.AuthInfo authInfo = DataHelper.getAuthInfo(); // взяли инфу
//        VerificationPage verificationPage = loginPage.validLogin(authInfo); // заполнили поля для логина, нажали отправить
//
//        DataHelper.VerificationCode verificationCode = DataHelper.getVerificationCodeFor(authInfo); //взяли код
//        verificationPage.validVerify(verificationCode);// ввели код, нажали отправить
//        DashboardPage dashboardPage = new DashboardPage(); // создали страницу
//}
}

