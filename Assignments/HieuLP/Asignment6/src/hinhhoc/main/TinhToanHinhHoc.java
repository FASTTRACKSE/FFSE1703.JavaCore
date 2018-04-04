package hinhhoc.main;

import hinhhoc.model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class TinhToanHinhHoc {
	public static Scanner Scanner = new Scanner(System.in);
	public static ArrayList<HinhHoc> hinhhoc = new ArrayList<HinhHoc>();
	public static HinhTron hinhtron = new HinhTron();
	public static HinhChuNhat hinhchunhat = new HinhChuNhat();
	public static HinhTamGiac hinhtamgiac = new HinhTamGiac();
	public static HinhVuong hinhvuong = new HinhVuong();
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
			int act = Scanner.nextInt();
			if (act == 1) {
				tinhHinhTron();
			} else if (act == 2) {
				tinhHinhChuNhat();
			} else if (act == 3) {
				tinhHinhTamGiac();
			} else if (act == 4) {
				tinhHinhVuong();
			} else if (act == 5) {
				inTatCaGiaTri();
			} else if (act == 6) {
				ketThuc();
			}
			Scanner.nextLine();
			System.out.println("         Nhấn Enter để tiếp tục chương trình ");
			System.out.println("                  =================          ");
			System.out.println("                    ===Cảm ơn===             ");
			Scanner.nextLine();
		}
	}

	public static void tinhHinhTron() {
		hinhtron = new HinhTron();
		System.out.print("Nhập bán kính hình tròn :");
		r = Scanner.nextDouble();
		hinhtron.setBankinh(r);
		hinhhoc.add(new HinhTron(r));
	
	}

	public static void tinhHinhChuNhat() {
		
		
		System.out.print("Nhập chiều dài hình chữ nhật :");
		double chieudai = Scanner.nextDouble();
		hinhchunhat.setChieudai(chieudai);

		System.out.print("Nhập chiều rộng hình chữ nhật :");
		double chieurong = Scanner.nextDouble();
		hinhchunhat.setChieurong(chieurong);
		hinhhoc.add(new HinhChuNhat(chieudai,chieurong));
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
		hinhhoc.add(new HinhTamGiac(a,b,c));

	}

	public static void tinhHinhVuong() {
		
		System.out.println("Nhập độ dài  cạnh của hình vuông :");
		System.out.print("Nhập độ dài cạnh a :");
		double canhA = Scanner.nextDouble();
		hinhvuong.setCanhA(a);
		hinhhoc.add(new HinhVuong(canhA));

	}

	public static void inTatCaGiaTri() {
		System.out.println(" ==========================================================================================");
		System.out.println(" | STT |  Hình       |  Thuộc tính                     |    Chu vi        |     Diện tích  |");
		System.out.println(" ==========================================================================================");
		int i = 1;
		for (HinhHoc x : hinhhoc) {
			if ((x instanceof HinhTron)) {
				System.out.printf(" |%-5s|%-12s |Bán kính:%-24s|%-18s|%-16s|\n", i,"Hình Tròn", ((HinhTron) x).getBankinh(),
						x.getChuvi(), x.getDientich());
				}  else if ((x instanceof HinhVuong)) {
					System.out.printf(" |%-5s|%-13s|Cạnh A:%-26s|%-18s|%-16s|\n", i, "Hình Vuông", ((HinhVuong) x).getCanhA(),
							x.getChuvi(), x.getDientich());
				} else if ((x instanceof HinhChuNhat)) {
					System.out.printf(" |%-5s|%-13s|Chiều dài:%-4s Chiều rộng:%-7s|%-18s|%-16s|\n", i, "Chữ Nhật",
							((HinhChuNhat) x).getChieudai(), ((HinhChuNhat) x).getChieurong(), x.getChuvi(),
							x.getDientich());
				} else if ((x instanceof HinhTamGiac)) {
					System.out.printf(" |%-5s|%-13s|Cạnh A :%-3s Cạnh B:%-3s Cạnh C:%-3s|%-18s|%-16s|\n", i, "Tam Giác",
							((HinhTamGiac) x).getCanhA(), ((HinhTamGiac) x).getCanhB(), ((HinhTamGiac) x).getCanhC(),
							x.getChuvi(), x.getDientich());
				}
			System.out.println(" ==========================================================================================");
			i += 1;
		}

	}

	public static void ketThuc() {
		System.out.println("              Kết thúc chương trình ");
		System.out.println("                =================   ");
		System.out.println("                  ===Cảm ơn===      ");
		System.exit(0);
	}

}
