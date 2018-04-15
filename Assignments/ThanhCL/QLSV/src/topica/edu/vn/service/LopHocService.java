package topica.edu.vn.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import topica.edu.vn.model.LopHoc;

public class LopHocService extends OracleService {
	public int luuLopMoi(LopHoc lop)
	{
		try
		{
			String sql="insert into lophoc values(?,?)";
			PreparedStatement preStatement=conn.prepareStatement(sql);
			preStatement.setString(1, lop.getMaLop());
			preStatement.setString(2, lop.getTenLop());
			return preStatement.executeUpdate();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return -1;
	}
	public ArrayList<LopHoc>layToanBoLop()
	{
		ArrayList<LopHoc> ds=new ArrayList<LopHoc>();
		try
		{
			String sql="select * from lophoc";
			PreparedStatement preStatement=conn.prepareStatement(sql);
			ResultSet result=preStatement.executeQuery();
			while(result.next())
			{
				LopHoc lop=new LopHoc();
				lop.setMaLop(result.getString(1));
				lop.setTenLop(result.getString(2));
				ds.add(lop);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return ds;
	}
}
