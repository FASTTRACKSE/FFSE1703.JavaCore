package ffse1702010.edu.vn.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import ffse1702010.edu.vn.model.SinhVien;

public class SerializeFileFactory {

	public static boolean luuFile(ArrayList<SinhVien> arr, String path) {
		try {
			FileOutputStream fos = new FileOutputStream(path);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			for (SinhVien kh : arr) {
				String line = kh.getMaSV() + ";" + kh.getTenSV() + ";" + kh.getTuoiSV()+";"+kh.getLopSV();
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
		ArrayList<SinhVien> arr = new ArrayList<SinhVien>();

		try {
			FileInputStream fis = new FileInputStream(path);
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			BufferedReader br = new BufferedReader(isr);

			String line = br.readLine();
			while (line != null) {
				String[] arr1 = line.split(";");
				if (arr1.length == 4) {
					SinhVien kh = new SinhVien(arr1[0], arr1[1],arr1[2],arr1[3]);
					arr.add(kh);
				}
				line = br.readLine();
			}
			br.close();
			isr.close();
			fis.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return arr;
	}
}
