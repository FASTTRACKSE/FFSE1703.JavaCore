package ffse1703.dienluc.main;
import ffse1703.dienluc.model.*;
import java.util.ArrayList;
import java.util.Scanner;

//
public class QuanLyTienDien {
public static Scanner myInput = new Scanner(System.in);
public static int soluong ;
public static ArrayList<SinhVien> arrKhachHang = new ArrayList<>(); 
public static ArrayList<BienLai> arrBienLai = new ArrayList<>();
public static int stt = 0;
public static double tinhtong = 0;
	public static void main(String[] args) {
		myMenu();
	}
	//
	public static void nhapthongtinkhachhang() {
		System.out.println("<=====NHAP THONG TIN KHACH HANG=====>");
		System.out.println("Nhap so luong");
		soluong = myInput.nextInt();
		for (int i = 0; i < soluong; i++) {
			//KhachHang KhachHang = new KhachHang();
			myInput.nextLine();
			System.out.println("Nhap Ma So Khach Hang"+"["+(+i+1)+"]: ");
			String MasoKH = myInput.nextLine();
			System.out.println("Nhap Ten Khach Hang"+"["+(+i+1)+"]: ");
			String TenKH = myInput.nextLine();
			System.out.println("Nhap Dia Chi Khach Hang"+"["+(+i+1)+"]: ");
			String DiaChiKH = myInput.nextLine();
			System.out.println("Nhap Ma Cong To"+"["+(+i+1)+"]: ");
			double MaCongTo = myInput.nextDouble();
			arrKhachHang.add(new SinhVien(MasoKH,TenKH,DiaChiKH,MaCongTo));
		}
	}
	public static void nhapchisotieuthudien() {
			myInput.nextLine();
			System.out.println("Nhap Thang Chu Ky: ");
			int ThangChuKy = Integer.parseInt(myInput.nextLine());
			System.out.println("Nhap Nam Chu Ky: ");
			int NamChuKy = Integer.parseInt(myInput.nextLine());
		for (SinhVien x: arrKhachHang) {
			
			System.out.println("Ma Khach Hang: "+ x.getMasoKH());
			System.out.println("Ho Va Ten Khach Hang: "+ x.getTenKH());
			System.out.println("Dia Chi Khach Hang: "+ x.getDiaChiKH());
			System.out.println("Ma Cong To Khach Hang: "+ x.getMaCongTo());
			//BienLai BienLai = new BienLai();
			//myInput.nextLine();
			System.out.println("Nhap Chi So Moi: ");
			int ChiSoMoi=Integer.parseInt(myInput.nextLine());
			System.out.println("Nhap Chi So Cu: ");
			int ChiSoCu = Integer.parseInt(myInput.nextLine());
			System.out.println("Nhap Ngay Thang: ");
			String NgayThang = myInput.nextLine();
			arrBienLai.add(new BienLai(x.getMasoKH(),x.getTenKH(),x.getDiaChiKH(),x.getMaCongTo(),ChiSoMoi,ChiSoCu,NgayThang,ThangChuKy,NamChuKy));
		}
		

	}
	public static void indanhsachkhachhangnam() {
		System.out.println("<=====IN DANH SACH THEO NAM=====>");
		myInput.nextLine();
		System.out.println("Nhap Nam Can In: ");
		int NamChuKy = myInput.nextInt();
		System.out.printf("|%-20s|%-15s|%-10s|%-20s|%-20s|%-20s|%-10s|%-10s|%-10s|\n","Ma So KH","Ten KH","Dia Chi","Ma Cong To","Chi So Cu","Chi So Moi","Thang","Nam","Tong Tien");
//		System.out.println("Ma So KH" + "\t" + "Ten KH" + "\t" + "\t" + "Dia Chi" + "\t" + "\t" + "Ma Cong To"+ "\t" + "\t" + "Ma Cong To Moi"+ "\t" + "\t" + "Ma Cong To Cu"+ "\t" + "\t" + "Thang"+ "\t" + "\t" + "Tong Tien");
		for(BienLai x : arrBienLai) {
			if(NamChuKy==x.getNamChuKy()) {
			System.out.printf("|%-20s|%-15s|%-10s|%-20s|%-20s|%-20s|%-10s|%-10s|%-10s|\n",x.getMasoKH(),x.getTenKH(),x.getDiaChiKH(),x.getMaCongTo(),x.getChiSoMoi(),x.getChiSoCu(),x.getThangChuKy(),x.getNamChuKy(), x.getTongTien());
			//System.out.println(x.getMasoKH()+"\t"+"\t"+x.getTenKH()+"\t"+"\t"+x.getDiaChiKH()+"\t"+"\t"+x.getMaCongTo()+"\t"+"\t"+x.getChiSoMoi()+"\t"+"\t"+x.getChiSoCu()+"\t"+"\t"+x.getThangChuKy()+"\t" + x.getTongTien());
			tinhtong +=x.getTongTien();
			}
			
			
		}
		System.out.println(" Tong Tien: "+tinhtong);
	}
	public static void indanhsachcanhannam() {
		System.out.println("<=====IN CA NHAN THEO NAM=====>");
		myInput.nextLine();
		System.out.println("Nhap Ma Khach Hang Can In: ");
		String MasoKH = myInput.nextLine();
		System.out.println("Nhap Nam In: ");
		int NamChuKy = myInput.nextInt();
		System.out.println("Ten KH" + "\t" + "\t" + "Ma Cong To"+ "\t" + "\t" + "Tong Tien");
		for (BienLai x: arrBienLai) {
			if(MasoKH.equals(x.getMasoKH()) && (NamChuKy == x.getNamChuKy())) {
				tinhtong +=x.getTongTien();
				System.out.println(x.getTenKH()+ "\t " + x.getMaCongTo());
			}
		}
		System.out.println(" Tong Tien: "+ tinhtong);
	}
	public static void bienlai1thangcuakhachhang() {
		System.out.println("<=====IN DANH SACH THEO THANG=====>");
		myInput.nextLine();
		System.out.println("Nhap Nam Can In: ");
		int NamChuKy = myInput.nextInt();
		System.out.println("Nhap Thang Can In: ");
		int ThangChuKy = myInput.nextInt();
		
		System.out.println("Ma So KH" + "\t" + "Ten KH" + "\t" + "\t" + "Dia Chi" + "\t" + "\t" + "Ma Cong To"+ "\t" + "\t" + "Ma Cong To Moi"+ "\t" + "\t" + "Ma Cong To Cu"+ "\t" + "\t" + "Thang"+ "\t" + "\t" + "Tong Tien");
		for(BienLai x : arrBienLai) {
			if(NamChuKy==x.getNamChuKy() && ThangChuKy == x.getThangChuKy()) {
				tinhtong +=x.getTongTien();
			System.out.println(x.getMasoKH()+"\t"+"\t"+x.getTenKH()+"\t"+"\t"+x.getDiaChiKH()+"\t"+"\t"+x.getMaCongTo()+"\t"+"\t"+x.getChiSoMoi()+"\t"+"\t"+x.getChiSoCu()+"\t"+"\t"+x.getThangChuKy()+"\t"+"\t"+x.getTongTien());
			}
		
		}
		System.out.println(" Tong Tien: "+ tinhtong);
	}
	public static void bienlai1thangcuacanhan() {
		System.out.println("<=====IN CA NHAN THEO THANG=====>");
		myInput.nextLine();
		System.out.println("Nhap Ma Khach Hang Can In: ");
		String MasoKH = myInput.nextLine();
		System.out.println("Nhap Nam In: ");
		int NamChuKy = myInput.nextInt();
		System.out.println("Nhap Thang In: ");
		int ThangChuKy = myInput.nextInt();
		for (BienLai x: arrBienLai) {
			if(MasoKH.equals(x.getMasoKH()) && (NamChuKy == x.getNamChuKy()) && (ThangChuKy == x.getThangChuKy())) {
				tinhtong +=x.getTongTien();
				System.out.println(x.getTenKH()+ "\t " + x.getMaCongTo() + "\t"+ x.getTongTien());
			}
		}
		System.out.println(" Tong Tien: "+ tinhtong);
	}
	public static void ketthucchuongtrinh() {
		System.exit(0);
	}
	public static void myMenu() {
		while (true) {
			System.out.println("<======LUA CHON CHUC NANG======>");
			System.out.println("|| 1.NHAP THONG TIN KHACH HANG ||");
			System.out.println("|| 2.NHAP CHI SO TIEU THU DIEN ||");
			System.out.println("|| 3.IN BIEN LAI               ||");
			System.out.println("|| 4.KET THUC CHUONG TRINH     ||");
			System.out.println("<===============================>");
			System.out.println("      LUA CHON CUA BAN        ");
			int option = myInput.nextInt();
			if (option == 1) {
				nhapthongtinkhachhang();
			} else if (option == 2) {
				nhapchisotieuthudien();
			} else if (option == 3) {
				myMenu1();
			} else if (option == 4) {
				ketthucchuongtrinh();
			}
		}
	}
	public static void myMenu1() {
		while (true) {
			System.out.println("<======LUA CHON CHUC NANG===========>");
			System.out.println("|| 1.IN DANH SACH KHACH HANG NAM   ||");
			System.out.println("|| 2.IN CA NHAN TRONG NAM          ||");
			System.out.println("|| 3.IN 1 THANG CUA TAT CA KH      ||");
			System.out.println("|| 4.IN 1 THANG CUA CA NHAN        ||");
			System.out.println("|| 5.KET THUC CHUONG TRINH         ||");
			System.out.println("|| 0.QUAY VE                       ||");
			System.out.println("<===================================>");
			System.out.println("      LUA CHON CUA BAN        ");
			int option = myInput.nextInt();
			if (option == 1) {
				indanhsachkhachhangnam();
			} else if (option == 2) {
				indanhsachcanhannam();
			} else if (option == 3) {
				bienlai1thangcuakhachhang();
			} else if (option == 4) {
				bienlai1thangcuacanhan();
			} else if (option == 5) {
				ketthucchuongtrinh();
			} else if (option == 0) {
				myMenu();
			}
		}
	}
}
