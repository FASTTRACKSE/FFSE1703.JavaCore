package model;

public class DistrictModel {
	private String districtid,name ;
	

	public DistrictModel() {
		// TODO Auto-generated constructor stub
	}
	public DistrictModel(String districtid,String name) {
		this.districtid = districtid;
		this.name = name;
	}
	public String getDistrictid() {
		return districtid;
	}
	public void setDistrictid(String districtid) {
		this.districtid = districtid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String toString () {
		return this.name;
	}
}
