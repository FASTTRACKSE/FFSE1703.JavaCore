package fasttrackse.fileiosample.main;

import java.util.ArrayList;

import fasttrackse.fileiosample.io.TextFileFactory;
import fasttrackse.fileiosample.model.KhachHang;

public class QuanLyKhachHang {

	public static void luuFile() {
		ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
		dsKH.add(new KhachHang("KH01", "Nguyễn Thị Bình"));
		dsKH.add(new KhachHang("KH02", "Trần Trung Thành"));
		dsKH.add(new KhachHang("KH03", "Lê Bá Khánh Trình"));
		dsKH.add(new KhachHang("KH04", "Hoàng Ngọc Phách"));

		boolean kt = TextFileFactory.luuFile(dsKH, "dulieu.txt");
		if (kt == true) {
			System.out.println("Lưu file thành công");
		} else {
			System.out.println("Lưu file thất bại");
		}
	}

	public static void main(String[] args) {
		luuFile();
		ArrayList<KhachHang> dsKH = TextFileFactory.docFile("dulieu.txt");

		System.out.println("Danh sách khách hàng nhập vào máy tính:");
		System.out.println("Mã----Tên");
		for (KhachHang kh : dsKH) {
			System.out.println(kh);
		}
	}

}
