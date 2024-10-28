package tuan5_GiaoDich;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class DSGiaoDich implements MethodofDS{
	ArrayList<GiaoDich> dsGD = new ArrayList<GiaoDich>();

	//-----------------------Thêm giao dịch-----------------------------
	public boolean themGD( GiaoDich gd)
	{
		if(dsGD.contains(gd))
		{
			return false;
		}
		else
		{
			dsGD.add(gd);
			return true;
		}
	}

	//-----------------------Tìm giao dịch-----------------------------
	public GiaoDich timKiemGD(String maGD)
	{
		for(GiaoDich gd: dsGD)
		{
			if(gd.getMaGD().equalsIgnoreCase(maGD))
				return gd;
		}
		return null;
	}

	//-------------------Tìm vị trí của giao dịch----------------------
	public int timViTriCuaGD(String maGD)
	{
		GiaoDich gd = timKiemGD(maGD);
		if(gd != null)
			return dsGD.indexOf(gd);
		return -1;
	}

	//-----------------------Sửa giao dịch-----------------------------
	public void suaGD(GiaoDich suaGD)
	{
		int vt = dsGD.indexOf(suaGD);
		if(vt != -1)
		{
			dsGD.set(vt, suaGD);
		}
	}

	//-----------------------Xóa giao dịch-----------------------------
	public void xoaGD(GiaoDich gd)
	{
		dsGD.remove(gd);
	}

	//-------------------Lấy danh sách giao dịch-----------------------
	public ArrayList<GiaoDich> layHetGD()
	{
		return dsGD;
	}

	//-----------------Lấy danh sách giao dịch vàng--------------------
	public ArrayList<GiaoDich> layGDVang()
	{
		ArrayList<GiaoDich> dsGDVang = new ArrayList<GiaoDich>();
		for(GiaoDich gd: dsGD)
		{
			if( gd instanceof Vang)
				dsGDVang.add(gd);
		}
		return dsGDVang;
	}

	//---------------Lấy danh sách giao dịch tiền tệ------------------
	public ArrayList<GiaoDich> layGDTienTe()
	{
		ArrayList<GiaoDich> dsGDTienTe = new ArrayList<GiaoDich>();
		for(GiaoDich gd: dsGD)
		{
			if(gd instanceof TienTe)
				dsGDTienTe.add(gd);
		}
		return dsGDTienTe;
	}

	//---------------Tính số lượng giao dịch vàng----------------------
	public double tongSoLuongGDVang()
	{
		double tong = 0;
		for(GiaoDich gd : dsGD)
		{
			if(gd instanceof Vang)
				tong += gd.soLuong;
		}
		return tong;
	}

	//---------------Tính số lượng giao dịch tiền tệ--------------------
	public double tongSoLuongGDTienTe()
	{
		double tong = 0;
		for(GiaoDich gd : dsGD)
		{
			if(gd instanceof TienTe)
				tong += gd.soLuong;
		}
		return tong;
	}

	//---------------Tính thành tiền của giao dịch----------------------
	public double tongSoThanhTienGD()
	{
		double thanhTien = 0;
		for(GiaoDich gd: dsGD)
		{
			thanhTien += gd.thanhTien();
		}
		return thanhTien;
	}

	//------Tính trung bình thành tiền của giao dịch tiền tệ------------
	public double tbThanhTienGDTienTe()
	{
		double thanhTien = 0;
		int dem = 0;
		for(GiaoDich gd : dsGD)
		{
			if(gd instanceof TienTe)
			{
				thanhTien += gd.thanhTien();
				dem++;
			}
		}
		return thanhTien/dem;
	}

	//--------------Lấy danh sách giao dịch trên 1 tỷ-------------------
	public ArrayList<GiaoDich> gdGiaHon1Ty()
	{
		ArrayList<GiaoDich> dsGDTy = new ArrayList<GiaoDich>();
		for(GiaoDich gd: dsGD)
		{
			if(gd.donGia > 1000000000)
				dsGDTy.add(gd);
		}
		return dsGDTy;
	}

	//--------------------Sắp xếp theo mã giao dịch------------------------
	public void sapXepTheoMaGD()
	{
		Collections.sort(dsGD, new Comparator<GiaoDich>() {
			@Override
			public int compare(GiaoDich o1, GiaoDich o2) {
				String maGD1 = o1.getMaGD();
				String maGD2 = o2.getMaGD();
				return maGD1.compareToIgnoreCase(maGD2);
			}
		});
	}

	//------------------Sắp xếp theo ngày và số lượng----------------------
	public void sapXepTheoNgayVaSL()
	{
		Collections.sort(dsGD, new Comparator<GiaoDich>() {
			@Override
			public int compare(GiaoDich o1, GiaoDich o2) {
				Date ngay1 = o1.getNgayGD();
				Date ngay2 = o2.getNgayGD();
				int temp = ngay1.compareTo(ngay2);
				if(temp == 0)
				{
					Integer sl1 = o1.getSoLuong();
					Integer sl2 = o2.getSoLuong();
					return sl1.compareTo(sl2);
				}
				return temp;
			}
		});
	}
}
