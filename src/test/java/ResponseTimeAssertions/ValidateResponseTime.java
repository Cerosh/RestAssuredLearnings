package ResponseTimeAssertions;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ValidateResponseTime {
	RequestSpecification requestSpecification;
	ResponseSpecification responseSpecification;

	@BeforeClass
	public void setupForSpecification() {
		requestSpecification = RestAssured.given().baseUri("https://restful-booker.herokuapp.com/").basePath("booking")
				.body("{\n" + "    \"firstname\" : \"Jim\",\n" + "    \"lastname\" : \"Brown\",\n"
						+ "    \"totalprice\" : 111,\n" + "    \"depositpaid\" : true,\n" + "    \"bookingdates\" : {\n"
						+ "        \"checkin\" : \"2018-01-01\",\n" + "        \"checkout\" : \"2019-01-01\"\n"
						+ "    },\n" + "    \"additionalneeds\" : \"Breakfast\"\n" + "}")
				.contentType(ContentType.JSON);
		responseSpecification = requestSpecification.expect().statusCode(200).contentType(ContentType.JSON);
	}

	@Test
	public void requestCreateTheBooking_extractTheResponseTime_validateTheRange() {
		Response response = RestAssured.given().spec(requestSpecification).given().post();
		Long responseTimeInMill = response.getTime();
		System.out.println("responseTimeInMill :" + responseTimeInMill);
		Long responseTimeInSeconds = response.getTimeIn(TimeUnit.SECONDS);
		System.out.println("responseTimeInSeconds :" + responseTimeInSeconds);
		response.then().assertThat().time(Matchers.lessThan(5000L));
		response.then().time(Matchers.greaterThanOrEqualTo(1L), TimeUnit.SECONDS);
		response.then().time(Matchers.both(Matchers.lessThan(5000L)).and(Matchers.greaterThan(1000L)));
	}

}
