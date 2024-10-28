package tuan4_ThuVienSach;

import java.util.Date;
import java.util.Objects;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public abstract class Sach {
	protected String maSach;
	protected Date ngayNhap;
	protected double donGia;
	protected int soLuong;
	protected String nhaXuatBan;
	public abstract double thanhTien();

	//-----------------------------Constructors------------------------------
	public Sach(String maSach, Date ngayNhap, double donGia, int soLuong, String nhaXuatBan) {
		super();
		this.maSach = maSach;
		this.ngayNhap = ngayNhap;
		this.donGia = donGia;
		this.soLuong = soLuong;
		this.nhaXuatBan = nhaXuatBan;
	}

	public Sach() {
		super();
		// TODO Auto-generated constructor stub
	}

	//-----------------------------Getters & Setters----------------------------
	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) throws Exception {
		if(maSach == "")
			throw new Exception("Ma khong duoc de trong.");
		else
			this.maSach = maSach;
	}

	public Date getNgayNhap() {
		return ngayNhap;
	}

	public void setNgayNhap(Date ngayNhap) {
		this.ngayNhap = ngayNhap;
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

	public String getNhaXuatBan() {
		return nhaXuatBan;
	}

	public void setNhaXuatBan(String nhaXuatBan) {
		this.nhaXuatBan = nhaXuatBan;
	}

	//-------------------Hashcode && Equals-------------------
	@Override
	public int hashCode() {
		return Objects.hash(maSach);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sach other = (Sach) obj;
		return Objects.equals(maSach, other.maSach);
	}

	//--------------------------------toString--------------------------------
	@Override
	public String toString() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("#,##0.00VND");
		DecimalFormat df1 = new DecimalFormat("#");
		String donGiaString = df.format(donGia);
		String strSoLuong = df1.format(soLuong);
		String str1 = simpleDateFormat.format(ngayNhap);
		return String.format("|%-15s|%-15s|%-20s|%-15s|%-20s|", maSach, str1, donGiaString, strSoLuong, nhaXuatBan);
	}
}
