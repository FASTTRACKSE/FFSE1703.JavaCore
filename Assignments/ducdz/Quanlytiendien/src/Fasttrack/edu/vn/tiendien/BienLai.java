package Fasttrack.edu.vn.tiendien;

public class BienLai extends KhachHang {
	public double chisocu;
	public double chisomoi;
	public double sotienphaitra;
	public int thang;
	public int nam;
	public BienLai(){
		super();
	}
	public BienLai(int maKh,String tenKh,String diachiKh,int macongtoKh,int thang,int nam,double chisocu,double chisomoi) {
		super(maKh,tenKh,diachiKh,macongtoKh);
		this.chisocu=chisocu;
		this.chisomoi=chisomoi;
		this.nam=nam;
		this.thang=thang;
	}
	public void setChisocu(double chisocu) {
		this.chisocu=chisocu;
	}
	public double getChisocu() {
		return this.chisocu;
	}
	public void setChisomoi(double chisomoi) {
		this.chisomoi=chisomoi;
	}
	public double getChisomoi() {
		return this.chisomoi;
	}
	public void setThang(int thang) {
		this.thang=thang;
	}
	public int getThang() {
		return this.thang;
	}
	public void setNam(int nam) {
		this.nam=nam;
	}
	public int getNam() {
		return this.nam;
	}
	public double tinhSotienphaitra() {
		sotienphaitra = ((chisomoi-chisocu)*3000);
		return this.sotienphaitra;
	}
}
