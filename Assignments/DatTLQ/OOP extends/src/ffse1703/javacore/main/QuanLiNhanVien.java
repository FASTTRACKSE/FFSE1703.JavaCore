package ffse1703.javacore.main;
import ffse1703.javacore.model.*;
import java.util.ArrayList;

public class QuanLiNhanVien {

	public static void main(String[] args) {
		NhanVien nv1=new NhanVien("FFSE022","Tong Le Quoc Dat","1/1/1996",5500000);
		QuanLi ql1= new QuanLi("FFSE001","Ho Thanh Nhan","1/1/1998",7000000,2000000);
		
		ArrayList<NhanVien>arrNV=new ArrayList<NhanVien>();
		
		
		
		
		System.out.println(nv1.getMaNhanVien()+"\t"+nv1.getTenNhanVien()+"\t"+nv1.getNgaySinh()+"\t"+nv1.luong()+"\t"+nv1.getThue());
		System.out.println(ql1.getMaNhanVien()+"\t"+ql1.getTenNhanVien()+"\t"+ql1.getNgaySinh()+"\t"+ql1.tinhLuongTN()+"\t"+ql1.tinhThueThuNhap());

	}

}
