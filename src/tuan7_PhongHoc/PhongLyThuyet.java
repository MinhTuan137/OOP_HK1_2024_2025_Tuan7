package tuan7_PhongHoc;

public class PhongLyThuyet extends PhongHoc{
	private boolean mayChieu;

	//------------------------------constracter-----------------------------
	public PhongLyThuyet(String maPhong, String dayNha, float dienTich, int soBongDen, boolean mayChieu) {
		super(maPhong, dayNha, dienTich, soBongDen);
		this.mayChieu = mayChieu;
	}

	public PhongLyThuyet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PhongLyThuyet(String maPhong, String dayNha, float dienTich, int soBongDen) {
		super(maPhong, dayNha, dienTich, soBongDen);
		// TODO Auto-generated constructor stub
	}

	//------------------------------sets & gets--------------------------------
	public boolean isMayChieu() {
		return mayChieu;
	}

	public void setMayChieu(boolean mayChieu) {
		this.mayChieu = mayChieu;
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
		if(duSang() == true && mayChieu == true)
			danhGia = "Đạt chuẩn";
		else
			danhGia = "Không đạt chuẩn";
		return danhGia;
	}

	//------------------------------to String---------------------------------
	@Override
	public String toString() {
		String strMayChieu;
		if(mayChieu == true)
			strMayChieu = "Có máy chiếu";
		else
			strMayChieu = "Không có máy chiếu";
		String str = String.format("%-25s|%-25s|", strMayChieu, danhGia());
		return super.toString() + str;
	}
}
