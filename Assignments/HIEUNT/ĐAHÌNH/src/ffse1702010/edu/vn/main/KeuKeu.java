package ffse1702010.edu.vn.main;

import ffse1702010.edu.vn.model.Cho;
import ffse1702010.edu.vn.model.DongVat;
import ffse1702010.edu.vn.model.Meo;
import ffse1702010.edu.vn.model.Voi;

public class KeuKeu {

	public static void main(String[] args) {
		 DongVat ani1 =new Cho();
         DongVat ani2 =new Meo();
         DongVat ani3 =new Voi();
         ani1.speak();
         ani2.speak();
         ani3.speak();
	}

}
