package RestAssured;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class RestTask {
    @BeforeEach
    public void setup(){
        RestAssured.baseURI = "https://swapi.dev/api";
    }


    @Test
    public void TestGetGiven(){
        Response response=
                given()
                        .when()
                        .get("/people/1")
                        .then().extract().response();
        Assertions.assertEquals(200, response.statusCode());
        System.out.println("Response: " + response.asPrettyString());

        Assertions.assertEquals("Luke Skywalker", response.jsonPath().getString("name"));
        Assertions.assertEquals("172", response.jsonPath().getString("height"));
        Assertions.assertEquals("77", response.jsonPath().getString("mass"));
        Assertions.assertEquals("blond", response.jsonPath().getString("hair_color"));
        Assertions.assertEquals("fair", response.jsonPath().getString("skin_color"));

        Gson gson = new Gson();
        RestTaskDTO dto =  gson.fromJson(response.body().asString(), RestTaskDTO.class);

       for(var element : dto.films){
            System.out.println(element); //Error

        }

    }
}
