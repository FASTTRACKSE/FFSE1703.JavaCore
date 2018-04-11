package ffse1703.javacore.vn;

import java.util.ArrayList;
import java.util.Scanner;
public class KhachHang {
	private int MaKhachHang ;
	private String Ten;
	private String DiaChi;
	private int MaCongTo;
	public KhachHang() {
    }
	
	public KhachHang(int MaCongTo, int MaKhachHang, String Ten, String DiaChi) {
		this.MaCongTo=MaCongTo;
		this.MaKhachHang=MaKhachHang;
		this.Ten=Ten;
		this.DiaChi=DiaChi;
	}
	
	  public int getMaCongTo() {
		return MaCongTo;
	}
	public void setMaCongTo(int maCongTo) {
		MaCongTo = maCongTo;
	}
	public int getMaKhachHang() {
		return MaKhachHang;
	}
	public void setMaKhachHang(int maKhachHang) {
		MaKhachHang = maKhachHang;
	}
	public String getTen() {
		return Ten;
	}
	public void setTen(String ten) {
		Ten = ten;
	}
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	public static void main(String[] args) {
	ArrayList<KhachHang> KH = new ArrayList<>();
	
	  }
	public void nhapKH() {
		
		Scanner input=new Scanner(System.in);
		
		System.out.println("Nhập mã số công tơ:");
		MaCongTo=input.nextInt();
		
		
		System.out.println("Nhập mã số khách hàng:");
		 MaKhachHang=input.nextInt();
		
		
		System.out.println("Nhập tên khách hàng:");
	     Ten=input.nextLine();
	     
	    System.out.println("Nhập địa chỉ của khách hàng:");
	     DiaChi=input.nextLine();
		
		
	}
	public void xuatKH() {
		
		System.out.println("Mã số công tơ:" + MaCongTo);
		System.out.println("Mã số khách hàng:" + MaKhachHang);
		System.out.println("Tên khách hàng:" + Ten);
		System.out.println("Địa chỉ khách hàng:" + DiaChi);
	}
}