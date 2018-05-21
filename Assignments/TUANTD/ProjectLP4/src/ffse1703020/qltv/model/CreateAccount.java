package ffse1703020.qltv.model;

public class CreateAccount {
	private String id, name, username, password;

	public CreateAccount() {
		super();
	}

	public CreateAccount(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		name = name.toLowerCase().replaceAll("\\s", "");
		name = name.replaceAll("[à|á|ạ|ả|ã|â|ầ|ấ|ậ|ẩ|ẫ|ă|ằ|ắ|ặ|ẳ|ẵ]", "a");
		name = name.replaceAll("[è|é|ẹ|ẻ|ẽ|ê|ề|ế|ệ|ể|ễ]", "e");
		name = name.replaceAll("[ì|í|ị|ỉ|ĩ]", "i");
		name = name.replaceAll("[ò|ó|ọ|ỏ|õ|ô|ồ|ố|ộ|ổ|ỗ|ơ|ờ|ớ|ợ|ở|ỡ]", "o");
		name = name.replaceAll("[ù|ú|ụ|ủ|ũ|ư|ừ|ứ|ự|ử|ữ]", "u");
		name = name.replaceAll("[ỳ|ý|ỵ|ỷ|ỹ]", "y");
		name = name.replaceAll("[đ]", "d");

		id = id.replaceFirst("^0+(?!$)", "");

		username = name + id;

		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		setPassword(username);
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}