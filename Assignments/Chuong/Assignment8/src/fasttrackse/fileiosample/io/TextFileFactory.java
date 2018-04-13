package fasttrackse.fileiosample.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import fasttrackse.fileiosample.model.KhachHang;

public class TextFileFactory {
	public static boolean luuFile(ArrayList<KhachHang> dsKH, String path) {
		try {
			FileOutputStream fos = new FileOutputStream(path);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			for (KhachHang kh : dsKH) {
				String line = kh.getMa() + ";" + kh.getTen();
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

	public static ArrayList<KhachHang> docFile(String path) {
		ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();

		try {
			FileInputStream fis = new FileInputStream(path);
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			BufferedReader br = new BufferedReader(isr);

			String line = br.readLine();
			while (line != null) {
				String[] arr = line.split(";");
				if (arr.length == 2) {
					KhachHang kh = new KhachHang(arr[0], arr[1]);
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