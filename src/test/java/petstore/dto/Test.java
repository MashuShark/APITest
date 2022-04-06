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

        // create a new user by a constructor
        User testUser1 = new User(10L, "nickDuck", "Nick", "Duck",
                "nickduck@email.com|", "nickpass","+380997076", 1 );

        // create a new user by a builder
        User testUser = new User.UserBuilder()
                .withId(111L)
                .withUserName("IvanPupkin")
                .withFirstName("Ivan")
                .withLastName("Pupkin")
                .withEmail("emailpupkin@email.com")
                .withPassword("pupkinPass")
                .withPhone("+3809900000")
                .withUserStatus(true).build();


        Response response = RestAssured.given().
                headers(requestHeaders).
                body(testUser).
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