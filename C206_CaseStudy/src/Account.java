
/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 19043384, 15 Aug 2020 1:29:15 am
 */

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
	
}
