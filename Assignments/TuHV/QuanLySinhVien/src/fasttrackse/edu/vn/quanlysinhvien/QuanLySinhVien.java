package fasttrackse.edu.vn.quanlysinhvien;

public class QuanLySinhVien {

	public static void main(String[] args) {
		SinhVien SV1, SV2, SV3;
		SinhVien[] arrMySV;

		SV1 = new SinhVien();
		SV1.setSVten("Hồ Viết Tú");
		SV1.setSVngaysinh("09/01/99");
		SV1.setSVLP1(9);
		SV1.setSVLP2(8);

		SV2 = new SinhVien();
		SV2.setSVten("Hồ Quang Minh");
		SV2.setSVngaysinh("12/09/99");
		SV2.setSVLP1(8);
		SV2.setSVLP2(7);

		SV3 = new SinhVien();
		SV3.setSVten("Lê Phước Hiếu");
		SV3.setSVngaysinh("08/07/99");
		SV3.setSVLP1(5);
		SV3.setSVLP2(4);

		arrMySV = new SinhVien[10];
		arrMySV[0] = SV1;
		arrMySV[1] = SV2;
		arrMySV[2] = SV3;

		System.out.println("Số điểm ĐTB của các sinh viên là :");
		for (int i = 0; i < 3; i++) {
			System.out.println(
					(i + 1) + ".SVten:" + arrMySV[i].getSVten() +"-SVngaysinh" + arrMySV[i].getSVngaysinh() + "- Điểm Trung Bình :" + arrMySV[i].getSVDTB() + "-Xếp Loại :" +arrMySV[i].getSVxeploai());

		}

	}

}
