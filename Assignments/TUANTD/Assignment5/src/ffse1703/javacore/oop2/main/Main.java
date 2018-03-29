package ffse1703.javacore.oop2.main;

import java.util.ArrayList;

import ffse1703.javacore.oop2.model.*;

public class Main {

	public static void main(String[] args) {
		NhanVien nv1 = new NhanVien("FFSE001", "Cao Le Thanh", "1/1/1977", 1);
		QuanLy ql1 = new QuanLy("FFSE002", "Nguyen Van Anh", "1/1/1975", 5, 2000000);
		NhanVien nv2 = new QuanLy("FFSE003", "Van Anh Thi", "1/1/1976", 5, 3000000);

		ArrayList<NhanVien> arrNhanVien = new ArrayList<NhanVien>();
		arrNhanVien.add(nv1);
		arrNhanVien.add(nv2);
		arrNhanVien.add(ql1);

		
		System.out.println("Danh sách nhân viên");
		System.out.println("-------------------");
		for (NhanVien x : arrNhanVien) {
			if (!(x instanceof QuanLy)) {
				System.out.println("Nhan vien: " + x.getHoTenNV() + " - " + x.tinhLuong() + " - " + x.tinhThueThuNhap());
			}
		}

		System.out.println("\n");
		System.out.println("Danh sách Quản Lý");
		System.out.println("-------------------");
		for (NhanVien x : arrNhanVien) {
			if (x instanceof QuanLy) {
				System.out.println("Quan ly: " + x.getHoTenNV() + " - " + ((QuanLy) x).getLuongTrachNhiem() + " - " + ql1.tinhLuong()
				+ " - " + ql1.tinhThueThuNhap());
			}
		}
	}

}
