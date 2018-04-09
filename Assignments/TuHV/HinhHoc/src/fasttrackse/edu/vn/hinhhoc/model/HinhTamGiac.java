package fasttrackse.edu.vn.hinhhoc.model;

import fasttrackse.edu.vn.hinhhoc.main.*;

public class HinhTamGiac extends HinhHoc {
	private int CanhA;
	private int CanhB;
	private int CanhC;
	

	public HinhTamGiac() {

	}

	public HinhTamGiac(int CanhA, int CanhB, int CanhC) {
		this.CanhA = CanhA;
		this.CanhB = CanhB;
		this.CanhC = CanhC;
		
	}


	public int getCanhA() {
		return CanhA;
	}

	public void setCanhA(int canhA) {
		CanhA = canhA;
	}

	public int getCanhB() {
		return CanhB;
	}

	public void setCanhB(int canhB) {
		CanhB = canhB;
	}

	public int getCanhC() {
		return CanhC;
	}

	public void setCanhC(int canhC) {
		CanhC = canhC;
	}

	

	public double getChuVi() {
		
		return (CanhA+CanhB+CanhC);
	}

	public double getDienTich() {
		return ((Math.sqrt(CanhA+CanhB+CanhC)*(CanhA+CanhB-CanhC)*(CanhB+CanhC-CanhA)*(CanhC+CanhA-CanhB))/4);

	}

}
