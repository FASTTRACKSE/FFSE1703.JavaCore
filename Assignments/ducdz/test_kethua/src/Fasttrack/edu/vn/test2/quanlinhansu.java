package Fasttrack.edu.vn.test2;
import Fasttrack.edu.vn.test.*;
public class quanlinhansu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		nhanvien nv1=new nhanvien(101,"nhanvienmoi",1998,50000);
		quanly ql1=new quanly(102,"quanlymoi",1995,70000,10000);
		System.out.println(nv1.get_maso_nhanvien()+nv1.get_ten_nhanvien()+nv1.get_namsinh_nhanvien()+nv1.get_luong_nhanvien());
		System.out.println(ql1.get_maso_nhanvien()+ql1.get_ten_nhanvien()+ql1.get_namsinh_nhanvien()+ql1.get_luong_nhanvien()+ql1.luong_trach_nhiem());
	}

}
