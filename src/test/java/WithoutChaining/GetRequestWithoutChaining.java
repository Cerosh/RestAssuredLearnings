package WithoutChaining;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import io.restassured.specification.RequestSpecification;

public class GetRequestWithoutChaining {
	@Test
	public void builtRequest_HitGetRequestAndGetResponse_ValidateResponse() {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
		requestSpecification.basePath("booking/{id}");
		requestSpecification.pathParam("id", 1);
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.when();
		Response response = requestSpecification.get();
		ValidatableResponse validatableResponse = response.then();
		validatableResponse.log().all();
		validatableResponse.time(Matchers.lessThan(5000L));
		 
	}
}
