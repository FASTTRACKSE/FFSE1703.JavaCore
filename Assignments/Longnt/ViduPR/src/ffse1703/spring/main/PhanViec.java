package ffse1703.spring.main;

import java.util.ArrayList;
import java.util.Scanner;
import ffse1703.spring.model.Sach;
import ffse1703.spring.model.SachToan;
public class PhanViec {
	public static Scanner myInput = new Scanner(System.in);
	static ArrayList<Sach> arrSach = new ArrayList<Sach>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		menu();
	}
	public static void menu() {
		while (true) {
			System.out.println("Danh sach bai toan");
			System.out.println("1. Sách Toán.");
			System.out.println("1. Sách Lý.");
			System.out.println("1. Sách Hóa.");
			System.out.print("Vui long nhap so de chon: ");
			int x = myInput.nextInt();
			switch (x) {
			case 1:
				sachToan();
				break;
			case 2:
				sachLy();
				break;
			case 3:
				sachHoa();
				break;
			}
		}
	}
	public static void sachToan() {
		System.out.print("Nhap ban kinh hinh tron: ");
		String r = myInput.toString();
		arrSach.add(new SachToan(Toan));
		System.out.println("+---------------DANH SÁCH KHÁCH HÀNG-------------------+");
		for (HinhHoc x : arrHinhHoc) {
			if (x instanceof HinhTron) {
			System.out.printf("%-15s%-15s%-20s \n", ((HinhTron) x).getR(), x.getChuVi(), x.getDienTich());
			}
		}
		myInput.nextLine();
		System.out.println();
		myInput.nextLine();
	}
}
