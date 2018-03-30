package asm3;
import java.util.Scanner;
public class asm3 {
	public static String[]ten = {"a, b, c"};
	public static String[]ntnsinh;
	public static Double[]lp1 = {8.0, 9.0, 6.7};
	public static Double[]lp2 = {5.8, 7.0, 10.0 };
	public static Double[]tb;
	
	public static int b=0;
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		menu();
	}
	
	public static void nhap() {
		System.out.println("BẠN MUỐN NHẬP BAO NHIÊU SINH VIÊN");
			b = sc.nextInt();
			ten = new String[b];
			ntnsinh = new String[b];
			lp1 = new Double[b];
			lp2 = new Double[b];
			tb = new Double[b];
			for(int i=0; i<b; i++) {
				sc.nextLine();
				System.out.println("Tên sinh viên");
				 ten[i] = sc.nextLine();
				System.out.println("Ngày tháng năm sinh");
				 ntnsinh[i] = sc.nextLine();
				System.out.println("Điểm lp1");
				lp1[i] = sc.nextDouble();
				System.out.println("ĐIểm lp2");
				lp2[i] = sc.nextDouble();
				tb[i]=(lp1[i]+lp2[i])/2;
				
			}
	}
	public static void in() {
		System.out.println(" Tên  Ngày sinh Lp1 Lp2 T bình");

		for(int i=0; i<b; i++) {
			System.out.print(ten[i]);
			System.out.print(ntnsinh[i]);
			System.out.print(lp1[i]);
			System.out.print(lp2[i]);
			System.out.print(tb[i]);
		}
			
	}
	public static void cao() {
		Double max=tb[0] ;
		int stt=0;
		for(int i=0; i<b; i++) {
			if(max<tb[i]) {
				max = tb[i];
				stt=i;
			}
		}
		System.out.print("Sinh viên có điểm cao nhất là: ");
		System.out.println(ten[stt] + tb[stt]);
	}
	public static void thap() {
		Double min=tb[0]; 
		int stt1=0;
		for(int i=0; i<ten.length; i++ ) {
			if(min>tb[i]) {
				min = tb[i];
				stt1=i;
			}
		}
		System.out.print("Sinh viên có điểm thấp nhất là:");
		System.out.println(ten[stt1] + tb[stt1]);
}
	public static void sapxeptb() {
	        Double temp = tb[0];
	        String stemp; 
	        for (int i = 0 ; i < tb.length - 1; i++) {
	            for (int j = i + 1; j < tb.length; j++) {
	                if (tb[i] > tb[j]) {
	                    temp = tb[i];
	                    tb[j] = tb[i];
	                    tb[i] = temp;
	                    
	                    stemp = ten[i];
	                    ten[i] = ten[j];
	                    ten[j] = stemp;
	                    
	                    temp = lp1[i];
	                    lp1[j] = lp1[i];
	                    lp1[i] = temp;
	                    
	                    temp = lp2[i];
	                    lp2[j] = lp2[i];
	                    lp2[i] = temp;
	                    
	                    stemp = ntnsinh[i];
	                    ntnsinh[j] = ntnsinh[i];
	                    ntnsinh[i] = stemp;
	                    
	          
	                }
	            }
	        }
	        System.out.println("Họ tên   Ngày tháng năm sinh   Lp1    Lp2  Đtb");
	        for (int i = 0; i < tb.length; i++) {
	            System.out.print(tb[i]+" " + lp1[i] +" "+ lp2[i]);
	        }
	}
	public static void kthuc() {
		System.out.println("Chào tạm biệt");
		System.exit(0);
	
}
	public static void menu(){
		while(true) {
		System.out.println(" 1.-----NHẬP DANH SÁCH SINH VIÊN-----");
		System.out.println(" 2.______IN DANH SÁCH SINH VIÊN______");
		System.out.println(" 3.___________TOP SINH VIÊN__________");
		System.out.println(" 4.____SINH VIÊN CÓ ĐIỂM THẤP NHẤT____");
		System.out.println(" 5. _____SẮP XẾP SINH VIÊN THEO ĐTB____");
		System.out.println(" 6._____SẮP XẾP SINH VIÊN THEO TÊN_____");
		System.out.println(" 7._______KẾT THÚC CHƯƠNG TRÌNH_______");
		System.out.println("______NHẬP CHỨC NĂNG BẠN MUỐN________");
			int a = sc.nextInt();
			if(a==1) {
				nhap();
			}
			else if(a==2) {
				in();
			}
			else if(a==3) {
				cao();
			}
			else if(a==4) {
				thap();
			}
			else if(a==5) {
				sapxeptb();
			}
			else if(a==6) {
				sapxeptb();
			}
			else if(a==7) {
				kthuc();
			}
	}
	}
	
}
