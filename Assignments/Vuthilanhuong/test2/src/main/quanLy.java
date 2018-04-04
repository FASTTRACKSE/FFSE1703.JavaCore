package main;
import java.util.Scanner;
import java.util.ArrayList;
import model.*;

public class quanLy {
	public static Scanner sc = new Scanner(System.in);
	public static ArrayList<KhachHang> kh = new ArrayList<KhachHang>();
	public static ArrayList<BienLai> bl = new ArrayList<BienLai>();
	public static void main (String[] args) { 
		menu();
	}
	
	public static void ttKhach() {
		System.out.println("Bạn muốn nhập bao nhiêu khách hàng");
		int a = sc.nextInt();
		for(int i=0; i<a; i++) {
			sc.nextLine();
		System.out.println("Nhập tên khách hàng");	
		String tenKhach = sc.nextLine();
		System.out.println("Nhập dịa chỉ khách hàng");
		String diaChi = sc.nextLine();
		System.out.println("Nhập số điện thoại khách hàng");
		String sdt = sc.nextLine();
		System.out.println("Nhập mã công tơ khách hàng");
		String maCto = sc.nextLine();
		kh.add(new KhachHang(tenKhach,diaChi,sdt,maCto));
		}
	}
	public static void bienLai() {
		
		for(int i=0; i<kh.size(); i++) {
			System.out.println("Tên khách hàng: "+kh.get(i).getTenKhach());
			System.out.println("Mã Công tơ: "+kh.get(i).getMaCto());
			
			System.out.println("Chỉ số cũ");
			int soCu = sc.nextInt();
			System.out.println("Chỉ số mới");
			int soMoi = sc.nextInt();
			bl.add(new BienLai(kh.get(i).getTenKhach(),kh.get(i).getDiaChi(),kh.get(i).getSdt(),kh.get(i).getMaCto(),soCu,soMoi));
		}
		
	}
	public static void inttKhach() {
		for(int i=0; i<kh.size(); i++) {
			System.out.println("Tên khách  Địa chỉ  Số điện thoại  Mã công tơ");
			System.out.printf( kh.get(i).getTenKhach()+ kh.get(i).getDiaChi()+ kh.get(i).getSdt()+ kh.get(i).getMaCto()+"\n");
		}
		
	}
	public static void inBienlai() {
		
	}
	public static void ketthuc() {
		
	}
	public static void menu() {
		while(true) {
		System.out.println("1.Nhập thông tin khách hàng");
		System.out.println("2.Nhập thông tin biên lai");
		System.out.println("3.In thông tin khách hàng");
		System.out.println("4.In biên lai");
		System.out.println("5.Kết thúc chương trình");
		int a = sc.nextInt(); 
		if(a==1) {
			ttKhach();
		}
		if(a==2) {
			bienLai();
		}
		if(a==3) {
			inttKhach();
		}
		if(a==4) {
			inBienlai();
		}
		if(a==5) {
			ketthuc();
		}
	}
	}
}
