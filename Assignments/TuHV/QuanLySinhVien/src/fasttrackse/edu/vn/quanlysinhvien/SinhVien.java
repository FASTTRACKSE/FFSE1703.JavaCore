package fasttrackse.edu.vn.quanlysinhvien;
import java.util.Scanner;

public class SinhVien {
	public static Scanner myScanner = new Scanner(System.in);

	public String SVten;
	public String SVngaysinh;
	public int SVLP1;
	public int SVLP2;
	public double SVDTB;

	public SinhVien(String SVten, String SVngaysinh, int SVLP1, int SVLP2) {
		this.SVten = SVten;
		this.SVngaysinh = SVngaysinh;
		this.SVLP1 = SVLP1;
		this.SVLP2 = SVLP2;

	}
	public SinhVien() {

	}
	public void Input() {
		myScanner.nextLine();
		System.out.print("Nhập tên Sinh Viên :");
		this.SVten = myScanner.nextLine();

		System.out.print("Nhập ngày sinh của Sinh Viên :");
		this.SVngaysinh = myScanner.nextLine();

		System.out.print("Nhập điểm môn LP1 :");
		this.SVLP1 = myScanner.nextInt();

		System.out.print("Nhập điểm môn LP2 :");
		this.SVLP2 = myScanner.nextInt();
	}


	public void setSVten(String name) {
		this.SVten = name;
	}

	public String getSVten() {
		return this.SVten;
	}

	public void setSVngaysinh(String name) {
		this.SVngaysinh = name;
	}

	public String getSVngaysinh() {
		return this.SVngaysinh;
	}

	public void setSVLP1(int LP1) {
		this.SVLP1 = LP1;
	}

	public int getSVLP1() {
		return this.SVLP1;
	}

	public void setSVLP2(int LP2) {
		this.SVLP2 = LP2;
	}

	public int getSVLP2() {
		return this.SVLP2;
	}

	public double getSVDTB() {
		return ((double) (this.SVLP1 + this.SVLP2) / 2);
	}

	public String getSVxeploai() {
		if (getSVDTB() >= 8.5) {
			return "Giỏi";
		} else if (getSVDTB() >= 7.0 && getSVDTB() <= 8.4) {
			return "Khá";
		} else if (getSVDTB() >= 5.0 && getSVDTB() <= 6.9) {
			return "Trung Bình";
		} else {
			return "Yếu";
		}

	}

}