package ffse1702050.edu.vn.model;

public class LophocModel {
	private String MaLop;
	private String MoTa;
	private String NamHoc;
	

	public LophocModel(String MaLop, String MoTa, String NamHoc) {
		this.MaLop = MaLop;
		this.MoTa = MoTa;
		this.NamHoc = NamHoc;

	}



	public LophocModel() {

	}

	public String getMaLop() {
		return MaLop;
	}

	public void setMaLop(String maLop) {
		MaLop = maLop;
	}

	public String getMoTa() {
		return MoTa;
	}

	public void setMoTa(String moTa) {
		MoTa = moTa;
	}

	public String getNamHoc() {
		return NamHoc;
	}

	public void setNamHoc(String namHoc) {
		NamHoc = namHoc;
	}

}
