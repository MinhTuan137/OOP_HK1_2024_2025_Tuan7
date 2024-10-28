package tuan4_ThuVienSach;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TestSach 
{
	static DSSach ds = new DSSach();
	//----------------------Tieu de---------------------------
	public static String tieuDe()
	{
		return String.format("|%-15s|%-15s|%-20s|%-15s|%-20s|%-30s|", "Mã sách", "Ngày nhập", "Đơn giá", "Số lượng", "Nhà xuất bản", "Thuế(STK) hay tình trạng(SGK)");
	}

	public static String tieuDeSTK()
	{
		return String.format("|%-15s|%-15s|%-20s|%-15s|%-20s|%-30s|", "Mã sách", "Ngày nhập", "Đơn giá", "Số lượng", "Nhà xuất bản", "Thuế");
	}

	public static String tieuDeSGK()
	{
		return String.format("|%-15s|%-15s|%-20s|%-15s|%-20s|%-30s|", "Mã sách", "Ngày nhập", "Đơn giá", "Số lượng", "Nhà xuất bản", "Tình trạng");
	}
	//-----------------------Main-----------------------------
	public static void main(String[] args) throws Exception 
	{
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
				themVaoDS();
				System.out.println();
				break;
			case 3:
				xoaSach();
				System.out.println();
				break;
			case 4:
				suaSach();
				System.out.println();
				break;
			case 5:
				timKiemSach();
				System.out.println();
				break;
			case 6:
				xuatDS();
				System.out.println();
				break;
			case 7:
				xuatDSSachGK();
				System.out.println();
				break;
			case 8:
				xuatDSSachTK();
				System.out.println();
				break;
			case 9:
				sortGiaTien();
				System.out.println();
				break;
			case 10:
				sortNgayVaSL();
				System.out.println();
				break;
			case 11:
				xuatTongTien();
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

	//------------------------Menu chính-----------------------------
	static void menu()
	{
		System.out.println("\t\t\t***CHƯƠNG TRÌNH QUẢN LÝ THƯ VIỆN SÁCH***\t\t\t");
		System.out.println("**************************************************************************************************************************");
		System.out.println("\t1. Nhập cứng.");
		System.out.println("\t2. Thêm sách.");
		System.out.println("\t3. Xóa sách.");
		System.out.println("\t4. Sửa sách.");
		System.out.println("\t5. Tìm kiếm sách.");
		System.out.println("\t6. Xuất danh sách sách.");
		System.out.println("\t7. Xuất danh sách sách giáo khoa.");
		System.out.println("\t8. Xuất danh sách sách tham khảo.");
		System.out.println("\t9. Sắp xếp sách theo số tiền.");
		System.out.println("\t10. Sắp xếp theo ngày và số lượng.");
		System.out.println("\t11. Xuất tổng tiền của các loại sách.");
		System.out.println("\t12. Thoát");
		System.out.println("**************************************************************************************************************************");
		System.out.println("Nhập lựa chọn của bạn: ");
	}

	//------------------Menu sửa sách giáo khoa------------------------
	static void menuSuaSachGK()
	{
		System.out.println("\t\t\t***MENU SỬA SÁCH GIÁO KHOA***\t\t\t");
		System.out.println("**************************************************************************************************************************");
		System.out.println("\t1. Ngày nhập.");
		System.out.println("\t2. Đơn giá.");
		System.out.println("\t3. Số lượng.");
		System.out.println("\t4. Nhà xuất bản.");
		System.out.println("\t5. Tình trạng");
		System.out.println("\t6. Về menu chính.");
		System.out.println("**************************************************************************************************************************");
	}

	//------------------Menu sửa sách tham khảo------------------------
	static void menuSuaSachTK()
	{
		System.out.println("\t\t\t***MENU SỬA SÁCH THAM KHẢO***\t\t\t");
		System.out.println("**************************************************************************************************************************");
		System.out.println("\t1. Ngày nhập.");
		System.out.println("\t2. Đơn giá.");
		System.out.println("\t3. Số lượng.");
		System.out.println("\t4. Nhà xuất bản.");
		System.out.println("\t5. Thuế.");
		System.out.println("\t6. Về menu chính.");
		System.out.println("**************************************************************************************************************************");
	}

	//----------------------------Nhập cứng----------------------------
	static void nhapCung()
	{
		Date date1 = new Date(2022 - 1900, 8, 12);
		Sach sach1 = new SachGiaoKhoa("TV1", date1, 25000, 20, "Kim Đồng", true);
		Date date2 = new Date(2022 - 1900, 2, 28);
		Sach sach2 = new SachGiaoKhoa("HT1", date2, 10000, 32, "Phương Nam", false);
		Date date3 = new Date(2022 - 1900, 7, 13);
		Sach sach3 = new SachThamKhao("MT1", date3, 30000, 25, "Hoa Mai", 1500);
		Date date4 = new Date(2022 - 1900, 6, 11);
		Sach sach4 = new SachThamKhao("LN1", date4, 45000, 15, "Ánh Sáng", 2500);
		ds.themSach(sach1);
		ds.themSach(sach2);
		ds.themSach(sach3);
		ds.themSach(sach4);
		System.out.println("Nhập danh sách các sách thành công.");
	}

	//-------------------Thêm sách vào danh sách------------------------
	public static void themVaoDS()
	{
		Sach s = themMotSach();
		if(s != null)
		{
			ds.themSach(s);
			System.out.println("Thêm sách thành công.");
		}
		else
			System.out.println("Thêm sách không thành công.");
	}

	//------------------------Thêm một sách-----------------------------
	public static Sach themMotSach()
	{
		Sach sach = null;
		Scanner sc = new Scanner(System.in);
		try
		{
			String maSach, nhaXB, ngayNhap;
			Date ngayNhapSach;
			int soLuong;
			double donGia;

			System.out.println("Nhập mã sách: ");
			maSach = sc.nextLine();
			int vt = ds.timKiemViTri(maSach);
			if(vt != -1)
			{
				System.out.println("Mã sách đã trùng.");
				return null;
			}
			else
			{
				System.out.println("Nhập ngày nhập sách: ");
				ngayNhap = sc.nextLine();
				ngayNhapSach = new SimpleDateFormat("dd/MM/yyyy").parse(ngayNhap);
				System.out.println("Nhập đơn giá: ");
				donGia = sc.nextDouble();
				System.out.println("Nhập số lượng: ");
				soLuong = sc.nextInt();
				sc.nextLine();
				System.out.println("Nhập nhà xuất bản: ");
				nhaXB = sc.nextLine();
				System.out.println("Nhập [1] để nhập sách giáo khoa hoặc nhập khác để nhập sách tham khảo: ");
				int chon = sc.nextInt();
				sc.nextLine();
				if(chon == 1)
				{
					boolean tinhTrang;
					String tinhTrangString;
					System.out.println("Nhập [M] nếu là sách mới và nhập [C] nếu là sách cũ: ");
					tinhTrangString = sc.nextLine();
					while(!tinhTrangString.equalsIgnoreCase("M")  && !tinhTrangString.equalsIgnoreCase("C"))
					{
						System.out.println("Bạn nhập không đúng vui lòng nhập lại: ");
						tinhTrangString = sc.nextLine();
					}
					if(tinhTrangString == "M")
						tinhTrang = false;
					tinhTrang = true;
					sach = new SachGiaoKhoa(maSach, ngayNhapSach, donGia, soLuong, nhaXB, tinhTrang);
				}
				else
				{
					double thue;
					System.out.println("Nhập thuế: ");
					thue = sc.nextDouble();
					sach = new SachThamKhao(maSach, ngayNhapSach, donGia, soLuong, nhaXB, thue);
				}
			}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		return sach;
	}

	//---------------------------------Xóa sách----------------------------
	static void xoaSach()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập mã sách cần xóa: ");
		String maSach = sc.nextLine();
		Sach s = ds.timKiemDoiTuong(maSach);
		if(s != null)
		{
			String chon;
			System.out.println("Bạn có xác nhận xóa sách này không [Y/N]: ");
			chon = sc.nextLine();
			if(chon.equalsIgnoreCase("Y"))
			{
				ds.xoaSach(s);
				System.out.println("Xóa sách thành công.");
			}
			else
			{
				System.out.println("Bạn đã chọn giữ lại sách.");
			}
		}
		else
			System.out.println("Sách bạn chọn không tồn tại.");
	}

	//-------------------------Tìm kiếm sách--------------------------------
	public static void timKiemSach()
	{
		String maSach;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập mã sách cần tìm: ");
		maSach = sc.nextLine();
		Sach s = ds.timKiemDoiTuong(maSach);
		if(ds.timKiemViTri(maSach) != -1)
		{
			System.out.printf("Tìm thấy sách ở vị trí %d trong danh sách.\n", ds.timKiemViTri(maSach));
			System.out.println(tieuDe());
			System.out.println("**************************************************************************************************************************");
			System.out.println(s);
			System.out.println("**************************************************************************************************************************");
		}
		else
			System.out.println("Không tìm thấy sách này trong danh sách.");
	}
	//------------------Thực hiện sửa thong tin chung--------------------------
	public static void thucHienMenuSua(int chon, Sach sachSua) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		switch(chon)
		{
		case 1:
			System.out.println("Nhập ngày nhập sách: ");
			String ngayNhap = sc.nextLine();
			Date ngayNhapSach = new SimpleDateFormat("dd/MM/yyyy").parse(ngayNhap);
			sachSua.setNgayNhap(ngayNhapSach);
			break;
		case 2:
			System.out.println("Nhập đơn giá: ");
			double donGia = sc.nextDouble();
			sachSua.setDonGia(donGia);
			break;
		case 3:
			System.out.println("Nhập số lượng: ");
			int soLuong = sc.nextInt();
			sachSua.setSoLuong(soLuong);
			break;
		case 4:
			System.out.println("Nhập nhà xuất bản: ");
			String nhaXB = sc.nextLine();
			sachSua.setNhaXuatBan(nhaXB);
			break;
		}
	}

	//---------------------------Sửa sách-----------------------------------
	static void suaSach() throws Exception
	{
		int chon, daSua = 0;
		boolean tinhTrang;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập mã sách cần sửa.");
		String maSach = sc.nextLine();
		Sach s = ds.timKiemDoiTuong(maSach);
		if(s != null)
		{
			System.out.println("Thông tin sách trước khi sửa\n" + s);
			if(s instanceof SachGiaoKhoa)
			{
				SachGiaoKhoa sachSua = (SachGiaoKhoa) s;
				do
				{
					menuSuaSachGK();
					System.out.println("Nhập lựa chọn: ");
					chon = sc.nextInt();
					sc.nextLine();
					daSua ++;
					thucHienMenuSua(chon, s);
					if(chon == 5)
					{
						String tinhTrangString;
						System.out.println("Nhập [M] nếu là sách mới và nhập [C] nếu là sách cũ: ");
						tinhTrangString = sc.nextLine();
						while(!tinhTrangString.equalsIgnoreCase("M")  && !tinhTrangString.equalsIgnoreCase("C"))
						{
							System.out.println("Bạn nhập không đúng vui lòng nhập lại: ");
							tinhTrangString = sc.nextLine();
						}
						if(tinhTrangString == "M")
							tinhTrang = false;
						tinhTrang = true;
						sachSua.setTinhTrang(tinhTrang);
					}
					if(chon == 6)
					{
						if(daSua >= 1)
							ds.suaSach(sachSua);
						System.out.println("Trở về menu chính.");
					}
				}
				while(chon < 6);
			}
			else	
			{
				SachThamKhao sachSua = (SachThamKhao) s;
				menuSuaSachTK();
				System.out.println("Nhập lựa chọn: ");
				chon = sc.nextInt();
				daSua ++;
				thucHienMenuSua(chon, sachSua);
				if(chon == 5)
				{
					System.out.println("Nhập thuế: ");
					double thue = sc.nextDouble();
					sachSua.setThue(thue);
				}
				if(chon == 6)
				{
					if(daSua >= 1)
						ds.suaSach(sachSua);
					System.out.println("Trở về menu chính.");
				}
			}
		}
		else
			System.out.println("Sách này không tồn tại.");
	}

	//----------------------Sắp xếp theo giá tiền---------------------
	public static void sortGiaTien()
	{
		ds.sortGiaTien();
		System.out.println("Danh sách sách đã được sắp xếp theo giá tiền thành công.");
	}

	//------------------Sắp xếp theo ngày và số lượng------------------
	public static void sortNgayVaSL()
	{
		ds.sortNgayVaSL();
		System.out.println("Danh sách sách đã được sắp xếp theo ngày và số lượng thành công.");
	}

	//-----------------Xuất danh sách sách giáo khoa---------------------
	public static void xuatDSSachGK()
	{
		System.out.println("\t\t\t***DANH SÁCH CÁC SÁCH GIÁO KHOA***\t\t\t");
		System.out.println(tieuDeSGK());
		System.out.println("**************************************************************************************************************************");
		for(Sach sachGK: ds.getDSSachGK())
		{
			System.out.println(sachGK);
		}
		System.out.println("**************************************************************************************************************************");
	}

	//-----------------Xuất danh sách sách tham khảo---------------------
	public static void xuatDSSachTK()
	{
		System.out.println("\t\t\t***DANH SÁCH CÁC SÁCH THAM KHẢO***\t\t\t");
		System.out.println(tieuDeSTK());
		System.out.println("**************************************************************************************************************************");
		for(Sach sachTK : ds.getDSSachTK())
		{
			System.out.println(sachTK);
		}
		System.out.println("**************************************************************************************************************************");
	}

	//-----------------Xuất danh sách tất cả sách---------------------------
	public static void xuatDS()
	{
		System.out.println("\t\t\t***DANH SÁCH TẤT CẢ CÁC SÁCH***\t\t\t");
		System.out.println(tieuDe());
		System.out.println("**************************************************************************************************************************");
		for(Sach sach : ds.getHetSach())
		{
			System.out.println(sach);
		}
		System.out.println("**************************************************************************************************************************");
	}

	//------------------Xuất tổng tiền các loại sách--------------------
	public static void xuatTongTien()
	{
		DecimalFormat df = new DecimalFormat("#,##0.00VND");
		String tongTienSGK = df.format(ds.getTongTienSGK());
		String tongTienSTK = df.format(ds.getTongTienSTK());
		System.out.println("Tổng tiền của tất cả các sách giáo khoa là: " + tongTienSGK);
		System.out.println();
		System.out.println("Tổng tiền của tất cả các sách tham khảo là: " + tongTienSTK);
	}
}
