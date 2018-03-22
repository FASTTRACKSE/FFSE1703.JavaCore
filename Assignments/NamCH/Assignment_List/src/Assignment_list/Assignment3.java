package Assignment_list;
import java.util.Scanner;
public class Assignment3 {
	public static Scanner input=new Scanner(System.in);
	public static String[] datatensv = new String[100]; 
	public static Double[] datadiemlp1 = new Double[100];
	public static Double[] datadiemlp2 = new Double[100];
	public static Double[] datadiemtb = new Double[100];
	public static int i=0,count=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myMenu();
	}
	public static void addsv() {
		System.out.println("THÊM SINH VIÊN VÀO DANH SÁCH");
		System.out.println("============================");
		System.out.println("Bạn muốn nhập bao nhiêu sinh viên ?");
		int numsv= input.nextInt();
		count=numsv + count;
		for (;i<count;i++) {
			input.nextLine();
			System.out.print("Nhập tên sinh viên thứ "+(i+1)+" : ");
			datatensv[i]=input.nextLine();
			System.out.print("Nhập Điểm LP1:");
			datadiemlp1[i]=input.nextDouble();
			System.out.print("Nhập Điểm LP2:");
			datadiemlp2[i]=input.nextDouble();
			
			datadiemtb[i]=(datadiemlp1[i] + datadiemlp2[i])/2;
		}
		input.nextLine();
		System.out.println("======================");
		System.out.println("Nhập ENTER để tiếp tục");
		input.nextLine();
	}
	public static void printsv() {
		System.out.println("-----------DANH SÁCH TẤT CẢ SINH VIÊN-------------");
		System.out.println("==================================================");
		System.out.println("STT|| Tên          ||Điểm LP1||Điểm LP2||Điểm TB");
		System.out.println("--------------------------------------------------");
		for(int j=0;j<count;j++) {
			System.out.print(" " +(j+1)+"   "+datatensv[j] +"\t");
			System.out.print(  datadiemlp1[j] +"\t");
			System.out.print(datadiemlp2[j] +"\t");
			System.out.println(datadiemtb[j] +"\t");
		}
		input.nextLine();
		System.out.println("======================");
		System.out.println("Nhập ENTER để tiếp tục");
		input.nextLine();
	}
	public static void topsv() {
		System.out.println("-----------SINH VIÊN CÓ ĐIỂM CAO NHẤT-------------");
		System.out.println("==================================================");
		Double max = datadiemtb[0];
		
		int stt=0;
		for (int j=0;j<count;j++) {
			if(max<datadiemtb[j]) {
				max =datadiemtb[j];
				stt=j;				
			}			
		}
		for (int j=0;j<count;j++) {
			if(max<=datadiemtb[j]) {
				System.out.println("Là sinh viên:" +"==>>> " + datatensv[j]+" <<<==" +"\n" +"Có điểm trung bình " +max +"\n" + "Có số thứ tự là "+(j+1));		
			}
		}
		input.nextLine();
		System.out.println("======================");
		System.out.println("Nhập ENTER để tiếp tục");
		input.nextLine();
	}
	public static void endsv() {
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
			System.out.println("         |==========================|");
			System.out.println("         |--4.Kết thúc chương trình-|");
			System.out.println("         |__________________________|");
			System.out.print("     Nhập chức năng mà bạn muốn thực hiện :");
			int act = input.nextInt();
			if(act ==1) {
				addsv();
			}else if(act ==2) {
				printsv();
			}else if(act==3) {
				topsv();
			}else {
				endsv();
			}
		}
	}

}
