package ffse1703004.model;

@SuppressWarnings("serial")
public class MyException extends Exception {
	String err;
	public MyException(String string) {
		// TODO Auto-generated constructor stub
		this.err = string;
	}
	@Override
	public String toString() {
		return this.err;
	}

	public static void checkInt(String str) throws MyException{
		int n;
		try {
			n = Integer.parseInt(str);
		}
		catch (Exception e) {
			throw new MyException("Vui lòng nhập đúng định dạng");
		}
		if (n < 0) {
			throw new MyException("Chỉ được nhập số dương, vui lòng nhập lại");
		}
	}
}
