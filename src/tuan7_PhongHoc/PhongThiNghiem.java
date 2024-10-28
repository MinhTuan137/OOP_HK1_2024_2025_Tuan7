package tuan7_PhongHoc;

import java.text.DecimalFormat;

public class PhongThiNghiem extends PhongHoc{
	private String chuyenNganh;
	private int sucChua;
	private boolean bonRua;

	//------------------------------constracter-----------------------------
	public PhongThiNghiem(String maPhong, String dayNha, float dienTich, int soBongDen, String chuyenNganh, int sucChua,
			boolean bonRua) {
		super(maPhong, dayNha, dienTich, soBongDen);
		this.chuyenNganh = chuyenNganh;
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

	//------------------------------sets & gets--------------------------------
	public String getChuyenNganh() {
		return chuyenNganh;
	}

	public void setChuyenNganh(String chuyenNganh) {
		this.chuyenNganh = chuyenNganh;
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

	//------------------------------Đánh giá---------------------------------
	public boolean duSang()
	{
		if((dienTich/10) <= soBongDen)
			return true;
		else
			return false;
	}

	public String danhGia()
	{
		String danhGia;
		if(duSang() == true && bonRua == true)
			danhGia = "Đạt chuẩn";
		else
			danhGia = "Không đạt chuẩn";
		return danhGia;
	}

	//------------------------------to String---------------------------------
	@Override
	public String toString() {
		String strBonRua;
		if(bonRua == true)
			strBonRua = "Có bồn rửa";
		else
			strBonRua = "Không có bồn rửa";
		DecimalFormat df = new DecimalFormat("#");
		String strSucChua = df.format(sucChua);
		String str = String.format("%-25s|%-25s|%-25s|%-25s|", getChuyenNganh(), strSucChua, strBonRua, danhGia());
		return super.toString() + str;
	}
}
