package tuan7_PhongHoc;

import java.text.DecimalFormat;

public class PhongMayTinh extends PhongHoc{
	private int soMayTinh;

	//------------------------------constracter-----------------------------
	public PhongMayTinh(String maPhong, String dayNha, float dienTich, int soBongDen, int soMayTinh) {
		super(maPhong, dayNha, dienTich, soBongDen);
		this.soMayTinh = soMayTinh;
	}

	public PhongMayTinh() {
		super();
		// TODO Auto-generated constructor stub
	}


	public PhongMayTinh(String maPhong, String dayNha, float dienTich, int soBongDen) {
		super(maPhong, dayNha, dienTich, soBongDen);
		// TODO Auto-generated constructor stub
	}

	//------------------------------sets & gets--------------------------------
	public int getSoMayTinh() {
		return soMayTinh;
	}

	public void setSoMayTinh(int soMayTinh) {
		this.soMayTinh = soMayTinh;
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
		if(duSang() == true && (dienTich/1.5) <= soMayTinh)
			danhGia = "Đạt chuẩn";
		else
			danhGia = "Không đạt chuẩn";
		return danhGia;
	}

	//------------------------------to String---------------------------------
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#");
		String strMayTinh = df.format(soMayTinh);
		String str = String.format("%-25s|%-25s|", strMayTinh, danhGia());
		return super.toString() + str;
	}
}
