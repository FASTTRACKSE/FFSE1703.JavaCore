package ffse1703005.software.atm.model;

import java.sql.Timestamp;

public class ATMTransaction extends Transaction {
	private String codeATM,adressATM,codeCus,districts,wards,streets;
	public String getDistricts() {
		return districts;
	}
	public void setDistricts(String districts) {
		this.districts = districts;
	}
	public String getWards() {
		return wards;
	}
	public void setWards(String wards) {
		this.wards = wards;
	}
	public String getStreets() {
		return streets;
	}
	public void setStreets(String streets) {
		this.streets = streets;
	}
	public ATMTransaction() {
		super();
	}
	public ATMTransaction(String codeTransaction,Timestamp timeTransaction,float payTransaction,
			String codeATM,String adressATM,String codeCus,String districts,String wards,String streets) {
		super(codeTransaction,timeTransaction,payTransaction);
		this.codeATM = codeATM;
		this.adressATM = adressATM;
		this.codeCus = codeCus;	
		this.districts = districts;
		this.wards = wards;
		this.streets = streets;
	}
	public String getCodeATM() {
		return codeATM;
	}
	public void setCodeATM(String codeATM) {
		this.codeATM = codeATM;
	}
	public String getAdressATM() {
		return adressATM;
	}
	public void setAdressATM(String adressATM) {
		this.adressATM = adressATM;
	}
	public String getCodeCus() {
		return codeCus;
	}
	public void setCodeCus(String codeCus) {
		this.codeCus = codeCus;
	}
}
