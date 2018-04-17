package Assignment_8.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import Assignment_8.model.SinhVien;

public class FileFactory2 {
	public static boolean luuFile(ArrayList<SinhVien> arrSinhVien, String path) {
		try {
			FileOutputStream fos = new FileOutputStream(path);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			for (SinhVien sv : arrSinhVien) {
				String line = sv.getHoten() + ";" + sv.getTuoiSV() + ";" + sv.getDiemLP1() + ";" + sv.getDiemLP2() + ";" + sv.getDiemTB() + ";" + sv.getXeploai();
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
				if (arr.length == 6) {
					SinhVien sv = new SinhVien(arr[0], Integer.parseInt(arr[1]), Float.parseFloat(arr[2]), Float.parseFloat(arr[3]), Float.parseFloat(arr[4]), arr[5]);
					arrSinhVien.add(sv);
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
