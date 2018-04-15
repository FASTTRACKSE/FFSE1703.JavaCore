package hinhhoc;

public class hinhchunhat extends hinhhoc{
	private int chieuDai;
	private int chieuRong;
	public hinhchunhat() {
		
	}
	
	public hinhchunhat(int chieuDai,int chieuRong) {
		this.chieuDai=chieuDai;
		this.chieuRong=chieuRong;
	}
	public int getChieuDai() {
		return chieuDai;
	}

	public void setChieuDai(int chieuDai) {
		this.chieuDai = chieuDai;
	}

	public int getChieuRong() {
		return chieuRong;
	}

	public void setChieuRong(int chieuRong) {
		this.chieuRong = chieuRong;
	}

	public double getChuVi() {		
		return (chieuDai + chieuRong)*2;
	}

	public double getDienTich() {
		return (chieuDai * chieuRong);
	}

}