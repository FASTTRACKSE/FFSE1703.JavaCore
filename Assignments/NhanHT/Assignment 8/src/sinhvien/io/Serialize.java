package sinhvien.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import sinhvien.model.*;

public class Serialize {
	public static boolean luuFile(ArrayList<SinhVien> arrSinhVien, String path) {
		try {
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(arrSinhVien);
			oos.close();
			fos.close();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
	public static ArrayList<SinhVien> docFile(String path) {
		ArrayList<SinhVien> arrSinhVien = new ArrayList<SinhVien>();
		try {
			FileInputStream fis = new FileInputStream(path);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object data = ois.readObject();
			arrSinhVien = (ArrayList<SinhVien>) data;
			ois.close();
			fis.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return arrSinhVien;
	}

}

