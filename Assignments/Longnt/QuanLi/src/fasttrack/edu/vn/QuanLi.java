package fasttrack.edu.vn;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.ArrayList;
public class QuanLi {
	public static Scanner input = new Scanner(System.in);
	public static SinhVien[] sv = new SinhVien[200];
	public static int tongsosv = 0, n = 0;
	public static String action;
	static ArrayList<SinhVien> arraySinhVien = new ArrayList<SinhVien>();
	public static void main(String[] args) {
		myMenu();
	}

	// nhập số sinh viên
	public static void NhapSV() {
		 String namesv;
		 String ngaysinhsv;
		 float LP1;
		 float LP2;
		 float LP3;
		System.out.println("THÊM SINH VIÊN VÀO DANH SÁCH");
		System.out.println("============================");
		System.out.println("Bạn muốn nhập bao nhiêu sinh viên:");
		n = input.nextInt();
		for (int z = 0; z < n; z++) {
			try {
			input.nextLine();
			System.out.println("Nhập Tên Sinh Viên Thứ  " + (z + 1) + " : ");
			namesv = input.nextLine();
			System.out.println("Nhập Ngày Sinh Cho Sinh Viên Thứ " + (z + 1) + " : ");
			ngaysinhsv = input.nextLine();
			System.out.println("Nhập Điểm LP#1 Cho Sinh Viên Thứ " + (z + 1) + " : ");
			LP1 = input.nextFloat();
		
			System.out.println("Nhập Điểm LP#2 Cho Sinh Viên Thứ " + (z + 1) + " : ");
			LP2 = input.nextFloat();
			System.out.println("Nhập Điểm LP#3 Cho Sinh Viên Thứ " + (z + 1) + " : ");
			LP3 = input.nextFloat();
			arraySinhVien.add(new SinhVien( namesv, ngaysinhsv, LP1, LP2 , LP3 ));
			SinhVien.setTongsv();
			} catch(Exception e) {
				System.out.println(" Nhập sai,vui lòng nhập l!" );
	            System.out.println(" Thank You!" );
	            input.nextLine();	
			}
		}
		action = input.nextLine();
		System.out.println("=====================================");
		System.out.println("-------Nhập ENTER để tiếp tục------");
	}

	// hiển thị sinh viên
	public static void XuatSV() {
		int i = 0;
		System.out.println("-----------DANH SÁCH TẤT CẢ SINH VIÊN-------------");
		System.out.println("==================================================");
		System.out.println("STT\tTên\tNgày Sinh\tĐiểm LP#1\tĐiểm LP#2\tĐiểm LP#3\tĐiểm TB\tXếp Loại");
		System.out.println("--------------------------------------------------");
		int STT =1;
		for (SinhVien x : arraySinhVien) {
			System.out.printf(STT + "\t", STT++);
			System.out.printf("%-10s %-15s %-15s %-10s %10s %15s %-15s \n", x.getNamesv(), x.getNgaysinhsv(), x.getLP1(), x.getLP2(),
					x.getLP3(), x.getDiemTB(), x.getXepLoai());
		}
		System.out.println("số lượng sinh viên " + SinhVien.tongsv);
		action = input.nextLine();
		System.out.println("=====================================");
		System.out.println("-------Nhập ENTER để tiếp tục------");
	}
	//sửa
	public static void edit() {
		System.out.println("Tên Khách Hàng Cần Sửa :");
		String namesv = input.next();
		System.out.println("Tên Khách Hàng Mới :");
		String newnamesv = input.next();
		for (SinhVien x : arraySinhVien) {
			if ((x.getNamesv()).equals(namesv)) {
				x.setNamesv(newnamesv);
			}
		}
	}
	//xóa
	public static void delete() {
		System.out.println("Tên Khách Hàng Cần Xóa :");
		String namesv = input.next();
	    for (int i=0; i<arraySinhVien.size();i++) {
		for (SinhVien x : arraySinhVien) {
			if ((x.getNamesv()).indexOf(namesv) > -1) {
				arraySinhVien.remove(x);
				i--;
				break;
			}	
			}
			}
		}
	public static void search() {
		System.out.println("Tên Khách Hàng Cần Tìm :");
		String namesv = input.next();
		
		for (SinhVien x : arraySinhVien) {
			if ((x.getNamesv()).equals(namesv)) {
				System.out.printf("%-10s %-15s %-15s %-10s %10s %15s %-15s \n", x.getNamesv(), x.getNgaysinhsv(), x.getLP1(), x.getLP2(),
						x.getLP3(), x.getDiemTB(), x.getXepLoai());
			}
		}
	}
	// sinh viên có điểm cao nhất
	public static void SVCaoNhat() {
		System.out.println("-----------SINH VIÊN CÓ ĐIỂM CAO NHẤT-------------");
		System.out.println("==================================================");
		float max = 0;
		int STT;
		for (int i=0; i< arraySinhVien.size(); i++) {
			if(max< arraySinhVien.get(i).getDiemTB()) {
				max = arraySinhVien.get(i).getDiemTB();
				STT =i;
			}
		}
		for(int i=0;i<arraySinhVien.size();i++) {
			if(max<=arraySinhVien.get(i).getDiemTB()) {
				System.out.println("         Là sinh viên:" +"==>>> " + arraySinhVien.get(i).getNamesv()+" <<<==" +"\n" +"Có điểm trung bình " +max +"\n" + "Có số thứ tự là "+(i+1));
			}
		}
		action = input.nextLine();
		System.out.println("=====================================");
		System.out.println("-------Nhập ENTER để tiếp tục------");
	}

	// sinh viên có điểm thấp nhất
	public static void SVThapNhat() {
		System.out.println("-----------SINH VIÊN CÓ ĐIỂM THẤP NHẤT-------------");
		System.out.println("==================================================");
		float min = 0;
		int stt;
		for (int i = 0; i < arraySinhVien.size(); i++) {
			if (min > arraySinhVien.get(i).getDiemTB()) {
				min = arraySinhVien.get(i).getDiemTB();
				stt = i;
			}
		}
		for (int i = 0; i < arraySinhVien.size(); i++) {
			if (min >= arraySinhVien.size()) {
				System.out.println("Là sinh viên:" + "==>>> " + arraySinhVien.get(i).getNamesv() + " <<<==" + "\n"
						+ "Có điểm trung bình " + min + "\n" + "Có số thứ tự là " + (i + 1));
			}
		}
		action = input.nextLine();
		System.out.println("=====================================");
		System.out.println("-------Nhập ENTER để tiếp tục------");
	}

	// sắp Xếp Điểm Trung Bình
	public static void SapXepĐTB() {
		System.out.println("         -------SẮP XẾP SINH VIÊN THEO ĐIỂM TRUNG BÌNH------");
		System.out.println("         =======================================");
		System.out.println("         Stt\t Tên\t Ngày Sinh\t Điểm LP1\t Điểm lp2\t Điểm TB\t Xếp Loại");
			Collections.sort(arraySinhVien, SinhVien.compare);
			int i=0;
			  for(SinhVien x: arraySinhVien){			  
				  	System.out.print("          "+(i+1)+"\t");
				  	System.out.printf("%-10s %-15s %-15s %-10s %10s %15s %-15s \n", x.getNamesv(), x.getNgaysinhsv(), x.getLP1(), x.getLP2(),
							x.getLP3(), x.getDiemTB(), x.getXepLoai());
					i++;
			  }
		action = input.nextLine();
		System.out.println("=====================================");
		System.out.println("-------Nhập ENTER để tiếp tục------");
	}
	// sắp xếp theo tên sinh viên
	public static void SapXepTen() {
		System.out.println("         -------SẮP XẾP SINH VIÊN THEO TÊN------");
		System.out.println("         =======================================");
		System.out.println("         Stt\t Tên\t Ngày Sinh\t Điểm LP1\t Điểm lp2\t Điểm TB\t Xếp Loại");
			Collections.sort(arraySinhVien, SinhVien.compareName);
			int i=0;
			  for(SinhVien x: arraySinhVien){			  
				  	System.out.print("          "+(i+1)+"\t");
				  	System.out.printf("%-10s %-15s %-15s %-10s %10s %15s %-15s \n", x.getNamesv(), x.getNgaysinhsv(), x.getLP1(), x.getLP2(),
							x.getLP3(), x.getDiemTB(), x.getXepLoai());
				  	i++;
			  }
	action = input.nextLine();
	System.out.println("=====================================");
	System.out.println("-------Nhập ENTER để tiếp tục------");
	}
	//kết thúc
	public static void KetThuc() {
		System.out.println("=======Tkank you!======");
		System.exit(0);
	}

	// phần Menu
	public static void myMenu() {
		while (true) {
			try {
			System.out.println("|<-----LỰA CHỌN CHỨC NĂNG------>|");
			System.out.println("| 1. Nhập Danh Sách Sinh Viên   |");
			System.out.println("| 2. Hiển Thị Thông Tin SV      |");
			System.out.println("| 3. Sắp Xếp Điểm Cao nhất   |");
			System.out.println("| 4. Sắp Xếp Điểm thấp nhất  |");
			System.out.println("| 5. Sắp Xếp Theo Điểm TB       |");
			System.out.println("| 6. Sắp Xếp Theo Tên Sinh Viên |");
			System.out.println("| 7. Sửa Tên Sinh Viên          |");
			System.out.println("| 8. Xóa Tên Sinh Viên          |");
			System.out.println("| 9. Tìm kiếm sinh viên          |");
			System.out.println("|=============!!!!==============|");
			System.out.println("| 10. Kết Thúc                   |");
			System.out.println("|<============????=============>|");
			int aye = input.nextInt();
			if (aye == 1) {
				NhapSV();
			} else if (aye == 2) {
				XuatSV();
			} else if (aye == 3) {
				SVCaoNhat();
			} else if (aye == 4) {
				SVThapNhat();
			} else if (aye == 5) {
				SapXepĐTB();
			} else if (aye == 6) {
				SapXepTen();
			} else if (aye == 7){
				edit();
			}else if (aye == 8){
				delete();
			}else if (aye == 9) {
				search();
			}else if (aye == 10){
				KetThuc();
			}else {
                throw new Exception();
         }
		} catch (Exception e) {
            System.out.println(" Chỉ Được Nhập Từ 1 Tới 9!" );
            System.out.println(" Thank You!" );
            input.nextLine();
            
        }
 
		}
	}
}
