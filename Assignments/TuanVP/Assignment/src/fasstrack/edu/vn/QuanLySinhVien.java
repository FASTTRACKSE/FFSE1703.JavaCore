package fasstrack.edu.vn;

import java.util.Scanner;
import java.util.ArrayList;

public class QuanLySinhVien {
	private static Scanner myInput= new Scanner(System.in);
	public static int Sv;
	public static SinhVien []Sinhvien;
	public static ArrayList<SinhVien> arrSinhVien = new ArrayList<SinhVien>();
	public static void main(String[] args) {	
		menu();
	}
	public static void menu() {
		while (true) {
			System.out.println("Xin chon chuong trinh duoi day:");
			System.out.println("1. Nhap thong tin sinh vien.");
			System.out.println("2. Danh sach sinh vien.");
			System.out.println("3. Danh sach sinh vien tieu bieu.");
			System.out.println("4. Sap xep danh sach sinh vien theo diem trung binh tu cao den thap.");
			System.out.println("5. Sap xep danh sach sinh vien theo ho ten.");
			System.out.println("6. Doi ten sinh vien.");
			System.out.println("7. Xoa sinh vien.");
			System.out.println("8. Ket thuc chuong trinh.");
			try {
				System.out.print("Vui long nhap so de chon bai toan: ");
				int x = myInput.nextInt();
				switch (x) {
				case 1:
					ThongtinSV();
					break;
				case 2:
					Danhsach();
					break;
				case 3:
					TieuBieu();
					break;
				case 4:
					DanhsachTB();
					break;
				case 5:
					DanhsachABC();
					break;
				case 6:
					renameSV();;
					break;
				case 7:
					removeSV();;
					break;
				case 8:
					ketthuc();
					break;
				}
			} catch (Exception e) {
				System.out.println("Xin hay nhap so!");
				myInput.nextLine();
			}		
		}
	}
	public static void ThongtinSV() {
		System.out.print("\n");
		System.out.print("Nhap so luong sinh vien: ");
		Sv = myInput.nextInt();
		Sinhvien = new SinhVien[Sv];
		for (int i = 0; i < Sv; i++) {
			Sinhvien[i] = new SinhVien();
			System.out.print("Nhap ten sinh vien: ");
			String Hoten = myInput.next();
			Sinhvien[i].setHoten(Hoten);
			System.out.print("Nhap ngay sinh vien: ");
			String Ngaysinh = myInput.next();
			Sinhvien[i].setNgaysinh(Ngaysinh);
			System.out.print("Nhap diem LP1: ");
			float DiemLP1 = myInput.nextFloat();
			Sinhvien[i].setDiemLP1(DiemLP1);
			System.out.print("Nhap diem LP2: ");
			float DiemLP2 = myInput.nextFloat();
			Sinhvien[i].setDiemLP2(DiemLP2);
			arrSinhVien.add(Sinhvien[i]);
		}
		myInput.nextLine();
		System.out.print("\n");
		myInput.nextLine();
	}
	public static void Danhsach() {
		System.out.print("\n");
		System.out.printf("%-12s %-12s %-12s %-12s %-12s %-12s \n","Ten","Ngay sinh","Diem LP1","Diem LP2","Diem TB","Xep Loai");
		for (SinhVien x: arrSinhVien) {
			System.out.printf("%-12s %-12s %-12.2f %-12.2f %-12.2f %-12s \n",x.getHoten(),x.getNgaysinh(),x.getDiemLP1(),x.getDiemLP2(),x.getDiemTB(),x.getXeploai());
		}
		myInput.nextLine();
		System.out.print("\n");
		myInput.nextLine();
	}
	public static void TieuBieu() {
		System.out.print("\n");
		int vt1 = 0,vt2 = 0;
		float min = 10,max = 0;
		for (int i = 0; i < Sinhvien.length; i++) {
			if (Sinhvien[i].DiemTB >= max) {
				max = Sinhvien[i].DiemTB;
				vt1=i;
			}
		}
		System.out.println("Danh sach hoc sinh cao diem nhat la "+Sinhvien[vt1].DiemTB+" voi diem trung binh la "+max);
		for (int i = 0; i < Sinhvien.length; i++) {
			if (Sinhvien[i].DiemTB <= min) {
				min = Sinhvien[i].DiemTB;
				vt2=i;
			}
		}
		System.out.println("Danh sach hoc sinh thap diem nhat la "+Sinhvien[vt2].DiemTB+" voi diem trung binh la "+min);
		myInput.nextLine();
		System.out.print("\n");
		System.out.print("\n");
		myInput.nextLine();
	}
	public static void DanhsachTB() {
		System.out.print("\n");
		SinhVien tmp = new SinhVien();
		for (int i = 0; i < Sinhvien.length-1; i++) {
			if (Sinhvien[i].DiemTB<Sinhvien[i+1].DiemTB) {
				 tmp = Sinhvien[i];
				 Sinhvien[i] =Sinhvien[i+1];
				 Sinhvien[i+1] = tmp;
			}
		}
		System.out.printf("%-12s %-12s %-12s %-12s %-12s %-12s \n","Ten","Ngay sinh","Diem LP1","Diem LP2","Diem TB","Xep Loai");
		for (int i = 0; i < Sv ; i++) {
			System.out.printf("%-12s %-12s %-12.2f %-12.2f %-12.2f %-12s \n",Sinhvien[i].getHoten(),Sinhvien[i].getNgaysinh(),Sinhvien[i].getDiemLP1(),Sinhvien[i].getDiemLP2(),Sinhvien[i].getDiemTB(),Sinhvien[i].getXeploai());
		}
		myInput.nextLine();
		System.out.print("\n");
		myInput.nextLine();
	}
	public static void DanhsachABC() {
		System.out.print("\n");
		SinhVien tmp = new SinhVien();
		for (int i = 0; i < Sinhvien.length-1; i++) {
			if ((Sinhvien[i].getHoten()).compareTo(Sinhvien[i+1].getHoten())>0) {
				 tmp = Sinhvien[i];
				 Sinhvien[i] =Sinhvien[i+1];
				 Sinhvien[i+1] = tmp;
			}
		}
		System.out.printf("%-12s %-12s %-12s %-12s %-12s %-12s \n","Ten","Ngay sinh","Diem LP1","Diem LP2","Diem TB","Xep Loai");
		for (int i = 0; i < Sv ; i++) {
			System.out.printf("%-12s %-12s %-12.2f %-12.2f %-12.2f %-12s \n",Sinhvien[i].getHoten(),Sinhvien[i].getNgaysinh(),Sinhvien[i].getDiemLP1(),Sinhvien[i].getDiemLP2(),Sinhvien[i].getDiemTB(),Sinhvien[i].getXeploai());
		}
		myInput.nextLine();
		System.out.print("\n");
		System.out.print("\n");
		myInput.nextLine();
	}
	public static void renameSV() {
		System.out.println("Do ten sinh vien");
		System.out.print("Ten sinh vien: ");
		String oldName = myInput.next();
		System.out.print("Ten moi: ");
		String newName = myInput.next();
		for (SinhVien x : arrSinhVien) {
			if ((x.getHoten()).equals(oldName)) {
				x.setHoten(newName);
			}
		}
	}
	public static void removeSV() {
		System.out.print("Ten sinh vien can xoa thong tin: ");
		String nameSV = myInput.next();
		for (SinhVien x : arrSinhVien) {
			if ((x.getHoten()).equals(nameSV)) {
				arrSinhVien.remove(x);
				break;
			}
		}
	}
	public static void ketthuc() {
		System.out.println("\n");
		System.out.println("Cam on ban da su dung chuong trinh!");
		System.exit(0);
	}	

}