import config.TestConfig;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class FirstTest extends TestConfig {
    @Test
    public void firstTest() {
        given().header("Accept", "application/json").
        when().get("videogames/1").
        then().statusCode(200);
    }
}
