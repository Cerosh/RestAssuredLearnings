package API_POST_REQUEST.KeyValueJSON;

public class JSONUsingPOJO {
	String	Name;
	String Job;
	String Email;
	String Password;
	
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	public String getJob() {
		return Job;
	}
	public void setJob(String job) {
		this.Job = job;
	}

}
