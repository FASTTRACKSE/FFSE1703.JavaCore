package hinhhoc.main;
import hinhhoc.model.*;
import java.util.Scanner;
import java.util.ArrayList;
public class Output {
	public static Scanner myInput = new Scanner(System.in);
	public static ArrayList<HinhHoc> arrHinhHoc = new ArrayList<>();
	public static void main(String[] args) {

	myMenu();
		
		
		
//		HinhHoc HinhTron = new HinhTron(4.0);
//		HinhTron.getChuVi(); 
//		HinhTron.getDienTich();
//		
//		HinhHoc HinhChuNhat = new HinhChuNhat(4.0,6.0);
//		HinhChuNhat.getChuVi();
//		HinhChuNhat.getDienTich();
//		
//		HinhHoc HinhTamGiac = new HinhTamGiac(5.0,5.0,5.0);
//		HinhTamGiac.getChuVi();
//		HinhTamGiac.getDienTich();
	}
	public static void HinhTron() {
		System.out.println("CHU VI VA DIEN TICH HINH TRON");
		System.out.println("NHAP BAN KINH : ");
		double banKinh = myInput.nextDouble();
		arrHinhHoc.add(new HinhTron(banKinh));

	}
	public static void HinhChuNhat() {
		System.out.println("CHU VI VA DIEN TICH HINH CHU NHAT");
		System.out.println("NHAP CHIEU DAI : ");
		double chieuDai = myInput.nextDouble();
		System.out.println("NHAP CHIEU RONG : ");
		double chieuRong = myInput.nextDouble();
		arrHinhHoc.add(new HinhChuNhat(chieuDai,chieuRong));
		
	}
	public static void HinhTamGiac() {
		System.out.println("CHU VI VA DIEN TICH HINH TAM GIAC");
		System.out.println("NHAP CANH A : ");
		double canhA = myInput.nextDouble();
		System.out.println("NHAP CANH B : ");
		double canhB = myInput.nextDouble();
		System.out.println("NHAP CANH C : ");
		double canhC = myInput.nextDouble();
		arrHinhHoc.add(new HinhTamGiac(canhA,canhB,canhC));
	}
	public static void HinhVuong() {
		System.out.println("CHU VI VA DIEN TICH HINH VUONG");
		System.out.println("NHAP CANH : ");
		double canh = myInput.nextDouble();
		arrHinhHoc.add(new HinhVuong(canh));
	}
	public static void Indanhsach() {
		for (HinhHoc x : arrHinhHoc) {
			if(x instanceof HinhTron) {
				System.out.println("Hinh Tron    ||" + "Dien Tich la: "+ x.getDienTich()+"||Chu Vi la: "+ x.getChuVi() + " ||Ban Kinh: " + ((HinhTron)x).getBanKinh());
			}else if(x instanceof HinhChuNhat) {
				System.out.println("Hinh Chu Nhat||" + "Dien Tich la: " + x.getDienTich()+"||Chu Vi la: "+ x.getChuVi() +
				"||Chieu Dai: " + ((HinhChuNhat) x).getChieuDai()+"||Chieu Rong: "+ ((HinhChuNhat)x).getChieuRong());
			}else if(x instanceof HinhTamGiac) {
				System.out.println("Hinh Tam Giac||" + "Dien Tich la: "+ x.getDienTich() + "||Chu Vi la: "+ x.getChuVi()+
				"||CanhA: "+ ((HinhTamGiac)x).getCanhA()+"||CanhB: "+ ((HinhTamGiac)x).getCanhB()+"||CanhC: "+ ((HinhTamGiac)x).getCanhC());
			}else if(x instanceof HinhVuong) {
				System.out.println("Hinh Vuong   ||"+ "Dien Tich la: " + x.getDienTich() + "||Chu Vi la: " + x.getChuVi() + "||Canh: "+ ((HinhVuong)x).getCanh());
			}
		}
	}
	public static void Ketthuc(){
		System.exit(0);
	}
	public static void  myMenu() {
		while (true) {
			System.out.println("<=LUA CHON CHUC NANG=>");
			System.out.println("|| 1.HiNH TRON     ||");
			System.out.println("|| 2.HINH CHU NHAT ||");
			System.out.println("|| 3.HINH TAM GIAC ||");
			System.out.println("|| 4.HINH VUONG    ||");
			System.out.println("|| 5.IN DANH SACH  ||");
			System.out.println("|| 6.KET THUC      ||");
			System.out.println("<===================>");
			System.out.println("  LUA CHON CUA BAN   ");
			int option = myInput.nextInt();
			if (option == 1) {
				HinhTron();
			} else if (option == 2) {
				HinhChuNhat();
			} else if (option == 3) {
				HinhTamGiac();
			} else if (option == 4) {
				HinhVuong();
			} else if (option == 5) {
				Indanhsach();
			} else if (option == 6) {
				Ketthuc();
			} 
		}
	}
}	

