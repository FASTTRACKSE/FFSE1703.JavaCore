package connector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.JOptionPane;

import org.gjt.mm.mysql.Driver;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class GetConnect {
	static Connection conn= getConnect("localhost", "FFSE1703008", "admin",
			"admin");


	public static void main(String[] args) {
		
				if(conn!=null)
				{
				System.out.println("Kết nối MYSQL thành công");
				}
				else
				{
				System.out.println("Kết nối MYSQL thất bại");
				}
				select();
				//insert();
				//delete();
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
	public static void select() {
		try {
			Statement statement = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = statement.executeQuery("select * from QLSinhVien");
			while(rs.next()){
			System.out.println(rs.getString("TenSv")+"  "+rs.getString("MaSv"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void insert() {
		try{
		String sql="insert into QLSinhVien values('"+3+"','"+"C"+"','"+1+"','"+1+"')";
		Statement statement=(Statement) conn.createStatement();
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
	public static void delete() {
		try{
		String sql="delete from QLSinhVien where MaSv='"+1+"'";
		Statement statement=(Statement) conn.createStatement();
		int x=statement.executeUpdate(sql);
		if(x>0){
		JOptionPane.showMessageDialog(null,"Xóa OK");
		}}
		catch(Exception ex)
		{
		ex.printStackTrace();
		}
	}
}
