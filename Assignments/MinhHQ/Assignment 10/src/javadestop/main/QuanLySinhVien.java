package javadestop.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javadestop.ui.QuanLySinhVienUI;

public class QuanLySinhVien {
	public static void main(String[] args) {
		QuanLySinhVienUI myUI = new QuanLySinhVienUI("Quản Lý Sinh Viên");
		myUI.showWindow();
		
	}
}
