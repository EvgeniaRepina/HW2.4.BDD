package ru.netology.web.test;

import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.data.SetTheBalance;
import ru.netology.web.page.DashboardPage;
import ru.netology.web.page.LoginPageV1;
import ru.netology.web.page.VerificationPage;

import static com.codeborne.selenide.Selenide.open;
import static ru.netology.web.data.SetTheBalance.Registration.getUser;
import static ru.netology.web.data.SetTheBalance.sendRequest;

class MoneyTransferTest {
    @Test
    void shouldTransferMoneyBetweenOwnCardsV1() throws InterruptedException {
        open("http://localhost:9999");

        SetTheBalance.RegistrationDto registeredUser = getUser(30000);
        sendRequest(registeredUser);

        LoginPageV1 loginPage = new LoginPageV1(); // создали страницу

        DataHelper.AuthInfo authInfo = DataHelper.getAuthInfo(); // взяли инфу

        VerificationPage verificationPage = loginPage.validLogin(authInfo); // заполнили поля


        DataHelper.VerificationCode verificationCode = DataHelper.getVerificationCodeFor(authInfo); //взяли код
        verificationPage.validVerify(verificationCode);// ввели код, нажали отправить

        DashboardPage dashboardPage = new DashboardPage(); // создали страницу
        dashboardPage.depositFirstCardNumber(DataHelper.getSecondCardInfo()); // заполнили поля
        Thread.sleep(5000);


    }


}

