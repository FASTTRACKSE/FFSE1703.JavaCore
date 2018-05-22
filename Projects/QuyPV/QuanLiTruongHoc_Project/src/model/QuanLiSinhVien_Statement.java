package model;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

import connector.GetConnect;
import ui.QuanLiSinhVien;

public class QuanLiSinhVien_Statement {
	final Connection conn= (new GetConnect()).getConnect("localhost", "Quan_li_truong_hoc", "phamquy481", "a0163763123");
	ArrayList<QuanLiSinhVien_Model> arrSv = new ArrayList<>();
	
	public ArrayList<QuanLiSinhVien_Model> selectAllSv(){
		arrSv.clear();
		try {
			Statement statement = conn.createStatement();
			ResultSet result=statement.executeQuery("select * from Sinh_Vien");
			while(result.next())
			{
				String maSV = result.getString("Masv");
				String hoTen = result.getString("Hoten");
				String diachi = result.getString("Diachi");
				String phuong = result.getString("Phuong");
				String quanHuyen = result.getString("Quanhuyen");
				String tinhThanh = result.getString("Tinhthanh");
				String dienThoai = result.getString("Dienthoai");
				String email = result.getString("Email");
				String maLop = result.getString("Malop");
				arrSv.add(new QuanLiSinhVien_Model(maSV, hoTen, diachi, phuong, quanHuyen, tinhThanh, dienThoai, email, maLop));
			}
			} catch (Exception e) {
			e.printStackTrace();
			}
		return arrSv;
	}
	
	
	public void insert(String maSv, String hoTen, String diaChi, String phuong, String quanHuyen, String tinhThanh, String dienThoai, String email, String maLop) {
		try {
			String sql = "insert into Sinh_vien values('"+0+"','"+maSv+"', '"+hoTen+"', '"+diaChi+"','"+phuong+"', '"+quanHuyen+"', '"+tinhThanh+"',  '"+dienThoai+"', '"+email+"', '"+maLop+"')";
			Statement statement = conn.createStatement();
			int x=statement.executeUpdate(sql);
			if(x>0) {
				JOptionPane.showMessageDialog(null, "Thêm Sinh viên thành công!");

			}
		}
			catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void deleteSv(String maSv) {
		try
		{
			String sql="delete from Sinh_vien where Masv='" + maSv + "'";
			Statement statement=conn.createStatement();
			int x=statement.executeUpdate(sql);
			if(x>0){
				JOptionPane.showMessageDialog(null, "Xóa sinh viên thành công!");
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void updateSv(String maSv, String hoTen, String diaChi, String phuong, String quanHuyen, String tinhThanh, String dienThoai, String email, String maLop) {
		try
		{
			
			String sql="update Sinh_vien set Hoten='" + hoTen + "', Diachi='"+ diaChi +  "', Phuong='" + phuong + "', Quanhuyen ='" + quanHuyen + "', Tinhthanh ='" + tinhThanh + "', Dienthoai ='" + dienThoai + "', Email ='" + email + "', Malop ='" + maLop +"' where Masv='" + maSv +"'";
			Statement statement = conn.createStatement();
			int y=statement.executeUpdate(sql);
			if(y>0){
				JOptionPane.showMessageDialog(null, "Sửa sinh viên thành công!");
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
}
