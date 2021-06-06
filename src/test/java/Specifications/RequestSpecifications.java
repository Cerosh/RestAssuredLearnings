package Specifications;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpecifications {
	RequestSpecification requestSpecification;
	@BeforeClass
	public void setRequestSpecification() {
		requestSpecification = RestAssured.
				given().
				baseUri("https://restful-booker.herokuapp.com/").
				contentType(ContentType.JSON).
				log().all();
	}

@Test
public void requestUpdatingTheBooking_usingRequestSpecifications() {
		RestAssured.
		given().
		spec(requestSpecification).
		basePath("booking").
		body("{\n" + "    \"firstname\" : \"Jim\",\n" + "    \"lastname\" : \"Brown\",\n"
						+ "    \"totalprice\" : 111,\n" + "    \"depositpaid\" : true,\n" + "    \"bookingdates\" : {\n"
						+ "        \"checkin\" : \"2018-01-01\",\n" + "        \"checkout\" : \"2019-01-01\"\n"
						+ "    },\n" + "    \"additionalneeds\" : \"Breakfast\"\n" + "}").
		when().
		post().
		then().
		statusCode(200);
		

	}

	@Test
	public void requestPatchingTheBooking_usingRequestSpecifications() {
		RestAssured.given().
		spec(requestSpecification).
		basePath("booking/{id}").
		pathParam("id",7).body("{\n" + "    \"firstname\" : \"Cerosh\",\n" + "    \"lastname\" : \"Jacob\"\n" + "}").
		header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=").
		when().
		patch().
		then().
		log().
		all().
		statusCode(200);
	}
}
