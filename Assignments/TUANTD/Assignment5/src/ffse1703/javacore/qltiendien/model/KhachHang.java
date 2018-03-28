package ffse1703.javacore.qltiendien.model;

import java.util.Scanner;

public class KhachHang {
	private String hoTenChuNha;
	private String maKhachHang;
	private String soNha;
	private int maSoCongTo;

	public KhachHang() {
		super();
	}

	public KhachHang(String hoTenChuNha, String maKhachHang, String soNha, int maSoCongTo) {
		super();
		this.hoTenChuNha = hoTenChuNha;
		this.maKhachHang = maKhachHang;
		this.soNha = soNha;
		this.maSoCongTo = maSoCongTo;
	}

	public void nhapThongTinKhachHang() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhập tên chủ hộ: ");
		hoTenChuNha = scanner.nextLine();
		System.out.print("Nhập tên Mã Khách Hàng: ");
		maKhachHang = scanner.nextLine();
		System.out.print("Nhập số nhà: ");
		soNha = scanner.nextLine();
		System.out.print("Mã số công tơ: ");
		maSoCongTo = scanner.nextInt();
	}

	public void hienThiThongTinKhachHang() {
		System.out.println("Tên chủ hộ: " + hoTenChuNha);
		System.out.println("Mã Khách Hàng: " + maKhachHang);
		System.out.println("Số nhà: " + soNha);
		System.out.println("Mã số công tơ: " + maSoCongTo);
	}

	public String getHoTenChuNha() {
		return hoTenChuNha;
	}

	public void setHoTenChuNha(String hoTenChuNha) {
		this.hoTenChuNha = hoTenChuNha;
	}

	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getSoNha() {
		return soNha;
	}

	public void setSoNha(String soNha) {
		this.soNha = soNha;
	}

	public int getMaSoCongTo() {
		return maSoCongTo;
	}

	public void setMaSoCongTo(int maSoCongTo) {
		this.maSoCongTo = maSoCongTo;
	}

}
