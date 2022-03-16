package Localhost;

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

    String baseurlLocalhost = "http://localhost:3000";
    String employeeLocalhost = "/employee";
    String positionsLocalhost = "/positions";
    String endpointLocalhost = "/{id}";

    @DataProvider(name = "addNewEmployees")
    public static Object[][] addNewEmployees() {
        return new Object[][]{
                {"Meyer", "Everitt", "meveritt7@java.com", "Female", 7},
                {"Shoshana", "Esposito", "sesposito2@nytimes.com", "Male", 3}
        };
    }

    @Test(dataProvider = "addNewEmployees")
    // add new Employees by POST request
    public void POSTAddNewEmployee(String first_name, String last_name, String email, String gender, int position) {

        JSONObject POSTrequestBody = new JSONObject();
        POSTrequestBody.put("first_name", first_name);
        POSTrequestBody.put("last_name", last_name);
        POSTrequestBody.put("email", email);
        POSTrequestBody.put("gender", gender);
        POSTrequestBody.put("position", position);

        Response response = RestAssured.given().
                headers(requestHeaders).
                body(POSTrequestBody.toString()).
                log().all().
                when().
                post(baseurlLocalhost + employeeLocalhost).
                then().
                extract().response();

        Assert.assertEquals(response.getStatusCode(), 201, "StatusCode does not match 201");

        String body = response.body().asString();
        System.out.println(body);
    }
}
