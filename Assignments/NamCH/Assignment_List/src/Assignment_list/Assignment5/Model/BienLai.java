package Assignment_list.Assignment5.Model;

public class BienLai extends KhachHang{
	private int chiSoCu;
	private int chiSoMoi;
	public BienLai(String maKhachHang,String tenKhachHang,
			   String diaChi,String maCongTo) {
		super(maKhachHang,tenKhachHang,diaChi,maCongTo);
	}
	public BienLai(int chiSoCu,int chiSoMoi) {		
		this.chiSoCu=chiSoCu;
		this.chiSoMoi=chiSoMoi;
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
	public int getTienDien() {
		return (getChiSoMoi()-getChiSoCu())*3000;
	}
	public String toString() {
		return ("|| "+super.getMaKhachHang() +"\t   " +super.getTenKhachHang() +"\t     " 
				+super.getDiaChi() +"\t\t" +super.getMaCongTo()
				+"\t    "+getChiSoCu()+"\t        " + getChiSoMoi()+"\t       "+getTienDien());
	}
}
