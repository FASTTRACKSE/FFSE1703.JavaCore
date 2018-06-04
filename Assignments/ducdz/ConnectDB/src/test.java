import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.swing.JOptionPane;

import org.gjt.mm.mysql.Driver;

public class test {
	public static void main(String[] args) {
		Connection conn= getConnect("localhost", "test", "test",
				"123");
				if(conn!=null)
				{
				System.out.println("Kết nối MYSQL thành công");
				}
				else
				{
				System.out.println("Kết nối MYSQL thất bại");
				}
				try {
					String sql = "UPDATE `test` set `test2` = 'da sua roi' where `id` = 2";
					Statement statement = conn.createStatement();
					int x = statement.executeUpdate(sql);
					if(x>0) {
						JOptionPane.showMessageDialog(null,"xoa thanh cong!");
					}
				}
				catch(Exception e) {
					e.printStackTrace();
				}
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
			conn=driver.connect(strConnect, pro);
			}
			catch(SQLException ex)
			{
			ex.printStackTrace();
			}
			return conn;
			}
}
