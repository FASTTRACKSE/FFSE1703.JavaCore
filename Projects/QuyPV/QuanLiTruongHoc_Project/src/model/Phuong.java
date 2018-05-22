package model;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import connector.GetConnect;

public class Phuong {
	private String name;
	private PreparedStatement ps;
	
	public Phuong() {
		//
	}
	
	public Phuong(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	
	@Override
	public String toString() {
		return this.name;
	}
	
	
}
