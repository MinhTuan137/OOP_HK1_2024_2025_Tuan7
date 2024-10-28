package tuan4_ChuyenXe;

import java.text.DecimalFormat;
import java.util.Objects;

public class ChuyenXe {
	//------------------------------Các biến-----------------------------------
	protected String maChuyenXe;
	protected String hoTen;
	protected int soXe;
	protected double doanhThu;

	//----------------------get và  set các biến--------------------------------
	protected String getMaChuyenXe() {
		return maChuyenXe;
	}

	protected void setMaChuyenXe(String maChuyenXe) {
		this.maChuyenXe = maChuyenXe;
	}

	protected String getHoTen() {
		return hoTen;
	}

	protected void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	protected int getSoXe() {
		return soXe;
	}

	protected void setSoXe(int soXe) {
		this.soXe = soXe;
	}

	protected double getDoanhThu() {
		return doanhThu;
	}

	protected void setDoanhThu(double doanhThu) throws Exception{
		if(doanhThu > 0)
			this.doanhThu = doanhThu;
		else
			throw new Exception("Doanh thu phải lớn hơn 0");
	}

	//------------------------------ Các Contructor -----------------------------------
	protected ChuyenXe(String maChuyenXe, String hoTen, int soXe, double doanhThu) {
		super();
		this.maChuyenXe = maChuyenXe;
		this.hoTen = hoTen;
		this.soXe = soXe;
		this.doanhThu = doanhThu;
	}

	protected ChuyenXe() {
		super();
		// TODO Auto-generated constructor stub
	}

	//------------------------------hashcode và equals---------------------------------
	@Override
	public int hashCode() {
		return Objects.hash(maChuyenXe);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChuyenXe other = (ChuyenXe) obj;
		return Objects.equals(maChuyenXe, other.maChuyenXe);
	}

	//----------------------------------to String-----------------------------------------
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#");
		DecimalFormat df1 = new DecimalFormat("#,##0.00VNĐ");
		String strSoXe = df.format(soXe);
		String strDoanhThu = df1.format(doanhThu);
		return String.format("|%-20s|%-20s|%-20s|%-20s|", maChuyenXe, hoTen, strSoXe, strDoanhThu);
	}
}
