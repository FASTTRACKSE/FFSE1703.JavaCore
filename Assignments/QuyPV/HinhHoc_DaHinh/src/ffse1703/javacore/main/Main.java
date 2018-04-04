package ffse1703.javacore.main;
import ffse1703.javacore.model.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
	private Scanner myInput = new Scanner(System.in);
	private ArrayList<HinhHoc> arrHinhHoc = new ArrayList<>(); 
	
	public static void main(String[] args) {
		
//		HinhHoc hinhTron = new HinhTron(5);
//	HinhHoc hinhChuNhat = new HinhChuNhat("a", 10, 5);
//		HinhHoc hinhTamGiac = new HinhTamGiac(2, 3, 4);
//		
//		hinhTron.getChuVi();
//		hinhTron.getDienTich();
//		
//		hinhChuNhat.getChuVi();
//		hinhChuNhat.getDienTich();
//		
//		hinhTamGiac.getChuVi();
//		hinhTamGiac.getDienTich();
		
		Main main = new Main();
		main.menu();
		
//		System.out.printf("|%-10.5s| \n","a");
//		System.out.printf("|%-5s%-5s|", "c", "d" );
	}
	
	public void menu() {
		while(true) {
			System.out.println("---  lỰA CHỌN CHỨC NĂNG  ---");
			System.out.println("____________________________" + "\n");
			System.out.println("1. Tính diện tích hình chữ nhật.");
			System.out.println("2. Tính diện tích hình tròn.");
			System.out.println("3. Tính diện tích hình tam giác.");
			System.out.println("4. Tính diện tích hình vuông.");
			System.out.println("5. In.");
			System.out.println("0. Kết thúc.");
			System.out.println("____________________________" + "\n");
	
			System.out.println("Nhập lựa chọn của bạn: ");
			
			int chose = Integer.parseInt(myInput.nextLine()); 
			
			if(chose == 1) {
				hinhChuNhat();
			} else if(chose == 2) {
				hinhTron();
			} else if(chose == 3) {
				hinhTamGiac();
			} else if(chose == 4) {
				hinhVuong();
			} else if(chose == 5) {
				in();
			} else if(chose == 0) {
				ketThuc();
			}
		}
	}
	
	public void hinhChuNhat() {
		System.out.println("Nhập chiều rộng: ");
		double cr = Double.parseDouble(myInput.nextLine());
		System.out.println("Nhập chiều dài: ");
		double cd = Double.parseDouble(myInput.nextLine());
		
		arrHinhHoc.add(new HinhChuNhat(cd, cr));
	}
	
	public void hinhTron() {
		System.out.println("Nhập bán kính: ");
		double bk = Double.parseDouble(myInput.nextLine());
		
		arrHinhHoc.add(new HinhTron(bk));
	}
	
	public void hinhTamGiac() {
		System.out.println("Nhập độ dài cạnh a: ");
		double a = Double.parseDouble(myInput.nextLine());
		System.out.println("Nhập độ dài cạnh b: ");
		double b = Double.parseDouble(myInput.nextLine());
		System.out.println("Nhập độ dài cạnh c: ");
		double c = Double.parseDouble(myInput.nextLine());
		
		arrHinhHoc.add(new HinhTamGiac(a, b, c));
		
	}
	
	public void hinhVuong() {
		System.out.println("Nhập độ dài cạnh a: ");
		double a = Double.parseDouble(myInput.nextLine());
		
		arrHinhHoc.add(new HinhVuong(a));
		
	}
	
	public void ketThuc() {
		
	}
	
	public void in() {
		
		System.out.printf("|%-20s|%-60s|%-30s|%-30s| \n", "Hình","Thuộc tính","Chu vi", "Diện tích");
		
		for(HinhHoc x : arrHinhHoc) {
			if(x instanceof HinhChuNhat) {
				System.out.printf("|%-20s|%-30s%-30s|%-30s|%-30s| \n", "Hình chữ nhật", "Chiều dài: "+((HinhChuNhat) x).getChieuDai() + ", ", "Chiều rộng: "+((HinhChuNhat) x).getChieuRong() + ", ", x.getChuVi(), x.getDienTich());
			}
			else if(x instanceof HinhTron) {
				System.out.printf("|%-20s|%-60s|%-30s|%-30s| \n", "Hình tròn: ", "Bán kính: "+((HinhTron) x).getBanKinh(), x.getChuVi(), x.getDienTich());
			}
			else if(x instanceof HinhTamGiac) {
				System.out.printf("|%-20s|%-20s%-20s%-20s|%-30s|%-30s| \n", "Hình tam giác", "Cạnh a: "+((HinhTamGiac) x).getCanhA() + ", ", "Cạnh b: "+((HinhTamGiac) x).getCanhB() + ", ", "Cạnh c: "+((HinhTamGiac) x).getCanhC() + ", ", x.getChuVi(), x.getDienTich());
			}
			else if(x instanceof HinhVuong) {
				System.out.printf("|%-20s|%-60s|%-30s|%-30s| \n", "Hình vuông", "Cạnh a: "+((HinhVuong) x).getCanhA(), x.getChuVi(), x.getDienTich());
			}
		}
	}
}
