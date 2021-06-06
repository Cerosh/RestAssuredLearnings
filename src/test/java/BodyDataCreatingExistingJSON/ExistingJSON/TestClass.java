package BodyDataCreatingExistingJSON.ExistingJSON;
import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TestClass {
	@Test
	void CreateBodyUsingJSON() throws FileNotFoundException {
		File file = new File("/Users/ceroshjacob/eclipse-workspace/FirstRestAssuredProject/src/test/java/BodyDataCreatingExistingJSON/Body.json");
		FileReader fr = new FileReader(file);
		JSONTokener jt = new JSONTokener(fr);
		JSONObject jo = new JSONObject(jt);
		
		Response res = 
				given().contentType(ContentType.JSON).body(jo.toString())
				.when().post("http://localhost:3000/friends");
		System.out.println(res.statusCode());
		System.out.println(res.asPrettyString());
	}

}
