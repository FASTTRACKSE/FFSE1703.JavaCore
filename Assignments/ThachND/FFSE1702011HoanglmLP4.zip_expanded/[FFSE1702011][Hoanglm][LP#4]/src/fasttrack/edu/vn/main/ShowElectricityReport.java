package fasttrack.edu.vn.main;

import java.sql.Connection;
import java.sql.*;
import com.mysql.*;
import java.io.*;
import java.awt.*;
import fasttrack.edu.vn.connection.ConnectSql;
import fasttrack.edu.vn.ui.ElectricityReportUI;

public class ShowElectricityReport {
	static Connection conn = ConnectSql.getConnect("localhost", "ffse1702011", "ffse1702011", "123456");
	public static void main(String[] args) {
		ElectricityReportUI giaodien = new ElectricityReportUI("Chương trình quản lý tiền điện");
		giaodien.showWindow();
	}

}
