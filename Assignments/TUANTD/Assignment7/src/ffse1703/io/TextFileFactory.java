package ffse1703.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import ffse1703.model.*;

public class TextFileFactory {
	public static boolean luuFile(ArrayList<SinhVien> dsSV, String path) {
		try {
			FileOutputStream fos = new FileOutputStream(path);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			for (SinhVien sv : dsSV) {
				String line = sv.getNameSV() + ";" + sv.getNgaySinh() + ";" + sv.getLp1() + ";" + sv.getLp2() + ";" + sv.getLp3();
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
		ArrayList<SinhVien> dsSV = new ArrayList<SinhVien>();

		try {
			FileInputStream fis = new FileInputStream(path);
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			BufferedReader br = new BufferedReader(isr);

			String line = br.readLine();
			while (line != null) {
				String[] arr = line.split(";");
				if (arr.length == 5) {
					float i = Float.parseFloat(arr[2]);
					float j = Float.parseFloat(arr[3]);
					float k = Float.parseFloat(arr[4]);
					SinhVien sv = new SinhVien(arr[0], arr[1] ,i,j,k);
					dsSV.add(sv);
				}
				line = br.readLine();
			}
			br.close();
			isr.close();
			fis.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return dsSV;
	}

}
