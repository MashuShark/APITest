import org.junit.Test;

import static io.restassured.RestAssured.given;

public class FirstTest {

    @Test
    public void firstTestCase() {
        String url = "https://reqres.in/api/users?page=2";
        given()
                .when()
                .get(url)
                .then()
                .assertThat()
                .statusCode(200);
    }

}
