package fasttrack.assignment6.main;

import fasttrack.assignment6.model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class BaiToanHinhHoc {
	public static Scanner Scanner = new Scanner(System.in);
	public static ArrayList<HinhHoc> hinhhoc = new ArrayList<HinhHoc>();
	public static Tron hinhtron = new Tron();
	public static ChuNhat hinhchunhat = new ChuNhat();
	public static TamGiac hinhtamgiac = new TamGiac();
	public static Vuong hinhvuong = new Vuong();
	public static double r,chieudai,chieurong,a,b,c,canhA;

	public static void main(String[] args) {
		myMenu();
	}

	public static void myMenu() {
		while (true) {

			System.out.println("        ___________________________________");
			System.out.println("         |-------CHỌN LỰA CHỨC NĂNG------|");
			System.out.println("         |=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=|");
			System.out.println("         |  1.Tính giá trị hình tròn     |");
			System.out.println("         |  2.Tính giá trị hình chữ nhật |");
			System.out.println("         |  3.Tính giá trị hình tam giác |");
			System.out.println("         |  4.Tính giá trị hình vuông    |");
			System.out.println("         |  5.In kết quả tất cả các hình |");
			System.out.println("         |                               |");
			System.out.println("         |=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=|");
			System.out.println("         |--6.Kết thúc chương trình------|");
			System.out.println("         |_______________________________|");
			System.out.print("     Nhập chức năng mà bạn muốn thực hiện :");
			int a = Scanner.nextInt();
			if (a == 1) {
				tinhHinhTron();
			} else if (a == 2) {
				tinhHinhChuNhat();
			} else if (a == 3) {
				tinhHinhTamGiac();
			} else if (a == 4) {
				tinhHinhVuong();
			} else if (a == 5) {
				inTatCaGiaTri();
			} else if (a == 6) {
				ketThuc();
			}
			Scanner.nextLine();
			System.out.println("         Nhấn Enter để tiếp tục chương trình ");
			Scanner.nextLine();
		}
	}

	public static void tinhHinhTron() {
		hinhtron = new Tron();
		System.out.print("Nhập bán kính hình tròn :");
		r = Scanner.nextDouble();
		hinhtron.setBankinh(r);
		hinhhoc.add(new Tron(r));
	
	}

	public static void tinhHinhChuNhat() {
		
		
		System.out.print("Nhập chiều dài hình chữ nhật :");
		double chieudai = Scanner.nextDouble();
		hinhchunhat.setChieudai(chieudai);

		System.out.print("Nhập chiều rộng hình chữ nhật :");
		double chieurong = Scanner.nextDouble();
		hinhchunhat.setChieurong(chieurong);
		hinhhoc.add(new ChuNhat(chieudai,chieurong));
	}

	public static void tinhHinhTamGiac() {
		
		System.out.println("Nhập độ dài 3 cạnh của hình tam giác :");
		System.out.print("Nhập độ dài cạnh a :");
		double a = Scanner.nextDouble();
		hinhtamgiac.setCanhA(a);

		System.out.print("Nhập độ dài cạnh b :");
		double b = Scanner.nextDouble();
		hinhtamgiac.setCanhB(b);

		System.out.print("Nhập độ dài cạnh c :");
		double c = Scanner.nextDouble();
		hinhtamgiac.setCanhC(c);
		hinhhoc.add(new TamGiac(a,b,c));

	}

	public static void tinhHinhVuong() {
		
		System.out.println("Nhập độ dài  cạnh của hình vuông :");
		System.out.print("Nhập độ dài cạnh a :");
		double canhA = Scanner.nextDouble();
		hinhvuong.setCanhA(a);
		hinhhoc.add(new Vuong(canhA));

	}

	public static void inTatCaGiaTri() {
		System.out.println(" ==========================================================================================");
		System.out.println(" | STT |  Hình       |  Thuộc tính                     |    Chu vi        |     Diện tích  |");
		System.out.println(" ==========================================================================================");
		int i = 1;
		for (HinhHoc x : hinhhoc) {
			if ((x instanceof Tron)) {
				System.out.printf(" |%-5s|%-12s |Bán kính:%-24s|%-18s|%-16s|\n", i,"Hình Tròn", ((Tron) x).getBankinh(),
						x.getChuVi(), x.getDienTich());
				}  else if ((x instanceof Vuong)) {
					System.out.printf(" |%-5s|%-13s|Cạnh A:%-26s|%-18s|%-16s|\n", i, "Hình Vuông", ((Vuong) x).getCanhA(),
							x.getChuVi(), x.getDienTich());
				} else if ((x instanceof ChuNhat)) {
					System.out.printf(" |%-5s|%-13s|Chiều dài:%-4s Chiều rộng:%-7s|%-18s|%-16s|\n", i, "Chữ Nhật",
							((ChuNhat) x).getChieudai(), ((ChuNhat) x).getChieurong(), x.getChuVi(),
							x.getDienTich());
				} else if ((x instanceof TamGiac)) {
					System.out.printf(" |%-5s|%-13s|Cạnh A :%-3s Cạnh B:%-3s Cạnh C:%-3s|%-18s|%-16s|\n", i, "Tam Giác",
							((TamGiac) x).getCanhA(), ((TamGiac) x).getCanhB(), ((TamGiac) x).getCanhC(),
							x.getChuVi(), x.getDienTich());
				}
			System.out.println(" ==========================================================================================");
			i += 1;
		}

	}

	public static void ketThuc() {
		System.out.println("              Kết thúc chương trình ");
		System.exit(0);
	}

}
