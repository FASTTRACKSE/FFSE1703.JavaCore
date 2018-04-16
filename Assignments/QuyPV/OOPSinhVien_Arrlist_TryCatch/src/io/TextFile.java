package io;

import sinhvien.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class TextFile {
	public static boolean luuFile(ArrayList<SinhVien> arr, String path) {

		try {
			FileOutputStream fos = new FileOutputStream(path);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			for (SinhVien x : arr) {
				String line = x.getHoTen() + ";" + x.getNgaySinh() + ";" + x.getDiemLp1() + ";" + x.getDiemLp2();
				bw.write(line);
				bw.newLine();
			}	
			bw.close();
			osw.close();
			fos.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static ArrayList<SinhVien> docFile(String path){
		ArrayList<SinhVien> arrFile = new ArrayList<>();
		try {
			FileInputStream fis = new FileInputStream(path);
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			BufferedReader br = new BufferedReader(isr);

			String line = br.readLine();
			while (line != null) {
				String[] arr = line.split(";");
				if (arr.length == 4) {
				double diemLP1 = Double.parseDouble(arr[2]);
				double diemLP2 = Double.parseDouble(arr[3]);
				
					SinhVien sv = new SinhVien(arr[0], arr[1], diemLP1, diemLP2);
					arrFile.add(sv);
				}
				line = br.readLine();
			}
			br.close();
			isr.close();
			fis.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return arrFile;
	}
}
