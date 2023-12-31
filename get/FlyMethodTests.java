package ru.cft.shift.qa.test.yellowrubberduck.get;

import jdk.nashorn.internal.ir.annotations.Ignore;
import ru.cft.shift.qa.test.yellowrubberduck.BaseTest;
import ru.cft.shift.qa.test.yellowrubberduck.Directory;
import ru.cft.shift.qa.test.yellowrubberduck.framework.web.HttpStatusCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

public class FlyMethodTests extends BaseTest {
    private static final String url = Directory.FLY.getValue();

    @Test
    @DisplayName("Проверка метода \"Лететь\" в случае, если состояние крыльев - ACTIVE")
    public void checkFLyMethodWhenWingsAreActive() {
        //prepare
        String expectedMessage = "I'm flying";

        // do
        String actualMessage = given()
                .spec(requestSpecification)
                .when()
                .queryParam("wingsState", "ACTIVE")
                .get(url)
                .then()
                .statusCode(HttpStatusCode.OK)
                .extract()
                .jsonPath()
                .getString("message");

        // check
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("Проверка метода \"Лететь\" в случае, если состояние крыльев - Fixed")
    public void checkFLyMethodWhenWingsAreFixed() {
        //prepare
        String expectedMessage = "I can't fly";

        // do
        String actualMessage = given()
                .spec(requestSpecification)
                .when()
                .queryParam("wingsState", "FIXED")
                .get(url)
                .then()
                .statusCode(HttpStatusCode.OK)
                .extract()
                .jsonPath()
                .getString("message");

        // check
        assertEquals(expectedMessage, actualMessage);
    }
    // TODO: Fly-QA-3-STATUSCODE-BODY
    @Ignore
    @Test
    @DisplayName("Проверка метода \"Лететь\" в случае, если состояние крыльев - not found")
    public void checkFLyMethodWhenWingsAreNotfound() {
        //prepare
        String expectedMessage = "No wings detectable!";

        // do
        String actualMessage = given()
                .spec(requestSpecification)
                .when()
                .queryParam("wingsState", "")
                .get(url)
                .then()
                .statusCode(HttpStatusCode.INTERNAL_SERVER_ERROR)
                .extract()
                .jsonPath()
                .getString("message");

        // check
        assertEquals(expectedMessage, actualMessage);
    }
}

