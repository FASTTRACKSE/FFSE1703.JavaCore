package ffse1703013.java.modle;

import java.io.Serializable;
import java.util.Comparator;

public class SinhVien implements Serializable {
	private String nameSv;
	private String Birthday;
	private String xepLoai;
	private Double lp1;
	private Double lp2;
	private Double Dtb;
	public static int toTal = 0;

	public SinhVien() {

	}

	public SinhVien(String name, String birthday, Double lp1, Double lp2) {
		this.nameSv = name;
		this.Birthday = birthday;
		this.lp1 = lp1;
		this.lp2 = lp2;
	}

	public SinhVien(String name, String birthday, Double lp1, Double lp2, Double dtb, String xepLoai) {
		this.nameSv = name;
		this.Birthday = birthday;
		this.lp1 = lp1;
		this.lp2 = lp2;
		this.Dtb = dtb;
		this.xepLoai = xepLoai;
	}

	public void setName(String name) {
		this.nameSv = name;
	}

	public String getName() {
		return this.nameSv;
	}

	public void setBirthday(String birthday) {
		this.Birthday = birthday;
	}

	public String getBirthday() {
		return this.Birthday;
	}

	public void setLp1(Double lp1) {
		this.lp1 = lp1;
	}

	public Double getLp1() {
		return this.lp1;
	}

	public void setLp2(Double lp2) {
		this.lp2 = lp2;
	}

	public Double getLp2() {
		return this.lp2;
	}

	public Double getDtb() {
		return Dtb = (this.lp1 + this.lp2) / 2;
	}

	public static void tongSo() {
		toTal++;
	}

	public String getXepLoai() {
		if (Dtb >= 8.5 && Dtb <= 10) {
			return xepLoai = "Giỏi";
		} else if (Dtb >= 6.5 && Dtb < 8.5) {
			return xepLoai = "khá";
		} else if (Dtb < 6.5 && Dtb >= 5) {
			return xepLoai = "Trung BÌnh";
		} else if (Dtb < 5 && Dtb > 0) {
			return xepLoai = "Yếu";
		} else {
			return xepLoai = "Quá xuất xắc";
		}
	}

	public static Comparator<SinhVien> SVNameComparator = new Comparator<SinhVien>() {

		public int compare(SinhVien s1, SinhVien s2) {
			String StudentName1 = s1.getName().toUpperCase();
			String StudentName2 = s2.getName().toUpperCase();

			return StudentName1.compareTo(StudentName2);

		}

	};

	public static Comparator<SinhVien> SVDTBComparator = new Comparator<SinhVien>() {

		public int compare(SinhVien s1, SinhVien s2) {

			Double fDTB1 = s1.getDtb();
			Double fDTB2 = s2.getDtb();

			if ((fDTB2 - fDTB1) > 0)
				return 1;
			else if ((fDTB2 - fDTB1) < 0)
				return -1;
			else
				return 0;

		}
	};

	public String toString() {
		return "  "+nameSv + "\t  \t" + Birthday + "\t \t" + lp1 + "\t \t" + lp2 + "\t \t" + getDtb() + "\t \t" + getXepLoai();
	}
}
