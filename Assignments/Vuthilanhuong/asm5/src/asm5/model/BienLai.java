package asm5.model;

public class BienLai extends KhachHang{
	private int thangCk;
	private int namCk;
	private int soMoi;
	private int soCu;
	private int soTienTra;
	
	public BienLai() {
		super();
	}

	public BienLai(int soCu,int soMoi) {
		super();
		this.soMoi=soMoi;
		this.soCu=soCu;
	}

	public BienLai(String maK,String tenK,String diaChi,String maCto,int soCu,int soMoi,int thangCk,int namCk) {
		super(maK,tenK,diaChi,maCto);
		this.namCk = namCk;
		this.thangCk = thangCk;
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
	public int getThangCk() {
		return thangCk;
	}

	public void setThangCk(int thangCk) {
		this.thangCk = thangCk;
	}

	public int getNamCk() {
		return namCk;
	}

	public void setNamCk(int namCk) {
		this.namCk = namCk;
	}
	public int tinhTien() {
		return (getSoMoi() - getSoCu())*3000;
		
	}
}

	


