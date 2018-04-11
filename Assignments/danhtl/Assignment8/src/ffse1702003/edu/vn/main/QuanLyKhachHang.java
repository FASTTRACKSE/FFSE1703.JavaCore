package ffse1702003.edu.vn.main;
import ffse1702003.edu.vn.io.TextFileFactory;
import ffse1702003.edu.vn.model.*;
public class QuanLyKhachHang {
	public static void luuFile() {
		ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
		dsKH.add(new KhachHang("KH01", "Nguyễn Thị Bình"));
		dsKH.add(new KhachHang("KH02", "Trần Trung Thành"));
		dsKH.add(new KhachHang("KH03", "Lê Bá Khánh Trình"));
		dsKH.add(new KhachHang("KH04", "Hoàng Ngọc Phách"));

		boolean kt = TextFileFactory.luuFile(dsKH, "dulieu.txt");
		if (kt == true) {
			System.out.println("Lưu file thành công");
		} else {
			System.out.println("Lưu file thất bại");
		}
	}

	public static void main(String[] args) {
		luuFile();
		ArrayList<KhachHang> dsKH = TextFileFactory.docFile("dulieu.txt");

		System.out.println("Danh sách khách hàng nạp vào máy tính là:");
		System.out.println("Mã    Tên");
		for (KhachHang kh : dsKH) {
			System.out.println(kh);
		}
	}

}
