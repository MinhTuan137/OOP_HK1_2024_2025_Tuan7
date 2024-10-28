package tuan3_SinhVien;

public class DSSinhVien {
	//----------------------------các biến---------------------------------
	static SinhVien[] ds;
	public int soLuongHT = 0;

	//---------------------------contructor--------------------------------
	public DSSinhVien (int soLuong)
	{
		ds = new SinhVien[soLuong];
	}

	public DSSinhVien() {
		super();
		this.ds = new SinhVien[1];
	}

	//----------------------------get và set -------------------------------
	public int getSoLuongHT() {
		return soLuongHT;
	}

	public void setSoLuongHT(int soLuongHT) {
		this.soLuongHT = soLuongHT;
	}

	//------------------------Tăng kích thước mảng------------------------
	public void tangKichThuoc()
	{
		SinhVien temp[] = new SinhVien[ds.length*2];
		for(int i=0; i<ds.length; i++)
		{
			temp[i] = ds[i];
		}
		ds = temp;
	}

	//------------------------Sao chép mảng--------------------------------
	public SinhVien[] saoChep(SinhVien[] ds, int size)
	{
		SinhVien[] newDS = new SinhVien[size];
		for(int i = 0; i < size; i++)
		{
			newDS[i] = ds[i];
		}
		return newDS;
	}

	//-----------------------Tìm kiếm sinh viên---------------------------
	public int timViTri(int mssv)
	{
		for(int i=0; i<soLuongHT; i++)
		{
			if(mssv == ds[i].getMssv())
				return i;
		}
		return -1; 
	}

	public SinhVien timSV(int mssv)
	{
		int vt = timViTri(mssv);
		if(vt != -1)
			return ds[vt];
		else
			return null;
	}

	//------------------------Thêm sinh viên-------------------------------
	public boolean them(SinhVien sv)
	{
		if(soLuongHT == ds.length)
			tangKichThuoc();
		if(timViTri(sv.getMssv()) == -1)
		{
			ds[soLuongHT] = sv;
			soLuongHT ++;
			return true;
		}
		else
		{
			return false;
		}
	}

	//------------------------Xóa sinh viên-------------------------------
	public void xoaSV(int mssv) throws Exception
	{
		int vt = timViTri(mssv);
		if(vt != -1)
		{
			for(int i = vt; i < soLuongHT-1; i++)
			{
				ds[i] = ds[i+1];
			}
			soLuongHT--;
		}
		else
			throw new Exception("Không tìm thấy sinh viên cần xóa.");
	}

	//------------------------Sửa sinh viên-------------------------------
	public void suaSV(SinhVien sv) throws Exception
	{
		int vt = timViTri(sv.getMssv());
		if(vt != -1)
			ds[vt] = sv;
		else
			throw new Exception("Không tìm thấy sinh viên cần sửa.");	
	}

	//----------------------lấy danh sách sinh viên--------------------------
	public SinhVien[] xuatSV()
	{
		return ds;
	}

	//---------------------Sắp xếp mảng theo mã sinh viên-------------------
	public SinhVien[] sapXepMSSV()
	{
		SinhVien[] sapXepSV = saoChep(ds, soLuongHT);
		SinhVien temp;
		int n = soLuongHT;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (sapXepSV[i].getMssv() > sapXepSV[j].getMssv()) {
					temp = sapXepSV[i];
					sapXepSV[i] = sapXepSV[j];
					sapXepSV[j] = temp;
				}
			}
		}
		return ds = saoChep(sapXepSV, n);
	} 
}
