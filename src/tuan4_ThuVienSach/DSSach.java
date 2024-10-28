package tuan4_ThuVienSach;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class DSSach {
	ArrayList<Sach> dsSach = new ArrayList<Sach>();

	// ----------------------Them sach-----------------------
	public boolean themSach(Sach s) {
		if(dsSach.contains(s))    //Trung ma
			return false;
		else
		{
			dsSach.add(s);
			return true;
		}
	}

	//-------------------Tim kiem doi tuong---------------------
	public Sach timKiemDoiTuong(String maSach)
	{
		for(Sach s: dsSach)
		{
			if(s.getMaSach().equalsIgnoreCase(maSach))
			{
				return s;
			}
		}
		return null;
	}

	//---------------------Tim kiem vi tri----------------------
	public int timKiemViTri(String maSach)
	{
		Sach timSach = timKiemDoiTuong(maSach);
		if(timSach != null)
			return dsSach.indexOf(timSach);
		return -1;
	}

	//----------------------Sua sach---------------------------
	public void suaSach(Sach sachSua)
	{
		int vt = dsSach.indexOf(sachSua);
		if(vt != -1)
			dsSach.set(vt, sachSua);
	}

	//----------------------Xoa sach----------------------------
	public void xoaSach(Sach sachXoa)
	{
		dsSach.remove(sachXoa);
	}

	//----------------Tra ve toan bo danh sach------------------
	public ArrayList<Sach> getHetSach()
	{
		return dsSach;
	}

	//------------Tra ve danh sach sach giao khoa----------------
	public ArrayList<Sach> getDSSachGK()
	{
		ArrayList<Sach> dsSachGK = new ArrayList<Sach>();
		for(Sach s: dsSach)
		{
			if(s instanceof SachGiaoKhoa)
			{
				dsSachGK.add(s);
			}
		}
		return dsSachGK;
	}

	//------------Tra ve danh sach sach tham khao----------------
	public ArrayList<Sach> getDSSachTK()
	{
		ArrayList<Sach> dsSachTK = new ArrayList<Sach>();
		for(Sach s: dsSach)
		{
			if(s instanceof SachThamKhao)
			{
				dsSachTK.add(s);
			}
		}
		return dsSachTK;
	}

	//-----------------Sap xep theo gia tien----------------------
	public void sortGiaTien()
	{
		Collections.sort(dsSach, new Comparator<Sach>() {
			@Override
			public int compare(Sach o1, Sach o2) {
				Double gia1 = o1.getDonGia();
				Double gia2 = o2.getDonGia();
				return gia1.compareTo(gia2);
			}
		});
	}

	//---------------Sap xep theo ngay va so luong-----------------
	public void sortNgayVaSL()
	{
		Collections.sort(dsSach, new Comparator<Sach>() {
			@Override
			public int compare(Sach o1, Sach o2) {
				Date ngay1 = o1.getNgayNhap();
				Date ngay2 = o2.getNgayNhap();
				int comp = ngay1.compareTo(ngay2);
				if(comp == 0) //Bang nhau
				{
					Integer sl1 = o1.getSoLuong();
					Integer sl2 = o2.getSoLuong();
					return sl1.compareTo(sl2);
				}
				return comp;
			}
		});
	}

	//---------------------Tong so tien----------------------------
	public double getTongSoTien()
	{
		double tt = 0;
		for(Sach s: dsSach)
		{
			tt += s.thanhTien();
		}
		return tt;
	}

	//-------------------Tong tien sach giao khoa-------------------
	public double getTongTienSGK()
	{
		double tt = 0;
		for(Sach s: dsSach)
		{
			if(s instanceof SachGiaoKhoa)
			{
				tt += s.thanhTien();
			}
		}
		return tt;
	}

	//-------------------Tong tien sach tham khảo-------------------
	public double getTongTienSTK()
	{
		double tt = 0;
		for(Sach s: dsSach)
		{
			if(s instanceof SachThamKhao)
			{
				tt += s.thanhTien();
			}
		}
		return tt;
	}
}
