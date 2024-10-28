package tuan5_HangHoa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DSHangHoa implements MethodofDS{
	ArrayList<HangHoa> ds = new ArrayList<HangHoa>();

	//-------------------------Thêm hàng hóa----------------------------
	public boolean themHangHoa(HangHoa hh)
	{
		if(ds.contains(hh) )
			return false;
		else
		{
			ds.add(hh);
			return true;
		}
	}

	//----------------------Tìm kiếm hàng hóa----------------------------
	public HangHoa timKiemHangHoa(String maHH)
	{
		for(HangHoa hh : ds)
		{
			if(hh.getMaHang().equalsIgnoreCase(maHH))
				return hh;
		}
		return null;
	}

	//-------------------Tìm vị trí của hàng hóa--------------------------
	public int timViTriHangHoa(String maHH)
	{
		HangHoa hh = timKiemHangHoa(maHH);
		if(hh != null)
		{
			return ds.indexOf(hh);
		}
		return -1;
	}

	//-------------------------Xóa hàng hóa----------------------------
	public void xoaHangHoa(HangHoa hh)
	{
		ds.remove(hh);
	}

	//-------------------------Sửa hàng hóa----------------------------
	public void suaHangHoa(HangHoa hh)
	{
		int vt = ds.indexOf(hh);
		if(vt != -1)
			ds.set(vt, hh);
	}

	//-------------------lấy toàn bộ danh sách-------------------------
	public ArrayList<HangHoa> layHetDS()
	{
		return ds;
	}

	//----------------lấy danh sách hàng thực phẩm----------------------
	public ArrayList<HangHoa> layHangThucPham()
	{
		ArrayList<HangHoa> dsHTP = new ArrayList<HangHoa>();
		for(HangHoa hh : ds)
		{
			if(hh instanceof HangThucPham)
				dsHTP.add(hh);
		}
		return dsHTP;
	}

	//-------------------lấy danh sách hàng sành sứ----------------------
	public ArrayList<HangHoa> layHangSanhSu()
	{
		ArrayList<HangHoa> dsHSS = new ArrayList<HangHoa>();
		for(HangHoa hh : ds)
		{
			if( hh instanceof HangSanhSu)
				dsHSS.add(hh);
		}
		return dsHSS;
	}

	//-------------------lấy danh sách hàng điện máy---------------------
	public ArrayList<HangHoa> layHangDienMay()
	{
		ArrayList<HangHoa> dsHDM = new ArrayList<HangHoa>();
		for(HangHoa hh : ds)
		{
			if(hh instanceof HangDienMay)
				dsHDM.add(hh);
		}
		return dsHDM;
	}

	//-------------------Sắp xếp danh sách theo mã-------------------------
	public void sapXepTheoMaHang()
	{
		Collections.sort(ds, new Comparator<HangHoa>() {
			@Override
			public int compare(HangHoa o1, HangHoa o2) {
				String maHH1 = o1.getMaHang();
				String maHH2 = o2.getMaHang();
				return maHH1.compareTo(maHH2);
			}
		});
	}

	//---------------Sắp xếp danh sách theo sl và đơn giá-------------------
	public void sapXepTheoSLTonVaDonGia()
	{
		Collections.sort(ds, new Comparator<HangHoa>() {
			@Override
			public int compare(HangHoa o1, HangHoa o2) {
				Integer sl1 = o1.getSoLuongTon();
				Integer sl2 = o2.getSoLuongTon();
				int temp = sl1.compareTo(sl2);
				if(temp == 0)
				{
					Double donGia1 = o1.getDonGia();
					Double donGia2 = o2.getDonGia();
					return donGia1.compareTo(donGia2);
				}
				return sl1.compareTo(sl2);
			}
		});
	}

	//------------------Tổng số lượng tồn hàng thực phẩm---------------------
	public int tongSLTonHTP()
	{
		int tong = 0;
		for(HangHoa hh : ds)
		{
			if(hh instanceof HangThucPham)
				tong += hh.soLuongTon;
		}
		return tong;
	}

	//------------------Tổng số lượng tồn hàng sành sứ---------------------
	public int tongSLTonHSS()
	{
		int tong = 0;
		for(HangHoa hh : ds)
		{
			if(hh instanceof HangSanhSu)
				tong += hh.soLuongTon;
		}
		return tong;
	}

	//------------------Tổng số lượng tồn hàng điện máy---------------------
	public int tongSLTonHDM()
	{
		int tong = 0;
		for(HangHoa hh : ds)
		{
			if(hh instanceof HangDienMay)
				tong += hh.soLuongTon;
		}
		return tong;
	}
}
