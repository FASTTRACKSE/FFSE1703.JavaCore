package test.io.main;
import java.util.ArrayList;
import test.io.model.*;
import test.io.*;
public class QuanLyKhachHang {
	public static void saveFile() {
		ArrayList<KhachHang> dsKh = new ArrayList<KhachHang>();
		dsKh.add(new KhachHang("01","Pham Tran Duc"));
		dsKh.add(new KhachHang("02","Pham Ngoc Minh"));
		dsKh.add(new KhachHang("03","Tran Trung Hieu"));
		boolean kt = Text.saveFile(dsKh, "tenFile.txt");
		if (kt==true) {
			System.out.println("Luu file thanh cong!");
		}
		else {
			System.out.println("Luu file that bai!");
		}
	}
	public static void main(String[] args) {
		saveFile();
		ArrayList<KhachHang> dsKh = Text.readFile("tenFile.txt");
		System.out.println("Danh sach khach hang luu vao may tinh la: ");
		for(KhachHang kh : dsKh) {
			System.out.println(kh);
		}
	}
}
