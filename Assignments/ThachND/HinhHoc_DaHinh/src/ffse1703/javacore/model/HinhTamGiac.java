package ffse1703.javacore.model;

abstract public class HinhTamGiac extends HinhHoc {
	protected int canhA, canhB, canhC;
	 
    public HinhTamGiac(int canhA, int canhB, int canhC) {
        super();
        this.canhA = canhA;
        this.canhB = canhB;
        this.canhC = canhC;
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
	public double getNuaChuVi() {
		return (canhA + canhB + canhC)/2;
	}
	public double getChuVi() {
		return canhA + canhB + canhC;
	}
	public double getDientich() {
		return ;
		
	}
}

