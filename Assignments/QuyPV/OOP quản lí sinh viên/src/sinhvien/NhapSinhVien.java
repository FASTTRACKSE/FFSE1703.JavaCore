package sinhvien;
import java.util.Scanner;
public class NhapSinhVien {
	public static SinhVien sinhVien1, sinhVien2, sinhVien3, sinhVien4;
	public static SinhVien arrSinhVien[];

	public static void main(String[] args) {
		Scanner myInput = new Scanner(System.in);

		// Khai báo sinh viên 1
		sinhVien1 = new SinhVien();

		System.out.println("Nhập tên sinh viên: ");
		String ten1 = myInput.nextLine();
		sinhVien1.setHoTen(ten1);

		System.out.println("Nhập ngày sinh: ");
		String ngaySinh1 = myInput.nextLine();
		sinhVien1.setNgaySinh(ngaySinh1);

		System.out.println("Nhập điểm lp1: ");
		double diemLp1Sv1 = myInput.nextDouble();
		sinhVien1.setDiemLp1(diemLp1Sv1);

		System.out.println("Nhập điểm lp2: ");
		double diemLp2Sv1 = myInput.nextDouble();
		sinhVien1.setDiemLp2(diemLp2Sv1);

		sinhVien1.getDiemTB();

		// Khai báo sinh viên 2
		sinhVien2 = new SinhVien();

		System.out.println("Nhập tên sinh viên: ");
		String ten2 = myInput.nextLine();
		sinhVien2.setHoTen(ten2);

		System.out.println("Nhập ngày sinh: ");
		String ngaySinh2 = myInput.nextLine();
		sinhVien2.setNgaySinh(ngaySinh2);

		System.out.println("Nhập điểm lp1: ");
		double diemLp1Sv2 = myInput.nextDouble();
		sinhVien2.setDiemLp1(diemLp1Sv2);

		System.out.println("Nhập điểm lp2: ");
		double diemLp2Sv2 = myInput.nextDouble();
		sinhVien2.setDiemLp2(diemLp2Sv2);

		sinhVien2.getDiemTB();

		// Khai báo sinh viên 3
		sinhVien3 = new SinhVien();

		System.out.println("Nhập tên sinh viên: ");
		String ten3 = myInput.nextLine();
		sinhVien3.setHoTen(ten3);

		System.out.println("Nhập ngày sinh: ");
		String ngaySinh3 = myInput.nextLine();
		sinhVien3.setNgaySinh(ngaySinh3);

		System.out.println("Nhập điểm lp1: ");
		double diemLp1Sv3 = myInput.nextDouble();
		sinhVien3.setDiemLp1(diemLp1Sv3);

		System.out.println("Nhập điểm lp2: ");
		double diemLp2Sv3 = myInput.nextDouble();
		sinhVien3.setDiemLp2(diemLp2Sv3);

		sinhVien3.getDiemTB();

		// Khai báo sinh viên 4
		sinhVien4 = new SinhVien();

		System.out.println("Nhập tên sinh viên: ");
		String ten4 = myInput.nextLine();
		sinhVien4.setHoTen(ten4);

		System.out.println("Nhập ngày sinh: ");
		String ngaySinh4 = myInput.nextLine();
		sinhVien4.setNgaySinh(ngaySinh4);

		System.out.println("Nhập điểm lp1: ");
		double diemLp1Sv4 = myInput.nextDouble();
		sinhVien4.setDiemLp1(diemLp1Sv4);

		System.out.println("Nhập điểm lp2: ");
		double diemLp2Sv4 = myInput.nextDouble();
		sinhVien4.setDiemLp2(diemLp2Sv4);

		sinhVien4.getDiemTB();

		arrSinhVien = new SinhVien[4];
		arrSinhVien[0] = sinhVien1;
		arrSinhVien[1] = sinhVien2;
		arrSinhVien[2] = sinhVien3;
		arrSinhVien[3] = sinhVien4;

		System.out.println("STT \t" + "H�? Và tên \t" + "Ngày sinh \t" + "�?iểm LP1 \t" + "�?iểm LP2 \t" + "�?TB");
		for (int i = 0; i < 4; i++) {

			System.out.println((i + 1) + " \t" + arrSinhVien[i].getHoTen() + " \t \t" + arrSinhVien[i].getNgaySinh()
					+ "\t" + arrSinhVien[i].getDiemLp1() + " \t\t" + arrSinhVien[i].getDiemLp2() + " \t\t"
					+ arrSinhVien[i].getDiemTB());
		}

	}
}
