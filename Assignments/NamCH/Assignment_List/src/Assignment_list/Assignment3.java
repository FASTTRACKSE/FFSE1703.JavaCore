package Assignment_list;
import java.util.Scanner;
public class Assignment3 {
	public static Scanner input=new Scanner(System.in);
	public static String[] datatensv = new String[100]; 
	public static Double[] datadiemlp1 = new Double[100];
	public static Double[] datadiemlp2 = new Double[100];
	public static Double[] datadiemtb = new Double[100];
	public static int sorf[]=new int[100];
	public static int k=0,count=0,l=0,stt=0,tempt=0;
	public static Double max=0.0,temp=0.0;
	public static String tempp,action,sosanh="k";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myMenu();
	}
	public static void addsv() {
		System.out.println("THÊM SINH VIÊN VÀO DANH SÁCH");
		System.out.println("============================");
		System.out.println("Bạn muốn nhập bao nhiêu sinh viên ?");
		int numsv= input.nextInt();
		count=numsv + count;
		for (;k<count;k++) {
			input.nextLine();
			System.out.println("Nhập tên sinh viên thứ "+(k+1)+" : ");
			datatensv[k]=input.nextLine();
			System.out.println("Nhập Điểm LP1:");
			datadiemlp1[k]=input.nextDouble();
			System.out.println("Nhập Điểm LP2:");
			datadiemlp2[k]=input.nextDouble();
			
			datadiemtb[k]=(datadiemlp1[k] + datadiemlp2[k])/2;
			sorf[k]=k;
		}
		action=input.nextLine();
		System.out.println("=====================================");
		System.out.println("Nhập ENTER để Xem DANH SÁCH SINH VIÊN");
		System.out.println("Hoặc gõ K để kết thúc trương trình");
		action=input.nextLine();
		if(action.equals(sosanh)) {
			 endsv();
			  }
		printsv();
	}
	public static void printsv() {
		System.out.println("-----------DANH SÁCH TẤT CẢ SINH VIÊN-------------");
		System.out.println("==================================================");
		System.out.println("STT|| Tên          ||Điểm LP1||Điểm LP2||Điểm TB");
		System.out.println("--------------------------------------------------");
		for (int i = 0 ; i < count; i++) {					
					for (int j=i+1;j<count ;j++) {
						if (sorf[i]>sorf[j]) {							
							tempt = sorf[j];
							sorf[j]=sorf[i];
							sorf[i]=tempt;
							tempp = datatensv[j];
							datatensv[j] = datatensv[i];
							datatensv[i] = tempp;
							temp = datadiemtb[j];
							datadiemtb[j] = datadiemtb[i];
							datadiemtb[i] = temp;
						}					
					}										
				}
		for(int j=0,randum;j<count;j++) {
			randum=sorf[j];
			System.out.print(" " +(j+1)+"   "+datatensv[randum] +"\t");
			System.out.print(  datadiemlp1[randum] +"\t");
			System.out.print(datadiemlp2[randum] +"\t");
			System.out.println(((datadiemlp1[randum]+datadiemlp2[randum])/2) +"\t");
		}
		System.out.println("======================");
		System.out.println("Nhập ENTER để tiếp tục xem SINH VIÊN CÓ ĐIỂM CAO NHẤT");
		System.out.println("Hoặc gõ K để kết thúc trương trình");
		action=input.nextLine();
		if(action.equals(sosanh)) {
			 endsv();
			  }
		topsv();
	}
	public static void topsv() {
		System.out.println("-----------SINH VIÊN CÓ ĐIỂM CAO NHẤT-------------");
		System.out.println("==================================================");		
		
		
		for (int j=0;j<count;j++) {
			if(max<datadiemtb[j]) {
				max =datadiemtb[j];
				stt=j;				
			}			
		}
		for (int j=0;j<count;j++) {
			System.out.println(datadiemtb[j]);
			if(max<=datadiemtb[j]) {
				System.out.println("Là sinh viên:" +"==>>> " + datatensv[j]+" <<<==" +"\n" +"Có điểm trung bình " +max +"\n" + "Có số thứ tự là "+(j+1));		
			}
		}
		System.out.println("=============================================");
		System.out.println("Nhập ENTER để xem Danh sách SẮP XẾP THEO ĐIỂM");
		System.out.println("Hoặc gõ K để kết thúc trương trình");
		action=input.nextLine();
		if(action.equals(sosanh)) {
			 endsv();
			  }
		sorfsv();
	}
	public static void sorfsv() {
		System.out.println("-----------SẮP XẾP THEO ĐIỂM TRUNG BÌNH------------");
		System.out.println("==================================================");
		for (int i = 0 ; i < count; i++) {					
			for (int j=i+1;j<count ;j++) {
				if (sorf[i]>sorf[j]) {							
					tempt = sorf[j];
					sorf[j]=sorf[i];
					sorf[i]=tempt;					
				}					
			}										
		}
		for (int i = 0 ; i < count; i++) {
			
			for (int j=i+1;j<count ;j++) {
				if (datadiemtb[i]>datadiemtb[j]) {
					temp = datadiemtb[j];
					datadiemtb[j] = datadiemtb[i];
					datadiemtb[i] = temp;
					tempt = sorf[j];
					sorf[j]=sorf[i];
					sorf[i]=tempt;
				}					
			}
			
			
		}
		
		System.out.println("-----------DANH SÁCH TẤT CẢ SINH VIÊN-------------");
		System.out.println("==================================================");
		System.out.println("STT|| Tên          ||Điểm LP1||Điểm LP2||Điểm TB");
		System.out.println("--------------------------------------------------");
		for (int i=0;i<count;i++) {
			int ll=sorf[i];
			System.out.print(" " +(i+1)+"   "+datatensv[ll] +"\t");
			System.out.print(  datadiemlp1[ll] +"\t");
			System.out.print(datadiemlp2[ll] +"\t");
			System.out.println(datadiemtb[i] +"\t");			
		}
		System.out.println("===============================================");
		System.out.println("Nhập ENTER để xem danh sách SẮP XẾP THEO HỌ TÊN");
		System.out.println("Hoặc gõ K để kết thúc trương trình");
		action=input.nextLine();
		if(action.equals(sosanh)) {
			 endsv();
			  }
		sorfnamesv();
	}
	public static void sorfnamesv() {
		System.out.println("---------------SẮP XẾP THEO HỌ TÊN----------------");
		System.out.println("==================================================");
		for (int i = 0 ; i < count; i++) {					
			for (int j=i+1;j<count ;j++) {
				if (sorf[i]>sorf[j]) {							
					tempt = sorf[j];
					sorf[j]=sorf[i];
					sorf[i]=tempt;				
				}					
			}										
		}
		for (int i = 0 ; i < count; i++) {			
			for (int j=i+1;j<count ;j++) {
				int result = datatensv[i].compareTo( datatensv[j] );
				if (result>0) {
					tempp = datatensv[j];
					datatensv[j] = datatensv[i];
					datatensv[i] = tempp;
					tempt = sorf[j];
					sorf[j]=sorf[i];
					sorf[i]=tempt;
				}					
			}						
		}
		
		System.out.println("-----------DANH SÁCH TẤT CẢ SINH VIÊN-------------");
		System.out.println("==================================================");
		System.out.println("STT|| Tên          ||Điểm LP1||Điểm LP2||Điểm TB");
		System.out.println("--------------------------------------------------");
		for (int i=0;i<count;i++) {
			l=sorf[i];
			System.out.print(" " +(i+1)+"   "+datatensv[i] +"\t");
			System.out.print(  datadiemlp1[l] +"\t");
			System.out.print(datadiemlp2[l] +"\t");
			System.out.println(((datadiemlp1[l]+datadiemlp2[l])/2) +"\t");			
		}
		System.out.println("===========================================");
		System.out.println("Nhập ENTER để Thêm sinh viên vào danh sách");
		System.out.println("Hoặc gõ K để kết thúc trương trình");
		action=input.nextLine();
		if(action.equals(sosanh)) {
			 endsv();
			  }
		addsv();
	}
	public static void endsv() {
		System.out.println("Kết thúc chương trình");
		System.out.println("======================");
		System.out.println("=======Tkank you======");
		System.exit(0);
	}
	public static void myMenu() {
		
			System.out.println("         ____________________________");
			System.out.println("         |==========================|");
			System.out.println("         |----CHỌN LỰA CHỨC NĂNG----|");
			System.out.println("         |--------------------------|");
			System.out.println("         |--1.Nhập danh sinh viên---|");
			System.out.println("         |-2.In danh sách sinh viên-|");
			System.out.println("         |-----3.Top sinh viên------|");
			System.out.println("         |==========================|");
			System.out.println("         |--4.Kết thúc chương trình-|");
			System.out.println("         |__________________________|");
			System.out.print("     Nhập chức năng mà bạn muốn thực hiện :");
			int act = input.nextInt();
			if(act ==1) {
				addsv();
			}else if(act ==2) {
				printsv();
			}else if(act==3) {
				topsv();
			}else if(act==4) {
				sorfsv();
			}else if(act==5) {
				sorfnamesv();
			}else {
				endsv();
			}
		}
	

}
