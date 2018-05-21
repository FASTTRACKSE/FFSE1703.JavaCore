package model;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

import connector.GetConnect;

public class QuanLiLopHoc_Statement {
	final Connection conn= (new GetConnect()).getConnect("localhost", "Quan_li_truong_hoc", "phamquy481", "a0163763123");
	ArrayList<QuanLiLopHoc_Model> arrLop = new ArrayList<>();
	int soLuongSinhVien;
	
	public ArrayList<QuanLiLopHoc_Model> sellectAllLop(){
		arrLop.clear();
		try {
			String sql = "select * from Lop";
			Statement statement=conn.createStatement();
			ResultSet result=statement.executeQuery(sql);
			while(result.next())
			{
				 String maLop = result.getString("Malop");
				 String tenLop = result.getString("Tenlop");
				 String namHoc = result.getString("Namhoc");
				 arrLop.add(new QuanLiLopHoc_Model(maLop, tenLop, namHoc));
			}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		return arrLop;
	}
	
	public void insertLopHoc(String maLop, String tenLop, String namHoc) {
		try {
			String sql = "insert into Lop values('"+0+"','"+maLop+"', '"+tenLop+"', '"+namHoc+"')";
			Statement statement = conn.createStatement();
			int x=statement.executeUpdate(sql);
			if(x>0) {
				JOptionPane.showMessageDialog(null, "Thêm lớp học thành công!");

			}
		}
			catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void updateLopHoc(String maLop, String tenLop, String namHoc) {
		try
		{
			String sql="update Lop set Tenlop='" + tenLop + "', Namhoc='"+ namHoc + "' where Malop='" + maLop +"'";
			Statement statement = conn.createStatement();
			int y=statement.executeUpdate(sql);
			if(y>0){
				JOptionPane.showMessageDialog(null, "Sửa lớp học thành công!");
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void deleteLopHoc(String maLop) {
		try
		{
			String sql="delete from Lop where Malop='" + maLop + "'";
			Statement statement=conn.createStatement();
			int x=statement.executeUpdate(sql);
			if(x>0){
				JOptionPane.showMessageDialog(null, "Xóa lớp học thành công!");
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public int demSoSinhVien(String maLop) {
		try {
			String sql = "select count(*) from Sinh_vien where Malop = " + "'" + maLop + "'";
			Statement statement=conn.createStatement();
			ResultSet result=statement.executeQuery(sql);
			while(result.next())
			{
				 soLuongSinhVien = result.getInt("COUNT(*)");
			}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		return soLuongSinhVien;
	}
}
