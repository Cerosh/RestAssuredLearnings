package Specifications;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpecifications {
	RequestSpecification requestSpecification;
	ResponseSpecification responseSpecification;
	@BeforeClass
	public void setRequestSpecification() {
		requestSpecification = RestAssured.
				given().
				baseUri("https://restful-booker.herokuapp.com/").
				contentType(ContentType.JSON).
				log().all();
	}
	@BeforeClass
	public void setResponseSpecification() {
		responseSpecification = requestSpecification.expect();
		responseSpecification.
		statusCode(200).
		contentType(ContentType.JSON).
		time(Matchers.lessThan(5000L));
	}

@Test
public void requestUpdatingTheBooking_usingResponsetSpecifications() {
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
		spec(responseSpecification);
		

	}

	@Test
	public void requestPatchingTheBooking_usingResponseSpecifications() {
		RestAssured.given().
		spec(requestSpecification).
		basePath("booking/{id}").
		pathParam("id",4).body("{\n" + "    \"firstname\" : \"Cerosh\",\n" + "    \"lastname\" : \"Jacob\"\n" + "}").
		header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=").
		when().
		patch().
		then().
		log().
		all().
		spec(responseSpecification);
	}
}
