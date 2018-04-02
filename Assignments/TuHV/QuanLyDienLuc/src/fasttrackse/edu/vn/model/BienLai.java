package fasttrackse.edu.vn.model;

public class BienLai extends KhachHang{
	private int chiSoMoi;
	private int chiSoCu;

	
		public double getchiSoMoi() {
			return chiSoMoi;
		}

		public void setchiSoMoi(int chiSoMoi) {
			this.chiSoMoi = chiSoMoi;
		}
		public double getchiSoCu() {
			return chiSoCu;
		}

		public void setchiSoCu(int chiSoCu) {
			this.chiSoCu = chiSoCu;
		}

		
		
		public BienLai(String MsKhachHang, String TenKhachHang, String DiaChi, int MsCongto, int chiSoMoi, int chiSoCu)  {
			super(MsKhachHang, TenKhachHang, DiaChi, MsCongto);
			this.chiSoMoi = chiSoMoi;
			this.chiSoCu = chiSoCu;
		}
		public int gettienDien(){
			return((chiSoMoi - chiSoCu ) *3000);
		}
		
	
	
}

