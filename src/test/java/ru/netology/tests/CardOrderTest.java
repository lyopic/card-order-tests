package ru.netology.tests;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class CardOrderTest {

    @Test
    void shouldSubmitCardForm() {
        given()
                .baseUri("https://sinsl.github.io/testing-form/") // если API доступен
                .contentType(ContentType.JSON)
                .body("""
                {
                  "name": "Иван",
                  "surname": "Иванович",
                  "patronymic": "Иванов",
                  "telephone": "+7(999)999-99-99",
                  "birthdate": "2000-11-11",
                  "passport": "9999 99999999"
                }
                """)
                .when()
                .post("/submit") // уточни путь, если потребуется
                .then()
                .statusCode(200)
                .body("success", equalTo(true));
    }
}