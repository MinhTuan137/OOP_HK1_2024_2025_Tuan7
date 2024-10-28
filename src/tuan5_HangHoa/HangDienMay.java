package tuan5_HangHoa;

import java.text.DecimalFormat;

public class HangDienMay extends HangHoa{
	private int thoiGianBaoHanh;
	private double congSuat;

	//-------------------------Constructor-----------------------------------
	public HangDienMay(String maHang, String tenHang, int soLuongTon, double donGia, int thoiGianBaoHanh,
			double congSuat) throws Exception {
		super(maHang, tenHang, soLuongTon, donGia);
		this.thoiGianBaoHanh = thoiGianBaoHanh;
		this.congSuat = congSuat;
	}

	public HangDienMay() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HangDienMay(String maHang, String tenHang, int soLuongTon, double donGia) throws Exception {
		super(maHang, tenHang, soLuongTon, donGia);
		// TODO Auto-generated constructor stub
	}

	//----------------------gets và sets các biến------------------------------
	public int getThoiGianBaoHanh() {
		return thoiGianBaoHanh;
	}

	public void setThoiGianBaoHanh(int thoiGianBaoHanh) throws Exception {
		if(thoiGianBaoHanh < 0)
			throw new Exception("Thời gian bảo hành phải >= 0");
		else
			this.thoiGianBaoHanh = thoiGianBaoHanh;
	}

	public double getCongSuat() {
		return congSuat;
	}

	public void setCongSuat(double congSuat) throws Exception {
		if(congSuat <= 0)
		{
			throw new Exception("Công suất phải > 0");
		}
		else
			this.congSuat = congSuat;
	}

	//-----------------------------Tính VAT----------------------------------
	public double VAT()
	{
		return donGia*(0.1);
	}

	//-------------------------Đánh giá mức độ bán----------------------------
	public String mucDoBanBuon()
	{
		String danhGia = "Không đánh giá";
		if(soLuongTon < 3)
			danhGia = "Bán được";
		return danhGia;
	}

	//--------------------------to String-----------------------------------
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,##0.00VND");
		DecimalFormat df1 = new DecimalFormat("#.0 KW");
		DecimalFormat df2 = new DecimalFormat("# Tháng");
		String strVAT = df.format(VAT());
		String strCongSuat = df1.format(congSuat);
		String strThoiGianBH = df2.format(thoiGianBaoHanh);
		String str = "";
		str = String.format("%-20s|%-20s|%-20s|%-20s|", strThoiGianBH, strCongSuat, strVAT, mucDoBanBuon());
		return super.toString() + str;
	}
}
