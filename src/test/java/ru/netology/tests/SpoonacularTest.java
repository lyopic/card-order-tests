package ru.netology.tests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class SpoonacularTest {

    @Test
    void shouldSearchRecipe() {
        given()
                .baseUri("https://api.spoonacular.com")
                .queryParam("apiKey", "ВАШ_API_КЛЮЧ") // замени на свой
                .queryParam("query", "pasta")
                .queryParam("maxFat", 25)
                .when()
                .get("/recipes/complexSearch")
                .then()
                .statusCode(200)
                .contentType("application/json")
                .body("results.size()", greaterThan(0));
    }
}