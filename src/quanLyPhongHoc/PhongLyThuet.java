package quanLyPhongHoc;

public class PhongLyThuet extends PhongHoc {
	private boolean mayChieu;

	public PhongLyThuet(String maPhong, String dayNha, float dienTich, int soBongDen, boolean mayChieu) {
		super(maPhong, dayNha, dienTich, soBongDen);
		this.mayChieu = mayChieu;
	}

	public PhongLyThuet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PhongLyThuet(String maPhong, String dayNha, float dienTich, int soBongDen) {
		super(maPhong, dayNha, dienTich, soBongDen);
		// TODO Auto-generated constructor stub
	}

	public boolean isMayChieu() {
		return mayChieu;
	}

	public void setMayChieu(boolean mayChieu) {
		this.mayChieu = mayChieu;
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
		if(duSang() == true &&  mayChieu == true)
			danhGia = "Đạt chuẩn.";
		else
			danhGia = "Không đạt chuẩn.";
		return danhGia;
	}
	
	@Override
	public String toString() {
		String strMayChieu;
		if(mayChieu == true)
			strMayChieu = "Có máy chiếu.";
		else
			strMayChieu = "Không có máy chiếu.";
		String str = String.format("%-25s|%-25s|", strMayChieu, danhGia());
		return super.toString() + str;
	}
}
