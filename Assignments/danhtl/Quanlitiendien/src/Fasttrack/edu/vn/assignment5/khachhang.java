package Fasttrack.edu.vn.assignment5;

public class khachhang {
	public String makh;
	public String tenkh;
	public String diachikh;
	public double macongto;
	public khachhang(String makh, String tenkh,String diachikh, double macongto ) {

		this.makh =makh;
		this.tenkh =tenkh;
		this.diachikh = diachikh;
		this.macongto = macongto;
		

	}
	public khachhang() {
		
	}

	public String getMakh() {
		return makh;
	}
	public void setMakh(String makh) {
		this.makh = makh;
	}
	public String getTenkh() {
		return tenkh;
	}
	public void setTenkh(String tenkh) {
		this.tenkh = tenkh;
	}
	public String getDiachikh() {
		return diachikh;
	}
	public void setDiachikh(String diachikh) {
		this.diachikh = diachikh;
	}
	public double getMacongto() {
		return macongto;
	}
	public void setMacongto(double macongto) {
		this.macongto = macongto;
	}
}
