package fasttrack.edu.vn.sinhvien;
import java.util.Scanner;
public class QLSV {
	public static Scanner sc = new Scanner(System.in);
	public static Sinhvien[] sv = new Sinhvien[100];
	public static int danhsach = 0 ;
	public static String Act;
	public static int i,n=0;
	public static int max=0,min = 0,tempt=0;
	public static String[] ten;
	public static String[] namsinh;
	public static double[] diemLP1 ;
	public static double[] diemLP2 ;
	public static double[] diemTB;
	public static double[] sx_diem;
	public static void main(String[] args) {
		myMenu();
	}
	
	public static void nhapdanhsachsinhvien() {
		System.out.println("Nhap danh sach sinh vien");
		System.out.println("=======================");
		System.out.println("Nhap so luong sinh vien");
		int a = sc.nextInt();
		danhsach = a + danhsach;
		for (int i=0; i<danhsach; i++) {
			sv[i] = new Sinhvien();
		}
		for (int i=0;i<danhsach;i++) {
			sc.nextLine();
			System.out.println("Nhap ten sinh vien thu:" + (i+1) + ":");
			String ten = sc.nextLine();
			sv[i].setten(ten);
			System.out.println("Nhap nam sinh sinh vien thu:" + (i+1) + ":");
			int namsinh = sc.nextInt();
			sv[i].setnamsinh(namsinh);
			System.out.println("Nhap diem LP1 sinh vien thu:" + (i+1) + ":");
			float diemLP1 = sc.nextFloat();
			sv[i].setdiemLP1(diemLP1);
			System.out.println("Nhap diem LP1 sinh vien thu:" + (i+1) + ":");
			float diemLP2 = sc.nextFloat();
			sv[i].setdiemLP2(diemLP2);
			 System.out.println("=====================================");
				System.out.println("-------Nhập ENTER để tiếp tục------");	
				Act = sc.nextLine();
			
			}
	}
		
		public static void indanhsachsinhvien() {
			System.out.println("-----------DANH SÁCH TẤT CẢ SINH VIÊN-------------");
			System.out.println("==================================================");
			System.out.println("STT\tTên\t Ngày Sinh\tĐiểm LP1\tĐiểm LP2\tĐiểm TB\tXếp Loại");
			System.out.println("--------------------------------------------------");
			
			for (int i=0;i<danhsach; i++) {
				System.out.printf("%-5s%-20s%-15s%-10s%-10s%-5s\n", (i+1), sv[i].getten(), sv[i].getnamsinh(), sv[i].getdiemLP1(),
						sv[i].getdiemLP2(), sv[i].getdiemTB());
			}
			System.out.println("=============================");
			System.out.println("-------Nhập ENTER để tiếp tục------");
			Act = sc.nextLine();
			}
		public static void sinhviendiemcaonhat() {
			double min = diemTB[0], max = diemTB[0];
			int x = 0, y = 0;

			for (i = 0; i < n; i++) {
				if (min > diemTB[i]) {
					min = diemTB[i];
					x = i;
				}
				if (max < diemTB[i]) {
					max = diemTB[i];
					y = i;
				}
			}
			System.out.println("Học sinh có kết quả học tập cao nhất là :");
			System.out.println((y + 1) + " \t " + ten[y] + " \t " + namsinh[y] + " \t " + diemLP1[y] + " \t "
					+ diemLP2[y] + " \t " + diemTB[y]);

			System.out.println("Học sinh có kết quả học tập thấp nhất là :");
			System.out.println((x + 1) + " \t " + ten[x] + " \t " + namsinh[x] + " \t " + diemLP1[x] + " \t "
					+ diemLP2[x] + " \t " + diemTB[x]);

			sc.nextLine();
			System.out.println("Ấn Enter để về menu chính");
			sc.nextLine();
		}
		public static void sapxepsinhvien() {
			int[] vitri = new int[n];
			for (i = 0; i < n; i++) {
				vitri[i] = i;
			}
			int temp;
			for (i = 0; i < n - 1; i++) {
				for (int j = i + 1; j < n; j++) {
					if (diemTB[vitri[i]] < diemTB[vitri[j]]) {
						temp = vitri[j];
						vitri[j] = vitri[i];
						vitri[i] = temp;
					}
				}
			}
			

			for (i = 0; i < n; i++) {
				System.out.println("Danh sách sinh viên đã được sắp xếp theo điểm trung bình ");
				System.out.println("--------------------------------------------------------------------");
				System.out.println("STT  Họ và tên              Ngày sinh     lp1  lp2  ĐTB  ");
				System.out.println("--------------------------------------------------------------------");
				for (i = 0; i < n; i++) {
					System.out.printf("%-5s%-23s%-14s%-5s%-5s%-5s\n", (i + 1), ten[vitri[i]], namsinh[vitri[i]],
							diemLP1[vitri[i]], diemLP2[vitri[i]], diemTB[vitri[i]]);
				}
			}

			sc.nextLine();
			System.out.println("Ấn Enter để về menu chính");
			sc.nextLine();
		}
		public static void ketthuc() {
			System.out.println("=======Tkank you!======");
			System.exit(0);
		}
		
	public static void myMenu() {
		while(true) {
			System.out.println(" ____________________________");
			System.out.println(" -CHỌN LỰA CHỨC NĂNG-");
			System.out.println("--------------------------");
			System.out.println(" 1.Nhập danh sinh viên: ");
			System.out.println(" 2.In danh sách sinh viên:");
			System.out.println(" 3.Top sinh viên: ");
			System.out.println(" 4.Sắp xếp theo Điểm: ");
			System.out.println("======================");
			System.out.println(" 5.Kết thúc chương trình");
			System.out.print("     Nhập chức năng mà bạn muốn thực hiện :");
			int Act = sc.nextInt();
			if(Act ==1) {
				nhapdanhsachsinhvien();
		     }
			else if (Act ==2) {
				indanhsachsinhvien();
			}
			else if (Act == 3) {
				sinhviendiemcaonhat();
			}
			else if (Act == 4) {
				sapxepsinhvien();
			}
			else {
				ketthuc();
			}
		}
	}
	}
    		

