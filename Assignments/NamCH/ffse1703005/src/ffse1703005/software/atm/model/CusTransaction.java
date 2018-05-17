package ffse1703005.software.atm.model;

import java.sql.Timestamp;

public class CusTransaction extends Transaction {
	private String codeCus,fullnameCus,codeATM,districts,wards,streets,status;
	public CusTransaction() {
		super();
	}
	public CusTransaction(String codeTransaction,Timestamp timeTransaction,float payTransaction,
			String codeCus,String fullnameCus,String codeATM,String districts,String wards,String streets,String status) {
		super(codeTransaction,timeTransaction,payTransaction);
		this.codeCus = codeCus;
		this.fullnameCus = fullnameCus;
		this.codeATM = codeATM;
		this.districts = districts;
		this.wards = wards;
		this.streets = streets;
		this.status = status;
	}
	public String getCodeCus() {
		return codeCus;
	}
	public void setCodeCus(String codeCus) {
		this.codeCus = codeCus;
	}
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
	public String getFullnameCus() {
		return fullnameCus;
	}
	public void setFullnameCus(String fullnameCus) {
		this.fullnameCus = fullnameCus;
	}
	public String getCodeATM() {
		return codeATM;
	}
	public void setCodeATM(String codeATM) {
		this.codeATM = codeATM;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
