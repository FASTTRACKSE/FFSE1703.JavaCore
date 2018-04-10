package quanlisinhvien.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import sinhvien.model.*;

public class TextFileFactory {
	public static boolean luuFile(ArrayList<SinhVien> sv, String path) {
		try {
			FileOutputStream fos = new FileOutputStream(path);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			for (SinhVien x : sv) {
				String line = x.getStuName() + ";" + x.getStuDate() + ";" +x.getDLP1() + ";" +x.getDLP2();
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
		ArrayList<SinhVien> sv = new ArrayList<SinhVien>();

		try {
			FileInputStream fis = new FileInputStream(path);
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			BufferedReader br = new BufferedReader(isr);

			String line = br.readLine();
			while (line != null) {
				String[] arr = line.split(";");
				if (arr.length == 2) {
					double result1=Double.parseDouble(arr[2]);
					double result2=Double.parseDouble(arr[3]);

					SinhVien arrsv = new SinhVien(arr[0], arr[1],result1,result2);
					sv.add(arrsv);
				}
				line = br.readLine();
			}
			br.close();
			isr.close();
			fis.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return sv;
	}
}
