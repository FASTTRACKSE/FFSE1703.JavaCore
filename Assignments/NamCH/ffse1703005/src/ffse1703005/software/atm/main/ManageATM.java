package ffse1703005.software.atm.main;

import ffse1703005.software.atm.ui.MainLayout;
import ffse1703005.software.atm.model.*;
public class ManageATM {
	/*hàm chính khi run-time sẽ gọi JFrame của ui đã dựng*/
	public static void main(String[] args) {
		/*sét title cho Main layout*/
		MainLayout myUI = new MainLayout("TP Bank - Vì Chúng Tôi Hiểu Bạn.");
		/*show JFrame chính*/
		myUI.showWindow();
		/*kết nối với database*/
		ConnectDB conn=new ConnectDB();			
		if(conn.getConnect("localhost", "ffse1703005", "hainam", "123456")!=null)
		{
		System.out.println("Kết nối MYSQL thành công");
		}
		else
		{
		System.out.println("Kết nối MYSQL thất bại");
		}
		
	}
	

}
