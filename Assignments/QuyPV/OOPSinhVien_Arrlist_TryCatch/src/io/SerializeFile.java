package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import sinhvien.*;

public class SerializeFile {
	public static boolean luuFile(ArrayList<SinhVien> arr, String path) {
		try {
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(arr);
			oos.close();
			fos.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	public static ArrayList<SinhVien> docFile(String path){
		ArrayList<SinhVien> arr = new ArrayList<>();
		try {
			FileInputStream fis = new FileInputStream(path);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object data = ois.readObject();
			arr = (ArrayList<SinhVien>) data;
			ois.close();
			fis.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return arr;
	}
}
