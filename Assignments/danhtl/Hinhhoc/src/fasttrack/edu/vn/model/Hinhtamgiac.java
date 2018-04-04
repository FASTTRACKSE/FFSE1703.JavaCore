package fasttrack.edu.vn.model;

import fasttrack.edu.vn.main.*;
import java.util.Scanner;

public class Hinhtamgiac extends Hinhhoc {
	Scanner input = new Scanner(System.in);
	private int canhA;
	private int canhB;
	private int canhC;

	public Hinhtamgiac() {

	}

	public Hinhtamgiac(int canhA, int canhB, int canhC) {
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

	public double getChuVi() {
		return (canhA + canhB + canhC);
	}

	@Override
	public double getDienTich() {

		return ((Math.sqrt(
				(canhA + canhB + canhC) * (canhA + canhB - canhC) * (canhA - canhB + canhC) * (canhB + canhC - canhA)))
				/ 4.0);
	}

}
