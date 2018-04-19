package fasttrackse.interfacesamples.models;

public class MonAnh extends MonHoc {
	private double diemListening;
	private double diemSpeaking;
	private double diemReading;
	private double diemWriting;

	public double getDiemListening() {
		return diemListening;
	}

	public void setDiemListening(double diemListening) {
		this.diemListening = diemListening;
	}

	public double getDiemSpeaking() {
		return diemSpeaking;
	}

	public void setDiemSpeaking(double diemSpeaking) {
		this.diemSpeaking = diemSpeaking;
	}

	public double getDiemReading() {
		return diemReading;
	}

	public void setDiemReading(double diemReading) {
		this.diemReading = diemReading;
	}

	public double getDiemWriting() {
		return diemWriting;
	}

	public void setDiemWriting(double diemWriting) {
		this.diemWriting = diemWriting;
	}

	public MonAnh() {
		//
	}

	public MonAnh(double diemListening, double diemSpeaking, double diemReading, double diemWriting) {
		this.diemListening = diemListening;
		this.diemSpeaking = diemSpeaking;
		this.diemReading = diemReading;
		this.diemWriting = diemWriting;
	}

	@Override
	public String mangSach() {
		return "Business English";
	}

	@Override
	public double tinhDiemMonHoc() {
		return (this.diemListening + this.diemSpeaking + this.diemReading + this.diemWriting) / 4;
	}

}
