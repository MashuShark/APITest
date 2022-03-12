package GoREST;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostTest {

    String baseurlGoREST = "https://gorest.co.in/public/v2";
    String usersGoREST = "/users";
    String endpointGoREST = "/{id}";

    String bearerTokenGoREST = "84b4084ed12b2ecb81a704cf4011ee4e36919ce589b2f91b778f772c6a9d4ac9";

    String requestBody = "{\"id\": \"1\", \"name\": \"Alex Viet\", " +
            "\"email\": \"alex_viet@willms.info\", \"gender\": \"male\"," +
            "\"status\": \"inactive\"}";

    @Test
    public void postRequest() {
        Response response = RestAssured.given()
                .header(
                        "Authorization",
                        "Bearer " + bearerTokenGoREST
                )
                .header("content-type", "application/json")
                .and()
                .body(requestBody)
                .log().all()
                .when()
                .post(baseurlGoREST + usersGoREST)
                .then()
                .extract().response();

        System.out.println("Response Body is =>  " + response.asString());

        Assert.assertEquals(201, response.statusCode());
        Assert.assertEquals("Alex Viet", response.jsonPath().getString("name"));
    }

//    @Test
//    public void getRequest() {
//        String name = "Alex Viet";
//        String expectedName = "Alex Viet";
//
//        ValidatableResponse response = RestAssured.given()
//                .contentType(ContentType.JSON).accept(ContentType.JSON)
//                .param("name", name)
//                .log().all()
//                .when()
//                .get(baseurlGoREST + usersGoREST)
//                .then()
//                .body("name", containsString(expectedName));
//    }
}
