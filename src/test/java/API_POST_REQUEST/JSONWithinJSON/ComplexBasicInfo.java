package API_POST_REQUEST.JSONWithinJSON;

public class ComplexBasicInfo {
	String FirstName;
	String LastName;
	String Designation;
	String Id;
	String MentorName;
	String CourseName;
	ComplexAdress address; 

	
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getDesignation() {
		return Designation;
	}
	public void setDesignation(String designation) {
		Designation = designation;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getMentorName() {
		return MentorName;
	}
	public void setMentorName(String mentorName) {
		MentorName = mentorName;
	}
	public String getCourseName() {
		return CourseName;
	}
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	public ComplexAdress getAddress() {
		return address;
	}
	public void setAddress(ComplexAdress address) {
		this.address = address;
	}
	
}
