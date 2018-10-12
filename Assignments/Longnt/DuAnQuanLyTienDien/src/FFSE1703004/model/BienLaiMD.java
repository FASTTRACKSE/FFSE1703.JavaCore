package FFSE1703004.model;

import java.util.Date;

public class BienLaiMD extends KhachHangMD {
	Date dateAdded;
	int month;
	int year;
	int meterNumber;
	
	public Date getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMeterNumber() {
		return meterNumber;
	}
	public void setMeterNumber(int meterNumber) {
		this.meterNumber = meterNumber;
	}


}