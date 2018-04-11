package Assignment_list.Asm7.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.ArrayList;
import Assignment_list.Asm7.model.*;
public class TextFileFactory {	
	public static boolean saveFile(ArrayList<SinhVien> arrSv,String path) {
		try {
			FileOutputStream fos = new FileOutputStream(path);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			for (SinhVien sv : arrSv) {
				String line = sv.getHoTen() + ";" + sv.getNgaySinh()+ ";"+ sv.getDiemLp1()+ ";"+sv.getDiemLp2();
				bw.write(line);
				bw.newLine();
			}
			bw.close();
			osw.close();
			fos.close();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public static ArrayList<SinhVien> readFile(String path){	
		ArrayList<SinhVien> arrSv=new ArrayList<SinhVien>();
		try {
			
			FileInputStream fis = new FileInputStream(path);
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			BufferedReader br = new BufferedReader(isr);
			String line = br.readLine();
			while (line != null) {
				String[] arr = line.split(";");
				if (arr.length == 4) {
					float i = Float.parseFloat(arr[2]);
					float j = Float.parseFloat(arr[3]);
					SinhVien sv = new SinhVien(arr[0], arr[1] ,i,j);
					arrSv.add(sv);
				}
				line = br.readLine();
			}
			br.close();
			isr.close();
			fis.close();			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return arrSv;
	}
}
