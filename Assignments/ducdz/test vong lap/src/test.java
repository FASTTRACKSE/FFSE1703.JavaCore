import java.util.Scanner;
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner myInput = new Scanner(System.in);
		int x;
		System.out.print("Nhap so phan tu cua mang :");
		x = myInput.nextInt();
		int a[] = new int[x];
		for (int i=0;i<x;i++) {
			System.out.print("Gia tri cua phan tu "+(i+1)+" : ");
			a[i] = myInput.nextInt();
		}
		int max;
		int min;
		max = a[0];
		min = a[0];
		int vi_tri_max=0;
		int vi_tri_min=1;
		for (int i=0;i<x;i++) {
			if (max<a[i]) {
				max=a[i];
				vi_tri_max=i+1;
			}
		}
		
		for (int i=0;i<0;i++) {
			if(min>a[i]) {
				min=a[i];
				vi_tri_min=i+1;
			}
		}
		System.out.println("Gia tri lon nhat : "+max);
		System.out.println("Gia tri nho nhat : "+min);
		System.out.println("Vi tri nho nhat : "+vi_tri_min);
		System.out.println("Vi tri lon nhat : "+vi_tri_max);
	}
}
