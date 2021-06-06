package json.schema.validation;

import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

public class ValidateJsonAgainstSchema {

	String EmployeeDetails = "{\n"
			+ "    \"id\": 1,\n"
			+ "    \"first_name\": \"Celie\",\n"
			+ "    \"last_name\": \"Boadby\",\n"
			+ "    \"email\": \"cboadby0@t-online.de\",\n"
			+ "    \"gender\": \"Male\",\n"
			+ "    \"Age\": 71,\n"
			+ "    \"Student\": true,\n"
			+ "    \"Address\": [\n"
			+ "      {\n"
			+ "        \"StreetAddress\": \"366 Moulton Parkway\",\n"
			+ "        \"State\": \"California\",\n"
			+ "        \"Country\": \"United States\"\n"
			+ "      }\n"
			+ "    ],\n"
			+ "    \"Phone\": [\n"
			+ "      {\n"
			+ "        \"Mobile\": \"714-138-6081\"\n"
			+ "      },\n"
			+ "      {\n"
			+ "        \"Home\": \"465-681-7889\"\n"
			+ "      }\n"
			+ "    ]\n"
			+ "  }";
	@Test
	public void validate_jsonAgainst_jsonSchema() {
		MatcherAssert.assertThat(EmployeeDetails, JsonSchemaValidator.matchesJsonSchemaInClasspath("EmployeeDetailsResponse.json"));
	}
}
