package Assignment_list.Assignment5.Model;

public class BienLai extends KhachHang{
	private int chiSoCu;
	private int chiSoMoi;
	private String ntNam;
	public BienLai() {
		super();
	}
	public BienLai(String maKhachHang,String tenKhachHang,
			   String diaChi,String maCongTo,int chiSoCu,int chiSoMoi,String ntNam) {
		super(maKhachHang,tenKhachHang,diaChi,maCongTo);
		this.chiSoCu=chiSoCu;
		this.chiSoMoi=chiSoMoi;
		this.ntNam=ntNam;
	}
	public String getNtNam() {
		return ntNam;
	}
	public void setNtNam(String ntNam) {
		this.ntNam = ntNam;
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
		return (chiSoMoi-chiSoCu)*3000;
	}
	public String toString() {
		return ("|| "+super.getMaKhachHang() +"\t   " +super.getTenKhachHang() +"\t     " 
				+super.getDiaChi() +"\t\t" +super.getMaCongTo()
				+"\t  "+chiSoCu+"\t   " + chiSoMoi+"\t\t"+getTienDien())+"    "+ntNam;
	}
}
