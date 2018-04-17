package fasttrackse.edu.io;
import fasttrackse.edu.model.QuanLy;
import fasttrackse.edu.main.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import fasttrackse.edu.modelsv.SinhVien;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class TextFile {	
	public static boolean saveFile(ArrayList<SinhVien> arraySinhVien,String path) {
		try {
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(arraySinhVien);
			oos.close();
			fos.close();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public static ArrayList<SinhVien> readFile(String path){	
		ArrayList<SinhVien> arrSvFile=new ArrayList<SinhVien>();
		try {
			
			FileInputStream fis = new FileInputStream(path);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object data = ois.readObject();
			arrSvFile = (ArrayList<SinhVien>) data;
			ois.close();
			fis.close();			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return arrSvFile;
	}
}
