package fasttrack.edu.vn.practices;

import java.util.ArrayList;
import java.util.Scanner;

public class DanhSachSV {

	ArrayList<QLSinhViên> arrsv = new ArrayList<>();

	public void dockingdssv(ArrayList<QLSinhViên> arrsv) {
		for (int i = 0; i < arrsv.size(); i++) {
			for (int j = 0; j < arrsv.size(); j++) {
				if (arrsv.get(i).getGpa() < arrsv.get(j).getGpa()) {
					QLSinhViên sv = new QLSinhViên();
					sv = arrsv.get(i);
					arrsv.set(i, arrsv.get(j));
					arrsv.set(j, sv);
				}
			}
		}
	}

	public void showListsv(ArrayList<QLSinhViên> arrsv) {
		for (int i = 0; i < arrsv.size(); i++) {
			arrsv.get(i).outputIforSV();
		}
	}

	public void inputListsv(int n) {
		for (int i = 0; i < n; i++) {
			System.out.println("Nhập Tên Sinh Viên Thứ " + (i + 1) + " :");
			QLSinhViên sv = new QLSinhViên();
			sv.inputIforSV();
			arrsv.add(sv);
		}
	}

	public static void main(String[] args) {
		DanhSachSV q = new DanhSachSV();
		Scanner input = new Scanner(System.in);
		int luachon, i = 0;
		while (i == 0) {
			System.out.println("|<-----LỰA CHỌN CHỨC NĂNG------>|");
			System.out.println("| 1. Nhập Danh Sách Sinh Viên   |");
			System.out.println("| 2. Hiển Thị Thông Tin SV      |");
			System.out.println("| 3. Sắp Xếp                    |");
			System.out.println("|=============!!!!==============|");
			System.out.println("| 4. Kết Thúc                   |");
			System.out.println("|<============????=============>|");
			luachon = input.nextInt();
			switch (luachon) {
			case 1:
				System.out.println("Ban Hay Nhap So Sinh Vien Co Trong Danh Sach");
				int n = input.nextInt();
				q.inputListsv(n);
				break;
			case 2:
				q.showListsv(q.arrsv);
				break;
			case 3:
				q.dockingdssv(q.arrsv);
				q.showListsv(q.arrsv);
				break;
			case 4:
				i = 1;
				System.out.println("Thank You!");
				break;
			}
		}
	}
}
