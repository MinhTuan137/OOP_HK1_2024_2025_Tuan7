package tuan2_NganHang;

import java.text.DecimalFormat;

public class Account {
	//------------------------các biến---------------------------
	private long soTK;
	private String tenTK;
	private double soTienTrongTK;
	private final long soTienMacDinh = 50000;

	//----------------------getter và setter---------------------
	public long getSoTK() {
		return soTK;
	}

	public void setSoTK(long soTK) {
		this.soTK = soTK;
	}

	public String getTenTK() {
		return tenTK;
	}

	public void setTenTK(String tenTK) {
		this.tenTK = tenTK;
	}

	public double getSoTienTrongTK() {
		return soTienTrongTK;
	}

	public void setSoTienTrongTK(double soTienTrongTK) {
		this.soTienTrongTK = soTienTrongTK;
	}

	//-----------------------Construtor--------------------------
	public Account(long soTK, String tenTK, double soTienTrongTK) {
		super();
		this.soTK = soTK;
		this.tenTK = tenTK;
		this.soTienTrongTK = soTienTrongTK;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(long soTK, String tenTK) {
		super();
		this.soTK = soTK;
		this.tenTK = tenTK;
		this.soTienTrongTK = soTienMacDinh;
	}

	//-----------------------toString--------------------------
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,##0.00VND");
		DecimalFormat df1 = new DecimalFormat("#");
		String strTienTrongTK = df.format(soTienTrongTK);
		String strSoTK = df1.format(soTK);
		String str = "";
		str += String.format("|%-15s|%-20s|%-20s|", strSoTK, getTenTK(), strTienTrongTK);
		return str;
	}

	//-----------Phương thức nạp tiền vào tài khoản------------
	public boolean napTien(double soTienNap) throws Exception
	{
		double tienTrongTK;
		if(soTienNap > 0)
		{
			tienTrongTK = getSoTienTrongTK();
			tienTrongTK += soTienNap;
			this.setSoTienTrongTK(tienTrongTK);
			return true;
		}
		else
		{
			try {
				throw new Exception("Số tiền không được bé hơn không");
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

	//--------------------Phương thức rút tiền-----------------
	public boolean rutTien(double soTienRut, double phiRut) throws Exception
	{
		double tienTrongTK;
		tienTrongTK = this.getSoTienTrongTK();
		if(soTienRut > 0 && (soTienRut + phiRut) < tienTrongTK)
		{
			tienTrongTK -= (soTienRut + phiRut);
			this.setSoTienTrongTK(tienTrongTK);
			return true;
		}
		else {
			try {
				throw new Exception("Số dư không đủ. Vui lòng thử lại.");
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

	//-------------------Phương thức đáo hạn-------------------
	public boolean daoHan(double tienTrongTK) throws Exception
	{
		tienTrongTK = this.getSoTienTrongTK();
		float laiSuat = (float) 0.035;
		tienTrongTK += (tienTrongTK*laiSuat);
		this.setSoTienTrongTK(tienTrongTK);
		return true;
	}

	//-----------------Phương thức chuyển khoảng----------------
	public boolean chuyenKhoang(Account taiKhoanNhan, double tienChuyenKhoan) throws Exception
	{
		if(tienChuyenKhoan > 0 )
		{
			if(tienChuyenKhoan < this.soTienTrongTK)
			{
				this.soTienTrongTK -= tienChuyenKhoan;
				taiKhoanNhan.napTien(tienChuyenKhoan);
				return true;
			}
			else
				throw new Exception("Tài khoản của bạn không đủ tiền.");
		}
		else
			throw new Exception("Số tiền nhập vào không hợp lệ. Vui lòng nhập lại.");
	}
}
