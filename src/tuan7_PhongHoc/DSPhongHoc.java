package tuan7_PhongHoc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DSPhongHoc implements MethodfDS{
	ArrayList<PhongHoc> dsPH = new ArrayList<PhongHoc>();

	//--------------------------Thêm phòng học----------------------------
	public boolean themPH(PhongHoc ph)
	{
		if(dsPH.contains(ph))
			return false;
		else
		{
			dsPH.add(ph);
			return true;
		}
	}

	//--------------------------Tìm phòng học----------------------------
	public PhongHoc timKiemPhongHoc(String maPH)
	{
		for(PhongHoc ph : dsPH)
		{
			if(ph.getMaPhong().equalsIgnoreCase(maPH))
				return ph;
		}
		return null;
	}

	//--------------------Tìm vị trí của phòng học------------------------
	public int timViTriPhongHoc(String maPH)
	{
		PhongHoc ph = timKiemPhongHoc(maPH);
		if(ph != null)
		{
			return dsPH.indexOf(ph);
		}
		return -1;
	}

	//--------------------------Xóa phòng học----------------------------
	public void xoaPhongHoc(PhongHoc ph)
	{
		dsPH.remove(ph);
	}

	//--------------------------Sửa phòng học----------------------------
	public void suaPhongHoc(PhongHoc ph)
	{
		int vt = dsPH.indexOf(ph);
		if(vt != -1)
			dsPH.set(vt, ph);
	}

	//--------------------------Lấy tất cả phòng học----------------------------
	public ArrayList<PhongHoc> layDS()
	{
		return dsPH;
	}

	//-------------------------Lấy phòng lý thuyết-------------------------------
	public ArrayList<PhongHoc> layPhongLyThuyet()
	{
		ArrayList<PhongHoc> dsPLT = new ArrayList<PhongHoc>();
		for(PhongHoc ph : dsPH)
		{
			if(ph instanceof PhongLyThuyet)
				dsPLT.add(ph);
		}
		return dsPLT;
	}

	//---------------------------Lấy phòng máy tình-------------------------------
	public ArrayList<PhongHoc> layPhongMayTinh()
	{
		ArrayList<PhongHoc> dsPMT = new ArrayList<PhongHoc>();
		for(PhongHoc ph : dsPH)
		{
			if(ph instanceof PhongMayTinh)
				dsPMT.add(ph);
		}
		return dsPMT;
	}

	//---------------------------Lấy phòng thí nghiệm-------------------------------
	public ArrayList<PhongHoc> layPhongThiNghiem()
	{
		ArrayList<PhongHoc> dsPTN = new ArrayList<PhongHoc>();
		for(PhongHoc ph : dsPH)
		{
			if(ph instanceof PhongThiNghiem)
				dsPTN.add(ph);
		}
		return dsPTN;
	}

	//---------------------------Lấy phòng đạt chuẩn-------------------------------
	public ArrayList<PhongHoc> layPhongDatChuan()
	{
		ArrayList<PhongHoc> dsPDC = new ArrayList<PhongHoc>();
		for(PhongHoc ph : dsPH)
		{
			if(ph.danhGia() == "Đạt chuẩn")
				dsPDC.add(ph);
		}
		return dsPDC;
	}

	//-----------------------Lấy phòng có 60 máy tính-----------------------------
	public ArrayList<PhongHoc> layPhong60MayTinh()
	{
		ArrayList<PhongHoc> dsPMT = new ArrayList<PhongHoc>();
		for(PhongHoc ph : dsPH)
		{
			if(ph instanceof PhongMayTinh)
				if(((PhongMayTinh) ph).getSoMayTinh() == 60)
					dsPMT.add(ph);
		}
		return dsPMT;
	}

	//----------------------Sắp xếp danh sách theo dãy nhà-------------------------
	public void sapXepTheoDayNha()
	{
		Collections.sort(dsPH, new Comparator<PhongHoc>() {
			@Override
			public int compare(PhongHoc o1, PhongHoc o2) {
				String dayNha1 = o1.getDayNha();
				String dayNha2 = o2.getDayNha();
				return dayNha1.compareTo(dayNha2);
			}
		});
	}

	//----------------------Sắp xếp danh sách theo diện tích-------------------------
	public void sapXepTheoDienTich()
	{
		Collections.sort(dsPH, new Comparator<PhongHoc>() {
			@Override
			public int compare(PhongHoc o1, PhongHoc o2) {
				Float dienTich1 = o1.getDienTich();
				Float dienTich2 = o2.getDienTich();
				return dienTich1.compareTo(dienTich2);
			}
		});
	}

	//--------------------Sắp xếp danh sách theo số bóng đèn-------------------------
	public void sapXepTheoSoBongDen()
	{
		Collections.sort(dsPH, new Comparator<PhongHoc>() {
			@Override
			public int compare(PhongHoc o1, PhongHoc o2) {
				Integer soBongDen1 = o1.getSoBongDen();
				Integer soBongDen2 = o2.getSoBongDen();
				return soBongDen1.compareTo(soBongDen2);
			}
		});
	}

	//-----------------------------Tổng số phòng học--------------------------------
	public int tongSoPhong()
	{
		int dem = 0;
		for(PhongHoc ph: dsPH)
		{
			dem++;
		}
		return dem;
	}
}
