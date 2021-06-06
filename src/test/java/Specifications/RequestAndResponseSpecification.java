package Specifications;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RequestAndResponseSpecification {
	RequestSpecification requestSpecification;
	ResponseSpecification responseSpecification;

	@BeforeClass
	public void setRequestAndResponseSpecifications() {
		requestSpecification = RestAssured.given().baseUri("https://restful-booker.herokuapp.com/").basePath("booking")
				.body("{\n" + "    \"firstname\" : \"Jim\",\n" + "    \"lastname\" : \"Brown\",\n"
						+ "    \"totalprice\" : 111,\n" + "    \"depositpaid\" : true,\n" + "    \"bookingdates\" : {\n"
						+ "        \"checkin\" : \"2018-01-01\",\n" + "        \"checkout\" : \"2019-01-01\"\n"
						+ "    },\n" + "    \"additionalneeds\" : \"Breakfast\"\n" + "}")
				.contentType(ContentType.JSON).log().all();

		responseSpecification = requestSpecification.expect().statusCode(200).contentType(ContentType.JSON)
				.time(Matchers.lessThan(5000L));
	}

	@Test
	public void requestCreateTheBooking_usingRequestAndResponsetSpecifications() {
		RestAssured.given(requestSpecification, responseSpecification).post().then().log().all();

	}

}
