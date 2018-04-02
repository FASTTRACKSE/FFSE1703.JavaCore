package ffse1703.Javacore.oop2.model;
import java.util.Scanner;
public class BienLai extends KhachHang  {
	private double chiSoCu;
	private double chiSoMoi;
	private double tongTien;
	private KhachHang KhachHang;
	private double soTienPhaiTra;
	public double getChiSoCu() {
		return chiSoCu;
	}

	public void setChiSoCu(double chiSoCu) {
		this.chiSoCu = chiSoCu;
	}

	public double getChiSoMoi() {
		return chiSoMoi;
	}

	public void setChiSoMoi(double chiSoMoi) {
		this.chiSoMoi = chiSoMoi;
	}

	public BienLai() {
		super();
	}
	
	public BienLai(String maKhachHang, String tenKhachHang, String diaChi, Double maCongTo, Double chiSoCu, Double chiSoMoi) {
		super();
		this.chiSoCu = chiSoCu;
		this.chiSoMoi = chiSoMoi;
	}
	public void nhapBienLai() {
		KhachHang = new KhachHang();
		KhachHang.nhapThongTinKhachHang();

		Scanner scanner = new Scanner(System.in);
		do {
			System.out.print("Nhập chỉ số cũ: ");
			chiSoCu = scanner.nextInt();
			System.out.print("Nhập chỉ số mới: ");
			chiSoMoi = scanner.nextInt();
		} while (chiSoCu > chiSoMoi);

		soTienPhaiTra = (double) (chiSoMoi - chiSoCu) * 3000;
	}

	public void hienThiBienLai() {
		KhachHang.hienThiThongTinKhachHang();
		System.out.println("Chỉ số cũ: " + chiSoCu);
		System.out.println("Chỉ số mới: " + chiSoMoi);
		System.out.println("Số tiền phải trả: " + soTienPhaiTra);
	}
}
	

