package fasttrack.edu.vn.main;
import java.sql.Connection;
import java.sql.*;
import com.mysql.*;
import java.io.*;
import fasttrack.edu.vn.connection.ConnectSql;
import fasttrack.edu.vn.ui.MenuUI;
public class ShowMenu {
	static Connection conn = ConnectSql.getConnect("localhost", "ffse1702011", "ffse1702011", "123456");
	public static void main(String[] args) {
		MenuUI giaodien = new MenuUI("Chương trình quản lý tiền điện");
		giaodien.showWindow();
	}
}
