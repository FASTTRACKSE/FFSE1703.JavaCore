package ffse1703.javacore.vn;

import java.util.Scanner;
import java.util.ArrayList;
public class Xuat {
	
	 public static void main(String[] args)
	 {
		
	    BienLai bienLai;
        ArrayList<BienLai> BL = new ArrayList<>();
		System.out.println("Nhập số lượng khách hàng:");
		Scanner input1= new Scanner(System.in);
		int n = input1.nextInt();
		int dem;
		for(int i=0; i<n; i++) {
			dem= i+1;
			bienLai = new BienLai();
			System.out.println("Khách hàng:");
			bienLai.nhapBienLai();
			BL.add(bienLai);
		}
		System.out.println("Thông tin biên lai của các hộ gia đình: ");
		for(int i=0; i<BL.size();i++) {
			dem= i+1;
			System.out.println("Thông  hộ gia đình ");
			BL.get(i).xuatBienLai();
		}
	 }
}