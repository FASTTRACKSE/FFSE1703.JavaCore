package fasttrackse.fileiosample.io;




import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import fasttrack.ffse20.model.*;


public class TextFileFactory {
	public static boolean luuFile(ArrayList<QuanLySinhVienModel> arrSV, String path) {
		try {
			FileOutputStream fos = new FileOutputStream(path);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			for (QuanLySinhVienModel kh : arrSV) {
				String line = kh.getTenSV() + ";" + kh.getLopSV()+ ";" + kh.getMaSV()+ ";" + kh.getTuoiSV();
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

	public static ArrayList<QuanLySinhVienModel> docFile(String path) {
		ArrayList<QuanLySinhVienModel> arrSV = new ArrayList<QuanLySinhVienModel>();

		try {
			FileInputStream fis = new FileInputStream(path);
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			BufferedReader br = new BufferedReader(isr);

			String line = br.readLine();
			while (line != null) {
				String[] arr = line.split(";");
				if (arr.length == 2) {
					QuanLySinhVienModel kh = new QuanLySinhVienModel(line, line, line, line);
					arrSV.add(kh);
				}
				line = br.readLine();
			}
			br.close();
			isr.close();
			fis.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return arrSV;
	}
}