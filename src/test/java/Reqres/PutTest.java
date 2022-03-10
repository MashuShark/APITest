package Reqres;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class PutTest {
    Map<String, String> requestHeaders = new HashMap<>() {{
        put("Content-Type", "application/json");
    }};

    String baseurlReqres = "https://reqres.in/api";
    String usersReqres = "/users";
    String endpoint = "/{id}";

    @Test
    // update user by POST request
    public void updateUser() {

        JSONObject POSTrequestBody = new JSONObject();
        POSTrequestBody.put("name", "Martin");
        POSTrequestBody.put("job", "singer");

        String id = "384";

        Response response = RestAssured.given().
                headers(requestHeaders).
                pathParam("id", id).
                body(POSTrequestBody.toString()).
                log().all().
                when().
                put(baseurlReqres + usersReqres + endpoint).
                then().
                extract().response();

        Assert.assertEquals(200, response.statusCode());

        String body = response.body().asString();
        System.out.println(body);

//        {"name":"Martin","job":"singer","updatedAt":"2022-03-10T13:00:18.803Z"}
    }
}
