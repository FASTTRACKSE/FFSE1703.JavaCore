package ffse1703.dienluc.main;
import ffse1703.dienluc.model.*;
import java.util.ArrayList;
import java.util.Scanner;

//
public class QuanLyTienDien {
public static Scanner myInput = new Scanner(System.in);
public static int soluong ;
public static ArrayList<KhachHang> arrKhachHang = new ArrayList<>(); 
public static ArrayList<BienLai> arrBienLai = new ArrayList<>();
public static int stt = 0;
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
			arrKhachHang.add(new KhachHang(MasoKH,TenKH,DiaChiKH,MaCongTo));
		}
	}
	public static void nhapchisotieuthudien() {
			myInput.nextLine();
			System.out.println("Nhap Thang Chu Ky: ");
			int ThangChuKy = Integer.parseInt(myInput.nextLine());
			System.out.println("Nhap Nam Chu Ky: ");
			int NamChuKy = Integer.parseInt(myInput.nextLine());
		for (KhachHang x: arrKhachHang) {
			
			System.out.println("Ma Khach Hang: "+ x.getMasoKH());
			System.out.println("Ho Va Ten Khach Hang: "+ x.getTenKH());
			System.out.println("Dia Chi Khach Hang: "+ x.getDiaChiKH());
			System.out.println("Ma Cong To Khach Hang: "+ x.getMaCongTo());
			//BienLai BienLai = new BienLai();
//			myInput.nextLine();
			System.out.println("Nhap Chi So Moi: ");
			int ChiSoMoi=Integer.parseInt(myInput.nextLine());
			System.out.println("Nhap Chi So Cu: ");
			int ChiSoCu = Integer.parseInt(myInput.nextLine());
			System.out.println("Nhap Ngay Thang: ");
			String NgayThang = myInput.nextLine();
			
			arrBienLai.add(new BienLai(x.getMasoKH(),x.getTenKH(),x.getDiaChiKH(),x.getMaCongTo(),ChiSoMoi,ChiSoCu,NgayThang,ThangChuKy,NamChuKy));
		}
		

	}
	public static void indanhsachkhachhang() {
		System.out.println("<=====IN DANH SACH KHACH HANG=====>");
		System.out.println("Ma So KH" + "\t" + "Ten KH" + "\t" + "\t" + "Dia Chi" + "\t" + "\t" + "Ma Cong To"+ "\t" + "\t" + "Ma Cong To Moi"+ "\t" + "\t" + "Ma Cong To Cu"+ "\t" + "\t" + "Ngay Thang"+ "\t" + "\t" + "Tong Tien");
		for(BienLai x : arrBienLai) {
			System.out.println(x.getMasoKH()+"\t"+"\t"+x.getTenKH()+"\t"+"\t"+x.getDiaChiKH()+"\t"+"\t"+x.getMaCongTo()+"\t"+"\t"+x.getChiSoMoi()+"\t"+"\t"+x.getChiSoCu()+"\t"+"\t"+x.getNgayThang()+"\t"+"\t"+x.getTongTien());
		}
	}
	public static void ketthucchuongtrinh() {
		System.exit(0);
	}
	public static void myMenu() {
		while (true) {
			System.out.println("<======LUA CHON CHUC NANG======>");
			System.out.println("|| 1.NHAP THONG TIN KHACH HANG ||");
			System.out.println("|| 2.NHAP CHI SO TIEU THU DIEN ||");
			System.out.println("|| 3.IN DANH SACH KHACH HANG   ||");
			System.out.println("|| 4.KET THUC CHUONG TRINH     ||");
			System.out.println("<===============================>");
			System.out.println("      LUA CHON CUA BAN        ");
			int option = myInput.nextInt();
			if (option == 1) {
				nhapthongtinkhachhang();
			} else if (option == 2) {
				nhapchisotieuthudien();
			} else if (option == 3) {
				indanhsachkhachhang();
			} else if (option == 4) {
				ketthucchuongtrinh();
			}
		}
	}
}
