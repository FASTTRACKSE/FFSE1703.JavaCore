package fasttrack.edu.vn.quanlydien.models;

public class BienLai extends KhachHang {
	private int thangTinhChuKy;
	private int namTinhChuKy;
	private int soDienDauKy;
	private int soDienCuoiKy;

	public BienLai() {
		super();
	}

	public BienLai(KhachHang kh, int thangTinhChuKy, int namTinhChuKy, int soDienDauKy, int soDienCuoiKy) {
		super(kh.getMaKhachHang(), kh.getTenKhachHang(), kh.getDcKhachHang(), kh.getMaCongToDien());

		this.thangTinhChuKy = thangTinhChuKy;
		this.namTinhChuKy = namTinhChuKy;
		this.soDienDauKy = soDienDauKy;
		this.soDienCuoiKy = soDienCuoiKy;
	}

	public BienLai(String maKhachHang, String tenKhachHang, String dcKhachHang, String maCongToDien, int thangTinhChuKy,
			int namTinhChuKy, int soDienDauKy, int soDienCuoiKy) {
		super(maKhachHang, tenKhachHang, dcKhachHang, maCongToDien);

		this.thangTinhChuKy = thangTinhChuKy;
		this.namTinhChuKy = namTinhChuKy;
		this.soDienDauKy = soDienDauKy;
		this.soDienCuoiKy = soDienCuoiKy;
	}

	public int getThangTinhChuKy() {
		return thangTinhChuKy;
	}

	public void setThangTinhChuKy(int thangTinhChuKy) {
		this.thangTinhChuKy = thangTinhChuKy;
	}

	public int getNamTinhChuKy() {
		return namTinhChuKy;
	}

	public void setNamTinhChuKy(int namTinhChuKy) {
		this.namTinhChuKy = namTinhChuKy;
	}

	public int getSoDienDauKy() {
		return soDienDauKy;
	}

	public void setSoDienDauKy(int soDienDauKy) {
		this.soDienDauKy = soDienDauKy;
	}

	public int getSoDienCuoiKy() {
		return soDienCuoiKy;
	}

	public void setSoDienCuoiKy(int soDienCuoiKy) {
		this.soDienCuoiKy = soDienCuoiKy;
	}

	public long tinhTienTieuThu() {
		return (long) (soDienCuoiKy - soDienDauKy) * 3000;
	}
}
