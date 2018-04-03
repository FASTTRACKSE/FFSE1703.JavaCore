package Fasttrack.edu.vn.assignment5;

public class bienlai extends khachhang{
	public double chisomoi;
	public double chisocu;
	public int thang;
	public int nam;
	
	public double getThang() {
		return thang;
	}
	public void setThang(int thang) {
		this.thang = thang;
	}
	public double getNam() {
		return nam;
	}
	public void setNam(int nam) {
		this.nam = nam;
	}
	public  bienlai(String makh, String tenkh,String diachikh,  double macongto,
			double cu, double moi, int thang , int nam) {
		super(makh,tenkh,diachikh,macongto);
		this.thang = thang;
		this.nam = nam;
		this.chisomoi = moi ;
		this.chisocu = cu ;
}
	public bienlai() {}
	public double getChisomoi() {
		return chisomoi;
	}
	public void setChisomoi(double chisomoi) {
		this.chisomoi = chisomoi;
	}
	public double getChisocu() {
		return chisocu;
	}
	public void setChisocu(double chisocu) {
		this.chisocu = chisocu;
	}
	public double tiendien() {
		return ((this.chisomoi)-(this.chisocu))*3000;
	}
	
}