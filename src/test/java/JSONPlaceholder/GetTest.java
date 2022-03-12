package JSONPlaceholder;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.containsString;

public class GetTest {

    String baseurlJsonplaceholder = "https://jsonplaceholder.typicode.com";
    String usersJsonplaceholder = "/users";
    String endpointJsonplaceholder = "/{id}";

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
    }

    @Test
    public void getRequestWithQueryParam() {
        String id = "1";
        String expectedName = "[Leanne Graham]";

        Response response = RestAssured.given()
                .contentType(ContentType.JSON).accept(ContentType.JSON)
                .param("id", id)
                .log().all()
                .when()
                .get(baseurlJsonplaceholder + usersJsonplaceholder);

        String body = response.body().asString();
        JsonPath jpath = new JsonPath(body);
        String actualName = jpath.getList("name").toString();

        System.out.println("Response Body is =>  " + body);

        Assert.assertEquals("actual name: " + actualName + "don't match expected name: " + expectedName,
                expectedName, actualName);
    }
}