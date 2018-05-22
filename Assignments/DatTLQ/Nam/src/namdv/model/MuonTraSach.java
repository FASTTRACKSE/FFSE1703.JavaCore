package namdv.model;

public class MuonTraSach {
	private String maMuonTra, maBanDoc, maSachMuon, ngayMuon, ngayTra;

	public MuonTraSach() {
		super();
	}

	public MuonTraSach(String maMuonTra, String maBanDoc, String maSachMuon) {
		super();
		this.maBanDoc = maBanDoc;
		this.maSachMuon = maSachMuon;
		this.maMuonTra = maMuonTra;
	}

	public String getMaMuonTra() {
		return maMuonTra;
	}

	public void setMaMuonTra(String maMuonTra) {
		this.maMuonTra = maMuonTra;
	}

	public String getMaBanDoc() {
		return maBanDoc;
	}

	public void setMaBanDoc(String maBanDoc) {
		this.maBanDoc = maBanDoc;
	}

	public String getNgayMuon() {
		return ngayMuon;
	}

	public void setNgayMuon(String ngayMuon) {
		this.ngayMuon = ngayMuon;
	}

	public String getMaSachMuon() {
		return maSachMuon;
	}

	public void setMaSachMuon(String maSachMuon) {
		this.maSachMuon = maSachMuon;
	}

	public String getNgayTra() {
		return ngayTra;
	}

	public void setNgayTra(String ngayTra) {
		this.ngayTra = ngayTra;
	}

}