package asm5.model;

public class BienLai extends KhachHang{
	private int soMoi;
	private int soCu;
	private int soMoit2;
	private int soMoit3;
	private int soTienTra;
	
	public BienLai() {
		super();
	}

	public BienLai(int soCu,int soMoi) {
		super();
		this.soMoi=soMoi;
		this.soCu=soCu;
	}
	
	public int getSoMoit2() {
		return soMoit2;
	}

	public void setSoMoit2(int soMoit2) {
		this.soMoit2 = soMoit2;
	}

	public int getSoMoit3() {
		return soMoit3;
	}

	public void setSoMoit3(int soMoit3) {
		this.soMoit3 = soMoit3;
	}

	public BienLai(String maK,String tenK,String diaChi,String maCto,int soCu,int soMoi,int thangCk,int namCk) {
		super(maK,tenK,diaChi,maCto);
		
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
		return (getSoMoi() - getSoCu())*3000;
		
	}
	public int tinhTient2() {
		return (getSoMoit2() - getSoMoi()*3000);
	}
	public int tinhTient3() {
		return (getSoMoit3()-getSoMoit2()*3000);
				
					}
}

	


