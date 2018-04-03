import java.util.Scanner;

public class Maytinh {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("MÁY TÍNH CÁ NHÂN ");
		System.out.print(" 1.Phép cộng");
		System.out.print(" 2.Phép trừ");
		System.out.print(" 3.Kết thúc");
		System.out.print(" <<Chọn chức năng>>");
		Scanner myInput = new Scanner(System.in);
		int so1 = myInput.nextInt();
		if (so1 == 1) {
			System.out.print(" Nhập vào 1 số : ");
			Scanner my = new Scanner(System.in);
			int c1 = my.nextInt();
			System.out.print(" Nhập vào 1 số : ");
			Scanner m = new Scanner(System.in);
			int c2 = m.nextInt();
			int K = c1 + c2;
			System.out.printf(c1 + "+" + c2 + "=" + K);
		} else if (so1 == 2) {
			System.out.print(" Nhập vào 1 số : ");
			Scanner my = new Scanner(System.in);
			int c1 = my.nextInt();
			System.out.print(" Nhập vào 1 số : ");
			Scanner m = new Scanner(System.in);
			int c2 = m.nextInt();
			int K = c1 - c2;
			System.out.printf(c1 + "-" + c2 + "=" + K);
		} else if (so1 == 3) {
			System.exit(0);
		}
	}
}
