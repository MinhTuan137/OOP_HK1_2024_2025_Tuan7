package tuan5_GiaoDich;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public abstract class GiaoDich {
	protected String maGD;
	protected Date ngayGD;
	protected double donGia;
	protected int soLuong;
	public abstract double thanhTien();

	//-------------------------Constructor-----------------------------------
	public GiaoDich(String maGD, Date ngayGD, double donGia, int soLuong) {
		super();
		this.maGD = maGD;
		this.ngayGD = ngayGD;
		this.donGia = donGia;
		this.soLuong = soLuong;
	}

	public GiaoDich() {
		super();
		// TODO Auto-generated constructor stub
	}

	//----------------------gets và sets các biến------------------------------
	public String getMaGD() {
		return maGD;
	}

	public void setMaGD(String maGD) {
		this.maGD = maGD;
	}

	public Date getNgayGD() {
		return ngayGD;
	}

	public void setNgayGD(Date ngayGD) {
		this.ngayGD = ngayGD;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	//------------------------hashCode và equals----------------------------
	@Override
	public int hashCode() {
		return Objects.hash(maGD);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GiaoDich other = (GiaoDich) obj;
		return Objects.equals(maGD, other.maGD);
	}

	//--------------------------to String-----------------------------------
	@Override
	public String toString() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("#,##0.00VND");
		DecimalFormat df1 = new DecimalFormat("#");
		String strSoLuong = df1.format(soLuong);
		String donGiaString = df.format(donGia);
		String str1 = simpleDateFormat.format(ngayGD);
		return String.format("|%-20s|%-25s|%-25s|%-15s|", maGD, str1, donGiaString, strSoLuong);
	}
}
