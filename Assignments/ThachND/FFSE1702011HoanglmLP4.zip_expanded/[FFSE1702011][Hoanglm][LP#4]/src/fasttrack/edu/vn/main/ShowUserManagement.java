package fasttrack.edu.vn.main;
import fasttrack.edu.vn.connection.ConnectSql;
import fasttrack.edu.vn.ui.UserManagementUI;
import java.sql.*;
import com.mysql.*;
import java.io.*;
public class ShowUserManagement {
	static Connection conn = ConnectSql.getConnect("localhost", "ffse1702011", "ffse1702011", "123456");
	public static void main(String[] args) {
		UserManagementUI giaodien = new UserManagementUI("Chương trình quản lý tiền điện");
		giaodien.showWindow();
	}
}