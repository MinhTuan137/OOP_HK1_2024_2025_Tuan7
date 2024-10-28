package tuan3_CD;

import java.text.DecimalFormat;
import java.util.Scanner;

public class TestCD {
	public static DSCD ds;

	//-----------------------------Tiêu đề--------------------------------
	static void tieuDe()
	{
		System.out.printf("|%-15s|%-20s|%-20s|%-15s|%-18s|", "Mã CD", "Tựa CD", "Ca sĩ", "Số bài hát", "Giá thành");
	}

	//-----------------------------Nhập dữ liệu----------------------------
	public static int nhapMaCD(String thongbao)
	{
		int maCD;
		System.out.println(thongbao);
		Scanner sc = new Scanner(System.in);
		maCD = sc.nextInt();
		return maCD;
	}

	public static String nhapTuaCD(String thongbao) {
		String tuaCD;
		System.out.println(thongbao);
		Scanner sc = new Scanner(System.in);
		tuaCD = sc.nextLine();
		return tuaCD;
	}

	public static String nhapCaSi(String thongbao) {
		String caSi;
		System.out.println(thongbao);
		Scanner sc = new Scanner(System.in);
		caSi = sc.nextLine();
		return caSi;
	}

	public static int nhapSoBaiHat(String thongbao) {
		int soBaiHat;
		do {
			System.out.println(thongbao);
			Scanner sc = new Scanner(System.in);
			soBaiHat = sc.nextInt();
			if (soBaiHat < 0)
				System.out.println("Số bài hát phải lớn hơn 0.");
		} while (soBaiHat < 0);
		return soBaiHat;
	}

	public static float nhapGiaThanh(String thongbao) {
		float giaThanh;
		do {
			System.out.println(thongbao);
			Scanner sc = new Scanner(System.in);
			giaThanh = sc.nextFloat();
			if (giaThanh < 0)
				System.out.println("Giá thành phải lớn hơn 0.");
		} while (giaThanh < 0);
		return giaThanh;
	}

	//-----------------------------Nhập đối tượng----------------------------
	public static CD nhapDoiTuong() throws Exception
	{
		CD cd = null;
		try
		{
			int maCD = nhapMaCD("Nhập mã CD: ");
			int vt = ds.timKiem(maCD);
			if(vt != -1)
			{
				System.out.println("Trùng mã");
				return null;
			}
			else
			{
				String tuaCD = nhapTuaCD("Nhập tựa CD: ");
				String caSi = nhapCaSi("Nhập ca sĩ: ");
				int soBaiHat = nhapSoBaiHat("Nhập số bài hát: ");
				float giaThanh = nhapGiaThanh("Nhập giá thành: ");
				cd = new CD(maCD, tuaCD, caSi, soBaiHat, giaThanh);
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return cd;
	}

	//-----------------------------Tạo mảng--------------------------------
	public static void nhapCungCD() throws Exception {
		CD cd1 = new CD(1012, "Cô Ấy", "Sing", 10, 1500000);
		CD cd2 = new CD(1107, "Vượt Vũ Môn", "Mai Xuân Thứ", 15, 2000000);
		CD cd3 = new CD(1006, "Em Của Ngày Hôm Qua", "Sơn Tùng", 12, 1000000);
		CD cd4 = new CD(1078, "Năm Ấy", "Đức Phúc", 8, 1700000);
		ds.them(cd1);
		ds.them(cd2);
		ds.them(cd3);
		ds.them(cd4);
		System.out.println("Nhập danh sách CD thành công.");
	}

	//-----------------------------Thêm CD--------------------------------
	public static void themCD() throws Exception {
		CD cd = nhapDoiTuong();
		if(ds.them(cd) == true)
			System.out.println("Thêm CD thành công.");
		else
			System.out.println("Thêm CD không thành công.");
	}

	//-----------------------------Sửa CD--------------------------------
	public static void suaCD() throws Exception
	{
		int maCD = nhapMaCD("Nhập mã CD cần sửa: ");
		CD cdSua = ds.timCD(maCD);
		int daSua = 0, chon;
		if(cdSua != null)
		{
			System.out.println("\t\t\t***THÔNG TIN CD TRƯỚC KHI SỬA***\t\t\t");
			tieuDe();
			System.out.println("**********************************************************************************************");
			System.out.println(cdSua);
			System.out.println("**********************************************************************************************");
			System.out.println();
			do 
			{
				menuSua();
				Scanner sc = new Scanner(System.in);
				chon = sc.nextInt();
				daSua++;
				switch(chon) 
				{
				case 1: 
					String tuaCD = nhapTuaCD("Nhập tựa CD: ");
					cdSua.setTuaCD(tuaCD);
					break;
				case 2: 
					String caSi = nhapCaSi("Nhập ca sĩ: ");
					cdSua.setCaSi(caSi);
					break;
				case 3: 
					int soBaiHat = nhapSoBaiHat("Nhập số bài hát: ");
					cdSua.setSoBaiHat(soBaiHat);
					break;
				case 4: 
					float giaThanh = nhapGiaThanh("Nhập giá thành: ");
					cdSua.setGiaThanh(giaThanh);
					break;
				case 5: 
					if(daSua >= 1)
						ds.suaCD(cdSua);
					System.out.println("Đã sửa CD thành công.");
					break;
				}
			}
			while(chon < 5);
		}
		else
			System.out.println("Không tìm thấy CD cần sửa.");
	}

	//-----------------------------Xóa CD--------------------------------
	public static void xoaCD() throws Exception
	{
		int maCD = nhapMaCD("Nhập mã CD cần xóa: ");
		CD cdXoa = ds.timCD(maCD);
		if(cdXoa != null)
		{
			tieuDe();
			System.out.println("**********************************************************************************************");
			System.out.println(cdXoa);
			System.out.println("**********************************************************************************************");
			System.out.println();
			System.out.println("Bạn có chắc chắn muốn xóa CD này không [Y/N]: ");
			Scanner sc = new Scanner(System.in);
			String xacNhan = sc.nextLine();
			if(xacNhan.equalsIgnoreCase("Y"))
			{
				ds.xoaCD(maCD);
				System.out.println("Bạn đã xóa CD này thành công.");
			}
			else
			{
				System.out.println("Bạn đã giữ lại CD này.");
			}
		}
		else
		{
			System.out.println("Không tìm thấy CD này.");
		}
	}

	//--------------------------tìm kiếm CD-----------------------------
	public static void timKiemCD() throws Exception
	{
		int maCD = nhapMaCD("Nhập mã CD cần tìm: ");
		CD cd = ds.timCD(maCD);
		if(cd != null)
		{
			tieuDe();
			System.out.println("**********************************************************************************************");
			System.out.println(cd);
			System.out.println("**********************************************************************************************");
			System.out.println();
		}
		else
			System.out.println("Không tìm thấy CD cần tìm.");
	}

	//------------------------Tính số lượng--------------------------------
	public static void soLuongCD() {
		System.out.println("Số lượng CD: " + ds.tinhSoLuongCD());
		System.out.println();
	}

	//------------------------Tính tổng giá thành----------------------------
	public static void tongGiaThanh() {
		DecimalFormat df = new DecimalFormat("#,##0.00VND");
		String tongGiaThanhString = df.format(ds.tongGiaThanh());
		System.out.println("Tổng giá thành: " + tongGiaThanhString);
		System.out.println();
	}

	//------------------------Sắp xếp CD theo giá thành-----------------------
	public static void sapXepGiamGiaThanh() {
		System.out.println("\t\t\t***DANH SÁCH CD GIẢM DẦN THEO GIÁ THÀNH***\t\t\t ");
		ds.sapXepTheoGiaThanh();
		xuatMangCD();
		System.out.println();
	}

	//------------------------Sắp xếp CD theo tựa CD--------------------------
	public static void sapXepTangTuaCD() {
		System.out.println("\t\t\t***DANH SÁCH CD TĂNG DẦN THEO TỰA CD***\t\t\t ");
		ds.sapXepTangTuaCD();
		xuatMangCD();
		System.out.println();
	}

	//------------------------Xuất danh sách CD-------------------------------
	public static void xuatMangCD() {
		CD[] dsXuat = ds.layDS();
		tieuDe();
		System.out.println();
		System.out.println("**********************************************************************************************");
		for(int i = 0; i < ds.soLuongCD; i++)
			System.out.println(dsXuat[i]);
		System.out.println("**********************************************************************************************");
		System.out.println();
	}

	//-----------------------------Menu sửa CD--------------------------------
	public static void menuSua()
	{
		System.out.println("\t\t\t***MENU SỬA CD***\t\t\t");
		System.out.println("**********************************************************************************************");
		System.out.println("\t1. Tựa CD");
		System.out.println("\t2. Ca sĩ");
		System.out.println("\t3. Số bài hát");
		System.out.println("\t4. Giá thành");
		System.out.println("\t5. Trở về menu chính");
		System.out.println("**********************************************************************************************");
	}

	//-----------------------------Menu chính--------------------------------
	public static void menu()
	{
		System.out.println("\t\t\t***QUẢN LÝ DANH SÁCH CD***\t\t\t");
		System.out.println("**********************************************************************************************");
		System.out.println("\t1. Nhập danh sách CD");
		System.out.println("\t2. Thêm CD");
		System.out.println("\t3. Sửa CD");
		System.out.println("\t4. Xóa CD");
		System.out.println("\t5. Tìm CD");
		System.out.println("\t6. Xuất danh sách CD");
		System.out.println("\t7. Số lượng CD");
		System.out.println("\t8. Tổng giá thành");
		System.out.println("\t9. Sắp xếp giảm giá thành");
		System.out.println("\t10. Sắp xếp tăng tựa CD");
		System.out.println("\t11. Thoát");
		System.out.println("**********************************************************************************************");
	}

	//------------------------Main-------------------------------------------
	public static void main(String[] args) throws Exception {
		ds = new DSCD();
		int chon;
		Scanner sc = new Scanner(System.in);
		do {
			menu();
			System.out.println("Nhập lựa chọn của bạn: ");
			chon = sc.nextInt();
			switch (chon) {
			case 1:
				nhapCungCD();
				System.out.println("");
				break;
			case 2:
				themCD();
				break;
			case 3:
				suaCD();
				break;
			case 4:
				xoaCD();
				break;
			case 5:
				timKiemCD();
				break;
			case 6:
				xuatMangCD();
				break;
			case 7:
				soLuongCD();
				break;
			case 8:
				tongGiaThanh();
				break;
			case 9:
				sapXepGiamGiaThanh();
				break;
			case 10:
				sapXepTangTuaCD();
				break;
			case 11:
				System.out.println("Kết thúc chương trình.");
				break;
			default:
				System.out.println("Lựa chọn bạn nhập không hợp lệ. Vui lòng nhập lại.");
				break;
			}
		} while (chon != 11);
	}
}
