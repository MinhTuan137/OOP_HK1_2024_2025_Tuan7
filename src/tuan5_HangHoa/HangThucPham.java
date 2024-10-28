package tuan5_HangHoa;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HangThucPham extends HangHoa{
	private LocalDate ngaySX;
	private LocalDate ngayHH;
	private String nhaCungCap;

	//-------------------------Constructor-----------------------------------
	public HangThucPham(String maHang, String tenHang, int soLuongTon, double donGia, LocalDate ngaySX, LocalDate ngayHH,
			String nhaCungCap) throws Exception {
		super(maHang, tenHang, soLuongTon, donGia);
		this.ngaySX = ngaySX;
		this.ngayHH = ngayHH;
		this.nhaCungCap = nhaCungCap;
	}

	public HangThucPham() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HangThucPham(String maHang, String tenHang, int soLuongTon, double donGia) throws Exception {
		super(maHang, tenHang, soLuongTon, donGia);
		// TODO Auto-generated constructor stub
	}

	//----------------------gets và sets các biến------------------------------
	public LocalDate getNgaySX() {
		return ngaySX;
	}

	public void setNgaySX(LocalDate ngaySX) throws Exception {
		LocalDate now = LocalDate.now();
		if(ngaySX.isAfter(now))
		{
			throw new Exception("Ngày sản xuất phải trước ngày hiện tại.");
		}
		else
			this.ngaySX = ngaySX;
	}

	public LocalDate getNgayHH() {
		return ngayHH;
	}

	public void setNgayHH(LocalDate ngayHH) throws Exception {
		if(ngayHH.isBefore(ngaySX))
		{
			throw new Exception("Ngày hết hạn phải sau hoặc là ngày sản xuất.");
		}
		else
			this.ngayHH = ngayHH;
	}

	public String getNhaCungCap() {
		return nhaCungCap;
	}

	public void setNhaCungCap(String nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}

	//-----------------------------Tính VAT----------------------------------
	public double VAT()
	{
		return donGia*(0.05);
	}

	//-------------------------Đánh giá mức độ bán----------------------------
	public String mucDoBanBuon()
	{
		LocalDate now = LocalDate.now();
		String danhGia = "Không đánh giá";
		if(soLuongTon > 0  && ngayHH.isBefore(LocalDate.now()))
		{
			danhGia = "Khó bán";
		}
		return danhGia;
	}

	//-----------------------Kiểm tra ngày hết hạn----------------------------
	public boolean kiemTraHetHan()
	{
		LocalDate now = LocalDate.now();
		if(ngayHH.isBefore(now))
			return true;
		return false;
	}

	//--------------------------to String-----------------------------------
	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String strNgaySX = ngaySX.format(formatter);
		String strNgayHH = ngayHH.format(formatter);
		String hanSD;
		if(kiemTraHetHan() == true)
		{
			hanSD = "Đã hết hạn sử dụng.";
		}
		else
		{
			hanSD = "Còn hạn sử dụng";
		}
		DecimalFormat df = new DecimalFormat("#,##0.00VND");
		String strVAT = df.format(VAT());
		String str = "";
		str = String.format("%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|", strNgaySX, strNgayHH, hanSD, nhaCungCap, strVAT, mucDoBanBuon());
		return super.toString() + str;
	}
}
