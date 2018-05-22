package ffse1703013.atm.main;

import java.sql.Connection;
import ffse1703013.atm.model.*;
import ffse1703013.atm.layout.LayoutLogin;

public class QuanLiATM {
	public static void main(String[] args) {
		LayoutLogin myLayout = new LayoutLogin("TP BANK");
		myLayout.showWindow();
		Connection conn = ConnectDatabase.getConnect("localhost", "FFSE1703013_ATM", "tuan18081999", "tuan123");
		if (conn != null) {
		} else {
			System.out.println("Kết nối MYSQL thất bại");
		}
	}
}
