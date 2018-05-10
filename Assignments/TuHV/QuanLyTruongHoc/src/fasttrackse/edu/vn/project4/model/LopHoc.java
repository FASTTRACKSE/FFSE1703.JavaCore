package fasttrackse.edu.vn.project4.model;

public class LopHoc {
	private String malop;
	private String tenlop;
	private String namhoc;
	
	public LopHoc(String malop, String tenlop,  String namhoc) {
		this.malop = malop;
		this.tenlop = tenlop;
		this.namhoc = namhoc;
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
