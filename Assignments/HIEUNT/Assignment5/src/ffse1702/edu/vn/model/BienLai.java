package ffse1702.edu.vn.model;

public class BienLai extends KhachHang {
	public Double chisocu;
	public Double chisomoi;
	public int thang;
	public int nam;

	public int getThang() {
		return thang;
	}

	public void setThang(int thang) {
		this.thang = thang;
	}

	public int getNam() {
		return nam;
	}

	public void setNam(int nam) {
		this.nam = nam;
	}

	public double getchisocu() {
		return chisocu;
	}

	public void setchisocu(double chisocu) {
		this.chisocu = chisocu;
	}

	public double getchisomoi() {
		return chisomoi;
	}

	public void setchisomoi(double chisomoi) {
		this.chisomoi = chisomoi;

	}

	public BienLai() {
		super();

	}

	public BienLai(Double macongto, Double chisocu, Double chisomoi) {
		this.chisocu = chisocu;
		this.chisomoi = chisomoi;
		super.macongto=macongto;

	}
	public Double tinhtien() {
	return	(this.chisocu+this.chisomoi)*3000;
	}
}
