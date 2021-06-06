package BodyDataCreatingExistingJSON.JSONWithVariables;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.regex.Pattern;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TestUsingJSONVariables {
	@Test
	void CreateBodyUsingJSONWithVariables() throws FileNotFoundException {
		File file = new File(
				"/Users/ceroshjacob/eclipse-workspace/FirstRestAssuredProject/src/test/java/BodyDataCreatingExistingJSON/JSONWithVariables/BodyWithVariables.json");
		FileReader fr = new FileReader(file);
		JSONTokener jt = new JSONTokener(fr);
		JSONObject jo = new JSONObject(jt);
		String Data = jo.toString();
		Data = Data.replaceAll(Pattern.quote("{{" + "id" + "}}"), "28May02");
		Data = Data.replaceAll(Pattern.quote("{{" + "firstName" + "}}"), "Rohan");
		Data = Data.replaceAll(Pattern.quote("{{" + "Designation" + "}}"), "Student");
		Response Res = given().contentType(ContentType.JSON).body(Data).when().post("http://localhost:3000/friends");
		System.out.println(Res.getStatusLine());
		System.out.println(Res.asPrettyString());

	}

}
