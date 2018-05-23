package fasttrack.edu.vn.Project4.model;



public class QuanLyMonLop {
	private String malop1;
	private String mamon;
	private String tenmon;

public  QuanLyMonLop(String malop1,String mamon, String tenmon) {
	this.malop1 = malop1;
	this.mamon = mamon;
	this.tenmon = tenmon;
}
public  QuanLyMonLop() {
	
}
public String getMalop1() {
	return malop1;
}

public void setMalop1(String malop1) {
	this.malop1 = malop1;
}

public String getMamon() {
	return mamon;
}

public void setMamon(String mamon) {
	this.mamon = mamon;
}

public String getTenmon() {
	return tenmon;
}

public void setTenmon(String tenmon) {
	this.tenmon = tenmon;
}


}