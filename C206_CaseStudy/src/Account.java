

public class Account {
	
	private String userRole;
	
	private String contactNumber;
	
	private String studentId;
	
	private String username;
	
	public Account(String userRole, String contactNumber, String studentId, String username) {
	this.userRole = userRole;
	this.contactNumber = contactNumber;
	this.studentId = studentId;
	this.username = username;
	
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
public String toString() {
		
		return String.format("%-15s %-10s %-10s %-20s" , getUserRole(),getContactNumber(),getStudentId(), getUsername());
	
	}
public void display() {
	//  Auto-generated method stub
	System.out.println("Role: " + userRole);
	System.out.println("Contact  Number: " + contactNumber);
	System.out.println("Student ID: " + studentId);
	System.out.println("Username: " + username);	
}
}
