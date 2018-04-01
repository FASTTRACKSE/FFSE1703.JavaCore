package Fasttrack.edu.vn.assginment5.main;
import java.util.ArrayList;
import Fasttrack.edu.vn.assignment5.*;
import java.util.Scanner;

public class Tiendien {
	public static Scanner Scanner = new Scanner(System.in);
	public static ArrayList<khachhang> arrKhachHang = new ArrayList<khachhang>();
	public static ArrayList<bienlai> arrbienlai = new ArrayList<bienlai>();
	public static int n,a = 0;

	public static void main(String[] args) {
		myMenu();
	}

	public static void myMenu() {
		while (true) {
			System.out.println(">>     Lựa chọn  chức năng bạn cần      <<");
			System.out.println("+----------------------------------------+");
			System.out.println("|1. Danh sách khách hàng                 |");
			System.out.println("|2. nhập biên lai                        |");
			System.out.println("|3. In Dnh sách khách hàng               |");
			System.out.println("|4. In Biên lai thu tiền điện            |");
			System.out.println("|5. Kết thúc chương trình                |");
			System.out.println("+----------------------------------------+");
			System.out.println(">>            Lựa chọn của bạn?         <<");
			int a;
			a = Scanner.nextInt();
			if (a == 1) {
			nhapkhachhang();
			} else if (a==2){
				nhapbienlai();
			} else if (a==3){
				inkhachhang();
			}else if (a==4){
				inbienlai();}}
		
		}
		
		

	

	public static void nhapkhachhang() {
		System.out.println("1 Nhập vào số lượng các hộ sử dụng điện");
		n = Scanner.nextInt();
		Scanner.nextLine();

		for (int i = 0; i < n; i++) {
			khachhang x = new khachhang();
			Scanner.nextLine();

			System.out.print("Khách hàng thứ  " + (i + 1));
			System.out.print("\n");

			System.out.println("Mã số khách hàng: ");
			String makhachang = Scanner.nextLine();
			System.out.println("Nhập tên khách hàng: ");
			String tenkhachhang = Scanner.nextLine();
			System.out.println("Nhập địa chỉ: ");
			String diachi = Scanner.nextLine();
			System.out.println("Mã công tơ: ");
			Double macongto = Scanner.nextDouble();
			x.setTenkh(tenkhachhang);
			x.setMakh(makhachang);
			x.setDiachikh(diachi);
			x.setMacongto(macongto);

			arrKhachHang.add(x);

		}
		Scanner.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		Scanner.nextLine();
	}
	
public static void nhapbienlai() {
		
		System.out.println("Nhập chỉ số điện tiêu thụ :");

		for (int i = 0; i < n; i++) {

			Scanner.nextLine();
			
			System.out.println("Tên Khách hàng : " +arrKhachHang.get(i).getTenkh());
			System.out.println("Mã Khách hàng : " +arrKhachHang.get(i).getMakh());
			System.out.println("Mã Công Tơ :" + arrKhachHang.get(i).getMacongto());
			
			System.out.println("Nhập Chỉ Số Điện Cũ :");
			int chisotruoc=Scanner.nextInt();
			
			System.out.println("Nhập Chỉ Số Điện Mới :");
			int chisosau=Scanner.nextInt();
			
			arrbienlai.add(new bienlai(arrKhachHang.get(i).getMakh(),
					arrKhachHang.get(i).getTenkh(),
					arrKhachHang.get(i).getDiachikh(),arrKhachHang.get(i).getMacongto(),
					chisotruoc,chisosau));			
		}	
		
		Scanner.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		Scanner.nextLine();
	}

	public static void inbienlai() {
		
		System.out.println("Danh sách tính tiền điện của khách hàng ");
		System.out.println("-------------------------------------------------------------------------------------------------------------------");
		System.out.println("STT  MasoKH    TênKH           Địa chỉ     macongto  Chỉ số trước  Chỉ số sau     Tiền điện     ");
		System.out.println("-------------------------------------------------------------------------------------------------------------------");
		for (int i = 0; i < arrbienlai.size(); i++) {

			System.out.printf("%-5s%-10s%-16s%-12s%-12s%-14s%-12s%-14s\n",
					(i + 1),
					arrKhachHang.get(i).getMakh(),
					arrKhachHang.get(i).getTenkh(),
					arrKhachHang.get(i).getDiachikh(),
					arrKhachHang.get(i).getMacongto(),
					arrbienlai.get(i).getChisomoi(),
					arrbienlai.get(i).getChisocu(),
					arrbienlai.get(i).tiendien());
		}
		
		Scanner.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		Scanner.nextLine();
	}
	
public static void inkhachhang() {
		
		System.out.println("Danh sách tính tiền điện của khách hàng ");
		System.out.println("------------------------------------------------------");
		System.out.println("STT  MasoKH    TênKH           Địa chỉ     macongto  ");
		System.out.println("------------------------------------------------------");
		for (int i = 0; i < arrKhachHang.size(); i++) {

			System.out.printf("%-5s%-10s%-16s%-12s%-12s\n",
					(i + 1),
					arrKhachHang.get(i).getMakh(),
					arrKhachHang.get(i).getTenkh(),
					arrKhachHang.get(i).getDiachikh(),
					arrKhachHang.get(i).getMacongto());}
		
		Scanner.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		Scanner.nextLine();
	}

	public static void ketThuc() {
		System.out.println("Kết thúc chương trình!!!!!");
		System.exit(0);
	}

	}
