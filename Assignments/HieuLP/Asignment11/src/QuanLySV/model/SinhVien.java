package QuanLySV.model;

import java.io.Serializable;
import java.util.Scanner;

public class SinhVien  implements Serializable {
	public static Scanner myScanner = new Scanner(System.in);
	private String MaSV;
	private String TenSV;
	private String TuoiSV;
	private String LopSV;
	
	public SinhVien(String MaSV, String TenSV, String TuoiSV, String LopSV ) {
		this.MaSV = MaSV;
		this.TenSV = TenSV;
		this.TuoiSV = TuoiSV;
		this.LopSV = LopSV;
		}

	public SinhVien() {

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

	public void setLopSV(String lopSV) {
		LopSV = lopSV;
	}
	

}
