package ffse1703.javacore.oop2.main;
import java.lang.*;
import ffse1703.javacore.oop2.model.*;
import java.util.Scanner;

public class Quanlinhansu {
		int num1=1;
		static NhanVien nv1 = new NhanVien("FFSE001","Bùi Thế Nghĩa","1/1/99",1);
		static NhanVien nv2 = new NhanVien("FFSE001","Bùi Thế Nghĩa","1/1/99",1);
		Quanlinhanvien ql1 = new Quanlinhanvien("FFSE002","Bùi Thế Tiến","22/2/99",5,2000000);
		public static void main(String args[]) {
			System.out.print(nv1);
			nv1.HienThi();
			double sotien = nv1.ThueThuNhap();
			System.out.println(sotien);
		}

		
}
