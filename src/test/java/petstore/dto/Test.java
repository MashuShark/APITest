package petstore.dto;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

public class Test {

    Map<String, String> requestHeaders = new HashMap<>() {{
        put("Content-Type", "application/json");
    }};

    String BASE_URL = "https://petstore.swagger.io";
    String BASE_PATH = "/v2";
    String USER = "/user";

    @org.testng.annotations.Test
    public void addUser() {

        User testUser2 = User.builder()
                .id(1L)
                .userName("sodcroft0")
                .firstName("Shadow")
                .lastName("Odcroft")
                .email("sodcroft0@senate.gov")
                .password("815b32")
                .phone("733-356-1417")
                .userStatus(1)
                .build();

        // create a new user by a constructor
        User testUser1 = new User(10L, "nickDuck", "Nick", "Duck",
                "nickduck@email.com|", "nickpass","+380997076", 1 );

        Response response = RestAssured.given().
                headers(requestHeaders).
                body(testUser2).
                log().all().
                when().
                post(BASE_URL + BASE_PATH + USER).
                then().
                extract().response();

        Assert.assertEquals(response.getStatusCode(), 200, "StatusCode does not match 200");

        String body = response.body().asString();
        System.out.println(body);
    }
}