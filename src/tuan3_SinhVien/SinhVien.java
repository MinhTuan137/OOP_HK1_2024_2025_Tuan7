package tuan3_SinhVien;

import java.text.DecimalFormat;

public class SinhVien {
	//----------------------------các biến---------------------------------
	private int mssv;
	private String hoTen;
	private String diaChi;
	private String soDienThoai;

	//--------------------------get và set các biến------------------------
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

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	//---------------------------contructor------------------------------------
	public SinhVien(int mssv, String hoTen, String diaChi, String soDienThoai) {
		super();
		this.mssv = mssv;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
	}

	public SinhVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	//----------------------------to String--------------------------------------
	@Override
	public String toString() {
		DecimalFormat df1 = new DecimalFormat("#");
		String strMSSV = df1.format(mssv);
		return String.format("|%-15s|%-20s|%-30s|%-15s|", strMSSV, getHoTen(), getDiaChi(), getSoDienThoai());
	}
}
