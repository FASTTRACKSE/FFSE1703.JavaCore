package ffasttrackse.edu.model;
import java.io.Serializable;
import java.util.Comparator;
public class SinhVien implements Serializable {
		private String nameSV;
		private String ngaySinhSV;
		private float LP1;
		private float LP2;
		private float LP3;
		 static int tongSV = 0;
		public int getTongSV() {
			return tongSV;
		}
		 static void setTongSV() {
			tongSV++;
		}
		public SinhVien() {
			
		}
		public SinhVien(String nameSV,String ngaySinhSV,float LP1,float LP2,float LP3) {
			super();
			this.nameSV=nameSV;
			this.ngaySinhSV=ngaySinhSV;
			this.LP1= LP1;
			this.LP2= LP2;
			this.LP3= LP3;		
		}
		public String getNameSV() {
			return this.nameSV;
		}
		public void setNameSV(String nameSV) {
			this.nameSV=nameSV;
		}
		public String getNgaySinhSV() {
			return this.ngaySinhSV;
		}
		public void setNgaySinhSV(String ngaySinhSV) {
			this.ngaySinhSV=ngaySinhSV;
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
		public static Comparator<SinhVien> compare = new Comparator<SinhVien>() {
	        public int compare(SinhVien sv1, SinhVien sv2) {
	            if (sv1.getDiemTB() > sv2.getDiemTB()) {
	                return 1;
	            } else {
	                if (sv1.getDiemTB() == sv2.getDiemTB()) {
	                    return 0;
	                } else {
	                    return -1;
	                }
	            }
	        }
		};
		public static Comparator<SinhVien> compareName = new Comparator<SinhVien>() {
			 
			  @Override
			  public int compare(SinhVien sv1, SinhVien sv2) {		  
			    return sv1.nameSV.compareTo(sv2.nameSV);		   
			  }
			 };
	}

