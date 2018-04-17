package hinhhoc;

public class hinhtron extends hinhhoc {	
	private double banKinh;
	public hinhtron() {
		
	}
	public hinhtron(double banKinh) {
		this.banKinh=banKinh;
	}
	public double getBanKinh() {
		return banKinh;
	}
	
	public void setBanKinh(double banKinh) {
		this.banKinh = banKinh;
	}
	
	public double getChuVi() {
		return 2*3.14*banKinh;		
	}
	
	public double getDienTich() {
		return 3.14*banKinh*banKinh;		
	}
}