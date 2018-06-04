package fasttrack.edu.vn.main;
import java.sql.Connection;
import java.sql.*;
import com.mysql.*;
import java.io.*;
import java.awt.*;
import fasttrack.edu.vn.connection.ConnectSql;
import fasttrack.edu.vn.ui.BillsManagementUI;
public class ShowBillsManagement {
	static Connection conn = ConnectSql.getConnect("localhost", "ffse1702011", "ffse1702011", "123456");
	public static void main(String[] args) {
		BillsManagementUI giaodien = new BillsManagementUI("Chương trình quản lý tiền điện");
		giaodien.showWindow();
	}

}
