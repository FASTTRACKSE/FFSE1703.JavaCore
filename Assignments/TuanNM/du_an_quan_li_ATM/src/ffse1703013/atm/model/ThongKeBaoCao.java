package ffse1703013.atm.model;

import java.util.Comparator;

public class ThongKeBaoCao extends GiaoDich {
	private String maKH, tenKH, soNha, phuong, quan, soThe, soTK, soDu;
	private int soLanRut;
	private int tongTien;

	public ThongKeBaoCao() {
		super();
	}

	public ThongKeBaoCao(String maKH, String tenKH, String soNha, String phuong, String quan, String soThe, String soTK,
			int soLanRut, int tongTien ,String soDu) {

		this.maKH = maKH;
		this.tenKH = tenKH;
		this.soNha = soNha;
		this.phuong = phuong;
		this.quan = quan;
		this.soThe = soThe;
		this.soTK = soTK;
		this.soLanRut = soLanRut;
		this.tongTien = tongTien;
		this.soDu = soDu;
	}

	public ThongKeBaoCao(String maKH, String maGD, String soThe, String thoiGian, String soTien, String maMay) {
		super(maGD, soThe, thoiGian, soTien, maMay);
		this.maKH = maKH;

	}
	

	public String getSoDu() {
		return soDu;
	}

	public void setSoDu(String soDu) {
		this.soDu = soDu;
	}

	public ThongKeBaoCao(int soLan, int tongTien) {
		this.soLanRut = soLan;
		this.tongTien = tongTien;
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getTenKH() {
		return tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	public String getSoNha() {
		return soNha;
	}

	public void setSoNha(String soNha) {
		this.soNha = soNha;
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

	public String getSoThe() {
		return soThe;
	}

	public void setSoThe(String soThe) {
		this.soThe = soThe;
	}

	public String getSoTK() {
		return soTK;
	}

	public void setSoTK(String soTK) {
		this.soTK = soTK;
	}

	public int getSoLanRut() {
		return soLanRut;
	}

	public void setSoLanRut(int soLanRut) {
		this.soLanRut = soLanRut;
	}

	public int getTongTien() {
		return tongTien;
	}

	public void setTongTien(int tongTien) {
		this.tongTien = tongTien;
	}

	public static Comparator<ThongKeBaoCao> sortName = new Comparator<ThongKeBaoCao>() {
		@Override
		public int compare(ThongKeBaoCao s1, ThongKeBaoCao s2) {
			String name1 = s1.getTenKH().toUpperCase();
			String name2 = s2.getTenKH().toUpperCase();

			return name1.compareTo(name2);

		}

	};
	public static Comparator<ThongKeBaoCao> sortThoiGian = new Comparator<ThongKeBaoCao>() {
		@Override
		public int compare(ThongKeBaoCao s1, ThongKeBaoCao s2) {
			String tg1 = s1.getThoiGian().toUpperCase();
			String tg2 = s2.getThoiGian().toUpperCase();

			return tg2.compareTo(tg1);

		}

	};
	
	public static Comparator<ThongKeBaoCao> sortTongTien = new Comparator<ThongKeBaoCao>() {

		public int compare(ThongKeBaoCao s1, ThongKeBaoCao s2) {

			int ma1 = s1.getTongTien();
			int ma2 = s2.getTongTien();

			if ((ma2 - ma1) > 0)
				return 1;
			else if ((ma2 - ma1) < 0)
				return -1;
			else
				return 0;

		}
	};
}
