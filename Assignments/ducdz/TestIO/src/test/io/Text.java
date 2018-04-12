package test.io;
import java.io.*;
import java.util.ArrayList;

import test.io.model.KhachHang;
public class Text {
	public static boolean saveFile(ArrayList<KhachHang> dsKh,String path) {
		try {
			FileOutputStream fos = new FileOutputStream(path);
			OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			for(KhachHang kh : dsKh) {
				String line = kh.getMaKh()+";"+kh.getTenKh();
				bw.write(line);
				bw.newLine();
			}
			bw.close();
			osw.close();
			fos.close();
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	public static ArrayList<KhachHang> readFile(String path){
		ArrayList<KhachHang> dsKh = new ArrayList<KhachHang>();
		try {
			FileInputStream fis = new FileInputStream(path);
			InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
			BufferedReader br = new BufferedReader(isr);
			String line = br.readLine();
			while (line != null) {
				String[] arr = line.split(";");
				if (arr.length==2) {
					KhachHang kh = new KhachHang(arr[0],arr[1]);
					dsKh.add(kh);
				}
				line = br.readLine();
			}
			br.close();
			isr.close();
			fis.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return dsKh;
	}
}
