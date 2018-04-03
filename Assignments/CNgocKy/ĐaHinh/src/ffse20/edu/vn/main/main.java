package ffse20.edu.vn.main;

import ffse20.edu.vn.modle.Cho;
import ffse20.edu.vn.modle.DongVat;
import ffse20.edu.vn.modle.Meo;
import ffse20.edu.vn.modle.Vit;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DongVat ani1 = new Cho();
		DongVat ani2 = new Meo();
		DongVat ani3 = new Vit();
		
		ani1.speak();
		ani2.speak();
		ani3.speak();
	}

}
