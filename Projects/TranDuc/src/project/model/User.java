package project.model;

public class User {
	String userID;
	String userName;
	String userPass;
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public User(String userID, String userName, String userPass) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.userPass = userPass;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	
}
