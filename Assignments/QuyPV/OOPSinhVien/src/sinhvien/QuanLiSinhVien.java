package sinhvien;

import java.util.Scanner;
import java.util.ArrayList;

public class QuanLiSinhVien {
	
	public static ArrayList<SinhVien> arr = new ArrayList<>();
	public static SinhVien arrSinhVien[];
	public static int soLuong;
	public static Scanner myInput = new Scanner(System.in);
	public static int sortByDTB[];
	public static int sortByABC[];
	public static SinhVien a = new SinhVien();
	

	public static void main(String[] args) {

		// for(int i = 0; i < soLuong; i++) {
		// SinhVien sv = new SinhVien();
		// sv.nhap();
		//
		// arrSinhVien[i] = sv;
		// }

		myMenu();
	}

	public static void myMenu() {
		System.out.println("---  lỰA CHỌN CHỨC NĂNG  ---");
		System.out.println("____________________________" + "\n");
		System.out.println("1. Nhập thông tin sinh viên.");
		System.out.println("2. In thông tin sinh viên.");
		System.out.println("3. Top sinh viên.");
		System.out.println("4. Sắp xếp theo điểmTB.");
		System.out.println("5. Sắp xếp theo họ tên.");
		System.out.println("6. Sửa họ tên.");
		System.out.println("0. Kết thúc.");
		System.out.println("____________________________" + "\n");
		while (true) {
			System.out.print("Nhập lựa chọn của bạn: ");
			int myChose = myInput.nextInt();
			if (myChose == 1) {
				nhap();
			} else if (myChose == 2) {
				in();
			} else if (myChose == 3) {
				top();
			} else if (myChose == 4) {
				sapXepDTB();
			} else if (myChose == 5) {
				sapXepHoTen();
			} else if (myChose == 0) {
				ketThuc();
			}
		}
	}

	public static void nhap() {

		System.out.println("Nhập số lượng sinh viên: ");
		soLuong = myInput.nextInt();
		arrSinhVien = new SinhVien[soLuong];
		for (int i = 0; i < soLuong; i++) {
			arrSinhVien[i] = new SinhVien();
			myInput.nextLine();
			SinhVien.setTongSo();
			
			
			System.out.println("Nhập tên sinh viên: ");
			String ten = myInput.nextLine();
			arrSinhVien[i].setHoTen(ten);
			
			System.out.println("Nhập ngày sinh: ");
			String ngSinh = myInput.nextLine();
			arrSinhVien[i].setNgaySinh(ngSinh);
			
			System.out.println("Nhập điểm Lp1: ");
			double diemLP1 = Double.parseDouble(myInput.nextLine());
			arrSinhVien[i].setDiemLp1(diemLP1);
			
			System.out.println("Nhập điểm Lp2: ");
			double diemLP2 = Double.parseDouble(myInput.nextLine());
			arrSinhVien[i].setDiemLp2(diemLP2);
			
			arr.add(new SinhVien(ten, ngSinh, diemLP1, diemLP2));
		}
		
		
		
	}

	public static void in() {
		
		int i = 0;
		System.out.println(
				"STT \t" + "Họ Và tên \t" + "Ngày sinh \t" + "Điểm LP1 \t" + "Điểm LP2 \t" + "ĐTB \t" + "Xếp loại");
		for (SinhVien x : arr) {

			System.out.println((i + 1) + " \t" + x.getHoTen() + " \t \t" + x.getNgaySinh()
					+ "\t" + x.getDiemLp1() + " \t \t" + x.getDiemLp2() + " \t \t"
					+ x.getDiemTB() + "\t" + x.getXepLoai());
			i++;
		}
		
		System.out.println("Tổng số sinh viên: " + SinhVien.tongSo);
	
	}

	public static void top() {
		double max, min;
		int vtMax, vtMin;

		max = arrSinhVien[0].getDiemTB();
		min = arrSinhVien[0].getDiemTB();
		vtMax = 0;
		vtMin = 0;
		for (int i = 1; i < soLuong; i++) {
			if (max < arrSinhVien[i].getDiemTB()) {
				max = arrSinhVien[i].getDiemTB();
				vtMax = i;
			}

			if (min > arrSinhVien[i].getDiemTB()) {
				min = arrSinhVien[i].getDiemTB();
				vtMin = i;
			}
		}

		for (int i = 0; i < soLuong; i++) {
			if (max == arrSinhVien[i].getDiemTB()) {
				max = arrSinhVien[i].getDiemTB();
				vtMax = i;
				System.out.println(
						"Sinh viên có điểm trung bình cao nhất: " + arrSinhVien[vtMax].getHoTen() + " với " + max);
			}

			if (min == arrSinhVien[i].getDiemTB()) {
				min = arrSinhVien[i].getDiemTB();
				vtMin = i;
				System.out.println(
						"Sinh viên có điểm trung bình thấp nhất: " + arrSinhVien[vtMin].getHoTen() + " với " + min);
			}
		}

	}

	public static void sapXepDTB() {
		sortByDTB = new int[soLuong];
		for (int i = 0; i < soLuong; i++) {
			sortByDTB[i] = i;
		}
		for (int i = 0; i < soLuong - 1; i++) {
			for (int j = i + 1; j < soLuong; j++) {
				if (arrSinhVien[sortByDTB[i]].getDiemTB() > arrSinhVien[sortByDTB[j]].getDiemTB()) {
					int temp = sortByDTB[j];
					sortByDTB[j] = sortByDTB[i];
					sortByDTB[i] = temp;
				}
			}

		}

		System.out.println(
				"STT \t" + "Họ Và tên \t" + "Ngày sinh \t" + "Điểm LP1 \t" + "Điểm LP2 \t" + "ĐTB \t" + "Xếp loại");
		for (int i = 0; i < soLuong; i++) {

			System.out.println((i + 1) + " \t" + arrSinhVien[sortByDTB[i]].getHoTen() + " \t \t"
					+ arrSinhVien[sortByDTB[i]].getNgaySinh() + "\t" + arrSinhVien[sortByDTB[i]].getDiemLp1() + " \t \t"
					+ arrSinhVien[sortByDTB[i]].getDiemLp2() + " \t \t" + arrSinhVien[sortByDTB[i]].getDiemTB() + "\t"
					+ arrSinhVien[sortByDTB[i]].getXepLoai());

		}

	}

	public static void sapXepHoTen() {
		sortByABC = new int[soLuong];
		for(int i = 0; i < soLuong; i++) {
			sortByABC[i] = i;
		}
		
		for(int i = 0; i < soLuong - 1; i++) {
			for(int j = i + 1; j < soLuong; j++) {
				if(arrSinhVien[sortByABC[i]].getHoTen().compareTo(arrSinhVien[sortByABC[j]].getHoTen()) > 0) {
					int temp = sortByABC[i];
					sortByABC[i] = sortByABC[j];
					sortByABC[j] = temp;
				}
			}
		}
		

		System.out.println(
				"STT \t" + "Họ Và tên \t" + "Ngày sinh \t" + "Điểm LP1 \t" + "Điểm LP2 \t" + "ĐTB \t" + "Xếp loại");
		for (int i = 0; i < soLuong; i++) {

			System.out.println((i + 1) + " \t" + arrSinhVien[sortByABC[i]].getHoTen() + " \t \t"
					+ arrSinhVien[sortByABC[i]].getNgaySinh() + "\t" + arrSinhVien[sortByDTB[i]].getDiemLp1() + " \t \t"
					+ arrSinhVien[sortByABC[i]].getDiemLp2() + " \t \t" + arrSinhVien[sortByABC[i]].getDiemTB() + "\t"
					+ arrSinhVien[sortByABC[i]].getXepLoai());

		}

	}

	public static void ketThuc() {
		System.out.println("Cảm ơn bạn đã sử dụng chương trình của chúng tôi!!!");
		System.exit(0);
	}
	
	

}
