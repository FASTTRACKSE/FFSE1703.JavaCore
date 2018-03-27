package fasttrack.edu.vn.mycar;

public class Quanlisinhvien {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sinhvien Sv1, Sv2, Sv3;
		Sinhvien[] arrSv;
		// khai bao SV 1
		Sv1 = new Sinhvien();
		Sv1.setSvName("Ho Thanh Nhan");
		Sv1.setSvDate("10/07/98");
		Sv1.setSvDiemlp1(9.1);
		Sv1.setSvDiemlp2(8.5);

		// khai bao SV 2
		Sv2 = new Sinhvien();
		Sv2.setSvName("Pham Van Quy");
		Sv2.setSvDate("00/00/00");
		Sv2.setSvDiemlp1(8.3);
		Sv2.setSvDiemlp2(7.0);

		// khai bao SV 3
		Sv3 = new Sinhvien();
		Sv3.setSvName("Tong Le Quoc Dat");
		Sv3.setSvDate("00/00/00");
		Sv3.setSvDiemlp1(5.4);
		Sv3.setSvDiemlp2(6.3);

		// khai bao mang xe
		arrSv = new Sinhvien[5];
		arrSv[0] = Sv1;
		arrSv[1] = Sv2;
		arrSv[2] = Sv3;

		System.out.println("\t" + "<-----DANH SACH SINH VIEN----->" + "\t");
		System.out.println("   Name         " + "\t" + "Date" + "\t" + "\t" + "DiemLP1" + "\t" + "\t" + "DiemLP2" + "\t"
				+ "\t" + "DiemTB");
		for (int i = 0; i < 3; i++) {
			System.out.println((i + 1) + " " + arrSv[i].getSvName() + "    " + "\t" + arrSv[i].getSvDate() + "\t"
					+ arrSv[i].getSvDiemlp1() + "\t" + "\t" + arrSv[i].getSvDiemlp2() + "\t" + "\t"
					+ arrSv[i].getSvDiemtb());
		}
		System.out.println("\t" + "<-----XEP LOAI DIEM TRUNG BINH CUA SINH VIEN----->" + "\t");
		for (int i = 0; i < 3; i++) {
			if (arrSv[i].getSvDiemtb() >= 8.5) {
				System.out.println("Hoc Sinh Gioi: " + arrSv[i].getSvName() + "    Diem TB " + arrSv[i].getSvDiemtb());
			} else if ((arrSv[i].getSvDiemtb() <= 8.4) && (arrSv[i].getSvDiemtb() >= 7)) {
				System.out.println("Hoc Sinh Kha: " + arrSv[i].getSvName() + "    Diem TB " + arrSv[i].getSvDiemtb());
			} else if ((arrSv[i].getSvDiemtb() <= 6.9) && (arrSv[i].getSvDiemtb() >= 5)) {
				System.out.println("Hoc Sinh TB: " + arrSv[i].getSvName() + "    Diem TB " + arrSv[i].getSvDiemtb());
			}
		}
	}

}
