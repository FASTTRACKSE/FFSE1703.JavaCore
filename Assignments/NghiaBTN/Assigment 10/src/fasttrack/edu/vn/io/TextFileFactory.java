package fasttrack.edu.vn.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;


import fasttrack.edu.vn.model.SinhVienModel;

public class TextFileFactory {
	public static boolean luuFile(ArrayList<SinhVienModel> arrSV, String path) {
		try {
			FileOutputStream fos = new FileOutputStream(path);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			for (SinhVienModel sv : arrSV) {
				String line = sv.getMaSV()+ ";" + sv.getTenSV() + ";" + sv.getTuoiSV() + ";" + sv.getLopSV();
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

public static ArrayList<SinhVienModel> docFile(String path) {
	ArrayList<SinhVienModel> dsKH = new ArrayList<SinhVienModel>();

	try {
		FileInputStream fis = new FileInputStream(path);
		InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
		BufferedReader br = new BufferedReader(isr);

		String line = br.readLine();
		while (line != null) {
			String[] arr = line.split(";");
			if (arr.length == 4) {
				SinhVienModel kh = new SinhVienModel(arr[0], arr[1],arr[2],arr[3]);
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
