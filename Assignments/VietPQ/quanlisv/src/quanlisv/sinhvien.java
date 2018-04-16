package quanlisv;

import java.util.Scanner;
import java.util.ArrayList;

public class sinhvien {
	public static Scanner input = new Scanner(System.in);
	public static qlsinhvien[] sv = new qlsinhvien[200];
	public static int tongsv, i = 0;
	public static String action;
	static ArrayList<qlsinhvien> arraySinhvien = new ArrayList<qlsinhvien>();

	public static void main(String[] args) {
		myMenu();
	}

	public static void themsv() {
		String tensv;
		String nssv;
		float LP1;
		float LP2;
		float LP3;
		System.out.println("THEM SINH VIEN VAO DANH SACH");
		System.out.println("============================");
		System.out.println("Nhap so sinh vien muon them");
		tongsv = input.nextInt();
		for (int r = 0; r < tongsv; r++) {
			input.nextLine();
			System.out.println("Nhap ten sinh vien thu  " + (r + 1) + " : ");
			tensv = input.nextLine();
			System.out.println("Nhap ngay sinh sinh vien thu " + (r + 1) + " : ");
			nssv = input.nextLine();
			System.out.println("Nhap diem LP1 sinh vien thu " + (r + 1) + " : ");
			LP1 = input.nextFloat();
			System.out.println("Nhap diem LP2 sinh vien thu " + (r + 1) + " : ");
			LP2 = input.nextFloat();
			System.out.println("Nhap diem LP3 sinh vien thu " + (r + 1) + " : ");
			LP3 = input.nextFloat();
			arraySinhvien.add(new qlsinhvien(tensv, nssv, LP1, LP2, LP3));
			qlsinhvien.setTongsv();
		}
		action = input.nextLine();
		System.out.println("=====================================");
		System.out.println("========BAM ENTER DE TIEP TUC========");
		action = input.nextLine();
	}

	public static void hienthisv() {
		int y = 0;
		System.out.println("====================================TAT CA SINH VIEN====================================");
		System.out.println("STT\tTen SV\tNgay sinh\tDiem LP1\tDiem LP2\tDiem LP3\tDiem TB\tXep loai");
		for (qlsinhvien x : arraySinhvien) {
			System.out.print((i + 1) + "\t");
			System.out.printf("%-10s %-15s %-15s %-10s %10s %15s %-15s \n", x.getTensv(), x.getNssv(), x.getLP1(),
					x.getLP2(), x.getLP3(), x.getDiemtb(), x.getXepLoai());
		}
		action = input.nextLine();
		System.out.println("========================================================================================");
		System.out.println("==================================BAM ENTER DE TIEP TUC=================================");
		action = input.nextLine();
	}

	public static void svcaonhat() {
		System.out.println("===============================SINH VIEN CO DIEM CAO NHAT===============================");
		System.out.println("========================================================================================");
		float max = sv[0].getDiemtb();
		int STT = 0;
		for (qlsinhvien x: sv) {
			if (max < x.getDiemtb()) {
				max = x.getDiemtb();
//				STT = x;
			}
			System.out.println( max);
		}
		for (qlsinhvien x: sv) {
			if (max <= x.getDiemtb()) {
				System.out.println("La sinh vien:" + "==>>> " + x.getTensv() + " <<<==" + "\n"
						+ "Co diem trung binh " + max + "\n" + "Có so thu tu la ");
			}
			System.out.println(sv[STT].getTensv() + max);
		}
//		action = input.nextLine();
//		System.out.println("========================================================================================");
//		System.out.println("==================================BAM ENTER DE TIEP TUC=================================");
//		action = input.nextLine();
	}

	public static void svthapnhat() {
		System.out.println("==============================SINH VIEN CO DIEM THAP NHAT===============================");
		System.out.println("========================================================================================");
		float min = sv[0].getDiemtb();
		int STT=0;
		for (int i = 0; i < tongsv; i++) {
			if (min > sv[i].getDiemtb()) {
				min = sv[i].getDiemtb();
				STT = i;
			}
			System.out.println(min);
		}
//		for (int i = 0; i < tongsv; i++) {
//			if (min >= sv[i].getDiemtb()) {
//				System.out.println("La sinh vien:" + "==>>> " + sv[i].getTensv() + " <<<==" + "\n"
//						+ "Có diem trung binh " + min + "\n" + "Có so thu tu la " + (i + 1));
//			}
//		}
		action = input.nextLine();
		System.out.println("========================================================================================");
		System.out.println("==================================BAM ENTER DE TIEP TUC=================================");
		action = input.nextLine();
	}

	public static void sxdtb() {
		qlsinhvien[] temp = new qlsinhvien[tongsv];
		float tempt;
		for (int i = 0; i < tongsv; i++) {
			for (int j = i + 1; j < tongsv; j++) {
				if (sv[i].getDiemtb() < sv[j].getDiemtb()) {
					;
					temp[i] = sv[i];
					sv[i] = sv[j];
					sv[j] = temp[i];
				}
			}
		}
		for (int i = 0; i < tongsv; i++) {
			System.out.print((i + 1) + "\t");
			hienthisv();
		}
		action = input.nextLine();
		System.out.println("=====================================");
		System.out.println("========BAM ENTER DE TIEP TUC========");
		action = input.nextLine();
	}

	public static void sxten() {
		qlsinhvien[] temp = new qlsinhvien[tongsv];

		for (int i = 0; i < tongsv - 1; i++) {
			for (int j = i + 1; j < tongsv; j++) {
				if (sv[i].getTensv().compareTo(sv[j].getTensv()) > 0) {
					temp[i] = sv[j];
					sv[j] = sv[i];
					sv[i] = temp[i];
				}
			}
		}
		System.out.println("=====================DANH SACH SINH VIEN XEP THEO TEN====================");
		System.out.println("=========================================================================");
		System.out.println("STT  HO VA TEN              NGAY SINH     LP1  LP2  LP3  DTB  XEP LOAI   ");
		for (int i = 0; i < tongsv; i++) {
			System.out.print((i + 1) + "\t");
			hienthisv();
		}
		action = input.nextLine();
		System.out.println("=====================");
		System.out.println("BAM ENTER DE TIEP TUC");
		action = input.nextLine();
	}

	public static void suasv() {
		System.out.println("Ten SV can sua :");
		String namesv = input.next();
		System.out.println("Ten SV moi :");
		String newnamesv = input.next();
		for (qlsinhvien x : arraySinhvien) {
			if ((x.getTensv()).equals(namesv)) {
				x.setTensv(newnamesv);
			}
		}
	}

	public static void xoasv() {
		System.out.println("Ten SV can xoa :");
		String namesv = input.next();
		for(int z = 0; z < arraySinhvien.size(); z++) {
			for (qlsinhvien x : arraySinhvien) {
				if ((x.getTensv()).indexOf(namesv) > -1) {
					arraySinhvien.remove(x);
					z--;
					qlsinhvien.tongsv();
					break;
				}
			}
		}
	}

	public static void savefile() {

	}

	public static void ketthuc() {
		System.out.println("=======HEN GAP LAI======");
		System.exit(0);
	}


	public static void myMenu() {
		while (true) {
			System.out.println("+========LUA CHON CHUC NANG========+");
			System.out.println("|1.THEM SINH VIEN                  |");
			System.out.println("|2.HIEN THI THONG TIN SINH VIEN    |");
			System.out.println("|3.SAP XEP DIEM THAP DEN CAO       |");
			System.out.println("|4.SAP XEP DIEM CAO DEN THAP       |");
			System.out.println("|5.SAP XEP DIEM TRUNG BINH         |");
			System.out.println("|6.SAP XEP THEO TEN SINH VIEN      |");
			System.out.println("|7.SUA TEN SINH VIEN               |");
			System.out.println("|8.XOA SINH VIEN                   |");
			System.out.println("|9.LUU SINH VIEN                   |");
			System.out.println("|10.KET THUC                       |");
			System.out.println("+=========LUA CHON CUA BAN=========+");
			int xb1 = input.nextInt();
			if (xb1 == 1) {
				themsv();
			} else if (xb1 == 2) {
				hienthisv();
			} else if (xb1 == 3) {
				svcaonhat();
			} else if (xb1 == 4) {
				svthapnhat();
			} else if (xb1 == 5) {
				sxdtb();
			} else if (xb1 == 6) {
				sxten();
			} else if (xb1 == 7) {
				suasv();
			} else if (xb1 == 8) {
				xoasv();
			} else if (xb1 == 9) {
				savefile();
			} else if (xb1 == 10) {
				ketthuc();
			}
		}
	}
}