package fasstrack.edu.vn;

import java.util.Scanner;

public class QuanlySV {
	private static Scanner myInput= new Scanner(System.in);
	private static int Sv,Vt1,Vt2;
	private static Double tmp2;
	private static String SVcaodiem,SVthapdiem,tmp1;
	private static String []Hoten;
	private static String []Ngaysinh;
	private static Double []DiemLP1;
	private static Double []DiemLP2;
	private static Double []DiemTB;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		menu();
	}
	public static void menu() {
		while (true) {
			int x ;
			System.out.println("Xin chon chuong trinh duoi day:");
			System.out.println("1. Nhap thong tin sinh vien.");
			System.out.println("2. Danh sach sinh vien.");
			System.out.println("3. Danh sach sinh vien tieu bieu.");
			System.out.println("4. Sap xep sinh vien theo danh sach thu tu ABC.");
			System.out.println("5. Sap xep sinh vien theo danh sach DiemTB tu cao den thap.");
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
				DanhsachABC();
				break;
			case 5:
				DanhsachTB();
				break;
			case 6:
				ketthuc();
				break;
			}
		}
	}
	public static void ThongtinSV() {
		System.out.print("Nhap so luong sinh vien: ");
		Sv = myInput.nextInt();
		Hoten = new String[Sv];
		Ngaysinh = new String[Sv];
		DiemLP1 = new Double[Sv];
		DiemLP2 = new Double[Sv];
		DiemTB = new Double[Sv];
		for (int i = 0; i < Sv; i++) {
			System.out.print("Nhap ten sinh vien: ");
			Hoten[i] = myInput.next();
			System.out.print("Nhap ngay sinh sinh vien: ");
			Ngaysinh[i]=myInput.next();
			System.out.print("Nhap diem LP1: ");
			DiemLP1[i] = myInput.nextDouble();
			System.out.print("Nhap diem LP2: ");
			DiemLP2[i]=myInput.nextDouble();
			DiemTB[i] = (DiemLP1[i]+DiemLP2[i])/2;
		}
		myInput.nextLine();
		System.out.print("\n");
		System.out.print("\n");
		myInput.nextLine();
	}
	public static void Danhsach() {
		if (Sv==0) {
			ThongtinSV();
		} else {
			System.out.printf("%-12s %-12s %-12s %-12s %-12s \n","Ten","Ngay sinh","Diem LP1","Diem LP2","Diem TB");
			for (int i = 0; i < Sv ; i++) {
				System.out.printf("%-12s %-12s %-12s %-12s %-12s \n",Hoten[i],Ngaysinh[i],DiemLP1[i],DiemLP2[i],DiemTB[i]);
			}
			myInput.nextLine();
			System.out.print("\n");
			System.out.print("\n");
			myInput.nextLine();
		}
	}
	public static void TieuBieu() {
		if (Sv==0) {
			ThongtinSV();
		} else {
			double max = 0,min =DiemTB[0];
			for (int i = 0; i < Sv; i++) {
				if (DiemTB[i] >= max) {
					max = DiemTB[i];
					Vt1=i;
				}
				if (DiemTB[i] <= min) {
					min = DiemTB[i];
					Vt2=i;
				}
			}
			System.out.println("Danh sach hoc sinh cao diem nhat: "+Hoten[Vt1]);
			System.out.println("Danh sach hoc sinh thap diem nhat: "+Hoten[Vt2]);
			myInput.nextLine();
			System.out.print("\n");
			System.out.print("\n");
			myInput.nextLine();
		}
	}
	public static void DanhsachABC() {
		if (Sv==0) {
			ThongtinSV();
		} else {
			for (int i = 0; i < Sv-1; i++) {
				if (Hoten[i].compareTo(Hoten[i+1])>0) {
					tmp1= Hoten[i];
					Hoten[i]=Hoten[i+1];
					Hoten[i+1]=tmp1;
					tmp1 = Ngaysinh[i];
					Ngaysinh[i]=Ngaysinh[i+1];
					Ngaysinh[i+1]=tmp1;
					tmp2 = DiemLP1[i];
					DiemLP1[i]=DiemLP1[i+1];
					DiemLP1[i+1]=tmp2;
					tmp2 = DiemLP2[i];
					DiemLP2[i]=DiemLP2[i+1];
					DiemLP2[i+1]=tmp2;
					tmp2 = DiemTB[i];
					DiemTB[i]=DiemTB[i+1];
					DiemTB[i+1]=tmp2;
				}
			}
			System.out.printf("%-12s %-12s %-12s %-12s %-12s \n","Ten","Ngay sinh","Diem LP1","Diem LP2","Diem TB");
			for (int i = 0; i < Sv ; i++) {
				System.out.printf("%-12s %-12s %-12s %-12s %-12s \n",Hoten[i],Ngaysinh[i],DiemLP1[i],DiemLP2[i],DiemTB[i]);
			}
			myInput.nextLine();
			System.out.print("\n");
			System.out.print("\n");
			myInput.nextLine();
		}
	}

	public static void DanhsachTB() {
		if (Sv==0) {
			ThongtinSV();
		} else {
			for (int i = 0; i < DiemTB.length-1; i++) {
				if (DiemTB[i]<DiemTB[i+1]) {
					tmp1= Hoten[i];
					Hoten[i]=Hoten[i+1];
					Hoten[i+1]=tmp1;
					tmp1 = Ngaysinh[i];
					Ngaysinh[i]=Ngaysinh[i+1];
					Ngaysinh[i+1]=tmp1;
					tmp2 = DiemLP1[i];
					DiemLP1[i]=DiemLP1[i+1];
					DiemLP1[i+1]=tmp2;
					tmp2 = DiemLP2[i];
					DiemLP2[i]=DiemLP2[i+1];
					DiemLP2[i+1]=tmp2;
					tmp2 = DiemTB[i];
					DiemTB[i]=DiemTB[i+1];
					DiemTB[i+1]=tmp2;
				}
			}
			System.out.printf("%-12s %-12s %-12s %-12s %-12s \n","Ten","Ngay sinh","Diem LP1","Diem LP2","Diem TB");
			for (int i = 0; i < Sv ; i++) {
				System.out.printf("%-12s %-12s %-12s %-12s %-12s \n",Hoten[i],Ngaysinh[i],DiemLP1[i],DiemLP2[i],DiemTB[i]);
			}
			myInput.nextLine();
			System.out.print("\n");
			System.out.print("\n");
			myInput.nextLine();
		}
	}
	public static void ketthuc() {
		System.out.println("\n");
		System.out.println("Cam on ban da su dung chuong trinh!");
		System.exit(0);
	}	
}
