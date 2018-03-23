package fasttrack.edu.vn.pratices;
import java.util.Scanner;

public class Menuvuatoi {
	public static Scanner myScanner = new Scanner(System.in);
	
	public static void main (String[] args) {
		myMenu();
	}
    
	public static void tong2so() {
		System.out.println("Tính tổng 2 số" );
		int a, b, c;
		Scanner myInput = new Scanner(System.in);
		System.out.print("Nhập vào số a : ");
		a = myInput.nextInt();
		System.out.print("nhập vào số b : ");
		b = myInput.nextInt();
		c = a + b ;
		System.out.printf("Tổng của %d + %d = %d \n", a, b, c);
		myScanner.nextLine();
		System.out.println("Ấn ENTER để về Menu chính");
		myScanner.nextLine();
	}
	public static void giaiptb2() {
		System.out.println("Phương trình bậc 2" );
		double a , b , c, x1, x2;
		Scanner myInput = new Scanner(System.in);
		System.out.print("Nhập vào số a : ");
		a = myInput.nextInt();
		System.out.print("Nhập vào số b : ");
		b = myInput.nextInt();
		System.out.print("Nhập vào số c : ");
		c = myInput.nextInt();
	if(a==0) {
		if(b==0) {
			if(c==0) {
				System.out.println("phương trình vô số nghiệm");
		              }
			    else {
				      System.out.println("phương trình vô  nghiệm");
			         }
		         }
	         else { 
		         System.out.println("phương trình có nghiệm là : " + -c/b);
		            }
	         
	
	} else  {
		double denta =Math.pow(b, 2)-4*a*c;
		if( denta < 0) {
			System.out.println("phương trình vô  nghiệm ");}
	    else if (denta > 0) {
	    	x1 = (-b + Math.sqrt(denta))/(2*a);
	    	x2 = (-b - Math.sqrt(denta))/(2*a);
			System.out.println("phương trình có 2 nghiệm là : x1 = "+ x1 +" và x2 = "+ x2);
		}else if(denta==0) {
			x1 = x2 = -b/2*a;
			System.out.println("Phương trình có nghiệm kép là : x1 = x2 =" + x1);
				}
			}
	myScanner.nextLine();
	System.out.println("Ấn ENTER để về Menu chính");
	myScanner.nextLine();
	}
	
	
	public static void solonnhattrongmang() {
		System.out.println("so sánh cac số" );
				int n, i, nho, lon;
				Scanner myInput = new Scanner(System.in);
				System.out.println("Nhập tổng phần tử trong mảng a[] là");
				n = myInput.nextInt();
				int[] a = new int[n];
				for (i = 0; i < n; i++) {
					System.out.println("nhập giá trị phần tử a[" + (i + 1) + "] là ");
					a[i] = myInput.nextInt();

				}
				nho = a[0];
				lon = a[0];
				int x = 1, y = 1;

				for (i = 0; i < n; i++) {
					if (nho > a[i]) {
						nho = a[i];
						x = i + 1;
					}
				}

				System.out.println("Số nhỏ nhất trong " + n + " phần tử là :" + nho);

				System.out.println("Là phần tử thứ " + x);

				for (i = 0; i < n; i++) {
					if (lon < a[i]) {
						lon = a[i];
						y = i + 1;
					}
				}

				System.out.println("Số lớn nhất trong " + n + " phần tử là :" + lon);

				System.out.println("Là phần tử thứ " + y);
				myScanner.nextLine();
				System.out.println("Ấn ENTER để về Menu chính");
				myScanner.nextLine();
			}
	
	public static void ketthuc() {
		System.out.println("" );
		System.exit(0);
	}
	
	public static void myMenu() {
		while (true) {
			System.out.println("Menu của tôi");
			System.out.println("LỰA CHỌN CHƯƠNG TRÌNH");
			System.out.println("1. Chương trình phép cộng");
			System.out.println("2. Chương trình gptb2");
			System.out.println("3. Chương trình min max trong mảng");
			System.out.println("4. kết thúc");
			System.out.println("Lựa chọn của bạn là :");
			int myOption = myScanner.nextInt();
			if(myOption==1) {
				tong2so();
			}else if(myOption==2) {
				giaiptb2();
			}else if(myOption==3) {
				solonnhattrongmang();
			}else if(myOption==4) {
				ketthuc();
			}
			
		}
	}
}