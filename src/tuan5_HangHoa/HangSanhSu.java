package tuan5_HangHoa;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class HangSanhSu extends HangHoa{
	private String nhaSX;
	private LocalDate ngayNhapKho;

	//-------------------------Constructor-----------------------------------
	public HangSanhSu(String maHang, String tenHang, int soLuongTon, double donGia, String nhaSX, LocalDate ngayNhapKho) throws Exception {
		super(maHang, tenHang, soLuongTon, donGia);
		this.nhaSX = nhaSX;
		this.ngayNhapKho = ngayNhapKho;
	}

	public HangSanhSu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HangSanhSu(String maHang, String tenHang, int soLuongTon, double donGia) throws Exception {
		super(maHang, tenHang, soLuongTon, donGia);
		// TODO Auto-generated constructor stub
	}

	//----------------------gets và sets các biến------------------------------
	public String getNhaSX() {
		return nhaSX;
	}

	public void setNhaSX(String nhaSX) {
		this.nhaSX = nhaSX;
	}

	public LocalDate getNgayNhapKho() {
		return ngayNhapKho;
	}

	public void setNgayNhapKho(LocalDate ngayNhapKho) {
		this.ngayNhapKho = ngayNhapKho;
	}

	//-----------------------------Tính VAT----------------------------------
	public double VAT()
	{
		return donGia*(0.1);
	}

	//-------------------------Đánh giá mức độ bán----------------------------
	public String mucDoBanBuon()
	{
		Period age = Period.between(ngayNhapKho, LocalDate.now());
		int days = age.getDays();
		String danhGia = "Không đánh giá";
		if(soLuongTon > 50 && days > 10)
			danhGia = "Bán chậm";
		return danhGia;
	}

	//--------------------------to String-----------------------------------
	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String strNgayNhapKho = ngayNhapKho.format(formatter);
		DecimalFormat df = new DecimalFormat("#,##0.00VND");
		String strVAT = df.format(VAT());
		String str ="";
		str = String.format("%-20s|%-20s|%-20s|%-20s|", nhaSX, strNgayNhapKho, strVAT, mucDoBanBuon());
		return super.toString() + str;
	}
}
