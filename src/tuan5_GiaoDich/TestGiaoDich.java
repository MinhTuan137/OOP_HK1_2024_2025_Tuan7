package tuan5_GiaoDich;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class TestGiaoDich {
	static DSGiaoDich ds = new DSGiaoDich();
	
	//----------------------nhập dữ liệu-------------------
	public static int nhapSoNguyen(String thongbao)
	{
		int soNguyen;
		Scanner sc = new Scanner(System.in);
		System.out.println(thongbao);
		soNguyen = sc.nextInt();
		return soNguyen;
	}
	
	public static double nhapSoThuc(String thongbao)
	{
		double soThuc;
		Scanner sc = new Scanner(System.in);
		System.out.println(thongbao);
		soThuc = sc.nextDouble();
		return soThuc;
	}
	
	public static String nhapChuoi(String thongbao)
	{
		String chuoi;
		Scanner sc = new Scanner(System.in);
		System.out.println(thongbao);
		chuoi = sc.nextLine();
		return chuoi;
	}
	
	//---------------------Nhập giao dịch------------------------
	public static GiaoDich nhapDoiTuong() throws ParseException
	{
		GiaoDich gd = null;
		try {
			int chon;
			String maGD = nhapChuoi("Nhập mã giao dịch: ");
			int vt = ds.timViTriCuaGD(maGD);
			if(vt != -1)
			{
				System.out.println("Trùng mã.");
				return null;
			}
			else
			{
				String ngayGDString = nhapChuoi("Nhập ngày giao dịch: ");
				double donGia = nhapSoThuc("Nhập đơn giá: ");
				int soLuong = nhapSoNguyen("Nhập số lượng: ");
				Date ngayGD = new SimpleDateFormat("dd/MM/yyyy").parse( ngayGDString);
				System.out.println("Nhập giao dịch.(Nhập 1 nếu là giao dịch vàng, nhập 2 nếu giao dịch tiền tệ.)");
				Scanner sc = new Scanner(System.in);
				chon = sc.nextInt();
				if(chon == 1)
				{
					String loaiVang = nhapChuoi("Nhap loai vang: ");
					gd =  new Vang(maGD, ngayGD, donGia, soLuong, loaiVang);
				}
				else
				{
					double tiGia = nhapSoThuc("Nhap ti gia: ");
					String loaiTienTe = nhapChuoi("Nhap loai tien te (VN, USD, Euro): ");
					gd =  new TienTe(maGD, ngayGD, donGia, soLuong, tiGia, loaiTienTe);
				}
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return gd;
	}
	
	//-------------------Thêm giao dịch vào ds----------------------
	public static void themDS() throws ParseException
	{
		GiaoDich gd = nhapDoiTuong();
		ds.themGD(gd);
	}
	
	//-------------------Nhập cứng giao dịch-------------------------
	public static void themCungGD()
	{
		Date date1 = new Date(2024-1900, 5 , 22);
		Date date2 = new Date(2023-1900, 8 , 20);
		Date date3 = new Date(2024-1900, 2 , 12);
		Date date4 = new Date(2023-1900, 1 , 10);
		GiaoDich gd1 = new Vang("1234", date1, 10000000, 10, "9999");
		GiaoDich gd2 = new Vang("1357", date2, 1500000000, 20, "9999");
		GiaoDich gd3 = new TienTe("1590", date3, 2000000000, 30, 20, "USD");
		GiaoDich gd4 = new TienTe("4682", date4, 15000000, 25, 10, "VN");
		ds.themGD(gd1);
		ds.themGD(gd2);
		ds.themGD(gd3);
		ds.themGD(gd4);
		System.out.println("Thêm giao dịch thành công.");
	}
	
	//-------------------Tìm giao dịch------------------------------
	public static void timKiemGD()
	{
		String maGD;
		int chon;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập mã giao dịch cần tìm: ");
		maGD = sc.nextLine();
		GiaoDich gd = ds.timKiemGD(maGD);
		
		if(gd != null)
		{
			System.out.println(tieuDe());
			System.out.println("************************************************************************************************************************************");
			System.out.println(gd);
			System.out.println("************************************************************************************************************************************");
		}
		else
		{
			System.out.println("Không tìm thấy giao dịch này.");
		}
	}
	
	//--------------------Xuất danh sách giao dịch----------------------
	public static void xuatGDVang()
	{
		for(GiaoDich gdVang: ds.layGDVang())
		{
			System.out.println(gdVang);
		}
	}
	
	public static void xuatGDTienTe()
	{
		for(GiaoDich gdTienTe: ds.layGDTienTe())
		{
			System.out.println(gdTienTe);
		}
	}
	
	public static void xuatGDTy()
	{
		for(GiaoDich gd: ds.gdGiaHon1Ty())
		{
			System.out.println(gd);
		}
	}
	
	//--------------------------Xóa giao dịch--------------------------
	public static void xoaGD()
	{
		String maGD;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập mã giao dịch cần xóa: ");
		maGD = sc.nextLine();
		GiaoDich gd = ds.timKiemGD(maGD);
		if(gd != null)
		{
			System.out.println("Bạn có xác định muốn xóa giao dịch này không[Y/N]: ");
			String xacNhan = sc.nextLine();
			if(xacNhan.equalsIgnoreCase("Y"))
			{
				ds.xoaGD(gd);
				System.out.println("Xóa giao dịch thành công.");
			}
			else
				System.out.println("Bạn đã giữ lại giao dịch này.");
		}
		else
			System.out.println("Không tìm thấy giao dịch cần xóa.");
	}
	
	//-----------------------Sửa giao dịch-----------------------------
	public static void suaGD() throws ParseException
	{
		int chon, daSua = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập mã giao dịch cần sửa: ");
		String maGD = sc.nextLine();
		GiaoDich gd = ds.timKiemGD(maGD);
		if(gd != null)
		{
			System.out.println("Thông tin của giao dịch trước khi sửa.");
			if(gd instanceof Vang)
				System.out.println(tieuDeVang());
			else
				System.out.println(tieuDeTienTe());
			System.out.println(gd);
			if(gd instanceof Vang)
			{
				Vang gdSua = (Vang) gd;
				do
				{
					menuSuaGDVang();
					chon = sc.nextInt();
					daSua ++;
					menuThucHienSua(chon, gdSua);
					if(chon == 4)
					{
						String loaiVang = nhapChuoi("Nhập loại vàng: ");
						gdSua.setLoaiVang(loaiVang);
					}
					if(chon == 5)
					{
						if(daSua >= 1)
							ds.suaGD(gdSua);
						System.out.println("Đã sửa giao dịch thành công.");
					}
				}
				while(chon < 5);
			}
			else
			{
				TienTe gdSua = (TienTe) gd;
				do
				{
					menuSuaGDTienTe();
					chon = sc.nextInt();
					daSua++;
					menuThucHienSua(chon, gdSua);
					if(chon == 4)
					{
						double tiGia = nhapSoThuc("Nhập tỉ giá: ");
						gdSua.setTiGia(tiGia);
					}
					if(chon == 5)
					{
						String loaiTienTe = nhapChuoi("Nhập loại tiền tệ: ");
						gdSua.setLoaiTienTe(loaiTienTe);
					}
					if(chon == 6)
					{
						if(daSua >= 1)
							System.out.println("Đã sửa giao dịch thành công.");
					}
				}
				while(chon < 6);
			}
		}
		else
			System.out.println("Giao dịch này không tồn tại.");
	}
	
	//------------------Sửa thông tin chung của giao dịch----------------------
	public static void menuThucHienSua(int chon, GiaoDich gdSua) throws ParseException
	{
		switch(chon)
		{
			case 1:
				String ngayGDString = nhapChuoi("Nhập ngày giao dịch: ");
				Date ngayGD = new SimpleDateFormat("dd/MM/yyyy").parse( ngayGDString);
				gdSua.setNgayGD(ngayGD);
				break;
			case 2:
				double donGia = nhapSoThuc("Nhập đơn giá: ");
				gdSua.setDonGia(donGia);
				break;
			case 3:
				int soLuong = nhapSoNguyen("Nhập số lượng: ");
				gdSua.setSoLuong(soLuong);
				break;
		}
	}
	
	//------------------Sắp xếp giao dịch theo mã-----------------------------
	public static void sapXepTheoMaGD()
	{
		ds.sapXepTheoMaGD();
		System.out.println("Đã sắp xếp các giao dịch theo mã giao dịch thành công.");
	}
	
	//---------------Sắp xếp giao dịch theo ngày và sl------------------------
	public static void sapXepTheoNgayVaSL()
	{
		ds.sapXepTheoNgayVaSL();
		System.out.println("Đã sắp xếp các giao dịch theo ngày và số lượng thành công.");
	}
	
	//---------------------------Menu chính-----------------------------------
	public static void menu()
	{
		System.out.println("\t\t\t***QUẢN LÝ CÁC GIAO DỊCH***\t\t\t");
		System.out.println("********************************************************************************************************************");
		System.out.println("\t1. Nhập cứng.");
		System.out.println("\t2. Thêm giao dịch.");
		System.out.println("\t3. Xuất danh sách các giao dịch vàng.");
		System.out.println("\t4. Xuất danh sách các giao dịch tiền tệ.");
		System.out.println("\t5. Tìm kiếm giao dịch.");
		System.out.println("\t6. Xóa giao dịch.");
		System.out.println("\t7. Sửa giao dịch.");
		System.out.println("\t8. Tổng số lượng giao dịch vàng.");
		System.out.println("\t9. Tổng số lượng giao dịch tiền tệ.");
		System.out.println("\t10. Trung bình thành tiền giao dịch tiền tệ.");
		System.out.println("\t11. Tổng thành tiền của tất cả các giao dịch.");
		System.out.println("\t12. Danh sách các giao dịch có đơn giá trên 1 tỷ.");
		System.out.println("\t13. Sắp xếp các giao dịch theo mã giao dịch.");
		System.out.println("\t14. Sắp xếp các giao dịch theo ngày giao dịch và theo số lượng.");
		System.out.println("\t15. Thoát.");
		System.out.println("********************************************************************************************************************");
		System.out.println("Nhập lựa chọn của bạn: ");
	}
		
	//--------------------------Menu sửa giao dịch vàng----------------------------
	public static void menuSuaGDVang()
	{
		System.out.println("\t\t\t***MENU SỬA GIAO DỊCH VÀNG***\t\t\t");
		System.out.println("********************************************************************************************************************");
		System.out.println("\t1. Ngày giao dịch.");
		System.out.println("\t2. Đơn giá.");
		System.out.println("\t3. Số lượng.");
		System.out.println("\t4. Loại vàng.");
		System.out.println("\t5. Trở về menu chính.");
		System.out.println("********************************************************************************************************************");
		System.out.println("Nhập lựa chọn của bạn: ");
	}
	
	//------------------------Menu sửa giao dịch tiền tệ---------------------------
	public static void menuSuaGDTienTe()
	{
		System.out.println("\t\t\t***MENU SỬA GIAO DỊCH TIỀN TỆ***\t\t\t");
		System.out.println("********************************************************************************************************************");
		System.out.println("\t1. Ngày giao dịch.");
		System.out.println("\t2. Đơn giá.");
		System.out.println("\t3. Số lượng.");
		System.out.println("\t4. Tỉ giá.");
		System.out.println("\t5. Loại tiền tệ.");
		System.out.println("\t6. Trở về menu chính.");
		System.out.println("********************************************************************************************************************");
		System.out.println("Nhập lựa chọn của bạn: ");
	}
	
	//-------------------------------Tiêu đề--------------------------------------
	public static String tieuDe()
	{
		return String.format("|%-20s|%-25s|%-25s|%-15s|%-25s|%-15s|", "Mã giao dich", "Ngày giao dich", "Đơn giá", "Số lượng", "Tỉ giá & loại Vàng",  "Loại tiền tệ" );
	} 
	
	public static String tieuDeVang()
	{
		return String.format("|%-20s|%-25s|%-25s|%-15s|%-25s|", "Mã giao dich", "Ngày giao dich", "Đơn giá", "Số lượng", "Loại vàng");
	}
	
	public static String tieuDeTienTe()
	{
		return String.format("|%-20s|%-25s|%-25s|%-15s|%-25s|%-15s|", "Mã giao dich", "Ngày giao dich", "Đơn giá", "Số lượng", "Tỉ giá", "Loại tiền tệ");
	}
	
	//----------------------------Main-----------------------------------
	public static void main(String[] args) throws ParseException {
		int chon;
		Scanner sc = new Scanner(System.in);
		do
		{
			menu();
			chon = sc.nextInt();
			switch(chon)
			{
				case 1:
					themCungGD();
					System.out.println();
					break;
				case 2:
					themDS();
					System.out.println();
					break;
				case 3:
					System.out.println("\t\t\t***DANH SÁCH CÁC GIAO DỊCH VÀNG***\t\t\t");
					System.out.println(tieuDeVang());
					System.out.println("********************************************************************************************************************");
					xuatGDVang();
					System.out.println("********************************************************************************************************************");
					System.out.println();
					break;
				case 4:
					System.out.println("\t\t\t***DANH SÁCH CÁC GIAO DỊCH TIỀN TỆ***\t\t\t");
					System.out.println(tieuDeTienTe());
					System.out.println("************************************************************************************************************************************");
					xuatGDTienTe();
					System.out.println("************************************************************************************************************************************");
					System.out.println();
					break;
				case 5:
					timKiemGD();
					System.out.println();
					break;
				case 6:
					xoaGD();
					System.out.println();
					break;
				case 7:
					suaGD();
					System.out.println();
					break;
				case 8:
					System.out.println("Tổng số giao dịch vàng là: " + ds.tongSoLuongGDVang());
					System.out.println();
					break;
				case 9:
					System.out.println("Tổng số lượng giao dịch tiền tệ là: " + ds.tongSoLuongGDTienTe());
					System.out.println();
					break;
				case 10:
					double tongThanhTienTienTe = ds.tbThanhTienGDTienTe();
					DecimalFormat df = new DecimalFormat("#,##0.00VND");
					String tongThanhTienTienTeString = df.format(tongThanhTienTienTe);
					System.out.println("Trung bình thành tiền của các giao dịch tiền tệ là: " + tongThanhTienTienTeString);
					System.out.println();
					break;
				case 11:
					double tongThanhTienGD = ds.tongSoThanhTienGD();
					DecimalFormat df2 = new DecimalFormat("#,##0.00VND");
					String tongThanhTienGDString = df2.format(tongThanhTienGD);
					System.out.println("Tổng thành tiền của tất cả các giao dịch trong danh sách là: " + tongThanhTienGDString);
					break;
				case 12:
					System.out.println("Danh sách các giao dịch trên 1 tỷ.");
					System.out.println(tieuDe());
					System.out.println("************************************************************************************************************************************");
					xuatGDTy();
					System.out.println("************************************************************************************************************************************");
					System.out.println();
				case 13:
					sapXepTheoMaGD();
					System.out.println();
					break;
				case 14:
					sapXepTheoNgayVaSL();
					System.out.println();
					break;
				case 15:
					System.out.println("Kết thúc chương trình.");
					System.out.println();
					break;
				default:
					System.out.println("Lựa chọn của bạn không hợp lệ vui lòng nhập lại.");
			}
		}
		while(chon != 15);
	}
}
