package Assignment_list.assignment10.model;
import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

import java.sql.ResultSet;
import java.sql.Statement;
import Assignment_list.assignment10.model.*;
import java.util.ArrayList;
public class StatementDb {
	GetDatabase myDB = new GetDatabase();
	Connection conn= myDB.getConnect("localhost", "sinhvien", "root", "12345");
	ArrayList<SinhVien> arrSv=new ArrayList<SinhVien>();
	public void insertDb(String maSv,String tenSv,String tuoiSv,String lopSv) {
		try
		{
		String sql="insert into danhsachsv(code,name,age,class) values("
		+ "'" + maSv + "','"+tenSv+"','"
		+tuoiSv+ "','"+lopSv+"'"+")";
		java.sql.Statement statement=conn.createStatement();
		int x=statement.executeUpdate(sql);
		if(x>0)
		{
		JOptionPane.showMessageDialog(null, "Lưu OK");
		}
		}
		catch(Exception ex){
		ex.printStackTrace();
		}
	}
	public ArrayList<SinhVien> SeclectDb() {
//		ArrayList<SinhVien> arrSv=new ArrayList<SinhVien>();
		try {
			
			Statement statement=conn.createStatement();
			ResultSet result=statement.executeQuery
			("select * from danhsachsv");
			while(result.next())
			{
				
				arrSv.add(new SinhVien(result.getString("code"),result.getString("name")
						,result.getString("age"),result.getString("class")));
			}
			} catch (Exception e) {
			e.printStackTrace();
			}
		return arrSv;
	}
	public void editDb(String maSv,String tenSv,String tuoiSv) {
		try
		{
			String sql="UPDATE danhsachsv SET name='"+tenSv+"',age='"+tuoiSv+"' where code='"+maSv+"'";
			Statement statement=conn.createStatement();
			int x=statement.executeUpdate(sql);
			if(x>0)
			{
			JOptionPane.showMessageDialog(null, "Cập nhật OK");
			}
			}
		catch(Exception ex)
		{
		ex.printStackTrace();
		}
	}
	public void deleteDb(String maSv) {
		try
		{
		String sql="DELETE from danhsachsv WHERE code='"+maSv+"' " ;
		Statement statement=conn.createStatement();
		int x=statement.executeUpdate(sql);
		if(x>0)
		{
		JOptionPane.showMessageDialog(null,
		"Xóa OK");
		}
		}
		catch(Exception ex)
		{
		ex.printStackTrace();
		}
	}
}
