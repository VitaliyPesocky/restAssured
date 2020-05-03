import config.EndPoint;
import config.TestConfig;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class FirstTest extends TestConfig {

    @Test
    public void firstTest() {
        given().
                log().
                all().
        when().get("videogames/1").
        then().
                log().
                all();
    }

    @Test
    public void getAllGames() {
        when().
                get(EndPoint.VIDEOGAMES);
    }
}
