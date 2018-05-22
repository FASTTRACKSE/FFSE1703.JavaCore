package assignment11.java.connect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

import assignment11.java.model.SinhVien;

public class ConnectDb {
	final Connection conn = Connect.getConnect("localhost", "Java", "tuan18081999", "tuan123");
	ArrayList<SinhVien> arrSv= new ArrayList<SinhVien>();
	public ArrayList<SinhVien> selectSinhVien(){
		try {

			Statement statement = (Statement) conn.createStatement();
			ResultSet rs = statement.executeQuery("select * from ConnectSQL");
			while (rs.next()) {
				String id = rs.getString("maSV");
				String name = rs.getString("tenSV");
				String age = rs.getString("tuoiSV");
				String class1 = rs.getString("lopSV");
				arrSv.add(new SinhVien(id, name, age, class1));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrSv;
		
	}
	public void insertSinhVien(String maSinhVien,String tenSV,String tuoi,String lop) {
		try
		{
		String sql="insert into ConnectSQL values('"+maSinhVien+"','"+tenSV+"','"+tuoi+"','"+lop+"')";
		Statement statement= (Statement) conn.createStatement();
		int x=statement.executeUpdate(sql);
		if(x>0)
		{
		JOptionPane.showMessageDialog(null, "Lưu thành công\n╚(•⌂•)╝ (-’๏_๏’-) Ƹ̴Ӂ̴Ʒ εїз");
		}
		}
		catch(Exception ex){
		ex.printStackTrace();
		}
	}
	public void updateSinhVien(String maSinhVien,String tenSV,String tuoi) {
		try
		{
		
		String sql="UPDATE ConnectSQL SET tenSV="+tenSV+",tuoiSV="+tuoi+" where maSV="+maSinhVien+"";
		Statement statement=(Statement)conn.createStatement();
		int x=statement.executeUpdate(sql);
		if(x>0)
		{
		JOptionPane.showMessageDialog(null, "Cập nhật thành công <3<3<3 \n (✖╭╮✖) ⊙︿⊙ ⊙﹏⊙ ●︿● ●﹏●");
		}
		}
		catch(Exception ex)
		{
		ex.printStackTrace();
		}
	}
	public void deleteSinhVien(String maSv) {
		try
		{
		String sql="DELETE from connectSQL WHERE maSV='"+maSv+"' " ;
		Statement statement=(Statement) conn.createStatement();
		int x=statement.executeUpdate(sql);
		if(x>0)
		{
		JOptionPane.showMessageDialog(null,
		"Xóa thành công :)) \n ◖♪_♪|◗ •(⌚_⌚)• !⑈ˆ~ˆ!⑈ ⋋ō_ō` ‹(•¿•)›");
		}
		}
		catch(Exception ex)
		{
		ex.printStackTrace();
		}
		
	}
}
