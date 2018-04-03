package ffse1703.edu.vn.model;

public class HinhTamGiac extends HinhHoc {
	private int canhA;
	private int canhB;
	private int canhC;
	private int chieuCao;
	private int canhDay;
	public HinhTamGiac() {
		
	}
	public HinhTamGiac(int chieuCao,int canhDay) {
		this.chieuCao=chieuCao;
		this.canhDay=canhDay;
	}
	public HinhTamGiac(int canhA,int canhB,int canhC) {
		this.canhA=canhA;
		this.canhB=canhB;
		this.canhC=canhC;
		
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

	public double getChuVi() {		
		return (canhA + canhB + canhC);
	
	}
	
	public double getDienTich() {		
		double q = getChuVi()/2;
		return (Math.sqrt(q*(q-canhA)*(q-canhB)*(q-canhC)));
	}
	
}