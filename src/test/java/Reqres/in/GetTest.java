package Reqres.in;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class GetTest {

    Map<String,String> requestHeaders = new HashMap<String, String>() {{
        put("Content-Type", "application/json");
    }};

    String baseurlReqres = "https://reqres.in/api";
    String usersReqres = "/users";
    String endpointReqres = "/{id}";

    @Test
    // getRequest With Query Param
    public void getListUsers() {
        String page = "1";

        Response response = RestAssured.given()
                .headers(requestHeaders)
                .queryParam("page", page)
                .log().all()
                .when()
                .get(baseurlReqres + usersReqres)
                .then()
                .extract().response();

        String body = response.body().asString();
        JsonPath jpath = new JsonPath(body);
        String actualName = jpath.getString("page");

        System.out.println("Response Body is =>  " + body);

        Assert.assertEquals("StatusCode does not match 200", 200, response.getStatusCode());
        Assert.assertEquals ("actual name: " + actualName + "don't match expected name: " + page,
                page, actualName);
    }

    @Test
    // getRequest With Path Param
    public void getSingleUser() {
        String id = "2";
        String expectedEmail = "janet.weaver@reqres.in";

        Response response = RestAssured.given()
                .headers(requestHeaders)
                .pathParam("id", id)
                .log().all()
                .when()
                .get(baseurlReqres + usersReqres + endpointReqres)
                .then()
                .extract().response();

        String body = response.body().asString();
        JsonPath jpath = new JsonPath(body);
        String actualData = jpath.getString("data.email");

        // get all response headers and print them
        Headers allHeaders = response.getHeaders();
        for(Header header : allHeaders)
        {
            System.out.print(header.getName() +" : ");
            System.out.println(header.getValue());
        }

        System.out.println("Response Body is =>  " + body);

        Assert.assertEquals("StatusCode does not match 200", 200, response.getStatusCode());
        Assert.assertEquals ("actual name: " + actualData + " don't match expected name: " + expectedEmail,
                actualData, expectedEmail);
    }

    @Test
    // getRequest With Path Param
    public void getSingleUserNotFound() {
        String id = "23";

        ValidatableResponse response = RestAssured.given()
                .headers(requestHeaders)
                .pathParam("id", id)
                .log().all()
                .when()
                .get(baseurlReqres + usersReqres + endpointReqres)
                .then()
                .statusCode(404);
    }
}
