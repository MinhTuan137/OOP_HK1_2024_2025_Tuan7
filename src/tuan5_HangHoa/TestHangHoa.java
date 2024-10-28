package tuan5_HangHoa;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class TestHangHoa {
	public static DSHangHoa ds = new DSHangHoa();
	public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	//--------------------------Main----------------------------
	public static void main(String[] args) throws Exception{
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
				themDS();
				System.out.println();
				break;
			case 3:
				suaHH();
				System.out.println();
				break;
			case 4:
				xoaHH();
				System.out.println();
				break;
			case 5:
				timKiemHH();
				System.out.println();
				break;
			case 6:
				System.out.println("\t\t\t***DANH SÁCH CÁC HÀNG HÓA THỰC PHẨM***\t\t\t");
				System.out.println(tieuDeHTP());
				System.out.println("*******************************************************************************************************************************************************************************************************************");
				xuatHTP();
				System.out.println("*******************************************************************************************************************************************************************************************************************");
				System.out.println();
				break;
			case 7:
				System.out.println("\t\t\t***DANH SÁCH CÁC HÀNG HÓA SÀNH SỨ***\t\t\t");
				System.out.println(tieuDeHSS());
				System.out.println("*************************************************************************************************************************************************************************");
				xuatHSS();
				System.out.println("*************************************************************************************************************************************************************************");
				System.out.println();
				break;
			case 8:
				System.out.println("\t\t\t***DANH SÁCH CÁC HÀNG HÓA ĐIỆN MÁY***\t\t\t");
				System.out.println(tieuDeHDM());
				System.out.println("*************************************************************************************************************************************************************************");
				xuatHDM();
				System.out.println("*************************************************************************************************************************************************************************");
				System.out.println();
				break;
			case 9:
				sapXepTheoMaHH();
				System.out.println();
				break;
			case 10:
				sapXepTheoSLTonVaDG();
				System.out.println();
				break;
			case 11:
				System.out.println("Tổng số lượng hàng thực phẩm trong siêu thị là: " + ds.tongSLTonHTP());
				System.out.println("Tổng số lượng hàng sành sứ trong siêu thị là: " + ds.tongSLTonHSS());
				System.out.println("Tổng số lượng hàng điện máy trong siêu thị là: " + ds.tongSLTonHDM());
				System.out.println();
				break;
			case 12:
				System.out.println("Kết thúc chương trình.");
				System.out.println();
				break;
			default:
				System.out.println("Lựa chọn của bạn không hợp lệ. Vui lòng nhập lại.");
			}
		}
		while(chon != 12);
	}

	//----------------------------Menu------------------------------
	public static void menu()
	{
		System.out.println("\t\t\t***QUẢN LÝ KHO CỦA SIÊU THỊ***\t\t\t");
		System.out.println("*************************************************************************************************************************************************************************");
		System.out.println("\t1. Nhập cứng.");
		System.out.println("\t2. Thêm hàng hóa.");
		System.out.println("\t3. Sửa hàng hóa.");
		System.out.println("\t4. Xóa hàng hóa.");
		System.out.println("\t5. Tìm kiếm hàng hóa.");
		System.out.println("\t6. Xuất các hàng hóa là hàng thực phẩm.");
		System.out.println("\t7. Xuất các hàng hóa là hàng sành sứ.");
		System.out.println("\t8. Xuất các hàng hóa là hàng điện máy.");
		System.out.println("\t9. Sắp xếp các hàng hóa theo mã hàng hóa.");
		System.out.println("\t10. Sắp xếp các hàng hóa theo số lượng tồn và đơn giá.");
		System.out.println("\t11. Tổng số lượng tồn của hàng thực phẩm, hàng sành sứ và hàng điện máy.");
		System.out.println("\t12. Thoát");
		System.out.println("*************************************************************************************************************************************************************************");
		System.out.println("Nhập lựa chọn của bạn: ");
	}

	//--------------------------Menu sửa htp----------------------------
	public static void menuSuaHTP()
	{
		System.out.println("\t\t\t***MENU SỬA HÀNG THỰC PHẨM***\t\t\t");
		System.out.println("*************************************************************************************************************************************************************************");
		System.out.println("\t1. Tên hàng.");
		System.out.println("\t2. Số lượng tồn");
		System.out.println("\t3. Đơn giá.");
		System.out.println("\t4. Ngày sản xuất.");
		System.out.println("\t5. Ngày hết hạn.");
		System.out.println("\t6. Nhà cung cấp.");
		System.out.println("\t7. Trở lại menu chính.");
		System.out.println("*************************************************************************************************************************************************************************");
	}

	//--------------------------Menu sửa hss----------------------------
	public static void menuSuaHSS()
	{
		System.out.println("\t\t\t***MENU SỬA HÀNG SÀNH SỨ***\t\t\t");
		System.out.println("*************************************************************************************************************************************************************************");
		System.out.println("\t1. Tên hàng.");
		System.out.println("\t2. Số lượng tồn");
		System.out.println("\t3. Đơn giá.");
		System.out.println("\t4. Nhà sản xuất.");
		System.out.println("\t5. Ngày nhập kho.");
		System.out.println("\t6. Trở lại menu chính.");
		System.out.println("*************************************************************************************************************************************************************************");
	}

	//--------------------------Menu sửa hdm----------------------------
	public static void menuSuaHDM()
	{
		System.out.println("\t\t\t***MENU SỬA HÀNG ĐIỆN MÁY***\t\t\t");
		System.out.println("*************************************************************************************************************************************************************************");
		System.out.println("\t1. Tên hàng.");
		System.out.println("\t2. Số lượng tồn");
		System.out.println("\t3. Đơn giá.");
		System.out.println("\t4. Thời gian bảo hành.");
		System.out.println("\t5. Công suất.");
		System.out.println("\t6. Trở lại menu chính.");
		System.out.println("*************************************************************************************************************************************************************************");
	}

	//-----------------------------tiêu đề------------------------------
	public static String tieuDeHTP()
	{
		return String.format("|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|", "Mã hàng", "Tên hàng", "Số lượng tồn", "Đơn giá", "Ngày sản xuất", "Ngày hết hạn","Hạn sử dụng ", "Nhà cung cấp", "VAT", "Mức độ bán buôn");
	}

	public static String tieuDeHSS()
	{
		return String.format("|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|", "Mã hàng", "Tên hàng", "Số lượng tồn", "Đơn giá", "Nhà sản xuất", "Ngày nhập kho", "VAT", "Mức độ bán buôn");
	}

	public static String tieuDeHDM()
	{
		return String.format("|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|", "Mã hàng", "Tên hàng", "Số lượng tồn", "Đơn giá", "Thời gian bảo hành", "Công suất", "VAT", "Mức độ bán buôn");
	}

	//--------------------------Nhập dữ liệu----------------------------
	public static String nhapChuoi(String thongbao)
	{
		String chuoi;
		Scanner sc = new Scanner(System.in);
		System.out.println(thongbao);
		chuoi = sc.nextLine();
		return chuoi;
	}

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

	public static LocalDate nhapNgay(String thongbao) {
		Scanner sc = new Scanner(System.in);
		LocalDate date = null;
		while (date == null) {
			try {
				System.out.println(thongbao + " (theo định dạng dd-MM-yyyy): ");
				String strNgay = sc.nextLine();
				date = LocalDate.parse(strNgay, formatter);
			} catch (DateTimeParseException e) {
				System.out.println("Ngày nhập không hợp lệ. Vui lòng nhập theo định dạng dd-MM-yyyy.");
			}
		}
		return date;
	}

	//--------------------------Nhập cứng danh sách----------------------------
	public static void nhapCung() throws Exception 
	{
		LocalDate ngaySX1 = LocalDate.of(2023, 8, 12);  
		LocalDate ngayHH1 = LocalDate.of(2024, 1, 11);
		LocalDate ngaySX2 = LocalDate.of(2023, 4, 20);
		LocalDate ngayHH2 = LocalDate.of(2023, 6, 11);
		LocalDate ngayNhapKho1 = LocalDate.of(2023, 5, 25);
		LocalDate ngayNhapKho2 = LocalDate.of(2023, 7, 13);
		HangHoa htp1 = new HangThucPham("HTP1", "Bánh", 20, 20000, ngaySX1, ngayHH1, "Kinh Đô");
		HangHoa htp2 = new HangThucPham("HTP4", "Thạch dừa", 2, 35000, ngaySX2, ngayHH2, "Long Hải");
		HangHoa hss1 = new HangSanhSu("1291", "Bình hoa", 10, 100000, "Sao Mai", ngayNhapKho1);
		HangHoa hss2 = new HangSanhSu("3120", "Ấm nước", 30, 150000, "Cổ Xưa", ngayNhapKho2);
		HangHoa hdm1 = new HangDienMay("80AU", "Máy bơm", 5, 1200000, 12, 100);
		HangHoa hdm2 = new HangDienMay("761A", "Máy phát điện", 2, 30000000, 18, 200);
		ds.themHangHoa(htp1);
		ds.themHangHoa(htp2);
		ds.themHangHoa(hss1);
		ds.themHangHoa(hss2);
		ds.themHangHoa(hdm1);
		ds.themHangHoa(hdm2);
		System.out.println("Nhập danh sách thành công.");
	}

	//--------------------------Thêm đối tượng----------------------------
	public static HangHoa themDoiTuong() throws Exception
	{
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		HangHoa hh = null;
		try
		{
			int chon;
			String maHH = nhapChuoi("Nhập mã hàng: ");
			int viTri = ds.timViTriHangHoa(maHH);
			if(viTri != -1)
			{
				System.out.println("Trùng mã.");
				return null;
			}
			else
			{
				String tenHang = nhapChuoi("Nhập tên hàng: ");
				int soLuongTon = nhapSoNguyen("Nhập số lượng tồn: ");
				double donGia = nhapSoThuc("Nhập đơn giá: ");
				System.out.println("Nhập hàng hóa. Nhập 1 nếu là hàng thực phẩm, 2 nếu là hàng sành sứ, 3 nếu là hàng điện máy.");
				chon = sc.nextInt();
				if(chon == 1)
				{
					LocalDate ngaySX = nhapNgay("Nhập ngày sản xuất: ");
					LocalDate ngayHH = nhapNgay("Nhập ngày hết hạn: ");
					String nhaCungCap = nhapChuoi("Nhập nhà sản xuất: ");
					hh = new HangThucPham(maHH, tenHang, soLuongTon, donGia, ngaySX, ngayHH, nhaCungCap);
				}
				if(chon == 2)
				{
					String nhaSanXuat = nhapChuoi("Nhập nhà sản xuất: ");
					LocalDate ngayNK = nhapNgay("Nhập ngày nhập kho: ");
					hh = new HangSanhSu(maHH, tenHang, soLuongTon, donGia, nhaSanXuat, ngayNK);
				}
				if(chon == 3)
				{
					int thoiGianBH = nhapSoNguyen("Nhập thời gian bảo hành: ");
					double congSuat = nhapSoThuc("Nhập công suất: ");
					hh = new HangDienMay(maHH, tenHang, soLuongTon, donGia, thoiGianBH, congSuat);
				}
				System.out.println("Thêm hàng hóa thành công.");
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return hh;
	}

	//--------------------------Thêm hàng hóa vào ds----------------------------
	public static void themDS() throws Exception
	{
		HangHoa hh = themDoiTuong();
		ds.themHangHoa(hh);
	}

	//--------------------------Xuất hàng thực phẩm----------------------------
	public static void xuatHTP()
	{
		for(HangHoa hh : ds.layHangThucPham())
		{
			System.out.println(hh);
		}
	}

	//--------------------------Xuất hàng sành sứ----------------------------
	public static void xuatHSS()
	{
		for(HangHoa hh : ds.layHangSanhSu())
		{
			System.out.println(hh);
		}
	}

	//--------------------------Xuất hàng điện máy----------------------------
	public static void xuatHDM()
	{
		for(HangHoa hh : ds.layHangDienMay())
		{
			System.out.println(hh);
		}
	}

	//---------------------thực hiện sửa thông tin chung----------------------
	public static void menuThucHienSua(int chon, HangHoa hh) throws Exception
	{
		switch(chon)
		{
		case 1:
			String tenHang = nhapChuoi("Nhập tên hàng: ");
			hh.setTenHang(tenHang);
			break;
		case 2:
			int soLuongTon = nhapSoNguyen("Nhập số lượng tồn: ");
			hh.setSoLuongTon(soLuongTon);
			break;
		case 3:
			double donGia = nhapSoThuc("Nhập đơn giá: ");
			hh.setDonGia(donGia);
			break;
		}
	}

	//-----------------------------Sửa hàng hóa-------------------------------
	public static void suaHH() throws Exception
	{
		int chon, daSua = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập mã hàng cần sửa: ");
		String maHH = sc.nextLine();
		HangHoa hh = ds.timKiemHangHoa(maHH);
		if(hh != null)
		{
			System.out.println("Thông tin của hàng hóa trước khi sửa.");
			if(hh instanceof HangThucPham)
			{
				System.out.println(tieuDeHTP());
				System.out.println("*******************************************************************************************************************************************************************************************************************");
				System.out.println(hh);
				System.out.println("*******************************************************************************************************************************************************************************************************************");
				HangThucPham hhSua = (HangThucPham) hh;
				do
				{
					menuSuaHTP();
					System.out.println("Nhập lựa chọn của bạn: ");
					chon = sc.nextInt();
					daSua++;
					menuThucHienSua(chon, hhSua);
					if(chon == 4)
					{
						LocalDate ngaySX = nhapNgay("Nhập ngày sản xuất: ");
						hhSua.setNgaySX(ngaySX);

					}
					if(chon == 5)
					{
						LocalDate ngayHH = nhapNgay("Nhập ngày hết hạn: ");
						hhSua.setNgayHH(ngayHH);
					}
					if(chon == 6)
					{
						String nhaCungCap = nhapChuoi("Nhập nhà sản xuất: ");
						hhSua.setNhaCungCap(nhaCungCap);
					}
					if(chon == 7)
					{
						if(daSua >= 1)
							ds.suaHangHoa(hhSua);
						System.out.println("Đã sửa hàng thực phẩm này thành công.");
					}
				}
				while(chon < 7);
			}

			if(hh instanceof HangSanhSu)
			{
				System.out.println(tieuDeHSS());
				System.out.println("*************************************************************************************************************************************************************************");
				System.out.println(hh);
				System.out.println("*************************************************************************************************************************************************************************");
				HangSanhSu hhSua = (HangSanhSu) hh;
				do
				{
					menuSuaHSS();
					System.out.println("Nhập lựa chọn của bạn: ");
					chon = sc.nextInt();
					daSua++;
					menuThucHienSua(chon, hhSua);
					if(chon == 4)
					{
						String nhaSX = nhapChuoi("Nhập nhà sản xuất: ");
						hhSua.setNhaSX(nhaSX);
					}
					if(chon == 5)
					{
						LocalDate ngayNK = nhapNgay("Nhập ngày nhập kho: ");
						hhSua.setNgayNhapKho(ngayNK);
					}
					if(chon == 6)
					{
						if(daSua >= 1)
							ds.suaHangHoa(hhSua);
						System.out.println("Đã sửa hàng sành sứ này thành công.");
					}
				}
				while(chon < 6);
			}

			if(hh instanceof HangDienMay)
			{
				System.out.println(tieuDeHDM());
				System.out.println("*************************************************************************************************************************************************************************");
				System.out.println(hh);
				System.out.println("*************************************************************************************************************************************************************************");
				HangDienMay hhSua = (HangDienMay) hh;
				do
				{
					menuSuaHDM();
					System.out.println("Nhập lựa chọn của bạn: ");
					chon = sc.nextInt();
					daSua++;
					menuThucHienSua(chon, hhSua);
					if(chon == 4)
					{
						int thoiGianBH = nhapSoNguyen("Nhập thời gian bảo hành: ");
						hhSua.setThoiGianBaoHanh(thoiGianBH);
					}
					if(chon == 5)
					{
						double congSuat = nhapSoThuc("Nhập công suất: ");
						hhSua.setCongSuat(congSuat);
					}
					if(chon == 6)
					{
						if(daSua >= 1)
							ds.suaHangHoa(hhSua);
						System.out.println("Đã sửa hàng điện máy này thành công.");
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

	//-----------------------------tìm hàng hóa-------------------------------
	public static void timKiemHH()
	{
		String maHH;
		int chon;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập mã hàng hóa cần tìm: ");
		maHH = sc.nextLine();
		HangHoa hh = ds.timKiemHangHoa(maHH);

		if(hh != null)
		{
			if(hh instanceof HangThucPham)
			{
				System.out.println(tieuDeHTP());
				System.out.println("*******************************************************************************************************************************************************************************************************************");
				System.out.println(hh);
				System.out.println("*******************************************************************************************************************************************************************************************************************");
			}

			if(hh instanceof HangSanhSu)
			{
				System.out.println(tieuDeHSS());
				System.out.println("*************************************************************************************************************************************************************************");
				System.out.println(hh);
				System.out.println("*************************************************************************************************************************************************************************");
			}
			else
			{
				System.out.println(tieuDeHDM());
				System.out.println("*************************************************************************************************************************************************************************");
				System.out.println(hh);
				System.out.println("*************************************************************************************************************************************************************************");
			}
		}
		else
		{
			System.out.println("Không tìm thấy hàng hóa này.");
		}
	}

	//-----------------------------Xóa hàng hóa-------------------------------
	public static void xoaHH()
	{
		String maHH;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập mã hàng hóa cần xóa: ");
		maHH = sc.nextLine();
		HangHoa hh = ds.timKiemHangHoa(maHH);

		if(hh != null)
		{
			System.out.println("Bạn có xác định muốn xóa hàng hóa này không[Y/N]: ");
			String xacNhan = sc.nextLine();
			if(xacNhan.equalsIgnoreCase("Y"))
			{
				ds.xoaHangHoa(hh);
				System.out.println("Xóa hàng hóa này thành công.");
			}
			else
				System.out.println("Bạn đã giữ lại hàng hóa này.");
		}
		else
			System.out.println("Không tìm thấy hàng hóa cần xóa.");
	}

	//----------------------Sắp xếp hàng hóa theo mã--------------------------
	public static void sapXepTheoMaHH()
	{
		ds.sapXepTheoMaHang();
		System.out.println("Các hàng hóa đã được sắp xếp theo mã hàng hóa thành công.");
	}

	//---------------Sắp xếp hàng hóa theo sl tồn và đơn giá------------------
	public static void sapXepTheoSLTonVaDG()
	{
		ds.sapXepTheoSLTonVaDonGia();
		System.out.println("Các hàng hóa đã được sắp xếp theo số lượng tồn và đơn giá thành công.");
	}
}
