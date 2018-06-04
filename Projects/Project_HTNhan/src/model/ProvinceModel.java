package model;

public class ProvinceModel {
	private String provinceid,name;
	public ProvinceModel() {
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
