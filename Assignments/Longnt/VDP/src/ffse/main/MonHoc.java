package ffse.main;

import java.util.ArrayList;
import java.util.Scanner;
import ffse.model.Ten;
public class MonHoc {
	public static Scanner myInput = new Scanner(System.in);
	static String ten;
	
	static Ten ojbTen = new Ten();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		nhapTen();
	}
	public static void nhapTen() {
		while(true) {
			System.out.println("nhập vào tên của bạn");
			ten = myInput.nextLine();
			ojbTen.setHoTen(ten);
			if(ten.isEmpty()) {
				System.out.println("vui lòng nhập tên");
			} else {
				menu();
			}
		}
	}
	public static void menu() {
		
			System.out.println("Danh sach bai toan");
			System.out.println("1. Mang sách toán");
			System.out.println("2. Mang sách lý");
			System.out.println("3. Mang sách hóa");
			System.out.print("Vui long nhap so de chon: ");
			int x = myInput.nextInt();
			switch (x) {
			case 1:
				ojbTen.mangToan();
				break;
			case 2:
				ojbTen.mangLy();
				break;
			
			case 3:
				ojbTen.mangHoa();
				break;
			}
		}
	}
	
	

