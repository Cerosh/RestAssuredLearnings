package API_POST_REQUEST.KeyValueJSON;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostRequest {
	@Test
	void SimpleJSONUsingPOJO() {
		
		JSONUsingPOJO Data = new JSONUsingPOJO();
		Data.setName("Morpheus");
		Data.setJob("Leader");
		Response Res = 
				given()
				.contentType(ContentType.JSON)
				.body(Data)
				.when()
				.post("https://reqres.in/api/users");
		System.out.println("The Status Code for Post Request=:"+Res.getStatusCode());
		System.out.println("The Status Line for Post Request=:"+Res.getStatusLine());
		System.out.println("The Data Posted is:");
		System.out.println(Res.asPrettyString());
		System.out.println("Just Chill");
				
	}
	@Test
	void secondSimpleJSONUsingPojo() {
		JSONUsingPOJO Data = new JSONUsingPOJO();
		Data.setEmail("eve.holt@reqres.in");
		Data.setPassword("pistol");
		Response Res = 
				given().contentType(ContentType.JSON).body(Data)
				.when().post("https://reqres.in/api/register");
		System.out.println("Status Code: " + Res.getStatusCode());
	}
	
	


}
