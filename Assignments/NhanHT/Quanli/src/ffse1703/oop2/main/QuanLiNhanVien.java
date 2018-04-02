package ffse1703.oop2.main;
import ffse1703.oop2.model.*;
public class QuanLiNhanVien {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NhanVien nv1 = new NhanVien("001","NV","00/00/00",3);
		QuanLy ql1 = new QuanLy("002","QL","00/00/00",3000000,5000000);
		
		System.out.println(nv1.tinhluong());
	}

}
