package fasttrackse.fileiosample.main;

import java.util.ArrayList;

import fasttrackse.fileiosample.io.SerializeFileFactory;
import fasttrackse.fileiosample.model.KhachHang;

public class QuanLyKhachHang2 {

	public static void luuFile() {
		ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
		dsKH.add(new KhachHang("KH01", "Nguyễn Thị Bình"));
		dsKH.add(new KhachHang("KH02", "Trần Trung Thành"));
		dsKH.add(new KhachHang("KH03", "Lê Bá Khánh Trình"));
		dsKH.add(new KhachHang("KH04", "Hoàng Ngọc Phách"));

		boolean kt = SerializeFileFactory.luuFile(dsKH, "dulieu2.txt");
		if (kt == true) {
			System.out.println("Đã lưu file thành công");
		} else {
			System.out.println("Lưu file thất bại");
		}
	}

	public static void main(String[] args) {
		// luuFile();

		ArrayList<KhachHang> dsKH = SerializeFileFactory.docFile("dulieu2.txt");

		System.out.println("Danh sách khách hàng nạp vào máy tính là:");
		System.out.println("Mã----Tên");
		for (KhachHang kh : dsKH) {
			System.out.println(kh);
		}
	}

}
