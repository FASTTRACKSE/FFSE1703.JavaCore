package Assignment_list.Asm6.hinhhoc.model;

public class HinhTron extends HinhHoc {	
	private int banKinh;
	public HinhTron() {
		
	}
	public HinhTron(int banKinh) {
		this.banKinh=banKinh;
	}
	public int getBanKinh() {
		return banKinh;
	}
	
	public void setBanKinh(int banKinh) {
		this.banKinh = banKinh;
	}
	
	public void getChuVi() {
		System.out.println("Chu Vi Hình Tròn Là :"+(2*3.14*banKinh));
	}
	
	public void getDienTich() {
		System.out.println("Diện Tích Hình Tròn Là :"+(3.14*banKinh*banKinh));		
	}
}
