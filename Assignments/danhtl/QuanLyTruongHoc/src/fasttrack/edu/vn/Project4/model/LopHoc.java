package fasttrack.edu.vn.Project4.model;

import java.io.Serializable;

public class LopHoc implements Serializable {
	private String malop;
	private String tenlop;
	private String namhoc;
	
	public 	LopHoc() {
		
	}
	public 	LopHoc (String lop,String Tenlop,String nam) {
		this.malop = lop;
		this.tenlop = Tenlop;
		this.namhoc = nam;
		
	}
	public String getMalop() {
		return malop;
	}
	public void setMalop(String malop) {
		this.malop = malop;
	}
	public String getTenlop() {
		return tenlop;
	}
	public void setTenlop(String tenlop) {
		this.tenlop = tenlop;
	}
	public String getNamhoc() {
		return namhoc;
	}
	public void setNamhoc(String namhoc) {
		this.namhoc = namhoc;
	}
}
