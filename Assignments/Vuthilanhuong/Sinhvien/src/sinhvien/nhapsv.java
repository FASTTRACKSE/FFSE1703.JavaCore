package sinhvien;
import java.util.Scanner;
public class nhapsv {
	public static SV sv=new SV();
	public static SV arr[];
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[]args) {
		menu();
	}
	public static void nhap() {
		System.out.println("Bạn muốn nhập bao nhiêu sinh viên");
		int b = sc.nextInt();
		arr=new SV[b];
		for(int i=0; i<b; i++) {
			sv=new SV();
			sc.nextLine();
			System.out.println("Tên sinh viên thứ " +(i+1));
			String hoten=sc.nextLine();
			sv.setHoten(hoten);
			System.out.println("Ngày sinh");
			String ntnsinh=sc.nextLine();
			sv.setNtnsinh(ntnsinh);
			System.out.println("Điểm lp1");
			Double lp1=sc.nextDouble();
			sv.setLp1(lp1);
			System.out.println("Điểm lp2");
			Double lp2=sc.nextDouble();
			sv.setLp2(lp2);
			arr[i]=sv;
		}
		sc.nextLine();
		System.out.println("Nhập enter để tiếp tục");
		sc.nextLine();
	}
	public static void in() {
		System.out.println("Tên   Ngày sinh   Lp1    LP2  Điểm tb");
			for(int i=0; i<arr.length; i++) {
				System.out.println(arr[i].getHoten()+"\t"+ arr[i].getNtnsinh()+"\t" +arr[i].getLp1()
						+"\t"+arr[i].getLp2()+"\t"+arr[i].getTb());
			}
			sc.nextLine();
			System.out.println("Nhập enter để tiếp tục");
			sc.nextLine();
		}
	public static void caothap() {
		int stt=0, stt1=0; 
		Double max=arr[0].getTb(); Double min=arr[0].getTb();
		for(int i=0; i<arr.length; i++) {
			if(max<arr[i].getTb()) {
				max=arr[i].getTb();
				stt=i;
			}
			if(min>arr[i].getTb()) {
				min=arr[i].getTb();
				stt1=i;
			}
		}
		System.out.println("Điểm trung bình cao nhất là: "+arr[stt].getHoten()+" "+"với số điểm là "+max);
		System.out.println("Điểm trung bình thấp nhất là: "+arr[stt1].getHoten()+" "+"với số điểm là "+min);
		sc.nextLine();
		System.out.println("Nhập enter để tiếp tục");
		sc.nextLine();
	}
	public static void sxeptb() {
		 SV[] temp =new SV[arr.length];
	        for (int i = 0 ; i <arr.length - 1; i++) {
	            for (int j = i + 1; j < arr.length; j++) {
	            	if(arr[i].getTb()<arr[j].getTb()){
	            		temp[i] = arr[j];
	            		arr[j]=arr[i];
	            		arr[i]=temp[i];
	            	} 
	            }
	        }
	        System.out.println("Họ tên   Ngày sinh   Lp1   Lp2    Điểm tb");
	        for (int i = 0; i < arr.length; i++) {
	        	System.out.println(arr[i].getHoten()+"\t"+ arr[i].getNtnsinh()+"\t" +arr[i].getLp1()
						+"\t"+arr[i].getLp2()+"\t"+arr[i].getTb());
	        }
	        sc.nextLine();
			System.out.println("Nhập enter để tiếp tục");
			sc.nextLine();
	}
	 public static void xeploai() {
		 System.out.println("Tên   Ngày sinh   Lp1    LP2  Điểm tb  Xếp loại");
		 for(int i=0; i<arr.length; i++) {
			 System.out.println(arr[i].getHoten()+"\t"+ arr[i].getNtnsinh()+"\t" +arr[i].getLp1()
						+"\t"+arr[i].getLp2()+"\t"+arr[i].getTb()+"\t"+arr[i].getXepLoai());
		  
		 }
		 sc.nextLine();
			System.out.println("Nhập enter để tiếp tục");
			sc.nextLine();
	  }
	public static void kthuc() {
		System.out.println("Chào tạm biệt");
		System.exit(0);
	}
	public static void menu() {
		while(true) {
		System.out.println("1. Nhập danh sách sinh viên");
		System.out.println("2. In danh sách sinh viên");
		System.out.println("3. Sinh viên có điểm cao nhất và thấp nhất");
		System.out.println("4. Sắp xếp theo trung bình");
		System.out.println("5. Xếp loại");
		System.out.println("6. Kết thúc");
		System.out.println(" Chọn Chức Năng Bạn Muốn Nhập");
		int a= sc.nextInt();
		if (a==1) {
			nhap();
		}
		else if (a==2) {
			in();
		}
		else if (a==3) {
			caothap();
		}
		else if (a==4) {
			sxeptb();
		}
		else if (a==5) {
			xeploai();
		}
		else if (a==6) {
			kthuc();
		}
		}
	}
}
