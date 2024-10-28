package tuan4_ChuyenXe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DSChuyenXe {
	//------------------------------Các danh sách-----------------------------------
	ArrayList<ChuyenXe> dsChuyenXe = new ArrayList<ChuyenXe>();

	//---------------------------Thêm chuyến xe ---------------------------------
	public boolean themChuyenXe(ChuyenXe cx) {
		if(dsChuyenXe.contains(cx))
		{
			return false;
		}
		else
		{
			dsChuyenXe.add(cx);
			return true;
		}
	}

	//----------------------Tìm kiếm chuyến xe-----------------------------------
	public ChuyenXe timKiemChuyenXe(String maChuyenXe)
	{
		for(ChuyenXe cx : dsChuyenXe)
		{
			if(cx.getMaChuyenXe().equalsIgnoreCase(maChuyenXe))
				return cx;
		}
		return null;
	}

	//----------------------Tìm kiếm vị trí chuyến xe-----------------------------
	public int timViTriCX(String maChuyenXe)
	{
		ChuyenXe cx = timKiemChuyenXe(maChuyenXe);
		if(cx != null)
			return dsChuyenXe.indexOf(cx);
		return -1;
	}

	//---------------------------Xóa chuyến xe------------------------------------
	public void xoaCX(ChuyenXe cx)
	{
		dsChuyenXe.remove(cx);
	}

	//-----------------------------Sửa chuyến xe-----------------------------------
	public void suaCX(ChuyenXe cx)
	{
		int vt = dsChuyenXe.indexOf(cx);
		if(vt != -1)
			dsChuyenXe.set(vt, cx);
	}

	//--------------------Sắp xếp chuyến xe theo mã chuyến xe----------------------
	public void sapXepTheoMaCX()
	{
		Collections.sort(dsChuyenXe, new Comparator<ChuyenXe>() {
			@Override
			public int compare(ChuyenXe o1, ChuyenXe o2) {
				String maCX1 = o1.getMaChuyenXe();
				String maCX2 = o2.getMaChuyenXe();
				return maCX1.compareTo(maCX2);
			}
		});
	}

	//-----------------------Xuất danh sách chuyến xe nội thành---------------------
	public ArrayList<ChuyenXe> xuatDSNoiThanh() {
		ArrayList<ChuyenXe> dsNoiThanh = new ArrayList<ChuyenXe>();
		for (ChuyenXe cx : dsChuyenXe) {
			if(cx instanceof NoiThanh)
			{
				dsNoiThanh.add(cx);
			}
		}
		return dsNoiThanh;
	}

	//-----------------------Xuất danh sách chuyến xe ngoại thành---------------------
	public ArrayList<ChuyenXe> xuatDSNgoaiThanh() {
		ArrayList<ChuyenXe> dsNgoaiThanh = new ArrayList<ChuyenXe>();
		for (ChuyenXe cx : dsChuyenXe) {
			if(cx instanceof NgoaiThanh) {
				dsNgoaiThanh.add(cx);
			}
		}
		return dsNgoaiThanh;
	}

	//---------------------------Xuất toàn bộ danh sách ------------------------------
	public ArrayList<ChuyenXe> xuatDS()
	{
		return dsChuyenXe;
	}

	//-----------------------Tính tổng doanh thu nội thành---------------------------
	public double tongDoanhThuNoiThanh() {
		double sum = 0;
		for (ChuyenXe cx : dsChuyenXe) {
			if(cx instanceof NoiThanh)
			{
				sum = sum + cx.getDoanhThu();
			}
		}
		return sum;
	}

	//-----------------------Tính tổng doanh thu ngoại thành--------------------------
	public double tongDoanhThuNgoaiThanh() {
		double sum = 0;
		for (ChuyenXe cx: dsChuyenXe) {
			if(cx instanceof NgoaiThanh)
			{
				sum = sum + cx.getDoanhThu();
			}
		}
		return sum;
	}
}
