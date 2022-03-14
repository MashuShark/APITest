package Localhost;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;


public class DeleteTest {

    String baseurlLocalhost = "http://localhost:3000";
    String employeeLocalhost = "/employee";
    String endpointLocalhost = "/{id}";

    @DataProvider(name = "dataForDelete")
    public Object[] dataForDelete() {
        return new Object[]{
                "102", "57", "8"
        };
    }

    @Test(dataProvider = "dataForDelete")
    // delete user by DELETE request, static import and DDT using annotation @DataProvider
    public void deleteUser(int id) {

        Map<String, String> requestHeaders = new HashMap<>() {{
            put("Content-Type", "application/json");
        }};


        given().
                headers(requestHeaders).
                pathParam("id", id).
                log().all().
                when().
                delete(baseurlLocalhost + employeeLocalhost + endpointLocalhost).
                then().
                statusCode(204);
    }

    @Parameters("employeeId")
    @Test
    // delete user by DELETE request and static import and DDT using annotation @Parameters
    public void deleteUser2(int employeeId) {

        Map<String, String> requestHeaders = new HashMap<>() {{
            put("Content-Type", "application/json");
        }};

        System.out.println("Value for employeeId is: " + employeeId);

        given().
                headers(requestHeaders).
                pathParam("id", employeeId).
                log().all().
                when().
                delete(baseurlLocalhost + employeeLocalhost + endpointLocalhost).
                then().
                statusCode(200);
    }
}