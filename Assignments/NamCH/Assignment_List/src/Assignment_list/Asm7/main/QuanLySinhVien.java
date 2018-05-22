package Assignment_list.Asm7.main;

import Assignment_list.Asm7.io.SerializeFileFactory;
import Assignment_list.Asm7.model.SinhVien;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.io.File;
public class QuanLySinhVien {
	public static Scanner input=new Scanner(System.in);	
	public static ArrayList<SinhVien> arrSv=new ArrayList<SinhVien>();
	public static int stt=0;
	
	public static void main(String[] args) {
		myMenu();
	}
	public static void addSv() {		
		System.out.println("         THÃŠM SINH VIÃŠN VÃ€O DANH SÃ�CH");
		System.out.println("         ============================");
		System.out.print("         Báº¡n muá»‘n nháº­p bao nhiÃªu Sinh ViÃªn :");
		File file = new File("D:/FFSE1703.JavaCore/Assignments/NamCH/Assignment_List/dulieusinhvien.txt");	    
	    if(file.exists()) {
	    	ArrayList<SinhVien> arrSvFile = SerializeFileFactory.readFile("dulieusinhvien.txt");
	  		arrSv=arrSvFile;
	    }		
		try {
		int size = Integer.parseInt(input.nextLine());			
		for(int i=0;i<size;i++) {
			System.out.print("         Nhap tÃªn cho sinh vien thu " + (stt+1)  + " : ");
			String hoTen = input.nextLine();			
			System.out.print("         Nhap ngÃ y sinh cho sinh vien thu " + (stt+1)  + " : ");
			String ngaySinh = input.nextLine();		
			System.out.print("         Nhap Ä�iá»ƒm LP1 cho sinh vien thu " + (stt+1)  + " : ");
			float diemLp1 = Float.parseFloat(input.nextLine())	;
			System.out.print("         Nhap Ä�iá»ƒm LP2 cho sinh vien thu " + (stt+1)  + " : ");
			float diemLp2 = Float.parseFloat(input.nextLine())	;
			arrSv.add(new SinhVien(hoTen,ngaySinh,diemLp1,diemLp2));			
			boolean checked= SerializeFileFactory.saveFile(arrSv, "dulieusinhvien.txt");
			if (checked == true) {
				System.out.println("Ä�Ã£ lÆ°u thÃ´ng tin cá»§a "+size +" sinh viÃªn");
			} else {
				System.out.println("LÆ°u tháº¥t báº¡i");
			}
		}
		}catch(Exception e) {
			System.out.println("         Nháº­p sai Ä‘á»‹nh dáº¡ng !!!");
			System.out.println("         Vui lÃ²ng nháº­p láº¡i");
		}
		
	}
	public static void printSv() {
		System.out.println("         DANH SÃ�CH Táº¤T Cáº¢ SINH VIÃŠN");
		System.out.println("         ==========================");
		System.out.println("         Stt\t TÃªn\t NgÃ y Sinh\t Ä�iá»ƒm LP1\t Ä�iá»ƒm lp2\t Ä�iá»ƒm TB\t Xáº¿p Loáº¡i");
		int i=0;
		ArrayList<SinhVien> arrSv = SerializeFileFactory.readFile("dulieusinhvien.txt");
		for(SinhVien x :arrSv) {			
			System.out.print("          "+(i+1)+"\t");
			System.out.println(x);
			i++;
		}
	}
	public static void topSv() {
		System.out.println("         -----------SINH VIÃŠN CÃ“ Ä�Iá»‚M CAO NHáº¤T-------------");
		System.out.println("         ==================================================");
		float max=0;
		int stt;
		for (int i=0;i<arrSv.size();i++) {
			if(max<arrSv.get(i).getDiemTB()) {
				max =arrSv.get(i).getDiemTB();
				stt=i;				
			}			
		}
		for (int i=0;i<arrSv.size();i++) {			
			if(max<=arrSv.get(i).getDiemTB()) {
				System.out.println("         LÃ  sinh viÃªn:" +"==>>> " + arrSv.get(i).getHoTen()+" <<<==" +"\n" +"CÃ³ Ä‘iá»ƒm trung bÃ¬nh " +max +"\n" + "CÃ³ sá»‘ thá»© tá»± lÃ  "+(i+1));		
			}
		}
	}
	public static void sorfDiemSV() {
		System.out.println("         -------Sáº®P Xáº¾P SINH VIÃŠN TÄ‚NG Dáº¦N THEO Ä�Iá»‚M TB------");
		System.out.println("         ====================================================");
		System.out.println("         Stt\t TÃªn\t NgÃ y Sinh\t Ä�iá»ƒm LP1\t Ä�iá»ƒm lp2\t Ä�iá»ƒm TB\t Xáº¿p Loáº¡i");
		Collections.sort(arrSv, SinhVien.compare);
		int i=0;
		  for(SinhVien x: arrSv){			  
			  	System.out.print("          "+(i+1)+"\t");
				System.out.println(x);
				i++;
		  }
	}
	public static void sorfNameSV() {
		System.out.println("         -------Sáº®P Xáº¾P SINH VIÃŠN THEO TÃŠN------");
		System.out.println("         =======================================");
		System.out.println("         Stt\t TÃªn\t NgÃ y Sinh\t Ä�iá»ƒm LP1\t Ä�iá»ƒm lp2\t Ä�iá»ƒm TB\t Xáº¿p Loáº¡i");
		Collections.sort(arrSv, SinhVien.compareName);
		int i=0;
		  for(SinhVien x: arrSv){			  
			  	System.out.print("          "+(i+1)+"\t");
				System.out.println(x);
				i++;
		  }
	}
	public static void printByNameSV() {
		System.out.println("         -------IN DANH SÃ�CH THEO TÃŠN------");
		System.out.println("         ==================================");
		System.out.print("         GÃµ tÃªn sinh viÃªn mÃ  báº¡n muá»‘n in: ");
		String act = input.nextLine();
		int i=0;
		try {
		System.out.println("         Stt\t TÃªn\t NgÃ y Sinh\t Ä�iá»ƒm LP1\t Ä�iá»ƒm lp2\t Ä�iá»ƒm TB\t Xáº¿p Loáº¡i");
		for(SinhVien x:arrSv) {
			if(act.equals(x.getHoTen())) {
				System.out.print("          "+(i+1)+"\t");
				System.out.println(x);
				i++;
				}else {
					throw new Exception(); 
				}
			
		}
		}catch (Exception e) {
			System.out.println("         khÃ´ng cÃ³ sinh viÃªn nÃ o tÃªn :"+act);
		}				
	}
	public static void changeNameSV() {
		System.out.println("         Stt\t TÃªn\t NgÃ y Sinh\t Ä�iá»ƒm LP1\t Ä�iá»ƒm lp2\t Ä�iá»ƒm TB\t Xáº¿p Loáº¡i");
		int i=0;
		for(SinhVien x :arrSv) {			
			System.out.print("          "+(i+1)+"\t");
			System.out.println(x);
			i++;
		}
		System.out.print("         Báº¡n muá»‘n thay Ä‘á»•i tÃªn cá»§a sinh viÃªn thá»© máº¥y : ");
		try {			
			int act = Integer.parseInt(input.nextLine());
			try {
				if((act)<=arrSv.size()) {
				System.out.print("         Nháº­p tÃªn mÃ  báº¡n muá»‘n thay Ä‘á»•i : ");
				String hoTen = input.nextLine();
				arrSv.get((act-1)).setHoTen(hoTen);
				System.out.println("         Ä�Ã£ thay Ä‘á»•i thÃ nh cÃ´ng sinh viÃªn thá»© : "+act);
				System.out.println(arrSv.get((act-1)).toString());
				}else {
					throw new Exception();
				}
			}catch (Exception e) {
				System.out.println("         Chá»‰ nháº­p tá»« 1 tá»›i " +arrSv.size());
			}
		}catch (Exception e) {
			System.out.println("         Nháº­p sai Ä‘á»‹nh dáº¡ng !!!");
			System.out.println("         Vui lÃ²ng nháº­p láº¡i!!!");
		}
	}
	public static void removeSv() {
		System.out.println("         Stt\t TÃªn\t NgÃ y Sinh\t Ä�iá»ƒm LP1\t Ä�iá»ƒm lp2\t Ä�iá»ƒm TB\t Xáº¿p Loáº¡i");
		int i=0;
		for(SinhVien x :arrSv) {			
			System.out.print("          "+(i+1)+"\t");
			System.out.println(x);
			i++;
		}
		System.out.print("         Nháº­p tÃªn sinh viÃªn mÃ  báº¡n muá»‘n xÃ³a : ");
		String ten = input.nextLine();					
			for(i=0;i<arrSv.size();i++) {
				if(ten.equals(arrSv.get(i).getHoTen())) {				
					arrSv.remove(i);
					i--;
				}
			}					
		System.out.println("         XÃ“A THÃ€NH CÃ”NG sinh viÃªn cÃ³ tÃªn : "+ten);			
		System.out.println("         Stt\t TÃªn\t NgÃ y Sinh\t Ä�iá»ƒm LP1\t Ä�iá»ƒm lp2\t Ä�iá»ƒm TB\t Xáº¿p Loáº¡i");
		int j=0;
		for(SinhVien x :arrSv) {		
			System.out.print("          "+(j+1)+"\t");
			System.out.println(x);
			j++;
		}
	}
	public static void endSv() {
		System.out.println("         Káº¿t thÃºc chÆ°Æ¡ng trÃ¬nh");
		System.out.println("         ======================");
		System.out.println("         =======Tkank you======");
		System.exit(0);
	}

	public static void myMenu() {
		while(true) {
			try {
				System.out.println("         ____________________________");
				System.out.println("         |==========================|");
				System.out.println("         |----CHá»ŒN Lá»°A CHá»¨C NÄ‚NG----|");
				System.out.println("         |--------------------------|");
				System.out.println("         |--1.Nháº­p danh sinh viÃªn---|");
				System.out.println("         |--2.In danh sÃ¡ch sinh viÃªn|");
				System.out.println("         |--3.Top sinh viÃªn---------|");
				System.out.println("         |--4.Sáº¯p xáº¿p theo tÄƒng dáº§n-|");
				System.out.println("         |--5.Sáº¯p xáº¿p theo TÃªn------|");
				System.out.println("         |--6.TÃ¬m kiáº¿m sinh viÃªn----|");
				System.out.println("         |--7.Ä�á»•i tÃªn sinh viÃªn-----|");
				System.out.println("         |--8.XÃ³a sinh viÃªn theo tÃªn|");
				System.out.println("         |==========================|");
				System.out.println("         |--9.Káº¿t thÃºc chÆ°Æ¡ng trÃ¬nh-|");
				System.out.println("         |__________________________|");
				System.out.print("     Nháº­p chá»©c nÄƒng mÃ  báº¡n muá»‘n thá»±c hiá»‡n :");				
				int act = Integer.parseInt(input.nextLine());					
				if(act ==1) {
					addSv();
				}else if(act ==2) {
					printSv();
				}else if(act==3) {
					topSv();
				}else if(act==4) {
					sorfDiemSV();
				}else if(act==5) {
					sorfNameSV();
				}else if(act==6) {
					printByNameSV();
				}else if(act==7) {
					changeNameSV();
				}else if(act==8) {
					removeSv();
				}else if(act==9) {
					endSv();
				}else {
					throw new Exception();
		        }
			}catch(NumberFormatException e){
					System.out.println("         Vui LÃ²ng nháº­p sá»‘");
			}catch (Exception e) {		
		         System.out.println("         Chá»‰ Ä�Æ°á»£c Nháº­p tá»« 1 Ä‘áº¿n 9 báº¡n nhÃ©!!!");				         
			}						
			System.out.println("         =====================================");
			System.out.println("         -------Nháº­p ENTER Ä‘á»ƒ tiáº¿p tá»¥c------");
			input.nextLine();
		}
	}

}

