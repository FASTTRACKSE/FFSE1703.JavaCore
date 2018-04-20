package topica.edu.vn.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import topica.edu.vn.model.DangNhap;

public class DangNhapService extends OracleService {
	public DangNhap login(String user,String pass)
	{
		DangNhap account=null;
		try
		{
			String sql="select * from DangNhap where username=? and password=?";
			PreparedStatement preStatement=conn.prepareStatement(sql);
			preStatement.setString(1, user);
			preStatement.setString(2, pass);
			ResultSet result=preStatement.executeQuery();
			if(result.next())
			{
				account=new DangNhap();
				account.setUserName(result.getString(1));
				account.setPassword(result.getString(2));
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return account;
	}
}
