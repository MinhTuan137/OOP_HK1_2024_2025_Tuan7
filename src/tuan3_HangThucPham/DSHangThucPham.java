package tuan3_HangThucPham;

public class DSHangThucPham {
	//-------------------------------các biến--------------------------------
	private HangThucPham[] ds;
	public int soLuongHT = 0;

	//----------------------------constructor--------------------------------
	public DSHangThucPham()
	{
		super();
		this.ds = new HangThucPham[1];
	}

	public DSHangThucPham(int soLuong) {
		ds = new HangThucPham[soLuong];
	}

	//----------------------------get và set--------------------------------
	public int getSoLuongHT() {
		return soLuongHT;
	}

	public void setSoLuongHT(int soLuongHT) {
		this.soLuongHT = soLuongHT;
	}

	//------------------------Tăng kích thước mảng---------------------------
	public void tangKichThuoc(){
		HangThucPham temp[] = new HangThucPham[ds.length * 2];
		for (int i = 0; i < ds.length; i++) {
			temp[i] = ds[i];
		}
		ds = temp;
	}

	//---------------------------Sao chép mảng---------------------------------
	public HangThucPham[] saoChep(HangThucPham[] ds, int size)
	{
		HangThucPham[] newDS = new HangThucPham[size];
		for(int i = 0; i < size; i++)
		{
			newDS[i] = ds[i];
		}
		return newDS;
	}

	//----------------------Tìm kiếm hàng theo mã hàng-------------------------
	public int timViTri(String maHang) {
		for (int i = 0; i < soLuongHT; i++) {
			if (ds[i].getMaHang().equalsIgnoreCase(maHang))
				return i;
		}
		return -1;
	}

	public HangThucPham timHTP(String maHang) 
	{
		int vt = timViTri(maHang);
		if(vt != -1)
			return ds[vt];
		else
			return null;
	}

	//-----------------------------thêm hàng----------------------------------
	public boolean them(HangThucPham htp) {
		if(soLuongHT == ds.length)
			tangKichThuoc();

		if(timViTri(htp.getMaHang()) == -1) // Không tìm thấy mã trùng
		{
			ds[soLuongHT] = htp;
			soLuongHT++;
			return true;
		} 
		else 
		{
			return false;
		}
	}

	//-----------------------------xóa hàng----------------------------------
	public void xoaHTP(String maHang) throws Exception
	{
		int vt = timViTri(maHang);
		if(vt != -1)
		{
			ds[vt] = null;
			for(int i = vt; i < soLuongHT - 1; i++)
			{
				ds[i] = ds[i+1];
			}
			soLuongHT--;
		}
		else
			throw new Exception("Không tìm thấy mặt hàng cần xóa.");
	}

	//-----------------------------sửa hàng----------------------------------
	public void suaHTP(HangThucPham htp) throws Exception
	{
		int vt = timViTri(htp.getMaHang());
		if(vt != -1)
			ds[vt] = htp;
		else
			throw new Exception("Không tìm thấy mặt hàng cần sửa.");	
	}

	//-----------------------sắp xếp theo mã hàng---------------------------
	public void sapXepTheoMaHTP()
	{
		HangThucPham[] dsSapXep = saoChep(ds, soLuongHT);
		HangThucPham temp;
		int n = soLuongHT;
		for (int i = 0; i < n - 1; i++) 
		{
			for(int j = i + 1; j < n ; j++)
			{
				if((dsSapXep[i].getMaHang().compareTo(dsSapXep[j].getMaHang())) > 0)
				{
					temp = dsSapXep[i];
					dsSapXep[i] = dsSapXep[j];
					dsSapXep[j] = temp;
				}
			}
		}
		ds= saoChep(dsSapXep, n);
	}

	//-------------------------Tính số lượng---------------------------------
	public int tinhSoLuongHang() {
		return soLuongHT;
	}

	//-------------------------Tính tổng giá thành----------------------------
	public double tongGiaThanh() {
		double tong = 0.0;
		for (int i = 0; i < soLuongHT; i++) {
			tong += ds[i].getDonGia();
		}
		return tong;
	}

	//---------------------------lấy danh sách hàng----------------------------
	public HangThucPham[] layDS()
	{
		return ds ;
	}
}
