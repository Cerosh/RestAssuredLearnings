package JsonPathExpressions;

import java.io.File;
import java.util.ArrayList;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class JsonUsingGSon {

	String dirPath = File.separator + "src" + File.separator + "test" + File.separator + "java" + File.separator
			+ "JsonPathExpressions" + File.separator + "Json_Example.json";
	String filePath = System.getProperty("user.dir") + dirPath;
	File jsonArrayFile = new File(filePath);
	JsonPath jsonPath = new JsonPath(jsonArrayFile);

	@Test
	public void access_firstEmployeeDetails_FromJsonFile() {
		Object object = jsonPath.get("[0]");
		System.out.println("First Employee Details: " + object);
	}
	@Test
	public void access_firstAndSecondEmployeeDetails_FromJsonFile() {
		Object object = jsonPath.get("[0]");
		System.out.println("First And Second Employee Details: " + object);
	}
	
	@Test
	public void access_firstEmployeesFirstName_FromJsonFile() {
		String firstName= jsonPath.getString("[0].first_name");
		System.out.println("First Employees First Name: "+ firstName);
	}
	@Test
	public void access_firstEmployeesAge_FromJsonFile() {
		int age= jsonPath.getInt("[0].Age");
		System.out.println("First Employees Age: "+ age);
	}
	@Test
	public void access_firstEmployeesAddress_FromJsonFile() {
		List<Object>  Address= jsonPath.getList("[0].Address");
		System.out.println("First Employees Address: "+ Address);
	}
	@Test
	public void access_firstNameOfAllEmployees_FromJsonFile() {
		List<Object>  firstNameList= jsonPath.getList("first_name");
		System.out.println("Employees First Name List: "+ firstNameList);
	}
	
	@Test
	public void access_firstNameOfAllFemaleEmployees_FromJsonFile() {
		List <String> femaleFirstNameList = jsonPath.getList("findAll{it.gender == 'Female'}.first_name");
		System.out.println("Employees First Name List: "+ femaleFirstNameList);
	}
	
	@Test
	public void access_emailWithFirstAndLastName_FromJsonFile() {
		String emailAddress = jsonPath.getString("find{it.first_name == 'Guenna' & it.last_name== 'Gyurko'}.email");
		System.out.println("Employees First Name List: "+ emailAddress);
	}
//	@Test
//	public void access_detailsOfEmployeesFromCaliforniaOrUnitedStates_FromJsonFile() {
//		String  emailId = jsonPath.getString("Address.findAll{it.StreetAddress =='366 Moulton Parkway'}");
//		System.out.println(emailId);
//	}
	
	@Test
	public void access_detailsOfEmployeesOlderThan50_fromJsonFile() {
		List<String>oldEmployees = jsonPath.getList("findAll{it.Age >= 50}.id");
		System.out.println(oldEmployees);
	}
	
	@Test
	public void access_countOfEmployeeRecords_fromJsonFile() {
		System.out.println("Number Of Employee Records are: " + jsonPath.getInt("size()"));
	}
	@Test
	public void access_oldestEmployeeRecords_fromJsonFile() {
		System.out.println("Age Of Oldest Employee: " + jsonPath.getInt("Age.max()"));
	}
	
}
