package asm5.main;
import java.util.Scanner;
import java.util.ArrayList;
import asm5.model.*;
public class QuanLyTienDien {
	public static ArrayList<KhachHang> arrkh = new ArrayList <KhachHang>();
	public static ArrayList<BienLai> arrbl = new ArrayList<BienLai>();
	public static Scanner sc = new Scanner(System.in);
	public static int stt=0;
	
	public static void main(String[] args) {
			menu();
	}
	public static void ThongTinKhach() {
		System.out.println("Bạn muốn nhập bao nhiêu khách  hàng");
		int a = sc.nextInt();
		
		for(int i=0; i<a; i++) {
			sc.nextLine();
			System.out.println("Mã người sử dụng");
			String maK = sc.nextLine();
			System.out.println("Tên người sử dụng");
			String tenK = sc.nextLine();
			System.out.println("Địa chỉ người sử dụng");
			String diaChi = sc.nextLine();
			System.out.println("Mã công tơ của người sử dụng");
			String maCto = sc.nextLine();
			arrkh.add(new KhachHang(maK, tenK, diaChi, maCto));
		}
		
	}

	
	public static void TienThu() {
		System.out.println("BẢN BIÊN LAI");
				
			for(KhachHang x : arrkh) {
			System.out.println("Mã khách hàng:"+x.getMaK());
			System.out.println("Tên khách hàng:"+x.getTenK());
			System.out.println("Địa chỉ khách hàng:"+x.getTenK());
			System.out.println("Mã công tơ khách hàng:"+x.getTenK());
			System.out.print("Chỉ số mới: ");
			int soMoi = sc.nextInt();
			
			System.out.print("Chỉ số cũ: ");
			int soCu = sc.nextInt();
			
			arrbl.add(new BienLai(x.getMaK(), x.getTenK(), x.getDiaChi(), x.getMaCto(), soCu, soMoi, 1, 2018)); 
			
		
		}
	}
	public static void thang2() {
		System.out.println("BẢN BIÊN LAI THÁNG 2");
		for(int i=0;i<arrkh.size();i++) {
			System.out.println("Mã Khách hàng: "+arrkh.get(i).getMaK());
			System.out.println("Tên khách hàng: "+arrkh.get(i).getTenK());
			System.out.println("Địa chỉ khách hàng: "+arrkh.get(i).getDiaChi());
			System.out.println("Mã công tơ khách hàng:"+arrkh.get(i).getMaCto());
			System.out.println("Chỉ số mới: ");
			int soMoi= sc.nextInt();
			arrbl.get(i).setSoMoit2(soMoi);
		}
	}
	public static void thang3() {
		System.out.println("BẢN BIÊN LAI THÁNG 3");
		for(int i=0;i<arrbl.size();i++) {
			System.out.println("Mã khách hàng:"+arrkh.get(i).getMaK());
			System.out.println("Tên khách hàng:"+arrkh.get(i).getTenK());
			System.out.println("Địa chỉ khách hàng"+arrkh.get(i).getDiaChi());
			System.out.println("Mã công tơ khách hàng: "+arrkh.get(i).getMaCto());
			System.out.println("Chỉ số mới: ");
			int soMoi = sc.nextInt();
			arrbl.get(i).setSoMoit3(soMoi);
		}
	}
	
	public static void Intt() {
		System.out.printf("%-15s | %-20s | %-20s | %-20s |  \n", "Mã Khách","Tên khách","Địa chỉ","Mã công tơ");
		for(BienLai x : arrbl) {
			System.out.printf("%-15s | %-20s | %-20s | %-20s | \n", x.getMaK() , x.getTenK() , x.getDiaChi() 
			, x.getMaCto());
					}
	}
	
		
	public static void Inbl() {
		//System.out.println("Mã Khách	Tên Khác	Địa chỉ	   Mã Công Tơ   Số cũ    Số mới   Tính tiền");
		System.out.printf("%-15s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | \n", "Mã Khách","Tên khách","Địa chỉ","Mã công tơ","Số cũ","Số mới","Tính tiền");
		for(int i=0; i<arrbl.size(); i++) {
			BienLai bl = new BienLai();
			bl = arrbl.get(i);
			
			
			System.out.printf("%-15s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | \n", bl.getMaK() , bl.getTenK() , bl.getDiaChi() 
			, bl.getMaCto(),  bl.getSoCu() 
			, bl.getSoMoi(),  bl.tinhTien());
					}
	}
	public static void Inblt2() {
		System.out.printf("%-15s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | \n", "Mã Khách","Tên khách","Địa chỉ","Mã công tơ","Số cũ","Số mới","Tính tiền");
		for(int i=0; i<arrbl.size(); i++) {
			BienLai bl = new BienLai();
			bl = arrbl.get(i);
			
			
			System.out.printf("%-15s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | \n", bl.getMaK() , bl.getTenK() , bl.getDiaChi() 
			, bl.getMaCto() 
			, bl.getSoMoi(), bl.getSoMoit2(),  bl.tinhTient2());
					}
	}
	public static void Inblt3() {
		System.out.printf("%-15s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | \n", "Mã Khách","Tên khách","Địa chỉ","Mã công tơ","Số cũ","Số mới","Tính tiền");
		for(int i=0; i<arrbl.size(); i++) {
			BienLai bl = new BienLai();
			bl = arrbl.get(i);
			
			
			System.out.printf("%-15s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | \n", bl.getMaK() , bl.getTenK() , bl.getDiaChi() 
			, bl.getMaCto() 
			, bl.getSoMoit2(),bl.getSoMoit3(),  bl.tinhTient3());
					}
	}
	public static void tongtien() {
		System.out.printf("%-15s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | \n", "Mã Khách","Tên khách","Địa chỉ","Mã công tơ","Tiền t1","Tiền t2","Tiền t3","Tổng tiền");
		for(int i=0; i<arrbl.size(); i++) {
			BienLai bl = new BienLai();
			bl = arrbl.get(i);
			
			
			System.out.printf("%-15s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | \n", bl.getMaK() , bl.getTenK() , bl.getDiaChi() 
			, bl.getMaCto() 
			, bl.tinhTien(),bl.tinhTient2(), bl.tinhTient3(),( bl.tinhTien()+ bl.tinhTient2()+ bl.tinhTient3()));
					}
	}
	
	public static void menu() {
		while(true) {
		System.out.println("1.Nhập thông tin khách hàng");
		System.out.println("2.Nhập thông tin tiên thu điện tháng 1");
		System.out.println("3.Nhập thông tin tiên thu điện tháng 2");
		System.out.println("4.Nhập thông tin tiên thu điện tháng 3");
		System.out.println("5.In thông tin khách hàng");
		System.out.println("6.In thông tin biên lai tháng 1");
		System.out.println("7.In thông tin biên lai tháng 2");
		System.out.println("8.In thông tin biên lai tháng 3");
		System.out.println("9.Tổng tiền");
		int a= sc.nextInt();
		if(a==1) {
			ThongTinKhach();
			
		}
		if(a==2) {
			TienThu();
		}
		if(a==3) {
			thang2();
		}
		if(a==4) {
			thang3();
		}
		if(a==5) {
			Intt();
		}
		if(a==6) {
			Inbl();
		}
		if(a==7) {
			Inblt2();
		}
		if(a==8) {
			Inblt3();
		}
		if(a==9) {
			tongtien();
		}
		
		
		
	}
	}
	
}
