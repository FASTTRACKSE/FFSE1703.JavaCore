package quanlisinhvien.io;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import sinhvien.model.*;


public class SerializeFileFactory {
	public static boolean luuFile(ArrayList<SinhVien> sv, String path) {
		try {
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(sv);
			oos.close();
			fos.close();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
	public static ArrayList<SinhVien> docFile(String path) {
		ArrayList<SinhVien> sv = new ArrayList<SinhVien>();
		try {
			FileInputStream fis = new FileInputStream(path);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object data = ois.readObject();
			sv = (ArrayList<SinhVien>) data;
			ois.close();
			fis.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return sv;
	}
}
