package model;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

import connector.GetConnect;

public class QuanLiDiem_Statement {
	final Connection conn= (new GetConnect()).getConnect("localhost", "Quan_li_truong_hoc", "phamquy481", "a0163763123");
	ArrayList<PhanMon_Model> arrPhanMon = new ArrayList<>();
	ArrayList<QuanLiDiem_Model> arrQuanLiDiem = new ArrayList<>();
	
	public ArrayList<PhanMon_Model> sellectPhanMon(String maLopHoc){
		arrPhanMon.clear();
		try {
			String sql = "select * from Phan_mon where Malop = " + "'" + maLopHoc + "'";
			Statement statement = conn.createStatement();
			ResultSet result=statement.executeQuery(sql);
			while(result.next())
			{
				String maLop = result.getString("Malop");
				String maMon = result.getString("Mamon");
				arrPhanMon.add(new PhanMon_Model(maLop, maMon));
			}
			} catch (Exception e) {
			e.printStackTrace();
			}
		return arrPhanMon;
	}
	
	public ArrayList<QuanLiDiem_Model> sellectAllDiem(){
		arrQuanLiDiem.clear();
		try {
			String sql = "select * from Diem ";
			Statement statement = conn.createStatement();
			ResultSet result=statement.executeQuery(sql);
			while(result.next())
			{
				String maSv = result.getString("Masv");
				String maMon = result.getString("Mamon");
				String diem = result.getString("Diem");
				arrQuanLiDiem.add(new QuanLiDiem_Model(maSv, maMon, diem));
			}
			} catch (Exception e) {
			e.printStackTrace();
			}
		return arrQuanLiDiem;
	}
	
	public void insertDiem(String maSv, String maMon, String diem) {
		try {
			String sql = "insert into Diem values('"+0+"','"+maSv+"', '"+maMon+"', '"+diem+"')";
			Statement statement = conn.createStatement();
			int x=statement.executeUpdate(sql);
			if(x>0) {
				JOptionPane.showMessageDialog(null, "Nhập điểm thành công!");

			}
		}
			catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void updateDiem(String maSv, String maMon, String diem) {
		try
		{
			String sql="update Diem set Diem='" + diem + "' where Mamon='" + maMon+ "'and Masv='" + maSv + "'";
			Statement statement = conn.createStatement();
			int y=statement.executeUpdate(sql);
			if(y>0){
				JOptionPane.showMessageDialog(null, "Sửa điểm thành công!");
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void deleteDiem(String maSv) {
		try
		{
			String sql="delete from Diem where Masv='" + maSv + "'";
			Statement statement=conn.createStatement();
			int x=statement.executeUpdate(sql);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
