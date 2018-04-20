package Assignment_11.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.JOptionPane;

import org.gjt.mm.mysql.Driver;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import Assignment_11.ui.*;

public class GetConnectSQL {
	final static Connection conn= getConnect("localhost", "ffse1703014", "admin","123456");
//	public static void main(String[] args) {
//		Connection conn= getConnect("localhost", "ffse1703014", "admin","123456");
//		if(conn!=null)
//		{
//		System.out.println("Kết nối MYSQL thành công");
//		}
//		else
//		{
//		System.out.println("Kết nối MYSQL thất bại");
//		}
//		getSV();
//	}
	public static void getSV() {
		try {
			Statement statement = (Statement) conn.createStatement();
			ResultSet result=statement.executeQuery
			("select * from sinhvien");
			while(result.next())
			{
			System.out.println(result.getString("MaSV"));
			System.out.println(result.getString("TenSV"));
			System.out.println(result.getString("TuoiSV"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void getSV(String lopSV) {
		try {
			Statement statement = (Statement) conn.createStatement();
			ResultSet result=statement.executeQuery
			("select * from sinhvien where LopSV = '"+lopSV+"'");
			while(result.next())
			{
			System.out.println(result.getString("MaSV"));
			System.out.println(result.getString("TenSV"));
			System.out.println(result.getString("TuoiSV"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void themSV() {
		try {
			Statement statement = (Statement) conn.createStatement();
			ResultSet result=statement.executeQuery ("select * from sinhvien where LopSV = '"+lopSV+"' and MaSV ='"+maSV+"'");
			if (result.next() == true) {
				JOptionPane.showMessageDialog(null, "Thông tin sinh viên đã tồn tại!");
			} else {
				try {
					String sql="insert into sinhvien value('"+lopSV+"','"+maSV+"','"+tenSV+"','"+tuoiSV+"')";
					Statement statements=(Statement) conn.createStatement();
					int y=statements.executeUpdate(sql);
					if(y>0)	{
						textMaSV.setText("");
						textTenSV.setText("");
						textTuoiSV.setText("");
						dm.addRow(new String[] {maSV,tenSV,tuoiSV});
						JOptionPane.showMessageDialog(null, "Nhập thông tin sinh viên thành công!");
					}
				} catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	public static void suaSV(String lopSV,String maSV,String tenSV,String tuoiSV) {
		try {
			String sql="update sinhvien set TenSV='"+tenSV+"',TuoiSV="+tuoiSV+" where MaSV='"+maSV+"' and LopSV = '"+lopSV+"'";
			Statement statement=(Statement) conn.createStatement();
			int x=statement.executeUpdate(sql);
			if(x>0) {
				JOptionPane.showMessageDialog(null, "Sửa thông tin sinh viên thành công!");
			} else {
				JOptionPane.showMessageDialog(null, "Sửa thông tin sinh viên thất bại!");
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	public static Connection getConnect(String strServer,String strDatabase,String strUser,String strPwd) {
		Connection conn=null;
		String strConnect="jdbc:mysql://"+strServer+"/"+strDatabase;
		Properties pro=new Properties();
		pro.put("user", strUser);
		pro.put("password", strPwd);
		try	{
			com.mysql.jdbc.Driver driver=new Driver();
			conn=(Connection) driver.connect(strConnect, pro);
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		return conn;
	}

}
