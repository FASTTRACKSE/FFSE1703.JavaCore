package ;
import java.util.Scanner;
public class listhocsinh {
		// TODO Auto-generated method stub
		public static Scanner myInput = new Scanner(System.in);
		public static String[] arrSinhvien;
		public static String[] arrDate;
		public static double[] arrDiemlp1;
		public static double[] arrDiemlp2;
		public static double[] arrDiemtb;
		public static int a;
		//
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			myMenu();
		}
		public static void themsinhvien() {
			
			System.out.println("<----Nhập số lượng---->");
			 a = myInput.nextInt();
		 arrSinhvien = new String[a];
		 arrDate = new String[a];
		 arrDiemlp1 = new double[a];
		 arrDiemlp2 = new double[a];
		 arrDiemtb = new double[a];

			for(int i=0;i<a;i++) {
				myInput.nextLine();
				System.out.println("Nhập họ và tên sinh viên: ");
				arrSinhvien[i] = myInput.nextLine();
				System.out.println("Nhập Ngày Sinh");
				arrDate[i] = myInput.nextLine();
				System.out.println("Nhập Điểm LP1");
				arrDiemlp1[i] = myInput.nextDouble();
				System.out.println("Nhập Điểm LP2");
				arrDiemlp2[i] = myInput.nextDouble();
				arrDiemtb[i]=((arrDiemlp1[i]+arrDiemlp2[i])/(2));
			}

		}
		public static void topsinhvien() {
			System.out.println("Danh Sách Điểm Cao Nhất");
			double max = arrDiemtb[0];
			int maxvt = 0;
			for(int i=0;i<arrDiemtb.length;i++) {
				if(max < arrDiemtb[i]) {
					max = arrDiemtb[i];
					maxvt = i;
					
				}
			}
			System.out.println("Tên Sinh Viên Là: " + arrSinhvien[maxvt] + "\t" + "Diem Trung Binh La: " + max);
		}
		public static void indanhsach() {
			
			System.out.println("<----Danh Sách Sinh Viên---->");
			System.out.println("Tên Sinh Viên: " + "    Date: " + "    Điểm LP1: " + "    Điểm LP2: " + "    Điểm TB: ");
			for(int i=0;i<a;i++) {	
				System.out.println( " \t " + arrSinhvien[i] + " \t " + arrDate[i] +  " \t " + arrDiemlp1[i] +  " \t " + arrDiemlp2[i] +  " \t " + arrDiemtb[i] );
			}
		}
		public static void ketThuc() {
			System.out.println("<----Kết Thúc Chương Trinh---->");
		}
		public static void myMenu() {
			while(true) {
			System.out.println("Lựa Chọn Chức Năng");
			System.out.println("1.Tên Sinh Viên");
			System.out.println("2.Top Sinh Viên");
			System.out.println("3.In Danh Sách");
			int option = myInput.nextInt();
			if(option == 1) {
				themsinhvien();
			}else if(option == 2) {
				topsinhvien();
			}else if(option == 3) {
				indanhsach();
			}
		}
	}
}

