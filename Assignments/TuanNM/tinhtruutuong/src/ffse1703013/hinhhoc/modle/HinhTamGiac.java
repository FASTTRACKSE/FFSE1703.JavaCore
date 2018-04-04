package ffse1703013.hinhhoc.modle;

public class HinhTamGiac extends HinhHoc{
	private Double canhA;
	private Double canhB;
	private Double canhC;
	private String ten;
	
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public HinhTamGiac() {
		
	}
	public HinhTamGiac(String ten,Double canhA, Double canhB, Double canhC) {
		this.ten = ten;
		this.canhA = canhA;
		this.canhB = canhB;
		this.canhC = canhC;
	}
	public Double getCanhA() {
		return canhA;
	}
	public void setCanhA(Double canhA) {
		this.canhA = canhA;
	}
	public Double getCanhB() {
		return canhB;
	}
	public void setCanhB(Double canhB) {
		this.canhB = canhB;
	}
	public Double getCanhC() {
		return canhC;
	}
	public void setCanhC(Double canhC) {
		this.canhC = canhC;
	}
	public Double getChuVi() {
		return this.canhA+this.canhB+this.canhC;
	}
	public Double getDienTich() {
		Double p = (this.canhA+this.canhB+this.canhC)/2;
		return Math.sqrt(p*(p-this.canhA)*(p-this.canhB)*(p-this.canhC));
	}
}
