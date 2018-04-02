package ffse1703.javacore.main;
import java.util.ArrayList;
import java.util.Scanner;
import ffse1703.javacore.model.*;

public class QuanLiNhanVien {

	public static void main(String[] args) {
		Scanner myInput = new Scanner(System.in);
		NhanVien nv1 = new NhanVien(1703, "Phạm Văn Quý", "5/5/1999", 9);
		NhanVien nv2 = new NhanVien(1702, "Phạm Văn Châu", "5/5/1970", 2);
		QuanLi ql1 = new QuanLi(1701, "Cao Lê Thành", "5/5/1999", 9, 1000000 );

		System.out.println(nv1.getMaNhanVien() + " " + nv1.gettenNhanVien() + " " + nv1.getNamSinh() + " "
				+ nv1.getHsLuong() + " " + nv1.tinhLuong() + " " + nv1.getThue());
		System.out.println(ql1.getMaNhanVien() + " " + ql1.tinhLuongTN() + " " + ql1.tinhThueThuNhap());
		
		
		ArrayList<NhanVien> arrNhanVien = new ArrayList<NhanVien>();
		ArrayList<QuanLi> arrQuanLi = new ArrayList<QuanLi>();
	    arrNhanVien.add(nv1);
		arrNhanVien.add(nv2);
		arrNhanVien.add(ql1);
		
		
		
		
		
		for(NhanVien k: arrNhanVien) {
			if(k instanceof QuanLi) {
				System.out.println("Nhân Viên: " + k.gettenNhanVien());
			}
			
		}
		
//		for(int i = 0; i < arrNhanVien.size(); i++) {
//			System.out.println(arrNhanVien.get(i).gettenNhanVien()); 
//		}
		
		
		
		
			
		
	}

}
