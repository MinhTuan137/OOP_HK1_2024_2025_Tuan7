package quanLyPhongHoc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DSPhongHoc {
	ArrayList<PhongHoc> ds = new ArrayList<PhongHoc>();
	
	public boolean themPH(PhongHoc ph)
	{
		if(ds.contains(ph))
			return false;
		else
		{
			ds.add(ph);
			return true;
		}
	}
	
	public PhongHoc timPH(String maPH)
	{
		for(PhongHoc ph: ds)
		{
			if(ph.getMaPhong().equalsIgnoreCase(maPH))
				return ph;
		}
		return null;
	}
	
	public int timViTriPH(String maPH)
	{
		PhongHoc ph = timPH(maPH);
		if(ph != null)
			return ds.indexOf(ph);
		return -1;
	}
	
	public ArrayList<PhongHoc> laDS()
	{
		return ds;
	}
	
	public ArrayList<PhongHoc> layPhongLyThuyet()
	{
		ArrayList<PhongHoc> dsLT = new ArrayList<PhongHoc>();
		for(PhongHoc ph: ds)
		{
			if(ph instanceof PhongLyThuet)
				dsLT.add(ph);
		}
		return dsLT;
	}
	
	public ArrayList<PhongHoc> layPhongMayTinh()
	{
		ArrayList<PhongHoc> dsMT = new ArrayList<PhongHoc>();
		for(PhongHoc ph: ds)
		{
			if(ph instanceof PhongMayTinh)
				dsMT.add(ph);
		}
		return dsMT;
	}
	
	public ArrayList<PhongHoc> layPhongThiNghiem()
	{
		ArrayList<PhongHoc> dsTN = new ArrayList<PhongHoc>();
		for(PhongHoc ph: ds)
		{
			if(ph instanceof PhongThiNghiem)
				dsTN.add(ph);
		}
		return dsTN;
	}
	
	public ArrayList<PhongHoc> layPhongDatChuan()
	{
		ArrayList<PhongHoc> dsDC = new ArrayList<PhongHoc>();
		for(PhongHoc ph: ds)
		{
			if(ph.danhGia() == "Đạt chuẩn")
				dsDC.add(ph);
		}
		return dsDC;
	}
	
	public ArrayList<PhongHoc> layPhong60MT()
	{
		ArrayList<PhongHoc> dsMT = new ArrayList<PhongHoc>();
		for(PhongHoc ph: ds)
		{
			if(ph instanceof PhongMayTinh)
				if(((PhongMayTinh) ph).getSoMayTinh() == 60)
					dsMT.add(ph);
		}
		return dsMT;
	}
	
	public void sapXepTheoDayNha()
	{
		Collections.sort(ds, new Comparator<PhongHoc>() {
			@Override
			public int compare(PhongHoc o1, PhongHoc o2) {
				String dayNha1 = o1.getDayNha();
				String dayNha2 = o2.getDayNha();
				return dayNha1.compareTo(dayNha2);
			}
		});
	}
	
	public void sapXepTheoDienTich()
	{
		Collections.sort(ds, new Comparator<PhongHoc>() {
			@Override
			public int compare(PhongHoc o1, PhongHoc o2) {
				Float S1 = o1.getDienTich();
				Float S2 = o2.getDienTich();
				return S1.compareTo(S2);
			}
		});
	}
	
	public void sapXepTheoSoBongDen()
	{
		Collections.sort(ds, new Comparator<PhongHoc>() {
			@Override
			public int compare(PhongHoc o1, PhongHoc o2) {
				Integer soBongDen1 = o1.getSoBongDen();
				Integer soBongDen2 = o2.getSoBongDen();
				return soBongDen1.compareTo(soBongDen2);
			}
		});
	}
	
	public void xoaPH(PhongHoc ph)
	{
		ds.remove(ph);
	}
	
	public void suaPH(PhongHoc ph)
	{
		int vt = ds.indexOf(ph);
		if(vt != -1)
			ds.set(vt, ph);
	}
	
	public int tongPH()
	{
		int tong = 0;
		for(PhongHoc ph: ds)
		{
			tong++;
		}
		return tong;
	}
}
