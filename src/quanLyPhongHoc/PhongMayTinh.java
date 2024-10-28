package quanLyPhongHoc;

import java.text.DecimalFormat;

public class PhongMayTinh extends PhongHoc {
	private int soMayTinh;

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

	public int getSoMayTinh() {
		return soMayTinh;
	}

	public void setSoMayTinh(int soMayTinh) {
		this.soMayTinh = soMayTinh;
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
		if(duSang() == true &&  (getDienTich()/1.5) <= soMayTinh)
			danhGia = "Đạt chuẩn.";
		else
			danhGia = "Không đạt chuẩn.";
		return danhGia;
	}
	
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#");
		String strSoMayTinh =  df.format(soMayTinh);
		String str = String.format("%-25s|%-25s|", strSoMayTinh, danhGia());
		return super.toString() + str;
	}
}
