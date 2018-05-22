package model;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import connector.*;

public class TinhThanh_Statement {
	final Connection conn= (new GetConnect()).getConnect("localhost", "Quan_li_truong_hoc", "phamquy481", "a0163763123");
	ArrayList<TinhThanh> arrTinhThanh = new ArrayList<>();
	
	public ArrayList<TinhThanh> selectAll() {
		try {
			//ps = (PreparedStatement) conn.prepareStatement("select * from Tinh_thanh");
			//ResultSet result = ps.executeQuery();
			String sql = "select * from Tinh_thanh";
			Statement statement=conn.createStatement();
			ResultSet result=statement.executeQuery(sql);
			while (result.next()) {
				String provinceId = result.getString("provinceid");
				String name = result.getString("name");
				arrTinhThanh.add(new TinhThanh(provinceId, name));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrTinhThanh;
	}

}
