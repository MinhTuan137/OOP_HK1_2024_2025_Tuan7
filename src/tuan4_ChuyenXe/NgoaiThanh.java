package tuan4_ChuyenXe;

import java.text.DecimalFormat;

public class NgoaiThanh extends ChuyenXe{
	//------------------------------Các biến-----------------------------------
	private String noiDen;
	private int soNgayDiDuoc;

	//-----------------------------get và set các biến---------------------------
	public String getNoiDen() {
		return noiDen;
	}

	public void setNoiDen(String noiDen) {
		this.noiDen = noiDen;
	}

	public int getSoNgayDiDuoc() {
		return soNgayDiDuoc;
	}

	public void setSoNgayDiDuoc(int soNgayDiDuoc) {
		this.soNgayDiDuoc = soNgayDiDuoc;
	}

	//------------------------------Các contructor-------------------------------
	public NgoaiThanh(String maChuyenXe, String hoTen, int soXe, double doanhThu, String noiDen, int soNgayDiDuoc) {
		super(maChuyenXe, hoTen, soXe, doanhThu);
		this.noiDen = noiDen;
		this.soNgayDiDuoc = soNgayDiDuoc;
	}

	public NgoaiThanh() {
		super();
		this.noiDen ="";
		this.soNgayDiDuoc = 0;
	}
	//-----------------------------to String------------------------------------
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#");
		String strSoNgayDiDuoc = df.format(soNgayDiDuoc);
		String str = "";
		str = String.format("%-20s|%-20s|", noiDen, strSoNgayDiDuoc);
		return super.toString() + str;
	}
}
