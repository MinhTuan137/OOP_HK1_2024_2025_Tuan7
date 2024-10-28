package tuan4_ChuyenXe;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Scanner;

public class TestChuyenXe {
	static DSChuyenXe dscx = new DSChuyenXe();
	static Scanner sc = new Scanner(System.in);

	//--------------------------Nhập dữ liệu------------------------------
	public static String nhapChuoi(String thongbao)
	{
		String str;
		System.out.println(thongbao);
		str = sc.nextLine();
		return str;
	}

	public static int nhapSoNguyen(String thongbao)
	{
		int n;
		System.out.println(thongbao);
		n = sc.nextInt();
		return n;
	}

	public static double nhapSoThuc(String thongbao) {
		double n;
		System.out.println(thongbao);
		n = sc.nextDouble();
		return n;
	}

	//------------------------Nhập thông tin chuyến xe-------------------
	public static ChuyenXe nhapChuyenXe() {
		ChuyenXe cx = null;
		try
		{
			int chon;
			String maCX = nhapChuoi("Nhập mã chuyến xe: ");
			int vt = dscx.timViTriCX(maCX);
			if(vt != -1)
			{
				System.out.println("Trùng mã.");
				return null;
			}
			else
			{
				String hoTen = nhapChuoi("Nhập họ tên tài xế: ");
				int soXe = nhapSoNguyen("Nhập số xe: ");
				double doanhThu = nhapSoThuc("Nhập doanh thu: ");
				System.out.println("Nhập 1 nếu là xe nội thành hay nhập số khác nếu là xe ngoại thành.");
				chon = sc.nextInt();
				if(chon == 1)
				{
					int soTuyen = nhapSoNguyen("Nhập số tuyến: ");
					double soKM = nhapSoThuc("Nhập số km: ");
					cx = new NoiThanh(maCX, hoTen, soXe, doanhThu, soTuyen, soKM);
				}
				else
				{
					String noiDen = nhapChuoi("Nhập nơi đến: ");
					int soNgayDiDuoc = nhapSoNguyen("Nhập số ngày đi được: ");
					cx = new NgoaiThanh(maCX, hoTen, soXe, doanhThu, noiDen, soNgayDiDuoc);
				}
			}
			System.out.println("Thêm chuyến xe thành công.");
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return cx;
	}

	//---------------------Nhập cứng danh sách chuyến xe-------------------
	public static void nhapCung()
	{
		ChuyenXe cx1 = new NoiThanh("1870", "Nguyễn Văn Hùng", 25, 10000000, 10, 250);
		ChuyenXe cx2 = new NoiThanh("1281", "Nguyễn Hùng Văn", 99, 15000000, 20, 150);
		ChuyenXe cx3 = new NgoaiThanh("3187", "Nguyễn Quốc An", 13, 100000000, "Hà Nội", 60);
		ChuyenXe cx4 = new NgoaiThanh("1876", "Nguyễn Văn Việt", 88, 50000000, "Tp Hồ Chí Minh", 50);
		dscx.themChuyenXe(cx1);
		dscx.themChuyenXe(cx2);
		dscx.themChuyenXe(cx3);
		dscx.themChuyenXe(cx4);
		System.out.println("Thêm danh sách thành công.");
	}

	//------------------------------Thêm chuyến xe-------------------------------
	public static void themChuyenXe()
	{
		ChuyenXe cx = nhapChuyenXe();
		dscx.themChuyenXe(cx);
	}

	//---------------------------Sửa chuyến xe-----------------------------------
	public static void suaCX() throws Exception
	{
		int chon, daSua = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập chuyến xe cần sửa: ");
		String maCX = sc.nextLine();
		ChuyenXe cx = dscx.timKiemChuyenXe(maCX);
		if(cx != null)
		{
			System.out.println("Thông tin của chuyến xe trước khi sửa.");
			if(cx instanceof NoiThanh)
			{
				System.out.println(tieuDeNoiThanh());
				System.out.println("*******************************************************************************************************************************");
				System.out.println(cx);
				System.out.println("*******************************************************************************************************************************");
				NoiThanh suaNT = (NoiThanh) cx;
				do
				{
					menuSuaNoiThanh();
					System.out.println("Nhập lựa chọn của bạn: ");
					chon = sc.nextInt();
					daSua++;
					menuThucHienSua(chon, suaNT);
					if(chon == 4)
					{
						int soTuyen = nhapSoNguyen("Nhập số tuyến: ");
						suaNT.setSoTuyen(soTuyen);
					}
					if(chon == 5)
					{
						double soKM = nhapSoThuc("Nhập số km: ");
						suaNT.setSoKm(soKM);
					}
					if(chon == 6)
					{
						if(daSua >= 1)
							dscx.suaCX(suaNT);
						System.out.println("Đã sửa chuyến xe này thành công.");
					}
				}
				while(chon < 6);
			}

			if(cx instanceof NgoaiThanh)
			{
				System.out.println(tieuDeNgoaiThanh());
				System.out.println("*******************************************************************************************************************************");
				System.out.println(cx);
				System.out.println("*******************************************************************************************************************************");
				NgoaiThanh suaNgT = (NgoaiThanh) cx;
				do
				{
					menuSuaNgoaiThanh();
					System.out.println("Nhập lựa chọn của bạn: ");
					chon = sc.nextInt();
					daSua++;
					menuThucHienSua(chon, suaNgT);
					if(chon == 4)
					{
						String noiDen = nhapChuoi("Nhập nơi đến: ");
						suaNgT.setNoiDen(noiDen);
					}
					if(chon == 5)
					{
						int soNgayDiDuoc = nhapSoNguyen("Nhập số ngày đi được: ");
						suaNgT.setSoNgayDiDuoc(soNgayDiDuoc);
					}
					if(chon == 6)
					{
						if(daSua >= 1)
							dscx.suaCX(suaNgT);
						System.out.println("Đã sửa chuyến xe này thành công.");
					}
				}
				while(chon < 6);
			}

		}
		else
		{
			System.out.println("Hàng hóa này không tồn tại.");
		}
	}

	//-------------------------Thực hiện sửa chuyến xe-----------------------
	public static void menuThucHienSua(int chon, ChuyenXe cxSua) throws Exception
	{
		switch(chon)
		{
		case 1:
			String hoTen = nhapChuoi("Nhập họ tên tài xế: ");
			cxSua.setHoTen(hoTen);
			break;
		case 2:
			int soXe = nhapSoNguyen("Nhập số xe: ");
			cxSua.setSoXe(soXe);
			break;
		case 3:
			double doanhThu = nhapSoThuc("Nhập doanh thu: ");
			cxSua.setDoanhThu(doanhThu);
			break;
		}
	}

	//-------------------------Tìm kiếm chuyến xe-----------------------------
	public static void timKiemCX()
	{
		String maCX;
		int chon;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập mã chuyến xe cần tìm: ");
		maCX = sc.nextLine();
		ChuyenXe cx = dscx.timKiemChuyenXe(maCX);

		if(cx != null)
		{
			if(cx instanceof NoiThanh)
			{
				System.out.println(tieuDeNoiThanh());
				System.out.println("*******************************************************************************************************************************");
				System.out.println(cx);
				System.out.println("*******************************************************************************************************************************");
			}

			if(cx instanceof NgoaiThanh)
			{
				System.out.println(tieuDeNgoaiThanh());
				System.out.println("*******************************************************************************************************************************");
				System.out.println(cx);
				System.out.println("*******************************************************************************************************************************");
			}
		}
		else
		{
			System.out.println("Không tìm thấy chuyến xe này.");
		}
	}

	//-----------------------------Xóa chuyến xe--------------------------------
	public static void xoaCX()
	{
		String maCX;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập mã chuyến xe cần xóa: ");
		maCX = sc.nextLine();
		ChuyenXe cx = dscx.timKiemChuyenXe(maCX);

		if(cx != null)
		{
			System.out.println("Bạn có xác định muốn xóa chuyến xe này không[Y/N]: ");
			String xacNhan = sc.nextLine();
			if(xacNhan.equalsIgnoreCase("Y"))
			{
				dscx.xoaCX(cx);
				System.out.println("Xóa chuyến xe này thành công.");
			}
			else
				System.out.println("Bạn đã giữ lại chuyến xe này.");
		}
		else
			System.out.println("Không tìm thấy chuyến xe cần xóa.");
	}

	//----------------------------Sắp xếp theo mã chuyến xe-----------------------
	public static void sapXepTheoMaCX()
	{
		dscx.sapXepTheoMaCX();
		System.out.println("Các chuyến xe đã được sắp xếp theo mã chuyến xe hóa thành công.");
	}

	//------------------------Xuất danh sách chuyến xe nội thành-----------------
	public static void xuatDSNoiThanh() {
		for(ChuyenXe cx : dscx.xuatDSNoiThanh())
		{
			System.out.println(cx);
		}
	}

	//------------------------Xuất danh sách chuyến xe ngoại thành-----------------
	public static void xuatDSNgoaiThanh() {
		for(ChuyenXe cx : dscx.xuatDSNgoaiThanh())
		{
			System.out.println(cx);
		}
	}

	//--------------------------------menu chính-------------------------------------
	public static void menu()
	{
		System.out.println("\t\t\t***QUẢN LÝ HOẠT ĐỘNG CỦA CÁC CHUYẾN XE***\t\t\t");
		System.out.println("*******************************************************************************************************************************");
		System.out.println("\t1. Nhập danh sách.");
		System.out.println("\t2. Thêm chuyến xe.");
		System.out.println("\t3. Tìm kiếm chuyến xe.");
		System.out.println("\t4. Sửa chuyến xe.");
		System.out.println("\t5. Xóa chuyến xe.");
		System.out.println("\t6. Xuất các chuyến xe nội thành.");
		System.out.println("\t7. Xuất các chuyến xe ngoại thành.");
		System.out.println("\t8. Sắp xếp các chuyến xe theo mã chuyến xe.");
		System.out.println("\t9. Tổng doanh thu của các xe nội thành.");
		System.out.println("\t10. Tổng doanh thu của các xe ngoại thành.");
		System.out.println("\t11. Thoát.");
		System.out.println("*******************************************************************************************************************************");
		System.out.println("Nhập lựa chọn của bạn: ");
	}

	//-----------------------------menu sửa xe nội thành-------------------------------
	public static void menuSuaNoiThanh()
	{
		System.out.println("\t\t\t***MENU SỬA XE NỘI THÀNH***\t\t\t");
		System.out.println("*******************************************************************************************************************************");
		System.out.println("\t1. Tên tài xế.");
		System.out.println("\t2. Số xe.");
		System.out.println("\t3. Doanh thu.");
		System.out.println("\t4. Số tuyến.");
		System.out.println("\t5. Số km.");
		System.out.println("\t6. Trở về menu chính.");
		System.out.println("*******************************************************************************************************************************");
	}

	//-----------------------------menu sửa xe ngoại thành------------------------------
	public static void menuSuaNgoaiThanh()
	{
		System.out.println("\t\t\t***MENU SỬA XE NGOẠI THÀNH***\t\t\t");
		System.out.println("*******************************************************************************************************************************");
		System.out.println("\t1. Tên tài xế.");
		System.out.println("\t2. Số xe.");
		System.out.println("\t3. Doanh thu.");
		System.out.println("\t4. Nơi đến.");
		System.out.println("\t5. Số ngày đi được.");
		System.out.println("\t6. Trở về menu chính.");
		System.out.println("*******************************************************************************************************************************");
	}

	//-----------------------------------Tiêu đề------------------------------------
	public static String tieuDeNoiThanh()
	{
		return String.format("|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|", "Mã chuyến xe", "Tên tài xế", "Số xe", "Doanh thu", "Số tuyến", "Số Km");
	}

	public static String tieuDeNgoaiThanh()
	{
		return String.format("|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|", "Mã chuyến xe", "Tên tài xế", "Số xe", "Doanh thu", "Nơi đến", "Số ngày đi được");
	}

	//------------------------------------Main---------------------------------------
	public static void main(String[] args) throws Exception {
		int chon;
		Scanner sc = new Scanner(System.in);
		do
		{
			menu();
			chon = sc.nextInt();
			switch(chon)
			{
			case 1: 
				nhapCung();
				System.out.println();
				break;
			case 2: 
				themChuyenXe();
				System.out.println();
				break;
			case 3: 
				timKiemCX();
				System.out.println();
				break;
			case 4: 
				suaCX();
				System.out.println();
				break;
			case 5: 
				xoaCX();
				System.out.println();
				break;
			case 6: 
				System.out.println(tieuDeNoiThanh());
				System.out.println("*******************************************************************************************************************************");
				xuatDSNoiThanh();
				System.out.println("*******************************************************************************************************************************");
				System.out.println();
				break;
			case 7: 
				System.out.println(tieuDeNgoaiThanh());
				System.out.println("*******************************************************************************************************************************");
				xuatDSNgoaiThanh();
				System.out.println("*******************************************************************************************************************************");
				System.out.println();
				break;
			case 8: 
				sapXepTheoMaCX();
				System.out.println();
				break;
			case 9: 
				DecimalFormat df = new DecimalFormat("#,##0.00VND");
				String tongDoanhThuNTString = df.format(dscx.tongDoanhThuNoiThanh());
				System.out.println("Tổng doanh thu của các xe nội thành là: " + tongDoanhThuNTString);
				System.out.println();
				break;
			case 10: 
				DecimalFormat df1 = new DecimalFormat("#,##0.00VND");
				String tongDoanhThuNgTString = df1.format(dscx.tongDoanhThuNgoaiThanh());
				System.out.println("Tổng doanh thu của các xe ngoại thành là: " + tongDoanhThuNgTString);
				System.out.println();
				break;
			case 11: 
				System.out.println("Kết thúc chương trình.");
				break;
			default:
				System.out.println("Lựa chọn của bạn không hợp lệ. Vui lòng nhập lại.");
				break;
			}
		}
		while(chon != 11);
	}
}
