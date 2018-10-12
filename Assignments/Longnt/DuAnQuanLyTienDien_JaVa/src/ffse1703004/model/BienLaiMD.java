package ffse1703004.model;

import java.util.Date;

public class BienLaiMD extends KhachHangMD {
	Date dateAdded;
	int month;
	int year;
	int meterNumber;
	
	public BienLaiMD() {
		super();
	}
    public BienLaiMD(Date dateAdded, int month, int year, int meternumber) {
    	super();
    	this.dateAdded = dateAdded;
    	this.month = month;
    	this.year = year;
    	this.meterNumber = meternumber;
    }
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