package tuan2_DangKyXe;

import java.text.DecimalFormat;

public class DangKyXe {
	//-------------------------các biến------------------------
	String maDK;
	String chuXe;
	String loaiXe;
	int dungTich;
	float triGia;

	//------------------------getter & setter------------------
	public String getMaDK() {
		return maDK;
	}

	public void setMaDK(String maDK) {
		this.maDK = maDK;
	}

	public String getChuXe() {
		return chuXe;
	}

	public void setChuXe(String chuXe) {
		this.chuXe = chuXe;
	}
	public String getLoaiXe() {
		return loaiXe;
	}
	public void setLoaiXe(String loaiXe) {
		this.loaiXe = loaiXe;
	}
	public int getDungTich() {
		return dungTich;
	}
	public void setDungTich(int dungTich) {
		this.dungTich = dungTich;
	}
	public float getTriGia() {
		return triGia;
	}
	public void setTriGia(float triGia) {
		this.triGia = triGia;
	}

	//------------------------constructor------------------------
	public DangKyXe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DangKyXe(String maDK, String chuXe, String loaiXe, int dungTich, float triGia) {
		super();
		this.maDK = maDK;
		this.chuXe = chuXe;
		this.loaiXe = loaiXe;
		this.dungTich = dungTich;
		this.triGia = triGia;
	}

	//------------------------Thue Phai Nop-----------------------
	public float thuePhaiNop() {
		int dTich;
		float tGia, thue;
		dTich = this.dungTich;
		tGia = this.triGia;
		if(dTich < 100)
			thue = (float) (tGia*0.01);
		else if(dTich <= 200)
			thue = (float) (tGia*0.03);
		else
			thue = (float) (tGia*0.05);
		return thue;
	}

	//------------------------toString---------------------------
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,##0.00VND");
		DecimalFormat df1 = new DecimalFormat("#");
		String strDungTich = df1.format(dungTich);
		String strTriGia = df.format(triGia);
		String strThue = df.format(thuePhaiNop());
		return String.format("|%-20s|%-20s|%-15s|%-15s|%-20s|%20s|", getMaDK(), getChuXe(), getLoaiXe(), strDungTich, strTriGia, strThue);
	}
}
