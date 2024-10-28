package tuan5_GiaoDich;

import java.text.DecimalFormat;
import java.util.Date;

public class TienTe extends GiaoDich{
	private double tiGia;
	private String loaiTienTe;

	//--------------------------Constructor---------------------------------
	public TienTe(String maGD, Date ngayGD, double donGia, int soLuong, double tiGia, String loaiTienTe) {
		super(maGD, ngayGD, donGia, soLuong);
		this.tiGia = tiGia;
		this.loaiTienTe = loaiTienTe;
	}

	public TienTe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TienTe(String maGD, Date ngayGD, double donGia, int soLuong) {
		super(maGD, ngayGD, donGia, soLuong);
		// TODO Auto-generated constructor stub
	}

	//----------------------gets và sets các biến------------------------------
	public double getTiGia() {
		return tiGia;
	}

	public void setTiGia(double tiGia) {
		this.tiGia = tiGia;
	}

	public String getLoaiTienTe() {
		return loaiTienTe;
	}

	public void setLoaiTienTe(String loaiTienTe) {
		this.loaiTienTe = loaiTienTe;
	}

	//-------------------------Tính thành tiền-----------------------------
	public double thanhTien()
	{
		if(loaiTienTe.equalsIgnoreCase("USD") || loaiTienTe.equalsIgnoreCase("Euro"))
		{
			return soLuong*donGia*tiGia;
		}
		else
			return soLuong*donGia;
	}

	//--------------------------to String-----------------------------------
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#.0");
		String strTiGia = df.format(tiGia);
		String str = "";
		str = String.format("%-25s|%-15s|", strTiGia, loaiTienTe );
		return super.toString() + str;
	}
}
