package ass10.java.main;
import com.mysql.jdbc.Connection;

import ass10.java.connect.Connect;
import ass10.java.ui.QuanLi;
public class QuanLiSV {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		QuanLi myUI= new QuanLi("Quản Lí Sinh Viên");
		myUI.showWindow();
		Connection conn= Connect.getConnect("localhost", "Java", "ttien96","zxcv1234");
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
