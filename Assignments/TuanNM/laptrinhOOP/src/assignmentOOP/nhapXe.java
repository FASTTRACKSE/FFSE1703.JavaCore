package assignmentOOP;

public class nhapXe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myCar car1,car2;
		myCar[] arrMyCar;
		//nhạp xe thứ nhất
		car1 = new myCar();
		car1.setCarMaker("Mercedes benz");
		car1.setCarModel("ML583");
		car1.setCarColor("Black");
		car1.setCarYear(2012);
		//nhạp xe thứ hai
		car2 = new myCar();
		car2.setCarMaker("honda");
		car2.setCarModel("FE583");
		car2.setCarColor("Blue");
		car2.setCarYear(2015);
		//khai bao mang xe
		arrMyCar = new myCar[10];
		arrMyCar[0] = car1;
		arrMyCar[1] = car2;
		System.out.println("Danh sách xe");
		for(int i = 0;i<2;i++) {
			System.out.println((i+1)+"Model: "+arrMyCar[i].getCarModel()+"Năm sx : "+arrMyCar[i].getCarAge());
		}
	}

}
