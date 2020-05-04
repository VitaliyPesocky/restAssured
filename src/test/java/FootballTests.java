import config.TestConfig;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class FootballTests extends TestConfig {

    @Test
    public void getAllCompetitionsOneArea() {
        given().
                spec(football_requestSpec).
                queryParam("areas", 2001).
        when().
                get("competitions/");
    }

    @Test
    public void getTeamCountOneCompetition() {
        given().
                spec(football_requestSpec).
        when().
                get("competitions/2021/teams").
                then().assertThat().body("count", equalTo(20)).
                log().
                all();
    }

    @Test
    public void getFirstTeamName() {
        given().
                spec(football_requestSpec).
                when().
                get("competitions/2021/teams").
                then().assertThat().body("teams.name[0]", equalTo("Arsenal FC")).
                log().
                all();
    }
}
