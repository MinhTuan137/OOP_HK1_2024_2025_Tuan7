package tuan4_ChuyenXe;

import java.text.DecimalFormat;

public class NoiThanh extends ChuyenXe{
	//-------------------------Các biến-----------------------------------
	private int soTuyen;
	private double soKm;

	//------------------------get và set các biến----------------------------
	public int getSoTuyen() {
		return soTuyen;
	}

	public void setSoTuyen(int soTuyen) {
		this.soTuyen = soTuyen;
	}

	public double getSoKm() {
		return soKm;
	}

	public void setSoKm(double soKm) {
		this.soKm = soKm;
	}

	//--------------------------Contructor----------------------------------
	public NoiThanh(String maChuyenXe, String hoTen, int soXe, double doanhThu, int soTuyen, double soKm) {
		super(maChuyenXe, hoTen, soXe, doanhThu);
		this.soTuyen = soTuyen;
		this.soKm = soKm;
	}

	public NoiThanh() {
		super();
		this.soTuyen = 0;
		this.soKm = 0;
	}

	//--------------------------to String----------------------------------
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#");
		String strSoTuyen = df.format(soTuyen);
		String strSoKM = df.format(soKm);
		String str = "";
		str = String.format("%-20s|%-20s|", strSoTuyen, strSoKM );
		return super.toString() + str;
	}
}
