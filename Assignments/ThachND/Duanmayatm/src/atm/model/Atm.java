package atm.model;

public class Atm {
	private String maMay, DiaChiDat, SoDu, quan, phuong;
	public Atm() {
		
	}
	public Atm(String maMay, String DiaChiDat, String SoDu, String quan, String phuong) {
		this.maMay = maMay;
		this.DiaChiDat = DiaChiDat;
		this.SoDu = SoDu;
		this.quan = quan;
		this.phuong = phuong;
	}
	public String getMaMay() {
		return maMay;
	}
	public void setMaMay(String maMay) {
		this.maMay = maMay;
	}
	public String getDiaChiDat() {
		return DiaChiDat;
	}
	public void setDiaChiDat(String diaChiDat) {
		DiaChiDat = diaChiDat;
	}
	public String getSoDu() {
		return SoDu;
	}
	public void setSoDu(String soDu) {
		SoDu = soDu;
	}
	public String getQuan() {
		return quan;
	}
	public void setQuan(String quan) {
		this.quan = quan;
	}
	public String getPhuong() {
		return phuong;
	}
	public void setPhuong(String phuong) {
		this.phuong = phuong;
	}
	@Override
	public String toString() {
		return this.maMay;
	}
	
	
}
