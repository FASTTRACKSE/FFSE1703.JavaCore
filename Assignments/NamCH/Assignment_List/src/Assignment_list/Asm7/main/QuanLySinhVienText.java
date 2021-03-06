package Assignment_list.Asm7.main;
import Assignment_list.Asm7.io.*;
import Assignment_list.Asm7.model.SinhVien;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.io.File;
public class QuanLySinhVienText {
	public static Scanner input=new Scanner(System.in);	
	public static ArrayList<SinhVien> arrSv=new ArrayList<SinhVien>();
	public static int stt=0;
	
	public static void main(String[] args) {
		myMenu();
	}
	public static void addSv() {		
		System.out.println("         THÊM SINH VIÊN VÀO DANH SÁCH");
		System.out.println("         ============================");
		System.out.print("         Bạn muốn nhập bao nhiêu Sinh Viên :");
		File file = new File("D:/FFSE1703.JavaCore/Assignments/NamCH/Assignment_List/dulieusinhvientext.txt");	    
	    if(file.exists()) {
	    	ArrayList<SinhVien> arrSvFile = TextFileFactory.readFile("dulieusinhvientext.txt");
	  		arrSv=arrSvFile;
	    }		
		try {
		int size = Integer.parseInt(input.nextLine());			
		for(int i=0;i<size;i++) {
			System.out.print("         Nhap tên cho sinh vien thu " + (stt+1)  + " : ");
			String hoTen = input.nextLine();			
			System.out.print("         Nhap ngày sinh cho sinh vien thu " + (stt+1)  + " : ");
			String ngaySinh = input.nextLine();		
			System.out.print("         Nhap Điểm LP1 cho sinh vien thu " + (stt+1)  + " : ");
			float diemLp1 = Float.parseFloat(input.nextLine())	;
			System.out.print("         Nhap Điểm LP2 cho sinh vien thu " + (stt+1)  + " : ");
			float diemLp2 = Float.parseFloat(input.nextLine())	;
			arrSv.add(new SinhVien(hoTen,ngaySinh,diemLp1,diemLp2));			
			boolean checked= TextFileFactory.saveFile(arrSv, "dulieusinhvientext.txt");
			if (checked == true) {
				System.out.println("Đã lưu thông tin của "+size +" sinh viên");
			} else {
				System.out.println("Lưu thất bại");
			}
		}
		}catch(Exception e) {
			System.out.println("         Nhập sai định dạng !!!");
			System.out.println("         Vui lòng nhập lại");
		}
		
	}
	public static void printSv() {
		System.out.println("         DANH SÁCH TẤT CẢ SINH VIÊN");
		System.out.println("         ==========================");
		System.out.println("         Stt\t Tên\t Ngày Sinh\t Điểm LP1\t Điểm lp2\t Điểm TB\t Xếp Loại");
		int i=0;
		for(SinhVien x :arrSv) {			
			System.out.print("          "+(i+1)+"\t");
			System.out.println(x);
			i++;
		}
	}
	public static void topSv() {
		System.out.println("         -----------SINH VIÊN CÓ ĐIỂM CAO NHẤT-------------");
		System.out.println("         ==================================================");
		float max=0;
		int stt;
		for (int i=0;i<arrSv.size();i++) {
			if(max<arrSv.get(i).getDiemTB()) {
				max =arrSv.get(i).getDiemTB();
				stt=i;				
			}			
		}
		for (int i=0;i<arrSv.size();i++) {			
			if(max<=arrSv.get(i).getDiemTB()) {
				System.out.println("         Là sinh viên:" +"==>>> " + arrSv.get(i).getHoTen()+" <<<==" +"\n" +"Có điểm trung bình " +max +"\n" + "Có số thứ tự là "+(i+1));		
			}
		}
	}
	public static void sorfDiemSV() {
		System.out.println("         -------SẮP XẾP SINH VIÊN TĂNG DẦN THEO ĐIỂM TB------");
		System.out.println("         ====================================================");
		System.out.println("         Stt\t Tên\t Ngày Sinh\t Điểm LP1\t Điểm lp2\t Điểm TB\t Xếp Loại");
		Collections.sort(arrSv, SinhVien.compare);
		int i=0;
		  for(SinhVien x: arrSv){			  
			  	System.out.print("          "+(i+1)+"\t");
				System.out.println(x);
				i++;
		  }
	}
	public static void sorfNameSV() {
		System.out.println("         -------SẮP XẾP SINH VIÊN THEO TÊN------");
		System.out.println("         =======================================");
		System.out.println("         Stt\t Tên\t Ngày Sinh\t Điểm LP1\t Điểm lp2\t Điểm TB\t Xếp Loại");
		Collections.sort(arrSv, SinhVien.compareName);
		int i=0;
		  for(SinhVien x: arrSv){			  
			  	System.out.print("          "+(i+1)+"\t");
				System.out.println(x);
				i++;
		  }
	}
	public static void printByNameSV() {
		System.out.println("         -------IN DANH SÁCH THEO TÊN------");
		System.out.println("         ==================================");
		System.out.print("         Gõ tên sinh viên mà bạn muốn in: ");
		String act = input.nextLine();
		int i=0;
		try {
		System.out.println("         Stt\t Tên\t Ngày Sinh\t Điểm LP1\t Điểm lp2\t Điểm TB\t Xếp Loại");
		for(SinhVien x:arrSv) {
			if(act.equals(x.getHoTen())) {
				System.out.print("          "+(i+1)+"\t");
				System.out.println(x);
				i++;
				}else {
					throw new Exception(); 
				}
			
		}
		}catch (Exception e) {
			System.out.println("         không có sinh viên nào tên :"+act);
		}				
	}
	public static void changeNameSV() {
		System.out.println("         Stt\t Tên\t Ngày Sinh\t Điểm LP1\t Điểm lp2\t Điểm TB\t Xếp Loại");
		int i=0;
		for(SinhVien x :arrSv) {			
			System.out.print("          "+(i+1)+"\t");
			System.out.println(x);
			i++;
		}
		System.out.print("         Bạn muốn thay đổi tên của sinh viên thứ mấy : ");
		try {			
			int act = Integer.parseInt(input.nextLine());
			try {
				if((act)<=arrSv.size()) {
				System.out.print("         Nhập tên mà bạn muốn thay đổi : ");
				String hoTen = input.nextLine();
				arrSv.get((act-1)).setHoTen(hoTen);
				System.out.println("         Đã thay đổi thành công sinh viên thứ : "+act);
				System.out.println(arrSv.get((act-1)).toString());
				}else {
					throw new Exception();
				}
			}catch (Exception e) {
				System.out.println("         Chỉ nhập từ 1 tới " +arrSv.size());
			}
		}catch (Exception e) {
			System.out.println("         Nhập sai định dạng !!!");
			System.out.println("         Vui lòng nhập lại!!!");
		}
	}
	public static void removeSv() {
		System.out.println("         Stt\t Tên\t Ngày Sinh\t Điểm LP1\t Điểm lp2\t Điểm TB\t Xếp Loại");
		int i=0;
		for(SinhVien x :arrSv) {			
			System.out.print("          "+(i+1)+"\t");
			System.out.println(x);
			i++;
		}
		System.out.print("         Nhập tên sinh viên mà bạn muốn xóa : ");
		String ten = input.nextLine();					
			for(i=0;i<arrSv.size();i++) {
				if(ten.equals(arrSv.get(i).getHoTen())) {				
					arrSv.remove(i);
					i--;
				}
			}					
		System.out.println("         XÓA THÀNH CÔNG sinh viên có tên : "+ten);			
		System.out.println("         Stt\t Tên\t Ngày Sinh\t Điểm LP1\t Điểm lp2\t Điểm TB\t Xếp Loại");
		int j=0;
		for(SinhVien x :arrSv) {		
			System.out.print("          "+(j+1)+"\t");
			System.out.println(x);
			j++;
		}
	}
	public static void endSv() {
		System.out.println("         Kết thúc chương trình");
		System.out.println("         ======================");
		System.out.println("         =======Tkank you======");
		System.exit(0);
	}

	public static void myMenu() {
		while(true) {
			try {
				System.out.println("         ____________________________");
				System.out.println("         |==========================|");
				System.out.println("         |----CHỌN LỰA CHỨC NĂNG----|");
				System.out.println("         |--------------------------|");
				System.out.println("         |--1.Nhập danh sinh viên---|");
				System.out.println("         |--2.In danh sách sinh viên|");
				System.out.println("         |--3.Top sinh viên---------|");
				System.out.println("         |--4.Sắp xếp theo tăng dần-|");
				System.out.println("         |--5.Sắp xếp theo Tên------|");
				System.out.println("         |--6.Tìm kiếm sinh viên----|");
				System.out.println("         |--7.Đổi tên sinh viên-----|");
				System.out.println("         |--8.Xóa sinh viên theo tên|");
				System.out.println("         |==========================|");
				System.out.println("         |--9.Kết thúc chương trình-|");
				System.out.println("         |__________________________|");
				System.out.print("     Nhập chức năng mà bạn muốn thực hiện :");				
				int act = Integer.parseInt(input.nextLine());					
				if(act ==1) {
					addSv();
				}else if(act ==2) {
					printSv();
				}else if(act==3) {
					topSv();
				}else if(act==4) {
					sorfDiemSV();
				}else if(act==5) {
					sorfNameSV();
				}else if(act==6) {
					printByNameSV();
				}else if(act==7) {
					changeNameSV();
				}else if(act==8) {
					removeSv();
				}else if(act==9) {
					endSv();
				}else {
					throw new Exception();
		        }
			}catch(NumberFormatException e){
					System.out.println("         Vui Lòng nhập số");
			}catch (Exception e) {		
		         System.out.println("         Chỉ Được Nhập từ 1 đến 9 bạn nhé!!!");				         
			}						
			System.out.println("         =====================================");
			System.out.println("         -------Nhập ENTER để tiếp tục------");
			input.nextLine();
		}
	}

}

