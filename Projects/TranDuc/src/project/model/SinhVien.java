package project.model;

public class SinhVien {
	String codeSv;
	String nameSv;
	String addressSv;
	String wardSv;
	String countySv;
	String citySv;
	String phonenumbSv;
	String emailSv;
	String classSv;
	public SinhVien(String codeSv,String nameSv,String addressSv,
			String wardSv,String countySv,String citySv,String phonenumbSv,
			String emailSv,String classSv) {
		this.codeSv=codeSv;
		this.nameSv=nameSv;
		this.addressSv=addressSv;
		this.wardSv=wardSv;
		this.countySv=countySv;
		this.citySv=citySv;
		this.phonenumbSv=phonenumbSv;
		this.emailSv=emailSv;
		this.classSv=classSv;
	}
	public String getNameSv() {
		return nameSv;
	}
	public void setNameSv(String nameSv) {
		this.nameSv = nameSv;
	}
	public String getAddressSv() {
		return addressSv;
	}
	public void setAddressSv(String addressSv) {
		this.addressSv = addressSv;
	}
	public String getWardSv() {
		return wardSv;
	}
	public void setWardSv(String wardSv) {
		this.wardSv = wardSv;
	}
	public String getCountySv() {
		return countySv;
	}
	public void setCountySv(String countySv) {
		this.countySv = countySv;
	}
	public String getCitySv() {
		return citySv;
	}
	public void setCitySv(String citySv) {
		this.citySv = citySv;
	}
	public String getPhonenumbSv() {
		return phonenumbSv;
	}
	public void setPhonenumbSv(String phonenumbSv) {
		this.phonenumbSv = phonenumbSv;
	}
	public String getEmailSv() {
		return emailSv;
	}
	public void setEmailSv(String emailSv) {
		this.emailSv = emailSv;
	}
	public String getClassSv() {
		return classSv;
	}
	public void setClassSv(String classSv) {
		this.classSv = classSv;
	}
	public void setCodeSv(String codeSv) {
		this.codeSv = codeSv;
	}
	public String getCodeSv() {
		return codeSv;
	}
}
