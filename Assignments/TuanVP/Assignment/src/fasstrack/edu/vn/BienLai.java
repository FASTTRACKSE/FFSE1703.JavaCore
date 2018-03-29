package fasstrack.edu.vn;

public class BienLai extends KhachHang {
	
	private int chiSoCu;
	private int chiSoMoi;
	
	public BienLai() {
		super();
	}
	public BienLai(String maKH,String tenKH,String diaChiKH,String maCT, int chiSoCu,int chiSoMoi) {
		super(maKH,tenKH,diaChiKH,maCT);
		this.chiSoCu = chiSoCu;
		this.chiSoMoi = chiSoMoi;
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
	public int tinhTienDien() {
		return (this.chiSoMoi - this.chiSoCu)*3000;
	}
}
