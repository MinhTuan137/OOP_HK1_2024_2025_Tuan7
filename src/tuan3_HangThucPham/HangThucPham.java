package tuan3_HangThucPham;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HangThucPham {
	//-------------------------Các biến----------------------------------
	private String maHang;
	private String tenHang;
	private int donGia;
	private Date ngaySX;
	private Date ngayHH;

	//-------------------------Constructor-------------------------------
	public HangThucPham(String maHang, String tenHang, int donGia, Date ngaySX, Date ngayHH) {
		super();
		this.maHang = maHang;
		this.tenHang = tenHang;
		this.donGia = donGia;
		this.ngaySX = ngaySX;
		this.ngayHH = ngayHH;
	}

	public HangThucPham() {
		super();
		// TODO Auto-generated constructor stub
	}

	//-------------------------Getter & Setter-----------------------------
	public String getMaHang() {
		return maHang;
	}

	public void setMaHang(String maHang) throws Exception{
		if (maHang == null)
			throw new Exception("Mã hàng không được để trống.");
		this.maHang = maHang;
	}

	public String getTenHang() {
		return tenHang;
	}

	public void setTenHang(String tenHang) throws Exception {
		if(tenHang == null)
			throw new Exception("Tên hàng không được để trống.");
		this.tenHang = tenHang;
	}

	public int getDonGia() {
		return donGia;
	}

	public void setDonGia(int donGia) throws Exception {
		if(donGia < 0)
			throw new Exception("Đơn giá phỉ lớn hơn 0.");
		this.donGia = donGia;
	}

	public Date getNgaySX() {
		return ngaySX;
	}

	public void setNgaySX(Date ngaySX) throws Exception {
		if (ngaySX.after(ngayHH) || ngaySX == null)
			throw new Exception("Ngày sản xuất phải trước ngày hết hạn.");
		this.ngaySX = ngaySX;
	}

	public Date getNgayHH() {
		return ngayHH;
	}

	public void setNgayHH(Date ngayHH) throws Exception {
		if (ngayHH.before(ngaySX) || ngayHH == null)
			throw new Exception("Ngày hết hạn phải sau ngày sản xuất.");
		this.ngayHH = ngayHH;
	}

	//---------------------Kiem tra han su dung---------------------
	public String hanSuDung()
	{
		Date now = new Date();
		String hSD = "";
		if(ngayHH.before(now))
			hSD = "Đã hết hạn";
		else
			hSD = "Còn hạn dùng";
		return hSD;
	}

	//-------------------------toString-----------------------------
	@Override
	public String toString() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("#,##0.00VND");
		String donGiaString = df.format(donGia);
		String str1 = simpleDateFormat.format(ngaySX);
		String str2 = simpleDateFormat.format(ngayHH);
		return String.format("|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|", getMaHang(), getTenHang(), donGiaString, str1, str2, hanSuDung());
	}
}
