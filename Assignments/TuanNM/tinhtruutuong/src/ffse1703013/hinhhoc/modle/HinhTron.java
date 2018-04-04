package ffse1703013.hinhhoc.modle;

public class HinhTron extends HinhHoc{
	private Double banKinh;
	private String ten;
	
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public HinhTron() {
		
	}
	public HinhTron(String ten,Double r) {
		this.ten = ten;
		this.banKinh = r;
	}
	public Double getR() {
		return banKinh;
	}
	public void setR(Double r) {
		this.banKinh = r;
	}
	public Double getChuVi() {
		return 2*this.banKinh*3.14;
	}
	public Double getDienTich() {
		return this.banKinh*this.banKinh *3.14;
	}
}
