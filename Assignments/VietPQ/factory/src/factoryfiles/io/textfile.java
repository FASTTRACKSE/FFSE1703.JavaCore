package factoryfiles.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import sv.model.*;

public class textfile {
	public static boolean luuFile(ArrayList<sinhvien> dsSV, String path) {
		try {
			FileOutputStream fos = new FileOutputStream(path);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			for (sinhvien sv : dsSV) {
				String line = sv.getTenSV() + ";" + sv.getNgaysinh() + ";" + sv.getLp1() + ";" + sv.getLp2() + ";"
						+ sv.getLP3();
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

	public static ArrayList<sinhvien> docFile(String path) {
		ArrayList<sinhvien> dsSV = new ArrayList<sinhvien>();

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
					sinhvien sv = new sinhvien(arr[0], arr[1], i, j, k);
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