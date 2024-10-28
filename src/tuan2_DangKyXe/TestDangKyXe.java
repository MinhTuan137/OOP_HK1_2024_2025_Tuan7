package tuan2_DangKyXe;

import java.util.Scanner;

public class TestDangKyXe {
	public static DSDangKyXe ds;

	//----------------------Tạo tiêu đề cho bảng---------------------------
	static String tieuDe() {
		return String.format("|%-20s|%-20s|%-15s|%-15s|%-20s|%-20s|", "Mã đăng ký ", "Tên chủ xe", "Loại xe", "Dung tích", "Trị giá", "Thuế phải nộp");
	}

	//-------------------Nhập thông tin từ bàn phím------------------------
	public static String nhapChuoi(String thongbao)
	{
		String chuoi;
		System.out.println(thongbao);
		Scanner sc = new Scanner(System.in);
		chuoi = sc.nextLine();
		return chuoi;
	}

	public static int nhapSoNguyen(String thongbao)
	{
		int soNguyen;
		System.out.println(thongbao);
		Scanner sc = new Scanner(System.in);
		soNguyen = sc.nextInt();
		return soNguyen;
	}

	public static float nhapSoThuc(String thongbao)
	{
		float soThuc;
		System.out.println(thongbao);
		Scanner sc = new Scanner(System.in);
		soThuc = sc.nextFloat();
		return soThuc;
	}

	//-------------------Nhập thông tin đối tượng------------------------
	public static DangKyXe nhapDoiTuong()
	{
		String maDK, chuXe, loaiXe;
		int dTich;
		float triGia;
		DangKyXe dkx = null;
		try
		{
			maDK = nhapChuoi("Nhập mã đăng ký xe: ");
			int vt = ds.timViTriXe(maDK);
			if(vt != -1)
			{
				System.out.println("Trùng mã.");
				return null;
			}
			else
			{
				chuXe = nhapChuoi("Nhập tên chủ xe: ");
				loaiXe = nhapChuoi("Nhập loại xe: ");
				dTich = nhapSoNguyen("Nhập dung tích xe: ");
				triGia = nhapSoThuc("Nhập trị giá của xe: ");
				dkx = new DangKyXe(maDK, chuXe, loaiXe, dTich, triGia);
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return dkx;
	}

	//-------------------------Thêm đăng ký xe----------------------------
	public static void themDKX()
	{
		DangKyXe dkx = nhapDoiTuong();
		if(ds.themXe(dkx) == true)
			System.out.println("Thêm đăng ký xe thành công.");
		else
			System.out.println("Thêm đăng ký xe không thành công.");
	}

	//---------------Nhập thông tin từ trong chương trình-----------------
	public static void nhapCung() throws Exception
	{
		DangKyXe xe1, xe2, xe3, xe4;
		xe1 = new DangKyXe("1298", "Đỗ Minh Tuấn", "Wave", 130, 15000000);
		xe2 = new DangKyXe("1026", "Lưu Quốc Trung", "AB", 200, 40000000);
		xe3 = new DangKyXe("1050", "Nguyễn Viết Quân", "SH", 220, 60000000);
		xe4 = new DangKyXe("1521", "Trần Cao Hùng", "Vision", 150, 35000000);
		ds.themXe(xe1);
		ds.themXe(xe2);
		ds.themXe(xe3);
		ds.themXe(xe4);
		System.out.println("Thêm danh sách thành công.");
	}

	//-------------------------Sửa đăng ký xe----------------------------
	public static void suaDKX() throws Exception
	{
		String maDK = nhapChuoi("Nhập mã đăng ký xe cần sửa: ");
		DangKyXe dkx = ds.timXe(maDK);
		int daSua = 0, chon;
		if(dkx != null)
		{
			System.out.println("\t\t\t***ĐĂNG KÝ XE TRƯỚC KHI SỬA***\t\t\t");
			System.out.println(tieuDe());
			System.out.println("*********************************************************************************************************************");
			System.out.println(dkx);
			System.out.println("*********************************************************************************************************************");
			System.out.println();

			do
			{
				menuSua();
				chon = nhapSoNguyen("Nhập lựa chọn của bạn: ");
				daSua ++;
				switch(chon) 
				{
				case 1: 
					String chuXe = nhapChuoi("Nhập tên chủ xe: ");
					dkx.setChuXe(chuXe);
					break;
				case 2: 
					String loaiXe = nhapChuoi("Nhập loại xe: ");
					dkx.setLoaiXe(loaiXe);
					break;
				case 3: 
					int dTich = nhapSoNguyen("Nhập dung tích xe: ");
					dkx.setDungTich(dTich);
					break;
				case 4: 
					float triGia = nhapSoThuc("Nhập trị giá của xe: ");
					dkx.setTriGia(triGia);
					break;
				case 5: 
					if(daSua >= 1)
						ds.suaDKX(dkx);
					System.out.println("Đã sửa đăng ký xe thành công.");
					break;
				}
			}
			while(chon < 5);
		}
		else
			System.out.println("Không tìm thấy đăng ký xe cần sửa.");
	}

	//-------------------------xóa đăng ký xe----------------------------
	public static void xoaKDX() throws Exception
	{
		String maDK = nhapChuoi("Nhập mã đăng ký xe cần xóa: ");
		DangKyXe dkx = ds.timXe(maDK);
		if(dkx != null)
		{
			System.out.println(tieuDe());
			System.out.println("*********************************************************************************************************************");
			System.out.println(dkx);
			System.out.println("*********************************************************************************************************************");
			System.out.println();
			System.out.println("Bạn có chắc muốn xoá đăng ký xe này không?(Y/N): ");
			Scanner sc = new Scanner(System.in);
			String xacNhan = sc.nextLine();
			if(xacNhan.equalsIgnoreCase("Y"))
			{
				ds.xoaDKX(maDK);
				System.out.println("Xóa đăng ký xe này thành công.");
			}
			else
				System.out.println("Bạn đã giữ lại đăng ký xe này.");
		}
		else
			System.out.println("Không tìm thấy đăng ký xe cần xóa.");
	}

	//-------------------------tìm đăng ký xe----------------------------
	public static void timDKX()
	{
		String maDK = nhapChuoi("Nhập mã đăng ký xe cần tìm: ");
		DangKyXe dkx = ds.timXe(maDK);
		if(dkx != null)
		{
			System.out.println(tieuDe());
			System.out.println("*********************************************************************************************************************");
			System.out.println(dkx);
			System.out.println("*********************************************************************************************************************");
			System.out.println();
		}
		else
			System.out.println("Không tìm thấy đăng ký xe này.");
	}

	//-------------------------xuất đăng ký xe----------------------------
	public static void xuatDKX()
	{
		DangKyXe[] dsXuat = ds.getAllDangKyXe();
		System.out.println(tieuDe());
		System.out.println("*********************************************************************************************************************");
		for(int i = 0; i < ds.soLuongHT; i++)
		{
			if(dsXuat[i] != null)
				System.out.println(dsXuat[i]);
		}
		System.out.println("*********************************************************************************************************************");
	}

	//----------------------------menu chính-------------------------------
	public static void menu()
	{
		System.out.println("\t\t\t***QUẢN LÝ ĐĂNG KÝ XE***\t\t\t");
		System.out.println("*********************************************************************************************************************");
		System.out.println("\t1. Nhập danh sách đăng ký xe.");
		System.out.println("\t2. Thêm đăng ký xe.");
		System.out.println("\t3. Xuất danh sách.");
		System.out.println("\t4. Sửa đăng ký xe.");
		System.out.println("\t5. Xóa đăng ký xe");
		System.out.println("\t6. Tìm kiếm");
		System.out.println("\t7. Sắp xếp danh sách theo mã đăng ký xe");
		System.out.println("\t8. Số lượng đăng ký xe trong danh sách.");
		System.out.println("\t9. Thoát");
		System.out.println("*********************************************************************************************************************");
	}

	//-----------------------menu sửa đăng ký xe--------------------------
	public static void menuSua()
	{
		System.out.println("\t\t\t***MENU SỬA ĐĂNG KÝ XE***\t\t\t");
		System.out.println("*********************************************************************************************************************");
		System.out.println("\t1. Tên chủ xe.");
		System.out.println("\t2. Loại xe.");
		System.out.println("\t3. Dung tích xe.");
		System.out.println("\t4. Trị giá của xe.");
		System.out.println("\t5. Trở về menu chính.");
		System.out.println("*********************************************************************************************************************");
	}

	//-------------------------Hàm main-----------------------------------
	public static void main(String[] args) throws Exception {
		ds = new DSDangKyXe();
		int chon;
		DangKyXe dkx;
		do
		{
			menu();
			Scanner sc = new Scanner(System.in);
			System.out.println("Nhập lựa chọn cửa bạn: ");
			chon = sc.nextInt();
			switch(chon)
			{
			case 1: 
				nhapCung();
				System.out.println("");
				break;
			case 2:
				themDKX();
				System.out.println("");
				break;
			case 3:
				System.out.println("\t\t\t***DANH SÁCH ĐĂNG KÝ XE***\t\t\t");
				xuatDKX();
				System.out.println("");
				break;
			case 4:
				suaDKX();
				System.out.println("");
				break;
			case 5:
				xoaKDX();
				System.out.println("");
				break;
			case 6:
				timDKX();
				System.out.println("");
				break;
			case 7:
				ds.sapXepTheoMaDKX();
				System.out.println("Đã sắp xếp danh sách theo mã đăng ký thành công.");
				System.out.println("");
				break;
			case 8:
				System.out.println("Số lượng đặng ký xe là: " + ds.tongSoDangKy());
				System.out.println("");
				break;
			case 9:
				System.out.println("Đã kết thúc chương trình.");
				System.out.println("");
				break;
			}
		}
		while(chon != 9);
	}
}
