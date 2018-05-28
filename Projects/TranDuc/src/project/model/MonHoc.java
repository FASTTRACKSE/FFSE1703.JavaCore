package project.model;

public class MonHoc {
	String maMh;
	String nameMh;
	String tinchiMh;
	String timeMh;
	public MonHoc(String maMh,String nameMh,String tinchiMh,String timeMh) {
		this.maMh=maMh;
		this.nameMh=nameMh;
		this.tinchiMh=tinchiMh;
		this.timeMh=timeMh;
	}
	public String getMaMh() {
		return maMh;
	}
	public void setMaMh(String maMh) {
		this.maMh = maMh;
	}
	public String getNameMh() {
		return nameMh;
	}
	public void setNameMh(String nameMh) {
		this.nameMh = nameMh;
	}
	public String getTinchiMh() {
		return tinchiMh;
	}
	public void setTinchiMh(String tinchiMh) {
		this.tinchiMh = tinchiMh;
	}
	public String getTimeMh() {
		return timeMh;
	}
	public void setTimeMh(String timeMh) {
		this.timeMh = timeMh;
	}
	
}
