package factoryfiles.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import sv.model.*;

public class serialize {

	public static boolean luuFile(ArrayList<sinhvien> dsSV, String path) {
		try {
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(dsSV);
			oos.close();
			fos.close();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	public static ArrayList<sinhvien> docFile(String path) {
		ArrayList<sinhvien> dsSV = new ArrayList<sinhvien>();
		try {
			FileInputStream fis = new FileInputStream(path);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object data = ois.readObject();
			ArrayList<sinhvien> arrayList = (ArrayList<sinhvien>) data;
			dsSV = arrayList;
			ois.close();
			fis.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return dsSV;
	}

}