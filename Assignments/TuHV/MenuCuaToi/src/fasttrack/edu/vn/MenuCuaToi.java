package fasttrack.edu.vn;
import java.util.Scanner;
public class MenuCuaToi {
	public static Scanner myScanner = new Scanner(System.in);
	
	public static void main(String[] args){
		myMenu();
	}
	public static void tinhtonghaiso() {
		System.out.println("Bai toan tim tong 2 so");
		System.out.println("**************");
		int a, b, c;
		Scanner myInput = new Scanner(System.in);
		System.out.print("nhap vao so a : ");
		a = myInput.nextInt();
		System.out.print("nhap vao so b ");
		b = myInput.nextInt();
		c = a + b;
		System.out.printf("tong cua %d + %d = %d \n", a, b, c);
		myScanner.nextLine();
		System.out.println("An Enter de ve menu chinh");
		myScanner.nextLine();

	}
	public static void giaiPTB2() {
		System.out.println("Giai phuong trinh bac 2");
		System.out.println("**************");
		int a, b, c;
		Scanner myInput = new Scanner(System.in);
		System.out.print("nhap vao so a : ");
		a = myInput.nextInt();
		System.out.print("nhap vao so b : ");
		b = myInput.nextInt();
		System.out.print("nhap vao so c : ");
		c = myInput.nextInt();
		
		if (a==0) {
		
		  if (b==0) {
		
		    if (c==0) 
			   System.out.println("Phương trình vô số nghiệm ");
			   else
				   System.out.println("Phương trình vô nghiệm");
		    }
		    else
		    	System.out.println("Phương trình có 1 nghiệm la x = "+(-c/b));
		  }
		  else 
		  {
			double x1 ;
			double x2 ;
			double delta=Math.pow(b, 2)-4*a*c;
			if (delta<0)
				System.out.println("Phương trình vô nghiệm");
			else if (delta>0) {
				x1=(-b+Math.sqrt(delta))/(2*a);
				x2=(-b-Math.sqrt(delta))/(2*a);
				System.out.println("Phương trình có 1 nghiệm x1 = "+x1);
				System.out.println("Phương trình có 1 nghiệm x2 = "+x2);
			}
			else
				System.out.println("Phương trình có nghiệm kép x1=x2= "+(-b/(2*a)));
		  }
		myScanner.nextLine();
		System.out.println("An Enter de ve menu chinh");
		myScanner.nextLine();
	}
	public static void xuLiMang() {
		System.out.println("Chuong trinh tim MIN MAX trong mang");
		System.out.println("**************");
		int a;
		int i;
		System.out.print("Nhap so phan tu cua mang= ");
		a = myScanner.nextInt();
		int[] b = new int[a];
		for (i = 1; i <= a; i++) {
			System.out.println("Nhap so phan tu cua mang " + i + ":");
			b[i - 1] = myScanner.nextInt();
		}
		int max=b[0];
		int min=b[0];
		int vitrimax=1;
		int vitrimin=1;
		
		for(i = 1; i <= a; i++) {
			if(max<b[i-1]) {
				max=b[i-1];
				vitrimax=i;
			}
			if(min>b[i-1]) {
				min=b[i-1];
				vitrimin=i;
			}
			
		}
	
		  System.out.println("max="+max+" vi tri thu"+" "+vitrimax);
	      System.out.println("min="+min+" vi tri thu"+" "+vitrimin);
	      myScanner.nextLine();
			System.out.println("An Enter de ve menu chinh");
			myScanner.nextLine();
	}
	public static void ketThuc() {
		System.out.println("Ket thuc chuong trinh- cam on cac ban");
		System.exit(0);
		
	}
	public static void myMenu() {
		while (true) {
			System.out.println("|-----------------------------------------------|");
			System.out.println("|                    APP                        |");
			System.out.println("|-----------------------------------------------|");
			System.out.println("|        LUA CHON CHUC NANG                     |");
			System.out.println("|     1. Chuong trinh phep cong                 |");
			System.out.println("|     2. Chuong trinh GPTB2                     |");
			System.out.println("|     3. Chuong trinh tim MIN MAX trong mang    |");
			System.out.println("|     4. Ket thuc chuong trinh                  |");
			System.out.println("|-----------------------------------------------|");
			System.out.println("|    Lua chon cua cac ban là :                  |");
			System.out.println("|-----------------------------------------------|");
					int myOption = myScanner.nextInt();
					if (myOption == 1) {
						tinhtonghaiso();					
					}else if (myOption == 2) {
						giaiPTB2();
					}else if (myOption == 3) {
						xuLiMang();
					}else if (myOption == 4) {
						ketThuc();
					}
					
		}
	}
}
