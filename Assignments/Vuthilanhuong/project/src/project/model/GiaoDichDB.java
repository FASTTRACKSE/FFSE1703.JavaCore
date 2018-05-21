package project.model;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class GiaoDichDB {
	static ConnectDB myDb = new ConnectDB();
	static Connection conn = myDb.getConnect("localhost", "ffse1703001", "huong", "12345");
	public ArrayList<GiaoDich> timTheoDiaChi(String duong,String quan, String phuong){
		ArrayList<GiaoDich> arrKH=new ArrayList<GiaoDich>();
		try {
			String sql ="select * from atm_giaodich where quan LIKE ? AND phuong LIKE ? AND duong LIKE ? ";
			PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
			preparedStatement.setString(1, "%" + quan + "%");
			preparedStatement.setString(2, "%" + phuong + "%");
			preparedStatement.setString(3, "%" + duong + "%");
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next())
			{
				GiaoDich kh = new GiaoDich();
				kh.setMaATM(rs.getString("ma_kh"));
				arrKH.add(kh);
			}
			} catch (Exception e) {
			e.printStackTrace();
			}
		return arrKH;
	}
}

