package tuan1_SinhVien;

public class SinhVien {
	//---------------------------constructor---------------------------
	public SinhVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SinhVien(int mssv, String hoTen, float diemLT, float diemTH) {
		super();
		this.mssv = mssv;
		this.hoTen = hoTen;
		this.diemLT = diemLT;
		this.diemTH = diemTH;
	}

	//---------------------------các biến---------------------------
	private int mssv;
	private String hoTen;
	private float diemLT, diemTH;

	//---------------------------get & set---------------------------
	public int getMssv() {
		return mssv;
	}
	public void setMssv(int mssv) {
		this.mssv = mssv;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public float getDiemLT() {
		return diemLT;
	}
	public void setDiemLT(float diemLT) {
		this.diemLT = diemLT;
	}
	public float getDiemTH() {
		return diemTH;
	}
	public void setDiemTH(float diemTH) {
		this.diemTH = diemTH;
	}

	//------------------Tính điểm trung bình---------------------------
	public float tinhDiemTB() {
		float diemLT, diemTH;
		diemLT = this.getDiemLT();
		diemTH = this.getDiemTH();
		float diemTB = (diemLT + diemTH)/2;
		return diemTB;
	}

	//--------------------------toString--------------------------------
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%5d \t%-20s %9.2f %20.2f %25.2f", getMssv(), getHoTen(), getDiemLT(), getDiemTH(), tinhDiemTB());
	}
}
