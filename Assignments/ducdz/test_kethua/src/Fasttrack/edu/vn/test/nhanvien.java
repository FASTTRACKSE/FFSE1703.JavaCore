package Fasttrack.edu.vn.test;

public class nhanvien {
	public static int maso_nhanvien;
	public static String ten_nhanvien;
	public static int namsinh_nhanvien;
	public static int luong_nhanvien;
	public static int thuethunhap=0;
	public nhanvien(){
		
	}
	public nhanvien(int maso_nhanvien,String ten_nhanvien,int namsinh_nhanvien,int luong_nhanvien) {
		this.ten_nhanvien=ten_nhanvien;
		this.maso_nhanvien=maso_nhanvien;
		this.namsinh_nhanvien=namsinh_nhanvien;
		this.luong_nhanvien=luong_nhanvien;
	}
	public void set_maso_nhanvien(int maso_nhanvien) {
		this.maso_nhanvien=maso_nhanvien;
	}
	public int get_maso_nhanvien() {
		return this.maso_nhanvien;
	}
	public void set_ten_nhanvien(String ten_nhanvien) {
		this.ten_nhanvien=ten_nhanvien;
	}
	public String get_ten_nhanvien() {
		return this.ten_nhanvien;
	}
	public void set_namsinh_nhanvien(int namsinh_nhanvien) {
		this.namsinh_nhanvien=namsinh_nhanvien;
	}
	public int get_namsinh_nhanvien() {
		return this.namsinh_nhanvien;
	}
	public void set_luong_nhanvien(int luong_nhanvien) {
		this.luong_nhanvien=luong_nhanvien;
	}
	public int get_luong_nhanvien() {
		return this.luong_nhanvien;
	}
	public int tinh_thue_thu_nhap() {
		thuethunhap= ((luong_nhanvien-50000)*1);
		return thuethunhap;
	}
}

