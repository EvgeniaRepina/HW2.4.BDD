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

class MoneyTransferSecondCardTest {

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
    void ShouldTopupSecondCard_PreBoundValue_NotEmptyBalanceOfEachCard() {
        int expectedFirstCard = DashboardPage.getCardBalance(DataHelper.getFirstCardId()) - 1;
        int expectedSecondCard = DashboardPage.getCardBalance(DataHelper.getSecondCardId()) + 1;

        MoneyTtransferPage.depositSecondCard(DataHelper.getFirstCardInfo(),"-1");

        int actualFirstCard = DashboardPage.getCardBalance(DataHelper.getFirstCardId());
        int actualSecondCard = DashboardPage.getCardBalance(DataHelper.getSecondCardId());

        assertEquals(expectedFirstCard, actualFirstCard);
        assertEquals(expectedSecondCard, actualSecondCard);
    }

    @Test
    void ShouldTopupFirstCard_ZeroValue_NotEmptyBalanceOfEachCard() {
        int expectedFirstCard = DashboardPage.getCardBalance(DataHelper.getFirstCardId());
        int expectedSecondCard = DashboardPage.getCardBalance(DataHelper.getSecondCardId());

        MoneyTtransferPage.depositSecondCard(DataHelper.getFirstCardInfo(),"0");

        int actualFirstCard = DashboardPage.getCardBalance(DataHelper.getFirstCardId());
        int actualSecondCard = DashboardPage.getCardBalance(DataHelper.getSecondCardId());
        assertEquals(expectedFirstCard, actualFirstCard);
        assertEquals(expectedSecondCard, actualSecondCard);
    }

    @Test
    void ShouldTopupSecondCard_PostBoundValue_NotEmptyBalanceOfEachCard() {
        int expectedFirstCard = DashboardPage.getCardBalance(DataHelper.getFirstCardId()) - 1;
        int expectedSecondCard = DashboardPage.getCardBalance(DataHelper.getSecondCardId()) + 1;

        MoneyTtransferPage.depositSecondCard(DataHelper.getFirstCardInfo(),"1");

        int actualFirstCard = DashboardPage.getCardBalance(DataHelper.getFirstCardId());
        int actualSecondCard = DashboardPage.getCardBalance(DataHelper.getSecondCardId());

        assertEquals(expectedFirstCard, actualFirstCard);
        assertEquals(expectedSecondCard, actualSecondCard);
    }

    @Test
    void ShouldTopupSecondCard_PositiveValue_NotEmptyBalanceOfEachCard() {

        int expectedFirstCard = DashboardPage.getCardBalance(DataHelper.getFirstCardId()) - 100;
        int expectedSecondCard = DashboardPage.getCardBalance(DataHelper.getSecondCardId()) + 100;

        MoneyTtransferPage.depositSecondCard(DataHelper.getFirstCardInfo(),"100");

        int actualFirstCard = DashboardPage.getCardBalance(DataHelper.getFirstCardId());
        int actualSecondCard = DashboardPage.getCardBalance(DataHelper.getSecondCardId());

        assertEquals(expectedFirstCard, actualFirstCard);
        assertEquals(expectedSecondCard, actualSecondCard);
    }

    @Test
    void ShouldTopupSecondCard_OverValue_NotEmptyBalanceOfEachCard() {

        int expectedFirstCard = DashboardPage.getCardBalance(DataHelper.getFirstCardId());
        int expectedSecondCard = DashboardPage.getCardBalance(DataHelper.getSecondCardId());

        MoneyTtransferPage.depositSecondCard(DataHelper.getFirstCardInfo(),"17845");

        int actualFirstCard = DashboardPage.getCardBalance(DataHelper.getFirstCardId());
        int actualSecondCard = DashboardPage.getCardBalance(DataHelper.getSecondCardId());

        assertEquals(expectedFirstCard, actualFirstCard);
        assertEquals(expectedSecondCard, actualSecondCard);
    }
    @Test
    void ShouldTopupSecondCard_EnormousValue_NotEmptyBalanceOfEachCard() {

        int expectedFirstCard = DashboardPage.getCardBalance(DataHelper.getFirstCardId());
        int expectedSecondCard = DashboardPage.getCardBalance(DataHelper.getSecondCardId());

        MoneyTtransferPage.depositSecondCard(DataHelper.getFirstCardInfo(),"9999999");

        int actualFirstCard = DashboardPage.getCardBalance(DataHelper.getFirstCardId());
        int actualSecondCard = DashboardPage.getCardBalance(DataHelper.getSecondCardId());

        assertEquals(expectedFirstCard, actualFirstCard);
        assertEquals(expectedSecondCard, actualSecondCard);
    }
}

