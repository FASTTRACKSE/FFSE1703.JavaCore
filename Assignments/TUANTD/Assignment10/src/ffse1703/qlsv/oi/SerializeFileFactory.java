package ffse1703.qlsv.oi;


	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.ObjectInputStream;
	import java.io.ObjectOutputStream;
	import java.util.ArrayList;
	import ffse1703.model.*;
	public class SerializeFileFactory {	
		public static boolean saveFile(ArrayList<HocSinh> arrSv,String path) {
			try {
				FileOutputStream fos = new FileOutputStream(path);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(arrSv);
				oos.close();
				fos.close();
				return true;
			}catch(Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		public static ArrayList<HocSinh> readFile(String path){	
			ArrayList<HocSinh> arrSvFile=new ArrayList<HocSinh>();
			try {
				
				FileInputStream fis = new FileInputStream(path);
				ObjectInputStream ois = new ObjectInputStream(fis);
				Object data = ois.readObject();
				arrSvFile = (ArrayList<HocSinh>) data;
				ois.close();
				fis.close();			
			}catch (Exception e) {
				e.printStackTrace();
			}
			return arrSvFile;
		}
	}
