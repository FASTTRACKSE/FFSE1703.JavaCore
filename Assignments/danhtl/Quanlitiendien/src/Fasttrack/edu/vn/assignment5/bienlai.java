package Fasttrack.edu.vn.assignment5;

public class bienlai extends khachhang{
	public double chisomoi;
	public double chisocu;
	public  bienlai(String makh, String tenkh,String diachikh,  double macongto,
			double cu, double moi) {
		super(makh,tenkh,diachikh,macongto);
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