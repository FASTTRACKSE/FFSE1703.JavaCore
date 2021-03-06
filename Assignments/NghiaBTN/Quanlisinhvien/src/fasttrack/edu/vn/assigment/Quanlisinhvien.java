package fasttrack.edu.vn.assigment;
import java.util.Scanner;
public class Quanlisinhvien {
	// tên,ngày sinh, điểm lp1,2,TBM

		public static Scanner myScanner = new Scanner(System.in);

		public static int i, n = 4;
		public static String[] ten_SV = {"Bùi Thế Nghĩa","Nguyễn Văn A","Trần Hoàng B","Hồ Quốc Huy"};
		public static String[] ngay_Sinh = {"01/01/99","02/02/99","03/03/99","04/04/99"};
		public static double[] diem_lp1 = {3.0,8.0,5.0,6.0};
		public static double[] diem_lp2 = {1.0,8.0,5.0,2.0};
		public static double[] diem_tbm;
		public static double[] sx_diem;

		public static void main(String[] args) {
			showMyMenu();
		}

		public static void nhapDSSV() {
			System.out.println("Nhập danh sách sinh viên : ");
			System.out.println("---------------------------");
			System.out.print("Số lượng sinh viên :");
			n = myScanner.nextInt();
			ten_SV = new String[n];
			ngay_Sinh = new String[n];
			diem_lp1 = new double[n];
			diem_lp2 = new double[n];
			
			for (i = 0; i < n; i++) {
				myScanner.nextLine();

				System.out.print("Nhập tên Sinh Viên thứ " + (i + 1) + " :");
				ten_SV[i] = myScanner.nextLine();

				System.out.print("Nhập ngày sinh của Sinh Viên thứ " + (i + 1) + " :");
				ngay_Sinh[i] = myScanner.nextLine();

				System.out.print("Nhập điểm môn LP1 " + " :");
				diem_lp1[i] = myScanner.nextDouble();

				System.out.print("Nhập điểm môn LP2 " + " :");
				diem_lp2[i] = myScanner.nextDouble();

				
			}
			myScanner.nextLine();
			System.out.println("Ấn Enter để về menu chính");
			myScanner.nextLine();
		}

		public static void inDSSV() {
			diem_tbm = new double[n];
			
			System.out.println("Danh sách sinh viên ");
			System.out.println("--------------------------------------------------------------------");
			System.out.println(" STT \t Họ và tên \t Ngày sinh \t lp1 \t lp2 \t ĐTB");
			System.out.println("--------------------------------------------------------------------");
			for (i = 0; i < n; i++) {
				diem_tbm[i] = ((diem_lp1[i] + diem_lp2[i]) / 2);
				System.out.println((i + 1) + " \t " + ten_SV[i] + " \t " + ngay_Sinh[i] + " \t " + diem_lp1[i] + " \t "
						+ diem_lp2[i] + " \t " + diem_tbm[i]);
			}
			myScanner.nextLine();
			System.out.println("Ấn Enter để về menu chính");
			myScanner.nextLine();
		}

		public static void topSV() {
			double min = diem_tbm[0], max = diem_tbm[0];
			int x = 0, y = 0;

			for (i = 0; i < n; i++) {
				if (min > diem_tbm[i]) {
					min = diem_tbm[i];
					x = i;
				}
				if (max < diem_tbm[i]) {
					max = diem_tbm[i];
					y = i;
				}
			}
			System.out.println("Học sinh có kết quả học tập cao nhất là :");
			System.out.println((y + 1) + " \t " + ten_SV[y] + " \t " + ngay_Sinh[y] + " \t " + diem_lp1[y] + " \t "
					+ diem_lp2[y] + " \t " + diem_tbm[y]);

			System.out.println("Học sinh có kết quả học tập thấp nhất là :");
			System.out.println((x + 1) + " \t " + ten_SV[x] + " \t " + ngay_Sinh[x] + " \t " + diem_lp1[x] + " \t "
					+ diem_lp2[x] + " \t " + diem_tbm[x]);

			myScanner.nextLine();
			System.out.println("Ấn Enter để về menu chính");
			myScanner.nextLine();

		}

		public static void sapxepTBM() {
			sx_diem = new double[n];
			for (i = 0; i < n; i++) {
				sx_diem[i] = diem_tbm[i];
			}
			double temp = sx_diem[0];
			for (i = 0; i < n - 1; i++) {
				for (int j = i + 1; j < n; j++) {
					if (sx_diem[i] < sx_diem[j]) {
						temp = sx_diem[j];
						sx_diem[j] = sx_diem[i];
						sx_diem[i] = temp;
					}
				}
			}
			int[] vitri = new int[n];
			for (i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (sx_diem[i] == diem_tbm[j]) {
						vitri[i] = j;
					}
				}
			}
			for (i = 0; i < n; i++) {
				System.out.println("Danh sách sinh viên đã được sắp xếp theo điểm trung bình ");
				System.out.println("--------------------------------------------------------------------");
				System.out.println(" STT \t Họ và tên \t Ngày sinh \t lp1 \t lp2 \t ĐTB");
				System.out.println("--------------------------------------------------------------------");
				for (i = 0; i < n; i++) {
					System.out.println((i + 1) + " \t " + ten_SV[vitri[i]] + " \t " + ngay_Sinh[vitri[i]] + " \t " + diem_lp1[vitri[i]] + " \t "
							+ diem_lp2[vitri[i]] + " \t " + diem_tbm[vitri[i]]);
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
				System.out.println("         MENU QUẢN LÝ SINH VIÊN       ");
				System.out.println("----------------------------------------");
				System.out.println("1. Nhập danh sách sinh viên             ");
				System.out.println("2. In danh sách sinh viên               ");
				System.out.println("3. Top sinh viên                        ");
				System.out.println("4. Sắp xếp theo điểm TBM                ");
				System.out.println("5. Kết thúc chương trình                ");
				System.out.println("----------------------------------------");
				System.out.println("            Lựa chọn của bạn?         ");

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