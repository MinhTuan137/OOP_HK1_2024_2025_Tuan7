package tuan3_CD;

public class DSCD {
	//-------------------------------các biến--------------------------------
	private CD[] dsCD;
	public int soLuongCD = 0;

	public int getSoLuongCD() {
		return soLuongCD;
	}

	public void setSoLuongCD(int soLuongCD) {
		this.soLuongCD = soLuongCD;
	}

	//----------------------------constructor--------------------------------
	public DSCD() {
		super();
		this.dsCD = new CD[1];
	}

	public DSCD(int soLuong)
	{
		dsCD = new CD[soLuong];
	}

	//------------------------Tăng kích thước mảng---------------------------
	public void tangKichThuoc() throws Exception {
		CD temp[] = new CD[dsCD.length * 2];
		for (int i = 0; i < dsCD.length; i++) {
			temp[i] = dsCD[i];
		}
		dsCD = temp;
	}

	//--------------------Tìm kiếm vị trí CD theo mã CD------------------------
	public int timKiem(int maCD) throws Exception
	{
		for (int i = 0; i < soLuongCD; i++) {
			if (maCD == dsCD[i].getMaCD())
				return i;
		}
		return -1;
	}

	//------------------------sao chép danh sách CD-----------------------------
	public CD[] saoChepDSCD(CD[] ds, int size)
	{
		CD[] newDS = new CD[size];
		for(int i = 0; i < size; i++)
		{
			newDS[i] = ds[i];
		}
		return newDS;
	}

	//-----------------------Tìm kiếm CD theo mã CD---------------------------
	public CD timCD(int maCD) throws Exception
	{
		int vt = timKiem(maCD);
		if(vt != -1)
			return dsCD[vt];
		else
			return null;
	}

	//-----------------------------thêm CD--- -------------------------------
	public boolean them(CD cd) throws Exception 
	{
		if (soLuongCD == dsCD.length)
			tangKichThuoc();
		if (timKiem(cd.getMaCD()) == -1) // Không tìm thấy mã trùng
		{
			dsCD[soLuongCD] = cd;
			soLuongCD++;
			return true;
		} 
		else 
		{
			return false;
		}
	}

	//----------------------------xóa 1 CD-----------------------------------
	public void xoaCD(int maCD) throws Exception
	{
		int vt = timKiem(maCD);
		if(vt != -1)
		{
			for(int i = vt; i < soLuongCD - 1; i++)
			{
				dsCD[i] = dsCD[i+1];
			}
			soLuongCD--;
		}
		else
			throw new Exception("Không tìm thấy CD cần xóa.");
	}

	//--------------------------sửa 1 CD--------------------------------------
	public void suaCD(CD cd) throws Exception
	{
		int vt = timKiem(cd.getMaCD());
		if(vt != -1)
		{
			dsCD[vt] = cd;
		}	
		else
			throw new Exception("Không tìm thấy CD cần sửa.");	
	}

	//-------------------------Tính số lượng---------------------------------
	public int tinhSoLuongCD() 
	{
		return soLuongCD;
	}

	//-------------------------Tính tổng giá thành----------------------------
	public double tongGiaThanh() 
	{
		double tong = 0.0;
		for (int i = 0; i < soLuongCD; i++) {
			tong += dsCD[i].getGiaThanh();
		}
		return tong;
	}

	//-------------------------Sắp xếp CD theo giá thành-----------------------
	public void sapXepTheoGiaThanh()
	{
		CD[] newDS = saoChepDSCD(dsCD, soLuongCD);
		CD temp;
		int n = soLuongCD;
		for (int i = 0; i < n - 1; i++) 
		{
			for(int j = i + 1; j < n ; j++)
			{
				if(newDS[i].getGiaThanh() < newDS[j].getGiaThanh())
				{
					temp = newDS[i];
					newDS[i] = newDS[j];
					newDS[j] = temp;
				}
			}
		}
		dsCD = saoChepDSCD(newDS, n);
	}

	//-------------------------Sắp xếp CD theo tựa CD-------------------------
	public void sapXepTangTuaCD() {
		CD[] newDS = saoChepDSCD(dsCD, soLuongCD);
		CD temp; 
		int n = soLuongCD;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (newDS[i].getTuaCD().compareTo(newDS[j].getTuaCD()) > 0) {
					temp = newDS[i];
					newDS[i] = newDS[j];
					newDS[j] = temp;
				}
			}
		}
		dsCD = saoChepDSCD(newDS, n);
	}

	//-------------------------Lấy danh sách CD-------------------------------
	public CD[] layDS() {
		return dsCD;
	}
}
