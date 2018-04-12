package fasttrackse.edu.io;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import ffasttrackse.edu.model.SinhVien;

public class SerializeFileFactory {
	public static boolean luuFile(ArrayList<SinhVien> dsSV, String path) {
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

	public static ArrayList<SinhVien> docFile(String path) {
		ArrayList<SinhVien> dsSV = new ArrayList<SinhVien>();
		try {
			FileInputStream fis = new FileInputStream(path);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object data = ois.readObject();
			dsSV = (ArrayList<SinhVien>) data;
			ois.close();
			fis.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return dsSV;
	}
}
