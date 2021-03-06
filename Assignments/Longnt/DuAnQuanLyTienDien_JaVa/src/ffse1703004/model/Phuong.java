package ffse1703004.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

public class Phuong {
	public static ArrayList<String> getList(String quan) {
		DBConnection DBConnection = new DBConnection();
		@SuppressWarnings("static-access")
		Connection conn= DBConnection.ketnoi("localhost", "ffse1703004_java", "root",
				"");
		String sql="select * from Phuong inner join Quan where Quan.id = Phuong.idquan and Phuong.tenphuong=? ";
		ArrayList<String> arr=new ArrayList<>();
		try {
			PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
			
			ptmt.setString(1,quan);
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