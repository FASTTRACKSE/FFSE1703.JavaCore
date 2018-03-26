package Assignment_list;
import java.util.Scanner;
public class MenuQuanly {
	public static Scanner input=new Scanner(System.in);	
	public static Sinhvien[] sv=new Sinhvien[100];
	public static int soluong=0;
	public static String action,sosanh="k";
	public static void main(String[] args) {
		myMenu();

	}
	public static void addSv() {
		System.out.println("THÊM SINH VIÊN VÀO DANH SÁCH");
		System.out.println("============================");
		System.out.println("Bạn muốn nhập bao nhiêu sinh viên ?");		
		int a=input.nextInt();
		soluong=a+soluong;
		for(int i=0;i<soluong;i++) {
			sv[i] = new Sinhvien();
		}
		for(int i=0;i<soluong;i++) {
			input.nextLine();
			System.out.println("Nhap tên cho sinh vien thu " + (i+1)  + " : ");
			String hoTen = input.nextLine();
			sv[i].setHoTen(hoTen);
			System.out.println("Nhap ngày sinh cho sinh vien thu " + (i+1)  + " : ");
			String ngaySinh = input.nextLine();
			sv[i].setNgaySinh(ngaySinh);
			System.out.println("Nhap Điểm LP1 cho sinh vien thu " + (i+1)  + " : ");
			float diemLp1 = input.nextFloat();
			sv[i].setDiemLp1(diemLp1);
			System.out.println("Nhap Điểm LP2 cho sinh vien thu " + (i+1)  + " : ");
			float diemLp2 = input.nextFloat();
			sv[i].setDiemLp2(diemLp2);			
		}
		action=input.nextLine();
		System.out.println("=====================================");
		System.out.println("-------Nhập ENTER để tiếp tục------");
		System.out.println("Hoặc gõ K để kết thúc trương trình");
		action=input.nextLine();
		if(action.equals(sosanh)) {
			 endSv();
			  }
	}
	public static void showSV(Sinhvien sv) {	    
		System.out.print(sv.getHoTen() +"\t" + 
				sv.getNgaySinh()+"\t" +
				"\t" + sv.getDiemLp1() +"\t"+ "\t" + sv.getDiemLp2()+"\t" 
				+ "\t" + sv.getDiemTB()+"\t"
        );
		sv.getXepLoai();
	}
	
	public static void printSv() {
		System.out.println("-----------DANH SÁCH TẤT CẢ SINH VIÊN-------------");
		System.out.println("==================================================");
		System.out.println("STT\tTên\t Ngày Sinh\tĐiểm LP1\tĐiểm LP2\tĐiểm TB\tXếp Loại");
		System.out.println("--------------------------------------------------");
		for(int i=0;i<soluong;i++) {
			System.out.print((i+1)+"\t");
			showSV(sv[i]);			
		}
		action=input.nextLine();
		System.out.println("=====================================");
		System.out.println("-------Nhập ENTER để tiếp tục------");
		System.out.println("Hoặc gõ K để kết thúc trương trình");
		action=input.nextLine();
		if(action.equals(sosanh)) {
			 endSv();
			  }
	}	
	public static void topSv() {
		System.out.println("-----------SINH VIÊN CÓ ĐIỂM CAO NHẤT-------------");
		System.out.println("==================================================");
		float max=0;
		int stt;
		for (int i=0;i<soluong;i++) {
			if(max<sv[i].getDiemTB()) {
				max =sv[i].getDiemTB();
				stt=i;				
			}			
		}
		for (int i=0;i<soluong;i++) {			
			if(max<=sv[i].getDiemTB()) {
				System.out.println("Là sinh viên:" +"==>>> " + sv[i].getHoTen()+" <<<==" +"\n" +"Có điểm trung bình " +max +"\n" + "Có số thứ tự là "+(i+1));		
			}
		}
		action=input.nextLine();
		System.out.println("=====================================");
		System.out.println("-------Nhập ENTER để tiếp tục------");
		System.out.println("Hoặc gõ K để kết thúc trương trình");
		action=input.nextLine();
		if(action.equals(sosanh)) {
			 endSv();
			  }
	}
	public static void badSv() {
		System.out.println("-----------SINH VIÊN CÓ ĐIỂM THẤP NHẤT-------------");
		System.out.println("==================================================");
		float min=0;
		int stt;
		for (int i=0;i<soluong;i++) {
			if(min>sv[i].getDiemTB()) {
				min =sv[i].getDiemTB();
				stt=i;				
			}			
		}
		for (int i=0;i<soluong;i++) {
			if(min<=sv[i].getDiemTB()) {
				System.out.println("Là sinh viên:" +"==>>> " + sv[i].getHoTen()+" <<<==" +"\n" +"Có điểm trung bình " +min +"\n" + "Có số thứ tự là "+(i+1));		
			}
		}
		action=input.nextLine();
		System.out.println("=====================================");
		System.out.println("-------Nhập ENTER để tiếp tục------");
		System.out.println("Hoặc gõ K để kết thúc trương trình");
		action=input.nextLine();
		if(action.equals(sosanh)) {
			 endSv();
			  }
	}
	public static void sorfDiemSv() {
		Sinhvien [] temp=new Sinhvien[soluong];
		float tempt;
		for (int i = 0; i<soluong-1;i++){
			for(int j=i+1;j<soluong;j++) {
				if(sv[i].getDiemTB()<sv[j].getDiemTB()) {					;
					temp[i] = sv[i];
					sv[i] = sv[j];
					sv[j] = temp[i];
				}
			}
	    }
		for(int i=0;i<soluong;i++) {
			System.out.print((i+1)+"\t");
			showSV(sv[i]);			
		}
		action=input.nextLine();
		System.out.println("=====================================");
		System.out.println("-------Nhập ENTER để tiếp tục------");
		System.out.println("Hoặc gõ K để kết thúc trương trình");
		action=input.nextLine();
		if(action.equals(sosanh)) {
			 endSv();
			  }
	}
	public static void endSv() {
		System.out.println("Kết thúc chương trình");
		System.out.println("======================");
		System.out.println("=======Tkank you======");
		System.exit(0);
	}

	public static void myMenu() {
		while(true) {
			System.out.println("         ____________________________");
			System.out.println("         |==========================|");
			System.out.println("         |----CHỌN LỰA CHỨC NĂNG----|");
			System.out.println("         |--------------------------|");
			System.out.println("         |--1.Nhập danh sinh viên---|");
			System.out.println("         |-2.In danh sách sinh viên-|");
			System.out.println("         |-----3.Top sinh viên------|");
			System.out.println("         |-----4.Bad sinh viên------|");
			System.out.println("         |---5.Sắp xếp theo Điểm----|");
			System.out.println("         |==========================|");
			System.out.println("         |--6.Kết thúc chương trình-|");
			System.out.println("         |__________________________|");
			System.out.print("     Nhập chức năng mà bạn muốn thực hiện :");
			int act = input.nextInt();
			if(act ==1) {
				addSv();
			}else if(act ==2) {
				printSv();
			}else if(act==3) {
				topSv();
			}else if(act==4) {
				badSv();
			}else if(act==5) {
				sorfDiemSv();
			}else {
				endSv();
			}
		}
	}

}
