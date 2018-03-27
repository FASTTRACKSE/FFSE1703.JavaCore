package Student_OOP;

public class nhapStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myStudent Student1,Student2,Student3;
		myStudent[] arrStudent;
		//nhap  hs thu nhat
		Student1 = new myStudent();
		Student1.setName("Ngô Minh Tuấn");
		Student1.setBirthday("18/08/1999");
		Student1.setLp1(8.5);
		Student1.setLp2(9.0);
		//nhap  hs thu hai
		Student2 = new myStudent();
		Student2.setName("Ngô Thị Thị Thúy");
		Student2.setBirthday("16/10/1993");
		Student2.setLp1(7.0);
		Student2.setLp2(8.0);
		//nhap  hs thu hai
		Student3 = new myStudent();
		Student3.setName("Ngô Thị Vân");
		Student3.setBirthday("26/07/1996");
		Student3.setLp1(8.0);
		Student3.setLp2(6.0);
		//đưa vào mảng
		arrStudent = new myStudent[10];
		arrStudent[0] = Student1;
		arrStudent[1] =Student2;
		arrStudent[2] =Student3;
		System.out.println(" Danh sách sinh viên");
		for(int i =0 ;i<3;i++) {
			System.out.println("Sinh viên : "+arrStudent[i].getName()+" có đtb là "+arrStudent[i].getDtb()+" xếp loại "+arrStudent[i].getXepLoai());
		}
	}

}
