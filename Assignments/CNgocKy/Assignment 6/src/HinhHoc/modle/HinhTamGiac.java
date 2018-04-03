package HinhHoc.modle;

public class HinhTamGiac extends HinhHoc{
	private int canhA;
	private int canhB;
	private int canhC;
	private int chieuCao;
	private int canhDay;
	public HinhTamGiac() {
		
	}
	public HinhTamGiac(int canhA, int canhB, int canhC, int chieuCao, int canhDay) {
		super();
		this.canhA = canhA;
		this.canhB = canhB;
		this.canhC = canhC;
		this.chieuCao = chieuCao;
		this.canhDay = canhDay;
	}
	public int getCanhA() {
		return canhA;
	}
	public void setCanhA(int canhA) {
		this.canhA = canhA;
	}
	public int getCanhB() {
		return canhB;
	}
	public void setCanhB(int canhB) {
		this.canhB = canhB;
	}
	public int getCanhC() {
		return canhC;
	}
	public void setCanhC(int canhC) {
		this.canhC = canhC;
	}
	public int getChieuCao() {
		return chieuCao;
	}
	public void setChieuCao(int chieuCao) {
		this.chieuCao = chieuCao;
	}
	public int getCanhDay() {
		return canhDay;
	}
	public void setCanhDay(int canhDay) {
		this.canhDay = canhDay;
	}
	public double getChuVi() {		
		return (canhA + canhB +canhC);
	}
	
	public double getDienTich() {		
		return (0.5*chieuCao*canhDay);
	}
}
