package ffse1703005.software.atm.model;

public class UserAdmin {
	private String username,code,password,fullname,position,agency;
	
	public UserAdmin() {
		
	}
	
	public UserAdmin(String username,String code,String password,String fullname,String position,String agency) {
		this.username = username;
		this.code = code;
		this.password = password;
		this.fullname = fullname;
		this.position = position;
		this.agency = agency;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getAgency() {
		return agency;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}
}
