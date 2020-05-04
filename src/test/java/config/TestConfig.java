package config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.BeforeClass;

public class TestConfig {

    public static RequestSpecification videoGame_requestSpec;
    public static RequestSpecification football_requestSpec;
    public static ResponseSpecification responseSpecification;

    @BeforeClass
    public static void setup() {

        RestAssured.proxy("localhost", 8866);

        videoGame_requestSpec = new RequestSpecBuilder().
                setBaseUri("http://localhost").
                setPort(8080).
                setBasePath("/app/").
                addHeader("Content-Type", "application/json").
                addHeader("Accept", "application/json").
                build();

        football_requestSpec = new RequestSpecBuilder().
                setBaseUri("https://api.football-data.org").
                setBasePath("/v2/").
                addHeader("X-Auth-Token", "c9a1abfed8f742758a75bab903eb9333").
                addHeader("X-Response-Control", "minified").
                build();

        responseSpecification = new ResponseSpecBuilder().
                expectStatusCode(200).
                build();

        RestAssured.responseSpecification = responseSpecification;
    }
}
