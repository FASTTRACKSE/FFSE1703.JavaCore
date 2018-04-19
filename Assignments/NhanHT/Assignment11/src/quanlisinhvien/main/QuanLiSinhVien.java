package quanlisinhvien.main;
import com.mysql.jdbc.Connection;
import quanlisinhvien.connect.*;
import quanlisinhvien.ui.*;
public class QuanLiSinhVien {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuanLi myUI = new QuanLi("Quan Li Sinh Vien");
		myUI.showWindow();
		Connection conn= GetConnect.getConnect("localhost", "admin", "admin","admin");
		if(conn!=null)
		{
		System.out.println("Kết nối MYSQL thành công");
		}
		else
		{
		System.out.println("Kết nối MYSQL thất bại");
		}
	}



}	
