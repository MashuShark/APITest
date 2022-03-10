package Reqres;

import org.json.JSONObject;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class PostTest {

    Map<String, String> requestHeaders = new HashMap<String, String>() {{
        put("Content-Type", "application/json");
    }};

    String baseurlReqres = "https://reqres.in/api";
    String usersReqres = "/users";
    String endpointReqres = "/{id}";

    @Test
    // getRequest With Query Param
    public void createNewUser() {

        JSONObject POSTrequestBody = new JSONObject();
        POSTrequestBody.put("name", "Martin");
        POSTrequestBody.put("job", "doctor");

    given().
        headers(requestHeaders).
        body(POSTrequestBody.toJSONString).
    when().
        post(baseurlReqres + usersReqres).
        log().all().
    then().
        statusCode(200);
    }

}
