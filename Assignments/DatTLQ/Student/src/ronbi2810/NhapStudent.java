package ronbi2810;

public class NhapStudent {

	public static void main(String[] args) {
		myStudent stu1,stu2,stu3;
		myStudent[] arrStu;
		
		stu1= new myStudent();
		stu1.setStuName("Tong Quoc Dat");
		stu1.setStuDate("28/10/1996");
		stu1.setDLP1(9);
		stu1.setDLP2(9);
		
		
		stu2= new myStudent();
		stu2.setStuName("Ho Thanh Nhan");
		stu2.setStuDate("01/12/1999");
		stu2.setDLP1(5);
		stu2.setDLP2(9);
		
		stu3= new myStudent();
		stu3.setStuName("Pham Van Quy");
		stu3.setStuDate("18/11/1998");
		stu3.setDLP1(7);
		stu3.setDLP2(6);
		
		
		arrStu= new myStudent[4];
		arrStu[0]=stu1;
		arrStu[1]=stu2;
		arrStu[2]=stu3;

		System.out.println("Danh Sach Sinh Vien");
		System.out.println("Name             "+"\t"+"Date    "+"\t"+"DiemLP1     "+"\t"+"DiemLP2"    +"\t"+"DTB");
		for(int i=0;i<4;i++) {
			System.out.println(arrStu[i].getStuName() +"\t"  +"\t"         +arrStu[i].getStuDate()	+"\t"	+arrStu[i].DLP1	+"\t"	+"\t"	+arrStu[i].getDLP2()	+"\t"			+arrStu[i].DTB());
		}

	}

}
