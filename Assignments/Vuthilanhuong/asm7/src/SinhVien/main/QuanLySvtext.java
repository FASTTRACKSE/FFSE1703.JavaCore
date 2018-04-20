package SinhVien.main;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

import SinhVien.model.*;
import SinhVien.io.*;
public class QuanLySvtext {
	public static ArrayList<SinhVien> arrsv = new ArrayList<SinhVien>();
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		menuC();
	}

	public static void nhapSV() {
		System.out.println("Bạn muốn nhập bao nhiêu sinh viên");
		int nhapSV = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < nhapSV; i++) {
			System.out.println("Tên sinh viên");
			String tenSv = sc.nextLine();
			System.out.println("Ngày sinh sinh viên");
			String nSinh = sc.nextLine();
			System.out.println("Điểm lp1");
			Double diemLP1 = Double.parseDouble(sc.nextLine());
			System.out.println("Điểm lp2");
			Double diemLP2 = Double.parseDouble(sc.nextLine());
			arrsv.add(new SinhVien(tenSv, nSinh, diemLP1, diemLP2));
			boolean sv = TextFileFactory.luuFile(arrsv, "dulieu1.txt");
			if (sv == true) {
				System.out.println("Đã lưu file thành công");
			} else {
				System.out.println("Lưu file thất bại");
			}
		}
	}

	public static void inDs() {
		ArrayList<SinhVien> arrSv = TextFileFactory.docFile("dulieu1.txt");
		System.out.printf("%-15s | %-20s | %-20s | %-20s |%-20s |  \n", "Tên Sv", "Ngày sinh", " Điểm lp1", " Điểm lp2",
				"Điểm tb");
		for (SinhVien x : arrSv) {
			System.out.printf("%-15s | %-20s | %-20s | %-20s |%-20s | \n", x.getHoTen(), x.getnSinh(), x.getDiemLp1(),
					x.getDiemLp2(), x.getDiemTb());
		}
	}

	public static void diemCao() {
		Double max = arrsv.get(0).getDiemTb();
		int stt = 0;
		for (int i = 0; i < arrsv.size(); i++) {
			if (max < arrsv.get(i).getDiemTb()) {
				max = arrsv.get(i).getDiemTb();
			}

		}
		System.out.println("Sinh viên có điểm cao nhất là: " + arrsv.get(stt).getHoTen() + arrsv.get(stt).getDiemTb());
	}

	public static void diemThap() {
		Double max = arrsv.get(0).getDiemTb();
		int stt = 0;
		for (int i = 0; i < arrsv.size(); i++) {
			if (max > arrsv.get(i).getDiemTb()) {
				max = arrsv.get(i).getDiemTb();
				stt=i;
			}

		}
		System.out.println("Sinh viên có điểm thấp nhất là: " + arrsv.get(stt).getHoTen() + arrsv.get(stt).getDiemTb());
	}

	public static void sxTB() {
		Collections.sort(arrsv, SinhVien.comparediem);
		System.out.printf("%-15s | %-20s | %-20s | %-20s |%-20s |  \n", "Tên Sv", "Ngày sinh", " Điểm lp1", " Điểm lp2",
				"Điểm tb");
		for (SinhVien x : arrsv) {
			System.out.printf("%-15s | %-20s | %-20s | %-20s |%-20s | \n", x.getHoTen(), x.getnSinh(), x.getDiemLp1(),
					x.getDiemLp2(), x.getDiemTb());
		}
	}

	public static void sxTen() {
		Collections.sort(arrsv, SinhVien.compareten);
		System.out.printf("%-15s | %-20s | %-20s | %-20s |%-20s |  \n", "Tên Sv", "Ngày sinh", " Điểm lp1", " Điểm lp2",
				"Điểm tb");
		for (SinhVien x : arrsv) {
			System.out.printf("%-15s | %-20s | %-20s | %-20s |%-20s | \n", x.getHoTen(), x.getnSinh(), x.getDiemLp1(),
					x.getDiemLp2(), x.getDiemTb());
		}
	}

	public static void inTheoTen() {
		System.out.println("bạn muốn in tên gì");
		String ten = sc.nextLine();
		for (SinhVien x : arrsv) {
			if (ten.equals(x.getHoTen())) {
				System.out.printf("%-15s | %-20s | %-20s | %-20s |%-20s | \n", x.getHoTen(), x.getnSinh(),
						x.getDiemLp1(), x.getDiemLp2(), x.getDiemTb());

			}
		}
	}

	public static void doiTen() {
		System.out.printf("%-15s |%-15s | %-20s | %-20s | %-20s |%-20s |  \n", "Stt", "Tên Sv", "Ngày sinh",
				" Điểm lp1", " Điểm lp2", "Điểm tb");
		int i = 1;
		for (SinhVien x : arrsv) {
			System.out.printf("%-15s |%-15s | %-20s | %-20s | %-20s |%-20s | \n", i, x.getHoTen(), x.getnSinh(),
					x.getDiemLp1(), x.getDiemLp2(), x.getDiemTb());
			i++;
		}
		System.out.println("bạn muốn dổi tên sinh viên thứ mấy: ");
		int dsvthu = Integer.parseInt(sc.nextLine());
		System.out.println("Nhập tên bạn muốn đổi");
		String ten = sc.nextLine();
		arrsv.get(dsvthu).setHoTen(ten);
		System.out.printf("%-15s | %-20s | %-20s | %-20s |%-20s |  \n", "Tên Sv", "Ngày sinh", " Điểm lp1", " Điểm lp2",
				"Điểm tb");
		for (SinhVien x : arrsv) {
			System.out.printf("%-15s | %-20s | %-20s | %-20s |%-20s | \n", x.getHoTen(), x.getnSinh(), x.getDiemLp1(),
					x.getDiemLp2(), x.getDiemTb());
		}

	}

	public static void xoaTen() {
		System.out.printf("%-15s |%-15s | %-20s | %-20s | %-20s |%-20s |  \n", "Stt", "Tên Sv", "Ngày sinh",
				" Điểm lp1", " Điểm lp2", "Điểm tb");
		int i = 1;
		for (SinhVien x : arrsv) {
			System.out.printf("%-15s |%-15s | %-20s | %-20s | %-20s |%-20s | \n", i, x.getHoTen(), x.getnSinh(),
					x.getDiemLp1(), x.getDiemLp2(), x.getDiemTb());
			i++;
		}
		System.out.println("bạn muốn xóa sinh viên thứ mấy: ");
		int xsvthu = Integer.parseInt(sc.nextLine());
		arrsv.remove(xsvthu);
		System.out.printf("%-15s | %-20s | %-20s | %-20s |%-20s |  \n", "Tên Sv", "Ngày sinh", " Điểm lp1", " Điểm lp2",
				"Điểm tb");
		for (SinhVien x : arrsv) {
			System.out.printf("%-15s | %-20s | %-20s | %-20s |%-20s | \n", x.getHoTen(), x.getnSinh(), x.getDiemLp1(),
					x.getDiemLp2(), x.getDiemTb());
		}
	}

	public static void menuC() {
		while (true) {
			try {
				System.out.println("1.Nhập thông tin sinh viên");
				System.out.println("2.In danh sách sinh viên");
				System.out.println("3.Sinh viên có điểm cao nhất");
				System.out.println("4.Sinh viên có điểm cao nhất");
				System.out.println("5.Sắp xếp sinh viên theo điểm trung bình");
				System.out.println("6.Sắp xếp sinh viên theo tên");
				System.out.println("7.In danh sách các sinh viên có tên nhập từ bàn phím");
				System.out.println("8.Đổi tên một sinh viên");
				System.out.println("9.Xóa tên một sinh viên");

				int menuC = Integer.parseInt(sc.nextLine());

				if (menuC == 1) {
					nhapSV();
				}
				else if (menuC == 2) {
					inDs();
				}
				else if (menuC == 3) {
					diemCao();
				}
				else if (menuC == 4) {
					diemThap();
				}
				else if (menuC == 5) {
					sxTB();
				}
				else if (menuC == 6) {
					sxTen();
				}
				else if (menuC == 7) {
					inTheoTen();
				}
				else if (menuC == 8) {
					doiTen();
				}
				else if (menuC == 9) {
					xoaTen();
				}else {
					throw new Exception();
				}
				} catch (NumberFormatException e) {
					System.out.println("Nhập sai định dạng !!!");
					sc.nextLine();

			} catch (Exception e) {
				System.out.println("Bạn chỉ được nhập từ 1 đến 9 !!!");
				sc.nextLine();
			}
		}
	}
}
