package ffse1703005.software.atm.model;

public class MachineATM {
	private String codeATM,streetATM,nameDistricts,nameWards;
	private int amountATM,districtATM,wardATM;
	
	public MachineATM() {
	
	}
	
	public MachineATM(String codeATM,int districtATM,int wardATM,
			String streetATM,int amountATM,String nameDistricts,String nameWards) {
		this.codeATM =  codeATM;
		this.districtATM = districtATM;
		this.wardATM = wardATM;
		this.streetATM =  streetATM;
		this.amountATM = amountATM;	
		this.nameDistricts = nameDistricts;	
		this.nameWards = nameWards;	
	}

	public String getCodeATM() {
		return codeATM;
	}

	public void setCodeATM(String codeATM) {
		this.codeATM = codeATM;
	}

	public int getDistrictATM() {
		return districtATM;
	}

	public void setDistrictATM(int districtATM) {
		this.districtATM = districtATM;
	}

	public int getWardATM() {
		return wardATM;
	}

	public void setWardATM(int wardATM) {
		this.wardATM = wardATM;
	}

	public String getStreetATM() {
		return streetATM;
	}

	public void setStreetATM(String streetATM) {
		this.streetATM = streetATM;
	}

	public int getAmountATM() {
		return amountATM;
	}

	public void setAmountATM(int amountATM) {
		this.amountATM = amountATM;
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

	public void add(String code, int keyDistricts, int keyWards, String street, int balance) {
		// TODO Auto-generated method stub
		this.codeATM =  code;
		this.districtATM = keyDistricts;
		this.wardATM = keyWards;
		this.streetATM =  street;
		this.amountATM = balance;		
	}
}
