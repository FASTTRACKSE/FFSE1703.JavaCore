package ffse1703005.software.atm.model;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;



public class StamentAdress {
	ConnectDB myDB = new ConnectDB();
	Connection conn= myDB.getConnect("localhost", "ffse1703005", "hainam", "123456");
	ArrayList<Adress> Adress=new ArrayList<Adress>();
	
	public ArrayList<String> SeclectDis() {
		ArrayList<String> arrDistricts=new ArrayList<String>();
		try {
			
			Statement statement=conn.createStatement();
			ResultSet result=statement.executeQuery
			("select * from atm_districts");
			while(result.next())
			{
				
				arrDistricts.add(result.getString("name"));
			}
			} catch (Exception e) {
			e.printStackTrace();
			}
		return arrDistricts;
	}
	public ArrayList<String> SeclectWard(int key) {
		ArrayList<String> arrWards=new ArrayList<String>();
		try {
			
			Statement statement=conn.createStatement();
			ResultSet result=statement.executeQuery
			("select * from atm_wards where code_districts = '"+key+"'");
			while(result.next())
			{
				
				arrWards.add(result.getString("name"));
			}
			} catch (Exception e) {
			e.printStackTrace();
			}
		return arrWards;
	}
	
	
	
	public int SeclectIdWards(String name) {
		int idWards=0;
		try {
			
			Statement statement=conn.createStatement();
			ResultSet result=statement.executeQuery
			("select * from atm_wards where name = '"+name+"'");
			while(result.next())
			{
				
				idWards=result.getInt("code_Wards");
			}
			} catch (Exception e) {
			e.printStackTrace();
			}
		return idWards;
	}
	
	public String SeclectStringWards(int keyWards) {
		String nameWards=null;
		try {
			
			Statement statement=conn.createStatement();
			ResultSet result=statement.executeQuery
			("select * from atm_wards where code_wards = '"+keyWards+"'");
			while(result.next())
			{
				
				nameWards=result.getString("name");
			}
			} catch (Exception e) {
			e.printStackTrace();
			}
		return nameWards;
	}
	
	public String SeclectStringDistricts(int keyDistricts) {
		String nameDistricts=null;
		try {
			
			Statement statement=conn.createStatement();
			ResultSet result=statement.executeQuery
			("select * from atm_districts where code_districts = '"+keyDistricts+"'");
			while(result.next())
			{
				
				nameDistricts=result.getString("name");
			}
			} catch (Exception e) {
			e.printStackTrace();
			}
		return nameDistricts;
	}
}
