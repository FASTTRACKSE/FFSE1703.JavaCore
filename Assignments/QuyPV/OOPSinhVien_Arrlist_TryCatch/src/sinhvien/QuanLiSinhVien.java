package sinhvien;

import java.util.Scanner;
import java.util.ArrayList;
import io.*;

public class QuanLiSinhVien {

	private ArrayList<SinhVien> arr = new ArrayList<>();
	private int soLuong;
	private Scanner myInput = new Scanner(System.in);

	public static void main(String[] args) {
		QuanLiSinhVien main = new QuanLiSinhVien();
		main.myMenu();
	}

	public void myMenu() {
		while (true) {
			try {
				System.out.println("---  lỰA CHỌN CHỨC NĂNG  ---");
				System.out.println("____________________________" + "\n");
				System.out.println("1. Nhập thông tin sinh viên.");
				System.out.println("2. In thông tin sinh viên.");
				System.out.println("3. Đổi tên sinh viên.");
				System.out.println("4. Xóa tên sinh viên.");
				System.out.println("5. Tìm kiếm tên sinh viên.");
				System.out.println("6. Lưu file.");
				System.out.println("7. Đọc file.");
				System.out.println("0. Kết thúc.");
				System.out.println("____________________________" + "\n");

				System.out.print("Nhập lựa chọn của bạn: ");
				int myChose = Integer.parseInt(myInput.nextLine());
				if (myChose == 1) {
					nhap();
				} else if (myChose == 2) {
					in();
				} else if (myChose == 3) {
					doiTen();
				} else if (myChose == 4) {
					xoaTen();
				} else if (myChose == 5) {
					timKiem();
				} else if (myChose == 6) {
					luuFile();
				} else if (myChose == 7) {
					docFile();
				} else if (myChose == 0) {
					ketThuc();
				} else {
					throw new Exception();
				}
			} catch (NumberFormatException e) {
				System.out.println("Không được nhập chữ!!");
				myInput.nextLine();
			} catch (Exception e) {
				System.out.println("Chỉ được nhập từ 0 - 5");
				myInput.nextLine();
			}

		}
	}

	public void nhap() {
		try {
			System.out.println("Nhập số lượng sinh viên: ");
			soLuong = Integer.parseInt(myInput.nextLine());

			for (int i = 0; i < soLuong; i++) {

				SinhVien.setTongSo();

				System.out.println("Nhập tên sinh viên: ");
				String ten = myInput.nextLine();

				System.out.println("Nhập ngày sinh: ");
				String ngSinh = myInput.nextLine();

				System.out.println("Nhập điểm Lp1: ");
				double diemLP1 = Double.parseDouble(myInput.nextLine());

				System.out.println("Nhập điểm Lp2: ");
				double diemLP2 = Double.parseDouble(myInput.nextLine());

				arr.add(new SinhVien(ten, ngSinh, diemLP1, diemLP2));
			}
		} catch (Exception e) {
			System.out.println("Nhập sai định dạng!!!");
			myInput.nextLine();
		}
	}

	public void in() {
		int i = 0;
		System.out.println(
				"STT \t" + "Họ Và tên \t" + "Ngày sinh \t" + "Điểm LP1 \t" + "Điểm LP2 \t" + "ĐTB \t" + "Xếp loại");
		for (SinhVien x : arr) {

			System.out.println((i + 1) + " \t" + x.getHoTen() + " \t \t" + x.getNgaySinh() + "\t" + x.getDiemLp1()
					+ " \t \t" + x.getDiemLp2() + " \t \t" + x.getDiemTB() + "\t" + x.getXepLoai());
			i++;
		}

		System.out.println("Tổng số sinh viên: " + arr.size());
	}

	public void doiTen() {
		int i = 0;
		String ten1, ten2;

		System.out.println("<<<< ĐỔI TÊN SINH VIÊN >>>> ");
		System.out.println("---------------------------");
		System.out.println("Nhập tên sinh viên cần đổi: ");
		ten1 = myInput.nextLine();

		System.out.println("Nhập tên đổi: ");
		ten2 = myInput.nextLine();
		System.out.println("---------------------------");
		System.out.println(
				"STT \t" + "Họ Và tên \t" + "Ngày sinh \t" + "Điểm LP1 \t" + "Điểm LP2 \t" + "ĐTB \t" + "Xếp loại");
		try {
			for (SinhVien x : arr) {
				if (ten1.equals(x.getHoTen())) {
					x.setHoTen(ten2);
					System.out
							.println((i + 1) + " \t" + x.getHoTen() + " \t \t" + x.getNgaySinh() + "\t" + x.getDiemLp1()
									+ " \t \t" + x.getDiemLp2() + " \t \t" + x.getDiemTB() + "\t" + x.getXepLoai());
					i++;
					break;
				}
				if (!ten1.equals(x.getHoTen())) {
					throw new Exception();
				}

			}
		} catch (Exception e) {
			System.out.println("Tên sinh viên ko tồn tại!!!");
			myInput.nextLine();
		}
	}

	public void xoaTen() {
		int i = 0;
		String ten;
		System.out.println("<<<< XÓA TÊN SINH VIÊN >>>>");
		System.out.println("Nhập tên cần xóa: ");
		ten = myInput.nextLine();
		System.out.println("---------------------------");
		for (int z = 0; z < arr.size(); z++) {
			for (SinhVien x : arr) {
				if (ten.equals(x.getHoTen())) {
					arr.remove(x);
					z--;
					SinhVien.updateTongSo();
					break;
				}
			}
		}
		System.out.println(
				"STT \t" + "Họ Và tên \t" + "Ngày sinh \t" + "Điểm LP1 \t" + "Điểm LP2 \t" + "ĐTB \t" + "Xếp loại");
		for (SinhVien x : arr) {

			System.out.println((i + 1) + " \t" + x.getHoTen() + " \t \t" + x.getNgaySinh() + "\t" + x.getDiemLp1()
					+ " \t \t" + x.getDiemLp2() + " \t \t" + x.getDiemTB() + "\t" + x.getXepLoai());
			i++;
		}

		System.out.println("Tổng số sinh viên: " + SinhVien.tongSo);
	}

	public void timKiem() {
		int i = 0;
		String ten;
		System.out.println("<<<< TÌM KIẾM SINH VIÊN >>>> ");
		System.out.println("Nhập tên sinh viên: ");
		ten = myInput.nextLine();
		System.out.println("-----------------------------");
		System.out.println(
				"STT \t" + "Họ Và tên \t" + "Ngày sinh \t" + "Điểm LP1 \t" + "Điểm LP2 \t" + "ĐTB \t" + "Xếp loại");
		for (SinhVien x : arr) {
			if (x.getHoTen().indexOf(ten) > -1) {
				System.out.println((i + 1) + " \t" + x.getHoTen() + " \t \t" + x.getNgaySinh() + "\t" + x.getDiemLp1()
						+ " \t \t" + x.getDiemLp2() + " \t \t" + x.getDiemTB() + "\t" + x.getXepLoai());
				i++;
			}
		}

	}

	public void luuFile() {
		boolean kt = SerializeFile.luuFile(arr, "sinhvien.txt");
		if (kt == true) {
			System.out.println("Lưu file thành công");
		} else {
			System.out.println("Lưu file thất bại");
		}
	}

	public void docFile() {
		int i = 1;
		ArrayList<SinhVien> arrFile = SerializeFile.docFile("sinhvien.txt");
		arr = arrFile;
		System.out.println(
				"STT \t" + "Họ Và tên \t" + "Ngày sinh \t" + "Điểm LP1 \t" + "Điểm LP2 \t" + "ĐTB \t" + "Xếp loại");
		for (SinhVien x : arr) {
			System.out.println((i ++) + " \t" + x.getHoTen() + " \t \t" + x.getNgaySinh() + "\t" + x.getDiemLp1()
					+ " \t \t" + x.getDiemLp2() + " \t \t" + x.getDiemTB() + "\t" + x.getXepLoai());
		}
	}

	public void ketThuc() {
		System.out.println("Cảm ơn bạn đã sử dụng chương trình của chúng tôi!!!");
		System.exit(0);
	}

}
