package ffse1703020.qltv.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class Phuong {
	public static ArrayList<String> getList(String quan) {
	Connection conn=(Connection) ConnectDB.getConnect();
	String sql="select * from gsovn_xaphuongthitran inner join gsovn_quanhuyen where gsovn_quanhuyen.maqh=gsovn_xaphuongthitran.maqh and gsovn_quanhuyen.name=?";
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
