package tuan7_PhongHoc;

import java.util.ArrayList;

public interface MethodfDS {
	public boolean themPH(PhongHoc ph);
	public ArrayList<PhongHoc> layDS();
	public void xoaPhongHoc(PhongHoc ph);
	public void suaPhongHoc(PhongHoc ph);
	public PhongHoc timKiemPhongHoc(String maPH);
	public int timViTriPhongHoc(String maPH);
	public void sapXepTheoDayNha();
	public void sapXepTheoDienTich();
	public void sapXepTheoSoBongDen();
}
