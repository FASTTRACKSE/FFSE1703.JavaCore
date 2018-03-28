package fasttrackse.edu.vn.quanlysinhvien;

import java.util.Scanner;

public class QuanLySinhVien {
		public static Scanner myScanner = new Scanner(System.in);

		public static int i, n = 4;
		public static SinhVien[] SV = new SinhVien[4];

		public static void main(String[] args) {
			SinhVien SV1= new SinhVien("Hồ Quang Minh","30/10/99",8,6);
			SinhVien SV2= new SinhVien("Lê Phước Hiếu","13/05/99",9,6);
			SinhVien SV3= new SinhVien("Nguyễn Thanh Hiếu","26/09/99",4,5);
			SinhVien SV4= new SinhVien("Hồ Việt Tú","04/04/99",6,4);
			SV[0] = SV1;
			SV[1] = SV2;
			SV[2] = SV3;
			SV[3] = SV4;
			showMyMenu();
		}

		public static void nhapDSSV() {

			for (i = 0; i < n; i++) {
				System.out.println("Nhập danh sách sinh viên : ");
				System.out.println("---------------------------");
				System.out.print("Số lượng sinh viên :");
				n = myScanner.nextInt();
				SV = new SinhVien[n];
				for (i = 0; i < n; i++) {
					SV[i] = new SinhVien();
					SV[i].Input();
				}

			}

			myScanner.nextLine();
			System.out.println("Ấn Enter để về menu chính");
			myScanner.nextLine();
		}

		public static void inDSSV() {
			

			System.out.println("Danh sách sinh viên ");
			System.out.println("--------------------------------------------------------------------");
			System.out.println("STT  Họ và tên              Ngày sinh     lp1  lp2  ĐTB  ");
			System.out.println("--------------------------------------------------------------------");
			for (i = 0; i < n; i++) {
				
				System.out.printf("%-5s%-23s%-14s%-5s%-5s%-5s\n", (i + 1), SV[i].getSVten(),SV[i].getSVngaysinh(),SV[i].getSVLP1(),SV[i].getSVLP2(),SV[i].getSVDTB());
			}
			myScanner.nextLine();
			System.out.println("Ấn Enter để về menu chính");
			myScanner.nextLine();
		}

		public static void topSV() {
			double min = SV[0].getSVDTB(), max = min;
			int x = 0, y = 0;

			for (i = 0; i < n; i++) {
				if (min > SV[i].getSVDTB()) {
					min = SV[i].getSVDTB();
					x = i;
				}
				if (max < SV[i].getSVDTB()) {
					max = SV[i].getSVDTB();
					y = i;
				}
			}
			
			System.out.println("Học sinh có kết quả học tập cao nhất là :");
			System.out.printf("%-23s%-14s%-5s%-5s%-5s\n", SV[y].getSVten(),SV[y].getSVngaysinh(),SV[y].getSVLP1(),SV[y].getSVLP2(),SV[y].getSVDTB());

			System.out.println("Học sinh có kết quả học tập thấp nhất là :");
			System.out.printf("%-23s%-14s%-5s%-5s%-5s\n", SV[x].getSVten(),SV[x].getSVngaysinh(),SV[x].getSVLP1(),SV[x].getSVLP2(),SV[x].getSVDTB());
			myScanner.nextLine();
			System.out.println("Ấn Enter để về menu chính");
			myScanner.nextLine();

		}

		public static void sapxepTBM() {
			SinhVien[] temp = new SinhVien[n];
			for (i = 0; i < n - 1; i++) {
				for (int j = i + 1; j < n; j++) {
					if (SV[i].getSVDTB() < SV[j].getSVDTB()) {
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
					System.out.printf("%-5s%-23s%-14s%-5s%-5s%-5s%-10s\n", (i + 1), SV[i].getSVten(),SV[i].getSVngaysinh(),SV[i].getSVLP1(),SV[i].getSVLP2(),SV[i].getSVDTB(),SV[i].getSVxeploai());
				}
			}

			myScanner.nextLine();
			System.out.println("Ấn Enter để về menu chính");
			myScanner.nextLine();
		}

		public static void ketThuc() {
			System.out.println("Kết thúc chương trình!!!!!");
			System.exit(0);
		}

		public static void showMyMenu() {
			while (true) {
				System.out.println(">>         MENU QUẢN LÝ SINH VIÊN       <<");
				System.out.println("+----------------------------------------+");
				System.out.println("|1. Nhập danh sách sinh viên             |");
				System.out.println("|2. In danh sách sinh viên               |");
				System.out.println("|3. Top sinh viên                        |");
				System.out.println("|4. Sắp xếp theo điểm TBM                |");
				System.out.println("|5. Kết thúc chương trình                |");
				System.out.println("+----------------------------------------+");
				System.out.println(">>            Lựa chọn của bạn?         <<");
				// .compareTo để so sánh chuỗi trong trường hợp sắp xếp theo tên
				int myOption = myScanner.nextInt();
				if (myOption == 1) {
					nhapDSSV();
				} else if (myOption == 2) {
					inDSSV();
				} else if (myOption == 3) {
					topSV();
				} else if (myOption == 4) {
					sapxepTBM();
				} else if (myOption == 5) {
					ketThuc();
				}

			}
		}
	}
