package WithoutChaining;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestLogSpecification;
import io.restassured.specification.RequestSpecification;

public class PostRequestWithoutChaining {
	@Test
	public void builtRequest_HitRequestAndGetResponse_ValidateResponse() {
		
		RequestSpecification requestSpecification = RestAssured.given();
		RequestLogSpecification requestSpecificationLog = requestSpecification.log();
		requestSpecificationLog.all();
		requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
		requestSpecification.basePath("booking");
		requestSpecification.body("{\r\n" + 
					"    \"firstname\" : \"Amod\",\r\n" + 
					"    \"lastname\" : \"Mahajan\",\r\n" + 
					"    \"totalprice\" : 15,\r\n" + 
					"    \"depositpaid\" : false,\r\n" + 
					"    \"bookingdates\" : {\r\n" + 
					"        \"checkin\" : \"2021-01-01\",\r\n" + 
					"        \"checkout\" : \"2021-01-01\"\r\n" + 
					"    },\r\n" + 
					"    \"additionalneeds\" : \"Lunch\"\r\n" + 
					"}");
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.post();
		ValidatableResponse validatableResponse = response.then();
		validatableResponse.statusCode(200);
		validatableResponse.time(Matchers.lessThan(5000L));
		

}}
