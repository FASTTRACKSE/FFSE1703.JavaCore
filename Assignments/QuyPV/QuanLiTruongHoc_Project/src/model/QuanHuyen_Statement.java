package model;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import connector.GetConnect;

public class QuanHuyen_Statement {
	final Connection conn= (new GetConnect()).getConnect("localhost", "Quan_li_truong_hoc", "phamquy481", "a0163763123");
	ArrayList<QuanHuyen> arrQuanHuyen = new ArrayList<>();
	
	public ArrayList<QuanHuyen> selectQuanHuyen(String provinceId){
		arrQuanHuyen.clear();
		try {
			String sql = "select * from Quan_huyen where provinceid =" + "'"+ provinceId +"'";
			//Statement statement=conn.createStatement();
			Statement statement=conn.createStatement();
			ResultSet result=statement.executeQuery(sql);
//			ps = (PreparedStatement) conn.prepareStatement(sql);
//			ResultSet result=ps.executeQuery();
			while(result.next())
			{
				 String name = result.getString("name");
				 String districtId = result.getString("districtid");
				 arrQuanHuyen.add(new QuanHuyen(name, districtId));
				 //System.out.println(nameQuanHuyen);
			}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		return arrQuanHuyen;
	}
}
