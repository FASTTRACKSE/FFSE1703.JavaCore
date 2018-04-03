package fasttrack.edu.vn;

import java.util.Scanner;

public class Main {
	public static SinhVien[] SV = new SinhVien[100];
	public static Scanner input = new Scanner(System.in);
	public static int i, n = 4;

	public static void nhapDSSV() {

	
			System.out.println("Nhập danh sách sinh viên : ");
			System.out.println("---------------------------");
			System.out.print("Số lượng sinh viên :");
			n = input.nextInt();
			SV = new SinhVien[n];
			for (i = 0; i < n; i++) {
				SV[i] = new SinhVien();
				SV[i].Input();
			}
			
		

		
		System.out.println("Ấn Enter để về menu chính");
		input.nextLine();
		main(null);
		
	}

	public static void sxName(SinhVien hoTen) {
		int n = input.nextInt();
		SinhVien s[] = new SinhVien[n];
		SinhVien temp = null;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if ((s[i].getHoTen()).compareTo(s[j].getHoTen()) > 0) {
					temp = s[i];
					s[i] = s[j];
					s[j] = temp;
				}
			}
		}
	}

	public static void inDSSV() {

		System.out.println("Danh sách sinh viên ");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("STT  Họ và tên              Ngày sinh     lp1  lp2  ĐTB  ");
		System.out.println("--------------------------------------------------------------------");
		for (i = 0; i < n; i++) {

			System.out.printf("%-5s%-23s%-14s%-5s%-5s%-5s\n", (i + 1), SV[i].getHoTen(), SV[i].getNgaySinh(),
					SV[i].getLp1(), SV[i].getLp2(), SV[i].getdTB());
		}
		input.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		main(null);
	}

	public static void sapxepTBM() {
		SinhVien[] temp = new SinhVien[n];
		for (i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (SV[i].getdTB() < SV[j].getdTB()) {
					temp[i] = SV[j];
					SV[j] = SV[i];
					SV[i] = temp[i];
				}
			}
		}
		for (i = 0; i < n; i++) {
			System.out.println("Danh sách sinh viên đã được sắp xếp theo điểm trung bình ");
			System.out.println("--------------------------------------------------------------------");
			System.out.println("STT  Họ và tên              Ngày sinh     lp1  lp2  ĐTB  Xếp Loại  ");
			System.out.println("--------------------------------------------------------------------");
			for (i = 0; i < n; i++) {
				System.out.printf("%-5s%-23s%-14s%-5s%-5s%-5s%-10s\n", (i + 1), SV[i].getHoTen(), SV[i].getNgaySinh(),
						SV[i].getLp1(), SV[i].getLp2(), SV[i].getdTB(), SV[i].getXepLoai());
			}
		}

		input.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		main(null);
	}
	public static void sapxepTen() {
		SinhVien[] temp = new SinhVien[n];
		for (i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (SV[i].getHoTen().compareTo(SV[j].getNgaySinh()) > 0) {
					temp[i] = SV[j];
					SV[j] = SV[i];
					SV[i] = temp[i];
				}
			}
		}

		for (i = 0; i < n; i++) {
			System.out.println("Danh sách sinh viên đã được sắp xếp theo điểm trung bình ");
			System.out.println("--------------------------------------------------------------------");
			System.out.println("STT  Họ và tên              Ngày sinh     lp1  lp2  ĐTB  Xếp Loại  ");
			System.out.println("--------------------------------------------------------------------");
			for (i = 0; i < n; i++) {
				System.out.printf("%-5s%-23s%-14s%-5s%-5s%-5s%-10s\n", (i + 1), SV[i].getHoTen(), SV[i].getNgaySinh(),
						SV[i].getLp1(), SV[i].getLp2(), SV[i].getdTB(), SV[i].getXepLoai());
			}
		}

		input.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		main(null);
	}
	public static void ketThuc() {
		System.out.println("Kết thúc chương trình!!!!!");
		System.exit(0);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(">>              MENU CUA TOI           <<");
		System.out.println("+----------------------------------------+");
		System.out.println("|1. Nhap danh sach sinh vien                 |");
		System.out.println("|2. in danh sach sinh vien                 |");
		System.out.println("|3. Sap xep diem TB tu cao den thap |");
		System.out.println("|4. sap xep ten abc  |");
		System.out.println("|5. ket thuc chuong trinh                  |");
		System.out.println("+----------------------------------------+");
		System.out.println(">>            chọn chức năng.         <<");
		int myOption = input.nextInt();
		
		if (myOption == 1) {
			nhapDSSV();
		}  else if (myOption == 2) {
			inDSSV();
		} else if (myOption == 3) {
			sapxepTBM();
		}else if (myOption == 4) {
			sapxepTen();
		} else if (myOption == 5) {
			ketThuc();
	}
}
}
