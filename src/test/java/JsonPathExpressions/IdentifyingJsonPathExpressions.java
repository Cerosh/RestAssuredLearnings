package JsonPathExpressions;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class IdentifyingJsonPathExpressions {
@Test
public void displayJsonNodeValue_usingSimpleJsonPath() {
	String json = "{\n"
			+ "    \"firstname\" : \"James\",\n"
			+ "    \"lastname\" : \"Brown\"\n"
			+ "}";
	JsonPath jsonPath = new JsonPath(json);
	Object firstNameObj = jsonPath.get("firstname");
	System.out.println("First Name as Object: "+ firstNameObj);
	
	String firstNameStr = jsonPath.getString("firstname");
	System.out.println("First Name as String:"+ firstNameStr);
	
	System.out.println("Displaying all the key-value pairs as Object in Json object:" +jsonPath.get("$"));
	
	System.out.println("Displaying all the key-value pairs as String in Json object:" +jsonPath.getString(""));
}
}
