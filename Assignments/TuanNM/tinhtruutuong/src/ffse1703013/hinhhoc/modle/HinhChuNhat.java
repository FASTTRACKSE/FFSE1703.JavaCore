package ffse1703013.hinhhoc.modle;

public class HinhChuNhat extends HinhHoc {
	private Double chieuDai;
	private Double chieuRong;
	private String ten;
	
	public HinhChuNhat() {
		
	}
	public HinhChuNhat(String ten,Double chieuDai,Double chieuRong) {
		this.ten = ten;
		this.chieuRong = chieuRong;
		this.chieuDai= chieuDai;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public Double getChieuDai() {
		return chieuDai;
	}
	public void setChieuDai(Double chieuDai) {
		this.chieuDai = chieuDai;
	}


	public Double getChieuRong() {
		return chieuRong;
	}


	public void setChieuRong(Double chieuRong) {
		this.chieuRong = chieuRong;
	}


	public Double getChuVi() {
		return (this.chieuRong+this.chieuDai)*2.0;
		
	}


	@Override
	public Double getDienTich() {
		// TODO Auto-generated method stub
		return this.chieuDai*this.chieuRong;
	}
}
