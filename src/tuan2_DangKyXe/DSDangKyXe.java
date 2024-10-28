package tuan2_DangKyXe;

public class DSDangKyXe {
	private DangKyXe[] ds;
	public int soLuongHT = 0;

	public int getSoLuongHT() {
		return soLuongHT;
	}

	public void setSoLuongHT(int soLuongHT) {
		this.soLuongHT = soLuongHT;
	}

	//-----------------------constructor---------------------------
	public DSDangKyXe() {
		super();
		this.ds = new DangKyXe[1];
	}

	public DSDangKyXe(int soLuong)
	{
		ds = new DangKyXe[soLuong];
	}

	//------------------lấy toàn bộ danh sách----------------------
	public DangKyXe[] getAllDangKyXe()
	{
		return ds;
	}

	//-------------------tăng kích thước mảng----------------------
	public void TangKichThuoc()
	{
		DangKyXe temp[] = new DangKyXe[ds.length*2];
		for(int i = 0; i < ds.length; i++)
			temp[i] = ds[i];
		ds = temp;
	}

	//-------------sao chép danh sách đăng ký xe-------------------
	public DangKyXe[] saoChep(DangKyXe[] ds, int size)
	{
		DangKyXe[] newDS = new DangKyXe[size];
		for(int i = 0; i < size; i++)
		{
			newDS[i] = ds[i];
		}
		return newDS;
	}

	//--------------------thêm 1 đăng ký xe------------------------
	public boolean themXe(DangKyXe xe) {
		if (soLuongHT == ds.length)
			TangKichThuoc();

		if (timViTriXe(xe.getMaDK()) == -1) // không tìm thấy
		{
			ds[soLuongHT] = xe;
			soLuongHT++;
			return true;
		} 
		else
		{
			return false;
		}
	}

	//------------------tìm vị trí đăng ký xe----------------------
	public int timViTriXe(String maDK) 
	{
		for (int i = 0; i < soLuongHT; i++) {
			if(ds[i].getMaDK().equalsIgnoreCase(maDK))
				return i;
		}
		return -1;
	}

	//---------------------tìm đăng ký xe--------------------------
	public DangKyXe timXe(String maDK)
	{
		int vt = timViTriXe(maDK);
		if(vt != -1)
			return ds[vt];
		else
			return null;
	}

	//---------------------xóa đăng ký xe---------------------------
	public void xoaDKX(String maDK) throws Exception
	{
		int vt = timViTriXe(maDK);
		if(vt != -1)
		{
			ds[vt] = null;
			for(int i = vt; i < soLuongHT-1; i++)
			{
				ds[i] = ds[i+1];
			}
			soLuongHT--;
		}
		else
			throw new Exception("Không tìm thấy đăng ký xe cần xóa.");
	}

	//---------------------sửa 1 tài khoản-------------------------
	public void suaDKX(DangKyXe dkx) throws Exception
	{
		int vt = timViTriXe(dkx.getMaDK());
		if(vt != -1)
			ds[vt] = dkx;
		else
			throw new Exception("Không tìm thấy đăng ký xe cần sửa.");	
	}

	//--------------------sắp xếp theo số tài khoản----------------
	public void sapXepTheoMaDKX()
	{
		DangKyXe[] dsSapXep = saoChep(ds, soLuongHT);
		DangKyXe temp;
		int n = soLuongHT;
		for (int i = 0; i < n - 1; i++) 
		{
			for(int j = i + 1; j < n ; j++)
			{
				if((dsSapXep[i].getMaDK().compareTo(dsSapXep[j].getMaDK())) > 0)
				{
					temp = dsSapXep[i];
					dsSapXep[i] = dsSapXep[j];
					dsSapXep[j] = temp;
				}
			}
		}
		ds = saoChep(dsSapXep, n);
	}

	//-----------tổng tiền của danh sách tài khoản----------------
	public int tongSoDangKy()
	{
		int dem = 0;
		for(int i = 0; i < soLuongHT; i++)
		{
			dem++;
		}
		return dem;
	}
}
