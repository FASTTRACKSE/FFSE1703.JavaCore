package topica.edu.vn.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import topica.edu.vn.model.SinhVien;

public class SinhVienService extends OracleService {
	public int xoaSinhVien(SinhVien sv)
	{
		try
		{
			String sql="delete from sinhvien where ma=?";
			PreparedStatement preStatement=conn.prepareStatement(sql);
			preStatement.setString(1, sv.getMa());
			return preStatement.executeUpdate();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return -1;
	}
	public ArrayList<SinhVien>layToanBoSinhVienTheoMaLop(String malop)
	{
		ArrayList<SinhVien> ds=new ArrayList<SinhVien>();
		try
		{
			String sql="select * from sinhvien where malop=?";
			PreparedStatement preStatement=conn.prepareStatement(sql);
			preStatement.setString(1, malop);
			ResultSet result=preStatement.executeQuery();
			while(result.next())
			{
				SinhVien sv=new SinhVien();
				sv.setMa(result.getString(1));
				sv.setTen(result.getString(2));
				sv.setTuoi(result.getInt(3));
				sv.setMaLop(malop);
				ds.add(sv);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return ds;
	}
}
