package ffse1702.javacore.main;

import java.util.Scanner;

import ffse1702.javacore.model.*;

import java.util.ArrayList;

public class QuanLyNhanVien {
	
	public static Scanner Scanner = new Scanner(System.in);
	//instanceof thuộc kiểu Quản lý or sinh viên
	public static void main(String[] args) {
		
		Quanly NV1 = new Quanly("FFSE1702063","Hồ Quang Minh","30/10/99",8,2);
		NhanVien NV2 = new NhanVien("FFSE1702010","Nguyễn Thanh Hiếu","13/09/99",7);
		NhanVien NV3 = new NhanVien("FFSE1702009","Lê Phước Hiếu","13/09/99",7);
		
		ArrayList<NhanVien> arrNhanVien = new ArrayList<NhanVien>();
		arrNhanVien.add(NV1);
		arrNhanVien.add(NV2);
		arrNhanVien.add(NV3);
		
		System.out.println("Mã Số NV         Tên NV              Ngày Sinh      Lương        Thuế thu nhập ");
		for (NhanVien x : arrNhanVien) {
			if (!(x instanceof Quanly)) {
				System.out.printf("%-17s%-20s%-15s%-13s%-14s\n",x.getMS(),x.getTen(),x.getNS(),x.getLuong(),x.tinhThueThuNhap());
				}
			}
			for (NhanVien x : arrNhanVien) {
				if (x instanceof NhanVien) {
					System.out.printf("%-17s%-20s%-15s%-13s%-14s\n",x.getMS(),x.getTen(),x.getNS(),x.getLuong(),x.tinhThueThuNhap());
				}
			}
		}
}
