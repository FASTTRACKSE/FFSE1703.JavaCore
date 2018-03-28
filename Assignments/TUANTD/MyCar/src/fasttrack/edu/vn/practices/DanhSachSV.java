package fasttrack.edu.vn.practices;

import java.util.Scanner;

public class DanhSachSV {
	public static Scanner input = new Scanner(System.in);
	public static QLSinhViên[] sv = new QLSinhViên[200];
	public static int tongsosv = 0, z = 0;
	public static String action;

	public static void main(String[] args) {
		myMenu();
	}

	// nhập số sinh viên
	public static void nhapsv() {
		System.out.println("THÊM SINH VIÊN VÀO DANH SÁCH");
		System.out.println("============================");
		System.out.println("Bạn muốn nhập bao nhiêu sinh viên ?");
		int a = input.nextInt();
		tongsosv = a + tongsosv;
		for (int z = 0; z < tongsosv; z++) {
			sv[z] = new QLSinhViên();
		}
		for (int z = 0; z < tongsosv; z++) {
			input.nextLine();
			System.out.println("Nhập Tên Sinh Viên Thứ  " + (z + 1) + " : ");
			String namesv = input.nextLine();
			sv[z].setNamesv(namesv);
			System.out.println("Nhập Ngày Sinh Cho Sinh Viên Thứ " + (z + 1) + " : ");
			String ngaysinhsv = input.nextLine();
			sv[z].setNgaysinhsv(ngaysinhsv);
			System.out.println("Nhập Điểm LP#1 Cho Sinh Viên Thứ " + (z + 1) + " : ");
			float LP1 = input.nextFloat();
			sv[z].setLP1(LP1);
			System.out.println("Nhập Điểm LP#2 Cho Sinh Viên Thứ " + (z + 1) + " : ");
			float LP2 = input.nextFloat();
			sv[z].setLP2(LP2);
			System.out.println("Nhập Điểm LP#3 Cho Sinh Viên Thứ " + (z + 1) + " : ");
			float LP3 = input.nextFloat();
			sv[z].setLP3(LP3);
		}
		action = input.nextLine();
		System.out.println("=====================================");
		System.out.println("-------Nhập ENTER để tiếp tục------");
	}

	// hiển thị sinh viên
	public static void show(QLSinhViên sv) {
		System.out.print(sv.getNamesv() + "\t" + sv.getNgaysinhsv() + "\t" + "\t" + sv.getLP1() + "\t" + "\t"
				+ sv.getLP2() + "\t" + "\t" + sv.getLP3() + "\t" + "\t" + sv.getDiemTB() + "\t" + sv.getXepLoai() + "\n");

	}

	public static void xuatsv() {
		System.out.println("-----------DANH SÁCH TẤT CẢ SINH VIÊN-------------");
		System.out.println("==================================================");
		System.out.println("STT\tTên\tNgày Sinh\tĐiểm LP#1\tĐiểm LP#2\tĐiểm LP#3\tĐiểm TB\tXếp Loại");
		System.out.println("--------------------------------------------------");
		for (int i = 0; i < tongsosv; i++) {
			System.out.print((i + 1) + "\t");
			show(sv[i]);
		}
		action = input.nextLine();
		System.out.println("=====================================");
		System.out.println("-------Nhập ENTER để tiếp tục------");
	}

	// sinh viên có điểm cao nhất
	public static void svcaonhat() {
		System.out.println("-----------SINH VIÊN CÓ ĐIỂM CAO NHẤT-------------");
		System.out.println("==================================================");
		float max = 0;
		int stt;
		for (int i = 0; i < tongsosv; i++) {
			if (max < sv[i].getDiemTB()) {
				max = sv[i].getDiemTB();
				stt = i;
			}
		}
		for (int i = 0; i < tongsosv; i++) {
			if (max <= sv[i].getDiemTB()) {
				System.out.println("Là sinh viên:" + "==>>> " + sv[i].getNamesv() + " <<<==" + "\n"
						+ "Có điểm trung bình " + max + "\n" + "Có số thứ tự là " + (i + 1));
			}
		}
		action = input.nextLine();
		System.out.println("=====================================");
		System.out.println("-------Nhập ENTER để tiếp tục------");
	}

	// sinh viên có điểm thấp nhất
	public static void svthapnhat() {
		System.out.println("-----------SINH VIÊN CÓ ĐIỂM THẤP NHẤT-------------");
		System.out.println("==================================================");
		float min = 10;
		int stt;
		for (int i = 0; i < tongsosv; i++) {
			if (min > sv[i].getDiemTB()) {
				min = sv[i].getDiemTB();
				stt = i;
			}
		}
		for (int i = 0; i < tongsosv; i++) {
			if (min >= sv[i].getDiemTB()) {
				System.out.println("Là sinh viên:" + "==>>> " + sv[i].getNamesv() + " <<<==" + "\n"
						+ "Có điểm trung bình " + min + "\n" + "Có số thứ tự là " + (i + 1));
			}
		}
		action = input.nextLine();
		System.out.println("=====================================");
		System.out.println("-------Nhập ENTER để tiếp tục------");
	}

	// sắp Xếp Điểm Trung Bình
	public static void sapxepĐTB() {
		QLSinhViên[] temp = new QLSinhViên[tongsosv];
		float tempt;
		for (int i = 0; i < tongsosv - 1; i++) {
			for (int j = i + 1; j < tongsosv; j++) {
				if (sv[i].getDiemTB() < sv[j].getDiemTB()) {
					;
					temp[i] = sv[i];
					sv[i] = sv[j];
					sv[j] = temp[i];
				}
			}
		}
		for (int i = 0; i < tongsosv; i++) {
			System.out.print((i + 1) + "\t");
			show(sv[i]);
		}
		action = input.nextLine();
		System.out.println("=====================================");
		System.out.println("-------Nhập ENTER để tiếp tục------");
	}

	public static void ketthuc() {
		System.out.println("=======Tkank you!======");
		System.exit(0);
	}

	// phần Menu
	public static void myMenu() {
		while (true) {
			System.out.println("|<-----LỰA CHỌN CHỨC NĂNG------>|");
			System.out.println("| 1. Nhập Danh Sách Sinh Viên   |");
			System.out.println("| 2. Hiển Thị Thông Tin SV      |");
			System.out.println("| 3. Sắp Xếp Điểm Cao -> Thấp   |");
			System.out.println("| 4. Sắp Xếp Điểm Thấp -> Cao   |");
			System.out.println("| 5. Sắp Xếp Theo Điểm TB       |");
			System.out.println("|=============!!!!==============|");
			System.out.println("| 6. Kết Thúc                   |");
			System.out.println("|<============????=============>|");
			int aye = input.nextInt();
			if (aye == 1) {
				nhapsv();
			} else if (aye == 2) {
				xuatsv();
			} else if (aye == 3) {
				svcaonhat();
			} else if (aye == 4) {
				svthapnhat();
			} else if (aye == 5) {
				sapxepĐTB();
			} else {
				ketthuc();
			}
		}
	}
}
