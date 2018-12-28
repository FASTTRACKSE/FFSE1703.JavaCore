package ffse1703004.main;

import java.sql.Connection;

import ffse1703004.model.DBConnection;
import ffse1703004.ui.Login;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Login venue = new Login("QUẢN LÝ TIỀN ĐIỆN");
		venue.showWindow();
		Connection conn= DBConnection.ketnoi("localhost", "ffse1703004_java", "root",
				"");
					if(conn!=null)
					{
					System.out.println("Kết nối MYSQL thành công");
					}
					
					else
					{
					System.out.println("Kết nối MYSQL thất bại");
					}

		}
	}


