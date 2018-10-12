package ffse1703004.model;
import ffse1703004.model.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

public class Quan {
	public static ArrayList<String> getList() {
		DBConnection DBConnection = new DBConnection();
		@SuppressWarnings("static-access")
		Connection conn= DBConnection.ketnoi("localhost", "ffse1703004_java", "thanhlong123",
				"123456");
		String sql="select * from Quan";
		ArrayList<String> arr=new ArrayList<>();
		try {
			PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs=ptmt.executeQuery();
			
			while(rs.next()){
				arr.add(rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arr;
}
}
