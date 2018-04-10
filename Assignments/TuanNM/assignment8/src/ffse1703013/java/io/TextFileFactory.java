package ffse1703013.java.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import ffse1703013.java.modle.*;

public class TextFileFactory {

	public static boolean luuFile(ArrayList<SinhVien> dsSinhVien, String path) {
		try {
			FileOutputStream fos = new FileOutputStream(path);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			for (SinhVien sv : dsSinhVien) {
				String line = sv.getName() + ";" + sv.getBirthday()+";"+sv.getLp1()+";"+sv.getLp2()+";"+sv.getDtb()+";"+sv.getXepLoai();
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
		ArrayList<SinhVien> dsSinhVien = new ArrayList<SinhVien>();

		try {
			FileInputStream fis = new FileInputStream(path);
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			BufferedReader br = new BufferedReader(isr);

			String line = br.readLine();
			while (line != null) {
				String[] arr = line.split(";");
				if (arr.length == 6) {
					Double i = Double.parseDouble(arr[2]);
					Double j = Double.parseDouble(arr[3]);
					Double k = Double.parseDouble(arr[4]);
					
					SinhVien sv = new SinhVien(arr[0], arr[1],i,j,k,arr[5]);
					dsSinhVien.add(sv);
				}
				line = br.readLine();
			}
			br.close();
			isr.close();
			fis.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return dsSinhVien;
	}
}	