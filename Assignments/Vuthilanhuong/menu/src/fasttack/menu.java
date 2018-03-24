package fasttack;
import java.util.Scanner;

public class menu {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		menu();
		
	}
	public static void tinhtong(){
		System.out.println("tính tổng");
		int a,b,c;
		System.out.println("nhập số a");
		a= sc.nextInt();
		System.out.println("nhập số b");
		b= sc.nextInt();
		c= a+b;
		System.out.println("tổng 2 số là: "+c);
		sc.nextLine();
		System.out.println("nhập enter để tiếp tục" );
		sc.nextLine();
		
	}
	public static void giaiphuongtrinh() {
		System.out.println("giải phương trình");
		int a,b,c;
		Scanner sc = new Scanner(System.in);
		double x1,x2,d;
		System.out.println("phương trình bậc 2 có dạng: ax^2+bx+c=0");
		System.out.print("nhập hệ số a:");
		a = sc.nextInt();
		
		System.out.print("nhập hệ số b:");
		b = sc.nextInt();
		
		System.out.print("nhập hệ số c:");
		c = sc.nextInt();
		if(a==0) {
			if(b==0) {
				if(c!=0) {
					System.out.println("phương trinh vô nghiệm");
				}else {
					System.out.println("phương trinh vô số nghiệm");
				}
			}else {
				x1 = (-c/b);
				System.out.println("phương trinh có 1 nghiệm là:" +x1);
			}
		}else {
			d=b*b-4*a*c;
			if(d>0) {
					x1=(-b+Math.sqrt(d))/(2*a);
					x2=(-b-Math.sqrt(d))/(2*a);
					System.out.println("phương trinh có 2 nghiệm là:" +x1 +"," +x2);
			}else if(d<0) {
				System.out.println("phương trinh có vô nghiệm" );
			}else {
				x1 = (-b)/(2*a);
				System.out.println("phương trinh có nghiệm kép là:" );
			}
			sc.nextLine();
			System.out.println("nhập enter để tiếp tục" );
			sc.nextLine();
		}
	}
	public static void min_max() {
		System.out.println("min max");
		int dai, max=0,min=0,c=1,a=0,b=0;
		Scanner sc = new Scanner(System.in);
		System.out.print("bạn muốn so sánh bao nhiêu số: ");
		dai= sc.nextInt();
		 // Khai báo và khởi tạo giá trị ban đầu cho mảng
	    // mảng này có tên là mang và kích thước = dai
		int[]mang = new int[dai];
		for (int i=0; i<dai; i++) {
			System.out.print("nhập số thứ " +c+" : ");
			mang[i]=sc.nextInt();
			min = mang[i];
			c=i+1;
		}
		System.out.print("các số cần so sánh là: ");
		for(int j=0; j<dai; j++) {
			if (max <= mang[j]) {
				max=mang[j];
			}
			if (min >= mang[j]) {
				min=mang[j];
				b=j+1;
			}
			System.out.print(mang[j] + "\t");
		}
		System.out.println("\nsố lớn nhất là: "+ max + " vị trí thứ " +a);
		System.out.println("số nhỏ nhất là: "+ min + " vị trí thứ " +b);
		sc.nextLine();
		System.out.println("nhập enter để tiếp tục" );
		sc.nextLine();
	
		}

	public static void ketthuc(){
		System.out.println("kết thúc");
		System.exit(0);
	}
	
	public static void  menu(){
		while(true) {
		System.out.println("CHỌN CHỨC NĂNG");
		System.out.println("1. chương trình tính tổng");
		System.out.println("2. phương trình bậc 2");
		System.out.println("3. tìm min max");
		System.out.println("4.KẾT THÚC CHƯƠNG TRÌNH");
		System.out.println("nhập chức năng bạn muốn thực hiện: ");
		int a = sc.nextInt();
		if(a==1) {
			tinhtong();
		}
		else if(a==2) {
			giaiphuongtrinh();
		}
		else if(a==3) {
			min_max();
		}
		else { 
			ketthuc();
		}
	}
	}
	
}

