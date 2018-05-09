package QuanLyTruongHoc.FFSE.Model;

	

	public class QuanLyModelLopHoc  {
		private String MaLop;
		private String MoTa;
		private String NamHoc;
		private String MaSV;
		
		
		public QuanLyModelLopHoc( String MaLop, String MoTa, String NamHoc) {
			this.MaLop = MaLop;
			this.MoTa = MoTa;
			this.NamHoc = NamHoc;
			
			}
		

		public QuanLyModelLopHoc() {

		}

		
		public String getMaLop() {
			return MaLop;
		}
		public void setMaLop(String maLop) {
			MaLop = maLop;
		}
		public String getMoTa() {
			return MoTa;
		}
		public void setMoTa(String moTa) {
			MoTa = moTa;
		}
		public String getNamHoc() {
			return NamHoc;
		}
		public void setNamHoc(String namHoc) {
			NamHoc = namHoc;
		}
		
	}
