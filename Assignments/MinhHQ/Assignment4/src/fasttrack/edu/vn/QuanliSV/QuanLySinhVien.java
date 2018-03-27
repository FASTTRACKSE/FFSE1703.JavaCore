package fasttrack.edu.vn.QuanliSV;

public class QuanLySinhVien {
	static void main(String[] args) {
		
		SinhVien sv1,sv2,sv3;
		//nhập sinh viên 1
		sv1 = new SinhVien();
		sv1.setName("Hồ Quang Minh");
		sv1.setDay("30/10/99");
		sv1.setLp1(8.0);
		sv1.setLp2(7.0);
		
		//nhập sinh viên 2
		sv2 = new SinhVien();
		sv2.setName("Nguyễn Thanh Hiếu");
		sv2.setDay("30/10/99");
		sv2.setLp1(8.0);
		sv2.setLp2(6.0);
		
		//nhập sinh viên 3
		sv3 = new SinhVien();
		sv2.setName("Lê Phước Hiếu");
		sv2.setDay("30/10/99");
		sv2.setLp1(9.0);
		sv2.setLp2(8.0);
		
		SinhVien[] SV = new SinhVien[4];
		SV[0] = sv1;
		SV[1] = sv2;
		SV[2] = sv3;
		
		for (int i = 0; i < 3; i++) {
			System.out.printf("%-5s%-23s%-14s%-5s%-5s%-5s\n", (i + 1), SV[i].getName() , SV[i].getDay(),SV[i].getLp1(),SV[i].getLp2(),SV[i].getDTB() );
		}
	}

}
