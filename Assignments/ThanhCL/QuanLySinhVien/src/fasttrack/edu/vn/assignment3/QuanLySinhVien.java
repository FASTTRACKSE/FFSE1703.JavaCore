package fasttrack.edu.vn.assignment3;

import java.util.Scanner;

public class QuanLySinhVien {
	public static Scanner myScanner = new Scanner(System.in);
	public static String[] arrSinhVien = {"Cao Le Thanh","Nguyen Ngoc Binh","Le The Thang","Doan Anh Chuan","Chu Thong Nhat"};
	public static int[] arrSortByName;
	public static int[] arrSortByDTB;
	public static Double[] arrLP1 = {8.0,7.0,9.0,6.0,5.0};
	public static Double[] arrLP2= {7.0,9.0,9.0,5.0,4.0};
	public static Double[] arrDTB;
	public static int tongSinhVien = 5;

	public static void main(String[] args) {
		showMenu();
	}

	public static void showMenu() {
		while (true) {
			System.out.println("\nLUA CHON CHUC NANG");
			System.out.println("1. Nhap danh sach sinh vien");
			System.out.println("2. In danh sach sinh vien");
			System.out.println("7. In danh sach sinh vien");
			System.out.println("3. Sinh vien theo TEN");
			System.out.println("4. Sinh vien theo DTB");
			System.out.println("5. Sinh vien tieu bieu");
			System.out.println("6. Ket thuc chuong trinh");
			System.out.print("Lua chon cua ban: ");

			int myOption = myScanner.nextInt();
			if (myOption == 1) {
				nhapThongTinSinhVien();
			} else if (myOption == 2) {
				inDSSinhVien();
			} else if (myOption == 7) {
				inDSSinhVien2();
			} else if (myOption == 3) {
				inDSSinhVienTheoTen();
			} else if (myOption == 4) {
				inDSSinhVienTheoDTB();
			} else if (myOption == 5) {
				thongkeTopSinhVien();
			} else if (myOption == 6) {
				ketThuc();
			}
			
			backToMainMenu();
		}
	}

	public static void backToMainMenu() {
		myScanner.nextLine();
		System.out.println("An Enter de ve menu chinh");
		myScanner.nextLine();
	}

	public static void nhapThongTinSinhVien() {
		System.out.println("Nhap danh sach sinh vien");
		System.out.println("------------------------");
		System.out.println("Tong so sinh vien: ");
		tongSinhVien = myScanner.nextInt();

		arrSinhVien = new String[tongSinhVien];
		arrLP1 = new Double[tongSinhVien];
		arrLP2 = new Double[tongSinhVien];
		arrDTB = new Double[tongSinhVien];

		for (int i = 0; i < tongSinhVien; i++) {
			myScanner.nextLine();

			System.out.println("Nhap ten sinh vien thu " + (i + 1) + ": ");
			arrSinhVien[i] = myScanner.nextLine();

			System.out.println("Nhap diem LP1 sinh vien thu " + (i + 1) + ": ");
			arrLP1[i] = myScanner.nextDouble();

			System.out.println("Nhap diem LP2 sinh vien thu " + (i + 1) + ": ");
			arrLP2[i] = myScanner.nextDouble();

			arrDTB[i] = (arrLP1[i] + arrLP2[i]) / 2;
		}
	}

	public static void inDSSinhVien() {
		tinhDTB();
		
		System.out.println("Danh sach sinh vien");
		System.out.println("--------------------------------------------");
		System.out.printf(" STT Ho Va Ten                LP1  LP2  DTB  \n");
		System.out.println("--------------------------------------------");
		for (int i = 0; i < tongSinhVien; i++) {
			System.out.printf(" %-4s%-25s%-5s%-5s%-5s\n",(i + 1),arrSinhVien[i],arrLP1[i],arrLP2[i],arrDTB[i]);
		}
	}

	public static void inDSSinhVien2() {
		tinhDTB();
		sortDTB2();
		
		System.out.println("Danh sach sinh vien");
		System.out.println("--------------------------------------------");
		System.out.printf(" STT Ho Va Ten                LP1  LP2  DTB  \n");
		System.out.println("--------------------------------------------");
		for (int i = 0; i < tongSinhVien; i++) {
			System.out.printf(" %-4s%-25s%-5s%-5s%-5s\n",(i + 1),arrSinhVien[i],arrLP1[i],arrLP2[i],arrDTB[i]);
		}
	}

	public static void tinhDTB() {
		arrDTB = new Double[tongSinhVien];
		
		for (int i = 0; i < tongSinhVien; i++) {
			arrDTB[i] = (arrLP1[i] + arrLP2[i])/2;
		}
	}

	public static void inDSSinhVienTheoTen() {
		tinhDTB();
		sortHoTen();

		System.out.println("Danh sach sinh vien");
		System.out.println("--------------------------------------------");
		System.out.printf(" STT Ho Va Ten                LP1  LP2  DTB  \n");
		System.out.println("--------------------------------------------");
		for (int i = 0; i < tongSinhVien; i++) {
			System.out.printf(" %-4s%-25s%-5s%-5s%-5s\n",(i + 1), arrSinhVien[arrSortByName[i]], arrLP1[arrSortByName[i]], arrLP2[arrSortByName[i]], arrDTB[arrSortByName[i]]);
		}
	}

	public static void inDSSinhVienTheoDTB() {
		tinhDTB();
		sortDTB();

		System.out.println("Danh sach sinh vien");
		System.out.println("--------------------------------------------");
		System.out.printf(" STT Ho Va Ten                LP1  LP2  DTB  \n");
		System.out.println("--------------------------------------------");
		for (int i = 0; i < tongSinhVien; i++) {
			System.out.printf(" %-4s%-25s%-5s%-5s%-5s\n",(i + 1), arrSinhVien[arrSortByDTB[i]], arrLP1[arrSortByDTB[i]], arrLP2[arrSortByDTB[i]], arrDTB[arrSortByDTB[i]]);
		}
	}

	public static void sortDTB() {
		int temp;
		arrSortByDTB = new int[tongSinhVien];

		// Khởi tạo mảng số thứ tự sinh viên
		for (int i = 0; i < tongSinhVien; i++) {
			arrSortByDTB[i] = i;
		}

		// Sắp xếp lại thứ tự theo DTB
		for (int i = 0; i < tongSinhVien - 1; i++) {
			for (int j = i + 1; j < tongSinhVien; j++) {
				if (arrDTB[arrSortByDTB[i]] < arrDTB[arrSortByDTB[j]]) {
					temp = arrSortByDTB[j];
					arrSortByDTB[j] = arrSortByDTB[i];
					arrSortByDTB[i] = temp;
				}
			}
		}
	}
	
	public static void sortDTB2() {
		double temp;
		String sTemp;
		
		for (int i = 0; i < tongSinhVien - 1; i++) {
			for (int j = i + 1; j < tongSinhVien; j++) {
				if (arrDTB[i] < arrDTB[j]) {
					temp = arrDTB[i];
					arrDTB[i] = arrDTB[j];
					arrDTB[j] = temp;
					
					sTemp = arrSinhVien[i];
					arrSinhVien[i] = arrSinhVien[j];
					arrSinhVien[j] = sTemp;
					
					temp = arrLP1[i];
					arrLP1[i] = arrLP1[j];
					arrLP1[j] = temp;
					
					temp = arrLP2[i];
					arrLP2[i] = arrLP2[j];
					arrLP2[j] = temp;
				}
			}
		}
	}

	public static void sortHoTen() {
		int temp;
		arrSortByName = new int[tongSinhVien];
		
		// Khởi tạo mảng số thứ tự sinh viên
		for (int i = 0; i < tongSinhVien; i++) {
			arrSortByName[i] = i;
		}

		// Sắp xếp lại thứ tự theo DTB
		for (int i = 0; i < tongSinhVien - 1; i++) {
			for (int j = i + 1; j < tongSinhVien; j++) {
				if (arrSinhVien[arrSortByName[i]].compareTo(arrSinhVien[arrSortByName[j]]) > 0) {
					temp = arrSortByName[j];
					arrSortByName[j] = arrSortByName[i];
					arrSortByName[i] = temp;
				}
			}
		}
	}

	public static void thongkeTopSinhVien() {
		double minDTB = arrDTB[0], maxDTB = minDTB;
		int minDTB_Position = 0, maxDTB_Position = 0;

		for (int i = 1; i < tongSinhVien; i++) {
			if (minDTB > arrDTB[i]) {
				minDTB = arrDTB[i];
				minDTB_Position = i;
			}

			if (maxDTB < arrDTB[i]) {
				maxDTB = arrDTB[i];
				maxDTB_Position = i;
			}
		}
		System.out.println("Danh sach sinh vien tieu bieu");
		System.out.println("-----------------------------");
		System.out.println("Cao diem CAO nhat lop: " + arrSinhVien[maxDTB_Position] + " - " + maxDTB);
		System.out.println("Cao diem THAP nhat lop: " + arrSinhVien[minDTB_Position] + " - " + minDTB);
	}

	public static void ketThuc() {
		System.out.println("Chuong trinh da ket thuc.\nCam on cac ban!!!");
		System.exit(0);
	}
}
