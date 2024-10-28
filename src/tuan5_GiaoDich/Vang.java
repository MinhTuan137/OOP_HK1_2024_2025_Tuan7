package tuan5_GiaoDich;

import java.util.Date;

public class Vang extends GiaoDich{
	private String loaiVang;

	//---------------------------Constructor--------------------------------
	public Vang(String maGD, Date ngayGD, double donGia, int soLuong, String loaiVang) {
		super(maGD, ngayGD, donGia, soLuong);
		this.loaiVang = loaiVang;
	}

	public Vang() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vang(String maGD, Date ngayGD, double donGia, int soLuong) {
		super(maGD, ngayGD, donGia, soLuong);
		// TODO Auto-generated constructor stub
	}

	//----------------------gets và sets các biến---------------------------
	public String getLoaiVang() {
		return loaiVang;
	}

	public void setLoaiVang(String loaiVang) {
		this.loaiVang = loaiVang;
	}

	//-------------------------Tính thành tiền-----------------------------
	public double thanhTien()
	{
		return soLuong*donGia;
	}

	//--------------------------to String-----------------------------------
	@Override
	public String toString() {
		String str = "";
		str = String.format("%-25s|", loaiVang);
		return super.toString()+ str;
	}
}
