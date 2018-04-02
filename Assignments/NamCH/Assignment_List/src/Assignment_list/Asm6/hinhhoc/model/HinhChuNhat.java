package Assignment_list.Asm6.hinhhoc.model;

public class HinhChuNhat extends HinhHoc{
	private int chieuDai;
	private int chieuRong;
	public HinhChuNhat() {
		
	}
	
	public HinhChuNhat(int chieuDai,int chieuRong) {
		this.chieuDai=chieuDai;
		this.chieuRong=chieuRong;
	}
	public int getChieuDai() {
		return chieuDai;
	}

	public void setChieuDai(int chieuDai) {
		this.chieuDai = chieuDai;
	}

	public int getChieuRong() {
		return chieuRong;
	}

	public void setChieuRong(int chieuRong) {
		this.chieuRong = chieuRong;
	}

	public void getChuVi() {		
		System.out.println("Chu Vi Hình Chữ Nhật Là : "+((chieuDai+chieuRong)*2));
	}

	public void getDienTich() {
		System.out.println("Diện Tích Hình Chữ Nhật Là : "+(chieuDai*chieuRong));
	}

}
