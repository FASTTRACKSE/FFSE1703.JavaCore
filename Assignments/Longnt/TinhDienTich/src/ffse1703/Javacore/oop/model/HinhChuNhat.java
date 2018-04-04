package ffse1703.Javacore.oop.model;

 public class HinhChuNhat extends HinhHoc {
	double chieudai, chieurong;
	public HinhChuNhat() {
		
	}
    public HinhChuNhat(double chieudai, double chieurong) {
    	this.chieudai = chieudai;
    	this.chieurong = chieurong;
    }
	public double getChieudai() {
		return chieudai;
	}

	public void setChieudai(double chieudai) {
		this.chieudai = chieudai;
	}

	public double getChieurong() {
		return chieurong;
	}

	public void setChieurong(double chieurong) {
		this.chieurong = chieurong;
	}
	public double getChuVi() {
		return (chieudai + chieurong)*2;
	}
    public double getDienTich() {
    	return chieudai*chieurong;
    }
}
