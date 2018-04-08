package assignment4;
import java.util.Scanner;
public class dssv {
	public static Scanner sc = new Scanner(System.in);
	public String hoten;
	public int ntnsinh;
	public int lp1;
	public int lp2;
	public int tb;
public dssv(String ht, int ns) {
		hoten = ht;
		ntnsinh = ns;
}
public void nhaptt() {
	
	System.out.println("Họ tên:");
	hoten = sc.nextLine();
	System.out.println("Năm sinh:");
	ntnsinh = sc.nextInt();
	System.out.println("Lp1:");
	lp1 = sc.nextInt();
	System.out.println("Lp2:");
	lp2 = sc.nextInt();
	
}
public void intt() {
	System.out.println("Họ tên"+this.hoten);
	System.out.println("Năm sinh"+this.ntnsinh);
	System.out.println("Lp1"+this.lp1);
	System.out.println("Lp2"+this.lp2);
}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public int getNtnsinh() {
		return ntnsinh;
	}
	public void setNtnsinh(int ntnsinh) {
		this.ntnsinh = ntnsinh;
	}
	public int getLp1() {
		return lp1;
	}
	public void setLp1(int lp1) {
		this.lp1 = lp1;
	}
	public int getLp2() {
		return lp2;
	}
	public void setLp2(int lp2) {
		this.lp2 = lp2;
	}
 
}

