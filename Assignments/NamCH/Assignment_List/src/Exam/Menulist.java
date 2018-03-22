package Exam;
import java.util.Scanner;
public class Menulist {
	public static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myMenu();
	}
	public static void tinhtong() {
		System.out.println("Bài toán tính tổng 2 số :");
		System.out.println("--------------------------");
		int a,b,c;
		System.out.print("nhập số a:");
		a=input.nextInt();
		System.out.print("nhập số b:");
		b=input.nextInt();
		c=a+b;
		System.out.println("Tổng 2 số :" +a + "+" + b + "=" + c  );
		input.nextLine();
		System.out.println("Nhập enter để tiếp tục");
		input.nextLine();
	}
	public static void giaipt() {
		System.out.println("Giả phương trình bậc 2:");
		System.out.println("--------------------------");
		int a,b,c;
		Scanner input = new Scanner(System.in);
		double x1,x2,d;
		System.out.println("Tính phương trình bật 2 có dạng : AX^2 + BX + C = 0");
		System.out.print("Nhập hệ số bậc 2 : A =");
		a = input.nextInt();
		System.out.print("Nhập hệ số bậc 1 :B=");
		b = input.nextInt();
		System.out.print("Nhập hệ số tự do :C=");
		c = input.nextInt();
		if (a==0) {
			if(b==0) {
				if(c==0) {
					System.out.print("Phương trình có vô số nghiệm");
				}else {
					System.out.print("Phương trình vô nghiệm");
				}
			}else {
				x1=-c/b;
				System.out.print("Phương trình có 1 nghiệm là :" + x1);
			}
		}else {
			d=b*b-4*a*c;
			if(d>0) {
				x1=(-b-Math.sqrt(d))/(2*a);
				x2=(-b+Math.sqrt(d))/(2*a);
				System.out.print("Phương trình có 2 nghiệm là :" + x1 + "," + x2);
			}else if(d==0){
				x1=(-b)/(2*a);
				System.out.print("Phương trình có nghiệm kép là :" + x1);
			}else {
				System.out.print("Phương trình vô nghiệm");
			}
		}
		input.nextLine();
		System.out.println("Nhập enter để tiếp tục");
		input.nextLine();
	}
	public static void timmm() {
		System.out.println("Tìm MIN MAX trong mảng:");
		System.out.println("--------------------------");
		int size,max=0,min=0,a=0,b=0,dem=1;
		Scanner input = new Scanner(System.in);
		System.out.print("Bạn muốn so sánh bao nhiêu số :");
		size = input.nextInt();
		int[] array= new int[size];
		
		for (int i=0;i < size ;i++) {
			System.out.print("Nhập số cần so sánh thứ " +dem +":");
			array[i]=input.nextInt();
			min = array[i];			
			dem++;
		}
		System.out.print("các số được so sánh là :");
		for (int j=0; j<size ;j++) {
			if (max <= array[j]) {
				max = array[j];
				a=j+1;
			}
			if (min >= array[j]) {
				min = array[j];
				b=j+1;
			}
			
			System.out.print(array[j] + "\t");
		}
		System.out.println("\nSố lớn nhất tìm được là số : "+max + " vị trí thứ " +a +" trong các số");
		System.out.println("Số lớn nhất tìm được là số : "+min + " vị trí thứ " +b +" trong các số");
		input.nextLine();
		System.out.println("Nhập enter để tiếp tục");
		input.nextLine();
	}
	public static void ketthuc() {
		System.out.println("kết thúc chương trình cám ơn!");
		System.exit(0);
	}
	public static void myMenu() {
		while(true) {
		System.out.println("____________________________");
		System.out.println("|==========================|");
		System.out.println("|----CHỌN LỰA CHỨC NĂNG----|");
		System.out.println("|--------------------------|");
		System.out.println("|-----1.Tính tổng 2 số-----|");
		System.out.println("|-2.Giả phương trình bậc 2-|");
		System.out.println("|-3.Tìm max min trong mảng-|");
		System.out.println("|==========================|");
		System.out.println("|--4.Kết thúc chương trình-|");
		System.out.println("____________________________");
		System.out.print("Nhập chức năng mà bạn muốn thực hiện");
		int a = input.nextInt();
		if (a==1) {
			tinhtong();
		}else if(a==2) {
			giaipt();
		}else if(a==3) {
			timmm();
		}else {
			ketthuc();
		}
		}
	}
}
