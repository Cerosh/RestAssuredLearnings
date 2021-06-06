package API_POST_REQUEST.KeyValueJSON;

import org.testng.annotations.Test;

import API_POST_REQUEST.JSONWithinJSON.ComplexAdress;
import API_POST_REQUEST.JSONWithinJSON.ComplexBasicInfo;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ComplexJSONUsingPOJO {
	@Test
	void PostRqstComplexPOJO() {
		ComplexAdress address = new ComplexAdress();
		address.setH_No("22");
		address.setStreet("Kumba");
		address.setZipCode("2287");

		ComplexBasicInfo basicInfo = new ComplexBasicInfo();
		basicInfo.setCourseName("MCA");
		basicInfo.setFirstName("Cerosh");
		basicInfo.setLastName("Jacob");
		basicInfo.setDesignation("Automation");
		basicInfo.setMentorName("Alex");
		basicInfo.setId("3892");
		basicInfo.setAddress(address);
		
		Response resp = given()
				.contentType(ContentType.JSON)
				.body(basicInfo)
				.when()
				.post("http://localhost:3000/friends");
		System.out.println(resp.getStatusLine());
		System.out.println(resp.asPrettyString());

	}

}
