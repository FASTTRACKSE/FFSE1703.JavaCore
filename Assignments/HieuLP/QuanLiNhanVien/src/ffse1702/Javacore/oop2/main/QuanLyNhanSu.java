package ffse1702.Javacore.oop2.main;

import ffse1702.Javacore.oop2.model.*;

public class QuanLyNhanSu {

	public static void main(String[] args) {
		NhanVien nv1 = new NhanVien("FFSE1702 ","Lê Phước Hiếu","12/2/1999",7);
		QuanLy ql1= new QuanLy("FFSE1702", "Hiếu LP","16/2/1999",8,6);
		System.out.println("Mã Số NV         Tên NV              Ngày Sinh      Lương        Thuế thu nhập ");
		System.out.printf("%-17s%-20s%-15s%-13s%-14s\n",nv1.getMasoNV(),nv1.getTenNV(),nv1.getDate(),nv1.getLuong(),nv1.thueThunhap());
		System.out.printf("%-17s%-20s%-15s%-13s%-14s\n",ql1.getMasoNV(),ql1.getTenNV(),ql1.getDate(),ql1.getLuong(),ql1.thueThunhap());

	}

}
