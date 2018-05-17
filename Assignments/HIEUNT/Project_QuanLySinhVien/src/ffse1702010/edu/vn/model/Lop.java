package ffse1702010.edu.vn.model;

public class Lop {
	private String maLop;
	private String moTa;
	private String nam;

	public Lop() {

	}
	public Lop(String maLop,String moTa,String nam) {
		this.maLop=maLop;
		this.moTa=moTa;
		this.nam=nam;
	
		
		}

	public String getMaLop() {
		return maLop;
	}

	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}


	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public String getNam() {
		return nam;
	}

	public void setNam(String nam) {
		this.nam = nam;
	}

}
