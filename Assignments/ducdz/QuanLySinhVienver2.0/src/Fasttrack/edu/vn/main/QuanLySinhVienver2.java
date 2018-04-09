package Fasttrack.edu.vn.main;

import Fasttrack.edu.vn.model.*;
import java.util.*;

public class QuanLySinhVienver2 {
	public static Scanner myScanner = new Scanner(System.in);
	public static ArrayList<SinhVien> arrSv = new ArrayList<SinhVien>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		menu();
	}

	public static void menu() {
		while (true) {
			System.out.println("1.Nhap thong tin sinh vien moi");
			System.out.println("2.In danh sach sinh vien");
			System.out.println("3.In sinh vien diem TB cao nhat va thap nhat");
			System.out.println("4.In sinh vien theo ten");
			System.out.println("5.Doi ten sinh vien");
			System.out.println("6.Xoa sinh vien");
			System.out.println("7.End program!");
			System.out.print("Lua chon cua ban la : ");
			try {
				int myOption = myScanner.nextInt();
				myScanner.nextLine();
				if (myOption == 1) {
					nhapinfoSv();
				}
				if (myOption == 2) {
					indanhsachSv();
				}
				if (myOption == 3) {
					intheodiemTB();
				}
				if (myOption == 4) {
					intheotenSv();
				}
				if (myOption == 5) {
					suaSv();
				}
				if (myOption == 6) {
					xoaSv();
				}
				if (myOption == 7) {
					endProgram();
				}
				else {
					throw new Exception();
				}
			}
			catch(Exception e){
				System.out.println("Nhap sai du lieu!");
				myScanner.nextLine();
			}
		}
	}

	public static void nhapinfoSv() {
		System.out.println("Tong so sinh vien muon nhap : ");
		try {
			int tongsoSvmuonnhap = Integer.parseInt(myScanner.nextLine());
			for (int i = 0; i < tongsoSvmuonnhap; i++) {
				SinhVien newsv = new SinhVien();
				System.out.println("Thong tin sinh vien thu " + (i + 1));
				System.out.println("Ma sinh vien: ");
				newsv.maSv = myScanner.nextInt();
				newsv.setMaSv(newsv.maSv);
				System.out.println("Ten sinh vien: ");
				newsv.tenSv = myScanner.next();
				newsv.setTenSv(newsv.tenSv);
				System.out.println("Ngay sinh: ");
				newsv.ngaysinhSv = myScanner.nextInt();
				newsv.setNgaysinhSv(newsv.ngaysinhSv);
				System.out.println("Diem LP1: ");
				newsv.diemLP1 = myScanner.nextInt();
				newsv.setDiemLP1(newsv.diemLP1);
				System.out.println("Diem LP2: ");
				newsv.diemLP2 = myScanner.nextInt();
				newsv.setDiemLP2(newsv.diemLP2);
				newsv.tinhDiemTB(newsv.diemLP1, newsv.diemLP2);
				System.out.println("Diem TB la : " + newsv.getDiemTB());
				arrSv.add(newsv);
			}
		} catch (Exception e) {
			System.out.println("Nhap sai kieu du lieu, xin moi nhap lai!");
			myScanner.nextLine();
		}
		backMenu();
	}

	public static void indanhsachSv() {
		System.out.println("Danh sach tat ca sinh vien");
		for (int i = 0; i < arrSv.size(); i++) {
			System.out.println("Thong tin sinh vien thu " + (i + 1) + " :");
			System.out.println("Ma sinh vien: " + arrSv.get(i).getMaSv());
			System.out.println("Ten sinh vien: " + arrSv.get(i).getTenSv());
			System.out.println("Ngay sinh: " + arrSv.get(i).getNgaysinhSv());
			System.out.println("Diem LP1: " + arrSv.get(i).getDiemLP1());
			System.out.println("Diem LP2: " + arrSv.get(i).getDiemLP2());
			System.out.println("Diem TB: " + arrSv.get(i).getDiemTB());
		}
		backMenu();
	}

	public static void intheodiemTB() {
		System.out.println("Danh sach diem TB");
		int max = arrSv.size();
		int min = arrSv.size();
		int vitrimax=0;
		int vitrimin=1;
		for (int i = 0; i < arrSv.size(); i++) {
			if (max < arrSv.get(i).getDiemTB()) {
				vitrimax = i + 1;
				max = arrSv.get(i).getDiemTB();
			}
		}
		System.out.println("Sinh vien thu " + vitrimax + " co diem TB cao nhat: " + max);
		for (int i = 0; i < arrSv.size(); i++) {
			if (min > arrSv.get(i).getDiemTB()) {
				vitrimin = i + 1;
				min = arrSv.get(i).getDiemTB();
			}
		}
		System.out.println("Sinh vien thu " + vitrimin + " co diem TB thap nhat: " + min);
		backMenu();
	}

	public static void intheotenSv() {
		System.out.println("Ten sinh vien muon in: ");
		String tenMuonIn = myScanner.next();
		for (int i = 0; i < 1; i++) {
			if (tenMuonIn.equalsIgnoreCase(arrSv.get(i).getTenSv())) {
				System.out.println("Thong tin sinh vien co ten " + tenMuonIn + " :");
				System.out.println("Ten sinh vien: " + arrSv.get(i).getTenSv());
				System.out.println("Ma sinh vien: " + arrSv.get(i).getMaSv());
				System.out.println("Ngay sinh: " + arrSv.get(i).getNgaysinhSv());
				System.out.println("Diem LP1: " + arrSv.get(i).getDiemLP1());
				System.out.println("Diem LP2: " + arrSv.get(i).getDiemLP2());
				System.out.println("Diem TB: " + arrSv.get(i).getDiemTB());
			} else {
				System.out.println("Khong co sinh vien ten " + tenMuonIn);
			}
		}
		backMenu();
	}

	public static void suaSv() {
		System.out.println("Ten sinh vien muon sua: ");
		String svMuonSua = myScanner.next();
		for (int i = 0; i < 1; i++) {
			if (svMuonSua.equalsIgnoreCase(arrSv.get(i).getTenSv())) {
				System.out.println("Ten sinh vien cu: "+arrSv.get(i).getTenSv());
				System.out.println("Ten sinh vien moi: ");
				String tenMoi = myScanner.next();
				arrSv.get(i).setTenSv(tenMoi);
				System.out.println("Da doi thanh cong ten cua sinh vien: "+tenMoi);
				System.out.println("Ten sinh vien: "+arrSv.get(i).getTenSv());
				System.out.println("Ngay sinh sinh vien: "+arrSv.get(i).getNgaysinhSv());
				System.out.println("Diem LP1: "+arrSv.get(i).getDiemLP1());
				System.out.println("Diem LP2: "+arrSv.get(i).getDiemLP2());
			}
		}
		backMenu();
	}

	public static void xoaSv() {
		System.out.println("Ten sinh vien muon xoa: ");
		String tenMuonXoa = myScanner.next();
		for (SinhVien x : arrSv) {
			if (tenMuonXoa.equalsIgnoreCase((x).getTenSv())) {
				arrSv.remove(x);
				System.out.println("Da xoa thanh cong sinh vien ten: "+tenMuonXoa);
			}
			break;
		}
		indanhsachSv();
	}

	public static void backMenu() {
		myScanner.nextLine();
		System.out.println("An Enter de quay lai menu!");
		myScanner.nextLine();
		menu();
	}

	public static void endProgram() {
		System.out.println("Cam on ban da su dung chuong trinh !");
		System.exit(0);
	}
}