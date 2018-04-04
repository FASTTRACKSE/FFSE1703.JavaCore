package ffse1702010.edu.vn.model;

import java.util.Scanner;

public class HinhTron extends AbstractHinhHoc {
	public double banKinh;
	Scanner input=new Scanner(System.in);
    public HinhTron() {
    	
    }
	public double getBanKinh() {
		return banKinh;
	}

	public void setBanKinh(double banKinh) {
		this.banKinh = banKinh;
	}
	public HinhTron(double Bankinh) {
		this.banKinh = Bankinh;
	}



	
	public double getChuVi() {
		return (this.banKinh*2*3.14);
	}

	
	public double getDienTich() {
		return (this.banKinh*this.banKinh*3.14);
	}
	
}
