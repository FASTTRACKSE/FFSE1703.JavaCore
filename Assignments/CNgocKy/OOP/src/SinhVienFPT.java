
public abstract class SinhVienFPT {
String hoTen;
String nganh;
abstract double getDiem();
String getHocluc() {
	String hocluc = "";
	if (getDiem()< 5) hocluc = "yeu";
	else if (getDiem()< 6.5) hocluc = "Tb";
	else if (getDiem()< 8) hocluc = "kha";
	else hocluc = "gioi";
	
	return hocluc;
}
void xuat() {
	System.out.println("Hoten : "+ this.hoten);
	System.out.println("Nghanh : "+ this.nghanh);
	System.out.println("Diem : "+ this.getDiem);
	System.out.println("Hocluc : "+ this.getHocluc);
}
}
