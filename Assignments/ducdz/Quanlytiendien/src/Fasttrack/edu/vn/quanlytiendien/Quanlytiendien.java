package Fasttrack.edu.vn.quanlytiendien;
import Fasttrack.edu.vn.tiendien.*;
import java.util.ArrayList;
import java.util.*;
public class Quanlytiendien {
	public static Scanner myScanner = new Scanner(System.in);
	public static ArrayList<KhachHang> arrKh = new ArrayList<KhachHang>();
	public static ArrayList<BienLai> arrBl = new ArrayList<BienLai>();
	public static KhachHang newKh = new KhachHang();
	public static BienLai newBl = new BienLai();
	public static int tongKh;
	public static int soNammuonin;
	public static int maKhmuonin;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		menu();
	}
	public static void menu() {
		while(true) {
			System.out.println("Menu quan ly");
			System.out.println("1.Nhap thong tin khach hang");
			System.out.println("2.Nhap thong tin chi so tieu thu dien");
			System.out.println("3.In danh sach thu tien cua khach hang");	
			System.out.println("4.In khach hang theo nam");
			System.out.println("5.In khach hang theo ma");
			System.out.println("6.Ket thuc chuong trinh!");
			System.out.print("Lua chon cua ban la : ");
			int myOption = myScanner.nextInt();
			if(myOption==1) {
				nhapInfoKh();
			}
			if(myOption==2) {
				nhapInfoChiso();
			}
			if(myOption==3) {
				inDanhsach();
			}
			if(myOption==4) {
				inKhtheonam();
			}
			if(myOption==5) {
				inKhtheoma();
			}
			if(myOption==6) {
				endProgram();
			}
		}
	}
	public static void nhapInfoKh() {
		
		System.out.print("Nhap so khach hang : ");
		tongKh = myScanner.nextInt();
		for(int i=0;i<tongKh;i++) {
			System.out.println("Nhap thong tin khach hang thu "+(i+1)+"!");
			System.out.print("Nhap ma so khach hang : ");
			int maKh=myScanner.nextInt();
			System.out.print("Nhap ten khach hang : ");
			String tenKh=myScanner.next();
			System.out.print("Nhap dia chi khach hang : ");
			String diachiKh=myScanner.next();
			System.out.print("Nhap ma cong to khach hang : ");
			int macongtoKh=myScanner.nextInt();
			arrKh.add(new KhachHang(maKh,tenKh,diachiKh,macongtoKh));
		}
		backToMenu();
	}
	public static void nhapInfoChiso() {
		for(int i=0;i<arrKh.size();i++) {
			System.out.println("Nhap chi so tieu thu dien cua khach hang thu "+(i+1)+" !");
			System.out.print("Nhap thang cua khach hang: ");
			int thang = myScanner.nextInt();
			System.out.print("Nhap nam cua khach hang: ");
			int nam = myScanner.nextInt();
			System.out.print("Nhap chi so cu: ");
			double chisocu = myScanner.nextDouble();
			System.out.print("Nhap chi so moi: ");
			double chisomoi = myScanner.nextDouble();
			arrBl.add(new BienLai(arrKh.get(i).getMaKh(),arrKh.get(i).getTenKh(),arrKh.get(i).getDiachiKh(),arrKh.get(i).getMacongtoKh(),thang,nam,chisocu,chisomoi));
		}	
	}
	public static void inDanhsach() {
		for (int i=0;i<arrBl.size();i++) {
			System.out.println("Thong tin khach hang thu "+(i+1)+" !");
			System.out.println("Ma khach hang \t Ten khach hang \t Dia chi khach hang \t Ma cong to khach hang \t Thang \t Nam \t Chi so cu \t Chi so moi");
			System.out.println(arrKh.get(i).getMaKh()+"\t"+arrKh.get(i).getTenKh()+"\t"+arrKh.get(i).getDiachiKh()+"\t"+arrKh.get(i).getMacongtoKh()+"\t"+arrBl.get(i).getThang()+"\t"+arrBl.get(i).getNam()+"\t"+arrBl.get(i).getChisocu()+"\t"+arrBl.get(i).getChisomoi()+"\n");
		}
		backToMenu();
	}
	public static void endProgram() {
		System.exit(0);
	}
	public static void inKhtheonam() {
		System.out.println("Nam muon in:");
		soNammuonin=myScanner.nextInt();
		for(int i=0;i<arrBl.size();i++) {
			if(soNammuonin==arrBl.get(i).getNam()) {
				System.out.println("--------------------------");
				System.out.println("Khach hang thu "+(i+1)+" !");
				System.out.println("Ma khach hang : "+arrBl.get(i).getMaKh());
				System.out.println("Ten khach hang : "+arrBl.get(i).getTenKh());
				System.out.println("Dia chi khach hang : "+arrBl.get(i).getDiachiKh());
				System.out.println("Ma cong to khach hang : "+arrBl.get(i).getMacongtoKh());
				System.out.println("Thang khach hang : "+arrBl.get(i).getThang());
				System.out.println("Chi so moi : "+arrBl.get(i).getChisomoi());
				System.out.println("Chi so cu : "+arrBl.get(i).getChisocu());
			}
			else{
				System.out.println("Khong co khach hang trong nam "+soNammuonin+" !");
			}
		}
	}
	public static void inKhtheoma() {
		System.out.println("Nhap ma khach hang : ");
		maKhmuonin = myScanner.nextInt();
		for(int i=0;i<arrBl.size();i++) {
			if(maKhmuonin==arrBl.get(i).getMaKh()) {
				System.out.println("---------------------");
				System.out.println("Ma khach hang la : "+arrBl.get(i).getMaKh());
				System.out.println("Ten khach hang : "+arrBl.get(i).getMaKh());
				System.out.println("Dia chi khach hang la : "+arrBl.get(i).getDiachiKh());
				System.out.println("Ma cong to khach hang : "+arrBl.get(i).getMacongtoKh());
				System.out.println("Thang khach hang : "+arrBl.get(i).getThang());
				System.out.println("Nam khach hang : "+arrBl.get(i).getNam());
				System.out.println("Chi so moi : "+arrBl.get(i).getChisomoi());
				System.out.println("Chi so cu : "+arrBl.get(i).getChisocu());;
			}
		}
	}
	public static void backToMenu() {
		myScanner.nextLine();
		System.out.print("An Enter de quay lai!");
		myScanner.nextLine();
	}
}
