package ffse1702_javacore_oop_main;
import ffse1702_javacore_oop2_model.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    NhanVien nv1 = new NhanVien("FFSE1702","ChauNgocKy","25121998",1000000);
    QuanLy ql1 = new QuanLy("FFSE1703","LeVanChuong","1111999",5,2000000);
    
    System.out.println(nv1.maSo + "-" + nv1.tenNV + "-"	+ nv1.getNgaySinh() +	"-" + nv1.getLuong() );
    System.out.println("-----------------------------------------------------");
    System.out.println(ql1.maSo + "-"	+ ql1.tenNV + "-" +	ql1.getNgaySinh() + "-"  +	ql1.getLuong()+"-" + ql1.tinhLuong());
	}

}
