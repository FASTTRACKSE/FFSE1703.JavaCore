package namdv.model;

public class Sach {
	private int soLuongTong, soLuongKho;
	private String id, ten, tacGia, namXuanBan, theLoaiSach, nhaXuatBan;

	public Sach() {
		super();
	}

	public Sach(String id, String ten, String tacGia, String namXuanBan, String theLoaiSach, String nhaXuatBan,
			int soLuongTong, int soLuongKho) {
		super();
		this.id = id;
		this.nhaXuatBan = nhaXuatBan;
		this.theLoaiSach = theLoaiSach;
		this.namXuanBan = namXuanBan;
		this.soLuongTong = soLuongTong;
		this.soLuongKho = soLuongKho;
		this.ten = ten;
		this.tacGia = tacGia;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNhaXuatBan() {
		return nhaXuatBan;
	}

	public void setNhaXuatBan(String nhaXuatBan) {
		this.nhaXuatBan = nhaXuatBan;
	}

	public String getTheLoaiSach() {
		return theLoaiSach;
	}

	public void setTheLoaiSach(String theLoaiSach) {
		this.theLoaiSach = theLoaiSach;
	}

	public String getNamXuanBan() {
		return namXuanBan;
	}

	public void setNamXuanBan(String namXuanBan) {
		this.namXuanBan = namXuanBan;
	}

	public int getSoLuongTong() {
		return soLuongTong;
	}

	public void setSoLuongTong(int soLuongTong) {
		this.soLuongTong = soLuongTong;
	}

	public int getSoLuongKho() {
		return soLuongKho;
	}

	public void setSoLuongKho(int soLuongKho) {
		this.soLuongKho = soLuongKho;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getTacGia() {
		return tacGia;
	}

	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}

}