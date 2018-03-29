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
			KhachHang KhachHang = new KhachHang();
			myInput.nextLine();
			System.out.println("Nhap Ma So Khach Hang"+"["+(+i+1)+"]: ");
			KhachHang.setMasoKH(myInput.nextLine());
			System.out.println("Nhap Ten Khach Hang"+"["+(+i+1)+"]: ");
			KhachHang.setTenKH(myInput.nextLine());
			System.out.println("Nhap Dia Chi Khach Hang"+"["+(+i+1)+"]: ");
			KhachHang.setDiaChiKH(myInput.nextLine());
			System.out.println("Nhap Ma Cong To"+"["+(+i+1)+"]: ");
			KhachHang.setMaCongTo(myInput.nextDouble());
			arrKhachHang.add(KhachHang);
		}
	}
	public static void nhapchisotieuthudien() {
		for (;stt < arrKhachHang.size() ;stt++) {
			System.out.println("Ma Khach Hang: "+ arrKhachHang.get(stt).getMasoKH());
			System.out.println("Ho Va Ten Khach Hang: "+ arrKhachHang.get(stt).getTenKH());
			System.out.println("Dia Chi Khach Hang: "+ arrKhachHang.get(stt).getDiaChiKH());
			System.out.println("Ma Cong To Khach Hang: "+ arrKhachHang.get(stt).getMaCongTo());
			BienLai BienLai = new BienLai();
			myInput.nextLine();
			System.out.println("Nhap Ma Cong To Moi: ");
			BienLai.setChiSoMoi(Integer.parseInt(myInput.nextLine()));
			System.out.println("Nhap Ma Cong To Cu: ");
			BienLai.setChiSoCu(Integer.parseInt(myInput.nextLine()));
			System.out.println("Nhap Ngay Thang: ");
			BienLai.setNgayThang(myInput.nextLine());
			arrBienLai.add(BienLai);
		}
		
		
	}
	public static void indanhsachkhachhang() {
		System.out.println("<=====IN DANH SACH KHACH HANG=====>");
		System.out.println("Ma So KH" + "\t" + "Ten KH" + "\t" + "\t" + "Dia Chi" + "\t" + "\t" + "Ma Cong To"+ "\t" + "\t" + "Ma Cong To Moi"+ "\t" + "\t" + "Ma Cong To Cu"+ "\t" + "\t" + "Ngay Thang"+ "\t" + "\t" + "Tong Tien");
		for(int i = 0;i<arrKhachHang.size();i++) {
			System.out.println(arrKhachHang.get(i).getMasoKH()+"\t"+"\t"+arrKhachHang.get(i).getTenKH()+"\t"+"\t"+arrKhachHang.get(i).getDiaChiKH()+"\t"+"\t"+arrKhachHang.get(i).getMaCongTo()+"\t"+"\t"+arrBienLai.get(i).getChiSoMoi()+"\t"+"\t"+arrBienLai.get(i).getChiSoCu()+"\t"+"\t"+arrBienLai.get(i).getNgayThang()+"\t"+"\t"+arrBienLai.get(i).getTongTien());
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
