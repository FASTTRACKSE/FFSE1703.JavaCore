package fasttrack.edu.vn.assignment3;

import java.util.Scanner;

public class Quanlysinhvien {
public static Scanner myScanner = new Scanner(System.in);
public static String[] arsinhvien;
public static double[] arrLP1;
public static double[] arrLP2;
public static double[] arrDTB;
public static String[] arrngaysinh;
public static int tongsinhvien = 0  ;
public static int i ;
	
	public static void main (String[] args) {
		ShowMenu();
	}
	public static void ShowMenu () {
		while (true) {
			System.out.println("LỰA CHỌN CHỨC NĂNG");
			System.out.println("1 .Danh sách sinh viên ");
			System.out.println("2 .in danh sách sinh viên ");
			System.out.println("3 .Top sinh viên");
			System.out.println("4 .kết thúc chương trình");
			System.out.println("Lựa chọn của bạn là :");
			int myOption = myScanner.nextInt();
			if(myOption==1) {
				nhapthongtinsinhvien();
			}else if(myOption==2) {
				indssinhvien();
			}else if(myOption==3) {
				svtieubieu();
			}else if(myOption==4) {
				ketthuc();
			}
			
		}
	}
	public static void nhapthongtinsinhvien() {
		
			System.out.println("Nhập danh sách sinh viên : ");
			System.out.println("---------------------------");
			System.out.println("Số lượng sinh viên :");
			tongsinhvien = myScanner.nextInt();
			 arsinhvien = new String[tongsinhvien];
			 arrngaysinh = new String[tongsinhvien];
			 arrLP1 = new double[tongsinhvien];
			 arrLP2 = new double[tongsinhvien];
			 arrDTB = new double[tongsinhvien];
			for (i = 0; i < tongsinhvien; i++) {
				myScanner.nextLine();
				
				System.out.print("Nhập tên Sinh Viên thứ "+ (i+1) + " :");
				arsinhvien[i] = myScanner.nextLine();
				System.out.print("ngày tháng năm sinh : "+  " :");
				arrngaysinh[i] = myScanner.nextLine();
				
				System.out.print("Nhập điểm môn LP1 "+ " :");
				arrLP1[i] = myScanner.nextDouble();
				
				System.out.print("Nhập điểm môn LP2 "+  " :");
				arrLP2[i] = myScanner.nextDouble();
				
				
				arrDTB[i] = ((arrLP1[i]+ arrLP2[i])/2);
			}
			myScanner.nextLine();
			System.out.println("Ấn Enter để về menu chính");
			myScanner.nextLine();
		}

	public static void indssinhvien() {
			System.out.println("Danh sách sinh viên ");
			System.out.println("--------------------------------------------");
			System.out.println("STT\tHọ và tên\t\tngàysinh\t\tlp1\t\tlp2\t\tĐTB");
			System.out.println("--------------------------------------------");
			for (i = 0; i < tongsinhvien; i++) {
				System.out.println((i+1)+"\t" + arsinhvien[i]+"\t\t\t" +arrngaysinh[i] + "\t\t\t" +arrLP1[i]+"\t\t"+arrLP2[i] + "\t\t"+ arrDTB[i]);
			}
			myScanner.nextLine();
			System.out.println("Ấn Enter để về menu chính");
			myScanner.nextLine();
		}
	public static void svtieubieu() {
		double
		min = arrDTB[0],
		max = arrDTB[0];
		int x =0, y=0;

		for (i = 0; i < tongsinhvien; i++) {
			if (min > arrDTB[i]) {
				min = arrDTB[i];
				x =i;
			}
			if (max < arrDTB[i]) {
				max = arrDTB[i];
				y =i;
			}
		}
		System.out.println("Học sinh có kết quả học tập cao nhất là :");
		System.out.println((y+1)+"\t" + arsinhvien[y] + "\t" +arrLP1[y]+"\t"+arrLP2[y] + "\t"+ arrDTB[y]);

		System.out.println("Học sinh có kết quả học tập thấp nhất là :");
		System.out.println((x+1)+"\t" + arsinhvien[x] + "\t" +arrLP1[x]+"\t"+arrLP2[x] + "\t"+ arrDTB[x]);
		myScanner.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		myScanner.nextLine();
		}
	public static void ketthuc() {
		System.out.println("Kết thúc chương trình!!!!!");
		System.exit(0);
	}
	
	}
	
