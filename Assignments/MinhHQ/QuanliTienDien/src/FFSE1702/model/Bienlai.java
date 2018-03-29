package FFSE1702.model;

public class Bienlai extends KhachHang {

	public double Chisotruoc;
	public double Chisosau;
	
	public Bienlai () {
		
	}
	public Bienlai (String KH, String name, String address, String ct, double ago, double after) {
		super(KH,name,address,ct);
		this.Chisotruoc = ago;
		this.Chisosau = after;
	}
	
	public double getChisotruoc() {
		return Chisotruoc;
	}
	public void setChisotruoc(double chisotruoc) {
		Chisotruoc = chisotruoc;
	}
	public double getChisosau() {
		return Chisosau;
	}
	public void setChisosau(double chisosau) {
		Chisosau = chisosau;
	}
	
	
	public double tienDien() {
		return (this.Chisosau - this.Chisotruoc)*3000;
	}
	
}
