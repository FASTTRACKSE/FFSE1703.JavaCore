package fasttrack.edu.vn.mycar;

public class Nhapxe {

	public static void main(String[] args) {
		Mycar car1, car2;
		Mycar[] arrMycar;

		// khai báo xe 1
		car1 = new Mycar();
		car1.setcarModel("Yammaha");
		car1.setcarMaker("MBH");
		car1.setcarYear(2004);
		car1.setcarColor("Green");
		
		// khai báo xe 1
		car2 = new Mycar();
		car2.setcarModel("Honda");
		car2.setcarMaker("HOG");
		car2.setcarYear(2002);
		car2.setcarColor("Blue");
		
		//khai báo mảng xe
		arrMycar = new Mycar[10];
		arrMycar[0] = car1;
		arrMycar[1] = car2;
		System.out.println("Danh sách các xe của tôi");
		for (int i = 0; i<2; i++) {
			System.out.println((i+1) + ".Model:" + arrMycar[i].getcarModel() + "- Tuổi đời :" +arrMycar[i].getcarAge() );
		}

	}

}
