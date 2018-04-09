package ffse1702010.edu.vn.model;

import java.util.Scanner;

public class HinhTamGiac extends AbstractHinhHoc {
	int canhA;
	int canhB;
	int canhC;
	Scanner input=new Scanner(System.in);
	

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
		return (this.canhA+this.canhB+this.canhC);
		
	}

	public double getDienTich() {
		double q=getChuVi()/2;
		return (Math.sqrt(q*(q-this.canhA)*(q-this.canhB)*(q-this.canhC)));
	}



}
