package json.object.payload;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class CreateUsingJavaMap {

	@Test
	public void creatingSortedJsonObjectPayload_usingJavaHashMap() {
		Map<String, String> objectPayload = new HashMap<>();
		objectPayload.put("first_name", "Celie");
		objectPayload.put("married", "false");
		objectPayload.put("salary", "123.45");
		objectPayload.put("id", "1");

		RestAssured.given().body(objectPayload).log().all().when().get().then();

	}

	@Test
	public void creatingUnsortedJsonObjectPayload_usingJavaLinkedHashMap() {
		Map<String, Object> objectPayloadWithDataType = new LinkedHashMap<String, Object>();
		objectPayloadWithDataType.put("first_name", "Celie");
		objectPayloadWithDataType.put("married", false);
		objectPayloadWithDataType.put("salary", 123.4);
		objectPayloadWithDataType.put("id", 3);
		RestAssured.given().body(objectPayloadWithDataType).log().all().get().then();
	}

	@Test
	public void createNestedJsonObjectPayLoad_using_JavaHashMap() {
		Map<String, Object> nestedObjectPayLoad = new HashMap<String, Object>();
		nestedObjectPayLoad.put("first_name", "Celie");
		nestedObjectPayLoad.put("married", false);
		nestedObjectPayLoad.put("salary", 123.4);
		nestedObjectPayLoad.put("id", 3);
		Map<String, String> addressObjectPayload = new HashMap<String, String>();
		addressObjectPayload.put("StreetAddress", "366 Moulton Parkway");
		addressObjectPayload.put("State", "California");
		addressObjectPayload.put("Country", "United States");
		nestedObjectPayLoad.put("address", addressObjectPayload);
		RestAssured.given().body(nestedObjectPayLoad).log().all().get().then();
	}
	@Test
	public void createJsonArrayPayload_using_list() {
		Map<String, Object> objectPayload = new LinkedHashMap<String, Object>();
		Map<String, Object> objectPayload1 = new LinkedHashMap<String, Object>();
		objectPayload.put("first_name", "Celie");
		objectPayload.put("married", false);
		objectPayload.put("salary", 123.4);
		objectPayload.put("id", 3);
		
		objectPayload1.put("first_name", "Sutherland");
		objectPayload1.put("married", false);
		objectPayload1.put("salary", 129.9);
		objectPayload1.put("id", 5);
		List<Map<String, Object>> payloadList = new ArrayList<Map<String, Object>>();
		payloadList.add(objectPayload);
		payloadList.add(objectPayload1);
		RestAssured.given().body(payloadList).log().all().when().get().then();
	}
	@Test
	public void createComplexJsonPayload_using_list_HashMap()
	{
		Map<String, Object> objectPayload1 = new LinkedHashMap<String, Object>();
		Map<String, Object> objectPayload2 = new LinkedHashMap<String, Object>();
		objectPayload1.put("first_name", "Celie");
		objectPayload1.put("married", false);
		objectPayload1.put("salary", 123.4);
		objectPayload1.put("id", 3);
		
		objectPayload2.put("first_name", "Sutherland");
		objectPayload2.put("married", false);
		objectPayload2.put("salary", 129.9);
		objectPayload2.put("id", 5);
		
		List<String> mobileObject1 = Arrays.asList("24724327947283","23423423");
		List<String> mobileObject2 = Arrays.asList("123456","145567868");
		objectPayload1.put("Mobile", mobileObject1);
		objectPayload2.put("Mobile", mobileObject2);
		
		Map<String, String> skillsetObject1 = new HashMap<String, String>();
		Map<String,Object> skillsetObject2 = new HashMap<String, Object>();
		skillsetObject1.put("name", "Testing");
		skillsetObject1.put("proficency", "Medium");
		skillsetObject2.put("name", "Java");
		skillsetObject2.put("proficency", "Medium");
		List<String> certificationObject = Arrays.asList("OCJP 11","OCJP 12");
		skillsetObject2.put("certification", certificationObject);
		objectPayload1.put("Skills", skillsetObject1);
		objectPayload2.put("Skills", skillsetObject2);
		
		
		List<Map<String, Object>> payloadList = new ArrayList<Map<String, Object>>();
		payloadList.add(objectPayload1);
		payloadList.add(objectPayload2);
		RestAssured.given().body(payloadList).log().all().when().get().then();
	}
}
