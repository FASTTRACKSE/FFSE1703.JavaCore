package project.model;

public class MayATM {
	private String tenQuan, tenPhuong, tenDuong, maMay, tongTien;
	
	public String getMaMay() {
		return maMay;
	}

	public void setMaMay(String maMay) {
		this.maMay = maMay;
	}

	public String getTongTien() {
		return tongTien;
	}

	public void setTongTien(String tongTien) {
		this.tongTien = tongTien;
	}

	public String getTenQuan() {
		return tenQuan;
	}

	public void setTenQuan(String tenQuan) {
		this.tenQuan = tenQuan;
	}

	public String getTenPhuong() {
		return tenPhuong;
	}

	public void setTenPhuong(String tenPhuong) {
		this.tenPhuong = tenPhuong;
	}

	public String getTenDuong() {
		return tenDuong;
	}

	public void setTenDuong(String tenDuong) {
		this.tenDuong = tenDuong;
	}

	public MayATM() {
		
	}

	public MayATM(String tenQuan, String tenPhuong, String tenDuong,String maMay,String tongTien) {
		super();
		this.tenQuan = tenQuan;
		this.tenPhuong = tenPhuong;
		this.tenDuong = tenDuong;
		this.maMay = maMay;
		this.tongTien = tongTien;
	}

	public void add(String quan, String phuong, String tenDuong, String maMay, String tongTien) {
		// TODO Auto-generated method stub
		this.tenQuan = quan;
		this.tenPhuong = phuong;
		this.tenDuong = tenDuong;
		this.maMay = maMay;
		this.tongTien = tongTien;
	}


}
