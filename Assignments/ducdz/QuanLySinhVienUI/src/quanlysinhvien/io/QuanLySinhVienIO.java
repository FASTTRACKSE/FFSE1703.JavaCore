package quanlysinhvien.io;
import java.io.*;
import java.util.ArrayList;
import quanlysinhvien.model.*;
public class QuanLySinhVienIO {
	public static boolean saveFile(ArrayList<SinhVien> arrSv,String path) {
		try {
				FileOutputStream fos = new FileOutputStream(path);
				OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
				BufferedWriter bw = new BufferedWriter(osw);
				for(SinhVien x : arrSv) {
					String line = x.getLopSv()+";"+x.getMaSv()+";"+x.getTenSv()+";"+x.getTuoiSv();
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
	public static ArrayList<SinhVien> readFile(String path) {
		ArrayList<SinhVien> dsSv = new ArrayList<SinhVien>();
		try {
				FileInputStream fis = new FileInputStream(path);
				InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
				BufferedReader br = new BufferedReader(isr);
				String line = br.readLine();
				while(line!=null) {
					String[] arr = line.split(";");
					if(arr.length == 4) {
						SinhVien sv = new SinhVien(arr[0],arr[1],arr[2],arr[3]);
						dsSv.add(sv);
					}
					line=br.readLine();
				}
				br.close();
				isr.close();
				fis.close();
			}
		catch(Exception e) {
			e.printStackTrace();
		}
		return dsSv;
	}
}
