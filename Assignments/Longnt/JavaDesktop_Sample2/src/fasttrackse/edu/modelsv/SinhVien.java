package fasttrackse.edu.modelsv;
import fasttrackse.edu.model.QuanLy;
import fasttrackse.edu.main.*;
import fasttrackse.edu.io.*;
import java.io.Serializable;
import java.util.Comparator;
import java.util.concurrent.ScheduledExecutorService;
public class SinhVien implements Serializable {
	private String maSinhVien;
	private String tenSinhVien;
    private String tuoiSinhVien;
    private String lop;
    
	public SinhVien()  {
		
	}
	public SinhVien(String maSinhVien, String tenSinhVien, String tuoiSinhVien, String lop) {
		super();
		this.maSinhVien=maSinhVien;
		this.tenSinhVien=tenSinhVien;
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
