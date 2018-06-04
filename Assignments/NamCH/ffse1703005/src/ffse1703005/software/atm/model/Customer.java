package ffse1703005.software.atm.model;

public class Customer {
	private String codeCus,fullnameCus,streetCus,emailCus,cardnumberCus,phoneCus,pin,nameDistricts,nameWards;
	private int districtCus,wardCus,amountCus;
	
	public Customer() {
		
	}
	
	public Customer(String codeCus,String fullnameCus,int districtCus,int wardCus,
			String streetCus,String phoneCus,String emailCus,String cardnumberCus,String pin,int amountCus,String nameDistricts,String nameWards) {
		this.codeCus =  codeCus;
		this.fullnameCus = fullnameCus;
		this.districtCus = districtCus;
		this.wardCus = wardCus;
		this.streetCus =  streetCus;
		this.phoneCus = phoneCus;
		this.emailCus = emailCus;
		this.cardnumberCus = cardnumberCus;
		this.pin = pin;
		this.amountCus = amountCus;
		this.nameDistricts = nameDistricts;
		this.nameWards = nameWards;
		
	}

	public String getCodeCus() {
		return codeCus;
	}

	public void setCodeCus(String codeCus) {
		this.codeCus = codeCus;
	}

	public String getFullnameCus() {
		return fullnameCus;
	}

	public void setFullnameCus(String fullnameCus) {
		this.fullnameCus = fullnameCus;
	}

	public int getDistrictCus() {
		return districtCus;
	}

	public void setDistrictCus(int districtCus) {
		this.districtCus = districtCus;
	}

	public int getWardCus() {
		return wardCus;
	}

	public void setWardCus(int wardCus) {
		this.wardCus = wardCus;
	}

	public String getStreetCus() {
		return streetCus;
	}

	public void setStreetCus(String streetCus) {
		this.streetCus = streetCus;
	}

	public String getEmailCus() {
		return emailCus;
	}

	public void setEmailCus(String emailCus) {
		this.emailCus = emailCus;
	}

	public String getCardnumberCus() {
		return cardnumberCus;
	}

	public void setCardnumberCus(String cardnumberCus) {
		this.cardnumberCus = cardnumberCus;
	}

	public String getPhoneCus() {
		return phoneCus;
	}

	public void setPhoneCus(String phoneCus) {
		this.phoneCus = phoneCus;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public int getAmountCus() {
		return amountCus;
	}

	public void setAmountCus(int amountCus) {
		this.amountCus = amountCus;
	}

	public String getNameDistricts() {
		return nameDistricts;
	}

	public void setNameDistricts(String nameDistricts) {
		this.nameDistricts = nameDistricts;
	}

	public String getNameWards() {
		return nameWards;
	}

	public void setNameWards(String nameWards) {
		this.nameWards = nameWards;
	}

	public void add(String code, String fullname, int keyDistricts, int keyWards, String street, String phoneDb,
			String email, String accountNumber, String i, int balanceDb) {
		this.codeCus =  code;
		this.fullnameCus = fullname;
		this.districtCus = keyDistricts;
		this.wardCus = keyWards;
		this.streetCus =  street;
		this.phoneCus = phoneDb;
		this.emailCus = email;
		this.cardnumberCus = accountNumber;
		this.pin = i;
		this.amountCus = balanceDb;		
	}
}
