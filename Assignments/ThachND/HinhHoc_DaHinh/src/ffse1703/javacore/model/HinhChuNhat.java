package ffse1703.javacore.model;

abstract public class HinhChuNhat extends HinhHoc {
	protected double chieuDai, chieuRong;
	 
    public HinhChuNhat(double chieuDai, double chieuRong) {
        super();
        this.chieuDai = chieuDai;
        this.chieuRong = chieuRong;
    }
 
    public double tinhChuVi() {
        return (chieuDai + chieuRong) * 2;
    }
     
    public double tinhDienTich() {
        return chieuDai * chieuRong;
    }
}
