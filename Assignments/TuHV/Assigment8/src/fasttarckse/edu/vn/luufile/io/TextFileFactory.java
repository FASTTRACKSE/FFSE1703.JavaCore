package fasttarckse.edu.vn.luufile.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import fasttrackse.edu.vn.luufile.model.*;

public class TextFileFactory {
	public static boolean luuFile(ArrayList<SinhVien> dsKH, String path) {
		try {
			FileOutputStream fos = new FileOutputStream(path);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			for (SinhVien kh : dsKH) {
				String line = kh.getSVten() + ";" + kh.getSVngaysinh() + ";" + kh.getSVLP1() + ";" + kh.getSVLP2() ;
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
		ArrayList<SinhVien> dsKH = new ArrayList<SinhVien>();

		try {
			FileInputStream fis = new FileInputStream(path);
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			BufferedReader br = new BufferedReader(isr);

			String line = br.readLine();
			while (line != null) {
				String[] arr = line.split(";");
				if (arr.length == 4) {
					double i = Double.parseDouble(arr[2]);
					double j = Double.parseDouble(arr[3]);
					SinhVien kh = new SinhVien(arr[0], arr[1],i,j);
					dsKH.add(kh);
				}
				line = br.readLine();
			}
			br.close();
			isr.close();
			fis.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return dsKH;
	}
}