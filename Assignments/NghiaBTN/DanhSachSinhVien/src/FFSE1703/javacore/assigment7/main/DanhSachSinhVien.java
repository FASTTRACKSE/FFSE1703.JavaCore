package FFSE1703.javacore.assigment7.main;

import FFSE1703.javacore.assigment7.model.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class DanhSachSinhVien {
	public static Scanner input = new Scanner(System.in);
	public static ArrayList<SinhVien> arrSV = new ArrayList<SinhVien>();
	public static int stt = 0;

	public static void main(String[] args) {
		myMenu();
	}

	public static void NhapSV() {
		System.out.println("THÊM SINH VIÊN VÀO DANH SÁCH");
		System.out.println("============================");
		System.out.println("Nhập số lượng sinh viên!");
		try {
			int size = Integer.parseInt(input.nextLine());
			for (int i = 0; i < size; i++) {
				System.out.println("Nhập tên sinh viên " + (i + 1) + " : ");
				String hoTen = input.nextLine();
				System.out.println("Nhập ngày sinh cho sinh viên " + (i + 1) + " : ");
				String ngaySinh = input.nextLine();
				System.out.println("Nhập Điểm LP1 cho sinh viên " + (i + 1) + " : ");
				float diemLp1 = Float.parseFloat(input.nextLine());
				System.out.println("Nhập Điểm LP2 cho sinh viên " + (i + 1) + " : ");
				float diemLp2 = Float.parseFloat(input.nextLine());
				arrSV.add(new SinhVien(hoTen, ngaySinh, diemLp1, diemLp2));
			}
		} catch (Exception e) {
			System.out.println("Nhập sai định dạng !!!");
			System.out.println("Vui lòng nhập lại");
		}
	}

	public static void InDSSV() {
		System.out.println("DANH SÁCH TẤT CẢ SINH VIÊN");
		System.out.println("==========================");
		System.out.println("Stt\t Tên\t Ngày Sinh\t Điểm LP1\t Điểm lp2\t Điểm TB\t Xếp Loại");
		int i = 0;
		for (SinhVien x : arrSV) {
			System.out.print(" " + (i + 1) + "\t");
			System.out.println(x);
			i++;
		}
	}

	public static void TopSV() {
		System.out.println("-----------SINH VIÊN CÓ ĐIỂM CAO NHẤT-------------");
		System.out.println("==================================================");
		float max = 0;
		int stt;
		for (int i = 0; i < arrSV.size(); i++) {
			if (max < arrSV.get(i).getDiemTB()) {
				max = arrSV.get(i).getDiemTB();
				stt = i;
			}
		}
		for (int i = 0; i < arrSV.size(); i++) {
			if (max <= arrSV.get(i).getDiemTB()) {
				System.out.println("Sinh viên:" + "==>>> " + arrSV.get(i).getHoTen() + " <<<==" + "\n"
						+ "Điểm trung bình " + max + "\n" + "Số thứ tự là " + (i + 1));
			}
		}
	}

	public static void SXDiemSV() {
		System.out.println("-------SẮP XẾP SINH VIÊN TĂNG DẦN THEO ĐIỂM TB------");
		System.out.println("====================================================");
		System.out.println("Stt\t Tên\t Ngày Sinh\t Điểm LP1\t Điểm lp2\t Điểm TB\t Xếp Loại");
		Collections.sort(arrSV, SinhVien.compare);
		int i = 0;
		for (SinhVien x : arrSV) {
			System.out.print(" " + (i + 1) + "\t");
			System.out.println(x);
			i++;
		}
	}

	public static void SXTenSV() {
		System.out.println("-------SẮP XẾP SINH VIÊN THEO TÊN------");
		System.out.println("=======================================");
		System.out.println("Stt\t Tên\t Ngày Sinh\t Điểm LP1\t Điểm lp2\t Điểm TB\t Xếp Loại");
		Collections.sort(arrSV, SinhVien.compareName);
		int i = 0;
		for (SinhVien x : arrSV) {
			System.out.print(" " + (i + 1) + "\t");
			System.out.println(x);
			i++;
		}
	}

	public static void TimKiemSV() {
		System.out.println("-------IN DANH SÁCH THEO TÊN------");
		System.out.println("==================================");
		System.out.print("Gõ tên sinh viên mà bạn muốn in: ");
		String act = input.nextLine();
		int i = 0;
		try {
			System.out.println("Stt\t Tên\t Ngày Sinh\t Điểm LP1\t Điểm lp2\t Điểm TB\t Xếp Loại");
			for (SinhVien x : arrSV) {
				if (act.equals(x.getHoTen())) {
					System.out.print(" " + (i + 1) + "\t");
					System.out.println(x);
					i++;
				} else {
					throw new Exception();
				}
			}
		} catch (Exception e) {
			System.out.println();
		}

	}

	public static void DoiTenSV() {
		System.out.println("Stt\t Tên\t Ngày Sinh\t Điểm LP1\t Điểm lp2\t Điểm TB\t Xếp Loại");
		int i = 0;
		for (SinhVien x : arrSV) {
			System.out.print(" " + (i + 1) + "\t");
			System.out.println(x);
			i++;
		}
		System.out.print("Bạn muốn thay đổi tên của sinh viên bao nhiêu : ");
		try {
			int act = Integer.parseInt(input.nextLine());
			try {
				if ((act) <= arrSV.size()) {
					System.out.print("Nhập tên mà bạn muốn thay đổi : ");
					String hoTen = input.nextLine();
					arrSV.get((act - 1)).setHoTen(hoTen);
					System.out.println("Đã thay đổi thành công sinh viên thứ : " + act);
					System.out.println(arrSV.get((act - 1)).toString());
				} else {
					throw new Exception();
				}
			} catch (Exception e) {
				System.out.println("Chỉ nhập từ 1 tới " + arrSV.size());
			}
		} catch (Exception e) {
			System.out.println("Nhập sai định dạng !");
			System.out.println("Vui lòng nhập lại!");
		}
	}

	public static void XoaSV() {
		System.out.println("         Stt\t Tên\t Ngày Sinh\t Điểm LP1\t Điểm lp2\t Điểm TB\t Xếp Loại");
		int i=0;
		for(SinhVien x :arrSV) {			
			System.out.print("          "+(i+1)+"\t");
			System.out.println(x);
			i++;
		}
		System.out.print("         Nhập tên sinh viên mà bạn muốn xóa : ");
		String ten = input.nextLine();					
			for(i=0;i<arrSV.size();i++) {
				if(ten.equals(arrSV.get(i).getHoTen())) {				
					arrSV.remove(i);
					i--;
				}
			}					
		System.out.println("         XÓA THÀNH CÔNG sinh viên có tên : "+ten);			
		System.out.println("         Stt\t Tên\t Ngày Sinh\t Điểm LP1\t Điểm lp2\t Điểm TB\t Xếp Loại");
		int j=0;
		for(SinhVien x :arrSV) {		
			System.out.print("          "+(j+1)+"\t");
			System.out.println(x);
			j++;
		}
	}
	public static void endSV() {
		System.out.println("         Kết thúc chương trình");
		System.out.println("         ======================");
		System.out.println("         =======Tkank you======");
		System.exit(0);
	}

	public static void endSv() {
		System.out.println("Kết thúc chương trình");
		System.out.println("======================");
		System.out.println("=======Tkank you======");
		System.exit(0);
	}

	public static void myMenu() {
		while (true) {
			try {
				System.out.println("         ____________________________");
				System.out.println("         |  CHỌN LỰA CÁC CHỨC NĂNG  |");
				System.out.println("         |1.Nhập danh sinh viên     |");
				System.out.println("         |2.In danh sách sinh viên  |");
				System.out.println("         |3.Top sinh viên           |");
				System.out.println("         |4.Sắp xếp theo tăng dần   |");
				System.out.println("         |5.Sắp xếp theo Tên        |");
				System.out.println("         |6.Tìm kiếm sinh viên      |");
				System.out.println("         |7.Đổi tên sinh viên       |");
				System.out.println("         |8.Xóa sinh viên theo tên  |");
				System.out.println("         |9.Kết thúc chương trình   |");
				System.out.println("         |__________________________|");
				System.out.print("     Nhập chức năng mà bạn muốn thực hiện :");
				int act = Integer.parseInt(input.nextLine());
				if (act == 1) {
					NhapSV();
				} else if (act == 2) {
					InDSSV();
				} else if (act == 3) {
					TopSV();
				} else if (act == 4) {
					SXDiemSV();
				} else if (act == 5) {
					SXTenSV();
				} else if (act == 6) {
					TimKiemSV();
				} else if (act == 7) {
					DoiTenSV();
				} else if (act == 8) {
					XoaSV();
				} else {
					throw new Exception();
				}
			} catch (NumberFormatException e) {
				System.out.println("Vui Lòng nhập số");
			} catch (Exception e) {
				System.out.println("Chỉ Được Nhập từ 1 đến 8, Hãy nhập lại!");
			}
			System.out.println("=====================================");
			System.out.println("-------Nhập ENTER để tiếp tục------");
			input.nextLine();
		}
	}

}