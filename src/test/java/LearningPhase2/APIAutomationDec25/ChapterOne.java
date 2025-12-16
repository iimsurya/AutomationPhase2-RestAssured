package LearningPhase2.APIAutomationDec25;

import Data.Payloads;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class ChapterOne {

    public static String placeID;

    static {
        RestAssured.baseURI = "https://rahulshettyacademy.com";
    }

	public static void main(String[] args) {

        addPlace();
        getPlace();
    }

    public static void addPlace(){

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
        placeID = js.getString("place_id");


	}

    public static void getPlace(){

        System.out.println("Place ID from the add place response: " + placeID);


        given().queryParam("key", "qaclick123")
                .queryParam("place_id", placeID)
        .when().get("/maps/api/place/get/json")
        .then().statusCode(200)
                .body("address", equalTo("13, French st, May 09"));
    }
}
