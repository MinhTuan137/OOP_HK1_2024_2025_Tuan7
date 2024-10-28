package quanLyPhongHoc;

import java.text.DecimalFormat;

public class PhongThiNghiem extends PhongHoc{
	private String chuenNganh;
	private int sucChua;
	private boolean bonRua;
	
	public PhongThiNghiem(String maPhong, String dayNha, float dienTich, int soBongDen, String chuenNganh, int sucChua,
			boolean bonRua) {
		super(maPhong, dayNha, dienTich, soBongDen);
		this.chuenNganh = chuenNganh;
		this.sucChua = sucChua;
		this.bonRua = bonRua;
	}
	
	public PhongThiNghiem() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PhongThiNghiem(String maPhong, String dayNha, float dienTich, int soBongDen) {
		super(maPhong, dayNha, dienTich, soBongDen);
		// TODO Auto-generated constructor stub
	}
	
	public String getChuenNganh() {
		return chuenNganh;
	}
	
	public void setChuenNganh(String chuenNganh) {
		this.chuenNganh = chuenNganh;
	}
	
	public int getSucChua() {
		return sucChua;
	}
	
	public void setSucChua(int sucChua) {
		this.sucChua = sucChua;
	}
	
	public boolean isBonRua() {
		return bonRua;
	}
	
	public void setBonRua(boolean bonRua) {
		this.bonRua = bonRua;
	}
	
	public boolean duSang()
	{
		if((getDienTich()/10) <= soBongDen)
			return true;
		return false;
	}
	
	public String  danhGia()
	{
		String danhGia;
		if(duSang() == true &&  bonRua == true)
			danhGia = "Đạt chuẩn.";
		else
			danhGia = "Không đạt chuẩn.";
		return danhGia;
	}
	
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#");
		String strSucChua =  df.format(sucChua);
		String strBonRua;
		if(bonRua == true)
			strBonRua = "Có bồn rửa.";
		else
			strBonRua = "Không có bồn rửa.";
		String str = String.format("%-25s|%-25s|%-25s|%-25s|", getChuenNganh(), strSucChua, strBonRua, danhGia());
		return super.toString() + str;
	}
}
