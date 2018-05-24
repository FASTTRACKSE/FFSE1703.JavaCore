package project.model;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DiaChiDB {
	static ConnectDB myDb = new ConnectDB();
	@SuppressWarnings("static-access")
	Connection conn = myDb.getConnect("localhost", "ffse1703001", "huong", "12345");
	public ArrayList<String> hienThiQuan(){
		//select từ bảng atm_quan trên database sseer hiển thị quận
		ArrayList<String> arrQuan=new ArrayList<String>();
		try {
			
			Statement statement=(Statement) conn.createStatement();
			ResultSet result=statement.executeQuery
			("select * from atm_quan");
			while(result.next())
			{
				
				arrQuan.add(result.getString("name"));
			}
			} catch (Exception e) {
			e.printStackTrace();
			}
		return arrQuan;
		
	}
	//select từ bảng atm_phuong để hiển thị phường
	public ArrayList <String> hienThiPhuong(int key){
		ArrayList<String> arrPhuong=new ArrayList<String>();
		try {
			
			Statement statement=(Statement) conn.createStatement();
			ResultSet result=statement.executeQuery
			("select * from atm_phuong where code_districts= '"+key+"' ");
			while(result.next())
			{
				
				arrPhuong.add(result.getString("name"));
			}
			} catch (Exception e) {
			e.printStackTrace();
			}
		return arrPhuong;
}
}
