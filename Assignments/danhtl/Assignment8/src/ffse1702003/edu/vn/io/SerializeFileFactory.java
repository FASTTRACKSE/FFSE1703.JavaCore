package ffse1702003.edu.vn.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import ffse1702003.edu.vn.model.SinhVien;

public class SerializeFileFactory {
	public static boolean luuFile(ArrayList<SinhVien> dsKH, String path) {
		try {
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(dsKH);
			oos.close();
			fos.close();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	public static ArrayList<SinhVien> docFile(String path) {
		ArrayList<SinhVien> dsKH = new ArrayList<SinhVien>();
		try {
			FileInputStream fis = new FileInputStream(path);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object data = ois.readObject();
			dsKH = (ArrayList<SinhVien>) data;
			ois.close();
			fis.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return dsKH;
	}
}
