package ru.netology.web.data;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import lombok.Value;

import static io.restassured.RestAssured.given;

public class SetTheBalance {
    private static final RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri("http://localhost")
            .setPort(9999)
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    private SetTheBalance() {
    }

    public static void sendRequest(RegistrationDto user) {
        given()
                .spec(requestSpec) // указываем, какую спецификацию используем
                .body(user) // передаём в теле объект, который будет
                .when()
                .post("/api/system/users")
                .then()
                .statusCode(200);
    }

    public static class Registration {
        private Registration() {
        }

        public static RegistrationDto getUser(int balance) {
            RegistrationDto user = new RegistrationDto("vasya", "qwerty123", "first", "12345", balance);
            return user;
        }

    }

    @Value
    public static class RegistrationDto {
        String login;
        String password;
        String card;
        String code;
        int balance;
    }
}

