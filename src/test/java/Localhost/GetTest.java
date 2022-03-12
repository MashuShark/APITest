package Localhost;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

public class GetTest {

    Map<String,String> requestHeaders = new HashMap<String, String>() {{
        put("Content-Type", "application/json");
    }};

    String baseurlLocalhost = "http://localhost:3000";
    String employeeLocalhost = "/employee";
    String positionsLocalhost = "/positions";
    String endpointLocalhost = "/{id}";

    @Test
    // getRequest With Path Param
    public void getSingleUser() {
        String id = "2";

        Response response = (Response) RestAssured.given()
                .headers(requestHeaders)
                .pathParam("id", id)
                .log().all()
                .when()
                .get(baseurlLocalhost + employeeLocalhost + endpointLocalhost)
                .then()
                .extract().response();

        // get all response headers and print them
        Headers allHeaders = response.getHeaders();
        for(Header header : allHeaders)
        {
            System.out.print(header.getName() +" : ");
            System.out.println(header.getValue());
        }

        String body = response.body().asString();
        System.out.println("Response Body is =>  " + body);

        Assert.assertEquals( response.getStatusCode(), 200, "StatusCode does not match 200");
    }

    @Test
    // getRequest With Query Param
    public void getListUsers() {
        String name = "Network engineer";

        Response response = RestAssured.given()
                .headers(requestHeaders)
                .queryParam("name", name)
                .log().all()
                .when()
                .get(baseurlLocalhost + positionsLocalhost)
                .then()
                .extract().response();

        String body = response.body().asString();
        JsonPath jpath = new JsonPath(body);
        String actualName = jpath.getString("name");

        System.out.println("Response Body is =>  " + body);

        Assert.assertEquals( response.getStatusCode(), 200, "StatusCode does not match 200");
    }
}
