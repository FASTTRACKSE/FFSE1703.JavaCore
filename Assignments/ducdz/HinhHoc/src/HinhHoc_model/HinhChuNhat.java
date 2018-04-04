package HinhHoc_model;

public class HinhChuNhat extends HinhHoc{
	public double chieuDai;
	public double chieuRong;
	public void setchieuDai(double chieuDai) {
		this.chieuDai=chieuDai;
	}
	public double getchieuDai() {
		return this.chieuDai;
	}
	public void setchieuRong(double chieuRong) {
		this.chieuRong=chieuRong;
	}
	public double getchieuRong() {
		return this.chieuRong;
	}
	public void tinhChuvi(double chieuDai,double chieuRong) {
		chuvi=(chieuDai+chieuRong)*2;
	}
	public void tinhDientich(double chieuDai,double chieuRong) {
		dientich=(chieuRong*chieuDai);
	}
	public double getChuviHCN() {
		return this.chuvi;
	}
	public double getDientichHCN() {
		return this.dientich;
	}
	public HinhChuNhat(){
		super();
	}
	public HinhChuNhat(double chuvi,double dientich,double chieuDai,double chieuRong) {
		super(chuvi,dientich);
		this.chieuDai=chieuDai;
		this.chieuRong=chieuRong;
	}
}
