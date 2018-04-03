import java.util.Scanner;

public abstract class SinhVienIT {
double diemJava;
double diemCSS;
double diemHTML;

public SinhVienIT(String hoten, String nghanh) {
	super (hoten,"IT");
	this.diemJava = diemJava;
	this.diemCSS = diemCSS;
	this.diemHTML = diemHTML;
	
}
double getDiem() {
	
	return(2*this.diemJava + this.diemCSS + this.diemHTML)/4;
}
public static void main(String arg []) {
  System.out.println("Nhap sinh vien");
  System.out.print("Nhap ho ten: ");
  Scanner nhaphoten = new Scanner(System.in);
  String hoten = nhaphoten.nextLine();
  
  Scanner nhapDiem = new Scanner(System.in);
  System.out.print("Nhap diem Java: ");
  double diemJava = nhapDiem.nextDouble();
  
  System.out.print("Nhap diem CSS: ");
  double diemCSS = nhapDiem.nextDouble();
  
  System.out.print("Nhap diem HTML: ");
  double diemHTML = nhapDiem.nextDouble();
  
  
  SinhVienFPT sinhvien = new SinhVienIT(hoten,diemJava,diemCSS,diemHTML); 
 
  System.out.print("xuat ra man hinh");
  sinhvien.xuat();
  
}
}
