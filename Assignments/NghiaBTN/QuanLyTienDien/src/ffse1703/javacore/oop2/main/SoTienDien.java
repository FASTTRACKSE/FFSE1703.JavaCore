package ffse1703.javacore.oop2.main;

import ffse1703.javacore.oop2.model.*;

import java.util.Scanner;

import java.util.ArrayList;

public class SoTienDien {
	public static Scanner Scanner= new Scanner(System.in);
	public static int n = 0;
	public static ArrayList<KhachHang> arrKhachHang=new ArrayList<KhachHang>();
	public static ArrayList<BienLai> arrBienLai=new ArrayList<BienLai>();
	public static int stt=0,size=0;
	public static void main(String[] args) {
		myMenu();
	}
	public static void nhapthongtinKH() {

		System.out.println("Nhập danh sách khách hàng : ");
		System.out.println("---------------------------");
		System.out.print("Số lượng khách hàng :");
		n = Scanner.nextInt();

		for (int i = 0; i < n; i++) {
			
			Scanner.nextLine();
			
			System.out.println("Nhập Mã khách hàng thứ "+(i+1)+" : ");
			String MaSoKH = Scanner.nextLine();
			
			System.out.println("Nhập Tên khách hàng thứ "+(i+1)+" : ");
			String TenKH = Scanner.nextLine();
			
			System.out.println("Nhập Địa Chỉ khách hàng thứ "+(i+1)+" : ");
			String DiaChi = Scanner.nextLine();
			
			System.out.println("Nhập Mã Công Tơ của khách hàng thứ "+(i+1)+" : ");
			String MaCongTo = Scanner.nextLine();
			
			arrKhachHang.add(new KhachHang(MaSoKH,TenKH,DiaChi,MaCongTo));

		}
		
		Scanner.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		Scanner.nextLine();
	}

	public static void nhapthongtinTT() {
		
		System.out.println("Nhập chỉ số điện tiêu thụ :");

		for (int i = 0; i < n; i++) {

			Scanner.nextLine();
			
			System.out.println("Tên Khách hàng : " +arrKhachHang.get(i).getTenKH());
			System.out.println("Mã Khách hàng : " +arrKhachHang.get(i).getMaSoKH());
			System.out.println("Mã Công Tơ :" + arrKhachHang.get(i).getMaCongTo());
			
			System.out.println("Nhập Tháng :");
			int Thang=Scanner.nextInt();
			
			System.out.println("Nhập Năm :");
			int Nam=Scanner.nextInt();
			
			System.out.println("Nhập Chỉ Số Điện Cũ :");
			int ChiSoCu=Scanner.nextInt();
			
			System.out.println("Nhập Chỉ Số Điện Mới :");
			int ChiSoMoi=Scanner.nextInt();
			
			arrBienLai.add(new BienLai(arrKhachHang.get(i).getMaSoKH(),
					arrKhachHang.get(i).getTenKH(),
					arrKhachHang.get(i).getDiaChi(),arrKhachHang.get(i).getMaCongTo(),
					ChiSoCu,ChiSoMoi,Thang,Nam));			
		}	
		
		Scanner.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		Scanner.nextLine();
	}

	public static void inbienlai() {
		
		System.out.println("Danh sách tính tiền điện của khách hàng ");
		System.out.println("-------------------------------------------------------------------------------------------------------------------");
		System.out.println("STT  MasoKH    TênKH           Địa chỉ     MasoCT   Tháng   Năm   Chỉ số trước  Chỉ số sau     Tiền điện     ");
		System.out.println("-------------------------------------------------------------------------------------------------------------------");
		for (int i = 0; i < arrBienLai.size(); i++) {

			System.out.printf("%-7s%-10s%-17s%-12s%-10s%-4s%-9s%-10s%-10s%-10s\n",
					(i + 1),
					arrKhachHang.get(i).getMaSoKH(),
					arrKhachHang.get(i).getTenKH(),
					arrKhachHang.get(i).getDiaChi(),
					arrKhachHang.get(i).getMaCongTo(),
					arrBienLai.get(i).getThang(),
					arrBienLai.get(i).getNam(),
					arrBienLai.get(i).getChiSoCu(),
					arrBienLai.get(i).getChiSoMoi(),
					arrBienLai.get(i).getTienDien());
		}
		
		Scanner.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		Scanner.nextLine();
	}
	
public static void inkhachhang() {
		
		System.out.println("Danh sách tính tiền điện của khách hàng ");
		System.out.println("------------------------------------------------------");
		System.out.println("STT  MasoKH    TênKH           Địa chỉ     MasoCT  ");
		System.out.println("------------------------------------------------------");
		for (int i = 0; i < arrKhachHang.size(); i++) {

			System.out.printf("%-5s%-10s%-16s%-12s%-12s\n",
					(i + 1),
					arrKhachHang.get(i).getMaSoKH(),
					arrKhachHang.get(i).getTenKH(),
					arrKhachHang.get(i).getDiaChi(),
					arrKhachHang.get(i).getMaCongTo());}
		
		Scanner.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		Scanner.nextLine();
	}

	public static void ketThuc() {	
		System.out.println("Kết thúc chương trình!!!!!");
		System.exit(0);
	}

	public static void myMenu() {
		while (true) {
			System.out.println("         MENU QUẢN LÝ TIỀN ĐIỆN       ");
			System.out.println("----------------------------------------");
			System.out.println("1. Nhập thông tin khách hàng            ");
			System.out.println("2. Nhập thông tin chỉ số tiêu thụ       ");
			System.out.println("3. In biên lai tiền điện của các hộ     ");
			System.out.println("4. In danh sách khách hàng              ");
			System.out.println("5. Kết thúc chương trình                ");
			System.out.println("----------------------------------------");
			
			int myOption = Scanner.nextInt();
			if (myOption == 1) {
				nhapthongtinKH();
			} else if (myOption == 2) {
				nhapthongtinTT();
			} else if (myOption == 3) {
				inbienlai();
			} else if (myOption == 4) {
				inkhachhang();
			} else if (myOption == 5) {
				ketThuc();
			}

			}
		}
	}
