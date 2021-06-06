package BodyDataCreatingExistingJSON.JSONWithRunTimeVariables;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Pattern;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TestUsingJSONRunTimeVariables {
	@Test
	void CreateBodyUsingJSONWithVariables() throws FileNotFoundException {
		File file = new File(
				"/Users/ceroshjacob/eclipse-workspace/FirstRestAssuredProject/src/test/java/BodyDataCreatingExistingJSON/JSONWithRunTimeVariables/BodyWithVariables.json");
		FileReader fr = new FileReader(file);
		JSONTokener jt = new JSONTokener(fr);
		JSONObject jo = new JSONObject(jt);
		String id, firstName, Designation;
		Scanner Variables = new Scanner(System.in);
		System.out.println("Enter the id: ");	
		id = Variables.next();
		System.out.println("Enter the First name: ");	
		firstName = Variables.next();
		System.out.println("Enter the designation: ");	
		Designation = Variables.next();

		String Data = jo.toString();
		Data = Data.replaceAll(Pattern.quote("{{" + "id" + "}}"), id);
		Data = Data.replaceAll(Pattern.quote("{{" + "firstName" + "}}"), firstName);
		Data = Data.replaceAll(Pattern.quote("{{" + "Designation" + "}}"), Designation);

		Response Res = 
				given().contentType(ContentType.JSON).body(Data)
				.when().post("http://localhost:3000/friends");
		System.out.println(Res.getStatusLine());
		System.out.println(Res.asPrettyString());

	}

}
