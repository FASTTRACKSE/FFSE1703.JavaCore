package sv;
import java.util.Scanner;
public class sv {
	public static Scanner sc = new Scanner(System.in);
	public static String[] tensv ;
	public static String[] ntnsinh;
	public static Double[] diemlp1 ;
	public static Double[] diemlp2;
	public static Double[] diemtb;
	public static int i=0,a=0,z=0,n=0,b=0,c=0;
	public static void main(String[] args) {
	menu();
	
	}
	public static void nhap() {
	 System.out.println("nhập sinh viên: ");
	 System.out.println("bạn muốn nhập bao nhiêu sinh viên: ");
	 
	  a= sc.nextInt();
	  // khởi tạo arr
	 	tensv  = new String [a];
	 	ntnsinh = new String [a];
	 	diemlp1 = new Double [a];
		diemlp2 = new Double [a];
		diemtb = new Double [a];
	 for(; i<a; i++) {
		 sc.nextLine();
		 System.out.println("nhập tên sinh viên thứ" +(i+1) +":");
		 tensv[i]=sc.nextLine();
		 System.out.println("nhập ngày tháng năm sinh của sinh viên thứ" +(i+1) +":");
		ntnsinh[i]=sc.nextLine();
		 System.out.println("nhập điểm lp1 sinh viên thứ" +(i+1) +":");
		 diemlp1[i]=sc.nextDouble();
		 System.out.println("nhập điểm lp2 sinh viên thứ" +(i+1) +":");
		 diemlp2[i]=sc.nextDouble();
		 
		 diemtb[i]= (diemlp1[i]+ diemlp2[i])/2;
		 
	 }
	 sc.nextLine();
		System.out.println("nhập enter để tiếp tục" );
		sc.nextLine();
	}
	public static void in() {
	 System.out.println("in sinh viên: "); 
	 System.out.println("danh sách sinh viên là");
	 System.out.println("tên sinh viên  ngày tháng năm sinh  điểm lp1  điểm lp2   điểm tb");
	 for(int j=0; j<a ; j++) {
		 System.out.print(tensv[j] +"\t"+"\t");
		 System.out.print(ntnsinh[j] +"\t"+"\t");
		 System.out.print(diemlp1[j] +"\t"+"\t");
		 System.out.print(diemlp2[j] +"\t"+"\t");
		 System.out.println(diemtb[j] +"\t");
	 }
	 sc.nextLine();
		System.out.println("nhập enter để tiếp tục" );
		sc.nextLine();
	}
	public static void tb() { 
    
                Double max; max=diemtb[0]; Double min; min=diemtb[0];
                for(int z=1;z<a;z++) {
                	if (max < diemtb[z]) {
        				max=diemtb[z];
        				b=z+1;
        		    if (min >diemtb[z]) {
        		    	min=diemtb[z];
        		    	c=z+1;
        		    }		

                }
                System.out.println("Sinh viên có điểm trung bình cao nhất là:"+" " +max+"vị trí thứ"+" "+b);
                System.out.println("Sinh viên có điểm trung bình nhỏ nhất là:"+" " + min+"vị trí thứ"+" "+c);
                }
                System.out.println("nhập enter để tiếp tục" );
        		sc.nextLine();
	}
	public static void ketthuc() {
	 System.out.println("kết thúc chương trình: "); 
	 System.exit(0);
	}
	public static void sapxep() {
		System.out.println("");
	}
	public static void menu(){
		while(true) {
		
		System.out.println("CHỌN CHỨC NĂNG");
		System.out.println("1. nhập danh sách");
		System.out.println("2. in danh sach");
		System.out.println("3. in điểm trung bình cao nhất ");
		System.out.println("4. sắp xếp điểm trung bình");
		System.out.println("5. kết thúc");
		System.out.println("nhập chức năng bạn muốn thực hiện: ");
		int b = sc.nextInt();
		if(b==1) {
			nhap();
		}
		else if(b==2) {
			in();
		}
		else if(b==3) {
			tb();
		}
		else if(b==4) {
			sapxep();
		}
		else {
			ketthuc();
		}
		}
	}
}
