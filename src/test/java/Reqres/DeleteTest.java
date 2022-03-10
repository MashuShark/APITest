package Reqres;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class DeleteTest {
    String baseurlReqres = "https://reqres.in/api";
    String usersReqres = "/users";
    String endpoint = "/{id}";

    @Test
    // delete user by DELETE request and static import
    public void deleteUser() {

        Map<String, String> requestHeaders = new HashMap<>() {{
            put("Content-Type", "application/json");
        }};

        String id = "384";

        given().
                headers(requestHeaders).
                pathParam("id", id).
                log().all().
                when().
                delete(baseurlReqres + usersReqres + endpoint).
                then().
                statusCode(204);
    }
}