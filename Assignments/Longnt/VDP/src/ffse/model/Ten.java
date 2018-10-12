package ffse.model;

public class Ten {
String hoTen;

public String getHoTen() {
	return hoTen;
}

public void setHoTen(String hoTen) {
	this.hoTen = hoTen;
}
public void mangToan() {
	System.out.println( hoTen + " mang sách toán đi học");
}
public void mangLy() {
	System.out.println( hoTen + " mang sách lý đi học");
}
public void mangHoa() {
	System.out.println( hoTen + " mang sách hóa đi học");
}

}
