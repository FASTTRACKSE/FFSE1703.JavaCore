package fasttrackse.edu.modelsv;
import fasttrackse.edu.model.*;
import fasttrackse.edu.main.*;
import java.util.Comparator;
public class SinhVien {
	private String maSinhVien;
	private String tenSinhVien;
    private String tuoiSinhVien;
    private String lop;
	public SinhVien() {
		
	}
	public SinhVien(String maSinhVien, String tenSinhVien, String tuoiSinhVien, String lop) {
		super();
		this.maSinhVien=maSinhVien;
		this.tenSinhVien=maSinhVien;
		this.tuoiSinhVien=tuoiSinhVien;
		this.lop=lop;
	}
	public String getMaSinhVien() {
		return maSinhVien;
	}
	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}
	public String getTenSinhVien() {
		return tenSinhVien;
	}
	public void setTenSinhVien(String tenSinhVien) {
		this.tenSinhVien = tenSinhVien;
	}
	public String getTuoiSinhVien() {
		return tuoiSinhVien;
	}
	public void setTuoiSinhVien(String tuoiSinhVien) {
		this.tuoiSinhVien = tuoiSinhVien;
	}
	public String getLop() {
		return lop;
	}
	public void setLop(String lop) {
		this.lop = lop;
	}
	
}
