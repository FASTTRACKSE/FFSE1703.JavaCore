package fasttrack.edu.vn;

public class NhapXe {
	public static void main(String[] args) {
		MyCar car1, car2;
		MyCar[] arrmyCar;

		// khởi tạo xe 1
		car1 = new MyCar();
		car1.setCarMaker("Mercedes Benz");
		car1.setCarModel("ML350");
		car1.setCarYear(2008);
		car1.setCarColor("Brown");

		// khởi tạo xe 2
		car2 = new MyCar();
		car2.setCarMaker("Toyota");
		car2.setCarModel("Crown");
		car2.setCarYear(2001);
		car2.setCarColor("Sivel");

		// khởi tạo mang xe
		arrmyCar = new MyCar[4];
		arrmyCar[0] = car1;
		arrmyCar[1] = car2;

		System.out.println("Danh Sách xe của tôi");
		for (int i = 0; i < 2; i++) {
			System.out.println(
					(i + 1) + "Model : " + arrmyCar[i].getCarModel() + " - Độ tuổi : " + arrmyCar[i].getCarAges());
		}

	}

}
