package ru.netology.web.data;

import lombok.Value;
import ru.netology.web.page.DashboardPage;

public class DataHelper {

    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    @Value
    public static class VerificationCode {
        private String code;
    }

    public static VerificationCode getVerificationCodeFor(AuthInfo authInfo) {
        return new VerificationCode("12345");
    }

    @Value
    public static class CardInfo {
        private String cardNumber;
        private String cardBalance;
    }

    public static CardInfo getFirstCardInfo() {
        return new CardInfo("5559000000000001", "10000");
    }
    public static CardInfo getSecondCardInfo() {
        return new CardInfo("5559000000000002", "10000");
    }


    @Value
    public static class PreBalanceInfo {
        static DashboardPage dashboardPage = new DashboardPage();
        private static int balanceFirstCard = dashboardPage.getCardBalance("[data-test-id=\"92df3f1c-a033-48e6-8390" +
                "-206f6b1f56c0\"]");
        private static int balanceSecondCard = dashboardPage.getCardBalance("[data-test-id=\"0f3f5c2a-249e-4c3d-8287" +
                "-09f7a039391d\"]");

        public static int getBalanceFirstCard() {
            return balanceFirstCard;
        }

        public static int getBalanceSecondCard() {
            return balanceSecondCard;
        }
    }

    @Value
    public static class PostBalanceInfo {
        static DashboardPage dashboardPage = new DashboardPage();
        private static int balanceFirstCard = dashboardPage.getCardBalance("[data-test-id=\"92df3f1c-a033-48e6-8390" +
                "-206f6b1f56c0\"]");
        private static int balanceSecondCard = dashboardPage.getCardBalance("[data-test-id=\"0f3f5c2a-249e-4c3d-8287" +
                "-09f7a039391d\"]");

        public static int getBalanceFirstCard() {
            return balanceFirstCard;
        }

        public static int getBalanceSecondCard() {
            return balanceSecondCard;
        }
    }
}

