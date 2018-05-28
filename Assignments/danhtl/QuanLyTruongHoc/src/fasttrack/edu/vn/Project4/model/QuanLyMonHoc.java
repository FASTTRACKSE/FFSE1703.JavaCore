package fasttrack.edu.vn.Project4.model;



public class QuanLyMonHoc {
	private String mamon;
	private String tenmon;
	private String sotc;
	private String time;
public QuanLyMonHoc (String mamon,String tenmon,String sotc,String time) {
	this.mamon = mamon;
	this.tenmon = tenmon;
	this.sotc = sotc;
	this.time = time;
}

public QuanLyMonHoc() {
	
}

public String getSotc() {
	return sotc;
}

public void setSotc(String sotc) {
	this.sotc = sotc;
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

public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}
}
