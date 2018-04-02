package ffse1703.Javacore.oop2.model;
import java.util.Scanner;
public class KhachHang {
	private String maKhachHang;
	private String tenKhachHang;
	private String diaChi;
	private Double maCongTo;
	public void nhapThongTinKhachHang() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhập mã khách hàng: ");
		maKhachHang = scanner.nextLine();
		System.out.print("Nhập tên Khách Hàng: ");
		tenKhachHang = scanner.nextLine();
		System.out.print("Nhập địa chỉ: ");
		diaChi = scanner.nextLine();
		System.out.print("Mã số công tơ: ");
		maCongTo = scanner.nextDouble();
	}

	public void hienThiThongTinKhachHang() {
		System.out.println("Tên chủ hộ: " + tenKhachHang);
		System.out.println("Mã Khách Hàng: " + maKhachHang);
		System.out.println("Địa chỉ: " + diaChi);
		System.out.println("Số công tơ: " + maCongTo);
	}
	public String getMaKhachHang() {
		return maKhachHang;
	}
	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	public String getTenKhachHang() {
		return tenKhachHang;
	}
	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public Double getMaCongTo() {
		return maCongTo;
	}
	public void setMaCongTo(Double maCongTo) {
		this.maCongTo = maCongTo;
	}
	public KhachHang() {
		super();
	}
	public KhachHang(String maKhachHang, String tenKhachHang, String diaChi, Double maCongTo) {
		super();
		this.maKhachHang = maKhachHang;
		this.tenKhachHang = tenKhachHang;
		this.diaChi = diaChi;
		this.maCongTo = maCongTo;	
	}
}
