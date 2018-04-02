package Assignment_list.Assignment5.Model;

public class BienLai extends KhachHang{
	private int chiSoCu;
	private int chiSoMoi;
	private int blThang;
	private int blNam;
	public BienLai() {
		super();
	}
	public BienLai(String maKhachHang,String tenKhachHang,
			   String diaChi,String maCongTo,int chiSoCu,int chiSoMoi,int blThang,int blNam) {
		super(maKhachHang,tenKhachHang,diaChi,maCongTo);
		this.chiSoCu=chiSoCu;
		this.chiSoMoi=chiSoMoi;
		this.blThang=blThang;
		this.blNam=blNam;
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
	
	public int getBlThang() {
		return blThang;
	}
	public void setBlThang(int blThang) {
		this.blThang = blThang;
	}
	public int getBlNam() {
		return blNam;
	}
	public void setBlNam(int blNam) {
		this.blNam = blNam;
	}
	public int getTienDien() {
		return (chiSoMoi-chiSoCu)*3000;
	}
	
	public String toString() {
		return ("|| "+super.getMaKhachHang() +"\t   " +super.getTenKhachHang() +"\t     " 
				+super.getDiaChi() +"\t\t" +super.getMaCongTo()
				+"\t  "+chiSoCu+"\t   " + chiSoMoi+"\t\t"+getTienDien()+"\t"+blThang+"\t"+blNam);
	}
}
