package ffse1703013.atm.model;

import java.util.Comparator;

public class ATM {
	private String maATM, duongPho, phuong, quan, tongTien;

	public ATM() {

	}

	public ATM(String maATM, String duongPho, String phuong, String quan, String tongTien) {
		this.maATM = maATM;
		this.duongPho = duongPho;
		this.phuong = phuong;
		this.quan = quan;
		this.tongTien = tongTien;
	}

	public String getMaATM() {
		return maATM;
	}

	public void setMaATM(String maATM) {
		this.maATM = maATM;
	}

	public String getDuongPho() {
		return duongPho;
	}

	public void setDuongPho(String duongPho) {
		this.duongPho = duongPho;
	}

	public String getPhuong() {
		return phuong;
	}

	public void setPhuong(String phuong) {
		this.phuong = phuong;
	}

	public String getQuan() {
		return quan;
	}

	public void setQuan(String quan) {
		this.quan = quan;
	}

	public String getTongTien() {
		return tongTien;
	}

	public void setTongTien(String tongTien) {
		this.tongTien = tongTien;
	}

	public static Comparator<ATM> sortSoTien = new Comparator<ATM>() {

		public int compare(ATM s1, ATM s2) {

			int ma1 = Integer.parseInt(s1.getTongTien());
			int ma2 = Integer.parseInt(s2.getTongTien());

			if ((ma2 - ma1) > 0)
				return 1;
			else if ((ma2 - ma1) < 0)
				return -1;
			else
				return 0;

		}
	};
	public static Comparator<ATM> sortMaMay = new Comparator<ATM>() {
		@Override
		public int compare(ATM s1, ATM s2) {
			String name1 = s1.getMaATM().toUpperCase();
			String name2 = s2.getMaATM().toUpperCase();

			return name1.compareTo(name2);

		}

	};

}
