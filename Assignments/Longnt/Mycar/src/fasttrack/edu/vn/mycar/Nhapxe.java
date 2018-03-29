package fasttrack.edu.vn.mycar;

public class Nhapxe {

	public static void main(String[] args) {
		MyCar car1, car2;
		MyCar[] arrMycar;
		
		//khai bao xe 1
					car1 = new MyCar();
					car1.setcarMaker("Mecedes Benz");
					car1.setcarModel("ML350");
					car1.setcarYear(2010);
					car1.setcarColor("green");
		
		//khai bao xe 2
					car2 = new MyCar();
					car2.setcarMaker("Toyota");
					car2.setcarModel("ML444");
					car2.setcarYear(2009);
					car2.setcarColor("white");
					
	    // khoi tao mang xe
					arrMycar = new MyCar[10];
					arrMycar[0] = car1;
					arrMycar[1] = car2;

		System.out.println("Danh sach cac xe cua toi");
		for (int i=0; i<2; i++) {
			System.out.println((i+1) + ".Model" + arrMycar[i].getcarModel() + "- Tuoi doi" + arrMycar[i].getcarYear()+  "- Mau xe " + arrMycar[i].getcarColor());
		}
	}

}
