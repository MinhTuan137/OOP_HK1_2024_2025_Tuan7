package tuan5_HangHoa;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Objects;

public abstract class HangHoa {
	protected String maHang;
	protected String tenHang;
	protected int soLuongTon;
	protected double donGia;
	public abstract double VAT();
	public abstract String mucDoBanBuon();

	//-------------------------Constructor-----------------------------------
	public HangHoa(String maHang, String tenHang, int soLuongTon, double donGia) throws Exception {
		super();
		if(maHang.equals(""))
			throw new Exception("Mã hàng không được để rỗng.");
		this.maHang = maHang;
		setTenHang(tenHang);
		this.soLuongTon = soLuongTon;
		setDonGia(donGia);
	}

	public HangHoa() {
		super();
		// TODO Auto-generated constructor stub
	}

	//----------------------gets và sets các biến------------------------------
	public String getMaHang() {
		return maHang;
	}

	public void setMaHang(String maHang) {
		this.maHang = maHang;
	}

	public String getTenHang() {
		return tenHang;
	}

	public void setTenHang(String tenHang) throws Exception {
		if(tenHang.equals(""))
			throw new Exception("Tên hàng không được để rỗng.");
		else
			this.tenHang = tenHang;
	}

	public int getSoLuongTon() {
		return soLuongTon;
	}

	public void setSoLuongTon(int soLuongTon) throws Exception {
		if(soLuongTon < 0)
			throw new Exception("Số lượng tồn phải >= 0");
		else
			this.soLuongTon = soLuongTon;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) throws Exception {
		if(donGia <= 0)
			throw new Exception("Đơn giá phải > 0");
		else
			this.donGia = donGia;
	}

	//------------------------hashCode và equals----------------------------
	@Override
	public int hashCode() {
		return Objects.hash(maHang);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HangHoa other = (HangHoa) obj;
		return Objects.equals(maHang, other.maHang);
	}

	//--------------------------to String-----------------------------------
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,##0.00VND");
		DecimalFormat df1 = new DecimalFormat("#");
		String strSoLuongTon = df1.format(soLuongTon);
		String donGiaString = df.format(donGia);
		return String.format("|%-20s|%-20s|%-20s|%-20s|", maHang, tenHang, strSoLuongTon, donGiaString);
	}
}
