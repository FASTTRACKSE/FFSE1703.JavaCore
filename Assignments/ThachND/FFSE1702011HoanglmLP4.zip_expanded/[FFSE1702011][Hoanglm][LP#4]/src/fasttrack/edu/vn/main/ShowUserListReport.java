package fasttrack.edu.vn.main;

import fasttrack.edu.vn.ui.UserListReportUI;
import java.sql.*;
import com.mysql.*;

import fasttrack.edu.vn.connection.ConnectSql;

import java.io.*;

public class ShowUserListReport {
	static Connection conn = ConnectSql.getConnect("localhost", "ffse1702011", "ffse1702011", "123456");
	public static void main(String[] args) {
		UserListReportUI giaodien = new UserListReportUI("Chương trình quản lý tiền điện");
		giaodien.showWindow();
	}
}
