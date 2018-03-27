package fasttrack.edu.vn.practices;

public class QLSinhViên {
	private String namesv;
	private String ngaysinhsv;
	private float LP1;
	private float LP2;
	private float LP3;
	public QLSinhViên() {
		
	}
	public QLSinhViên(String namesv,String ngaysinhsv,float LP1,float LP2,float LP3) {
		super();
		this.namesv=namesv;
		this.ngaysinhsv=ngaysinhsv;
		this.LP1= LP1;
		this.LP2= LP2;
		this.LP3= LP3;		
	}
	public String getNamesv() {
		return this.namesv;
	}
	public void setNamesv(String namesv) {
		this.namesv=namesv;
	}
	public String getNgaysinhsv() {
		return this.ngaysinhsv;
	}
	public void setNgaysinhsv(String ngaysinhsv) {
		this.ngaysinhsv=ngaysinhsv;
	}
	public float getLP1() {
		return  this.LP1;
	}
	public void setLP1(float  LP1) {
		this.LP1=LP1;		
	}
	public float getLP2() {
		return  this.LP2;
	}
	public void setLP2(float LP2) {
		this.LP2=LP2;
	}
	public float getLP3() {
		return  this.LP3;
	}
	public void setLP3(float  LP3) {
		this.LP3=LP3;		
	}
	public float getDiemTB() {
		return ((getLP1() + getLP2() + getLP3())/3);
	}
	public String getXepLoai() {		 
    	if(getDiemTB()<=4.9) {
    		return "Yếu";}
    	else if(getDiemTB()>=5.0 && getDiemTB()<=6.9) {
    		return "Trung Bình";}
    	else if(getDiemTB()>=7 && getDiemTB()<=8) {
    		return "Khá";}
    	else {
    		return "Giỏi";
    	}
    }	
}
