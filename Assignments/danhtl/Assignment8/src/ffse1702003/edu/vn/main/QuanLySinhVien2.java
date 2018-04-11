package ffse1702003.edu.vn.main;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import ffse1702003.edu.vn.io.TextFileFactory;
import ffse1702003.edu.vn.model.SinhVien;
public class QuanLySinhVien2 {
	public static Scanner myScanner = new Scanner(System.in);
    public static ArrayList<SinhVien> arrbangsv = new ArrayList<SinhVien>();
	public static int i, n = 4;
	public static SinhVien[] SV = new SinhVien[4];
	
	public static void main(String[] args) {
		showMyMenu();
	}
	public static void showMyMenu() {
		while (true) {
                    try {
			System.out.println(">>         MENU QUẢN LÝ SINH VIÊN       <<");
			System.out.println("+----------------------------------------+");
			System.out.println("|1. Nhập danh sách sinh viên             |");
			System.out.println("|2. In danh sách sinh viên               |");
			System.out.println("|3. Top sinh viên                        |");
			System.out.println("|4. Sắp xếp theo điểm TBM                |");
			System.out.println("|5. Sắp xếp theo Tên                     |");
			System.out.println("|6. Xóa sinh viên                        |");
			System.out.println("|7. Sửa Tên sinh viên                    |");
			System.out.println("|8. Kết thúc chương trình                |");
			System.out.println("+----------------------------------------+");
			System.out.println(">>            Lựa chọn của bạn?         <<");
			// .compareTo để so sánh chuỗi trong trường hợp sắp xếp theo tên
			int myOption = myScanner.nextInt();
			if (myOption == 1) {
				nhapDSSV();
			} else if (myOption == 2) {
				in();
			} else if (myOption == 3) {
				topSV();
			} else if (myOption == 4) {
				sapxepTBM();
			} else if (myOption == 5) {
				sapxepTen();
			} 
			else if (myOption == 6) {
				xoa();
			} else if (myOption == 7) {
				Sua();
			} 
			else if (myOption == 8) {
				ketThuc();
			} else {
                throw new Exception();
         } } catch (Exception e) {
                System.out.println("Chi duoc nhap tu 1 den 8, hay nhap lai nhe ban!!!");
                myScanner.nextLine();
          }
                    showMyMenu();
                    }
		}
	public static void nhapDSSV() {

		try {
			System.out.println("Nhập danh sách sinh viên : ");
			System.out.println("---------------------------");
			System.out.print("Số lượng sinh viên :");
			
			Path path = Paths.get("dulieu2.txt");
			
		if(Files.exists(path)) {
			arrbangsv = TextFileFactory.docFile("dulieu2.txt");
			
		} else {
			arrbangsv = new ArrayList<SinhVien>();
		}
			
			n=myScanner.nextInt(); 
			
			for (i = 0; i < n; i++) {	
				myScanner.nextLine();
				System.out.print("Tên Sinh Viên :");
				String Name = myScanner.nextLine();
                
				System.out.print("Ngày sinh  :");
				String Date = myScanner.nextLine();
         
				System.out.print("Điểm môn LP1 :");
				double Lp1 = myScanner.nextDouble();

				System.out.print("Điểm môn LP2 :");
				double Lp2 = myScanner.nextDouble();

				arrbangsv.add(new SinhVien(Name,Date,Lp1, Lp2 ));
				SinhVien.tongsv();
				boolean checked= TextFileFactory.luuFile(arrbangsv, "dulieu2.txt");
				if (checked == true) {
					System.out.println("Đã lưu thông tin của "+ (i+1) +" sinh viên");
				} else {
					System.out.println("Lưu thất bại");
				}
			}
			}
        catch (Exception e) {
             System.out.println(" Phần điểm chỉ được nhập  số :)");
             
             myScanner.nextLine();
             nhapDSSV();
       }
		
		
		myScanner.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		myScanner.nextLine();
}
	public static void topSV() {
		double min = SV[0].getTBM(), max = min;
		int x = 0, y = 0;

		for (i = 0; i <arrbangsv.size(); i++) {
			if (min > arrbangsv.get(i).getTBM()) {
				min = arrbangsv.get(i).getTBM();
				x = i;
			}
			if (max < arrbangsv.get(i).getTBM()) {
				max = arrbangsv.get(i).getTBM();
				y = i;
			}
		}

		System.out.println("Học sinh có kết quả học tập cao nhất là :");
		System.out.printf("%-23s%-14s%-5s%-5s%-5s\n", arrbangsv.get(y).getName(), arrbangsv.get(y).getDate(), arrbangsv.get(y).getLp1(), arrbangsv.get(y).getLp2(),
				arrbangsv.get(y).getTBM());

		System.out.println("Học sinh có kết quả học tập thấp nhất là :");
		System.out.printf("%-23s%-14s%-5s%-5s%-5s\n", arrbangsv.get(x).getName(), arrbangsv.get(x).getDate(), arrbangsv.get(x).getLp1(), arrbangsv.get(x).getLp2(),
				arrbangsv.get(x).getTBM());
		myScanner.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		myScanner.nextLine();

	}

	public static void sapxepTBM() {
		SinhVien[] temp = new SinhVien[n];
		for (i = 0; i <arrbangsv.size()- 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (arrbangsv.get(i).getTBM() < arrbangsv.get(j).getTBM()) {
					temp[i] = arrbangsv.get(j);
					arrbangsv.set(j, arrbangsv.get(i));
					arrbangsv.set(i , temp[i]);
				}
			
		}}}
	public static void in() {
		System.out.println("Danh sách sinh viên đã được sắp xếp theo điểm trung bình ");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("STT  Họ và tên              Ngày sinh     lp1  lp2  ĐTB  Xếp Loại  ");
		System.out.println("--------------------------------------------------------------------");


		
		for (i = 0; i < arrbangsv.size(); i++) {
			System.out.printf("%-5s%-23s%-14s%-5s%-5s%-5s%-10s\n", (i + 1),arrbangsv.get(i).getName(), arrbangsv.get(i).getDate(),
					arrbangsv.get(i).getLp1(),  arrbangsv.get(i).getLp2(), arrbangsv.get(i).getTBM(), arrbangsv.get(i).XepLoai());
		}
	

	myScanner.nextLine();
	System.out.println("Ấn Enter để về menu chính");
	myScanner.nextLine();
}
	public static void sapxepTen() {
		SinhVien[] temp = new SinhVien[n];
		for (i = 0; i < arrbangsv.size() - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (arrbangsv.get(i).getName().compareTo(arrbangsv.get(j).getName()) > 0) {
					temp[i] = arrbangsv.get(j);
					arrbangsv.set(j, arrbangsv.get(i));
					arrbangsv.set(i , temp[i]);
				}
				}
			}
		
	

		for (i = 0; i < n; i++) {
			System.out.println("Danh sách sinh viên đã được sắp xếp theo điểm trung bình ");
			System.out.println("--------------------------------------------------------------------");
			System.out.println("STT  Họ và tên              Ngày sinh     lp1  lp2  ĐTB  Xếp Loại  ");
			System.out.println("--------------------------------------------------------------------");
			for (i = 0; i < n; i++) {
				System.out.printf("%-5s%-23s%-14s%-5s%-5s%-5s%-10s\n", (i + 1), arrbangsv.get(i).getName(), arrbangsv.get(i).getDate(),
						arrbangsv.get(i).getLp1(), arrbangsv.get(i).getLp2(),arrbangsv.get(i).getTBM(), arrbangsv.get(i).XepLoai());
			}
		}

		myScanner.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		myScanner.nextLine();
	}
	public static void xoa() {
		myScanner.nextLine();
		System.out.println("Sinh viên bạn cần xóa là ");
		String Name = myScanner.nextLine();
		System.out.println("Bạn đã xóa sinh viên  " + Name);
		for (int  i = arrbangsv.size()-1; i>-1;i--) {
			if(arrbangsv.get(i).getName().equals(Name)) {
				SinhVien.tongsv-= -1;
				arrbangsv.remove(i);
				
			}
		}
		myScanner.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		myScanner.nextLine();

		
	}
	public static void Sua(){
	myScanner.nextLine();
	System.out.println("Sinh viên bạn cần sửa tên là : ");
	String Name = myScanner.nextLine();
	System.out.println("Tên Sinh viên  sửa thành  là : ");
	String TenMoi = myScanner.nextLine();
	if(arrbangsv.get(i).getName().equals(Name)) {
		arrbangsv.get(i).setName(TenMoi);
	}
	}
	public static void ketThuc() {
		System.out.println("Kết thúc chương trình!!!!!");
		System.exit(0);
	}

	public static void luuFile() {
		ArrayList<SinhVien> dsKH = new ArrayList<SinhVien>();
		dsKH.add(new SinhVien("KH01", "Nguyễn Thị Bình", 0, 0));
		dsKH.add(new SinhVien("KH02", "Trần Trung Thành", 0, 0));
		dsKH.add(new SinhVien("KH03", "Lê Bá Khánh Trình", 0, 0));
		dsKH.add(new SinhVien("KH04", "Hoàng Ngọc Phách", 0, 0));

		boolean kt = TextFileFactory.luuFile(dsKH, "dulieu.txt");
		if (kt == true) {
			System.out.println("Lưu file thành công");
		} else {
			System.out.println("Lưu file thất bại");
		}
	}

//	public static void main(String[] args) {
//		luuFile();
//		ArrayList<SinhVien> dsKH = TextFileFactory.docFile("dulieu.txt");
//
//		System.out.println("Danh sách khách hàng nạp vào máy tính là:");
//		System.out.println("Mã    Tên");
//		for (SinhVien kh : dsKH) {
//			System.out.println(kh);
//		}
//	}
	
}

