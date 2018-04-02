package ffse1703.Javacore.oop2.model;
import java.util.Scanner;
public class BienLai extends KhachHang  {
	private double chiSoCu;
	private double chiSoMoi;
	private double soTienPhaiTra;
	private int thang, nam;
	
	

	public BienLai() {
		super();
	}
	
	public BienLai(String maKhachHang, String tenKhachHang, String diaChi, Double maCongTo, Double chiSoCu, Double chiSoMoi,Integer thang, Integer nam) {
		super();
		this.chiSoCu = chiSoCu;
		this.chiSoMoi = chiSoMoi;
		this.thang = thang;
		this.nam = nam;
	}
	
}
	

