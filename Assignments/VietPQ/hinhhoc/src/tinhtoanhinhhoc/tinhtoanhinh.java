package tinhtoanhinhhoc;

import hinhhoc.*;

import java.util.ArrayList;
import java.util.Scanner;

public class tinhtoanhinh {
	public Scanner input = new Scanner(System.in);
	static ArrayList<hinhhoc> arrHinhhoc = new ArrayList<>();

	public static void main(String[] args) {
		tinhtoanhinh a = new tinhtoanhinh();
		a.myMenu();
	}

	public void chunhat() {
		System.out.println("TINH CHU VI & DIEN TÍCH HINH CHU NHAT");
		System.out.println("=====================================");
		System.out.print("Nhap chieu dai cua hinh chu nhat : ");
		int chieuDai = input.nextInt();
		System.out.print("Nhap chieu rong cua hinh chu nhatt : ");
		int chieuRong = input.nextInt();
		arrHinhhoc.add(new hinhchunhat(chieuDai, chieuRong));
		System.out.println("<==========Thong Tin Nhap Vao==========>");
		System.out.println("| Chieu Dai | Chieu Rong |  Chu Vi |  Dien Tich | ");
		for (hinhhoc x : arrHinhhoc) {
			if (x instanceof hinhchunhat) {
				System.out.printf("%-10s %-15s %-15s %-10s \n", ((hinhchunhat) x).getChieuDai(),
						((hinhchunhat) x).getChieuRong(), x.getChuVi(), x.getDienTich());
			}
		}
	}

	public void tamgiac() {
		System.out.println("TINH CHU VI HINH TAM GIAC");
		System.out.println("=========================");
		System.out.print("Nhap canh thu nhat cua hinh tam giac : ");
		int canhA = input.nextInt();
		System.out.print("Nhap canh thu hai cua hinh tam giac : ");
		int canhB = input.nextInt();
		System.out.print("Nhap canh thu ba cua hinh tam giac : ");
		int canhC = input.nextInt();
		arrHinhhoc.add(new hinhtamgiac(canhA, canhB, canhC));

		System.out.println("<==========Thong tin nhap vao==========>");
		System.out.println("|  Canh A  |   Canh B     |     Canh C  | Chu Vi | Dien Tich |");
		for (hinhhoc x : arrHinhhoc) {
			if (x instanceof hinhtamgiac) {
				System.out.printf("%-10s %-15s %-15s %-10s %-10s \n", ((hinhtamgiac) x).getCanhA(),
						((hinhtamgiac) x).getCanhB(), ((hinhtamgiac) x).getCanhC(), x.getChuVi(), x.getDienTich());
			}
		}
	}

	public void tron() {
		System.out.println("TINH CHU VI VA DIEN TINH HINH TRON");
		System.out.println("==================================");
		System.out.print("Nhap ban kinh hinh tron : ");
		double banKinh = input.nextDouble();
		arrHinhhoc.add(new hinhtron(banKinh));
		System.out.println("<==========Thong tin nhap vao==========>");
		System.out.println("| Ban Kinh |  Chu Vi |  Dien Tich | ");
		for (hinhhoc x : arrHinhhoc) {
			if (x instanceof hinhtron) {
				System.out.printf("%-10s %-15s %-15s \n", ((hinhtron) x).getBanKinh(), x.getChuVi(), x.getDienTich());
			}
		}
	}

	public void ketThuc() {
		System.out.println("Ket thuc chuong trinh");
		System.out.println("======================");
		System.out.println("=======Tkank you======");
		System.exit(0);
	}

	public void myMenu() {
		while (true) {
			System.out.println("+============================================+");
			System.out.println("|==============LUA CHON CHUC NANG============|");
			System.out.println("|1.Tinh chu vi & Dien tich hinh Chu Nhat     |");
			System.out.println("|2.Tinh chu vi & Dien tich hinh Hinh Tam Giac|");
			System.out.println("|3.Tinh chu vi & Dien tich hinh Tron---------|");
			System.out.println("|4.Ket thuc chuong trinh                     |");
			System.out.println("+============================================+");
			System.out.println("             LUA CHUC NANG CUA BAN            ");
			int act = Integer.parseInt(input.nextLine());
			if (act == 1) {
				tron();
			} else if (act == 2) {
				tamgiac();
			} else if (act == 3) {
				chunhat();
			} else if (act == 5) {

			} else if (act == 4) {
				ketThuc();
			}
			input.nextLine();
			System.out.println("=====================================");
			System.out.println("-------Bam ENTER de tiep tuc------");
			input.nextLine();
		}
	}
}