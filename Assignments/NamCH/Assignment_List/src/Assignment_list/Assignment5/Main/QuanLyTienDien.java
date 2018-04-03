package Assignment_list.Assignment5.Main;
import Assignment_list.Assignment5.Model.*;
import java.util.Scanner;
import java.util.ArrayList;
public class QuanLyTienDien {
	public static Scanner input= new Scanner(System.in);
	public static ArrayList<KhachHang> arrKhachHang=new ArrayList<KhachHang>();
	public static ArrayList<BienLai> arrBienLai=new ArrayList<BienLai>();
	public static int stt=0,stt1=0,size=0,j=2,a=0;
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
		System.out.print("Nhập biên lai của tháng :");
		int blThang=input.nextInt();
		System.out.print("Nhập biên lai của năm :");
		int blNam=input.nextInt();
		for(int i=0;i<arrKhachHang.size();i++) {
			
			System.out.println("Tên Khách hàng : " +arrKhachHang.get(i).getTenKhachHang());
			System.out.println("Mã Khách hàng : " +arrKhachHang.get(i).getMaKhachHang());
			System.out.println("Mã Công Tơ :" + arrKhachHang.get(i).getMaCongTo());
			
			System.out.print("Nhập Chỉ Số Điện Cũ :");
			int chiSoCu=input.nextInt();
			System.out.print("Nhập Chỉ Số Điện Mới :");
			int chiSoMoi=input.nextInt();
				
			arrBienLai.add(new BienLai(arrKhachHang.get(i).getMaKhachHang(),
					arrKhachHang.get(i).getTenKhachHang(),
					arrKhachHang.get(i).getDiaChi(),arrKhachHang.get(i).getMaCongTo(),
					chiSoCu,chiSoMoi,blThang,blNam));			
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
		System.out.println("----------------DANH SÁCH BIÊN LAI TẤT CẢ KHÁCH HÀNG----------------");
		System.out.println("====================================================================");
		System.out.println("||Stt||Mã|| Tên  ||Địa Chỉ||Mã Công Tơ||Chỉ Số Cũ||Chỉ Số Mới||Tiền Điện||Tháng||Năm");
		int sothutu=1;
		int sum=0;
		for(BienLai bienLai: arrBienLai) {
			System.out.print("|| " + sothutu+"  ");
			System.out.println(bienLai);	
			sothutu++;
			sum=bienLai.getTienDien()+sum;
		}
		System.out.println("Tiền điện tiêu thụ trong 1 năm là : "+sum);
	}
	public static void printByThang() {
		System.out.println("------------------------DANH SÁCH KHÁCH HÀNG------------------------");
		System.out.println("====================================================================");
		System.out.println("Nhập Tháng cần in biên Lai:");
		int inThang=input.nextInt();
		System.out.println("Nhập Năm cần in biên Lai:");
		int inNam=input.nextInt();
		System.out.println("||Stt||Mã|| Tên  ||Địa Chỉ||Mã Công Tơ||Chỉ Số Cũ||Chỉ Số Mới||Tiền Điện||Tháng||Năm");
		for(BienLai bienLai: arrBienLai) {			
			int sosanhthang=bienLai.getBlThang();
			int sosanhnam=bienLai.getBlNam();
			if(inThang == sosanhthang && inNam==sosanhnam) {
				System.out.println(bienLai);
				  }
		}
		
	}
	public static void printThongKe() {
		System.out.println("------------------------DANH SÁCH KHÁCH HÀNG------------------------");
		System.out.println("====================================================================");
		System.out.println("Thông Kê Từ :");
		System.out.println("Nhập Tháng:");
		int inThang=input.nextInt();
		System.out.println("Nhập Năm :");
		int inNam=input.nextInt();
		System.out.println("Thống Kê Đến");
		System.out.println("Nhập Tháng:");
		int inThangden=input.nextInt();
		System.out.println("Nhập Năm :");
		int inNamden=input.nextInt();
		System.out.println("||Stt||Mã|| Tên  ||Địa Chỉ||Mã Công Tơ||Chỉ Số Cũ||Chỉ Số Mới||Tiền Điện||Tháng||Năm");
		for(BienLai bienLai: arrBienLai) {			
			int sosanhthang=bienLai.getBlThang();
			int sosanhnam=bienLai.getBlNam();
			if((sosanhthang >= inThang && inNam<=sosanhnam &&sosanhnam<=inNamden)||
					(sosanhthang<=inThangden && sosanhnam<=inNamden && sosanhnam>inNam)) {
				System.out.println(bienLai);
				  }
		}
		
	}
	public static void printByNameThang() {
		System.out.println("------------------------DANH SÁCH KHÁCH HÀNG------------------------");
		System.out.println("====================================================================");
		System.out.print("Nhập Tên khách hàng cần in biên Lai:");
		input.nextLine();
		String tenKh = input.nextLine();		
		System.out.println("Nhập tháng cần in biên Lai:");
		int inThang=input.nextInt();
		System.out.println("Nhập năm cần in biên Lai:");
		int inNam=input.nextInt();		
		System.out.println("||Stt||Mã|| Tên  ||Địa Chỉ||Mã Công Tơ||Chỉ Số Cũ||Chỉ Số Mới||Tiền Điện||Tháng||Năm");
		for(BienLai bienLai: arrBienLai) {	
			int sosanhthang=bienLai.getBlThang();
			int sosanhnam=bienLai.getBlNam();
			String sosanhten = bienLai.getTenKhachHang();			
			if(tenKh.equals(sosanhten)&&sosanhthang==inThang&&sosanhnam==inNam) {
				System.out.println(bienLai);
			}
		}
		
	}
	public static void printByName() {
		System.out.println("------------------------DANH SÁCH KHÁCH HÀNG------------------------");
		System.out.println("====================================================================");
		System.out.print("Nhập Tên khách hàng cần in biên Lai:");
		input.nextLine();
		String tenKh = input.nextLine();				
		System.out.println("||Stt||Mã|| Tên  ||Địa Chỉ||Mã Công Tơ||Chỉ Số Cũ||Chỉ Số Mới||Tiền Điện||Tháng||Năm");
		for(BienLai bienLai: arrBienLai) {			
			String sosanhten = bienLai.getTenKhachHang();			
			if(tenKh.equals(sosanhten)) {
				System.out.println(bienLai);
			}
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
			System.out.println("         __________________________________");
			System.out.println("         |=================================|");
			System.out.println("         |-------CHỌN LỰA CHỨC NĂNG--------|");
			System.out.println("         |---------------------------------|");
			System.out.println("         |--1.Nhập Danh Sách Khách Hàng----|");
			System.out.println("         |--2.Nhập Danh Sách Tiền Điện-----|");
			System.out.println("         |--3.In Danh Sách Khách Hàng------|");
			System.out.println("         |--4.In Tất cả Biên Lai Khách Hàng|");
			System.out.println("         |--5.In Biên Lai Theo Tháng-------|");
			System.out.println("         |--6.In Biên Lai Theo Thông Kê----|");
			System.out.println("         |--7.In Biên Lai Theo Tên --------|");
			System.out.println("         |--8.In Biên Lai Theo Tên và tháng|");
			System.out.println("         |=================================|");
			System.out.println("         |--9.Kết thúc chương trình--------|");
			System.out.println("         |_________________________________|");
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
			}else if(act==5) {
				printByThang();
			}else if(act==6) {
				printThongKe();
			}else if(act==7) {
				printByName();
			}else if(act==8) {
				printByNameThang();
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
