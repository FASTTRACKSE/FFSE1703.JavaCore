package ffse1703.javacore.qltiendien.model;

import java.util.Scanner;
 class BienLai {
	private int chiSoCu;
	private int chiSoMoi;
	private String NgayThangNam;
	private double soTienPhaiTra;
	private int TieuThu;
	private KhachHang khachHang;

	public String getNgayThangNam() {
		return NgayThangNam;
	}

	public void setNgayThangNam(String ngayThangNam) {
		NgayThangNam = ngayThangNam;
	}

	public int getChiSoCu() {
		return chiSoCu;
	}

	public void setChiSoCu(int chiSoCu) {
		this.chiSoCu = chiSoCu;
	}

	public int getChiSoMoi() {
		return chiSoMoi;
	}

	public void setChiSoMoi(int chiSoMoi) {
		this.chiSoMoi = chiSoMoi;
	}

	public BienLai() {
		super();
	}

	public BienLai(int chiSoCu, int chiSoMoi, String NgayThangNam, KhachHang khachHang) {
		super();
		this.chiSoCu = chiSoCu;
		this.chiSoMoi = chiSoMoi;
		this.NgayThangNam = NgayThangNam;
		this.khachHang = khachHang;
	}

	public void nhapBienLai() {
		khachHang = new KhachHang();
		khachHang.nhapThongTinKhachHang();

		Scanner scanner = new Scanner(System.in);
		do {
			System.out.print("Nhập chỉ số cũ: ");
			chiSoCu = Integer.parseInt(scanner.nextLine());
			System.out.print("Nhập chỉ số mới: ");
			chiSoMoi = Integer.parseInt(scanner.nextLine());
			System.out.print("Nhập Ngày Tháng Năm:");
			NgayThangNam = scanner.nextLine();
		} while (chiSoCu > chiSoMoi);
		if (TieuThu <= 100)
			soTienPhaiTra = (double) (chiSoMoi - chiSoCu) * 1500;
		else {
			if (TieuThu <= 200)
				soTienPhaiTra = (double) (chiSoMoi - chiSoCu) * 1786;
			else {
				if (TieuThu <= 300)
					soTienPhaiTra = (double) (chiSoMoi - chiSoCu) * 2340;
				else {
					if (TieuThu <= 400)
						soTienPhaiTra = (double) (chiSoMoi - chiSoCu) * 2540;
				  }
			}
		}
	}
    
	public void hienThiBienLai() {
		khachHang.hienThiThongTinKhachHang();
		System.out.println("Chỉ số cũ: " + chiSoCu);
		System.out.println("Chỉ số mới: " + chiSoMoi);
		System.out.println("Ngày Tháng Năm: " + NgayThangNam);
		System.out.println("Số tiền phải trả: " + soTienPhaiTra);
	}
}
