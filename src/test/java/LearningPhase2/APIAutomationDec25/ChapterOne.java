package LearningPhase2.APIAutomationDec25;

import Data.Payloads;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class ChapterOne {

	public static void main(String[] args) {
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";


        String response =
		given().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body(Payloads.createPayload())
		.when().post("/maps/api/place/add/json")
		.then().statusCode(200)
                .body("scope",equalTo("APP"))
                //.header("Content-Type","application/json")
                        .extract().response().asString();
		

        System.out.println(response);

        JsonPath js = new JsonPath(response);
        String placeID = js.getString("place_id");

        System.out.println("Place ID from the add place response: " + placeID);
	}

}
