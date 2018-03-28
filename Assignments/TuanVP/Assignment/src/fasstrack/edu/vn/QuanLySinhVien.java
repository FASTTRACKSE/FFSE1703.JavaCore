package fasstrack.edu.vn;

import java.util.Scanner;

public class QuanLySinhVien {
	private static Scanner myInput= new Scanner(System.in);
	public static int Sv;
	public static SinhVien []Sinhvien;
	public static void main(String[] args) {	
		menu();
	}
	public static void menu() {
		while (true) {
			int x ;
			System.out.println("Xin chon chuong trinh duoi day:");
			System.out.println("1. Nhap thong tin sinh vien.");
			System.out.println("2. Danh sach sinh vien.");
			System.out.println("3. Danh sach sinh vien tieu bieu.");
			System.out.println("4. Sap xep danh sach sinh vien theo diem trung binh tu cao den thap.");
			System.out.println("5. Sap xep danh sach sinh vien theo ho ten.");
			System.out.println("6. Ket thuc chuong trinh.");
			System.out.print("Vui long nhap so de chon bai toan: ");
			x = myInput.nextInt();
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
				ketthuc();
				break;
			}
		}
	}
	public static void ThongtinSV() {
		System.out.print("\n");
		System.out.print("Nhap so luong sinh vien: ");
		Sv = Sv + myInput.nextInt();
		Sinhvien = new SinhVien[Sv];
		for(int i = 0; i <Sv; i++) {
			Sinhvien[i] = new SinhVien();
		}
		for (int i = 0; i < Sv; i++) {
			System.out.print("Nhap ten sinh vien: ");
			String Hoten = myInput.next();
			Sinhvien[i].setHoten(Hoten);
			System.out.print("Nhap ngay sinh sinh vien: ");
			String Ngaysinh = myInput.next();
			Sinhvien[i].setNgaysinh(Ngaysinh);
			System.out.print("Nhap diem LP1: ");
			float DiemLP1 = myInput.nextFloat();
			Sinhvien[i].setDiemLP1(DiemLP1);
			System.out.print("Nhap diem LP2: ");
			float DiemLP2 = myInput.nextFloat();
			Sinhvien[i].setDiemLP2(DiemLP2);
		}
		myInput.nextLine();
		System.out.print("\n");
		System.out.print("\n");
		myInput.nextLine();
	}
	public static void Danhsach() {
		System.out.print("\n");
		System.out.printf("%-12s %-12s %-12s %-12s %-12s %-12s \n","Ten","Ngay sinh","Diem LP1","Diem LP2","Diem TB","Xep Loai");
		for (int i = 0; i < Sv ; i++) {
			System.out.printf("%-12s %-12s %-12.2f %-12.2f %-12.2f %-12s \n",Sinhvien[i].getHoten(),Sinhvien[i].getNgaysinh(),Sinhvien[i].getDiemLP1(),Sinhvien[i].getDiemLP2(),Sinhvien[i].getDiemTB(),Sinhvien[i].getXeploai());
		}
		myInput.nextLine();
		System.out.print("\n");
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
	public static void ketthuc() {
		System.out.println("\n");
		System.out.println("Cam on ban da su dung chuong trinh!");
		System.exit(0);
	}	

}