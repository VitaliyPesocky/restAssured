import config.EndPoint;
import config.TestConfig;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class VideoGameDBTests extends TestConfig {

    @Test
    public void getAllGames() {
        when().
                get(EndPoint.VIDEOGAMES).
        then();
    }

    @Test
    public void createNewGameByJSON() {
        String gameBodyJson = "{\n" +
                "  \"id\": 11,\n" +
                "  \"name\": \"MyNewGame\",\n" +
                "  \"releaseDate\": \"2020-05-02T13:36:10.131Z\",\n" +
                "  \"reviewScore\": 50,\n" +
                "  \"category\": \"Driving\",\n" +
                "  \"rating\": \"Mature\"\n" +
                "}";

        given().
                body(gameBodyJson).
        when().
                post(EndPoint.VIDEOGAMES).
        then();
    }

    @Test
    public void createNewGameByXML() {
        String gameBodyXml = "";
    }
}
