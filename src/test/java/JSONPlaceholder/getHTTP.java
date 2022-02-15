package JSONPlaceholder;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;

public class getHTTP {

    String baseurlJsonplaceholder = "https://jsonplaceholder.typicode.com";
    String usersJsonplaceholder = "/users";
    String endpointJsonplaceholder = "/{id}";

    String requestBody = "{\n" +
            "  \"userId\": \"11\",\n" +
            "  \"id\": \"1\",\n" +
            "  \"title\": \"blinded by the possibility of catching up or repulsing a prudent mission\",\n" +
            "  \"body\": \"because he accepts and accepts to be accepted, they follow him unencumbered, \n " +
            "and when he finds any annoyance, \n so that as soon as the whole of our affairs belong\" \n}";


    @Test
    public void getRequest() {
        String id = "5";
        String expectedName = "Chelsey Dietrich";

        ValidatableResponse response = RestAssured.given()
                .contentType(ContentType.JSON).accept(ContentType.JSON)
                .pathParam("id", id)
                .when()
                .get(baseurlJsonplaceholder + usersJsonplaceholder + endpointJsonplaceholder)
                .then()
                .body("name", containsString(expectedName));

        // .extract().response();
        // Assert.assertEquals("actual name: " + actualName + "don't match expected name: " + expectedName,
        // expectedName, actualName);
    }

    @Test
    public void getRequestWithQueryParam() {
        String id = "1";
        String expectedName = "Leanne Graham";

//        ValidatableResponse response = RestAssured.given()
//                .contentType(ContentType.JSON).accept(ContentType.JSON)
//                .param("id", id)
//                .when()
//                .get(baseUrl + users)
//                .then()
//                .body("name", containsString(name));

        Response response = RestAssured.given()
                .contentType(ContentType.JSON).accept(ContentType.JSON)
                .param("id", id)
                .when()
                .get(baseurlJsonplaceholder + usersJsonplaceholder);
        String body = response.body().asString();
        JsonPath jpath = new JsonPath(body);
        String actualName = jpath.getString("name");

        Assert.assertEquals("actual name: " + actualName + "don't match expected name: " + expectedName,
                expectedName, actualName);

//org.junit.ComparisonFailure: actual name: [Leanne Graham]don't match expected name: Leanne Graham
//Expected :Leanne Graham
//Actual   :[Leanne Graham]
    }
}
