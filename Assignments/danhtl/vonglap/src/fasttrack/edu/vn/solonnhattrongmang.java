package fasttrack.edu.vn;
import java.util.Scanner;
public class solonnhattrongmang {
	public static void main (String[] args) {
		int n, i, nho, lon;
		Scanner myInput = new Scanner(System.in);
		System.out.println("Nhập tổng phần tử trong mảng a[] là" );
		n = myInput.nextInt();
		 int[] a = new int[n];
		 for (i=0; i < n; i++) {
			 System.out.println("nhập giá trị phần tử a[" + i +"] là ");
	            a[i] = myInput.nextInt();

		 }
		 nho=a[0];
		 lon=a[0];
			int x=1,y=1;
			
			for(i=0;i<n;i++) {
				if(nho>a[i]) {
					nho=a[i];
					x= i+1;
					} 
				  }

			System.out.println("Số nhỏ nhất trong "+ n +" phần tử là :"+ nho);
			
			System.out.println("Là phần tử thứ "+x);
			
			for(i=0;i<n;i++) {
				if(lon<a[i]) {
					lon=a[i];
					y= i+1;
					}	
				  }
			
			System.out.println("Số lớn nhất trong "+ n +" phần tử là :"+ lon);
			
			System.out.println("Là phần tử thứ "+y);	
			}
		}