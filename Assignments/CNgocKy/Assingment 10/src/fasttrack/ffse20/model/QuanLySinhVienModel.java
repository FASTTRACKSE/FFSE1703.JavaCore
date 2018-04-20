package fasttrack.ffse20.model;
import java.util.Scanner;
public class QuanLySinhVienModel {
private String MaSV , TenSV , TuoiSV, LopSV;

public QuanLySinhVienModel(String maSV, String tenSV, String tuoiSV, String lopSV) {
	super();
	MaSV = maSV;
	TenSV = tenSV;
	TuoiSV = tuoiSV;
	LopSV = lopSV;
}

public String getMaSV() {
	return MaSV;
}

public void setMaSV(String maSV) {
	MaSV = maSV;
}

public String getTenSV() {
	return TenSV;
}

public void setTenSV(String tenSV) {
	TenSV = tenSV;
}

public String getTuoiSV() {
	return TuoiSV;
}

public void setTuoiSV(String tuoiSV) {
	TuoiSV = tuoiSV;
}
public String getLopSV() {
	return LopSV;
}
public void setlopSV(String lopSV) {
	TuoiSV = lopSV;
}
}
