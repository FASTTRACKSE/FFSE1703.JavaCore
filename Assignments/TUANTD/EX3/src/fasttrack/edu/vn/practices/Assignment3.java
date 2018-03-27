package fasttrack.edu.vn.practices;

import java.util.Scanner;
import java.util.Collections;
public class Assignment3 {
	public static Scanner myScanner = new Scanner(System.in);
	public static String[] arrsv;
	public static double[] arrLP1;
	public static double[] arrLP2;
	public static double[] arrLP3;
	public static double[] arrĐTB;
	public static void main(String[] args) {
		myMenu();
	}
//nhập số sinh viên
	public static void nhapsosv() {
		System.out.println("Thêm sinh viên");
		int size;
		System.out.print("Nhập Số Sinh Viên Muốn Thêm : ");
		size = myScanner.nextInt();//n
		arrsv  = new String[size];
		arrLP1 = new double[size];
		arrLP2 = new double[size];
		arrLP3 = new double[size];
		arrĐTB = new double[size];//cấp phát
		for (int i = 0; i < size; i++) {
			myScanner.nextLine();
			System.out.println("Nhập Tên Sinh Viên Thứ " + (i + 1) + " :");
			arrsv[i] = myScanner.nextLine();
			System.out.println("Nhập Điểm LP#1 Của Sinh Viên Thứ " + (i + 1) + " :");
			arrLP1[i] = myScanner.nextDouble();
			System.out.println("Nhập Điểm LP#2 Của Sinh Viên Thứ " + (i + 1) + " :");
			arrLP2[i] = myScanner.nextDouble();
			System.out.println("Nhập Điểm LP#3 Của Sinh Viên Thứ " + (i + 1) + " :");
			arrLP3[i] = myScanner.nextDouble();
			arrĐTB[i] = (arrLP1[i] + arrLP2[i] + arrLP3[i]) / 3;
			System.out.println("Nhấn Enter để tiếp tục");
			System.out.println("<--------------------->");
			myScanner.nextLine();
		}
	}
//xuất số sinh viên
	public static void InDSSV() {
		System.out.println("<============Danh sách sinh viên==============>");
		System.out.println("<---     Tên SV     |     LP#1     |     LP#2     |     LP#3     |     ĐTB     ----->");
		for (int i = 0; i < arrsv.length; i++) {
			System.out.println("|      " + arrsv[i] + "     |      " + arrLP1[i] + "     |      " + arrLP2[i] + "      |      " + arrLP3[i]+ "     |      " + arrĐTB[i]);
		}
		System.out.println("<================================>");
		System.out.println("Nhấn Enter để về Menu Chính");
		myScanner.nextLine();
	}
//sinh viên có điểm trung bình cao nhất
	public static void sinhviencaonhat() {
		System.out.println("<------Danh sách sinh viên cao nhất------>");
		Double max = arrĐTB[0];
		int vtmax = 0;
		for (int i = 0; i < arrsv.length; i++) {
			if (max < arrĐTB[i]) {
				max = arrĐTB[i];
				vtmax = i;
			}
		}
		System.out.println("<---------Sinh viên có điểm trung bình cao nhất------->");
		System.out.println("<-------Tên sinh viên          ||            Điểm trung bình------->");
		System.out.println("|      " + arrsv[vtmax] + "                          " + max);
		System.out.println("Nhấn Enter để về Menu Chính");
		myScanner.nextLine();
		System.out.println("<================================>");
		myScanner.nextLine();
	}
//sinh viên có điểm trung bình thấp nhất	
	public static void sinhvienthapnhat() {
		System.out.println("<------Danh sách sinh viên thấp nhất------>");
		Double min = arrĐTB[0];
		int vtmin = 0;
		for (int i = 0; i < arrsv.length; i++) {
			if (min > arrĐTB[i]) {
				min = arrĐTB[i];
				vtmin = i;
			}
		}
		System.out.println("<---------Sinh viên có điểm trung bình thấp nhất------>");
		System.out.println("<-------Tên sinh viên          ||            Điểm trung bình------->");
		System.out.println("|      " + arrsv[vtmin] + "                          " + min);
		System.out.println("Nhấn Enter để về Menu Chính");
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

	
//kết thúc chương trình
	public static void ketThuc() {
		System.out.println("Thank You!");
		System.exit(0);
	}
	
//tạo menu
	public static void myMenu() {
		while (true) {
			System.out.println("|<-----LỰA CHỌN CHỨC NĂNG------>|");
			System.out.println("| 1. Thêm Sinh Viên             |");
			System.out.println("| 2. Danh Sách Sinh Viên        |");
			System.out.println("| 3. Danh Sách ĐTB Cao Nhất     |");
			System.out.println("| 4. Danh Sách ĐTB Thấp Nhất    |");
			System.out.println("| 5. Sắp Xếp                    |");
			System.out.println("|=============!!!!==============|");
			System.out.println("| 6. Kết Thúc                   |");
			System.out.println("|<============????=============>|");
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