package ResponseExtractions;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;


public class ExtractResponseBodyAsString {
	@Test
	public void requestBookingCreation_extractBodyAsStringFromResponse(){
		String responseBody = RestAssured.
				given().
				baseUri("https://restful-booker.herokuapp.com/").
				basePath("booking/{id}").
				pathParam("id",1).
				when().
				get().
				then().
				extract().
				body().
				asPrettyString();
		System.out.println("Response Body: "+ responseBody);
		
	}
	@Test
	public void requestBookingCreation_extractFirstNameAsStringFromResponse() {
		String firstName = RestAssured.
				given().
				baseUri("https://restful-booker.herokuapp.com/").
				basePath("booking/{id}").
				pathParam("id", 1).contentType(ContentType.JSON).
				when().get().
				then().extract().body().path("firstname").toString();
		System.out.println("First Name: " + firstName);
	}

}
