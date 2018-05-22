package namdv.model;

public class CheckLogin {
	private static String loggedrole;
	private static String maBanDoc;

	public static String getLoggedrole() {
		return loggedrole;
	}

	public static void setLoggedrole(String aLoggedrole) {
		loggedrole = aLoggedrole;
	}

	public static String getMaBanDoc() {
		return maBanDoc;
	}

	public static void setMaBanDoc(String maBanDoc) {
		CheckLogin.maBanDoc = maBanDoc;
	}
}