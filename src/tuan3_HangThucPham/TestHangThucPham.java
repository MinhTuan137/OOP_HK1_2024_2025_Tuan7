package tuan3_HangThucPham;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TestHangThucPham {
	static DSHangThucPham ds;
	//-----------------------------Tiêu đề--------------------------------
	static void tieuDe() {
		System.out.printf("|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|\n", "Mã hàng", "Tên hàng", "Đơn giá", "Ngày sản xuất",
				"Ngày hết hạn", "Hạn sử dụng");
	}

	//-----------------------------Nhập dữ liệu----------------------------
	public static String nhapMaHang(String thongbao)
	{
		String maHang;
		do {
			System.out.println(thongbao);
			Scanner sc = new Scanner(System.in);
			maHang = sc.nextLine();
			if (maHang == null)
				System.out.println("Mã hàng hóa không được để trống.");
		} while (maHang == null);
		return maHang;
	}

	public static String nhapTenHang(String thongbao) {
		String tenHang;
		do {
			System.out.println(thongbao);
			Scanner sc = new Scanner(System.in);
			tenHang = sc.nextLine();
			if (tenHang == null)
				System.out.println("Tên hàng hóa không được để trống.");
		} while (tenHang == null);
		return tenHang;
	}

	public static int nhapDonGia(String thongbao) {
		int donGia;
		do {
			System.out.println(thongbao);
			Scanner sc = new Scanner(System.in);
			donGia = sc.nextInt();
			if (donGia < 0)
				System.out.println("Đơn giá phải lớn hơn 0.");
		} while (donGia < 0);
		return donGia;
	}

	public static String nhapNgay(String thongbao)
	{
		String ngay;
		System.out.println(thongbao);
		Scanner sc = new Scanner(System.in);
		ngay = sc.nextLine();
		return ngay;
	}

	//-----------------------------Nhập đối tượng--------------------------------
	public static HangThucPham nhapDoiTuong() throws ParseException {
		String maHang, tenHang;
		int donGia;
		String ngaySXString, ngayHHString;
		Date ngaySX, ngayHH;
		HangThucPham htp = null;
		maHang = nhapMaHang("Nhập mã hàng: ");
		while(ds.timViTri(maHang) != -1)
		{
			System.out.println("Trùng mã. Vui lòng nhập lại.");
			maHang = nhapMaHang("Nhập mã hàng: ");
		}
		tenHang = nhapTenHang("Nhập tên hàng: ");
		donGia = nhapDonGia("Nhập đơn giá: ");
		do 
		{
			ngaySXString = nhapNgay("Nhập ngày sản xuất: ");
			ngayHHString = nhapNgay("Nhập ngày hết hạn: ");
			ngaySX = new SimpleDateFormat("dd/MM/yyyy").parse(ngaySXString);
			ngayHH = new SimpleDateFormat("dd/MM/yyyy").parse(ngayHHString);
			if (ngaySX.after(ngayHH))
				System.out.println("Ngày sản xuất phải trước ngày hết hạn.");
		}
		while(ngaySX.after(ngayHH));	
		htp = new HangThucPham(maHang, tenHang, donGia, ngaySX, ngayHH);
		return htp;
	}


	//-------------------------------Them danh sach-------------------------------
	public static void themDanhSach() throws Exception {
		HangThucPham htp = nhapDoiTuong();
		if(ds.them(htp) == true)
			System.out.println("Thêm hàng thực phẩm thành công.");
		else
			System.out.println("Thêm hàng thực phẩm không thành công.");
		System.out.println();
	}

	//-----------------------------Nhập cứng danh sach-----------------------------
	public static void nhapCung() throws Exception
	{
		HangThucPham htp1, htp2, htp3, htp4;
		Date ngaySX1 = new Date(2023 - 1900, 8, 12);  
		Date ngayHH1 = new Date(2024 - 1900, 1, 11);
		Date ngaySX2 = new Date(2023 - 1900, 4, 20);
		Date ngayHH2 = new Date(2023 - 1900, 6, 11);
		Date ngaySX3 = new Date(2023 - 1900, 10, 8);  
		Date ngayHH3 = new Date(2024 - 1900, 3, 8);
		Date ngaySX4 = new Date(2023 - 1900, 5, 22);
		Date ngayHH4 = new Date(2023 - 1900, 10, 22);
		htp1 = new HangThucPham("1298", "Bánh kem", 150000, ngaySX1, ngayHH1);
		htp2 = new HangThucPham("1026", "Bánh quy", 200000, ngaySX2, ngayHH2);
		htp3 = new HangThucPham("1050", "Kẹo", 60000, ngaySX3, ngayHH3);
		htp4 = new HangThucPham("1521", "Kem", 35000, ngaySX4, ngayHH4);
		ds.them(htp1);
		ds.them(htp2);
		ds.them(htp3);
		ds.them(htp4);
		System.out.println("Thêm danh sách thành công.");
	}

	//-----------------------------Sửa hàng thực phẩm-----------------------------
	public static void suaHTP() throws Exception
	{
		String maHang = nhapMaHang("Nhập mã hàng cần sửa: ");
		HangThucPham htp = ds.timHTP(maHang);
		int daSua = 0, chon;
		if(htp != null)
		{
			System.out.println("\t\t\t***HÀNG THỰC PHẨM TRƯỚC KHI SỬA***\t\t\t");
			tieuDe();
			System.out.println("*************************************************************************************************");
			System.out.println(htp);
			System.out.println("*************************************************************************************************");
			System.out.println();
			do
			{
				menuSua();
				System.out.println("Nhập lựa chọn của bạn: ");
				Scanner sc = new Scanner(System.in);
				chon = sc.nextInt();
				daSua ++;
				switch(chon) 
				{
				case 1: 
					String tenHTP = nhapTenHang("Nhập tên hàng thực phẩm: ");
					htp.setTenHang(tenHTP);
					break;
				case 2: 
					int donGia = nhapDonGia("Nhập đơn giá của hàng thực phẩm: ");
					htp.setDonGia(donGia);
					break;
				case 3: 
					String ngaySXString = nhapNgay("Nhập ngày sản xuất: ");
					Date ngaySX = new SimpleDateFormat("dd/MM/yyyy").parse(ngaySXString);
					htp.setNgaySX(ngaySX);
					break;
				case 4: 
					String ngayHHString = nhapNgay("Nhập ngày hết hạn: ");
					Date ngayHH = new SimpleDateFormat("dd/MM/yyyy").parse(ngayHHString);
					htp.setNgayHH(ngayHH);
					break;
				case 5: 
					if(daSua >= 1)
						ds.suaHTP(htp);
					System.out.println("Đã sửa hàng thực phẩm thành công.");
					break;
				}
			}
			while(chon < 5);
		}
		else
			System.out.println("Không tìm thấy hàng thực phẩm cần sửa.");
	}

	//-----------------------------Xóa hàng thực phẩm-----------------------------
	public static void xoaHTP() throws Exception
	{
		String maHang = nhapMaHang("Nhập mã hàng thực phẩm cần xóa: ");
		HangThucPham htp = ds.timHTP(maHang);
		if(htp != null)
		{
			tieuDe();
			System.out.println("*************************************************************************************************");
			System.out.println(htp);
			System.out.println("*************************************************************************************************");
			System.out.println();
			System.out.println("Bạn có chắc muốn xoá hàng thực phẩm này không?(Y/N): ");
			Scanner sc = new Scanner(System.in);
			String xacNhan = sc.nextLine();
			if(xacNhan.equalsIgnoreCase("Y"))
			{
				ds.xoaHTP(maHang);
				System.out.println("Xóa hàng thực phẩm này thành công.");
			}
			else
				System.out.println("Bạn đã giữ lại hàng thực phẩm này.");
		}
		else
			System.out.println("Không tìm thấy hàng thực phẩm cần xóa.");
	}

	//---------------------------------Xuất danh sach--------------------------------
	public static void xuatDanhSach() {
		HangThucPham[] dsXuat = ds.layDS();
		System.out.println("\t\t\t***DANH SÁCH HÀNG THỰC PHẨM***\t\t\t");
		tieuDe();
		System.out.println("*************************************************************************************************");
		for(int i = 0; i < ds.soLuongHT; i++)
		{
			System.out.println(dsXuat[i]);
		}
		System.out.println("*************************************************************************************************");
	}

	//---------------------------------Tìm kiếm-------------------------------------
	public static void timKiem() throws Exception {
		System.out.println("Nhập mã hàng cần tìm: ");
		Scanner sc = new Scanner(System.in);
		String maHang = sc.nextLine();
		HangThucPham htp = ds.timHTP(maHang);
		if(htp != null)
		{
			tieuDe();
			System.out.println("*************************************************************************************************");
			System.out.println(htp);
			System.out.println("*************************************************************************************************");
			System.out.println();
		}
		else
			System.out.println("Không tìm thấy hàng thực phẩm cần tìm.");
	}


	//-----------------------------------Menu chính-----------------------------------------
	public static void menu() {
		System.out.println("\t\t\t***QUẢN LÝ HÀNG THỰC PHẨM***\t\t\t");
		System.out.println("*************************************************************************************************");
		System.out.println("\t1. Nhập danh sách hàng thực phẩm.");
		System.out.println("\t2. Xuất danh sách.");
		System.out.println("\t3. Thêm mặt hàng.");
		System.out.println("\t4. Sửa mặt hàng.");
		System.out.println("\t5. Xóa mặt hàng.");
		System.out.println("\t6. Tìm kiếm mặt hàng.");
		System.out.println("\t7. Sắp xếp các mặt hàng theo mã hàng.");
		System.out.println("\t8. Số lượng hàng thực phẩm.");
		System.out.println("\t9. Tổng giá thành.");
		System.out.println("\t10. Thoát.");
		System.out.println("*************************************************************************************************");
	}

	//-----------------------------------Menu sửa-----------------------------------------
	public static void menuSua() {
		System.out.println("\t\t\t***MENU SỬA  HÀNG THỰC PHẨM***\t\t\t");
		System.out.println("*************************************************************************************************");
		System.out.println("\t1. Tên mặt hàng.");
		System.out.println("\t2. Đơn giá.");
		System.out.println("\t3. Ngày sản xuất.");
		System.out.println("\t4. Ngày hết hạn.");
		System.out.println("\t5. Trở về menu chính.");
		System.out.println("*************************************************************************************************");
	}

	//--------------------------------------Main---------------------------------------
	public static void main(String[] args) throws Exception {
		int chon;
		Scanner sc = new Scanner(System.in);
		ds = new DSHangThucPham();
		do {
			menu();
			System.out.println("Nhập lựa chọn của bạn: ");
			chon = sc.nextInt();
			switch (chon) 
			{
			case 1:
				nhapCung();
				System.out.println();
				break;
			case 2:
				xuatDanhSach();
				System.out.println();
				break;
			case 3:
				themDanhSach();
				System.out.println();
				break;
			case 4:
				suaHTP();
				System.out.println();
				break;
			case 5:
				xoaHTP();
				System.out.println();
				break;
			case 6:
				timKiem();
				System.out.println();
				break;
			case 7:
				ds.sapXepTheoMaHTP();
				System.out.println("Đã sắp xếp danh sách theo mã hàng thành công");
				System.out.println();
				break;
			case 8:
				System.out.println("Số lượng hàng thực phẩm là: " + ds.tinhSoLuongHang());
				System.out.println();
				break;
			case 9:
				DecimalFormat df = new DecimalFormat("#,##0.00VND");
				String tongThanhTienString = df.format(ds.tongGiaThanh());
				System.out.println("Tổng giá thành: " + tongThanhTienString);
				System.out.println();
				break;
			case 10:
				System.out.println("Kết thúc chương trình.");
				System.out.println();
				break;
			default:
				System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
				break;
			}
		} while (chon != 10);
	}
}
