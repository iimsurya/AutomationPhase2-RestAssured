package LearningPhase2.APIAutomationDec25;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;


public class ChapterOne {

	public static void main(String[] args) {
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body("{\n"
				+ "  \"location\": {\n"
				+ "    \"lat\": -38.383499,\n"
				+ "    \"lng\": 33.427360\n"
				+ "  },\n"
				+ "  \"accuracy\": 50,\n"
				+ "  \"name\": \"Walter house\",\n"
				+ "  \"phone_number\": \"(+91) 983 893 3937\",\n"
				+ "  \"address\": \"13, French st, May 09\",\n"
				+ "  \"types\": [\n"
				+ "    \"House park\",\n"
				+ "    \"Home\"\n"
				+ "  ],\n"
				+ "  \"website\": \"http://google.com\",\n"
				+ "  \"language\": \"English-IN\"\n"
				+ "}")
		.when().post("/maps/api/place/add/json")
		.then().log().all().statusCode(200);
		

	}

}
