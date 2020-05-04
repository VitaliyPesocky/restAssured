import config.EndPoint;
import config.TestConfig;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class VideoGameDBTests extends TestConfig {

    @Test
    public void getAllGames() {
        when().
                get(EndPoint.VIDEOGAMES).
        then().
                log().
                all();
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
    public void updateGame() {
        String gameBodyJson = "{\n" +
                "  \"id\": 11,\n" +
                "  \"name\": \"MyUpdatedGame\",\n" +
                "  \"releaseDate\": \"2020-05-02T13:36:10.131Z\",\n" +
                "  \"reviewScore\": 99,\n" +
                "  \"category\": \"Driving\",\n" +
                "  \"rating\": \"Mature\"\n" +
                "}";

        given().
                body(gameBodyJson).
        when().
                put(EndPoint.VIDEOGAMES + "/11").
        then().
                log().
                all();

    }

    @Test
    public void deleteGame() {
        when().
                delete(EndPoint.VIDEOGAMES + "/11").
        then().
                log().
                all();
    }

    @Test
    public void getSingleGame() {
        given().
                pathParam("videoGameId", 5).
        when().
                get(EndPoint.SINGLE_VIDEOGAME).
        then();
    }
}
