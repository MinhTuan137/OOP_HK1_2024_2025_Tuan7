package tuan2_NganHang;

import java.text.DecimalFormat;
import java.util.Scanner;

public class TestAcc {
	public static DSAccount accountList;

	//------------------------------tiêu đề-------------------------------
	public static void tieuDe() {
		String title = String.format("|%-5s|%-15s|%-20s|%-20s|", "STT", "Số tài khoản", "Họ và tên", "Số Dư");
		System.out.println(title);
	}

	public static void tieuDe2() {
		String title = String.format("|%-15s|%-20s|%-20s|", "Số tài khoản", "Họ và tên", "Số Dư");
		System.out.println(title);
	}

	//----------------------------nhập dữ liệu-----------------------------
	public static long nhapSoTaiKhoan(String thongbao)
	{
		long soTaiKhoan;
		System.out.println(thongbao);
		Scanner sc = new Scanner(System.in);
		soTaiKhoan = sc.nextLong();
		return soTaiKhoan;
	}

	public static String nhapHoTen(String thongbao)
	{
		String hoTen;
		System.out.println(thongbao);
		Scanner sc = new Scanner(System.in);
		hoTen = sc.nextLine();
		return hoTen;
	}

	public static double nhapSoTien(String thongbao)
	{
		double soTien;
		System.out.println(thongbao);
		Scanner sc = new Scanner(System.in);
		soTien = sc.nextDouble();
		return soTien;
	}

	//---------------------nhập trong chương trình-------------------------- 
	public static void nhapCung() throws Exception {
		Account[] accounts = {
				new Account(1017020607, "Lê Hoàng Bảo"),
				new Account(1017046087, "Tạ Văn Ơn", 5000000),
				new Account(1017061096, "Cù Văn Cần", 1000000),
				new Account(1017030708, "Bao Bao", 300000)
		};
		for (Account acc: accounts)
			accountList.them(acc); 
	}

	//---------------------------thêm tài khoản------------------------------
	public static void themTK() throws Exception
	{
		int sl;
		long soTaiKhoan;
		String hoTen;
		double soDu;
		Account acc;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập số lượng tài khoản muốn thêm: ");
		sl = sc.nextInt();
		for(int i = 0; i < sl; i++)
		{
			System.out.println("Tài khoản " + (i + 1) + " :");
			soTaiKhoan = nhapSoTaiKhoan("Nhập số tài khoản: ");
			int vt = accountList.timKiem(soTaiKhoan);
			if(vt != -1)
			{
				System.out.println("Số tài khoản này đã tồn tại.");
				return;
			}
			else
			{
				hoTen = nhapHoTen("Nhập họ tên: ");
				soDu = nhapSoTien("Nhập số dư trong tài khoản: ");
				acc = new Account(soTaiKhoan, hoTen, soDu);
				accountList.them(acc);
			}
		}
		System.out.println("Thêm các tài khoản thành công.");
	}

	//---------------------------sửa tài khoản-------------------------------
	public static void suaTK() throws Exception
	{
		long soTK = nhapSoTaiKhoan("Nhập số tài khoản cần sửa: ");
		Account acc = accountList.laySoTaiKhoan(soTK);
		Scanner sc = new Scanner(System.in);
		int chon, daSua = 0;
		if(acc != null)
		{
			System.out.println("\t\t\t***TÀI KHOẢN TRƯỚC KHI SỬA***\t\t\t");
			tieuDe2();
			System.out.println("***********************************************************");
			System.out.println(acc);
			System.out.println("***********************************************************");
			System.out.println();
			do
			{
				menuSua();
				System.out.println("Nhập lựa chọn của bạn: ");
				chon = sc.nextInt();
				daSua++;
				switch (chon) 
				{
				case 1: 
					String tenTK = nhapHoTen("Nhập tên tài khoản mới: ");
					acc.setTenTK(tenTK);
					break;
				case 2: 
					double soTien = nhapSoTien("Nhập số dư mới: ");
					acc.setSoTienTrongTK(soTien);
					break;
				case 3: 
					if(daSua >= 1)
						accountList.suaTK(acc);
					System.out.println("Đã sửa tài khoản thành công.");
					break;
				default:
					System.out.println("Lựa chọn của bạn không hợp lệ. Vui lòng nhập lại.");
					break;
				}
			}
			while(chon < 3);
		}
		else
			System.out.println("Không tìm thấy tài khoản cần sửa.");
	}

	//----------------------------xóa tài khoản-------------------------------
	public static void xoaTK() throws Exception
	{
		long soTK = nhapSoTaiKhoan("Nhập số tài khoản cần xóa: ");
		Account acc = accountList.laySoTaiKhoan(soTK);
		Scanner sc = new Scanner(System.in);
		if(acc != null)
		{
			tieuDe2();
			System.out.println("***********************************************************");
			System.out.println(acc);
			System.out.println("***********************************************************");
			System.out.println();
			System.out.println("Bạn có chắc muốn xoá tài khoản này không?(Y/N): ");
			String xacNhan = sc.nextLine();
			if(xacNhan.equalsIgnoreCase("Y"))
			{
				accountList.xoaTK(soTK);
				System.out.println("Xóa tài khoản này thành công.");
			}
			else
				System.out.println("Bạn đã giữ lại tài khoản này.");
		}
		else
			System.out.println("Không tìm thấy tài khoản cần xóa.");
	}

	//-------------------------tìm kiếm tài khoản----------------------------
	public static void timTK()
	{
		long soTK = nhapSoTaiKhoan("Nhập số tài khoản cần tìm: ");
		Account acc = accountList.laySoTaiKhoan(soTK);
		if(acc != null)
		{
			tieuDe2();
			System.out.println("***********************************************************");
			System.out.println(acc);
			System.out.println("***********************************************************");
			System.out.println();
		}
		else
			System.out.println("Không tìm thấy tài khoản này.");
	}

	//---------------------hiển thị danh sách tài khoản-----------------------
	public static void displayAccountList() {
		Account[] allAccount = accountList.getAllAccounts();
		for(int i = 0; i < accountList.getSoLuongHT(); i++) {
			DecimalFormat df1 = new DecimalFormat("#");
			String strSTT = df1.format(i + 1);
			System.out.printf("|%-5s", strSTT);
			System.out.println(allAccount[i]);
		}
	}

	//------------------------nạp tiền vào tài khoản----------------------------
	public static void napTien() throws Exception
	{
		double soTienNap;
		long soTK = nhapSoTaiKhoan("Nhập số tài khoản cần nạp: ");
		Account acc = accountList.laySoTaiKhoan(soTK);
		if(acc != null)
		{
			soTienNap = nhapSoTien("Nhập số tiền cần nạp: ");
			acc.napTien(soTienNap);
			System.out.println("Nạp tiền thành công.\n");
		}
		else
			System.out.println("Không tìm thấy tài khoản.\n");
	}

	//---------------------------------rút tiền-----------------------------------
	public static void rutTien() throws Exception
	{
		double soTienRut, phi;
		long soTK = nhapSoTaiKhoan("Nhập số tài khoản cần rút: ");
		Account acc = accountList.laySoTaiKhoan(soTK);
		if(acc != null)
		{
			soTienRut = nhapSoTien("Nhập số tiền cần rút: ");
			phi = nhapSoTien("Nhập phí rút tiền: ");
			acc.rutTien(soTienRut, phi);
			System.out.println("Rút tiền thành công.\n");
		}
		else
			System.out.println("Không tìm thấy tài khoản.\n");
	}

	//-----------------------------------đáo hạn-----------------------------------
	public static void daoHan() throws Exception
	{
		long soTK = nhapSoTaiKhoan("Nhập số tài khoản muốn đáo hạn: ");
		Account acc = accountList.laySoTaiKhoan(soTK);
		if(acc != null)
		{
			acc.daoHan(soTK);
			System.out.println("Đáo hạn thành công.\n");
		}
		else
			System.out.println("Không tìm thấy tài khoản.\n");
	}

	//--------------------------------chuyển khoản----------------------------------
	public static void chuyenKhoan() throws Exception
	{
		double soTienCK;
		long soTK1 = nhapSoTaiKhoan("Nhập số tài khoản người gửi: ");
		long soTK2 = nhapSoTaiKhoan("Nhập số tài khoản người nhận: ");
		Account nguoiGui = accountList.laySoTaiKhoan(soTK1);
		Account nguoiNhan = accountList.laySoTaiKhoan(soTK2);
		if(nguoiGui != null && nguoiNhan != null)
		{
			soTienCK = nhapSoTien("Nhập số tiền chuyển khoản: ");
			nguoiGui.chuyenKhoang(nguoiNhan, soTienCK);
			System.out.println("Chuyển tiền thành công.\n");
		}
		else
			System.out.println("Không tìm thấy tài khoản.\n");
	}

	//--------------------------------menu chính----------------------------------
	public static void menu()
	{
		System.out.println("\t\t***QUẢN LÝ TÀI KHOẢN NGÂN HÀNG***\t\t");
		System.out.println("*****************************************************************");
		System.out.println("\t1. In cứng danh sách tài khoản.");
		System.out.println("\t2. Xuất danh sách tài khoản.");
		System.out.println("\t3. Thêm tài khoản.");
		System.out.println("\t4. Sửa tài khoản.");
		System.out.println("\t5. Xóa tài khoản.");
		System.out.println("\t6. Tìm kiếm tài khoản.");
		System.out.println("\t7. Sắp xếp tài khoản theo số tài khoản.");
		System.out.println("\t8. Nạp tiền vào tài khoản.");
		System.out.println("\t9. Rút tiền.");
		System.out.println("\t10. Đáo hạn.");
		System.out.println("\t11. Chuyển khoản.");
		System.out.println("\t12. Tổng số tiền tong tài khoản của tất cả tài khoản.");
		System.out.println("\t13. Thoát.");
		System.out.println("*****************************************************************");
	}

	//---------------------------------menu sửa-----------------------------------
	public static void menuSua()
	{
		System.out.println("\t\t\t***MENU SỬA ACCOUNT***\t\t\t");
		System.out.println("*****************************************************************");
		System.out.println("\t1. Tên tài khoản.");
		System.out.println("\t2. Số dư tài khoản.");
		System.out.println("\t3. Trở về menu chính.");
		System.out.println("*****************************************************************");
	}
	//-----------------------------------main-------------------------------------
	public static void main(String[] args) throws Exception
	{
		accountList = new DSAccount();
		int chon;
		Account acc;
		do
		{
			menu();
			System.out.println("Nhập lựa chọn của bạn: ");
			Scanner sc = new Scanner(System.in);
			chon = sc.nextInt();
			switch(chon)
			{
			case 1: 
				nhapCung();
				System.out.println("Đã nhập danh sách thành công.");
				System.out.println();
				break;
			case 2:
				System.out.println("\t\t***QUẢN LÝ TÀI KHOẢN NGÂN HÀNG***\t\t");
				tieuDe();
				System.out.println("*****************************************************************");
				displayAccountList();
				System.out.println("*****************************************************************");
				System.out.println();
				break;
			case 3:
				themTK();
				System.out.println();
				break;
			case 4:
				suaTK();
				System.out.println();
				break;
			case 5:
				xoaTK();
				System.out.println();
				break;
			case 6:
				timTK();
				System.out.println();
				break;
			case 7:
				accountList.sapXepTheoSTK();
				System.out.println("Đã sắp xếp tài khoản theo số tài khoản thành công.");
				System.out.println();
				break;
			case 8: 
				System.out.println("\t\t***QUẢN LÝ TÀI KHOẢN NGÂN HÀNG***\t\t");
				tieuDe();
				System.out.println("*****************************************************************");
				displayAccountList();
				System.out.println("*****************************************************************");
				napTien();
				System.out.println();
				break;
			case 9: 
				System.out.println("\t\t***QUẢN LÝ TÀI KHOẢN NGÂN HÀNG***\t\t");
				tieuDe();
				System.out.println("*****************************************************************");
				displayAccountList();
				System.out.println("*****************************************************************");
				rutTien();
				System.out.println();
				break;
			case 10: 
				System.out.println("\t\t***QUẢN LÝ TÀI KHOẢN NGÂN HÀNG***\t\t");
				tieuDe();
				System.out.println("*****************************************************************");
				displayAccountList();
				System.out.println("*****************************************************************");
				daoHan();
				System.out.println();
				break;
			case 11: 
				System.out.println("\t\t***QUẢN LÝ TÀI KHOẢN NGÂN HÀNG***\t\t");
				tieuDe();
				System.out.println("*****************************************************************");
				displayAccountList();
				System.out.println("*****************************************************************");
				chuyenKhoan();
				System.out.println();
				break;
			case 12:
				DecimalFormat df = new DecimalFormat("#,##0.00VND");
				String strTongTien = df.format(accountList.tongSoTien());
				System.out.println("Tổng số tiền của tất cả các tài khoản là: " + strTongTien);
				System.out.println();
			case 13:
				System.out.println("Kết thúc chương trình.");
				System.out.println();
				break;
			default:
				System.out.println("Lựa chọn của bạn không hợp lệ. Xin vui lòng nhập lại: ");
				break;
			}
		}
		while(chon != 13);
	}
}
