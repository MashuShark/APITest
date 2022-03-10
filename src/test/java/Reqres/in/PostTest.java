package Reqres.in;

import org.json.JSONObject;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

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

        Map<String, Object> newUserDetails = new HashMap<String, Object>();
        newUserDetails.put("name", "Martin");
        newUserDetails.put("job", "doctor");

        JSONObject POSTrequestBody = new JSONObject(newUserDetails);


    }


}
