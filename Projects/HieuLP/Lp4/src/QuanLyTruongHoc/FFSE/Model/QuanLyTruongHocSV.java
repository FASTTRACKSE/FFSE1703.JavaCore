package QuanLyTruongHoc.FFSE.Model;

public class QuanLyTruongHocSV {
	private String MaSV;
	private String Ten;
	private String DiaChi;
	private String Phuong;
	private String Quan;
	private String TP;
	private String Lop;
	private String Email;
	private String DT;
	public QuanLyTruongHocSV( String MaSV, String Ten,  String lop,String DiaChi, String Phuong,
							  String Quan, String TP, String Email, String DT) {
		this.MaSV = MaSV;
		this.Ten = Ten;
		this.Lop = lop;
		this.DiaChi = DiaChi;
		this.Phuong = Phuong;
		this.Quan = Quan;
		this.TP = TP;
		this.Email = Email;
		this.DT = DT;
		
		}
		public String getMaSV() {
			return MaSV;
		}
		public void setMaSV(String maSV) {
		this.MaSV = maSV;
		}
		

		public String getTen() {
		return Ten;
		}

		public void setTen(String ten) {
		this.Ten = ten;
		}

		public String getLop() {
		return Lop;
		}

		public void setLop(String lop) {
		Lop = lop;
		}

		public String getDiaChi() {
		return DiaChi;
		}

		public void setAdress(String DiaChi) {
			this.DiaChi = DiaChi;
		}

		public String getPhuong() {
		return Phuong;
		}

		public void setPhuong(String phuong) {
		this.Phuong = phuong;
		}

		public String getQuan() {
		return Quan;
		}

		public void setQuan(String quan) {
		this.Quan = quan;
		}

		public String getTp() {
		return TP;
		}

		public void setTp(String tp) {
		this.TP = TP;
		}

		public String getEmail() {
		return Email;
		}

		public void setEmail(String email) {
		this.Email = email;
		}

		public String getSdt() {
		return DT;
		}

		public void setSdt(String sdt) {
		this.DT = sdt;
		}

		public QuanLyTruongHocSV() {

		}
		}