package tuan4_ThuVienSach;

import java.util.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class SachThamKhao extends Sach{
	private double thue;

	// --------------------------------Constructors-------------------------------
	public SachThamKhao(String maSach, Date ngayNhap, double donGia, int soLuong, String nhaXuatBan, double thue) {
		super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
		this.thue = thue;
	}

	public SachThamKhao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SachThamKhao(String maSach, Date ngayNhap, double donGia, int soLuong, String nhaXuatBan) {
		super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
		// TODO Auto-generated constructor stub
	}

	// -----------------------------Getters & Setters----------------------------
	public double getThue() {
		return thue;
	}

	public void setThue(double thue) {
		this.thue = thue;
	}

	// --------------------------------Thanh tien-----------------------------------
	public double thanhTien()
	{
		return ((soLuong*donGia) + (soLuong*donGia*thue));
	}

	// --------------------------------toString---------------------------------
	@Override
	public String toString() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("#,##0.00VND");
		String donGiaString = df.format(donGia);
		String strThue = df.format(thue);
		String str1 = simpleDateFormat.format(ngayNhap);
		String str = String.format("%-30s|", strThue);
		return super.toString() + str;
	}
}
