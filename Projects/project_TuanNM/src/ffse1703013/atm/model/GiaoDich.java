package ffse1703013.atm.model;

import java.util.Comparator;

public class GiaoDich {
	protected String maGD, soThe, thoiGian, soTien, maMay;

	public GiaoDich() {

	}

	public GiaoDich(String maGD, String soThe, String thoiGian, String soTien, String maMay) {
		this.maGD = maGD;
		this.soThe = soThe;
		this.thoiGian = thoiGian;
		this.soTien = soTien;
		this.maMay = maMay;
	}

	public String getMaGD() {
		return maGD;
	}

	public void setMaGD(String maGD) {
		this.maGD = maGD;
	}

	public String getSoThe() {
		return soThe;
	}

	public void setSoThe(String soThe) {
		this.soThe = soThe;
	}

	public String getThoiGian() {
		return thoiGian;
	}

	public void setThoiGian(String thoiGian) {
		this.thoiGian = thoiGian;
	}

	public String getSoTien() {
		return soTien;
	}

	public void setSoTien(String soTien) {
		this.soTien = soTien;
	}

	public String getMaMay() {
		return maMay;
	}

	public void setMaMay(String maMay) {
		this.maMay = maMay;
	}

	public static Comparator<GiaoDich> sortMaGiaoDich = new Comparator<GiaoDich>() {
		@Override
		public int compare(GiaoDich o1, GiaoDich o2) {
			String gd1 = o1.getMaGD().toUpperCase();
			String gd2 = o2.getMaGD().toUpperCase();

			return gd1.compareTo(gd2);
		}

	};
	public static Comparator<GiaoDich> sortThoiGian = new Comparator<GiaoDich>() {
		@Override
		public int compare(GiaoDich s1, GiaoDich s2) {
			String tg1 = s1.getThoiGian().toUpperCase();
			String tg2 = s2.getThoiGian().toUpperCase();

			return tg2.compareTo(tg1);

		}

	};

	public static Comparator<GiaoDich> sortSoTien = new Comparator<GiaoDich>() {

		public int compare(GiaoDich s1, GiaoDich s2) {

			int ma1 = Integer.parseInt(s1.getSoTien());
			int ma2 = Integer.parseInt(s2.getSoTien());

			if ((ma2 - ma1) > 0)
				return 1;
			else if ((ma2 - ma1) < 0)
				return -1;
			else
				return 0;

		}
	};

}
