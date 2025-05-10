package ru.netology.tests;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class BankApiTest {

    @Test
    void shouldReturnDemoAccounts() {
        given()
                .baseUri("http://localhost:9999")
                .when()
                .get("/api/v1/demo/accounts")
                .then()
                .statusCode(200)
                .body("[0].currency", equalTo("RUB"));
    }
}