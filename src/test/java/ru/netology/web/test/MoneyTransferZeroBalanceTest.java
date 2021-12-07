package ru.netology.web.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.DashboardPage;
import ru.netology.web.page.LoginPageV1;
import ru.netology.web.page.MoneyTtransferPage;
import ru.netology.web.page.VerificationPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MoneyTransferZeroBalanceTest {

    @BeforeEach
    void setup() {
        LoginPageV1 loginPage = open("http://localhost:9999", LoginPageV1.class); // создаем страницу одновременно с
        // ее открытием
        DataHelper.AuthInfo authInfo = DataHelper.getAuthInfo();
        VerificationPage verificationPage = loginPage.validLogin(authInfo);
        DataHelper.VerificationCode verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);

        MoneyTtransferPage.depositSecondCardByBalance(DataHelper.getFirstCardInfo());

        MoneyTtransferPage.depositFirstCard(DataHelper.getSecondCardInfo(), "10000");
    }

    @Test
    void ShouldTopupFirstCard_PositiveValue_FromNotEmptyCardToEmpty() {
        MoneyTtransferPage.depositSecondCardByBalance(DataHelper.getFirstCardInfo());

        int expectedFirstCard = 1;
        int expectedSecondCard = 19999;

        MoneyTtransferPage.depositFirstCard(DataHelper.getSecondCardInfo(),"1");

        int actualFirstCard = DashboardPage.getCardBalance(DataHelper.getFirstCardId());
        int actualSecondCard = DashboardPage.getCardBalance(DataHelper.getSecondCardId());

        assertEquals(expectedFirstCard, actualFirstCard);
        assertEquals(expectedSecondCard, actualSecondCard);
    }

    @Test
    void ShouldTopupSecondCard_PositiveValue_FromNotEmptyCardToEmpty() {
        MoneyTtransferPage.depositFirstCardByBalance(DataHelper.getSecondCardInfo());

        int expectedFirstCard = 19999;
        int expectedSecondCard = 1;

        MoneyTtransferPage.depositSecondCard(DataHelper.getFirstCardInfo(),"1");

        int actualFirstCard = DashboardPage.getCardBalance(DataHelper.getFirstCardId());
        int actualSecondCard = DashboardPage.getCardBalance(DataHelper.getSecondCardId());

        assertEquals(expectedFirstCard, actualFirstCard);
        assertEquals(expectedSecondCard, actualSecondCard);
    }

    @Test
    void ShouldTopupFirstCard_PositiveValue_FromEmptyCardToNotEmpty() {
        MoneyTtransferPage.depositFirstCardByBalance(DataHelper.getSecondCardInfo());

        int expectedFirstCard = 20000;
        int expectedSecondCard = 0;

        MoneyTtransferPage.depositFirstCard(DataHelper.getSecondCardInfo(),"1");

        int actualFirstCard = DashboardPage.getCardBalance(DataHelper.getFirstCardId());
        int actualSecondCard = DashboardPage.getCardBalance(DataHelper.getSecondCardId());

        assertEquals(expectedFirstCard, actualFirstCard);
        assertEquals(expectedSecondCard, actualSecondCard);
    }

    @Test
    void ShouldTopupSecondCard_PositiveValue_FromEmptyCardToNotEmpty() {
        MoneyTtransferPage.depositSecondCardByBalance(DataHelper.getFirstCardInfo());

        int expectedFirstCard = 0;
        int expectedSecondCard = 20000;

        MoneyTtransferPage.depositSecondCard(DataHelper.getFirstCardInfo(),"1");

        int actualFirstCard = DashboardPage.getCardBalance(DataHelper.getFirstCardId());
        int actualSecondCard = DashboardPage.getCardBalance(DataHelper.getSecondCardId());

        assertEquals(expectedFirstCard, actualFirstCard);
        assertEquals(expectedSecondCard, actualSecondCard);
    }
}
