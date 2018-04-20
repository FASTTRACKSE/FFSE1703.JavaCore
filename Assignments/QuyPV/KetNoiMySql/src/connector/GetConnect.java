package connector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.swing.JOptionPane;

import org.gjt.mm.mysql.Driver;

import com.mysql.jdbc.Connection;

public class GetConnect {
	private static Connection conn= getConnect("localhost","FFSE1703010", "admin",
			"123456");
	public static void main(String[] args) {
		
				if(conn!=null)
				{
				System.out.println("Kết nối MYSQL thành công");
				}
				else
				{
				System.out.println("Kết nối MYSQL thất bại");
				}
				
				GetConnect a = new GetConnect();
				//a.insert();
				//a.select();
				//a.update();
				a.delete();

	}
	public static Connection getConnect(String strServer,String strDatabase,
			String strUser,String strPwd)
			{
				Connection conn=null;
				String strConnect="jdbc:mysql://"+strServer+"/"+strDatabase;
				Properties pro=new Properties();
				pro.put("user", strUser);
				pro.put("password", strPwd);
				try
				{
					com.mysql.jdbc.Driver driver=new Driver();
					conn=(Connection) driver.connect(strConnect, pro);
				}
					catch(SQLException ex)
				{
					ex.printStackTrace();
				}
				return conn;
			}
	
	public void insert() {
		String a = "quý";
		try
		{
			
			String sql="insert into QuanLiSinhVien values('" + 4 + "','" + 2 + "','" + 3 + "','" + 4 + "')";
			System.out.println(sql);
			Statement statement=conn.createStatement();
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
	
	
	public void select() {
		try {
			Statement statement=conn.createStatement();
			ResultSet result=statement.executeQuery("select * from QuanLiSinhVien");
			while(result.next())
			{
			System.out.println(result.getString("maSV") + result.getString("Ten"));
			}
			} catch (Exception e) {
			e.printStackTrace();
			}
	}
	
	public void update() {
		try
		{
		String sql="update QuanLiSinhVien set Ten='" + "Phạm Quý" + "'where maSV='" + 4 +"'";
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
	
	public void delete() {
		try
		{
		String sql="delete from QuanLiSinhVien where maSV='" + 7 + "'";
		Statement statement=conn.createStatement();
		int x=statement.executeUpdate(sql);
		if(x>0)
		{
		JOptionPane.showMessageDialog(null, "Xóa OK");
		}
		}
		catch(Exception ex)
		{
		ex.printStackTrace();
		}
	}
}
