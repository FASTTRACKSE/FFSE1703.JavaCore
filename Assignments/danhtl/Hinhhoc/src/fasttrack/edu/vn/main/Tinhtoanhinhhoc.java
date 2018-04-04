package fasttrack.edu.vn.main;

import java.util.ArrayList;
import java.util.Scanner;

import fasttrack.edu.vn.model.*;

public class Tinhtoanhinhhoc {
	public static Scanner Scanner = new Scanner(System.in);
	public static ArrayList<Hinhhoc> arrHinhhoc = new ArrayList<Hinhhoc>();
	public static ArrayList<Hinhtamgiac> arrHinhtamgiac = new ArrayList<Hinhtamgiac>();
	public static ArrayList<hinhchunhat> arrhinhchunhat = new ArrayList<hinhchunhat>();
	public static ArrayList<hinhtron> arrhinhtron = new ArrayList<hinhtron>();
	public static Hinhtamgiac tamgiac = new Hinhtamgiac();
	public static hinhchunhat chunhat = new hinhchunhat();
	public static hinhtron tron = new hinhtron();

	public static void main(String[] args) {
		myMenu();
	}

	public static void myMenu() {
		while (true) {
			System.out.println(">>     Lựa chọn  chức năng bạn cần          <<");
			System.out.println("+------------------------------------------+");
			System.out.println("|1. Diện tích và chu vi hình tam giác       |");
			System.out.println("|2. Diện tích và chu vi hình chữ nhật       |");
			System.out.println("|3. Diện tích và chu vi hình tròn           |");
			System.out.println("|4. IN tất cả các giá trị của hình          |");
			System.out.println("|5. Kết thúc chương trình                   |");
			System.out.println("+----------------------------------------+");
			System.out.println(">>            Lựa chọn của bạn?         <<");
			int a;
			a = Scanner.nextInt();
			if (a == 1) {
				tamgiac();
			} else if (a == 2) {
				chunhat();
			} else if (a == 3) {
				hinhtron();
			} else if (a == 4) {
				inbang();
			} else if (a == 5) {
				ketThuc();
			}
		}

	}

	public static void tamgiac() {
		Scanner.nextLine();

		System.out.println("chiều dài  cạnh a là :");
		int canhA = Scanner.nextInt();
		System.out.println("chiều dài  cạnh b là :");
		int canhB = Scanner.nextInt();
		System.out.println("chiều dài  cạnh c là :");
		int canhC = Scanner.nextInt();

		Scanner.nextLine();
		tamgiac = new Hinhtamgiac(canhA, canhB, canhC);
		tamgiac.getChuVi();
		System.out.println("Chu vi hình tam giác là :" + tamgiac.getChuVi());
		tamgiac.getDienTich();
		System.out.println("Diện tích tam giác là :" + tamgiac.getDienTich());
		arrHinhhoc.add(new Hinhtamgiac(canhA, canhB, canhC));
		System.out.println("Ấn Enter để về Menu");
		Scanner.nextLine();

	}

	public static void chunhat() {
		Scanner.nextLine();
		System.out.println("chiều dài  hình chữ nhật là :");
		int chieudai = Scanner.nextInt();
		System.out.println("chiều rộng hình chữ nhật là :");
		int chieurong = Scanner.nextInt();
		Scanner.nextLine();
		chunhat = new hinhchunhat(chieudai, chieurong);
		chunhat.getChuVi();
		System.out.println("Chu vi hình chữ nhật là :" + chunhat.getChuVi());
		chunhat.getDienTich();
		System.out.println("Diện tích hình chữ nhật là :" + chunhat.getDienTich());
		arrHinhhoc.add(new hinhchunhat(chieudai, chieurong));
		System.out.println("Ấn Enter để về Menu");
		Scanner.nextLine();
	}

	public static void hinhtron() {
		Scanner.nextLine();
		System.out.println("Bán kính hình tròn  là :");
		int bankinh = Scanner.nextInt();
		Scanner.nextLine();
		tron = new hinhtron(bankinh);
		chunhat.getChuVi();
		System.out.println("Chu vi hình tròn là :" + tron.getChuVi());
		chunhat.getDienTich();
		System.out.println("Diện tích hình tròn là :" + tron.getDienTich());
		arrHinhhoc.add(new hinhtron(bankinh));
		System.out.println("Ấn Enter để về Menu");
		Scanner.nextLine();
	}

	public static void inbang() {
		System.out.println("====================================================================================");
		System.out.println("|STT  |       Hình      |  Thuộc tính      |      Chu vi      |      Diện tích     |");
		System.out.println("====================================================================================");
		int n = 1;
		for (Hinhhoc x : arrHinhhoc) {
			if ((x instanceof hinhtron)) {

				System.out.printf("|%-5s|%-17s|Bán kính :%-8s|%-18s|%.2f\n", n, "Tròn", ((hinhtron) x).getBankinh(),
						x.getChuVi(), x.getDienTich());

			} else if ((x instanceof hinhchunhat)) {
				System.out.printf("|%-5s|%-17s|cd:%-4s cr:%-7s|%-18s|%.2f\n", n, "Chữ Nhật",
						((hinhchunhat) x).getChieudai(), ((hinhchunhat) x).getChieurong(), x.getChuVi(),
						x.getDienTich());
			} else if ((x instanceof Hinhtamgiac)) {
				System.out.printf("|%-5s|%-17s|a :%-3s b:%-3s c:%-3s|%-18s|%.2f\n", n, "Tam Giác",
						((Hinhtamgiac) x).getCanhA(), ((Hinhtamgiac) x).getCanhB(), ((Hinhtamgiac) x).getCanhC(),
						x.getChuVi(), x.getDienTich());
			}
			System.out.println("------------------------------------------------------------------------------------");
			n += 1;
		}

	}
	public static void ketThuc() {
		System.out.println("Kết thúc chương trình!!!!!");
		System.exit(0);
    }
}