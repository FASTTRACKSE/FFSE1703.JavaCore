package model;

public class BienLai extends KhachHang{
	private int soMoi;
	private int soCu;
	
	public BienLai() {
		super();
	}
	public BienLai(String tenKhach,String diaChi,String sdt,String maCto,int soCu, int soMoi) {
		super(tenKhach,diaChi,sdt,maCto);
		this.soMoi = soMoi;
		this.soCu = soCu;
	}
	public int getSoMoi() {
		return soMoi;
	}
	public void setSoMoi(int soMoi) {
		this.soMoi = soMoi;
	}
	public int getSoCu() {
		return soCu;
	}
	public void setSoCu(int soCu) {
		this.soCu = soCu;
	}
	public int tinhTien() {
		return (getSoMoi()-getSoCu()*3000);
	}
}
