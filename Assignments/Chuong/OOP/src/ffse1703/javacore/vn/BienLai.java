package ffse1703.javacore.vn;

import java.util.Scanner;
public class BienLai {
	private int ChiSoCu;
	private int ChiSoMoi;
	private double soTienPhaiTra;
	private KhachHang khachHang;
	 public BienLai() {
	        super();
	    }
	 public BienLai(int ChiSoCu,int ChiSoMoi,double soTienPhaiTra,KhachHang khachHang) {
		this.ChiSoCu=ChiSoCu;
		this.ChiSoMoi=ChiSoMoi;
		this.soTienPhaiTra=soTienPhaiTra;
		this.khachHang=khachHang;
	 }
	 public void nhapBienLai() {
		 khachHang = new KhachHang();
		 khachHang.nhapKH();
		 Scanner input=new Scanner(System.in);
		 
		 System.out.println("Nhập chỉ số cũ:");
		 ChiSoCu = input.nextInt();
		 
		 System.out.println("Nhập chỉ số mới:");
		 ChiSoMoi = input.nextInt();
		 
		 soTienPhaiTra = (double) (ChiSoMoi - ChiSoCu) * 3000;
	 }
	 public void xuatBienLai() {
		 
		 khachHang.xuatKH();
		 System.out.println(" Chỉ số cũ:" + ChiSoCu);
		 System.out.println(" Chỉ số mới:" + ChiSoMoi);
		 System.out.println(" Tien Phai Tra:" + soTienPhaiTra);
		 
	 }
}