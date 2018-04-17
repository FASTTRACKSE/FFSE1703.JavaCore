package fasttrackse.interfacesamples.main;

import java.util.ArrayList;

import fasttrackse.interfacesamples.models.*;

public class QuanLySachHocSinh {

	public static void main(String[] args) {
		ArrayList<MonHoc> arrayMonHoc = new ArrayList<MonHoc>();
		
		arrayMonHoc.add(new MonToan(9, 8));
		arrayMonHoc.add(new MonLy(4, 4, 9));
		arrayMonHoc.add(new MonAnh(6, 7, 8, 9));
		
		int i = 0;
		for (MonHoc x: arrayMonHoc) {
			System.out.println((++i) + ". " + x.mangSach() + " điểm: " + x.tinhDiemMonHoc() + " loại: " + x.xepLoaiMonHoc());
		}

	}

}
