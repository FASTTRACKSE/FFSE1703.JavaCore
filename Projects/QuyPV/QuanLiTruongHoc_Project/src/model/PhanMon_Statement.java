package model;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

import connector.GetConnect;

public class PhanMon_Statement {
	final Connection conn= (new GetConnect()).getConnect("localhost", "Quan_li_truong_hoc", "phamquy481", "a0163763123");
	ArrayList<QuanLiMonHoc_Model> arrPhanMon = new ArrayList<>();
	ArrayList<PhanMon_Model> arrAllPhanMon = new ArrayList<>();
	
	public ArrayList<QuanLiMonHoc_Model> sellecPhanMon(String ma){
		arrPhanMon.clear();
		try {
			String sql = "select Mon_hoc.Tenmon, Phan_mon.Mamon from Mon_hoc left join Phan_mon on Mon_hoc.Mamon = Phan_mon.Mamon where Phan_mon.Malop =" + "'"+ ma +"'";
			Statement statement = conn.createStatement();
			ResultSet result=statement.executeQuery(sql);
			while(result.next())
			{
				String tenMon = result.getString("Mon_hoc.Tenmon");
				String maMon = result.getString("Phan_mon.Mamon");
				arrPhanMon.add(new QuanLiMonHoc_Model(tenMon, maMon));
			}
			} catch (Exception e) {
			e.printStackTrace();
			}
		return arrPhanMon;
	}
	
//	public ArrayList<PhanMon_Model> sellectAllPhanMon() {
//		arrAllPhanMon.clear();
//		try {
//			String sql = "select * from Phan_mon";
//			Statement statement = conn.createStatement();
//			ResultSet result=statement.executeQuery(sql);
//			while(result.next())
//			{
//				String maLop = result.getString("Malop");
//				String maMon = result.getString("Mamon");
//				arrAllPhanMon.add(new PhanMon_Model(maLop, maMon));
//			}
//			} catch (Exception e) {
//			e.printStackTrace();
//			}
//		 return arrAllPhanMon;
//	}
	
	public void insertPhanMon(String maLop, String maMon) {
		try {
			String sql = "insert into Phan_mon values('"+0+"','"+maLop+"', '"+maMon+"')";
			Statement statement = conn.createStatement();
			int x=statement.executeUpdate(sql);
	
		}
			catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void deletePhanMon(String maLop, String maMon) {
		try
		{
			String sql="delete from Phan_mon where Mamon='" + maMon + "'" + "and" + " Malop='" + maLop + "'";
			Statement statement=conn.createStatement();
			int x=statement.executeUpdate(sql);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void deleteLopPhanMon(String maLop) {
		try
		{
			String sql="delete from Phan_mon where Malop='" + maLop + "'";
			Statement statement=conn.createStatement();
			int x=statement.executeUpdate(sql);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
