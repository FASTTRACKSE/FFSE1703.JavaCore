package ffse1702010.edu.vn.io;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import ffse1702010.edu.vn.model.SinhVien;

public class TextFileFactory {
	public static boolean luuFile(ArrayList<SinhVien> arrSinhVien, String path) {
		try {
			FileOutputStream fos = new FileOutputStream(path);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			for (SinhVien kh : arrSinhVien) {
				String line = kh.getNgaySinh() + ";" + kh.getTen() + ";" + kh.getLp1() + ";" + kh.getLp2();
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
					SinhVien kh = new SinhVien(arr[0], arr[1],Integer.parseInt(arr[2]),Integer.parseInt(arr[3]));
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
