package ResponseDataParsing.JSONPath;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class JSONPath {
	@Test
	void filterUsingJSONPath() {
		Response res = given().contentType(ContentType.JSON)
				.when().get("http://localhost:3000/friends");
		System.out.println(res.statusLine());
		
		String age= res.jsonPath().getString("[2].id");
		System.out.println(age);
		
	}
	@Test
	void filterUsingComplexJSONPath() {
		Response res = given().contentType(ContentType.JSON)
				.when().get("https://reqres.in/api/users?page=2");
		String firstName = res.jsonPath().get("data[5].first_name").toString();
		System.out.println(firstName);
	}
	@Test
	void filterBasedOnTheContentType() {
		Response res = given().contentType(ContentType.JSON)
				.when().get("https://reqres.in/api/users?page=2").then().extract().response();
		System.out.println(res.path("data[5].first_name"));
		
	}
	

}
