package Header;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;

public class DifferentWaysOfPassingHeaders {
	@Test
	public void addHeaderAsKeyValuePairs() {
		RestAssured.given().header("h1", "v1").log().all().get();
	}

	@Test
	public void addMultipleHeaderAsKeyValuePairs() {
		RestAssured.given().header("h1", "v1").header("h2", "v2").log().all().get();
	}

	@Test
	public void addMultipleValuesAsKeyValuePairs() {
		RestAssured.given().header("h1", "v1", "v2").log().all().get();
	}

	@Test
	public void addMHeaderAsHeaderObject() {
		Header header = new Header("h1", "k1");

		RestAssured.given().header(header).log().all().get();
	}
	@Test
	public void addHeaderUsingHeadersMethod() {
		RestAssured.given().headers("h1", "v1","h2", "v2").log().all().get();
	}
	
	@Test
	public void addHeadersUsingMap() {
		Map<String,String> headerMap = new HashMap<>();
		headerMap.put("h1", "k1");
		headerMap.put("h2", "k2");
		RestAssured.given().headers(headerMap).log().all().get();
	}
}
