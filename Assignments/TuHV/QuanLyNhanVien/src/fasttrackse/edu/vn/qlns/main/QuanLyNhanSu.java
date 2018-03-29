package fasttrackse.edu.vn.qlns.main;

import fasttrackse.edu.vn.quanlynhanvien.*;

public class QuanLyNhanSu {

	public static void main(String[] args) {
		NhanVien nv1 = new NhanVien("FFSE1702", "Hồ Viết Tú", "09/01/1999", 1);
		QuanLy ql1 = new QuanLy("FFSE1701", "Hồ Viết Tuấn", "05/01/1994", 1, 2000000);
		System.out.println(nv1.getTenNV() +"-"+nv1.getNgaySinhNV());

	}
}
