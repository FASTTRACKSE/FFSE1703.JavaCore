package fastrack.edu.vn.practices;

import java.util.Scanner;

public class QLsinhvien {
	public static sinhvien arrSv[] = new sinhvien[100];
	public static Scanner myInput = new Scanner(System.in);
	public static int a;
	public static int i;
	public static int sortDTB[];
	public static int sortName[];
	public static void main(String[] args) {
		myMenu();

	}

	public static void nhapten() {
		System.out.println("<=====NHAP SINH VIEN=====>");
		System.out.println("Nhap so luong");
		a = myInput.nextInt();
		for (int i = 0; i < a; i++) {
			arrSv[i] = new sinhvien();
			myInput.nextLine();
			System.out.println("Nhap Ho Va Ten Sinh Vien");
			arrSv[i].setSvName(myInput.nextLine());
			System.out.println("Nhap Ngay Sinh");
			arrSv[i].setSvDate(myInput.nextLine());
			System.out.println("Nhap Diem LP1");
			arrSv[i].setSvDiemlp1(myInput.nextDouble());
			System.out.println("Nhap Diem LP2");
			arrSv[i].setSvDiemlp2(myInput.nextDouble());
		}

	}

	public static void indanhsach() {
		System.out.println("   Name         " + "\t" + "Date" + "\t" + "\t" + "DiemLP1" + "\t" + "\t" + "DiemLP2" + "\t"
				+ "\t" + "DiemTB");

		for (int i = 0; i < a; i++) {
			System.out.println((i + 1) + " " + arrSv[i].getSvName() + "    " + "\t" + arrSv[i].getSvDate() + "\t"
					+ arrSv[i].getSvDiemlp1() + "\t" + "\t" + arrSv[i].getSvDiemlp2() + "\t" + "\t"
					+ arrSv[i].getSvDiemtb());
		}
	}

	public static void topsinhvien() {
		double max = arrSv[0].getSvDiemtb(), min = arrSv[0].getSvDiemtb();
		int maxvt = 0, minvt = 0;

		for (int i = 0; i < a; i++) {
			if (max < arrSv[i].getSvDiemtb()) {
				max = arrSv[i].getSvDiemtb();
				maxvt = i;
			}
			if (min > arrSv[i].getSvDiemtb()) {
				min = arrSv[i].getSvDiemtb();
				minvt = i;
			}

		}
		System.out.println("Sinh vien co diem cao nhat la: " + arrSv[maxvt].getSvName() + "  Diem Trung Binh La: " + max);
		System.out.println("Sinh vien co diem thap nhat la: " + arrSv[minvt].getSvName() + "  Diem Trung Binh La: " + min);
	}

	public static void sapxepdiemtb() {
		System.out.println("DANH SACH THU TU DIEM TB ");
		sortDTB = new int [a];
		for (int i = 0;i<a;i++) {
			sortDTB[i]=i;
		}
		for (int i = 0; i < a - 1;i++) {
			for(int j = i+1;j<a;j++) {
				if (arrSv[sortDTB[i]].getSvDiemtb() < arrSv[sortDTB[j]].getSvDiemtb()) {
					int temp = sortDTB[j];
					sortDTB[j] = sortDTB[i];
					sortDTB[i] = temp;
				}
			}
		}
		for (int i=0;i<a;i++) {
			System.out.println("Ten Sinh Vien: "+arrSv[sortDTB[i]].getSvName() +"Diem TB: " +arrSv[sortDTB[i]].getSvDiemtb());
		}
		
	}

	public static void sapxepten() {
		System.out.println("DANH SACH THU TU TEN SINH VIEN ");
		sortName = new int [a];
		for (int i = 0;i<a;i++) {
			sortName[i]=i;
		}
		for (int i = 0; i < a - 1;i++) {
			for(int j = i+1;j<a;j++) {
				if ((arrSv[sortName[i]].getSvName()).compareTo(arrSv[sortName[j]].getSvName()) > 0) {
					int temp = sortName[i];
					sortName[i] = sortName[j];
					sortName[j] = temp;
				}
			}
		}
		for (int i=0;i<a;i++) {
			System.out.println("Ten Sinh Vien: "+arrSv[sortName[i]].getSvName() +"Diem TB: " +arrSv[sortName[i]].getSvDiemtb());
		}
	}

	public static void ketthuc() {
		System.exit(0);
	}

	public static void myMenu() {
		while (true) {
			System.out.println("<======LUA CHON CHUC NANG======>");
			System.out.println("|| 1.NHAP TEN SINH VIEN        ||");
			System.out.println("|| 2.DANH SACH SINH VIEN       ||");
			System.out.println("|| 3.DANH SACH SV CAO DIEM     ||");
			System.out.println("|| 4.DANH SACH THU TU DIEM TB  ||");
			System.out.println("|| 5.DANH SACH THU TU SINH VIEN||");
			System.out.println("|| 6.KET THUC CHUONG TRINH     ||");
			System.out.println("<===============================>");
			System.out.println("      LUA CHON CUA BAN        ");
			int option = myInput.nextInt();
			if (option == 1) {
				nhapten();
			} else if (option == 2) {
				indanhsach();
			} else if (option == 3) {
				topsinhvien();
			} else if (option == 4) {
				sapxepdiemtb();
			} else if (option == 5) {
				sapxepten();
			} else if (option == 6) {
				ketthuc();
			}
		}
	}
}