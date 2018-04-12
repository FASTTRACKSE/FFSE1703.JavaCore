package fasttrackse.edu.vn.luufile.main;
import java.util.ArrayList;

import fasttarckse.edu.vn.luufile.io.SerializeFileFactory;
import fasttarckse.edu.vn.luufile.io.TextFileFactory;
import fasttrackse.edu.vn.luufile.*;
import fasttrackse.edu.vn.luufile.model.*;

public class QuanLySinhVien {
	public static void luuFile() {
		ArrayList<SinhVien> arrSV = new ArrayList<SinhVien>();
		ArrayList<SinhVien> arrSV1;
		arrSV.add(new SinhVien("KH01", "Nguyễn Thị Bình",5,5));
		arrSV.add(new SinhVien("KH02", "Trần Trung Thành",5,5));
		arrSV.add(new SinhVien("KH03", "Lê Bá Khánh Trình",5,5));
		arrSV.add(new SinhVien("KH04", "Hoàng Ngọc Phách",5,5));

		boolean kt = TextFileFactory.luuFile(arrSV, "dulieu.txt");
		if (kt == true) {
			System.out.println("Lưu file thành công");
		} else {
			System.out.println("Lưu file thất bại");
		}
	}

	public static void main(String[] args) {
		luuFile();
		ArrayList<SinhVien> arrSV = TextFileFactory.docFile("dulieu.txt");

		System.out.println("Danh sách khách hàng nạp vào máy tính là:");
		System.out.println("ngày sinh-tên-LP1-Lp2");
		for (SinhVien kh : arrSV) {
			System.out.println(kh);
		}
	}


}
