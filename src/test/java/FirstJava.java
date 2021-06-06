import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class FirstJava {
	@Test
	void testClass() {
		Response res =	get("https://reqres.in/api/users?page=2");
		System.out.println(res.getStatusCode());
		System.out.println(res.getBody().asString());
		System.out.println(res.getHeader("content-type"));
	}
	@Test
	void getBDDStyle() {
		given().get("https://reqres.in/api/users?page=2").then().statusCode(200);
	}

}
