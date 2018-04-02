package Assignment_list.Asm6.hinhhoc.main;
import Assignment_list.Asm6.hinhhoc.model.*;
import java.util.Scanner;
public class TinhHinhHoc {
	public static Scanner input=new Scanner(System.in);
	public static HinhHoc tinh1=new HinhTron();
	public static HinhHoc tinh2=new HinhTamGiac();
	public static HinhHoc tinh3=new HinhChuNhat();	
	public static void main(String[] args) {
		myMenu();
	}
	
	public static void tinhHinhTron() {
		System.out.println("TÍNH CHU VI & DIỆN TÍCH HÌNH TRÒN");
		System.out.println("=================================");
		System.out.println("Nhập Bán Kính Hình Tròn ?");
		int banKinh=Integer.parseInt(input.nextLine());
		tinh1 =new HinhTron(banKinh);
		tinh1.getChuVi();
		tinh1.getDienTich();
	}		
	
	public static void tinhHinhTamGiac() {
		System.out.println("TÍNH CHU VI HÌNH TAM GIÁC");
		System.out.println("=========================");
		System.out.println("Nhập Cạnh thứ nhất của hình tam giác ?");
		int canhA=Integer.parseInt(input.nextLine());
		System.out.println("Nhập Cạnh thứ hai của hình tam giác ?");
		int canhB=Integer.parseInt(input.nextLine());
		System.out.println("Nhập Cạnh thứ ba của hình tam giác ?");
		int canhC=Integer.parseInt(input.nextLine());
		tinh2=new HinhTamGiac(canhA,canhB,canhC);
		tinh2.getChuVi();
		
		System.out.println("TÍNH DIỆN TÍCH HÌNH TAM GIÁC");
		System.out.println("============================");
		System.out.println("Nhập Chiều Cao của hình tam giác ?");
		int chieuCao=Integer.parseInt(input.nextLine());
		System.out.println("Nhập Cạnh Đáy của hình tam giác ?");
		int canhDay=Integer.parseInt(input.nextLine());
		tinh2=new HinhTamGiac(chieuCao,canhDay);
		tinh2.getDienTich();
	}	
	
	public static void tinhHinhChuNhat() {
		System.out.println("TÍNH CHU VI & DIỆN TÍCH HÌNH CHỮ NHẬT");
		System.out.println("=====================================");
		System.out.println("Nhập Chiều Dài Hình Chữ Nhật ?");
		int chieuDai=Integer.parseInt(input.nextLine());
		System.out.println("Nhập Chiều Rộng Hình Chữ Nhật ?");
		int chieuRong=Integer.parseInt(input.nextLine());
		tinh3 =new HinhChuNhat(chieuDai,chieuRong);
		tinh3.getChuVi();
		tinh3.getDienTich();
	}		
	
	public static void endTinh() {
		System.out.println("Kết thúc chương trình");
		System.out.println("======================");
		System.out.println("=======Tkank you======");
		System.exit(0);
	}
	
	public static void myMenu() {
		while(true) {
			System.out.println("         __________________________________________");
			System.out.println("         |=========================================|");
			System.out.println("         |-----------CHỌN LỰA CHỨC NĂNG------------|");
			System.out.println("         |-----------------------------------------|");
			System.out.println("         |--1.Tính Chu Vi & Diện Hình Tròn---------|");
			System.out.println("         |--2.Tính Chu Vi & Diện Tích Hình Tam Giác|");
			System.out.println("         |--3.Tính Chu Vi & Diện Tích Hình Chữ Nhật|");
			System.out.println("         |=========================================|");
			System.out.println("         |--4.Kết thúc chương trình----------------|");
			System.out.println("         |_________________________________________|");
			System.out.print("     Nhập chức năng mà bạn muốn thực hiện :");
			int act = Integer.parseInt(input.nextLine());
			if(act ==1) {
				tinhHinhTron();
			}else if(act ==2) {
				tinhHinhTamGiac();
			}else if(act==3) {
				tinhHinhChuNhat();
			}else {
				endTinh();
			}
			input.nextLine();
			System.out.println("=====================================");
			System.out.println("-------Nhập ENTER để tiếp tục------");
			input.nextLine();
		}
	}
}
