package ffse1703.qlsv.main;

import ffse1703.qlsv.ui.*;

import ffse1703.model.*;
import ffse1703.qlsv.oi.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import org.gjt.mm.mysql.Driver;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class SinhVien {
	public static void main(String[] args) {
		QuanLySinhVien myUI = new QuanLySinhVien("Quản Lý Sinh Viên");
		myUI.showWindow();

		Connection conn = getConnect("localhost", "ffse1703020", "ffse1703", "ffse1703@2018");
		if (conn != null) {
			System.out.println("Kếtnối MYSQL thànhcông");
			try{
				Statement statement=(Statement) conn.createStatement();
				ResultSet result=statement.executeQuery("select * from quanlysinhvien");
				while(result.next()){
					System.out.println(result.getString("Name"));
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Kếtnối MYSQL thấtbại");

		}
	}

	public static Connection getConnect(String strServer, String strDatabase, String strUser, String strPwd) {
		Connection conn = null;
		String strConnect="jdbc:mysql://"+strServer+"/"+strDatabase;
		Properties pro = new Properties();
		pro.put("user", strUser);
		pro.put("password", strPwd);
		try {
			com.mysql.jdbc.Driver driver = new Driver();
			conn = (Connection) driver.connect(strConnect, pro);

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return conn;
}
}