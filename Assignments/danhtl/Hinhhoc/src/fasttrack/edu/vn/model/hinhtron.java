package fasttrack.edu.vn.model;

import fasttrack.edu.vn.main.*;
import java.util.Scanner;

public class hinhtron extends Hinhhoc {
	private int bankinh;

	public hinhtron() {

	}

	public hinhtron(int bankinh) {
		this.bankinh = bankinh;
	}

	public int getBankinh() {
		return bankinh;
	}

	public void setBankinh(int bankinh) {
		this.bankinh = bankinh;
	}

	public double getChuVi() {
		return (bankinh * 2 * 3.14);
	}

	public double getDienTich() {

		return (bankinh * bankinh * 3.14);
	}

}
