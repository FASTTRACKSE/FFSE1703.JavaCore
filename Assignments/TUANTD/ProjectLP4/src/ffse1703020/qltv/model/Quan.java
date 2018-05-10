package ffse1703020.qltv.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class Quan {

	public static ArrayList<String> getList(String tinh) {
		Connection conn=(Connection) ConnectDB.getConnect();
		String sql="select * from gsovn_quanhuyen inner join gsovn_tinhthanhpho where gsovn_tinhthanhpho.matp=gsovn_quanhuyen.matp and gsovn_tinhthanhpho.name=?";
		ArrayList<String> arr=new ArrayList<>();
		try {
			PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
			ptmt.setString(1,tinh);
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