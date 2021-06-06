package assertion.jsonpath.restassured;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

public class TypesOfAssertions {
	@Test
	public void extractingTheValue_assertingTheExtractedValue() {
		String responseAsString = RestAssured.given().baseUri("https://restful-booker.herokuapp.com/auth")
				.contentType(ContentType.JSON)
				.body("{\n" + "    \"username\" : \"admin\",\n" + "    \"password\" : \"password123\"\n" + "}").when()
				.post().then().log().all().extract().asString();
		JsonPath jsonpath = new JsonPath(responseAsString);
		Assert.assertNotNull(jsonpath.get("token"));
		Assert.assertEquals(jsonpath.get("token.length()"), 15);
	}

	@Test
	public void withoutExtractingTheValue_assertingInlineWithValues() {
		RestAssured.given().baseUri("https://restful-booker.herokuapp.com/auth").contentType(ContentType.JSON)
				.body("{\r\n" + "    \"username\" : \"admin\",\r\n" + "    \"password\" : \"password123\"\r\n" + "}")
				.when().post().then().log().all().body("token", Matchers.notNullValue())
				.body("token.length()", Matchers.greaterThanOrEqualTo(15)).body("token.length()", Matchers.is(15))
				.body("token", Matchers.matchesRegex("^[a-z0-9]+$"));

	}
	
	@Test
	public void inlineAssertion_forArrayValues() {
		RestAssured.given().baseUri("https://restful-booker.herokuapp.com/booking").
		contentType(ContentType.JSON).
		when().get().
		then().log().all().
		body("bookingid", Matchers.hasItems(9,1)).
		body("[0].bookingid",Matchers.notNullValue()).
		body("bookingid.size()",Matchers.greaterThanOrEqualTo(11));	}

}
