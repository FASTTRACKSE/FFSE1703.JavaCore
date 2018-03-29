package ffse1703002.model;

public class BienLai extends KhachHang {
	public float chiSoCu,chiSoMoi;
	public BienLai() {
		super();
	}
	public BienLai(KhachHang khachHang,int maCongTo,float chiSoCu,float chiSoMoi) {
		super();
		this.chiSoCu=chiSoCu;
		this.chiSoMoi=chiSoMoi;
		
	}
	public float tienDien() {
		return(this.chiSoMoi-this.chiSoCu)*3000;
	}
}
