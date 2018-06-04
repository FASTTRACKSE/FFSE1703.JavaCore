package ffse1703005.software.atm.model;

public class Adress {
	private int key;
	private String value;
	public Adress() {
		
	}
	public Adress(int key,String value) {
		this.key = key;
		this.value = value;
	}	
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
