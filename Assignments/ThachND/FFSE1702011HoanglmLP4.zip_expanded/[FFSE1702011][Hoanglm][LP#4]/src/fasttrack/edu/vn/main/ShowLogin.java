package fasttrack.edu.vn.main;
import fasttrack.edu.vn.connection.ConnectSql;
import fasttrack.edu.vn.ui.LoginUI;
import java.sql.*;

public class ShowLogin {
	static Connection conn = ConnectSql.getConnect("localhost", "ffse1702011", "ffse1702011", "123456");
	public static void main(String[] args) {
		LoginUI giaodien = new LoginUI("Chương trình quản lý tiền điện");
		giaodien.showWindow();
	}
}
