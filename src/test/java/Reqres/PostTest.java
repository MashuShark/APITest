package Reqres;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

public class PostTest {

    Map<String, String> requestHeaders = new HashMap<>() {{
        put("Content-Type", "application/json");
    }};

    String baseurlReqres = "https://reqres.in/api";
    String usersReqres = "/users";

    @Test
    // create new user by POST request
    public void POSTcreateNewUser() {

        JSONObject POSTrequestBody = new JSONObject();
        POSTrequestBody.put("name", "Martin");
        POSTrequestBody.put("job", "doctor");

        Response response = RestAssured.given().
                headers(requestHeaders).
                body(POSTrequestBody.toString()).
                log().all().
                when().
                post(baseurlReqres + usersReqres).
                then().
                extract().response();

        Assert.assertEquals( response.getStatusCode(), 201, "StatusCode does not match 201");

        String body = response.body().asString();
        System.out.println(body);

//        {"name":"Martin","job":"doctor","id":"384","createdAt":"2022-03-10T12:38:06.452Z"}
    }

}
