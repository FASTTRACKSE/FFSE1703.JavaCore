package Assignment_list.Asm6.hinhhoc.model;

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
	public void getChuVi() {		
		System.out.println("Chu Vi Hình Tam Giác Là : " + (canhA + canhB +canhC));
	}
	
	public void getDienTich() {		
		System.out.println("Diện Tích Hình Tam Giác Là : "+(0.5*chieuCao*canhDay));
	}
	
}
