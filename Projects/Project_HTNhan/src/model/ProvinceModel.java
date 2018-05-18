package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ProvinceModel {
	private String provinceid,name;
	public ProvinceModel() {
		// TODO Auto-generated constructor stub
	}
	public ProvinceModel(String provinceid,String name) {
		this.provinceid = provinceid;
		this.name = name;
	}
	public String getProvinceid() {
		return provinceid;
	}
	public void setProvinceid(String provinceid) {
		this.provinceid = provinceid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String toString() {
		return this.name;
	}
}
