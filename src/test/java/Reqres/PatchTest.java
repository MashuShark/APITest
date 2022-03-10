package Reqres;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class PatchTest {
    Map<String, String> requestHeaders = new HashMap<>() {{
        put("Content-Type", "application/json");
    }};

    String baseurlReqres = "https://reqres.in/api";
    String usersReqres = "/users";
    String endpoint = "/{id}";

    @Test
    // update user by PATCH request
    public void updateUser() {

        JSONObject POSTrequestBody = new JSONObject();
        POSTrequestBody.put("name", "Martin");
        POSTrequestBody.put("job", "teacher");

        String id = "384";

        Response response = RestAssured.given().
                headers(requestHeaders).
                pathParam("id", id).
                body(POSTrequestBody.toString()).
                log().all().
                when().
                patch(baseurlReqres + usersReqres + endpoint).
                then().
                extract().response();

        Assert.assertEquals(200, response.statusCode());

        String body = response.body().asString();
        System.out.println(body);

//        {"name":"Martin","job":"teacher","updatedAt":"2022-03-10T12:58:56.794Z"}
    }
}
