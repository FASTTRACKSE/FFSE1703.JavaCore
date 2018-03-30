package Assignment_list.Assignment5.Main;
import Assignment_list.Assignment5.Model.*;
import java.util.Scanner;
import java.util.ArrayList;
public class QuanLyTienDien {
	public static Scanner input= new Scanner(System.in);
	public static ArrayList<KhachHang> arrKhachHang=new ArrayList<KhachHang>();
	public static ArrayList<BienLai> arrBienLai=new ArrayList<BienLai>();
	public static int stt=0,size=0;
	public static void main(String[] args) {
		myMenu();
	}
	public static void addKhachHang() {
		System.out.println("THÊM KHÁCH HÀNG VÀO DANH SÁCH");
		System.out.println("=============================");
		System.out.println("Bạn muốn nhập bao nhiêu Khách Hàng ?");
		size= input.nextInt();		
		for (int i=0;i<size;i++) {
			input.nextLine();
			System.out.println("Nhập Mã khách hàng thứ "+(i+1)+" : ");
			String maKhachHang=input.nextLine();
			System.out.println("Nhập Tên khách hàng thứ "+(i+1)+" : ");
			String tenKhachHang=input.nextLine();
			System.out.println("Nhập Địa Chỉ khách hàng thứ "+(i+1)+" : ");
			String diaChi=input.nextLine();
			System.out.println("Nhập Mã Công Tơ của khách hàng thứ "+(i+1)+" : ");
			String maCongTo=input.nextLine();
			arrKhachHang.add(new KhachHang(maKhachHang,tenKhachHang,diaChi,maCongTo));
			
		}
	}
	public static void addBienLai() {
		System.out.println("NHẬP CHỈ SỐ TIỀN ĐIỆN CỦA KHÁCH HÀNG");
		System.out.println("====================================");
		for(;stt<arrKhachHang.size();stt++) {
			
			System.out.println("Tên Khách hàng : " +arrKhachHang.get(stt).getTenKhachHang());
			System.out.println("Mã Khách hàng : " +arrKhachHang.get(stt).getMaKhachHang());
			System.out.println("Mã Công Tơ :" + arrKhachHang.get(stt).getMaCongTo());
			System.out.println("Nhập Chỉ Số Điện Cũ :");
			int chiSoCu=input.nextInt();
			System.out.println("Nhập Chỉ Số Điện Mới :");
			int chiSoMoi=input.nextInt();
			input.nextLine();
			System.out.println("Nhập Ngày Tháng Năm:");
			String ntNam =input.nextLine();
			arrBienLai.add(new BienLai(arrKhachHang.get(stt).getMaKhachHang(),
					arrKhachHang.get(stt).getTenKhachHang(),
					arrKhachHang.get(stt).getDiaChi(),arrKhachHang.get(stt).getMaCongTo(),
					chiSoCu,chiSoMoi,ntNam));			
		}	
	}	
	public static void printKhachHang() {
		System.out.println("-------DANH SÁCH TẤT CẢ KHÁCH HÀNG--------");
		System.out.println("==========================================");
		System.out.println("|| Stt || Mã || Tên        ||Địa Chỉ||Mã Công Tơ");
		int sothutu=1;
		for(KhachHang KhachHang: arrKhachHang) {
			System.out.print("|| " + sothutu+"    ");
			System.out.println(KhachHang.toString());
			sothutu++;
		}
	}
	public static void printBienLai() {
		System.out.println("---------------------DANH SÁCH TẤT CẢ KHÁCH HÀNG--------------------");
		System.out.println("====================================================================");
		System.out.println("|| Stt || Mã || Tên  ||Địa Chỉ||Mã Công Tơ||Chỉ Số Cũ||Chỉ Số Mới||Tiền Điện||Tháng");
		int sothutu=1;
		for(BienLai bienLai: arrBienLai) {
			System.out.print("|| " + sothutu+"    ");
			System.out.println(bienLai);	
			sothutu++;
		}
	}
	public static void endQl() {
		System.out.println("Kết thúc chương trình");
		System.out.println("======================");
		System.out.println("=======Tkank you======");
		System.exit(0);
	}
	public static void myMenu() {
		while(true) {
			System.out.println("         ________________________________");
			System.out.println("         |===============================|");
			System.out.println("         |-------CHỌN LỰA CHỨC NĂNG------|");
			System.out.println("         |-------------------------------|");
			System.out.println("         |--1.Nhập Danh Sách Khách Hàng--|");
			System.out.println("         |--2.Nhập Danh Sách Tiền Điện---|");
			System.out.println("         |--3.In Danh Sách Khách Hàng----|");
			System.out.println("         |--4.In Biên Lai Khách Hàng-----|");
			System.out.println("         |===============================|");
			System.out.println("         |--5.Kết thúc chương trình------|");
			System.out.println("         |_______________________________|");
			System.out.print("     Nhập chức năng mà bạn muốn thực hiện :");
			int act = input.nextInt();
			if(act ==1) {
				addKhachHang();
			}else if(act ==2) {
				addBienLai();
			}else if(act==3) {
				printKhachHang();
			}else if(act==4) {
				printBienLai();
			}else {
				endQl();
			}
			input.nextLine();
			System.out.println("=====================================");
			System.out.println("-------Nhập ENTER để tiếp tục------");
			System.out.println("Hoặc gõ K để kết thúc trương trình");
			input.nextLine();
		}
	}


}
