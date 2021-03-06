package sinhvien.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
//
import sinhvien.model.*;
//
public class Text {
	public static boolean luuFile(ArrayList<SinhVien> arrSinhVien, String path) {
		try {
			FileOutputStream fos = new FileOutputStream(path);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			for (SinhVien kh : arrSinhVien) {
				String line = kh.getSvName() + ";" + kh.getSvDate() + ";"+ kh.getSvDiemlp1()+";"+ kh.getSvDiemlp2();
				bw.write(line);
				bw.newLine();
			}

			bw.close();
			osw.close();
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
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			BufferedReader br = new BufferedReader(isr);

			String line = br.readLine();
			while (line != null) {
				String[] arr = line.split(";");
				if (arr.length == 4) {
					double Diemlp1 = Double.parseDouble(arr[2]);
					double Diemlp2 = Double.parseDouble(arr[3]);
					SinhVien kh = new SinhVien(arr[0], arr[1], Diemlp1, Diemlp2);
					arrSinhVien.add(kh);
				}
				line = br.readLine();
			}
			br.close();
			isr.close();
			fis.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return arrSinhVien;
	}
}
