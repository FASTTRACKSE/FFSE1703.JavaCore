package fasttrackse.assignment4.main;

import java.util.ArrayList;
import java.util.Collections;

import fasttrackse.assignment4.model.SinhVien;

public class QuanLySinhVien {
	static ArrayList<SinhVien> arraySinhVien = new ArrayList<SinhVien>();

	public static void main(String[] args) {
		System.out.println("Nhap sinh vien 1");

		arraySinhVien.add(new SinhVien("Cao Lê Thành 0", "02/02/1977", 8, 9));
		arraySinhVien.add(new SinhVien("Cao Lê Thành 1", "02/02/1977", 8, 9));
		arraySinhVien.add(new SinhVien("Cao Lê Thành 2", "02/02/1977", 8, 9));
		arraySinhVien.add(new SinhVien("Cao Lê Thành 3", "02/02/1977", 8, 9));
		arraySinhVien.add(new SinhVien("Cao Lê Thành 4", "02/02/1977", 8, 9));

		System.out.println("Tong so sinh vien la: " + SinhVien.getTongSinhVien());

		System.out.println("Nhap sinh vien 2");
		arraySinhVien.add(new SinhVien("Trần Mạnh Hùng", "02/02/1977", 9, 9));
		System.out.println("Tong so sinh vien la: " + SinhVien.getTongSinhVien());

		System.out.println("Nhap sinh vien 3");
		arraySinhVien.add(new SinhVien("Bi Văn Tráng", "02/02/1977", 6, 5));

		System.out.println("Nhap sinh vien 4");
		arraySinhVien.add(new SinhVien("Thê Thế Lương", "02/02/1977", 6, 6));

		System.out.println("Nhap sinh vien 5");
		SinhVien newSV = new SinhVien("Trương Gia Bình", "1/1/1951", 10, 2);
		System.out.println("Tong so sinh vien la: " + SinhVien.getTongSinhVien());

		arraySinhVien.add(newSV);

		arraySinhVien.remove(3);

		// System.out.println("\nDANH SACH SINH VIEN CHUA SAP XEP");
		// for (SinhVien sinhVien : arraySinhVien) {
		// System.out.println(sinhVien.toString());
		// }
		//
		// System.out.println("\nDANH SACH SINH VIEN CHUA SAP XEP");
		// for (int i=0; i< arraySinhVien.size(); i++) {
		// System.out.println(arraySinhVien.get(i).toString());
		// }
		//
		// Collections.sort(arraySinhVien, SinhVien.SVNameComparator);
		//
		// System.out.println("\nDANH SACH SINH VIEN SAP XEP THEO TEN");
		// for (SinhVien sinhVien : arraySinhVien) {
		// System.out.println(sinhVien.toString());
		// }
		// Collections.sort(arraySinhVien, SinhVien.SVDTBComparator);

		System.out.println("\nDANH SACH SINH VIEN SAP XEP THEO DTB");
		for (SinhVien sinhVien : arraySinhVien) {
			System.out.println(sinhVien.toString());
		}

		// suaTenSinhVien("Cao Lê Thành", "Cao Lê Hành");
		xoaSinhVienTheoTen("Thành");
		xoaSinhVienTheoTenCach2("Hùng");
		
		System.out.println("\nDANH SACH SINH VIEN SAP XEP THEO DTB (xoá các ông tên Hùng, Thành)");
		for (SinhVien sinhVien : arraySinhVien) {
			System.out.println(sinhVien.toString());
		}
	}

	public static void suaTenSinhVien(String oldName, String newName) {
		for (SinhVien x : arraySinhVien) {
			if (x.getHoTen().equals(oldName)) {
				x.setHoTen(newName);
			}
		}
	}

	public static void xoaSinhVienTheoTen(String tenSinhVien) {
		boolean thereIsSomethingToDelete = true;
		
		while (thereIsSomethingToDelete) {
			thereIsSomethingToDelete = false;
			
			for (SinhVien x : arraySinhVien) {
				if (x.getHoTen().indexOf(tenSinhVien) > -1) {
					arraySinhVien.remove(x);
					thereIsSomethingToDelete = true;
					break;
				}
			}
		}
	}

	public static void xoaSinhVienTheoTenCach2(String tenSinhVien) {
		for (int i = arraySinhVien.size()-1; i>-2; i--) {
				if (arraySinhVien.get(i).getHoTen().indexOf(tenSinhVien) > -1) {
					arraySinhVien.remove(i);
				}
		}
	}

}
