package MyMenu;

import java.util.Scanner;
import java.util.Collections;
public class DSSV {
	public static Scanner myScanner = new Scanner(System.in);
	public static String[] arrsv;
	public static double[] arrLP1;
	public static double[] arrLP2;
	public static double[] arrLP3;
	public static double[] arrĐTB;
	public static void main(String[] args) {
		myMenu();
	}

	public static void nhapsosv() {
		System.out.println("Them sinh vien");
		int size;
		System.out.print("Nhap so sinh vien muon them : ");
		size = myScanner.nextInt();//n
		arrsv  = new String[size];
		arrLP1 = new double[size];
		arrLP2 = new double[size];
		arrLP3 = new double[size];
		arrĐTB = new double[size];
		for (int i = 0; i < size; i++) {
			myScanner.nextLine();
			System.out.println("Nhap ten sinh vien thu " + (i + 1) + " :");
			arrsv[i] = myScanner.nextLine();
			System.out.println("Nhap diem LP1 cua sinh vien thu " + (i + 1) + " :");
			arrLP1[i] = myScanner.nextDouble();
			System.out.println("Nhap diem LP2 cua sinh vien thu  " + (i + 1) + " :");
			arrLP2[i] = myScanner.nextDouble();
			System.out.println("Nhap diem LP3 cua sinh vien thu  " + (i + 1) + " :");
			arrLP3[i] = myScanner.nextDouble();
			arrĐTB[i] = (arrLP1[i] + arrLP2[i] + arrLP3[i]) / 3;
			System.out.println("Nhan ENTER de tiep tuc");
			System.out.println("<--------------------->");
			myScanner.nextLine();
		}
	}

	public static void InDSSV() {
		System.out.println("<============Danh sach sinh vien==============>");
		System.out.println("<---     Ten SV     |     LP#1     |     LP#2     |     LP#3     |     ĐTB     ----->");
		for (int i = 0; i < arrsv.length; i++) {
			System.out.println("|      " + arrsv[i] + "     |      " + arrLP1[i] + "     |      " + arrLP2[i] + "      |      " + arrLP3[i]+ "     |      " + arrĐTB[i]);
		}
		System.out.println("<================================>");
		System.out.println("Nhan ENTER de tiep tuc");
		myScanner.nextLine();
	}

	public static void sinhviencaonhat() {
		System.out.println("<------Danh sach sinh vien cao nhat------>");
		Double max = arrĐTB[0];
		int vtmax = 0;
		for (int i = 0; i < arrsv.length; i++) {
			if (max < arrĐTB[i]) {
				max = arrĐTB[i];
				vtmax = i;
			}
		}
		System.out.println("<---------Sinh vien co DTB cao nhat------->");
		System.out.println("<-------Ten sinh vien          ||            Điem trung binh------->");
		System.out.println("|      " + arrsv[vtmax] + "                          " + max);
		System.out.println("Nhan ENTER de ve menu chinh");
		myScanner.nextLine();
		System.out.println("<================================>");
		myScanner.nextLine();
	}
	
	public static void sinhvienthapnhat() {
		System.out.println("<------Danh sach sinh vien thap ------>");
		Double min = arrĐTB[0];
		int vtmin = 0;
		for (int i = 0; i < arrsv.length; i++) {
			if (min > arrĐTB[i]) {
				min = arrĐTB[i];
				vtmin = i;
			}
		}
		System.out.println("+-------------Sinh vien co DTB thap nhat-------------+");
		System.out.println("+-------Tên sinh viên          ||            Điểm trung bình-------+");
		System.out.println("|      " + arrsv[vtmin] + "                          " + min);
		System.out.println("Nhan ENTERr de ve menu chinh");
		myScanner.nextLine();
		System.out.println("<================================>");
		myScanner.nextLine();
	}
	//sắp xếp
		public static void sapxepTBM() {
			double temp;
			String temps;
			
			for(int i = 0; i < arrsv.length; i++ ) {
				for (int j =i + 1;j<  arrsv.length; j++) {
					if(arrĐTB[i] < arrĐTB[j]) {
						temp = arrĐTB[i];
						arrĐTB[i] = arrĐTB[j];
						arrĐTB[j] = temp;
					}	
					if(arrLP1[i] < arrLP1[j]) {
						temp = arrLP1[i];
						arrLP1[i] = arrLP1[j];
						arrLP1[j] = temp;
					}	
					if(arrLP2[i] < arrLP2[j]) {
						temp = arrLP2[i];
						arrLP2[i] = arrLP2[j];
						arrLP2[j] = temp;
					}	
					if(arrLP3[i] < arrLP3[j]) {
						temp = arrLP3[i];
						arrLP3[i] = arrLP3[j];
						arrLP3[j] = temp;
					}	
					
				}
			}
			System.out.println("<============Sắp Xếp Điểm TBM==============>");
			System.out.println("<---     Tên SV     |     LP#1     |     LP#2     |     LP#3     |     ĐTB     ----->");
			for (int i = 0; i < arrsv.length; i++) {
				System.out.println("|      " + arrsv[i] + "     |      " + arrLP1[i] + "     |      " + arrLP2[i] + "      |      " + arrLP3[i]+ "     |      " + arrĐTB[i]);
			}
			System.out.println("<================================>");
			System.out.println("Nhấn Enter để về Menu Chính");
			myScanner.nextLine();
		}

	public static void ketThuc() {
		System.out.println("Thank You!");
		System.exit(0);
	}
	
	public static void myMenu() {
		while (true) {
			System.out.println("+------LUA CHON CHUC NANG-------+");
			System.out.println("| 1. Thêm Sinh Viên             |");
			System.out.println("| 2. Danh Sách Sinh Viên        |");
			System.out.println("| 3. Danh Sách ĐTB Cao Nhất     |");
			System.out.println("| 4. Danh Sách ĐTB Thấp Nhất    |");
			System.out.println("| 5. Sap Xep                    |");
			System.out.println("| 6. Ket thuc                   |");
			System.out.println("+-------LUA CHON CUA BAN--------+");
			
			int option = myScanner.nextInt();
			if (option == 1) {
				nhapsosv();
			} else if (option == 2) {
				InDSSV();
			} else if (option == 3) {
				sinhviencaonhat();
			} else if (option == 4) {
				sinhvienthapnhat();
			} else if (option == 5) {
				sapxepTBM();
			}else if (option == 6) {
				ketThuc();
			}
		}
	}
}