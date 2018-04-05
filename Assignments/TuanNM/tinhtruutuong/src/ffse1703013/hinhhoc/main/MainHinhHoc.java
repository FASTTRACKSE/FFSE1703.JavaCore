package ffse1703013.hinhhoc.main;

import java.util.Scanner;

import java.util.ArrayList;
import ffse1703013.hinhhoc.modle.*;

public class MainHinhHoc {
	public static Scanner myScanner = new Scanner(System.in);
	static ArrayList<HinhHoc> arrHinhHoc = new ArrayList<HinhHoc>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myMenu();
	}

	public static void hinhChuNhat() {
		HinhChuNhat hCN = new HinhChuNhat();
		System.out.println("Nhập thông tin hình tròn : ");
		System.out.println("nhập chiều dài: ");
		String ten = "Hình Chữ nhật";
		Double chieuDai = myScanner.nextDouble();
		hCN.setChieuDai(chieuDai);
		System.out.println("nhập chiều rộng: ");
		Double chieuRong = myScanner.nextDouble();
		hCN.setChieuRong(chieuRong);
		System.out.println("chiều dai : " + chieuDai);
		System.out.println("chiều rộng : " + chieuRong);
		System.out.println("Chu vi hình chữ nhật là : " + hCN.getChuVi());
		System.out.println("Diện tích hình chữ nhật là : " + hCN.getDienTich());
		arrHinhHoc.add(new HinhChuNhat(ten, chieuDai, chieuRong));
	}

	public static void hinhTron() {
		String ten = "Hình tròn";
		System.out.println("Nhập thông tin hình tròn : ");
		HinhTron hTron = new HinhTron();
		System.out.println("nhập bán kính: ");
		Double banKinh = myScanner.nextDouble();
		hTron.setR(banKinh);
		System.out.println("bán kính : " + banKinh);
		System.out.println("Chu vi hình tròn là : " + hTron.getChuVi());
		System.out.println("Diện tích hình tròn là : " + hTron.getDienTich());
		arrHinhHoc.add(new HinhTron(ten, banKinh));
	}

	public static void hinhTamGiac() {
		HinhTamGiac hTG = new HinhTamGiac();
		String tenTG = "Hình tam giác";
		System.out.println("Nhập thông tin hình tam giác : ");
		System.out.println("nhập canh A: ");
		Double canhA = myScanner.nextDouble();
		hTG.setCanhA(canhA);
		System.out.println("nhập Canh B: ");
		Double canhB = myScanner.nextDouble();
		hTG.setCanhB(canhB);
		System.out.println("nhập Canh B: ");
		Double canhC = myScanner.nextDouble();
		hTG.setCanhC(canhB);
		System.out.println("canh A: " + canhA);
		System.out.println("cạnh B : " + canhB);
		System.out.println("canh C: " + canhC);
		System.out.println("Chu vi hình tamlà : " + hTG.getChuVi());
		System.out.println("Diện tích hình chữ nhật là : " + hTG.getDienTich());
		arrHinhHoc.add(new HinhTamGiac(tenTG, canhA, canhB, canhC));
	}

	public static void inHinhHoc() {
		System.out.println(
				"+---------------------------------Danh sách hình chử nhật---------------------------------------+");
		System.out.println(
				"| STT |  Tên hình          |             thuộc tính                     |    chu vi | Diện tích |");
		int stt = 0;
		for (HinhHoc x : arrHinhHoc) {
			System.out.printf("%-8s", stt++);
			if (x instanceof HinhChuNhat) {
				System.out.printf("%-21s", ((HinhChuNhat) x).getTen());
				System.out.printf("Chiều dài : " + "%-10s ", ((HinhChuNhat) x).getChieuDai());
				System.out.printf("Chiều rộng : " + "%-11s", ((HinhChuNhat) x).getChieuRong());
				System.out.printf("%-11s %-12s \n", ((HinhChuNhat) x).getChuVi(), ((HinhChuNhat) x).getDienTich());
			}
			if (x instanceof HinhTamGiac) {
				System.out.printf("%-20s", ((HinhTamGiac) x).getTen());
				System.out.printf(" Canh A : " + "%-5s ", ((HinhTamGiac) x).getCanhA());
				System.out.printf(" Canh B : " + "%-5s ", ((HinhTamGiac) x).getCanhB());
				System.out.printf(" Canh C : " + "%-5s ", ((HinhTamGiac) x).getCanhC());
				System.out.printf("%-11s %-12s \n", ((HinhTamGiac) x).getChuVi(),
						Math.round(((HinhTamGiac) x).getDienTich()));
			}
			if (x instanceof HinhTron) {
				System.out.printf("%-21s", ((HinhTron) x).getTen());
				System.out.printf("Bán Kính : " + "%-36s", ((HinhTron) x).getR());
				System.out.printf("%-11s %-12s \n", ((HinhTron) x).getChuVi(), ((HinhTron) x).getDienTich());
			}
		}
	}

	public static void ketThuc() {
		System.out.println("++++++ Chương trình kết thúc+++++++");
		System.exit(0);
	}

	public static void myMenu() {
		while (true) {
			System.out.println("+------LỰA CHỌN CHỨC NĂNG-------+");
			System.out.println("| 1. Hình chữ nhật              |");
			System.out.println("| 2. Hình tròn                  |");
			System.out.println("| 3. Hình tam giác              |");
			System.out.println("| 4. Danh sách các hình         |");
			System.out.println("=================================");
			System.out.println("| 5. Kết thúc                   |");
			System.out.println("+-------------------------------+");
			int option = myScanner.nextInt();
			if (option == 1) {
				hinhChuNhat();
			} else if (option == 2) {
				hinhTron();
			} else if (option == 3) {
				hinhTamGiac();
			} else if (option == 4) {
				inHinhHoc();
			} else if (option == 5) {
				ketThuc();
			}
			myScanner.nextLine();
			System.out.println("Nhấn Enter để tiếp tục");
			System.out.println("______________________________");
			myScanner.nextLine();
		}
	}
}
