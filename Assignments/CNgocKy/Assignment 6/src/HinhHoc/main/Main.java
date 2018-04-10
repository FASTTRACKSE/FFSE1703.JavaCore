package HinhHoc.main;

import HinhHoc.modle.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static ArrayList<HinhTron> arrHinhTron = new ArrayList<HinhTron>();
	public static ArrayList<HinhHoc> arrHinhHoc = new ArrayList<HinhHoc>();
	public static ArrayList<HinhChuNhat> arrHinhChuNhat = new ArrayList<HinhChuNhat>();
	public static ArrayList<HinhTamGiac> arrHinhTamGiac = new ArrayList<HinhTamGiac>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myMenu();
	}

	public static void myMenu() {
		for (;;) {

			Scanner input = new Scanner(System.in);
			System.out.println("         __________________________________________");
			System.out.println("         |=========================================|");
			System.out.println("         |-----------CHỌN LỰA CHỨC NĂNG------------|");
			System.out.println("         |-----------------------------------------|");
			System.out.println("         |--1.Nhập thông tin hình tròn-------------|");
			System.out.println("         |--2.Nhâp thông tin hình tam giác --------|");
			System.out.println("         |--3.Nhâp thông tin hình chử nhật---------|");
			System.out.println("         |--4.In thông tin-------------------------|");
			System.out.println("         |=========================================|");
			System.out.println("         |--5.Kết thúc chương trình----------------|");
			System.out.println("         |_________________________________________|");
			System.out.print("     Nhập chức năng mà bạn muốn thực hiện :");
			int act = Integer.parseInt(input.nextLine());
			if (act == 1) {
				nhapHT();
			} else if (act == 2) {
				nhapHTG();
			} else if (act == 3) {
				nhapHCN();
			} else if (act == 4) {
				inGiaTri();
			} else {
				ketThuc();
			}
			input.nextLine();
			System.out.println("=====================================");
			System.out.println("-------Nhập ENTER để tiếp tục------");
			input.nextLine();
		}
	}

	public static void nhapHT() {
		Scanner input = new Scanner(System.in);
		HinhTron a = new HinhTron();
		System.out.println("Nhập bán kính hình tròn: ");
		int bk = input.nextInt();
		a.setBanKinh(bk);

		arrHinhTron.add(a);

	}

	public static void nhapHCN() {
		Scanner input = new Scanner(System.in);
		HinhChuNhat a = new HinhChuNhat();
		System.out.println("Nhập Chiều dài hình chữ nhật : ");
		int cd = input.nextInt();
		a.setChieuDai(cd);
		System.out.println("Nhập Chiều rộng hình chữ nhật : ");
		int cr = input.nextInt();
		a.setChieuRong(cr);

		arrHinhChuNhat.add(a);
	}

	public static void nhapHTG() {
		Scanner input = new Scanner(System.in);
		HinhTamGiac a = new HinhTamGiac();
		System.out.println("Nhập Chiều dài cạnh A : ");
		int cA = input.nextInt();
		a.setCanhA(cA);
		System.out.println("Nhập Chiều dài cạnh B : ");
		int cB = input.nextInt();
		a.setCanhB(cB);
		System.out.println("Nhập Chiều dài cạnh C : ");
		int cC = input.nextInt();
		a.setCanhC(cC);
		System.out.println("Nhập Chiều Cao : ");
		int chieuC = input.nextInt();
		a.setChieuCao(chieuC);
		System.out.println("Nhập Chiều Đáy : ");
		int day = input.nextInt();
		a.setCanhDay(day);

		arrHinhTamGiac.add(a);
	}

	public static void inGiaTri() {

		System.out.println("| ------------------------DANH SÁCH HIỂN THỊ-----------------------------   |");
		System.out.println("--------------------------------------------------------------------------");
		for (int i = 0; i < arrHinhTron.size(); i++) {
			System.out.println("Hình Tròn: Bán Kính: " + arrHinhTron.get(i).getBanKinh() + " || " + "Chu Vi: "
					+ arrHinhTron.get(i).getChuVi() + " || " + " Diện Tích: " + arrHinhTron.get(i).getDienTich());
		}
		System.out.println("--------------------------------------------------------------------------");
		for (int i = 0; i < arrHinhChuNhat.size(); i++) {
			System.out.println("Hình Chữ Nhật: Chiều dài: " + arrHinhChuNhat.get(i).getChieuDai() + " || "
					+ "Chiều Rộng : " + arrHinhChuNhat.get(i).getChieuRong() + " || " + "Chu Vi: "
					+ arrHinhChuNhat.get(i).getChuVi() + " || " + " Diện Tích: " + arrHinhChuNhat.get(i).getDienTich());
		}
		System.out.println("--------------------------------------------------------------------------");
		for (int i = 0; i < arrHinhTamGiac.size(); i++) {
			System.out.println("Hình Tam Giác:  " + "Chu Vi: " + arrHinhTamGiac.get(i).getChuVi() + " || "
					+ " Diện Tích: " + arrHinhTamGiac.get(i).getDienTich());
		}

	}

	public static void ketThuc() {
		System.out.println("Kết thúc chương trình!!!!!");
		System.exit(0);
	}
}
