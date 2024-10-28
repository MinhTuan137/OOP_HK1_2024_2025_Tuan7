package tuan2_NganHang;

public class DSAccount {
	//------------------------các biến---------------------------
	private Account[] ds;
	public int soLuongHT = 0;//hiện tai

	//-----------------------Construtor--------------------------
	public DSAccount() 
	{
		super();
		this.ds = new Account[1];
	}

	//-----------------------getter và setter---------------------
	public int getSoLuongHT()
	{
		return soLuongHT;
	}

	public void setSoLuongHT(int soLuongHT)
	{
		this.soLuongHT = soLuongHT;
	}

	public DSAccount(int soluong)
	{
		ds = new Account[soluong];
	}

	public Account[] getAllAccounts() {
		return ds;
	}

	//------------tăng kích thước của mảng nếu đầy----------------
	public void TangKichThuoc() {
		Account temp[] = new Account[ds.length * 2];
		for (int i = 0; i < ds.length; i++) {
			temp[i] = ds[i];
		}
		ds = temp;
	}

	//---------------sao chép danh sách tài khoản------------------
	public Account[] saoChepDS(Account[] ds, int size)
	{
		Account[] newDS = new Account[size];
		for(int i = 0; i < size; i++)
		{
			newDS[i] = ds[i];
		}
		return newDS;
	}

	//--------------------thêm 1 tài khoản------------------------
	public boolean them(Account ac) {
		if (soLuongHT == ds.length)
			TangKichThuoc();

		if (timKiem(ac.getSoTK()) == -1) // không tìm thấy
		{
			ds[soLuongHT] = ac;
			soLuongHT++;
			return true;
		} 
		else
		{
			return false;
		}
	}

	//--------------------tìm kiếm 1 tài khoản--------------------
	public int timKiem(long  soTK) 
	{
		for (int i = 0; i < soLuongHT; i++) {
			if (soTK == ds[i].getSoTK())
				return i;
		}
		return -1;
	}

	//--------------------lấy số tài khoản------------------------
	public Account laySoTaiKhoan(long soTK)
	{
		int timTK = timKiem(soTK);
		if(timTK != -1)
			return ds[timTK];
		else
			return null;
	}

	//---------------------xóa 1 tài khoản-------------------------
	public void xoaTK(long soTK) throws Exception
	{
		int vt = timKiem(soTK);
		if(vt != -1)
		{
			for(int i = vt; i < soLuongHT-1; i++)
			{
				ds[i] = ds[i+1];
			}
			soLuongHT--;
		}
		else
			throw new Exception("Không tìm thấy tài khoản cần xóa.");
	}

	//---------------------sửa 1 tài khoản-------------------------
	public void suaTK(Account acc) throws Exception
	{
		int vt = timKiem(acc.getSoTK());
		if(vt != -1)
			ds[vt] = acc;
		else
			throw new Exception("Không tìm thấy tài khoản cần sửa.");	
	}

	//--------------sắp xếp theo số tài khoản---------------------
	public void sapXepTheoSTK()
	{
		Account[] dsSapXep = saoChepDS(ds, soLuongHT);
		Account temp;
		int n = soLuongHT;
		for (int i = 0; i < n - 1; i++) 
		{
			for(int j = i + 1; j < n ; j++)
			{
				if(dsSapXep[i].getSoTK() > dsSapXep[j].getSoTK())
				{
					temp = dsSapXep[i];
					dsSapXep[i] = dsSapXep[j];
					dsSapXep[j] = temp;
				}
			}
		}
		ds = saoChepDS(dsSapXep, n);
	}

	//-----------tổng tiền của danh sách tài khoản----------------
	public double tongSoTien()
	{
		double tong = 0;
		for(int i = 0; i < soLuongHT; i++)
		{
			tong += ds[i].getSoTienTrongTK();
		}
		return tong;
	}
}
