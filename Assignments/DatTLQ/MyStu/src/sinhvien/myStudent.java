package sinhvien;
import java.util.Scanner;
public class myStudent {
	public  String stuName;
	public  String stuDate;
	public double DLP1;
	public  double DLP2;
	public int i;
	
	
	
	
	public void setStuName(String name) {
		this.stuName = name;
	}
	public String getStuName() {
		return this.stuName;
	}
	public void setStuDate(String name) {
		this.stuDate = name;
	}
	public String getStuDate() {
		return this.stuDate;
	}
	public void setDLP1(double diem1) {
		this.DLP1 = diem1;
	}
	public double getDLP1() {
		return this.DLP1;
	}
	public void setDLP2(double diem2) {
		this.DLP2 = diem2;
	}
	public double getDLP2() {
		return this.DLP2;
	}
	public double DTB() {
		return ((this.DLP1)+(this.DLP2))/2;
	}
	
		
	public void nhap () {
		Scanner scanner= new Scanner(System.in);
		
		System.out.println("Nhap ten sinh vien"  + ":");
		stuName = scanner.nextLine();
		System.out.println("Ngay sinh sinh vien"  + ":");
		stuDate = scanner.nextLine();
		System.out.println("Nhap diem LP1 cua sinh vien "  + ":");
		DLP1 = scanner.nextDouble();
		System.out.println("Nhap diem LP2 cua sinh vien "  + ":");
		DLP2 = scanner.nextDouble();

	}
	public void xeploai() {
		if (this.DTB()>8.5&&this.DTB()<10) {
			System.out.println("GIOI");
		}else if(this.DTB()>7&&this.DTB()<8.4) {
			System.out.println("Kha");
		}else if(this.DTB()>5&&this.DTB()<6.9) {
			System.out.println("Trung Binh");
		}else {
			System.out.println("Kem");
		}
	}


}
