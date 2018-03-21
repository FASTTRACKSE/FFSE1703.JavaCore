package text1;

import java.util.Scanner;

public class phuongtinhbac2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a, b, c;
		double denta, b2, x1, x2, candenta, x;
		Scanner myInput = new Scanner(System.in);
		System.out.print("Nhập vào số a :");
		a = myInput.nextInt();
		System.out.print("Nhập vào sô b :");
		b = myInput.nextInt();
		System.out.print("Nhập vào số c :");
		c = myInput.nextInt();
		System.out.println("Phương trình :" + a + "x2 +" + b + "x + " + c + " = 0");

		if (a == 0) {
			if (b == 0) {
				if (c == 0) {
					System.out.println("phương trình có vô số nghiệm");
				} else {
					System.out.println("phương trình có vô số nghiệm");
				}
			} else {
				x = -c / b;
				System.out.println("phương trình có 1 nghiệm =" + x);
			}

		} else {
			denta = b * b - 4 * a * c;
			if (denta > 0) {
				candenta = Math.sqrt(denta);
				x1 = (-b + candenta) / (2 * a);
				x2 = (-b - candenta) / (2 * a);
				System.out.println("phương trình có hai nghiệm phân biệt:");
				System.out.println("x1 = " + x1);
				System.out.println("x2 = " + x2);
			} else if (denta == 0) {
				x = -b / 2 * a;
				System.out.println("phương trình có 1 nghiệm kép =" + x);
			} else {
				System.out.println("phương trình vô nghiệm");
			}
<<<<<<< HEAD

=======
			
>>>>>>> cdef573be80f1cf2597c87b73bb79793df199958
		}

	}

}
