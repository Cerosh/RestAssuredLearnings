package API_POST_REQUEST.BodyAsArray;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class POJOUsingArray {

	@Test
	void ComplexPOJOUsingArray() {
		POJOComplexAddress[] address = new POJOComplexAddress[2];
		address[0]= new POJOComplexAddress();
		address[1]= new POJOComplexAddress();
		address[0].setH_No("12");
		address[0].setStreet("77 Springs Park");
		address[0].setZipCode("662955");
		address[1].setH_No("89");
		address[1].setStreet("56865 Hoard Plaza");
		address[1].setZipCode("652672");
		
		POJOArrayBasicInfo basicInfo = new POJOArrayBasicInfo();
		basicInfo.setFirstName("Ranbin");
		basicInfo.setLastName("Singh");
		basicInfo.setCourseName("Biology");
		basicInfo.setDesignation("Team Lead");
		basicInfo.setMentorName("Rajath");
		basicInfo.setId("22334");
		basicInfo.setAddress(address);
		
		Response Res	= given()
				.contentType(ContentType.JSON)
				.body(basicInfo)
				.when()
				.post("http://localhost:3000/friends");
		
		System.out.println(Res.getContentType());
		System.out.println(Res.getStatusLine());
		System.out.println(Res.asPrettyString());
				
		
		

	}
	
	
}
