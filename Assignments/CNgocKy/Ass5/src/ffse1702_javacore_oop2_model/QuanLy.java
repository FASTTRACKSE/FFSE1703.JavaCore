package ffse1702_javacore_oop2_model;

import java.util.Scanner;

public class QuanLy extends NhanVien {
	private int luongTN;

	public QuanLy(String maSo, String tenSV, String ngaySinh, int luong, int luongTN) {
		super(maSo, tenSV, ngaySinh, luong);
		this.luongTN = luongTN;
	}
	public double tinhLuong() {
		return super.getLuong() + this.luongTN;
		
	}
	
	public void inPut() {
		Scanner c = new Scanner(System.in);
		System.out.println("Ma nhan vien: ");
		this.maSo = c.nextLine();
		System.out.println("Nhap ten nhan vien: ");
		this.tenNV = c.nextLine();
		System.out.println("Nhap Ngay Sinh Nhan vien: ");
		this.ngaySinh = c.nextLine();
		System.out.println("Nhap Luong nhan vien: ");
		this.luong = c.nextInt();
		
	}
}
