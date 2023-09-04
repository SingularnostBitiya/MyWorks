package ru.cft.shift.qa.test.yellowrubberduck.get;

import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import ru.cft.shift.qa.test.yellowrubberduck.BaseTest;
import ru.cft.shift.qa.test.yellowrubberduck.Directory;
import ru.cft.shift.qa.test.yellowrubberduck.framework.web.HttpStatusCode;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SoundMethodTests extends BaseTest {
    private static final String url = Directory.SOUND.getValue();
    // 1
    @Test
    @DisplayName("Проверка метода \"Крякать\" в случае, если количество повторений - 3, количество звуков - 2")
    public void checkSoundMethodWhenWingsAreActive() {
        //prepare

        HashMap<String, Object> queryParams = new HashMap<String, Object>() {{
            put("repetitionCount", 3);
            put("soundCount", 2);
        }};
        String expectedSound = "quack-quack, quack-quack, quack-quack";

        // do
        String actualSound = given()
                .spec(requestSpecification)
                .when()
                .queryParams(queryParams)
                .get(url)
                .then()
                .statusCode(HttpStatusCode.OK)
                .extract()
                .jsonPath()
                .getString("sound");

        // check
        assertEquals(expectedSound, actualSound);
    }

    // 2

    @Test
    @DisplayName("Проверка метода \"Крякать\" в случае, если количество повторений - 1, количество звуков - 1")
    public void checkSoundMethodWhenWingsAreActiveRepetitionCountONEANDSoundCountONE() {
        //prepare

        HashMap<String, Object> queryParams = new HashMap<String, Object>() {{
            put("repetitionCount", 1);
            put("soundCount", 1);
        }};
        String expectedSound = "quack";  //String expectedSound = "quack";

        // do
        String actualSound = given()
                .spec(requestSpecification)
                .when()
                .queryParams(queryParams)
                .get(url)
                .then()
                .statusCode(HttpStatusCode.OK)
                .extract()
                .jsonPath()
                .getString("sound");

        // check
        assertEquals(expectedSound, actualSound);
    }

    // 3
    @Test
    @DisplayName("Проверка метода \"Крякать\" в случае, если количество повторений - 0, количество звуков - 0")
    public void checkSoundMethodWhenWingsAreNoActive() {
        //prepare

        HashMap<String, Object> queryParams = new HashMap<String, Object>() {{
            put("repetitionCount", 0);
            put("soundCount", 0);
        }};
        String expectedSound = "";

        // do
        String actualSound = given()
                .spec(requestSpecification)
                .when()
                .queryParams(queryParams)
                .get(url)
                .then()
                .statusCode(HttpStatusCode.OK)
                .extract()
                .jsonPath()
                .getString("sound");

        // check
        assertEquals(expectedSound, actualSound);
    }
    // 4
    @Test
    @DisplayName("Проверка метода \"Крякать\" в случае, если количество повторений - 1, количество звуков - 0")
    public void checkSoundMethodWhenWingsAreNoActiveTHENrepetitionCountONEsoundCountZERO() {
        //prepare

        HashMap<String, Object> queryParams = new HashMap<String, Object>() {{
            put("repetitionCount", 1);
            put("soundCount", 0);
        }};
        String expectedSound = "";

        // do
        String actualSound = given()
                .spec(requestSpecification)
                .when()
                .queryParams(queryParams)
                .get(url)
                .then()
                .statusCode(HttpStatusCode.OK)
                .extract()
                .jsonPath()
                .getString("sound");

        // check
        assertEquals(expectedSound, actualSound);
    }
    // 5
    @Test
    @DisplayName("Проверка метода \"Крякать\" в случае, если количество повторений - 0, количество звуков - 1")
    public void checkSoundMethodWhenWingsAreNoActiveTHENrepetitionCountZerosoundCountONE() {
        //prepare

        HashMap<String, Object> queryParams = new HashMap<String, Object>() {{
            put("repetitionCount", 0);
            put("soundCount", 1);
        }};
        String expectedSound = "";

        // do
        String actualSound = given()
                .spec(requestSpecification)
                .when()
                .queryParams(queryParams)
                .get(url)
                .then()
                .statusCode(HttpStatusCode.OK)
                .extract()
                .jsonPath()
                .getString("sound");

        // check
        assertEquals(expectedSound, actualSound);
    }
    // 6

    @Test
    @DisplayName("Проверка метода \"Крякать\" в случае, если количество повторений - 3, количество звуков - 1")
    public void checkSoundMethodWhenWingsAreActiveTHEN() {
        //prepare

        HashMap<String, Object> queryParams = new HashMap<String, Object>() {{
            put("repetitionCount", 3);
            put("soundCount", 1);
        }};
       String expectedSound = "quack, quack, quack";

        // do
        String actualSound = given()
                .spec(requestSpecification)
                .when()
                .queryParams(queryParams)
                .get(url)
                .then()
                .statusCode(HttpStatusCode.OK)
                .extract()
                .jsonPath()
                .getString("sound");

        // check
        assertEquals(expectedSound, actualSound);
    }

    // 7

    @Test
    @DisplayName("Проверка метода \"Крякать\" в случае, если количество повторений - 1, количество звуков - 2")
    public void checkSoundMethodWhenWingsAreActive2() {
        //prepare

        HashMap<String, Object> queryParams = new HashMap<String, Object>() {{
            put("repetitionCount", 1);
            put("soundCount", 2);
        }};
        String expectedSound = "quack-quack";

        // do
        String actualSound = given()
                .spec(requestSpecification)
                .when()
                .queryParams(queryParams)
                .get(url)
                .then()
                .statusCode(HttpStatusCode.OK)
                .extract()
                .jsonPath()
                .getString("sound");

        // check
        assertEquals(expectedSound, actualSound);
    }

    // 8

    @Test
    @DisplayName("Проверка метода \"Крякать\" в случае, если количество повторений - (-1), количество звуков - 0")
    public void checkSoundMethodWhenNegativeRepetitiCount() {
        //prepare

        HashMap<String, Object> queryParams = new HashMap<String, Object>() {{
            put("repetitionCount", -1);
            put("soundCount", 0);
        }};
        String expectedSound = "Invalid parameter value";

        // Convert the HashMap to JSON string

        // do
        String actualSound = given()
                .spec(requestSpecification)
                .when()
                .queryParams(queryParams)
                .get(url)
                .then()
                .statusCode(HttpStatusCode.INTERNAL_SERVER_ERROR)
                .extract()
                .jsonPath()
                .getString("message");

        // check

        assertEquals(expectedSound, actualSound);

    }


    // 9

    @Test
    @DisplayName("Проверка метода \"Крякать\" в случае, если количество повторений - 0, количество звуков - (-1)")
    public void checkSoundMethodWhenNegativeRepetitiSoundCount() {
        //prepare

        HashMap<String, Object> queryParams = new HashMap<String, Object>() {{
            put("repetitionCount", 0);
            put("soundCount", -1);
        }};
        String expectedSound = "Invalid parameter value"; //String expectedSound = "quack-quack, quack-quack,quack-quack";

        // Convert the HashMap to JSON string

        // do
        String actualSound = given()
                .spec(requestSpecification)
                .when()
                .queryParams(queryParams)
                .get(url)
                .then()
                .statusCode(HttpStatusCode.INTERNAL_SERVER_ERROR)
                .extract()
                .jsonPath()
                .getString("message");

        // check

        assertEquals(expectedSound, actualSound);

    }

    // 10

    @Test
    @DisplayName("Проверка метода \"Крякать\" в случае, если количество повторений - (-1), количество звуков - (-1)")
    public void checkSoundMethodWhenNegativeRepetitionCountANDSoundCount() {
        //prepare

        HashMap<String, Object> queryParams = new HashMap<String, Object>() {{
            put("repetitionCount", -1);
            put("soundCount", -1);
        }};
        String expectedSound = "Invalid parameter value"; //String expectedSound = "quack-quack, quack-quack,quack-quack";


        // do
        String actualSound = given()
                .spec(requestSpecification)
                .when()
                .queryParams(queryParams)
                .get(url)
                .then()
                .statusCode(HttpStatusCode.INTERNAL_SERVER_ERROR)
                .extract()
                .jsonPath()
                .getString("message");

        // check

        assertEquals(expectedSound, actualSound);

    }

    // 11
    @Test
    @DisplayName("Проверка метода \"Крякать\" в случае, если количество повторений - qwerty, количество звуков - (-1)")
    public void checkSoundMethodWhenNoValiderepetitionCountNegativesoundCount() {
        //prepare

        HashMap<String, Object> queryParams = new HashMap<String, Object>() {{
            put("repetitionCount", "qwerty");
            put("soundCount", -1);
        }};


        // do
        String actualSound = given()
                .spec(requestSpecification)
                .when()
                .queryParams(queryParams)
                .get(url)
                .then()
                .statusCode(HttpStatusCode.BAD_REQUEST)
                .extract()
                .body()
                .asString();


    }

    // 12
    @Test
    @DisplayName("Проверка метода \"Крякать\" в случае, если количество повторений - 2, количество звуков - qwerty")
    public void checkSoundMethodWhenValideRepetitionCountNoValideSoundCount() {
        //prepare

        HashMap<String, Object> queryParams = new HashMap<String, Object>() {{
            put("repetitionCount", 2);
            put("soundCount", "qwerty");
        }};


        // do
        String actualSound = given()
                .spec(requestSpecification)
                .when()
                .queryParams(queryParams)
                .get(url)
                .then()
                .statusCode(HttpStatusCode.BAD_REQUEST)
                .extract()
                .body()
                .asString();


    }

    // 13
    @Test
    @DisplayName("Проверка метода \"Крякать\" в случае, если количество повторений - qwerty, количество звуков - qwerty")
    public void checkSoundMethodWhenNoValiderepetitionCountsoundCount() {
        //prepare

        HashMap<String, Object> queryParams = new HashMap<String, Object>() {{
            put("repetitionCount", "qwerty");
            put("soundCount", "qwerty");
        }};


        // do
        String actualSound = given()
                .spec(requestSpecification)
                .when()
                .queryParams(queryParams)
                .get(url)
                .then()
                .statusCode(HttpStatusCode.BAD_REQUEST)
                .extract()
                .body()
                .asString();

    }
}

