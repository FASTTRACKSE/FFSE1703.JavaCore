package fasttrack.edu.vn.practices;
import java.util.Scanner;
public class MenuCuatoi {
    public static Scanner myScanner = new Scanner(System.in);
	public static void main(String[] args) {
	myMenu();

	}
	public static void phepCong() {
		System.out.println("Tìm tổng 2 số");
		int a, b, c;
		
		Scanner myInput = new Scanner(System.in);
		System.out.println("nhap so a :");
		a = myInput.nextInt();
		System.out.println("nhap so b :");
		b = myInput.nextInt();
		c = a + b;
		System.out.printf("tong cua %d + %d = %d \n",a ,b, c);
		
		myScanner.nextLine();
		System.out.println("An Enter de ve menu chinh");
		myScanner.nextLine();
	}
	public static void phepNhan() {
		System.out.println("Giải phương trình bậc 2");
		double a, b, c, x, y, d;

		Scanner myInput = new Scanner(System.in);

		System.out.print("Nhap vao so a:");
		a = myInput.nextDouble();

		System.out.print("Nhap vao so b:");
		b = myInput.nextDouble();

		System.out.print("Nhap vao so c:");
		c = myInput.nextDouble();

		d = (b * b) - 4 * a * c;
		if (a == 0) {
			if (b == 0) {

				if (c == 0) {
					System.out.print("Phuong trinh vo so nghiem");
				} else {
					System.out.print("Phuong trinh vo nghiem");
				}
			} else {
				x = -c / b;
				System.out.print("Phuong trinh co nghiem la:" + x);

			}
		} else {
			if (d == 0) {
				x = -b / 2 * a;
				System.out.print("Phuong trinh co nghiem kep la:" + x);
			} else if (d > 0) {
				x = (-b - Math.sqrt(d)) / (2 * a);
				y = (-b + Math.sqrt(d)) / (2 * a);
				System.out.println("Phuong trinh co 2 nghiem" + "\n" + x + "\n" + y);

			} else {
				System.out.print("Phuong trinh vo nghiem");
			}

		}

		myScanner.nextLine();
		System.out.println("An Enter de ve menu chinh");
		myScanner.nextLine();
	}
	public static void phepChia() {
		System.out.println("Tìm giá trị trong mảng");
		int n;
	    int count = 0;
	    Scanner scanner = new Scanner(System.in); 
    	do {
	         System.out.println("Nhập vào số phần tử của mảng: ");
		     n = scanner.nextInt();
		   } while (n < 0);
	 	int arr[] = new int[n];
	 		 System.out.println("Nhập các phần tử cho mảng: ");
 		for (int i = 0; i < n; i++) 
 			{
			  System.out.print("Nhập phần tử thứ " +(i + 1) +": ");
			  arr[i] = scanner.nextInt();
 			}
		 //Đếm số lần xuất hiện của 1 phần tử 
		      System.out.println("Nhập vào 1 số nguyên bất kỳ: ");
		 int number = scanner.nextInt();
		 for (int i = 0; i < n; i++) 
		 {
		     if (arr[i] == number) {
		         count++;
		     }
		 }
		      System.out.println("Số phần tử " + number + " có trong mảng = " + count);
		 //tìm min & max
		 int max = arr[0];
		 int min = arr[0];
		 for (int i=0;i<n;i++)
		 {
		     if(max<arr[i])
			  max=arr[i];
		     if(min>arr[i])
		      min=arr[i];
		 }
		 System.out.println("Số phần tử lớn nhất trong mảng là : " + max);
		 System.out.println("Số phần tử nhỏ nhất trong mảng là : " + min);
		 
		myScanner.nextLine();
		System.out.println("An Enter de ve menu chinh");
		myScanner.nextLine();
	}
	public static void ketThuc() {
		System.out.println("Kết thúc chương trình");
		System.exit(0);
		
	}
	public static void myMenu() {
		while(true) {
	System.out.println("LUA CHON CHUC NANG");
	System.out.println("1. Tìm tổng 2 số");
	System.out.println("2. Giải phương trình bậc 2");
	System.out.println("3. Tìm giá trị trong mảng");
	System.out.println("4. Kết thúc chương trình");
	System.out.println("Lựa chọn của bạn");
	
	int myOption = myScanner.nextInt();
	
	if (myOption == 1) {
		phepCong();
	} else if (myOption == 2) {
		phepNhan();
	} else if (myOption == 3) {
		phepChia();
	} else if (myOption == 4 ) {
		ketThuc();
	}
	}}

}
