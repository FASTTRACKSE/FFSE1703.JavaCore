package fasttrackse.edu.connect;
import java.sql.*;
import java.util.Scanner;
import java.util.*;
public class SinhVien {
			Connection con = null;
			PreparedStatement print = null;
			Scanner sc = new Scanner(System.in);
		public  void insertSinhVien() {
			DBConnection kn = new  DBConnection();
		con = kn.ketnoi("localhost", "ffse1703", "thanhlong123",
				"123456");
		String tensv,tuoisv,lop;
		System.out.println("Nhap ten sinh vien");
		tensv=sc.nextLine();
		System.out.println("Nhap tuoi sinh vien");
		tuoisv=sc.nextLine();
		System.out.println("Nhap lop cho sinh vien");
		lop = sc.nextLine();
		String sql = "insert into sinhvien(tensv,tuoisv,lop) value(?,?,?)";
		try {
			print = con.prepareStatement(sql);
			print.setString(1, tensv);
			print.setString(2, tuoisv);
			print.setString(3, lop);
			int kt = print.executeUpdate();
			if(kt !=0) {
				System.out.println("Them thanh cong");
			} else {
				System.out.println("Them that bai");
			}
			print.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Loi:" + e.getMessage());
			
		}
	
		}
		public void deleteSinhVien() {
			DBConnection kn = new  DBConnection();
			con = kn.ketnoi("localhost", "ffse1703", "thanhlong123",
					"123456");
			
		}
		}
