package ffse1703.javacore.model;

 public class HinhChuNhat extends HinhHoc {
	private static double chieuDai, chieuRong;
	 
    public HinhChuNhat(double chieuDai, double chieuRong) {
        super();
        this.chieuDai = chieuDai;
        this.chieuRong = chieuRong;
    }
 
    public double getChieuDai() {
		return chieuDai;
	}

	public void setChieuDai(double chieuDai) {
		this.chieuDai = chieuDai;
	}

	public double getChieuRong() {
		return chieuRong;
	}

	public void setChieuRong(double chieuRong) {
		this.chieuRong = chieuRong;
	}

	public double getChuVi() {
        return (chieuDai + chieuRong) * 2;
    }
     
    public double getDienTich() {
        return chieuDai * chieuRong;
    }
}
