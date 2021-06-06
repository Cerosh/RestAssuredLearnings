package ResponseDataParsing.Org.JSON;
import static io.restassured.RestAssured.*;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class OrgJSON {
	@Test
	void filterUsingOrgJSON() {
		Response res = given().contentType(ContentType.JSON)
				.when().get("https://reqres.in/api/users?page=2");
		System.out.println(res.getStatusLine());
		JSONObject jo = new JSONObject(res.asString());
		String firstName = jo.getJSONArray("data").getJSONObject(4).get("last_name").toString();
		System.out.println(firstName);
		
		String email = jo.getJSONArray("data").getJSONObject(3).get("email").toString();
		System.out.println(email);
		String text = jo.getJSONObject("support").getString("text");
		System.out.println(text);
	}
	@Test
	void filterUsingOrgJSONInLoop() {
		Response res = given().contentType(ContentType.JSON)
				.when().get("https://reqres.in/api/users?page=2");
		JSONObject jo = new JSONObject(res.asString());
		
		for (int i = 0; i< jo.getJSONArray("data").length(); i++)
		{
			String firstName = jo.getJSONArray("data").getJSONObject(i).get("first_name").toString();
			System.out.println(firstName);
		}
		
		
	}

}
