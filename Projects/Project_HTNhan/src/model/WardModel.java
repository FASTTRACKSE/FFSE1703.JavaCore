package model;


public class WardModel {
	private String name;
	
	public WardModel() {
	}
	public WardModel(String name) {
		this.name = name;
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
