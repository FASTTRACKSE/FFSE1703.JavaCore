package assignment10.java.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import assignment10.java.modle.*;;

public class SerializeFileFactory {
	public static boolean luuFile(ArrayList<ModleSinhVien> arrSvFile, String path) {
		try {
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(arrSvFile);
			oos.close();
			fos.close();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
	public static ArrayList<ModleSinhVien> docFile(String path) {
		ArrayList<ModleSinhVien> arrSvFile = new ArrayList<ModleSinhVien>();
		try {
			FileInputStream fis = new FileInputStream(path);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object data = ois.readObject();
			arrSvFile = (ArrayList<ModleSinhVien>) data;
			ois.close();
			fis.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return arrSvFile;
		
	}
}