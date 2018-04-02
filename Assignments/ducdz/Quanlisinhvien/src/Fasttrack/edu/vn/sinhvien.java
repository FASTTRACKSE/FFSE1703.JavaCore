package Fasttrack.edu.vn;

public class sinhvien {
	public String xeploai;
	public String tensinhvien;
	public int ngaysinh;
	public int diemLP1;
	public int diemLP2;
	public double diemTB;

	public sinhvien() {
		//
	}
	public sinhvien(String name, int date, int point1, int point2) {
		this.tensinhvien = name;
		this.ngaysinh = date;
		this.diemLP1 = point1;
		this.diemLP2 = point2;
	}

	public void set_tensinhvien(String name) {
		this.tensinhvien = name;
	}

	public String get_tensinhvien() {
		return this.tensinhvien;
	}

	public void set_ngaysinh(int date) {
		this.ngaysinh = date;
	}

	public int get_ngaysinh() {
		return ngaysinh;
	}

	public void set_diemLP1(int point1) {
		this.diemLP1 = point1;
	}

	public int get_diemLP1() {
		return diemLP1;
	}

	public void set_diemLP2(int point2) {
		this.diemLP2 = point2;
	}

	public int get_diemLP2() {
		return diemLP2;
	}

	public double tinh_diemTB() {
		diemTB = (get_diemLP1() + get_diemLP2()) / 2;
		return diemTB;
	}

	public String xeploai() {
		if (tinh_diemTB() < 4.9) {
			xeploai = "Kem";
		}
		if (tinh_diemTB() > 5 && tinh_diemTB() < 6.9) {

			xeploai = "Trung binh";
		}
		if (tinh_diemTB() > 7 && tinh_diemTB() < 8.4) {
			xeploai = "Kha";
		}
		if (tinh_diemTB() > 8.5 && tinh_diemTB() < 10) {
			xeploai = "Gioi";
		}
		return xeploai;
	}
}
