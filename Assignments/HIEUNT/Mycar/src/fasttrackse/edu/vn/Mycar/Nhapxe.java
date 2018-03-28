package fasttrackse.edu.vn.Mycar;

public class Nhapxe {

	public static void main(String[] args) {
		Mycar car1, car2;
		Mycar[] arrMycar;
		car1 = new Mycar();
		
		car1.setcarMaker("Mercedes Benz");
		car1.setcarMaker("Teslax");
		car1.carModel="ML350-TRUC TIEP";
		car1.setcarYear(2004);
		car1.setcarColor("DEN");
		
		car2=new Mycar();
		car2.setcarMaker("TOyota");
		car2.carModel="crown";
		car2.setcarYear(2005);
		car2.setcarColor("DEN");

		arrMycar = new Mycar[10];
		arrMycar[0]=car1;
		arrMycar[1]=car2;
		System.out.println("DANH SACH XE CUA TOI**");
		for(int i=0;i<2;i++) {
			System.out.println((i+1)+".Model:" + arrMycar[i].getcarModel()+".year:"+arrMycar[i].getcarAges());
		}


		

	}

}
