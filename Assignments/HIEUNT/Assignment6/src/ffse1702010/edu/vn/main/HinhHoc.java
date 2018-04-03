package ffse1702010.edu.vn.main;

import java.util.ArrayList;
import java.util.Scanner;

import ffse1702010.edu.vn.model.*;

public class HinhHoc {
	public static Scanner input = new Scanner(System.in);
	public static ArrayList<AbstractHinhHoc> arrHinhHoc = new ArrayList<AbstractHinhHoc>();
	public static HinhTamGiac tamgiac = new HinhTamGiac();
	public static HinhChuNhat chunhat = new HinhChuNhat();
	public static HinhTron hinhtron = new HinhTron();

	public static void main(String[] args) {

		meNu();

	}

	public static void nhapTamGiac() {
		System.out.println("Nhập cạnh A");
		int canhA = input.nextInt();
		System.out.println("Nhập cạnh B");
		int canhB = input.nextInt();
		System.out.println("Nhập cạnh C");
		int canhC = input.nextInt();
		tamgiac.setCanhA(canhA);
		tamgiac.setCanhB(canhB);
		tamgiac.setCanhC(canhC);
		System.out.println("Chu vi tam giác là:");
		System.out.println(tamgiac.getChuVi());
		System.out.println("Diện tích tam giác;");
		System.out.println(tamgiac.getDienTich());
	
		arrHinhHoc.add(tamgiac);

	}

	public static void nhapChuNhat() {

		System.out.println("Nhập chiều rộng");
		int ChieuRong = input.nextInt();
		System.out.println("Nhập chiều dài");
		int ChieuDai = input.nextInt();
		
		chunhat.setChieuDai(ChieuDai);
		chunhat.setChieuRong(ChieuRong);
		System.out.println("Chu vi chữ nhật là:");
		System.out.println(chunhat.getChuVi());
		System.out.println("Diện tích chữ nhật;");
		System.out.println(chunhat.getDienTich());
		
		arrHinhHoc.add(chunhat);

	}

	public static void NhapHinhTron() {
		System.out.println("Nhập vào bán kính:");
		Double banKinh = input.nextDouble();
		hinhtron.setBanKinh(banKinh);

		System.out.println("Chu vi hình tròn là:");
		System.out.println(hinhtron.getChuVi());
		System.out.println("Diện tích hình tròn;");
		System.out.println(hinhtron.getDienTich());
		arrHinhHoc.add(hinhtron);
	}

	public static void meNu() {
		while (true) {
			System.out.println(">>              MENU CUA TOI            <<");
			System.out.println("+----------------------------------------+");
			System.out.println("|1. Hình chữ nhật                        |");
			System.out.println("|2. Hình Tam Gíac                        |");
			System.out.println("|3. Hình tròn                            |");
			System.out.println("|4. In chu vi diện tích các hình         |");
			System.out.println("|5. kết thúc chương trình                |");
			System.out.println("+----------------------------------------+");
			System.out.println(">>            Bạn ChON SỐ MẤY?          <<");
			int a;
			a = input.nextInt();
			if (a == 1) {
				nhapChuNhat();
			} else if (a == 2) {
				nhapTamGiac();
			} else if (a == 3) {
				NhapHinhTron();

			} else if (a == 4) {
				intatca();
			} else if (a == 5) {
				ketThuc();
			}

		}

	}

	public static void ketThuc() {
		System.out.println("++++++++++ Chương trình kết thúc++++++++++");
		System.exit(0);

	}

	public static void intatca() {
		System.out
				.println("+---------------------------------CHU VI, DIỆN TÍCH------------------------------ --------+");
		System.out.println("STT		HÌNH		THUỘC TÍNH		CHU VI		DIỆN TÍCH	");
		for (int i = 0; i < arrHinhHoc.size(); i++) {
			if (arrHinhHoc.get(i) instanceof HinhTamGiac) {
				System.out.println((i+1)+"          "+"HÌNH TAM GIÁC"+"           "+tamgiac.getCanhA()+","+tamgiac.getCanhB()+","+tamgiac.getCanhC()+"                  "+tamgiac.getChuVi()+"             "+tamgiac.getDienTich());
				

			}else if(arrHinhHoc.get(i) instanceof HinhTron) {
				System.out.println((i+1)+"             "+"HÌNHTRòn"+"            "+hinhtron.getBanKinh()+"                  "+hinhtron.getChuVi()+"                 "+hinhtron.getDienTich());

				
			}else if(arrHinhHoc.get(i) instanceof HinhChuNhat) {
				System.out.println((i+1)+"           "+"HÌNH Chữ Nhật"+"          "+chunhat.getChieuDai()+","+chunhat.getChieuRong()+"                  "+chunhat.getChuVi()+"              "+chunhat.getDienTich());
 System.out.println("+.............................................................................................+");
 System.out.println("__________♥♥♥♥♥♥♥♥♥♥♥♥♥__________\r\n" + 
 		"__________♥♥♥♥♥♥♥♥♥♥♥♥♥__________ \r\n" + 
 		"______________♥♥♥♥♥______________ \r\n" + 
 		"______________♥♥♥♥♥______________ \r\n" + 
 		"______________♥♥♥♥♥______________ \r\n" + 
 		"______________♥♥♥♥♥______________ \r\n" + 
 		"______________♥♥♥♥♥______________ \r\n" + 
 		"______________♥♥♥♥♥______________ \r\n" + 
 		"______________♥♥♥♥♥______________ \r\n" + 
 		"__________♥♥♥♥♥♥♥♥♥♥♥♥♥__________ \r\n" + 
 		"__________♥♥♥♥♥♥♥♥♥♥♥♥♥__________ \r\n" + 
 		"_________________________________ \r\n" + 
 		"______♥♥♥♥♥♥♥♥___________________ \r\n" + 
 		"____♥♥♥♥♥♥♥♥♥♥♥♥_________________ \r\n" + 
 		"__♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥_______________ \r\n" + 
 		"_♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥____♥♥♥♥♥♥♥___ \r\n" + 
 		"_♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥_♥♥♥♥♥♥♥♥♥♥♥_ \r\n" + 
 		"_♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥ \r\n" + 
 		"_♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥ \r\n" + 
 		"__♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥ \r\n" + 
 		"___♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥_ \r\n" + 
 		"_____♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥___ \r\n" + 
 		"_______♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥____ \r\n" + 
 		"_________♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥______ \r\n" + 
 		"___________♥♥♥♥♥♥♥♥♥♥♥♥♥♥________ \r\n" + 
 		"____________♥♥♥♥♥♥♥♥♥♥♥__________ \r\n" + 
 		"____________♥♥♥♥♥♥♥♥♥____________ \r\n" + 
 		"____________♥♥♥♥♥♥_______________ \r\n" + 
 		"___________♥♥♥♥__________________ \r\n" + 
 		"__________♥♥_____________________ \r\n" + 
 		"_________♥_______________________ \r\n" + 
 		"_________________________________ \r\n" + 
 		"______♥♥♥♥♥___________♥♥♥♥♥______ \r\n" + 
 		"______♥♥♥♥♥___________♥♥♥♥♥______ \r\n" + 
 		"______♥♥♥♥♥___________♥♥♥♥♥______ \r\n" + 
 		"______♥♥♥♥♥___________♥♥♥♥♥______ \r\n" + 
 		"______♥♥♥♥♥___________♥♥♥♥♥______ \r\n" +
 		"____________ ♥♥♥♥♥♥_______________ \r\n" + 
 		"______♥♥♥♥♥___________♥♥♥♥♥______");
		}

	}

	// tamgiac.nhap();
	// System.out.println("Chu vi hình tam giác là");
	// Double q = tamgiac.getChuVi();

	// System.out.println(q);
	// System.out.println("Diện Tích Hình tam giác là");
	// System.out.println(tamgiac.getDienTich());

}}
