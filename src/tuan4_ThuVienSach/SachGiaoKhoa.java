package tuan4_ThuVienSach;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SachGiaoKhoa extends Sach{
	private boolean tinhTrang;

	//--------------------------------Constructors-------------------------------
	public SachGiaoKhoa(String maSach, Date ngayNhap, double donGia, int soLuong, String nhaXuatBan, boolean tinhTrang) {
		super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
		this.tinhTrang = tinhTrang;
	}

	public SachGiaoKhoa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SachGiaoKhoa(String maSach, Date ngayNhap, double donGia, int soLuong, String nhaXuatBan) {
		super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
		// TODO Auto-generated constructor stub
	}

	//-----------------------------Getters & Setters----------------------------
	public boolean isTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(boolean tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	//--------------------------------Thanh tien-----------------------------------
	public double thanhTien() {
		if (tinhTrang == true) {
			return soLuong * donGia;
		} else {
			return (soLuong * donGia * 0.5);
		}
	}

	//--------------------------------toString---------------------------------
	@Override
	public String toString()
	{
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("#,##0.00VND");
		String donGiaString = df.format(donGia);
		String str1 = simpleDateFormat.format(ngayNhap);
		String tinhTrangString = "";
		if(tinhTrang == true)
		{
			tinhTrangString = "mới";
		}
		else
		{
			tinhTrangString = "cũ";
		}
		String str = String.format("%-30s|", tinhTrangString);
		return super.toString() + str;
	}
}
