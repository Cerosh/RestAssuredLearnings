package mocking.in.restassured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class APIJsonResponse {
//	https://run.mocky.io/v3/a8eddbe5-3354-4d32-9d20-6a2a9c3bd447
	@Test
	public void mockAPI_jsonResponse_usingDesigner_Mocky_io(){
		RestAssured.given().when().get("https://run.mocky.io/v3/a8eddbe5-3354-4d32-9d20-6a2a9c3bd447").then().log().body();
	}

}
