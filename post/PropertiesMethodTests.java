package ru.cft.shift.qa.test.yellowrubberduck.post;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.cft.shift.qa.test.yellowrubberduck.BaseTest;
import ru.cft.shift.qa.test.yellowrubberduck.Directory;
import ru.cft.shift.qa.test.yellowrubberduck.framework.web.HttpStatusCode;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PropertiesMethodTests extends BaseTest {
    private static final String url = Directory.PROPERTIES.getValue();

    @Test
    @DisplayName("Проверка цвета уточки в случае, если материал - резина")
    public void checkColorWhenMaterialIsRubberColor() {
        //prepare

        String body = "{ \"material\": \"rubber\" }";
        String expectedColor = "yellow";

        // do
        String actualColor = given()
                .spec(requestSpecification)
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post(url)
                .then()
                .statusCode(HttpStatusCode.OK)
                .extract()
                .jsonPath()
                .getString("color");

        // check
        assertEquals(expectedColor, actualColor);
    }

    @Test
    @DisplayName("Проверка материала уточки в случае, если материал - резина")
    public void checkColorWhenMaterialIsRubberMaterial() {
        //prepare

        String body = "{ \"material\": \"rubber\" }";
        String expectedmaterial = "rubber";

        // do
        String actualmaterial = given()
                .spec(requestSpecification)
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post(url)
                .then()
                .statusCode(HttpStatusCode.OK)
                .extract()
                .jsonPath()
                .getString("material");

        // check
        assertEquals(expectedmaterial, actualmaterial);
    }

    @Test
    @DisplayName("Проверка высоты уточки в случае, если материал - резина")
    public void checkColorWhenMaterialIsRubbermetersHeight() {
        //prepare

        String body = "{ \"material\": \"rubber\" }";
        String expectedmetersHeight = "0.03"; //String expectedColor = "0.03";

        // do
        String actualHeight = given()
                .spec(requestSpecification)
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post(url)
                .then()
                .statusCode(HttpStatusCode.OK)
                .extract()
                .jsonPath()
                .getString("metersHeight");

        // check
        assertEquals(expectedmetersHeight, actualHeight);
    }

    @Test
    @DisplayName("Проверка свойств уточки в случае, если материал - углепластик")
    public void checkColorWhenMaterialIsCarbonfiber() {
        //prepare

        String body = "{ \"material\": \"carbonfiber\" }";
        String expectedproperties = "{}";

        // do
        String actual = given()
                .spec(requestSpecification)
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post(url)
                .then()
                .statusCode(HttpStatusCode.OK)
                .extract()
                .response()
                .getBody()
                .asString();

        // check
        assertEquals(expectedproperties, actual);
    }

    @Test
    @DisplayName("Проверка свойств уточки в случае, если материал - novalide")
    public void checkColorWhenMaterialIsNovalide() {
        //prepare

        String body = "{ \"material\": \"№!;:?*()_+_+\" }";
        String expectedproperties= "{}";

        // do
        String actual = given()
                .spec(requestSpecification)
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post(url)
                .then()
                .statusCode(HttpStatusCode.OK)
                .extract()
                .response()
                .getBody()
                .asString();

        // check
        assertEquals(expectedproperties, actual);
    }
}

