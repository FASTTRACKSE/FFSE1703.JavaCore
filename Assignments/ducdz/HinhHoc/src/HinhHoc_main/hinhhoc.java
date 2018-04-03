package HinhHoc_main;

import HinhHoc_model.*;
import java.util.*;

public class hinhhoc {
	public static Scanner myScanner = new Scanner(System.in);
	public static ArrayList<HinhHoc> arrHH = new ArrayList<HinhHoc>();
	public static HinhTron newHt = new HinhTron();
	public static HinhChuNhat newHcn = new HinhChuNhat();
	public static HinhTamGiac newHtg = new HinhTamGiac();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		menu();
	}

	public static void menu() {
		while (true) {
			System.out.println("1.Hinh tron");
			System.out.println("2.Hinh chu nhat");
			System.out.println("3.Hinh tam giac");
			System.out.println("4.In danh sach");
			System.out.print("Lua chon cua ban la: ");
			int myOption = myScanner.nextInt();
			if (myOption == 1) {
				tinhHinhtron();
			}
			if (myOption == 2) {
				tinhHCN();
			}
			if (myOption == 3) {
				tinhHTG();
			}
			if (myOption == 4) {
				inDanhsach();
			}
			if (myOption == 5) {
				endProgram();
			}
		}
	}

	public static void tinhHinhtron() {
		System.out.println("Nhap ban kinh cua hinh tron : ");
		double bankinh = myScanner.nextInt();
		newHt.setbanKinh(bankinh);
		newHt.tinhChuvi(bankinh);
		System.out.println("Chu vi cua hinh tron co ban kinh " + bankinh + " la : " + newHt.getChuvihinhtron());
		newHt.tinhDientich(bankinh);
		System.out.println("Dien tich cua hinh tron la : " + newHt.getDientichhinhtron());
		arrHH.add(newHt);
		backMenu();
	}

	public static void tinhHCN() {
		System.out.println("Nhap chieu dai cua hinh chu nhat : ");
		double chieuDai = myScanner.nextDouble();
		newHcn.setchieuDai(chieuDai);
		System.out.println("Nhap chieu rong cua hinh chu nhat : ");
		double chieuRong = myScanner.nextDouble();
		newHcn.setchieuRong(chieuRong);
		newHcn.tinhChuvi(chieuDai, chieuRong);
		System.out.println("Chu vi cua hinh chu nhat la : " + newHcn.getChuviHCN());
		newHcn.tinhDientich(chieuDai, chieuRong);
		System.out.println("Dien tich cua hinh chu nhat la :" + newHcn.getDientichHCN());
		arrHH.add(newHcn);
		backMenu();
	}

	public static void tinhHTG() {
		System.out.println("Nhap canh A cua hinh tam giac :");
		double canhA = myScanner.nextDouble();
		newHtg.setCanhA(canhA);
		System.out.println("Nhap canh B cua hinh tam giac :");
		double canhB = myScanner.nextDouble();
		newHtg.setCanhB(canhB);
		System.out.println("Nhap canh C cua hinh tam giac :");
		double canhC = myScanner.nextDouble();
		newHtg.setCanhC(canhC);
		newHtg.tinhChuviHTG(canhA, canhB, canhC);
		System.out.println("Chu vi cua hinh tam giac la : " + newHtg.getChuviHTG());
		newHtg.tinhDientichHTG(canhA, canhB, canhC);
		System.out.println("Dien tich cua hinh tam giac la : " + newHtg.getDientichHTG());
		arrHH.add(newHtg);
		backMenu();
	}

	public static void inDanhsach() {
		System.out.println("Danh sach tat ca cac hinh!");
		for(HinhHoc x : arrHH) {
			if(x instanceof HinhTron) {
				System.out.println("Hinh tron");
				System.out.println("Ban kinh hinh tron: "+((HinhTron) x).getbanKinh());
				System.out.println("Chu vi hinh tron: "+((HinhTron) x).getChuvi());
				System.out.println("Dien tich hinh tron: "+((HinhTron) x).getDientich());
			}
			if(x instanceof HinhChuNhat) {
				System.out.println("Hinh chu nhat");
				System.out.println("Chieu dai hinh chu nhat: "+((HinhChuNhat) x).getchieuDai());
				System.out.println("Chieu rong hinh chu nhat: "+((HinhChuNhat) x).getchieuRong());
				System.out.println("Chu vi hinh chu nhat: "+((HinhChuNhat) x).getChuviHCN());
				System.out.println("Dien tich hinh chu nhat: "+((HinhChuNhat) x).getDientichHCN());
			}
			if(x instanceof HinhTamGiac) {
				System.out.println("Hinh Tam Giac");
				System.out.println("Chieu dai canh A : "+((HinhTamGiac) x).getCanhA());
				System.out.println("Chieu dai canh B : "+((HinhTamGiac) x).getCanhB());
				System.out.println("Chieu dai canh C : "+((HinhTamGiac) x).getCanhC());
				System.out.println("Chu vi hinh tam giac : "+((HinhTamGiac) x).getChuviHTG());
				System.out.println("Dien tich hinh tam giac : "+((HinhTamGiac) x).getDientichHTG());
			}
		}
	}

	public static void endProgram() {
		System.exit(0);
	}

	public static void backMenu() {
		myScanner.nextLine();
		System.out.println("An Enter de quay lai menu!");
		myScanner.nextLine();
	}
}
