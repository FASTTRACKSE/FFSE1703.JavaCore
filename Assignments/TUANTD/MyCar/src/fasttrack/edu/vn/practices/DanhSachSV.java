package fasttrack.edu.vn.practices;

import java.util.Scanner;
import java.util.ArrayList;

public class DanhSachSV {
	public static Scanner input = new Scanner(System.in);
	public static QLSinhViên[] sv = new QLSinhViên[200];
	public static int n = 0;
	public static String action;
	static ArrayList<QLSinhViên> arraySinhVien = new ArrayList<QLSinhViên>();

	public static void main(String[] args) {
		myMenu();
	}

	// nhập số sinh viên
	public static void NhapSV() {
		String namesv;
		String ngaysinhsv;
		float LP1;
		float LP2;
		float LP3;
		System.out.println("THÊM SINH VIÊN VÀO DANH SÁCH");
		System.out.println("============================");
		System.out.println("Bạn muốn nhập bao nhiêu sinh viên:");
		n = input.nextInt();
		for (int z = 0; z < n; z++) {
			input.nextLine();
			System.out.println("Nhập Tên Sinh Viên Thứ  " + (z + 1) + " : ");
			namesv = input.nextLine();
			System.out.println("Nhập Ngày Sinh Cho Sinh Viên Thứ " + (z + 1) + " : ");
			ngaysinhsv = input.nextLine();
			System.out.println("Nhập Điểm LP#1 Cho Sinh Viên Thứ " + (z + 1) + " : ");
			LP1 = input.nextFloat();
			System.out.println("Nhập Điểm LP#2 Cho Sinh Viên Thứ " + (z + 1) + " : ");
			LP2 = input.nextFloat();
			System.out.println("Nhập Điểm LP#3 Cho Sinh Viên Thứ " + (z + 1) + " : ");
			LP3 = input.nextFloat();
			arraySinhVien.add(new QLSinhViên(namesv, ngaysinhsv, LP1, LP2, LP3));
			QLSinhViên.setTongsv();
		}
		action = input.nextLine();
		System.out.println("=====================================");
		System.out.println("-------Nhập ENTER để tiếp tục------");
	}

	// hiển thị sinh viên
	public static void XuatSV() {
		int i = 0;
		System.out.println("-----------DANH SÁCH TẤT CẢ SINH VIÊN-------------");
		System.out.println("==================================================");
		System.out.println("STT\tTên\tNgày Sinh\tĐiểm LP#1\tĐiểm LP#2\tĐiểm LP#3\tĐiểm TB\tXếp Loại");
		System.out.println("--------------------------------------------------");
		for (QLSinhViên x : arraySinhVien) {
			System.out.print((i + 1) + "\t");
			System.out.printf("%-10s %-15s %-15s %-10s %10s %15s %-15s \n", x.getNamesv(), x.getNgaysinhsv(),
					x.getLP1(), x.getLP2(), x.getLP3(), x.getDiemTB(), x.getXepLoai());
		}
		System.out.println("số lượng sinh viên " + QLSinhViên.tongsv);
		action = input.nextLine();
		System.out.println("=====================================");
		System.out.println("-------Nhập ENTER để tiếp tục------");
	}

	// sửa
	public static void Edit() {
		System.out.println("Tên Khách Hàng Cần Sửa :");
		String namesv = input.next();
		System.out.println("Tên Khách Hàng Mới :");
		String newnamesv = input.next();
		for (QLSinhViên x : arraySinhVien) {
			if ((x.getNamesv()).equals(namesv)) {
				x.setNamesv(newnamesv);
			}
		}
	}

	// xóa
	public static void Delete() {
		System.out.println("Tên Khách Hàng Cần Xóa :");
		String namesv = input.next();
		for(int z = 0; z < arraySinhVien.size(); z++) {
			for (QLSinhViên x : arraySinhVien) {
				if ((x.getNamesv()).indexOf(namesv) > -1) {
					arraySinhVien.remove(x);
					z--;
					QLSinhViên.Tongsv();
					break;
				}
			}
		}
	}

	// tìm kiếm
	public static void View() {
		try {
			System.out.println("Tên Sinh Viên Cần Tìm :");
			String namesv = input.next();
			for (QLSinhViên x : arraySinhVien) {
				if ((x.getNamesv()).equals(namesv)) {
					arraySinhVien.contains(namesv);
					System.out.println("Tên Sinh viên Đó Là :" + namesv);
					System.out.println("<---------------------------------->");
				} else {
					throw new Exception();
				}
			}
		} catch (Exception e2) {
			System.out.println("Tên Sinh Viên Nhập Vào Không Có!  ");
		}
	}

	// sinh viên có điểm cao nhất
	public static void SVCaoNhat() {
		System.out.println("-----------SINH VIÊN CÓ ĐIỂM CAO NHẤT-------------");
		System.out.println("==================================================");
		float max = 0;
		int stt;
		for (int i = 0; i < n; i++) {
			if (max < sv[i].getDiemTB()) {
				max = sv[i].getDiemTB();
				stt = i;
			}
		}
		for (int i = 0; i < n; i++) {
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
	public static void SVThapNhat() {
		System.out.println("-----------SINH VIÊN CÓ ĐIỂM THẤP NHẤT-------------");
		System.out.println("==================================================");
		float min = 0;
		int stt;
		for (int i = 0; i < n; i++) {
			if (min > sv[i].getDiemTB()) {
				min = sv[i].getDiemTB();
				stt = i;
			}
		}
		for (int i = 0; i < n; i++) {
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
	public static void SapXepĐTB() {
		QLSinhViên[] temp = new QLSinhViên[n];
		float tempt;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j <n; j++) {
				if (sv[i].getDiemTB() < sv[j].getDiemTB()) {
					;
					temp[i] = sv[i];
					sv[i] = sv[j];
					sv[j] = temp[i];
				}
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.print((i + 1) + "\t");
			XuatSV();
		}
		action = input.nextLine();
		System.out.println("=====================================");
		System.out.println("-------Nhập ENTER để tiếp tục------");
	}

	// sắp xếp theo tên sinh viên
	public static void SapXepTen() {
		QLSinhViên[] temp = new QLSinhViên[n];

		for (int i = 0; i <n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (sv[i].getNamesv().compareTo(sv[j].getNamesv()) > 0) {
					temp[i] = sv[j];
					sv[j] = sv[i];
					sv[i] = temp[i];
				}
			}
		}
		System.out.println("Danh sách sinh viên đã được sắp xếp theo Tên ");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("STT  Họ và tên              Ngày sinh     lp1  lp2  ĐTB  Xếp Loại  ");
		System.out.println("--------------------------------------------------------------------");
		for (int i = 0; i < n; i++) {
			System.out.print((i + 1) + "\t");
			XuatSV();
		}
		action = input.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		action = input.nextLine();
	}

	// kết thúc
	public static void KetThuc() {
		System.out.println("=======Tkank you!======");
		System.exit(0);
	}

	// phần Menu
	public static void myMenu() {
		while (true) {
			try {
				System.out.println("|<-----LỰA CHỌN CHỨC NĂNG------>|");
				System.out.println("| 1. Nhập Danh Sách Sinh Viên   |");
				System.out.println("| 2. Hiển Thị Thông Tin SV      |");
				System.out.println("| 3. Sắp Xếp Điểm Cao -> Thấp   |");
				System.out.println("| 4. Sắp Xếp Điểm Thấp -> Cao   |");
				System.out.println("| 5. Sắp Xếp Theo Điểm TB       |");
				System.out.println("| 6. Sắp Xếp Theo Tên Sinh Viên |");
				System.out.println("| 7. Sửa Tên Sinh Viên          |");
				System.out.println("| 8. Xóa Tên Sinh Viên          |");
				System.out.println("| 9. Tìm Kiếm Tên Sinh Viên     |");
				System.out.println("|=============!!!!==============|");
				System.out.println("| 10. Kết Thúc                   |");
				System.out.println("|<============????=============>|");
				int aye = input.nextInt();
				if (aye == 1) {
					NhapSV();
				} else if (aye == 2) {
					XuatSV();
				} else if (aye == 3) {
					SVCaoNhat();
				} else if (aye == 4) {
					SVThapNhat();
				} else if (aye == 5) {
					SapXepĐTB();
				} else if (aye == 6) {
					SapXepTen();
				} else if (aye == 7) {
					Edit();
				} else if (aye == 8) {
					Delete();
				} else if (aye == 9) {
					View();
				} else if (aye == 10) {
					KetThuc();
				} else {
					throw new Exception();
				}
			} catch (Exception e) {
				System.out.println(" Chỉ Được Nhập Từ 1 Tới 10,Hãy Nhập Lại Nha Bạn!");
				System.out.println(" Thank You!");
				input.nextLine();

			}

		}
	}
}
