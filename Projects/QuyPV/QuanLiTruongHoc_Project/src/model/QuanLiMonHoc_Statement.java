package model;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import connector.GetConnect;

public class QuanLiMonHoc_Statement {
	final Connection conn= (new GetConnect()).getConnect("localhost", "Quan_li_truong_hoc", "phamquy481", "a0163763123");
	ArrayList<QuanLiMonHoc_Model> arrMonHoc = new ArrayList<>();
	
	public ArrayList<QuanLiMonHoc_Model> sellectMonHoc(){
		arrMonHoc.clear();
		try {
			Statement statement = conn.createStatement();
			ResultSet result=statement.executeQuery("select * from Mon_hoc");
			while(result.next())
			{
				String maMon = result.getString("Mamon");
				String tenMon = result.getString("Tenmon");
				String tinChi = result.getString("Sotinchi");
				String thoiLuong = result.getString("Thoiluong");
				arrMonHoc.add(new QuanLiMonHoc_Model(maMon, tenMon, tinChi, thoiLuong));
			}
			} catch (Exception e) {
			e.printStackTrace();
			}
		return arrMonHoc;
	}
	
	public void insertMonHoc(String maMon, String tenMon, String soTinChi, String thoiLuong) {
		try {
			String sql = "insert into Mon_hoc values('"+0+"','"+maMon+"', '"+tenMon+"', '"+soTinChi+"','"+thoiLuong+" giờ"+"')";
			Statement statement = conn.createStatement();
			int x=statement.executeUpdate(sql);
			if(x>0) {
				JOptionPane.showMessageDialog(null, "Thêm môn học thành công!");

			}
		}
			catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void updateMonHoc(String maMon, String tenMon, String soTinChi, String thoiLuong  ) {
		try
		{
			String sql="update Mon_hoc set Tenmon='" + tenMon + "', SoTinChi='"+ soTinChi +  "', Thoiluong='" + thoiLuong + " giờ" + "' where Mamon='" + maMon +"'";
			Statement statement = conn.createStatement();
			int y=statement.executeUpdate(sql);
			if(y>0){
				JOptionPane.showMessageDialog(null, "Sửa môn học thành công!");
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void deleteMonHoc(String maMon) {
		try
		{
			String sql="delete from Mon_hoc where Mamon='" + maMon + "'";
			Statement statement=conn.createStatement();
			int x=statement.executeUpdate(sql);
			if(x>0){
				JOptionPane.showMessageDialog(null, "Xóa môn học thành công!");
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}

	
